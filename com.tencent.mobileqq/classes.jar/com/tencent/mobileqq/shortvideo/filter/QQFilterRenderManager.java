package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.mobileqq.sveffects.libsveffects.BuildConfig;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"NewApi"})
public class QQFilterRenderManager
{
  public static final float FACE_DET_SCALE = 0.25F;
  private static final String TAG = "QQFilterRenderManager";
  private static final String sId_Prefix = "FRM_";
  private static final AtomicInteger sInstanceCount = new AtomicInteger(0);
  private AIAttr aiAttr;
  public CameraInterFace cameraInterFace;
  private boolean enableGauss;
  private boolean isAEDetectorInited;
  public boolean mBackCameraDetectEnable;
  private long mBeginTime;
  private FilterBusinessOperation mBusinessOpt;
  public boolean mDetectedFace;
  public boolean mDetectedGesture;
  private long mEndTime;
  private PTFaceAttr mFaceAttr;
  private int mFaceDetectBuffer;
  int mFaceDetectHeight;
  int mFaceDetectWidth;
  private QQFilterRenderManager.FaceDetectParam mFaceParam;
  int mFilterHeight;
  int mFilterWidth;
  private boolean mHasGestureInit;
  private String mId = "";
  private final FilterManagerInternal mInternal;
  public GestureKeyInfo mLastGestureDetector;
  public boolean mNeedDoFaceDetect;
  public boolean mNeedDoGestureDetect;
  public boolean mNeedDoYTGestureDetect;
  private final Map<String, String> mParamMap;
  private StarParam mStarParam;
  private int mSufaceHeight;
  private int mSufaceWidth;
  private boolean mSurfaceDestroyed;
  private double mUIAspectRatio;
  
