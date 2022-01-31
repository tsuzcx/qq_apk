package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask.FaceDetectTaskResult;
import com.tencent.mobileqq.shortvideo.facedancegame.IFaceDetectCallBack;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.mobileqq.sveffects.libsveffects.BuildConfig;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.FACE_DETECT_MODE;
import com.tencent.ttpic.openapi.filter.VideoFilterListExtension;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"NewApi"})
public class QQFilterRenderManager
{
  public static final float FACE_DET_SCALE = 0.25F;
  private static final String TAG = "QQFilterRenderManager";
  private static final QQFilterCreator mDynamicCreator = new QQFilterCreator();
  private static final String sId_Prefix = "FRM_";
  private static final AtomicInteger sInstanceCount = new AtomicInteger(0);
  private AEDetector aeDetector;
  private AIAttr aiAttr;
  public CameraInterFace cameraInterFace;
  private boolean enableGauss = true;
  private FaceDetector.FACE_DETECT_MODE faceDetectMode = FaceDetector.FACE_DETECT_MODE.MULTIPLE;
  private boolean isAEDetectorInited = false;
  public boolean mBackCameraDetectEnable = false;
  private long mBeginTime = 0L;
  private FilterBusinessOperation mBusinessOpt;
  public boolean mDetectedFace = false;
  public boolean mDetectedGesture = false;
  private long mEndTime = 0L;
  private PTFaceAttr mFaceAttr;
  private int mFaceDetectBuffer = 0;
  int mFaceDetectHeight = 0;
  int mFaceDetectWidth = 0;
  PTFaceDetector mFaceDetector = null;
  private QQFilterRenderManager.FaceDetectParam mFaceParam = new QQFilterRenderManager.FaceDetectParam(null);
  int mFilterHeight;
  int mFilterWidth;
  private boolean mHasGestureInit = false;
  private String mId = "";
  private final FilterManagerInternal mInternal = new FilterManagerInternal();
  public GestureKeyInfo mLastGestureDetector = null;
  public boolean mNeedDoFaceDetect = false;
  public boolean mNeedDoGestureDetect = false;
  public boolean mNeedDoYTGestureDetect = false;
  private final Map<String, String> mParamMap = new ConcurrentHashMap();
  private PTSegAttr mSegAttr;
  private StarParam mStarParam;
  private int mSufaceHeight;
  private int mSufaceWidth;
  private boolean mSurfaceDestroyed = false;
  private double mUIAspectRatio;
  private boolean needEmotionDetect = false;
  private boolean needFaceDetect = true;
  private boolean needGenderDetect = false;
  private boolean needHandDetect = false;
  private boolean needSegment = false;
  
  public QQFilterRenderManager()
  {
    myId();
    this.mInternal.setCommonParam(this);
    this.mBusinessOpt = new FilterBusinessOperation(this);
  }
  
  public QQFilterRenderManager(int[] paramArrayOfInt)
  {
    this(paramArrayOfInt, null, true);
  }
  
  public QQFilterRenderManager(int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    myId();
    this.mInternal.setCommonParam(this);
    this.mBusinessOpt = new FilterBusinessOperation(this);
    if (paramArrayOfInt != null)
    {
      if (paramBoolean)
      {
        QQFilterRenderManager.ChainBuilder localChainBuilder = getChainBuilder();
        localChainBuilder.setUseSort(true);
        while (i < paramArrayOfInt.length)
        {
          localChainBuilder.addFilter(paramArrayOfInt[i], localChainBuilder.getParam(paramArrayOfObject, i));
          i += 1;
        }
        localChainBuilder.commit();
      }
    }
    else {
      return;
    }
    this.mInternal.push(paramArrayOfInt, paramArrayOfObject);
  }
  
  private void clear()
  {
    destroyGestureDetector();
    this.mBusinessOpt.setPtvVideoFilter(null);
    this.mParamMap.clear();
  }
  
