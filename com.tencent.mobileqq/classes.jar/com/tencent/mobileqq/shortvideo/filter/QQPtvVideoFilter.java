package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.os.Build;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.api.standard.filter.AESticker.STICKER_TYPE;
import com.tencent.aekit.openrender.AEFilterBase;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.initializer.AnimojiInitializer;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.PhoneProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

@TargetApi(17)
public class QQPtvVideoFilter
  extends QQBaseFilter
{
  private static final String TAG = "QQPtvVideoFilter";
  public static int[] mVoiceRecognizerLoadResult = { -4 };
  public static String[] mVoiceRecognizerSo = { "WXVoice" };
  volatile List<AESticker> activeVideoFilterLists = new Vector();
  volatile GroupVideoFilterList groupVideoFilterList;
  boolean isActive = false;
  boolean isInit = false;
  boolean isSharpInit = false;
  private int[] mAnimojiLoadResult = { -4, -4, -4 };
  private String[] mAnimojiSo = { "XHumanActionSDK", "animojisdk", "gameplay" };
  private boolean mAnimojiSoInited = false;
  BaseFilter mCopyFilter = null;
  Frame mCopyFrame = new Frame();
  private boolean mFilamentSoInited = false;
  BaseFilter mFlipFilter = null;
  public Frame mFlipFrame = new Frame();
  private int[] mFlipTextureID = new int[2];
  private boolean mGameplaySoInited = false;
  private int[] mGestureLoadResult = { -4, -4 };
  private String[] mGestureSo = { "YTHandDetector", "GestureDetectJni" };
  private boolean mGestureSoInited = false;
  private boolean mSegmentInited = false;
  private QQSharpFaceFilter mSharpFaceFilter = new QQSharpFaceFilter();
  public Frame mTempFrame = new Frame();
  boolean mUseTemplate = false;
  private boolean mVoiceChangeSoInited = false;
  private boolean mVoiceRecognizerSoInited = false;
  private boolean needFaceDetect = false;
  private boolean needFlip = true;
  private boolean onlySharp = false;
  volatile AESticker singleVideoFilterList;
  
  public QQPtvVideoFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void changeFilterList(List<AESticker> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool = false;
    if (SLog.isEnable()) {
      SLog.w("QQPtvVideoFilter", "changeFilter videoFilters=" + paramList);
    }
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    this.mCopyFrame.clear();
    Object localObject1 = this.activeVideoFilterLists.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      AESticker localAESticker = (AESticker)((Iterator)localObject1).next();
      if (localAESticker != null) {
        try
        {
          localAESticker.clear();
        }
        catch (Throwable localThrowable2) {}
      }
    }
    this.activeVideoFilterLists.clear();
    this.onlySharp = false;
    if ((paramList == null) || (paramList.size() <= 1)) {
      if ((paramList == null) || (paramList.size() != 1)) {
        break label274;
      }
    }
    label274:
    Object localObject2;
    for (localObject1 = (AESticker)paramList.get(0);; localObject2 = null)
    {
      bool = updateSharpFaceFilter((AESticker)localObject1, paramInt1, paramInt2, paramDouble);
      if ((bool) && (this.singleVideoFilterList != null)) {
        this.activeVideoFilterLists.add(this.singleVideoFilterList);
      }
      if (bool) {
        break;
      }
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.activeVideoFilterLists.addAll(paramList);
      }
      paramList = this.activeVideoFilterLists.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (AESticker)paramList.next();
        if (localObject1 != null) {
          try
          {
            ((AESticker)localObject1).apply();
          }
          catch (Throwable localThrowable1) {}
        }
      }
    }
    updateVideoSize(paramInt1, paramInt2, paramDouble);
    updateNeedFaceDetect(bool);
  }
  
  private AESticker getFirstVideoFilterList()
  {
    if ((this.activeVideoFilterLists != null) && (!this.activeVideoFilterLists.isEmpty())) {
      return (AESticker)this.activeVideoFilterLists.get(0);
    }
    return null;
  }
  
  private boolean isNeedFaceDetect()
  {
    if (this.onlySharp)
    {
      if (getQQFilterRenderManager().getBackCameraDetectEnable()) {
        if (QQSharpFaceFilter.sSharpFaceLevel <= 0) {}
      }
      while ((getQQFilterRenderManager().getCameraID() == 1) && (QQSharpFaceFilter.sSharpFaceLevel > 0))
      {
        return true;
        return false;
      }
      return false;
    }
    return this.needFaceDetect;
  }
  
  private static boolean isSupportPortarit()
  {
    return (ApiHelper.hasJellyBeanMR1()) && (SdkContext.getInstance().getDpcSwitcher().isPortraitSwitchOpen());
  }
  
  private boolean needEmotionDetect()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (this.groupVideoFilterList != null)
    {
      bool1 = bool3;
      if (this.groupVideoFilterList.getRenderList() != null)
      {
        bool1 = bool3;
        if (!this.groupVideoFilterList.getRenderList().isEmpty())
        {
          Iterator localIterator = this.groupVideoFilterList.getRenderList().iterator();
          bool1 = bool2;
          while (localIterator.hasNext())
          {
            bool2 = ((AESticker)localIterator.next()).checkStickerType(AESticker.STICKER_TYPE.EMOTION_DETECT_STICKER);
            bool1 = bool2;
            if (bool2) {
              bool1 = bool2;
            }
          }
        }
      }
    }
    while (this.singleVideoFilterList == null) {
      return bool1;
    }
    return this.singleVideoFilterList.checkStickerType(AESticker.STICKER_TYPE.EMOTION_DETECT_STICKER);
  }
  
  private boolean needGenderDetect()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (this.groupVideoFilterList != null)
    {
      bool1 = bool3;
      if (this.groupVideoFilterList.getRenderList() != null)
      {
        bool1 = bool3;
        if (!this.groupVideoFilterList.getRenderList().isEmpty())
        {
          Iterator localIterator = this.groupVideoFilterList.getRenderList().iterator();
          bool1 = bool2;
          while (localIterator.hasNext())
          {
            bool2 = ((AESticker)localIterator.next()).needDetectGender();
            bool1 = bool2;
            if (bool2) {
              bool1 = bool2;
            }
          }
        }
      }
    }
    while (this.singleVideoFilterList == null) {
      return bool1;
    }
    return this.singleVideoFilterList.needDetectGender();
  }
  
  private boolean needHandDetect()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (this.groupVideoFilterList != null)
    {
      bool1 = bool3;
      if (this.groupVideoFilterList.getRenderList() != null)
      {
        bool1 = bool3;
        if (!this.groupVideoFilterList.getRenderList().isEmpty())
        {
          Iterator localIterator = this.groupVideoFilterList.getRenderList().iterator();
          bool1 = bool2;
          while (localIterator.hasNext())
          {
            bool2 = ((AESticker)localIterator.next()).checkStickerType(AESticker.STICKER_TYPE.GESTURE_STICKER);
            bool1 = bool2;
            if (bool2) {
              bool1 = true;
            }
          }
        }
      }
    }
    while (this.singleVideoFilterList == null) {
      return bool1;
    }
    return this.singleVideoFilterList.checkStickerType(AESticker.STICKER_TYPE.GESTURE_STICKER);
  }
  
  private boolean needSegment()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (this.groupVideoFilterList != null)
    {
      bool1 = bool3;
      if (this.groupVideoFilterList.getRenderList() != null)
      {
        bool1 = bool3;
        if (!this.groupVideoFilterList.getRenderList().isEmpty())
        {
          Iterator localIterator = this.groupVideoFilterList.getRenderList().iterator();
          bool1 = bool2;
          while (localIterator.hasNext())
          {
            bool2 = ((AESticker)localIterator.next()).checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER);
            bool1 = bool2;
            if (bool2) {
              bool1 = bool2;
            }
          }
        }
      }
    }
    while (this.singleVideoFilterList == null) {
      return bool1;
    }
    return this.singleVideoFilterList.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER);
  }
  
  private int onDrawAV(int paramInt)
  {
    return paramInt;
  }
  
  private void updateNeedEmotionDetect()
  {
    boolean bool = needEmotionDetect();
    getQQFilterRenderManager().setNeedEmotionDetect(bool);
  }
  
  private void updateNeedFaceDetect(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if ((paramBoolean) && (this.onlySharp))
    {
      if (getQQFilterRenderManager().getBackCameraDetectEnable())
      {
        if (QQSharpFaceFilter.sSharpFaceLevel > 0) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          this.needFaceDetect = paramBoolean;
          return;
        }
      }
      if ((getQQFilterRenderManager().getCameraID() == 1) && (QQSharpFaceFilter.sSharpFaceLevel > 0)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        this.needFaceDetect = paramBoolean;
        return;
      }
    }
    if (this.activeVideoFilterLists.size() > 0) {}
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      this.needFaceDetect = paramBoolean;
      return;
    }
  }
  
  private void updateNeedGenderDetect()
  {
    boolean bool = needGenderDetect();
    getQQFilterRenderManager().setNeedGenderDetect(bool);
  }
  
  private void updateNeedHandDetect()
  {
    boolean bool = needHandDetect();
    getQQFilterRenderManager().setNeedHandDetect(bool);
  }
  
  private void updateNeedSegment()
  {
    boolean bool = needSegment();
    getQQFilterRenderManager().setNeedSegment(bool);
  }
  
  private boolean updateSharpFaceFilter(AESticker paramAESticker, int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool2 = false;
    if (!getQQFilterRenderManager().hasAEDetectorInited()) {
      return false;
    }
    VideoPreviewFaceOutlineDetector localVideoPreviewFaceOutlineDetector = getQQFilterRenderManager().getFaceDetector();
    if (((paramAESticker == null) || ((!paramAESticker.checkStickerType(AESticker.STICKER_TYPE.SEGMENT_STICKER)) && (!paramAESticker.isUseMesh()))) && (localVideoPreviewFaceOutlineDetector != null)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (Build.BRAND.equals("Xiaomi"))
      {
        j = i;
        if (Build.MODEL.equals("MI 9")) {
          j = 0;
        }
      }
      this.onlySharp = false;
      if ((QQSharpFaceFilter.sSharpFaceLevel < 0) || (this.mSharpFaceFilter == null) || (j == 0)) {
        break;
      }
      this.singleVideoFilterList = this.mSharpFaceFilter.createFilterWithSharpFace(paramAESticker, localVideoPreviewFaceOutlineDetector, paramInt1, paramInt2, paramDouble);
      if ((this.singleVideoFilterList != null) && (this.singleVideoFilterList.getFilters() != null))
      {
        boolean bool1 = bool2;
        if (!this.mUseTemplate)
        {
          bool1 = bool2;
          if (this.singleVideoFilterList.getFilters().size() == 1)
          {
            bool1 = bool2;
            if (this.singleVideoFilterList.getFilters().get(0) == this.mSharpFaceFilter.getFilter()) {
              bool1 = true;
            }
          }
        }
        this.onlySharp = bool1;
      }
      if (this.singleVideoFilterList != null) {
        this.singleVideoFilterList.apply();
      }
      this.isSharpInit = true;
      return true;
    }
  }
  
  public void changeFilter(AESticker paramAESticker, int paramInt1, int paramInt2, double paramDouble, VideoMaterial paramVideoMaterial)
  {
    if ((VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial)) && (!this.mFilamentSoInited)) {
      this.mFilamentSoInited = FeatureManager.Features.FILAMENT.init();
    }
    if ((VideoMaterialUtil.isAnimojiMaterial(paramVideoMaterial)) && (!this.mAnimojiSoInited)) {
      this.mAnimojiSoInited = FeatureManager.Features.ANIMOJI.init();
    }
    if ((VideoMaterialUtil.needVoiceChange(paramVideoMaterial)) && (!this.mVoiceChangeSoInited)) {
      this.mVoiceChangeSoInited = FeatureManager.Features.VOICE_TO_TEXT.init();
    }
    boolean bool;
    if (paramAESticker != null)
    {
      bool = true;
      this.isActive = bool;
      this.mUseTemplate = bool;
      this.groupVideoFilterList = null;
      this.singleVideoFilterList = paramAESticker;
      ArrayList localArrayList = new ArrayList();
      if (paramAESticker != null) {
        localArrayList.add(paramAESticker);
      }
      changeFilterList(localArrayList, paramInt1, paramInt2, paramDouble);
      updateNeedSegment();
      updateNeedHandDetect();
      updateNeedEmotionDetect();
      updateNeedGenderDetect();
      if (paramVideoMaterial == null) {
        break label178;
      }
    }
    label178:
    for (paramAESticker = paramVideoMaterial.getStarParam();; paramAESticker = null)
    {
      getQQFilterRenderManager().setStarParam(paramAESticker);
      return;
      bool = false;
      break;
    }
  }
  
  public void changeGroupFilter(GroupVideoFilterList paramGroupVideoFilterList, int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramGroupVideoFilterList != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.isActive = bool;
      this.mUseTemplate = bool;
      this.groupVideoFilterList = paramGroupVideoFilterList;
      this.singleVideoFilterList = null;
      if (paramGroupVideoFilterList == null) {
        break;
      }
      changeFilterList(paramGroupVideoFilterList.getActiveList(), paramInt1, paramInt2, paramDouble);
      return;
    }
    changeFilterList(null, paramInt1, paramInt2, paramDouble);
  }
  
  public void clearActiveFilters()
  {
    this.groupVideoFilterList = null;
    if (this.singleVideoFilterList != null) {
      this.singleVideoFilterList.clear();
    }
    this.singleVideoFilterList = null;
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    this.mCopyFrame.clear();
    Iterator localIterator = this.activeVideoFilterLists.iterator();
    while (localIterator.hasNext())
    {
      AESticker localAESticker = (AESticker)localIterator.next();
      if (localAESticker != null) {
        localAESticker.clear();
      }
    }
    this.activeVideoFilterLists.clear();
  }
  
  public VideoFilterBase getEffectFilter()
  {
    if (this.singleVideoFilterList != null) {
      return null;
    }
    return this.singleVideoFilterList.getEffectFilter();
  }
  
  public int getSharpFaceStrength()
  {
    if (this.mSharpFaceFilter != null) {
      return this.mSharpFaceFilter.getSharpFaceLevel();
    }
    return 0;
  }
  
  public int getShookHeadCount()
  {
    AESticker localAESticker = getFirstVideoFilterList();
    if (localAESticker != null) {
      return localAESticker.getShookHeadCount();
    }
    return 0;
  }
  
  public boolean hasEffectFilter()
  {
    return (this.singleVideoFilterList != null) && (this.singleVideoFilterList.getEffectFilter() != null);
  }
  
  public boolean isFilterWork()
  {
    return this.isActive;
  }
  
  public boolean needFaceDetect()
  {
    return isNeedFaceDetect();
  }
  
  public void onDrawFrame()
  {
    this.mOutputTextureID = onDrawAV(onDrawPtv(this.mInputTextureID));
  }
  
  public int onDrawPtv(int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new ArrayList();
    label83:
    PTFaceAttr localPTFaceAttr;
    int i;
    label161:
    int j;
    label191:
    label375:
    Frame localFrame;
    label271:
    label311:
    AIAttr localAIAttr;
    if (this.groupVideoFilterList != null)
    {
      this.groupVideoFilterList.detectFaceEvent(getQQFilterRenderManager());
      this.groupVideoFilterList.checkAutoJump(l);
      ((List)localObject1).addAll(this.groupVideoFilterList.getRenderList());
      if ((localObject1 == null) || (((List)localObject1).isEmpty()) || (this.onlySharp)) {
        break label867;
      }
      this.isActive = true;
      if (!this.isSharpInit)
      {
        getQQFilterRenderManager().initAEDetector_sync();
        if (getQQFilterRenderManager().hasAEDetectorInited())
        {
          updateSharpFaceFilter(null, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), 0.25D);
          this.isSharpInit = true;
        }
      }
      localPTFaceAttr = getQQFilterRenderManager().getFaceAttr();
      if ((!getQQFilterRenderManager().needFaceDetect()) || (localPTFaceAttr == null)) {
        break label875;
      }
      i = 1;
      j = i;
      if (i != 0)
      {
        j = i;
        if (this.onlySharp)
        {
          if (localPTFaceAttr.getAllFacePoints().size() <= 0) {
            break label880;
          }
          j = 1;
        }
      }
      if ((localObject1 == null) || (((List)localObject1).isEmpty()) || (j == 0) || ((this.onlySharp) && (!QQSharpFaceFilter.sSharpFaceOpen))) {
        break label1124;
      }
      if ((!this.isInit) && (FeatureManager.isBasicFeaturesFunctionReady()))
      {
        GLES20.glGenTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
        if (this.mFlipFilter != null) {
          break label885;
        }
        this.mFlipFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
        this.mFlipFilter.apply();
        this.mFlipFilter.setRotationAndFlip(0, 0, 1);
        if (this.mCopyFilter != null) {
          break label895;
        }
        this.mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
        this.mCopyFilter.apply();
        this.isInit = true;
      }
      i = paramInt;
      if (!this.isInit) {
        break label1080;
      }
      QQFilterLogManager.setPTVStart();
      if (!this.needFlip) {
        break label905;
      }
      this.mFlipFilter.RenderProcess(paramInt, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
      QQFilterLogManager.setPTVEnd("第一次翻转texture耗时");
      localFrame = this.mFlipFrame;
      QQFilterLogManager.setPTVStart();
      localAIAttr = getQQFilterRenderManager().getAIAttr();
      if ((localAIAttr == null) || (!getQQFilterRenderManager().isNeedSegment())) {
        break label1135;
      }
    }
    label674:
    label867:
    label875:
    label1135:
    for (PTSegAttr localPTSegAttr = (PTSegAttr)localAIAttr.getRealtimeData(AEDetectorType.SEGMENT.value);; localPTSegAttr = null)
    {
      Object localObject2;
      if ((localAIAttr != null) && (localPTFaceAttr != null))
      {
        localObject2 = (PTEmotionAttr)localAIAttr.getAvailableData(AEDetectorType.EMOTION.value);
        if ((localObject2 != null) && (((PTEmotionAttr)localObject2).isSmile()))
        {
          localObject2 = localPTFaceAttr.getTriggeredExpression();
          ((Set)localObject2).add(Integer.valueOf(PTFaceAttr.PTExpression.SMILE.value));
          localPTFaceAttr.setTriggeredExpression((Set)localObject2);
          l = System.currentTimeMillis();
          localObject2 = (FaceActionCounter)localPTFaceAttr.getFaceActionCounter().get(Integer.valueOf(PTFaceAttr.PTExpression.SMILE.value));
          if ((localObject2 != null) && (l - ((FaceActionCounter)localObject2).updateTime > 1000L))
          {
            ((FaceActionCounter)localObject2).count += 1;
            ((FaceActionCounter)localObject2).updateTime = l;
          }
        }
      }
      paramInt = localFrame.getTextureId();
      getQQFilterRenderManager().initGestureDetectorSDK_Sync();
      if (getQQFilterRenderManager().mNeedDoGestureDetect)
      {
        localObject2 = getQQFilterRenderManager().getFaceDataAfterDoFaceDetect();
        GestureMgrRecognize.getInstance().transferRGBAbuffer(paramInt, (byte[])localObject2, getQQFilterRenderManager().getFaceDetectWidth(), getQQFilterRenderManager().getFaceDetectHeight(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
        localObject2 = GestureMgrRecognize.getInstance().getGestureInfo();
        if ((localObject2 == null) || (!((GestureKeyInfo)localObject2).vaild) || (!((GestureKeyInfo)localObject2).type.equalsIgnoreCase(GestureFilterManager.sGestureType))) {
          break label941;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          getQQFilterRenderManager().mLastGestureDetector = ((GestureKeyInfo)localObject2);
          getQQFilterRenderManager().mLastGestureDetector.timeStamp = System.currentTimeMillis();
        }
        if (getQQFilterRenderManager().mLastGestureDetector != null) {
          break label946;
        }
        getQQFilterRenderManager().mDetectedGesture = false;
      }
      for (;;)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AESticker)((Iterator)localObject1).next();
          QQFilterLogManager.setPTVStart();
          ((AESticker)localObject2).updateVideoSize(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), getQQFilterRenderManager().getWindowScale());
          ((AESticker)localObject2).setRatio((float)getQQFilterRenderManager().getUIAspectRatio());
          ((AESticker)localObject2).setAIAttr(localAIAttr);
          ((AESticker)localObject2).setFaceAttr(localPTFaceAttr);
          ((AESticker)localObject2).setSegAttr(localPTSegAttr);
          localFrame = ((AESticker)localObject2).getBeforeTransFilter().render(localFrame);
          localFrame = ((AESticker)localObject2).getAfterTransFilter().render(localFrame);
          QQFilterLogManager.setPTVEnd("挂件内部渲染耗时");
        }
        if (this.singleVideoFilterList == null) {
          break;
        }
        ((List)localObject1).add(this.singleVideoFilterList);
        break;
        this.isActive = false;
        break label83;
        i = 0;
        break label161;
        label880:
        j = 0;
        break label191;
        label885:
        this.mFlipFilter.ClearGLSL();
        break label271;
        label895:
        this.mCopyFilter.ClearGLSL();
        break label311;
        this.mCopyFilter.RenderProcess(paramInt, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
        break label375;
        paramInt = 0;
        break label674;
        if (getQQFilterRenderManager().mLastGestureDetector.timeStamp + 2000L >= System.currentTimeMillis()) {
          getQQFilterRenderManager().mDetectedGesture = true;
        } else {
          getQQFilterRenderManager().mDetectedGesture = false;
        }
      }
      paramInt = localFrame.getTextureId();
      QQFilterLogManager.setPTVStart();
      if (this.needFlip)
      {
        this.mFlipFilter.RenderProcess(paramInt, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[1], 0.0D, this.mTempFrame);
        i = this.mFlipTextureID[1];
        if (PhoneProperty.instance().isCannotReuseFrameBuffer())
        {
          this.mFlipFrame.clear();
          this.mTempFrame.clear();
        }
        QQFilterLogManager.setPTVEnd("第二次翻转texture耗时");
        QQFilterLogManager.setFilterStatus("QQPtvVideoFilter", true);
      }
      for (;;)
      {
        GLES20.glDisable(2929);
        return i;
        this.mCopyFilter.RenderProcess(paramInt, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[1], 0.0D, this.mTempFrame);
        break;
        QQFilterLogManager.setFilterStatus("QQPtvVideoFilter", false);
        i = paramInt;
      }
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    updateVideoSize(paramInt1, paramInt2, getQQFilterRenderManager().getWindowScale());
  }
  
  public void onSurfaceCreate() {}
  
  public void onSurfaceDestroy()
  {
    GLES20.glDeleteTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
    if ((this.activeVideoFilterLists != null) && (!this.activeVideoFilterLists.isEmpty()))
    {
      Iterator localIterator = this.activeVideoFilterLists.iterator();
      while (localIterator.hasNext())
      {
        AESticker localAESticker = (AESticker)localIterator.next();
        if (localAESticker != null) {
          localAESticker.clear();
        }
      }
    }
    if (this.mFlipFilter != null) {
      this.mFlipFilter.ClearGLSL();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.ClearGLSL();
    }
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    this.mCopyFrame.clear();
    this.isInit = false;
    if (getQQFilterRenderManager() != null) {
      getQQFilterRenderManager().destroyAEDetecor();
    }
    QQSharpFaceFilter.sSharpFaceLevel = -1;
    this.mSegmentInited = false;
  }
  
  public void resetShookHeadCount()
  {
    AESticker localAESticker = getFirstVideoFilterList();
    if (localAESticker != null) {
      localAESticker.setShookHeadCount(0);
    }
  }
  
  public void setCosmeticsAlpha(int paramInt)
  {
    if ((this.activeVideoFilterLists != null) && (!this.activeVideoFilterLists.isEmpty()))
    {
      Iterator localIterator = this.activeVideoFilterLists.iterator();
      while (localIterator.hasNext())
      {
        AESticker localAESticker = (AESticker)localIterator.next();
        try
        {
          localAESticker.updateCosAlpha(paramInt);
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.needFlip = paramBoolean;
  }
  
  public void setSharpFaceStrength(int paramInt)
  {
    if (this.mSharpFaceFilter != null) {
      this.mSharpFaceFilter.setSharpFaceStrength(paramInt);
    }
  }
  
  public void startRecord()
  {
    if (this.groupVideoFilterList != null) {
      this.groupVideoFilterList.next(1);
    }
  }
  
  public void stopEffectsAudio()
  {
    if ((this.activeVideoFilterLists != null) && (!this.activeVideoFilterLists.isEmpty()))
    {
      Iterator localIterator = this.activeVideoFilterLists.iterator();
      while (localIterator.hasNext())
      {
        AESticker localAESticker = (AESticker)localIterator.next();
        if (localAESticker != null) {
          try
          {
            localAESticker.destroyAudio();
          }
          catch (Error localError) {}
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    if ((this.activeVideoFilterLists != null) && (!this.activeVideoFilterLists.isEmpty()))
    {
      Iterator localIterator = this.activeVideoFilterLists.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          AESticker localAESticker = (AESticker)localIterator.next();
          try
          {
            localAESticker.updateVideoSize(paramInt1, paramInt2, paramDouble);
            label74:
            localAESticker.checkNeedARGesture();
          }
          catch (Throwable localThrowable)
          {
            break label74;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtvVideoFilter
 * JD-Core Version:    0.7.0.1
 */