  public QQFilterRenderManager()
  {
    this.isAEDetectorInited = false;
    this.mInternal = new FilterManagerInternal();
    this.enableGauss = true;
    this.mFaceDetectWidth = 0;
    this.mFaceDetectHeight = 0;
    this.mFaceDetectBuffer = 0;
    this.mDetectedFace = false;
    this.mNeedDoFaceDetect = false;
    this.mNeedDoYTGestureDetect = false;
    this.mBackCameraDetectEnable = false;
    this.mFaceParam = new QQFilterRenderManager.FaceDetectParam(null);
    this.mBeginTime = 0L;
    this.mEndTime = 0L;
    this.mNeedDoGestureDetect = false;
    this.mDetectedGesture = false;
    this.mHasGestureInit = false;
    this.mLastGestureDetector = null;
    this.mParamMap = new ConcurrentHashMap();
    this.mSurfaceDestroyed = false;
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
    int i = 0;
    this.isAEDetectorInited = false;
    this.mInternal = new FilterManagerInternal();
    this.enableGauss = true;
    this.mFaceDetectWidth = 0;
    this.mFaceDetectHeight = 0;
    this.mFaceDetectBuffer = 0;
    this.mDetectedFace = false;
    this.mNeedDoFaceDetect = false;
    this.mNeedDoYTGestureDetect = false;
    this.mBackCameraDetectEnable = false;
    this.mFaceParam = new QQFilterRenderManager.FaceDetectParam(null);
    this.mBeginTime = 0L;
    this.mEndTime = 0L;
    this.mNeedDoGestureDetect = false;
    this.mDetectedGesture = false;
    this.mHasGestureInit = false;
    this.mLastGestureDetector = null;
    this.mParamMap = new ConcurrentHashMap();
    this.mSurfaceDestroyed = false;
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
        return;
      }
      this.mInternal.push(paramArrayOfInt, paramArrayOfObject);
    }
  }
  
  private void clear()
  {
    destroyGestureDetector();
    this.mParamMap.clear();
  }
  
  private void destroyGestureDetector()
  {
    this.mHasGestureInit = false;
    this.mNeedDoGestureDetect = false;
    this.mDetectedGesture = false;
    GestureMgrRecognize.getInstance().stop();
  }
  
  private void doAIDetect(Frame paramFrame) {}
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRM_");
    localStringBuilder.append(sInstanceCount.getAndIncrement());
    this.mId = localStringBuilder.toString();
  }
  
  public void cameraChange(int paramInt)
  {
    QQFilterLogManager.setLogStart("cameraChange");
    this.mInternal.changeCamera(paramInt);
    QQFilterLogManager.setLogEnd("cameraChange");
  }
  
  public void destroyAEDetecor()
  {
    this.isAEDetectorInited = false;
    this.mDetectedFace = false;
    this.mNeedDoFaceDetect = false;
    this.aiAttr = null;
    this.mFaceAttr = null;
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
    CameraInterFace localCameraInterFace = this.cameraInterFace;
    if (localCameraInterFace == null) {
      return -1;
    }
    return localCameraInterFace.getCameraID();
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
    if (SLog.isEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FilterProcessRender_showPreview[doFaceDetectInitAndFlip ");
      localStringBuilder.append((this.mEndTime - this.mBeginTime) / 1000L);
      localStringBuilder.append("us]");
      SLog.d("QQFilterRenderManager", localStringBuilder.toString());
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
    int i = this.mFaceDetectWidth;
    if (i != 0)
    {
      int j = this.mFilterWidth;
      if (j != 0)
      {
        float f = i * 1.0F / j;
        this.mFaceDetectHeight = ((int)(this.mFilterHeight * f));
        return f;
      }
    }
    return 0.25D;
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
      this.aiAttr = null;
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
    int i = 200;
    int m = 5;
    String str = SdkContext.getInstance().getResources().getGestureResource().getGestureGapTime();
    Object localObject = SdkContext.getInstance().getResources().getGestureResource().getGestureGapFrame();
    try
    {
      j = Integer.parseInt(str);
      i = j;
      k = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int j;
      int k;
      label73:
      break label73;
    }
    j = i;
    k = m;
    if (SLog.isEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GestureMgr.getInstance().setRecognizeMillis number exception");
      ((StringBuilder)localObject).append(i);
      SLog.d("GestureTestUse", ((StringBuilder)localObject).toString());
      k = m;
      j = i;
    }
    if (SLog.isEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PtvTemplateManager.mGestureGapTime raw value ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":GestureMgr.getInstance().setRecognizeMillis normal result");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(",frameRate is:");
      ((StringBuilder)localObject).append(k);
      SLog.d("GestureTestUse", ((StringBuilder)localObject).toString());
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
    FilterManagerInternal localFilterManagerInternal = this.mInternal;
    if (localFilterManagerInternal != null) {
      localFilterManagerInternal.setCaptureMode(paramBoolean);
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
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.mInternal.setNeedFaceDetectFlip(paramBoolean);
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
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.mUIAspectRatio = (d1 / d2);
    paramInt1 = this.mFaceDetectWidth;
    if (paramInt1 != 0)
    {
      paramInt2 = this.mFaceDetectHeight;
      if ((paramInt2 != 0) && (this.mFaceDetectBuffer != 0) && (paramInt1 >= 90) && (paramInt2 >= 120)) {}
    }
    else
    {
      this.mFaceDetectWidth = ((int)(this.mFilterWidth * 0.25F));
      this.mFaceDetectHeight = ((int)(this.mFilterHeight * 0.25F));
      this.mFaceDetectBuffer = (this.mFaceDetectWidth * this.mFaceDetectHeight * 4);
    }
    if (SLog.isEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePreviewSize:: mSufaceWidth=");
      localStringBuilder.append(this.mSufaceWidth);
      localStringBuilder.append(";mSufaceHeight=");
      localStringBuilder.append(this.mSufaceHeight);
      localStringBuilder.append(";mFilterWidth=");
      localStringBuilder.append(this.mFilterWidth);
      localStringBuilder.append(";mFilterHeight=");
      localStringBuilder.append(this.mFilterHeight);
      localStringBuilder.append(";mFaceDetectWidth");
      localStringBuilder.append(this.mFaceDetectWidth);
      localStringBuilder.append(";mFaceDetectHeight=");
      localStringBuilder.append(this.mFaceDetectHeight);
      localStringBuilder.append("; mUIRatio:");
      localStringBuilder.append(this.mUIAspectRatio);
      SLog.d("QQFilterRenderManager", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager
 * JD-Core Version:    0.7.0.1
 */