  private void destroyGestureDetector()
  {
    this.mHasGestureInit = false;
    this.mNeedDoGestureDetect = false;
    this.mDetectedGesture = false;
    GestureMgrRecognize.getInstance().stop();
  }
  
  private void doAIDetect(Frame paramFrame)
  {
    this.mBeginTime = SystemClock.elapsedRealtimeNanos();
    AIParam localAIParam = new AIParam();
    int i = VideoFilterUtil.get4DirectionAngle(this.aeDetector.getRotation());
    localAIParam.update(paramFrame.width, paramFrame.height, i);
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "phoneRoll", Float.valueOf(90.0F));
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "scale", Float.valueOf((float)getWindowScale()));
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "starParam", this.mStarParam);
    localAIParam.setModuleParam(AEDetectorType.HAND.value, "scale", Float.valueOf((float)getWindowScale()));
    localAIParam.setModuleParam(AEDetectorType.HAND.value, "scale", Float.valueOf((float)getWindowScale()));
    localAIParam.setModuleParam(AEDetectorType.EMOTION.value, "scale", Float.valueOf((float)getWindowScale()));
    localAIParam.setSurfaceTime(System.currentTimeMillis() * 1000000L);
    AICtrl localAICtrl = new AICtrl();
    localAICtrl.switchModule(AEDetectorType.FACE.value, true);
    localAICtrl.switchModule(AEDetectorType.EMOTION.value, this.needEmotionDetect);
    localAICtrl.switchModule(AEDetectorType.HAND.value, this.needHandDetect);
    localAICtrl.switchModule(AEDetectorType.SEGMENT.value, this.needSegment);
    this.aeDetector.getFaceDetector().setGenderDetectable(this.needGenderDetect);
    AIInput localAIInput = new AIInput();
    localAIInput.setInputTexture(paramFrame.getTextureId());
    this.aiAttr = this.aeDetector.detectFrame(localAIInput, localAIParam, localAICtrl);
    this.aiAttr.getOutTexture();
    this.mFaceAttr = ((PTFaceAttr)this.aiAttr.getFaceAttr());
    this.mDetectedFace = this.mFaceAttr.getTriggeredExpression().contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value));
    this.mEndTime = SystemClock.elapsedRealtimeNanos();
    long l = (this.mEndTime - this.mBeginTime) / 1000L;
    if (SLog.isEnable()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doTrackProceses=" + l + "us]");
    }
  }
  
  private void initial()
  {
    if (BuildConfig.DEBUG)
    {
      Application localApplication = SdkContext.getInstance().getApplication();
      if (localApplication != null)
      {
        LogUtils.setEnable(localApplication.getSharedPreferences("mobileQQ", 0).getBoolean("sv_error_log", false));
        return;
      }
      LogUtils.setEnable(false);
      return;
    }
    LogUtils.setEnable(false);
  }
  
  private void myId()
  {
    this.mId = ("FRM_" + sInstanceCount.getAndIncrement());
  }
  
  public void cameraChange(int paramInt)
  {
    QQFilterLogManager.setLogStart("cameraChange");
    this.mInternal.changeCamera(paramInt);
    QQFilterLogManager.setLogEnd("cameraChange");
  }
  
  public void destroyAEDetecor()
  {
    if (this.aeDetector != null)
    {
      this.aeDetector.clear();
      this.aeDetector = null;
    }
    this.isAEDetectorInited = false;
    this.mDetectedFace = false;
    this.mNeedDoFaceDetect = false;
    this.needEmotionDetect = false;
    this.needSegment = false;
    this.needHandDetect = false;
    this.aiAttr = null;
    this.mFaceAttr = null;
    this.mSegAttr = null;
  }
  
  public boolean detectedHeadNod()
  {
    return (this.mFaceDetector != null) && (this.mFaceAttr.getTriggeredExpression().contains(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_NOD.value)));
  }
  
  public boolean detectedOpenMouth()
  {
    return (this.mFaceDetector != null) && (this.mFaceAttr.getTriggeredExpression().contains(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value)));
  }
  
  public boolean detectedShakeHead()
  {
    return (this.mFaceDetector != null) && (this.mFaceAttr.getTriggeredExpression().contains(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE.value)));
  }
  
  public void doAEDetectWithCallBack(Frame paramFrame, int paramInt1, int paramInt2, IFaceDetectCallBack paramIFaceDetectCallBack)
  {
    long l = SystemClock.elapsedRealtimeNanos();
    AIParam localAIParam = new AIParam();
    localAIParam.update(paramFrame.width, paramFrame.height, 0);
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "phoneRoll", Integer.valueOf(90));
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "scale", Float.valueOf((float)getWindowScale()));
    localAIParam.setModuleParam(AEDetectorType.FACE.value, "starParam", this.mStarParam);
    AICtrl localAICtrl = new AICtrl();
    localAICtrl.switchModule(AEDetectorType.FACE.value, true);
    localAICtrl.switchModule(AEDetectorType.EMOTION.value, false);
    localAICtrl.switchModule(AEDetectorType.HAND.value, false);
    localAICtrl.switchModule(AEDetectorType.SEGMENT.value, false);
    AIInput localAIInput = new AIInput();
    localAIInput.setInputTexture(paramFrame.getTextureId());
    this.aiAttr = this.aeDetector.detectFrame(localAIInput, localAIParam, localAICtrl);
    this.aiAttr.getOutTexture();
    this.mFaceAttr = ((PTFaceAttr)this.aiAttr.getFaceAttr());
    FaceDanceDetectTask.logTimeInfo("doAEDetectWithCallBack", l, SystemClock.elapsedRealtimeNanos());
    if (paramIFaceDetectCallBack != null)
    {
      paramFrame = new FaceDanceDetectTask.FaceDetectTaskResult();
      if (this.mFaceAttr.getFaceCount() <= 0) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      paramFrame.vaild = bool;
      if (paramFrame.vaild)
      {
        paramFrame.pointFs = ((List)this.mFaceAttr.getAllFacePoints().get(0));
        paramFrame.angles = ((float[])this.mFaceAttr.getAllFaceAngles().get(0));
      }
      paramIFaceDetectCallBack.faceDetectEnd(paramFrame);
      return;
    }
  }
  
  public final int drawFrame(int paramInt)
  {
    QQFilterLogManager.setOnDrawFrameStart();
    paramInt = this.mInternal.runChain(paramInt);
    QQFilterLogManager.setOnDrawFrameEnd();
    return paramInt;
  }
  
  public AIAttr getAIAttr()
  {
    return this.aiAttr;
  }
  
  public List<QQBaseFilter> getAllActiveFilters()
  {
    ArrayList localArrayList = new ArrayList();
    this.mInternal.getAllActiveFilter(localArrayList);
    return localArrayList;
  }
  
  public boolean getBackCameraDetectEnable()
  {
    return this.mBackCameraDetectEnable;
  }
  
  public boolean getBooleanParam(String paramString)
  {
    paramString = (String)this.mParamMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Boolean.parseBoolean(paramString);
    }
    return false;
  }
  
  public FilterBusinessOperation getBusinessOperation()
  {
    return this.mBusinessOpt;
  }
  
  public int getCameraID()
  {
    if (this.cameraInterFace == null) {
      return -1;
    }
    return this.cameraInterFace.getCameraID();
  }
  
  public final QQFilterRenderManager.ChainBuilder getChainBuilder()
  {
    return new QQFilterRenderManager.ChainBuilder(this);
  }
  
  public final String getCurrentChainId()
  {
    return this.mInternal.getCurrentChainId();
  }
  
  public final boolean getCurrentChainInfo(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    return this.mInternal.getCurrentChainData(paramArrayList, paramArrayList1);
  }
  
  public PTFaceAttr getFaceAttr()
  {
    return this.mFaceAttr;
  }
  
  public byte[] getFaceDataAfterDoFaceDetect()
  {
    if (this.mNeedDoFaceDetect) {
      return this.mFaceParam.mFaceData;
    }
    return null;
  }
  
  public byte[] getFaceDetectDataByTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBeginTime = SystemClock.elapsedRealtimeNanos();
    int i = RetrieveDataManager.DATA_TYPE.RGBA.value;
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(i, paramInt1, paramInt2, paramInt3);
    this.mEndTime = SystemClock.elapsedRealtimeNanos();
    if (SLog.isEnable()) {
      SLog.d("QQFilterRenderManager", "FilterProcessRender_showPreview[doFaceDetectInitAndFlip " + (this.mEndTime - this.mBeginTime) / 1000L + "us]");
    }
    return arrayOfByte;
  }
  
  public boolean getFaceDetectFlags()
  {
    return this.mNeedDoFaceDetect;
  }
  
  public int getFaceDetectHeight()
  {
    return this.mFaceDetectHeight;
  }
  
  public int getFaceDetectWidth()
  {
    return this.mFaceDetectWidth;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    if ((this.aeDetector == null) || (this.aeDetector.getFaceDetector() == null)) {
      return null;
    }
    return this.aeDetector.getFaceDetector().getFaceDetector();
  }
  
  public String getFilterCacheInfo()
  {
    return this.mInternal.getCacheFilterInfo();
  }
  
  public int getFilterHeight()
  {
    return this.mFilterHeight;
  }
  
  public Object getFilterSpecificParam(int paramInt)
  {
    return this.mInternal.getFilterSpecificParam(paramInt);
  }
  
  public int getFilterWidth()
  {
    return this.mFilterWidth;
  }
  
  public float getFloatParam(String paramString)
  {
    paramString = (String)this.mParamMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Float.parseFloat(paramString);
    }
    return -1.0F;
  }
  
  public int getIntParam(String paramString)
  {
    paramString = (String)this.mParamMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return Integer.parseInt(paramString);
    }
    return -1;
  }
  
  public String getParam(String paramString)
  {
    return (String)this.mParamMap.get(paramString);
  }
  
  public QQBaseFilter getQQFilterByType(int paramInt)
  {
    return this.mInternal.currentChainGetFilter(paramInt);
  }
  
  public List<QQBaseFilter> getQQFilters(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    QQBaseFilter localQQBaseFilter = this.mInternal.currentChainGetFilter(paramInt);
    if (localQQBaseFilter != null) {
      localArrayList.add(localQQBaseFilter);
    }
    return localArrayList;
  }
  
  public String getStackTraceInfo()
  {
    return this.mInternal.generateStackTrace();
  }
  
  public int getSufaceWidth()
  {
    return this.mSufaceWidth;
  }
  
  public int getSurfaceHeight()
  {
    return this.mSufaceHeight;
  }
  
  public double getUIAspectRatio()
  {
    return this.mUIAspectRatio;
  }
  
  public double getWindowScale()
  {
    if ((this.mFaceDetectWidth == 0) || (this.mFilterWidth == 0)) {
      return 0.25D;
    }
    float f = this.mFaceDetectWidth * 1.0F / this.mFilterWidth;
    this.mFaceDetectHeight = ((int)(this.mFilterHeight * f));
    return f;
  }
  
  public boolean hasAEDetectorInited()
  {
    return this.isAEDetectorInited;
  }
  
  public boolean hasActiveFilter()
  {
    return this.mInternal.hasAllResourceActiveFilter();
  }
  
  public boolean hasQQFilter(int paramInt)
  {
    return this.mInternal.currentChinaHasFilter(paramInt);
  }
  
  public void initAEDetector_sync()
  {
    if (!this.isAEDetectorInited)
    {
      FeatureManager.loadBasicFeatures();
      if (!FeatureManager.isBasicFeaturesFunctionReady()) {
        return;
      }
      this.aeDetector = new AEDetector();
      int i = this.aeDetector.init();
      this.aiAttr = null;
      if (i != 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      this.isAEDetectorInited = bool;
      String str1 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
      String str2 = SdkContext.getInstance().getResources().getPtuFilterResource().getPortraitPathDir();
      if (this.needHandDetect) {
        AIManager.installDetector(AEHandDetector.class, str1, str1);
      }
      if (this.needSegment) {
        AIManager.installDetector(PTSegmenter.class, str2, str1);
      }
      if (!this.needEmotionDetect) {
        break;
      }
      AIManager.installDetector(PTEmotionDetector.class, str1, str1);
      return;
    }
  }
  
  public void initDetectFaceSDK(Frame paramFrame)
  {
    initAEDetector_sync();
    if ((this.mNeedDoFaceDetect) && (this.isAEDetectorInited)) {
      doAIDetect(paramFrame);
    }
  }
  
  public void initGestureDetectorSDK_Sync()
  {
    if (this.mHasGestureInit) {
      return;
    }
    this.mHasGestureInit = true;
    i = 200;
    m = 5;
    String str1 = SdkContext.getInstance().getResources().getGestureResource().getGestureGapTime();
    String str2 = SdkContext.getInstance().getResources().getGestureResource().getGestureGapFrame();
    try
    {
      j = Integer.parseInt(str1);
      i = j;
      k = Integer.parseInt(str2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int k = m;
        int j = i;
        if (SLog.isEnable())
        {
          SLog.d("GestureTestUse", "GestureMgr.getInstance().setRecognizeMillis number exception" + i);
          k = m;
          j = i;
        }
      }
    }
    if (SLog.isEnable()) {
      SLog.d("GestureTestUse", "PtvTemplateManager.mGestureGapTime raw value " + str1 + ":GestureMgr.getInstance().setRecognizeMillis normal result" + j + ",frameRate is:" + k);
    }
    GestureMgrRecognize.getInstance().setRecognizeMillis(j);
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(k);
  }
  
  public boolean isEnableGauss()
  {
    return this.enableGauss;
  }
  
  public boolean isFilterWork(int paramInt)
  {
    return this.mInternal.isFilterWork(paramInt);
  }
  
  public boolean isNeedEmotionDetect()
  {
    return this.needEmotionDetect;
  }
  
  public boolean isNeedFaceDetect()
  {
    return this.needFaceDetect;
  }
  
  public boolean isNeedHandDetect()
  {
    return this.needHandDetect;
  }
  
  public boolean isNeedSegment()
  {
    return this.needSegment;
  }
  
  public boolean isSurfaceDestroyed()
  {
    return this.mSurfaceDestroyed;
  }
  
  public boolean loadFilterSoSuccess()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public boolean needFaceDetect()
  {
    return this.mInternal.needFaceDetect();
  }
  
  public void onPause()
  {
    this.mInternal.onCurrentChainPause();
  }
  
  public void onResume()
  {
    this.mInternal.onCurrentChainResume();
  }
  
  public final void popAndRelease(String paramString)
  {
    this.mInternal.popAndRelease(paramString);
  }
  
  public final void popChain(String paramString)
  {
    this.mInternal.pop(paramString);
  }
  
  public final String pushChain(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    return this.mInternal.push(paramArrayList, paramArrayList1);
  }
  
  public final String pushChain(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    return this.mInternal.push(paramArrayOfInt, paramArrayOfObject);
  }
  
  public String pushChainBasedStackTopChain(int paramInt, Object paramObject)
  {
    return this.mInternal.insertNewFilterToOldChain_pushChain(paramInt, paramObject);
  }
  
  public void setBackCameraDetectEnable(boolean paramBoolean)
  {
    this.mBackCameraDetectEnable = paramBoolean;
  }
  
  public void setCaptureMode(boolean paramBoolean)
  {
    if (this.mInternal != null) {
      this.mInternal.setCaptureMode(paramBoolean);
    }
  }
  
  public void setEnableGauss(boolean paramBoolean)
  {
    this.enableGauss = paramBoolean;
  }
  
  public void setFaceDetectFlags(boolean paramBoolean)
  {
    this.mNeedDoFaceDetect = paramBoolean;
  }
  
  public final void setFilterSpecificParam(int paramInt, Object paramObject)
  {
    this.mInternal.setFilterSpecificParam(paramInt, paramObject);
  }
  
  public void setGestureDetectectFlags(boolean paramBoolean)
  {
    this.mNeedDoGestureDetect = paramBoolean;
    if (this.mNeedDoGestureDetect)
    {
      GestureMgrRecognize.getInstance().start();
      return;
    }
    GestureMgrRecognize.getInstance().stop();
  }
  
  public void setNeedEmotionDetect(boolean paramBoolean)
  {
    this.needEmotionDetect = paramBoolean;
  }
  
  public void setNeedFaceDetect(boolean paramBoolean)
  {
    this.needFaceDetect = paramBoolean;
  }
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.mInternal.setNeedFaceDetectFlip(paramBoolean);
  }
  
  public void setNeedGenderDetect(boolean paramBoolean)
  {
    this.needGenderDetect = paramBoolean;
  }
  
  public void setNeedHandDetect(boolean paramBoolean)
  {
    this.needHandDetect = paramBoolean;
  }
  
  public void setNeedSegment(boolean paramBoolean)
  {
    this.needSegment = paramBoolean;
  }
  
  public void setParam(String paramString1, String paramString2)
  {
    this.mParamMap.put(paramString1, paramString2);
  }
  
  public void setStarParam(StarParam paramStarParam)
  {
    this.mStarParam = paramStarParam;
  }
  
  public void setYTGestureDetectFlags(boolean paramBoolean)
  {
    this.mNeedDoYTGestureDetect = paramBoolean;
  }
  
  public final void surfaceChange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QQFilterLogManager.setLogStart("surfaceChange");
    updatePreviewSize(paramInt1, paramInt2, paramInt3, paramInt4);
    QQFilterLogManager.setLogEnd("surfaceChange");
  }
  
  public final void surfaceCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QQFilterLogManager.setLogStart("surfaceCreate");
    initial();
    updatePreviewSize(paramInt1, paramInt2, paramInt3, paramInt4);
    VideoFilterListExtension.setCreateExternalFiltersListener(mDynamicCreator);
    QQFilterLogManager.setLogEnd("surfaceCreate");
  }
  
  public final void surfaceDestroyed()
  {
    QQFilterLogManager.setLogStart("surfaceDestroyed");
    clear();
    this.mInternal.releaseAllResource();
    FrameBufferCache.getInstance().destroy();
    this.mSurfaceDestroyed = true;
    QQFilterLogManager.setLogEnd("surfaceDestroyed");
  }
  
  public void updatePreviewSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSufaceWidth = paramInt3;
    this.mSufaceHeight = paramInt4;
    this.mFilterWidth = paramInt1;
    this.mFilterHeight = paramInt2;
    this.mUIAspectRatio = (paramInt1 / paramInt2);
    if ((this.mFaceDetectWidth == 0) || (this.mFaceDetectHeight == 0) || (this.mFaceDetectBuffer == 0) || (this.mFaceDetectWidth < 90) || (this.mFaceDetectHeight < 120))
    {
      this.mFaceDetectWidth = ((int)(this.mFilterWidth * 0.25F));
      this.mFaceDetectHeight = ((int)(this.mFilterHeight * 0.25F));
      this.mFaceDetectBuffer = (this.mFaceDetectWidth * this.mFaceDetectHeight * 4);
    }
    if (SLog.isEnable()) {
      SLog.d("QQFilterRenderManager", "updatePreviewSize:: mSufaceWidth=" + this.mSufaceWidth + ";mSufaceHeight=" + this.mSufaceHeight + ";mFilterWidth=" + this.mFilterWidth + ";mFilterHeight=" + this.mFilterHeight + ";mFaceDetectWidth" + this.mFaceDetectWidth + ";mFaceDetectHeight=" + this.mFaceDetectHeight + "; mUIRatio:" + this.mUIAspectRatio);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager
 * JD-Core Version:    0.7.0.1
 */