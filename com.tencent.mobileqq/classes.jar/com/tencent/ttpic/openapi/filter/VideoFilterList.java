package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AECatAttr;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.filament.FilamentFilter;
import com.tencent.ttpic.filament.FilamentParticleFilter;
import com.tencent.ttpic.filter.ActFilters;
import com.tencent.ttpic.filter.CameraARFilterGesture;
import com.tencent.ttpic.filter.CrazyFaceFilters;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.DoodleFilter;
import com.tencent.ttpic.filter.DynamicNumFilter;
import com.tencent.ttpic.filter.EffectTriggerFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyShakeStrokeFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilterExt;
import com.tencent.ttpic.filter.FaceCopyFilter;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FaceOffNoseOcclusionFilter;
import com.tencent.ttpic.filter.FacialFeatureFilter;
import com.tencent.ttpic.filter.FastBlurFilter;
import com.tencent.ttpic.filter.FastParticleFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.HairCos;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LutItemsFilter;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.PhantomFilter;
import com.tencent.ttpic.filter.SkyboxItemsFilter;
import com.tencent.ttpic.filter.StarOverlayFilter;
import com.tencent.ttpic.filter.StaticCountFilter;
import com.tencent.ttpic.filter.StaticNumFilter;
import com.tencent.ttpic.filter.StickerDisplacementBlurFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter;
import com.tencent.ttpic.manager.CharmRandomManager;
import com.tencent.ttpic.manager.MaterialManager;
import com.tencent.ttpic.manager.RandomGroupManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceBeautyItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.PTSkyAttr;
import com.tencent.ttpic.openapi.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.DynamicMaskFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.FastMaskFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.MaskMergeFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.StaticMaskFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup;
import com.tencent.ttpic.openapi.filter.zoomfilter.ZoomFilter;
import com.tencent.ttpic.openapi.initializer.TNNGenderSwitchInitializer;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.listener.IStickerListener;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FaceOffFilterManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.SegmentStroke;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SEGMENT_BORDER_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.STICKER_ORDER_MODE;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.particle.GPUParticleConfig;
import com.tencent.ttpic.particle.GPUParticleConfig.BackgroundConfig;
import com.tencent.ttpic.particle.GPUParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter3D;
import com.tencent.ttpic.renderitem.FrozenFrameRender;
import com.tencent.ttpic.renderitem.StyleFilterRender;
import com.tencent.ttpic.trigger.AETriggerI;
import com.tencent.ttpic.trigger.FabbyStrokeExtTriggerCtrlItem;
import com.tencent.ttpic.trigger.HairCosTriggerCtrlItem;
import com.tencent.ttpic.trigger.StyleChildTriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.trigger.ZoomTriggerCtrlItem;
import com.tencent.ttpic.trigger.triggerctrlitem.DetectorSettingTrigerCtrlItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.PersonParam;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.ttpic.openapi.filter.RenderItem;>;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class VideoFilterList
{
  public static final int MAX_FACE_COUNT = 99;
  private static final String MULTIVIEW_PREFIX = "$preservedTexture_multiViewer_";
  private static final String MVPARTS_PREFIX = "$preservedTexture_mvPart";
  private static String TAG = VideoFilterList.class.getSimpleName();
  private static final Random mRandom = new Random(System.currentTimeMillis());
  public static boolean sIsUseFreezeFrame = false;
  private AIAttr aiAttr;
  private CameraARFilterGesture arFilterGesture;
  private List<RenderItem> bgDynamicStickerRenderItems;
  private List<RenderItem> bgStaticStickerRenderItems;
  private List<RenderItem> bodyParticleRenderItems = new ArrayList();
  private List<RenderItem> bodyRenderItems = new ArrayList();
  private List<RenderItem> catRenderItems = new ArrayList();
  private Frame[] copyFrame = new Frame[2];
  private boolean cosFunEnableGAN = false;
  private CosFunFilterGroup cosFunFilterGroup;
  private StyleCustomFilterGroup cosFunInnerStyleCustomFilterGroup;
  private CrazyFaceFilters crazyFaceFilters;
  private LinkedList<FaceInfo> currentFaceInfo;
  public int detecFaceCount = 0;
  private boolean directDraw;
  private StickerDisplacementBlurFilter displacementBlurFilter = new StickerDisplacementBlurFilter();
  private Frame displacementMaskFrame = new Frame();
  private FabbyExtractFilter fabbyExtractFilter;
  private Frame fabbyFeatheredMaskStep1 = new Frame();
  private Frame fabbyFeatheredMaskStep2 = new Frame();
  public Bitmap fabbyFrameBitmap;
  private Frame fabbyOriginCopyFrame = new Frame();
  private FabbyShakeStrokeFilter fabbyShakeStrokeFilter;
  private Frame fabbyStrokeFrame = new Frame();
  private RenderItem fabbyStrokeRenderItem;
  private Frame fabbyStrokeShakeFrame = new Frame();
  private List<RenderItem> faceGpuParticleDynamicRenderItems = new ArrayList();
  private List<RenderItem> faceGpuParticleStaticRenderItems = new ArrayList();
  private List<RenderItem> faceParticleDynamicRenderItems = new ArrayList();
  private List<RenderItem> faceParticleStaticRenderItems = new ArrayList();
  private FastBlurFilter fastBlurFilter;
  private FastParticleFilter fastParticleFilter = new FastParticleFilter();
  private List<RenderItem> fgDynamicRenderItems;
  private List<RenderItem> fgStaticStickerBeforeTransformRenderItems;
  private List<RenderItem> fgStaticStickerRenderItems;
  private FilamentParticleFilter filamentParticleFilter;
  private RenderItem filamentRenderItem;
  public int filterHeight = 0;
  public int filterWidth = 0;
  private List<VideoFilterBase> filters = new ArrayList();
  private GaussianBlurFilterCompose gaussianCompose;
  private List<RenderItem> gestureGpuParticleRenderItems = new ArrayList();
  private List<RenderItem> gestureParticleRenderItems = new ArrayList();
  private List<RenderItem> gestureRenderItems = new ArrayList();
  private int hasFreezeFrameStatus = -1;
  private RenderItem headCropRenderItem;
  private List<RenderItem> headCropRenderItems = new ArrayList();
  private RenderItem lutItemsRenderItem;
  private ARParticleFilter mARParticleFilter;
  private Queue<PointF> mARTouchPointQueue = new LinkedList();
  private ActFilters mActFilters;
  private Map<Integer, Float> mAgeValueMap = new HashMap();
  private RenderItem mAudio3DRenderItem;
  private List<RenderItem> mBeautyTransformListRenderItems;
  private Frame mBgFrame = new Frame();
  private BlurMaskFilter mBlurMaskFilter;
  private List<RenderItem> mComicEffectRenderItems;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] mCopyMaskFrame = new Frame[2];
  private Map<Integer, Float> mCpValueMap = new HashMap();
  private int mCurMVPart = 0;
  private PersonParam mCurPersonParam = new PersonParam();
  private VideoFilterBase mEffectFilter;
  private Frame mEffectFrame = new Frame();
  private int mEffectOrder = -1;
  private List<RenderItem> mEffectTriggerRenderItems;
  private RenderItem mFabbyMvFiltersRenderItem;
  private double mFaceDetScale;
  private Comparator<Face> mFaceIndexComperator = new VideoFilterList.3(this);
  private List<Face> mFaceList = new ArrayList();
  private FaceOffNoseOcclusionFilter mFaceOffNoseOcclusionFilter = new FaceOffNoseOcclusionFilter();
  private List<RenderItem> mFaceOffRenderItems = new ArrayList();
  private List<FacialFeatureFilter> mFacialFeatureFilterList;
  private RenderItem mFastBodyStickerRenderItems;
  private RenderItem mFastFaceStickerRenderItems;
  private FrozenFrameRender mFrozenRender;
  private RenderItem mGameRenderItems;
  private Map<Integer, Float> mGenderValueMap = new HashMap();
  private RenderItem mHairCosRenderItem;
  private Frame mHeadCropFrame = new Frame();
  private BaseFilter mMaskFilter;
  private MaskMergeFilter mMaskMergeFilter = new MaskMergeFilter();
  private Frame mMaskStickerFrame = new Frame();
  private List<RenderItem> mMaskStickerRenderItemList;
  private List<PointF> mMaskTouchPoints = new ArrayList();
  private Frame mMergeMaskFrame = new Frame();
  private PhantomFilter mPhantomFilter;
  private Frame mPhantomFrame = new Frame();
  private Map<Integer, Float> mPopularValueMap = new HashMap();
  private List<RenderItem> mRemodelRenderItems;
  private float mScaleFace = 1.0F;
  private List<RenderItem> mStyleFilterRenderItems;
  private List<List<PointF>> mTouchPoints = new ArrayList();
  private List<VideoFilterBase> mTransformFilters;
  private List<RenderItem> mTransformRenderItems;
  private RenderItem mZoomRenderItem;
  private VideoMaterial material;
  private List<MultiViewerFilter> multiViewerFilters;
  public Map<Integer, Frame> multiViewerFrameMap = new HashMap();
  private Frame multiViewerOutFrame;
  private int multiViewerSrcTexture;
  public Map<String, Frame> mvPartsAndMultiViewerFrameMap = new HashMap();
  private boolean needDetectEmotion = false;
  private boolean needDetectGender = false;
  private boolean needDetectGesture = false;
  private boolean needDetectGestureBonePoint = false;
  private int onlyDetectOneGesture = -999;
  private int postiveFaceCounts = 0;
  private int preFaceCounts = 0;
  private String preImagePath = null;
  private List<VideoFilterBase> qqGestureDynamicFilters = new ArrayList();
  private List<VideoFilterBase> qqGestureStaticFilters = new ArrayList();
  private List<RapidNetFilter> rapidNetFilterList = new ArrayList();
  private List<RenderItem> rapidNetRenderItems = new ArrayList();
  private Frame renderFrame = new Frame();
  private List<RenderItem> renderItems = new ArrayList();
  private int selectFaceIndex = -1;
  public int shookHeadCount = 0;
  private int shookType = 0;
  private RenderItem skyboxItemsRenderItem;
  private SnapShotFrameToSticker snapShotFrameToSticker = new SnapShotFrameToSticker();
  private int snapshotTexture;
  private StarOverlayFilter starOverlayFilter = new StarOverlayFilter();
  private Frame starOverlayFrame = new Frame();
  private List<RenderItem> starParticleRenderItems = new ArrayList();
  public List<RenderItem> staticCountRenderItems;
  private List<RenderItem> styleChildRenderItems = new ArrayList();
  private StyleCustomFilterGroup styleCustomFilterGroup;
  private TriggerManager triggerManager;
  private VoiceTextFilter voiceTextFilter;
  
  private Frame RenderProcessForComicEffectRenderItems(int paramInt, Frame paramFrame, List<RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame;
    }
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId()) {}
    for (Frame localFrame = this.copyFrame[1];; localFrame = this.copyFrame[0])
    {
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      Iterator localIterator = paramList.iterator();
      paramList = paramFrame;
      while (localIterator.hasNext())
      {
        Object localObject = (RenderItem)localIterator.next();
        if ((localObject != null) && ((((RenderItem)localObject).triggerCtrlItem == null) || (((RenderItem)localObject).triggerCtrlItem.isTriggered())))
        {
          localObject = (ComicEffectFilter)((RenderItem)localObject).filter;
          if ((paramInt == ((ComicEffectFilter)localObject).getOrderMode()) && (((ComicEffectFilter)localObject).isRenderReady()) && (!((ComicEffectFilter)localObject).isAlreadyRenderInSingleFrame()))
          {
            paramList = VideoFrameUtil.renderProcessByForAnimationEffectFilter(paramList.getTextureId(), paramList.width, paramList.height, (ComicEffectFilter)localObject, paramFrame, localFrame);
            ((ComicEffectFilter)localObject).setAlreadyRenderInSingleFrame(true);
          }
        }
      }
    }
    return paramList;
  }
  
  private Frame RenderProcessForEffectTriggerRenderItems(int paramInt, Frame paramFrame, List<RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame;
    }
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId()) {}
    for (Frame localFrame = this.copyFrame[1];; localFrame = this.copyFrame[0])
    {
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      Iterator localIterator = paramList.iterator();
      paramList = paramFrame;
      while (localIterator.hasNext())
      {
        Object localObject = (RenderItem)localIterator.next();
        if ((localObject != null) && ((((RenderItem)localObject).triggerCtrlItem == null) || (((RenderItem)localObject).triggerCtrlItem.isTriggered())))
        {
          localObject = (EffectTriggerFilter)((RenderItem)localObject).filter;
          if ((paramInt == ((EffectTriggerFilter)localObject).getOrderMode()) && (((EffectTriggerFilter)localObject).isRenderReady()) && (!((EffectTriggerFilter)localObject).isAlreadyRenderInSingleFrame()))
          {
            paramList = VideoFrameUtil.renderProcessByForEffectTriggerFilter(paramList.getTextureId(), paramList.width, paramList.height, (EffectTriggerFilter)localObject, paramFrame, localFrame);
            ((EffectTriggerFilter)localObject).setAlreadyRenderInSingleFrame(true);
          }
        }
      }
    }
    return paramList;
  }
  
  private Frame RenderProcessForFastBodyStickerRenderItem(Frame paramFrame1, Frame paramFrame2, PTDetectInfo paramPTDetectInfo)
  {
    if (paramFrame2 == null) {}
    for (;;)
    {
      paramFrame2 = (FastStickerFilter)this.mFastBodyStickerRenderItems.filter;
      if (paramFrame2 != null)
      {
        paramFrame2.setFaceCount(1);
        paramFrame2.addSrcTexture(this.multiViewerSrcTexture);
        paramFrame2.updatePreview(paramPTDetectInfo);
        paramFrame2.setRenderParams(new PersonParam().setPersonID(0));
        paramFrame2.Render(paramFrame1);
      }
      return paramFrame1;
      paramFrame1 = paramFrame2;
    }
  }
  
  private Frame RenderProcessForFastFaceStickerRenderItem(Frame paramFrame1, Frame paramFrame2, List<Face> paramList, int paramInt, PTFaceAttr paramPTFaceAttr, PersonParam paramPersonParam, AIAttr paramAIAttr)
  {
    if (paramFrame2 == null) {}
    for (;;)
    {
      paramAIAttr = (FastStickerFilter)this.mFastFaceStickerRenderItems.filter;
      if (paramAIAttr != null)
      {
        paramAIAttr.setFaceCount(paramInt);
        paramAIAttr.addSrcTexture(this.multiViewerSrcTexture);
        if (paramInt > 0) {
          break;
        }
        paramFrame2 = paramPTFaceAttr.getTriggeredExpression();
        if (this.aiAttr != null)
        {
          paramList = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
          if (paramList != null) {
            paramFrame2.add(Integer.valueOf(paramList.getHandType()));
          }
        }
        paramAIAttr.updatePreview(new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramFrame2).timestamp(paramPTFaceAttr.getTimeStamp()).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build());
        paramAIAttr.Render(paramFrame1);
      }
      return paramFrame1;
      paramFrame1 = paramFrame2;
    }
    PTHandAttr localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localPTHandAttr != null) {}
    for (paramFrame2 = localPTHandAttr.getHandPointList();; paramFrame2 = null)
    {
      int i = 0;
      while ((i < paramInt) && (i < paramList.size()))
      {
        Face localFace = (Face)paramList.get(i);
        Set localSet = paramPTFaceAttr.getTriggeredExpression();
        if (localPTHandAttr != null) {
          localSet.add(Integer.valueOf(localPTHandAttr.getHandType()));
        }
        paramAIAttr.updatePreview(new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints(paramFrame2).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build());
        paramAIAttr.setRenderParams(paramPersonParam);
        i += 1;
      }
      break;
    }
  }
  
  private Frame RenderProcessForFastParticleFilter(Frame paramFrame, List<VideoFilterBase> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return paramFrame;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.get(i);
      if ((localVideoFilterBase instanceof ParticleFilter)) {
        if (((ParticleFilter)localVideoFilterBase).getParticleParam().needRender) {
          localArrayList.add(((ParticleFilter)localVideoFilterBase).getParticleParam());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((localVideoFilterBase instanceof ParticleFilter3D)) && (((ParticleFilter3D)localVideoFilterBase).getParticleParam().needRender)) {
          localArrayList.add(((ParticleFilter3D)localVideoFilterBase).getParticleParam());
        }
      }
    }
    this.fastParticleFilter.render(localArrayList, paramFrame);
    return paramFrame;
  }
  
  private Frame RenderProcessForFastParticleRenderItem(Frame paramFrame, List<RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return paramFrame;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (RenderItem)paramList.get(i);
      if ((((RenderItem)localObject).filter == null) || ((((RenderItem)localObject).triggerCtrlItem != null) && (!((RenderItem)localObject).triggerCtrlItem.isTriggered()))) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (VideoFilterBase)((RenderItem)localObject).filter;
        if ((localObject instanceof ParticleFilter))
        {
          if (((ParticleFilter)localObject).getParticleParam().needRender) {
            localArrayList.add(((ParticleFilter)localObject).getParticleParam());
          }
        }
        else if (((localObject instanceof ParticleFilter3D)) && (((ParticleFilter3D)localObject).getParticleParam().needRender)) {
          localArrayList.add(((ParticleFilter3D)localObject).getParticleParam());
        }
      }
    }
    this.fastParticleFilter.render(localArrayList, paramFrame);
    return paramFrame;
  }
  
  private Frame RenderProcessForFilters(Frame paramFrame1, Frame paramFrame2, List<? extends VideoFilterBase> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame1;
    }
    if (paramFrame1.getTextureId() == this.copyFrame[0].getTextureId()) {}
    Frame localFrame1;
    VideoFilterBase localVideoFilterBase;
    for (Frame localFrame2 = this.copyFrame[1];; localFrame2 = this.copyFrame[0])
    {
      localFrame1 = paramFrame2;
      if (paramFrame2 == null) {
        localFrame1 = paramFrame1;
      }
      GLES20.glBindFramebuffer(36160, localFrame1.getFBO());
      GLES20.glViewport(0, 0, localFrame1.width, localFrame1.height);
      int i = 0;
      paramFrame2 = paramFrame1;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label321;
        }
        localVideoFilterBase = (VideoFilterBase)paramList.get(i);
        if (needRender(localVideoFilterBase)) {
          break;
        }
        i += 1;
      }
    }
    boolean bool = VideoFilterUtil.hasBlendMode(localVideoFilterBase);
    if ((!VideoFilterUtil.canUseBlendMode(localVideoFilterBase)) || ((this.directDraw) && (bool)))
    {
      localFrame1 = paramFrame2;
      if (VideoFilterUtil.needCopy(localVideoFilterBase))
      {
        GlUtil.setBlendMode(false);
        localFrame1 = FrameUtil.renderProcessBySwitchFbo(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, this.mCopyFilter, paramFrame1, localFrame2);
        GlUtil.setBlendMode(true);
      }
      if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform()))
      {
        paramFrame2 = VideoFrameUtil.renderProcessByCopy(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, this.mCopyFilter, paramFrame1, localFrame2);
        label257:
        localFrame1 = paramFrame2;
      }
    }
    for (;;)
    {
      this.directDraw = true;
      break;
      paramFrame2 = VideoFrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, paramFrame1, localFrame2);
      break label257;
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
    }
    label321:
    return localFrame1;
  }
  
  private Frame RenderProcessForFilters(Frame paramFrame, List<? extends VideoFilterBase> paramList)
  {
    return RenderProcessForFilters(paramFrame, null, paramList);
  }
  
  private Frame RenderProcessForGpuParticleFilters(Frame paramFrame1, Frame paramFrame2, List<? extends VideoFilterBase> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      paramList = paramFrame1;
    }
    do
    {
      do
      {
        return paramList;
        int i = 0;
        while (i < paramList.size())
        {
          paramFrame1 = ((VideoFilterBase)paramList.get(i)).render(paramFrame1);
          i += 1;
        }
        paramList = paramFrame1;
      } while (paramFrame2 == null);
      paramList = paramFrame1;
    } while (paramFrame1.getTextureId() == paramFrame2.getTextureId());
    this.mCopyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
    return paramFrame2;
  }
  
  private Frame RenderProcessForGpuParticleFilters(Frame paramFrame, List<? extends VideoFilterBase> paramList)
  {
    return RenderProcessForGpuParticleFilters(paramFrame, null, paramList);
  }
  
  private Frame RenderProcessForGpuParticleRenderItems(Frame paramFrame1, Frame paramFrame2, List<RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      paramList = paramFrame1;
    }
    do
    {
      do
      {
        return paramList;
        int i = 0;
        if (i < paramList.size())
        {
          Object localObject = (RenderItem)paramList.get(i);
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            localObject = (VideoFilterBase)((RenderItem)localObject).filter;
            ((GPUParticleFilter)localObject).setDynamicColorReference(this.fabbyFrameBitmap);
            paramFrame1 = ((VideoFilterBase)localObject).render(paramFrame1);
          }
        }
        paramList = paramFrame1;
      } while (paramFrame2 == null);
      paramList = paramFrame1;
    } while (paramFrame1.getTextureId() == paramFrame2.getTextureId());
    this.mCopyFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
    return paramFrame2;
  }
  
  private Frame RenderProcessForGpuParticleRenderItems(Frame paramFrame, List<RenderItem> paramList)
  {
    return RenderProcessForGpuParticleRenderItems(paramFrame, null, paramList);
  }
  
  private Frame RenderProcessForRenderItem(Frame paramFrame1, Frame paramFrame2, List<? extends RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame1;
    }
    if (paramFrame1.getTextureId() == this.copyFrame[0].getTextureId()) {}
    Frame localFrame1;
    VideoFilterBase localVideoFilterBase;
    for (Frame localFrame2 = this.copyFrame[1];; localFrame2 = this.copyFrame[0])
    {
      localFrame1 = paramFrame2;
      if (paramFrame2 == null) {
        localFrame1 = paramFrame1;
      }
      GLES20.glBindFramebuffer(36160, localFrame1.getFBO());
      GLES20.glViewport(0, 0, localFrame1.width, localFrame1.height);
      int i = 0;
      paramFrame2 = paramFrame1;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label327;
        }
        localVideoFilterBase = (VideoFilterBase)((RenderItem)paramList.get(i)).filter;
        if (needRender(localVideoFilterBase)) {
          break;
        }
        i += 1;
      }
    }
    boolean bool = VideoFilterUtil.hasBlendMode(localVideoFilterBase);
    if ((!VideoFilterUtil.canUseBlendMode(localVideoFilterBase)) || ((this.directDraw) && (bool)))
    {
      localFrame1 = paramFrame2;
      if (VideoFilterUtil.needCopy(localVideoFilterBase))
      {
        GlUtil.setBlendMode(false);
        localFrame1 = FrameUtil.renderProcessBySwitchFbo(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, this.mCopyFilter, paramFrame1, localFrame2);
        GlUtil.setBlendMode(true);
      }
      if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform()))
      {
        paramFrame2 = VideoFrameUtil.renderProcessByCopy(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, this.mCopyFilter, paramFrame1, localFrame2);
        label263:
        localFrame1 = paramFrame2;
      }
    }
    for (;;)
    {
      this.directDraw = true;
      break;
      paramFrame2 = VideoFrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, paramFrame1, localFrame2);
      break label263;
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
    }
    label327:
    return localFrame1;
  }
  
  private Frame RenderProcessForRenderItem(Frame paramFrame, List<? extends RenderItem> paramList)
  {
    return RenderProcessForRenderItem(paramFrame, null, paramList);
  }
  
  private Frame RenderProcessForRenderItems(Frame paramFrame1, Frame paramFrame2, List<RenderItem> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame1;
    }
    Frame localFrame;
    Object localObject;
    label100:
    RenderItem localRenderItem;
    List<RenderItem> localList;
    if (paramFrame1.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame = this.copyFrame[1];
      localObject = paramFrame2;
      if (paramFrame2 == null) {
        localObject = paramFrame1;
      }
      GLES20.glBindFramebuffer(36160, ((Frame)localObject).getFBO());
      GLES20.glViewport(0, 0, ((Frame)localObject).width, ((Frame)localObject).height);
      Iterator localIterator = paramList.iterator();
      paramFrame2 = paramFrame1;
      paramList = (List<RenderItem>)localObject;
      do
      {
        if (!localIterator.hasNext()) {
          return paramList;
        }
        localRenderItem = (RenderItem)localIterator.next();
        if (!(localRenderItem.filter instanceof ParticleFilter3D))
        {
          localObject = paramFrame2;
          localList = paramList;
          if (!(localRenderItem.filter instanceof VideoFilterBase)) {
            break;
          }
          if (localRenderItem.triggerCtrlItem != null)
          {
            localObject = paramFrame2;
            localList = paramList;
            if (!localRenderItem.triggerCtrlItem.isTriggered()) {
              break;
            }
          }
        }
        localObject = (VideoFilterBase)localRenderItem.filter;
      } while ((!(localRenderItem.filter instanceof ParticleFilter3D)) && (!needRender((VideoFilterBase)localObject)));
      boolean bool = VideoFilterUtil.hasBlendMode((VideoFilterBase)localObject);
      if ((VideoFilterUtil.canUseBlendMode((VideoFilterBase)localObject)) && ((!this.directDraw) || (!bool))) {
        break label410;
      }
      paramList = paramFrame2;
      if (VideoFilterUtil.needCopy((VideoFilterBase)localObject))
      {
        GlUtil.setBlendMode(false);
        paramList = FrameUtil.renderProcessBySwitchFbo(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, this.mCopyFilter, paramFrame1, localFrame);
        GlUtil.setBlendMode(true);
      }
      if ((!VideoFilterUtil.maybeTransformFilter((VideoFilterBase)localObject)) || (!VideoMaterialUtil.needCopyTransform())) {
        break label386;
      }
      paramFrame2 = VideoFrameUtil.renderProcessByCopy(paramList.getTextureId(), paramList.width, paramList.height, (VideoFilterBase)localObject, this.mCopyFilter, paramFrame1, localFrame);
      label312:
      paramList = paramFrame2;
    }
    for (;;)
    {
      this.directDraw = true;
      localList = paramList;
      localObject = paramFrame2;
      if (((localRenderItem.filter instanceof FaceOffFilter)) && (!localRenderItem.triggerCtrlItem.isTriggered()))
      {
        ((FaceOffFilter)localRenderItem.filter).resetLastFrameIndex();
        localRenderItem.triggerCtrlItem.reset();
      }
      paramFrame2 = (Frame)localObject;
      paramList = localList;
      break label100;
      localFrame = this.copyFrame[0];
      break;
      label386:
      paramFrame2 = VideoFrameUtil.renderProcessBySwitchFbo(paramList.getTextureId(), paramList.width, paramList.height, (VideoFilterBase)localObject, paramFrame1, localFrame);
      break label312;
      label410:
      ((VideoFilterBase)localObject).OnDrawFrameGLSL();
      ((VideoFilterBase)localObject).renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
    }
    return paramList;
  }
  
  private Frame RenderProcessForRenderItems(Frame paramFrame, List<RenderItem> paramList)
  {
    return RenderProcessForRenderItems(paramFrame, null, paramList);
  }
  
  private boolean allBusinessPrivateProcess(List<RenderItem> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem.filter instanceof BuckleFaceFilter)) {
          return ((BuckleFaceFilter)localRenderItem.filter).isNeedRender();
        }
      }
    }
    return true;
  }
  
  private int analysisShookHead(LinkedList<FaceInfo> paramLinkedList)
  {
    int j = 0;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 1)) {
      return 0;
    }
    FaceInfo localFaceInfo = (FaceInfo)paramLinkedList.getFirst();
    int i;
    if ((localFaceInfo.yaw > 25.0F) && (hasShookToRight(paramLinkedList))) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramLinkedList.clear();
        paramLinkedList.addFirst(localFaceInfo);
      }
      return i;
      i = j;
      if (localFaceInfo.yaw < -25.0F)
      {
        i = j;
        if (hasShookToLeft(paramLinkedList)) {
          i = 2;
        }
      }
    }
  }
  
  private void clearAgeRangeItemStatus()
  {
    if (this.renderItems != null)
    {
      int i = 0;
      if (i < this.renderItems.size())
      {
        Object localObject = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        if (!(localObject instanceof NormalVideoFilter)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).ageRange != null)) {
            ((StickerItem)localObject).ageRange.clearStatus();
          }
        }
      }
    }
    this.mAgeValueMap.clear();
  }
  
  private void clearCharmRangeItemStatus()
  {
    if (this.renderItems != null)
    {
      int i = 0;
      if (i < this.renderItems.size())
      {
        Object localObject = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        if (!(localObject instanceof NormalVideoFilter)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).charmRange != null)) {
            ((StickerItem)localObject).charmRange.clearStatus();
          }
        }
      }
    }
    CharmRandomManager.getInstance().clearFaceRandoms();
  }
  
  private void clearCpRangeItemStatus()
  {
    if (this.renderItems != null)
    {
      int i = 0;
      if (i < this.renderItems.size())
      {
        Object localObject = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        if (!(localObject instanceof NormalVideoFilter)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).cpRange != null)) {
            ((StickerItem)localObject).cpRange.clearStatus();
          }
        }
      }
    }
    this.mCpValueMap.clear();
  }
  
  private void clearFaceMappingData()
  {
    this.mFaceList.clear();
  }
  
  private void clearGenderRangeItemStatus()
  {
    if (this.renderItems != null)
    {
      int i = 0;
      if (i < this.renderItems.size())
      {
        Object localObject = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        if (!(localObject instanceof NormalVideoFilter)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).genderRange != null)) {
            ((StickerItem)localObject).genderRange.clearStatus();
          }
        }
      }
    }
    this.mGenderValueMap.clear();
  }
  
  private void clearHandsRangeItemStatus()
  {
    if (this.gestureRenderItems != null)
    {
      int i = 0;
      while (i < this.gestureRenderItems.size())
      {
        StickerItem localStickerItem = ((NormalVideoFilter)((RenderItem)this.gestureRenderItems.get(i)).filter).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
          localStickerItem.charmRange.clearStatus();
        }
        i += 1;
      }
    }
    CharmRandomManager.getInstance().clearHandRandoms();
  }
  
  private void clearPopularRangeItemStatus()
  {
    if (this.renderItems != null)
    {
      int i = 0;
      if (i < this.renderItems.size())
      {
        Object localObject = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        if (!(localObject instanceof NormalVideoFilter)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((NormalVideoFilter)localObject).getStickerItem();
          if ((localObject != null) && (((StickerItem)localObject).popularRange != null)) {
            ((StickerItem)localObject).popularRange.clearStatus();
          }
        }
      }
    }
    this.mPopularValueMap.clear();
  }
  
  private void destroyNormalAudio()
  {
    Object localObject;
    RenderItem localRenderItem;
    if (this.renderItems != null)
    {
      localObject = this.renderItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject).next();
        if ((localRenderItem.filter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localRenderItem.filter).destroyAudio();
        }
      }
    }
    if (this.fgStaticStickerRenderItems != null)
    {
      localObject = this.fgStaticStickerRenderItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject).next();
        if ((localRenderItem.filter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localRenderItem.filter).destroyAudio();
        }
      }
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject = this.mFastFaceStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).destroyAudio();
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject = this.mFastBodyStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).destroyAudio();
      }
    }
    if (this.bodyRenderItems != null)
    {
      localObject = this.bodyRenderItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject).next();
        if ((localRenderItem.filter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localRenderItem.filter).destroyAudio();
        }
      }
    }
  }
  
  private float getAdjustedAge(float paramFloat)
  {
    float f;
    if ((paramFloat >= 0.21D) && (paramFloat <= 0.25D)) {
      f = (float)(paramFloat * 0.8D);
    }
    do
    {
      do
      {
        return f;
        if ((paramFloat >= 0.26D) && (paramFloat <= 0.3D)) {
          return (float)(paramFloat * 0.7D);
        }
        if ((paramFloat >= 0.31D) && (paramFloat <= 0.49D)) {
          return (float)(paramFloat * 0.6D);
        }
        f = paramFloat;
      } while (paramFloat < 0.5D);
      f = paramFloat;
    } while (paramFloat > 0.7D);
    return (float)(paramFloat * 0.5D);
  }
  
  private List<PointF> getBodyPoints(AIAttr paramAIAttr)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAIAttr != null)
    {
      paramAIAttr = (List)paramAIAttr.getAvailableData(AEDetectorType.BODY.value);
      if ((paramAIAttr != null) && (paramAIAttr.size() > 0)) {
        return ((BodyDetectResult)paramAIAttr.get(0)).bodyPoints;
      }
    }
    return localArrayList;
  }
  
  private List<VideoFilterBase> getExcludeFilters(List<? extends VideoFilterBase> paramList, List<VideoFilterBase> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (!paramList1.contains(localVideoFilterBase)) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private List<RenderItem> getExcludeRenderItems(List<RenderItem> paramList1, List<RenderItem> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList1.next();
      if (!paramList2.contains(localRenderItem)) {
        localArrayList.add(localRenderItem);
      }
    }
    return localArrayList;
  }
  
  private boolean getIsPositiveFace(PTFaceAttr paramPTFaceAttr, Frame paramFrame)
  {
    if ((paramPTFaceAttr == null) || (paramFrame == null)) {
      return false;
    }
    List localList1 = paramPTFaceAttr.getAllFaceAngles();
    List localList2 = paramPTFaceAttr.getAllFacePoints();
    if ((localList1 != null) && (localList1.size() > 0) && (localList2 != null) && (localList2.size() > 0)) {
      return PTFaceAttr.isPositiveFace((float[])localList1.get(0), (List)localList2.get(0), paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
    }
    return false;
  }
  
  private int getMaskType(List<RenderItem> paramList1, FastMaskFilter paramFastMaskFilter, List<RenderItem> paramList2)
  {
    int i = 0;
    int j = 0;
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      for (i = j; paramList1.hasNext(); i = ((StaticMaskFilter)((RenderItem)paramList1.next()).filter).getMaskType()) {}
    }
    j = i;
    if (paramList2 != null)
    {
      paramList1 = paramList2.iterator();
      for (;;)
      {
        j = i;
        if (!paramList1.hasNext()) {
          break;
        }
        i = ((DynamicMaskFilter)((RenderItem)paramList1.next()).filter).getMaskType();
      }
    }
    if (paramFastMaskFilter != null) {
      j = paramFastMaskFilter.getMaskType();
    }
    return j;
  }
  
  private List<Integer> getNewFaceIndexList(int paramInt, Set<Integer> paramSet, List<Face> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(Integer.valueOf(((Face)paramList.get(((Integer)paramSet.next()).intValue())).faceIndex));
    }
    int i = 0;
    while (localArrayList.size() < paramInt)
    {
      if (!localHashSet.contains(Integer.valueOf(i))) {
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private Frame getSpaceFrame(int paramInt)
  {
    if ((this.mCopyMaskFrame[0] != null) && (paramInt == this.mCopyMaskFrame[0].getTextureId())) {
      return this.mCopyMaskFrame[1];
    }
    return this.mCopyMaskFrame[0];
  }
  
  private List<StaticCountFilter> getStaticCountFilters(List<VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
        if ((localVideoFilterBase instanceof StaticCountFilter)) {
          localArrayList.add((StaticCountFilter)localVideoFilterBase);
        }
      }
    }
    return localArrayList;
  }
  
  private List<RenderItem> getStaticCountRenderItens(List<RenderItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem.filter instanceof StaticCountFilter)) {
          localArrayList.add(localRenderItem);
        }
      }
    }
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStaticStickerFilters(List<? extends VideoFilterBase> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (((localVideoFilterBase instanceof StaticStickerFilter)) || ((localVideoFilterBase instanceof StaticNumFilter)) || (((localVideoFilterBase instanceof ParticleFilter)) && (((ParticleFilter)localVideoFilterBase).isStatic())) || (((localVideoFilterBase instanceof ParticleFilter3D)) && (((ParticleFilter3D)localVideoFilterBase).isStatic()))) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    return localArrayList;
  }
  
  private List<RenderItem> getStaticStickerRenderItems(List<RenderItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if ((localRenderItem != null) && (localRenderItem.filter != null) && (((localRenderItem.filter instanceof StaticStickerFilter)) || ((localRenderItem.filter instanceof StaticNumFilter)) || (((localRenderItem.filter instanceof ParticleFilter)) && (((ParticleFilter)localRenderItem.filter).isStatic())) || (((localRenderItem.filter instanceof ParticleFilter3D)) && (((ParticleFilter3D)localRenderItem.filter).isStatic())))) {
        localArrayList.add(localRenderItem);
      }
    }
    return localArrayList;
  }
  
  private List<VideoFilterBase> getStickerFilters(List<? extends VideoFilterBase> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = getStaticStickerFilters(paramList);
    paramList = getExcludeFilters(paramList, localList);
    if (paramBoolean1) {
      return getZIndexFilters(localList, paramBoolean2);
    }
    return getZIndexFilters(paramList, paramBoolean2);
  }
  
  private List<RenderItem> getStickerRenderItems(List<RenderItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = getStaticStickerRenderItems(paramList);
    paramList = getExcludeRenderItems(paramList, localList);
    if (paramBoolean1) {
      return getZIndexRenderItems(localList, paramBoolean2);
    }
    return getZIndexRenderItems(paramList, paramBoolean2);
  }
  
  private List<VideoFilterBase> getZIndexFilters(List<VideoFilterBase> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      int i = 0;
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        i = ((NormalVideoFilter)localVideoFilterBase).getStickerItem().zIndex;
      }
      if ((localVideoFilterBase instanceof VoiceTextFilter)) {
        i = ((VoiceTextFilter)localVideoFilterBase).getZIndex();
      }
      if (paramBoolean)
      {
        if (i >= 0) {
          localArrayList.add(localVideoFilterBase);
        }
      }
      else if (i < 0) {
        localArrayList.add(localVideoFilterBase);
      }
    }
    Collections.sort(localArrayList, new VideoFilterList.2(this));
    return localArrayList;
  }
  
  private List<RenderItem> getZIndexRenderItems(List<RenderItem> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if (localRenderItem.filter != null)
      {
        int i = 0;
        if ((localRenderItem.filter instanceof NormalVideoFilter)) {
          i = ((NormalVideoFilter)localRenderItem.filter).getStickerItem().zIndex;
        }
        if ((localRenderItem.filter instanceof VoiceTextFilter)) {
          i = ((VoiceTextFilter)localRenderItem.filter).getZIndex();
        }
        if (paramBoolean)
        {
          if (i >= 0) {
            localArrayList.add(localRenderItem);
          }
        }
        else if (i < 0) {
          localArrayList.add(localRenderItem);
        }
      }
    }
    Collections.sort(localArrayList, new VideoFilterList.1(this));
    return localArrayList;
  }
  
  private boolean hasShookToLeft(List<FaceInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramList.get(0);
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      FaceInfo localFaceInfo2 = (FaceInfo)paramList.next();
      if (localFaceInfo1.yaw - localFaceInfo2.yaw < -12.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasShookToRight(LinkedList<FaceInfo> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramLinkedList.getFirst();
    paramLinkedList = paramLinkedList.listIterator();
    while (paramLinkedList.hasNext())
    {
      FaceInfo localFaceInfo2 = (FaceInfo)paramLinkedList.next();
      if (localFaceInfo1.yaw - localFaceInfo2.yaw > 12.0F) {
        return true;
      }
    }
    return false;
  }
  
  private void hitAgeRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.renderItems != null)
      {
        if ((!this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mAgeValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          f = getAdjustedAge(f);
          this.mAgeValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        if (i < this.renderItems.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
          localObject1 = ((RenderItem)this.renderItems.get(i)).triggerCtrlItem;
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((localObject2 != null) && (localObject1 != null))
            {
              ((TriggerCtrlItem)localObject1).setAgeRangeValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerRenderItemList != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mMaskStickerRenderItemList.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject2 = (RenderItem)paramVideoPreviewFaceOutlineDetector.next();
          localObject1 = (VideoFilterBase)((RenderItem)localObject2).filter;
          localObject2 = ((RenderItem)localObject2).triggerCtrlItem;
          if (((localObject1 instanceof NormalVideoFilter)) && (localObject2 != null)) {
            ((TriggerCtrlItem)localObject2).setAgeRangeValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mBeautyTransformListRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mBeautyTransformListRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setAgeRangeValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mRemodelRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mRemodelRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setAgeRangeValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
    }
  }
  
  private void hitCharmRangeItem(int paramInt)
  {
    if (!CharmRandomManager.getInstance().constainsFaceCharm(paramInt)) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          hitRenderItemsCharmRange(this.renderItems, paramInt);
          hitRenderItemsCharmRange(this.mBeautyTransformListRenderItems, paramInt);
          hitRenderItemsCharmRange(this.mRemodelRenderItems, paramInt);
          hitRenderItemsCharmRange(this.mFaceOffRenderItems, paramInt);
          hitRenderItemsCharmRange(this.mMaskStickerRenderItemList, paramInt);
          if ((this.mHairCosRenderItem != null) && (this.mHairCosRenderItem.triggerCtrlItem != null)) {
            this.mHairCosRenderItem.triggerCtrlItem.hitCharmRange(paramInt);
          }
          Object localObject2;
          if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null) && ((this.filamentRenderItem.filter instanceof FilamentFilter)))
          {
            localObject1 = (FilamentFilter)this.filamentRenderItem.filter;
            if (((FilamentFilter)localObject1).getGlbList() != null)
            {
              localObject1 = ((FilamentFilter)localObject1).getGlbList().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (GLBItemJava)((Iterator)localObject1).next();
                if (((GLBItemJava)localObject2).charmRange != null) {
                  ((GLBItemJava)localObject2).charmRange.hit(CharmRandomManager.getInstance().getFaceCharmValue(paramInt));
                }
              }
            }
          }
          if (this.mFacialFeatureFilterList != null)
          {
            localObject1 = this.mFacialFeatureFilterList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (FacialFeatureFilter)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                localObject2 = ((FacialFeatureFilter)localObject2).getStickerRenderItems();
                if (localObject2 != null) {
                  hitRenderItemsCharmRange((List)localObject2, paramInt);
                }
              }
            }
          }
        } while (this.styleChildRenderItems == null);
        localObject1 = (RenderItem)this.styleChildRenderItems.get(0);
      } while (!(((RenderItem)localObject1).triggerCtrlItem instanceof StyleChildTriggerCtrlItem));
      localObject1 = (StyleChildTriggerCtrlItem)((RenderItem)localObject1).triggerCtrlItem;
    } while (localObject1 == null);
    ((StyleChildTriggerCtrlItem)localObject1).hitCharmRange(CharmRandomManager.getInstance().getFaceCharmValue(paramInt));
  }
  
  private void hitCpRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt1, int paramInt2)
  {
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue()) || (paramInt2 < 2)) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.renderItems != null)
      {
        if ((!this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) || ((this.mCpValueMap.containsKey(Integer.valueOf(paramInt1))) && (((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt1, FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          this.mCpValueMap.put(Integer.valueOf(paramInt1), Float.valueOf(f));
        }
        paramInt2 = 0;
        if (paramInt2 < this.renderItems.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)((RenderItem)this.renderItems.get(paramInt2)).filter;
          localObject1 = ((RenderItem)this.renderItems.get(paramInt2)).triggerCtrlItem;
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            paramInt2 += 1;
            break;
            localObject2 = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if (localObject1 != null) {
              ((TriggerCtrlItem)localObject1).setCpRangeValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
            }
            if ((localObject2 != null) && ((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value)) {
              ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() * 100.0F));
            }
          }
        }
      }
      if (this.mMaskStickerRenderItemList != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mMaskStickerRenderItemList.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject2 = (RenderItem)paramVideoPreviewFaceOutlineDetector.next();
          localObject1 = (VideoFilterBase)((RenderItem)localObject2).filter;
          localObject2 = ((RenderItem)localObject2).triggerCtrlItem;
          if (((localObject1 instanceof NormalVideoFilter)) && (localObject2 != null)) {
            ((TriggerCtrlItem)localObject2).setCpRangeValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
          }
        }
      }
      if (this.mBeautyTransformListRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mBeautyTransformListRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setCpRangeValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
          }
        }
      }
      if (this.mRemodelRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mRemodelRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setCpRangeValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
          }
        }
      }
    }
  }
  
  private void hitDynamicFaceRandomGroupItem(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (this.renderItems != null)
    {
      int i = 0;
      while (i < this.renderItems.size())
      {
        localObject1 = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        localObject2 = ((RenderItem)this.renderItems.get(i)).triggerCtrlItem;
        if (((localObject1 instanceof NormalVideoFilter)) && (!((NormalVideoFilter)localObject1).isStaticSticker())) {
          ((TriggerCtrlItem)localObject2).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
        i += 1;
      }
    }
    Object localObject3;
    if (this.mFaceOffRenderItems != null)
    {
      localObject1 = this.mFaceOffRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (RenderItem)((Iterator)localObject1).next();
        localObject2 = ((RenderItem)localObject3).filter;
        localObject3 = ((RenderItem)localObject3).triggerCtrlItem;
        if ((localObject2 instanceof FaceOffFilter)) {
          ((TriggerCtrlItem)localObject3).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(paramInt));
        } else if ((localObject2 instanceof FaceOff3DFilter)) {
          ((TriggerCtrlItem)localObject3).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject1 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (RenderItem)((Iterator)localObject1).next();
        localObject2 = (VideoFilterBase)((RenderItem)localObject3).filter;
        localObject3 = ((RenderItem)localObject3).triggerCtrlItem;
        if (((localObject2 instanceof NormalVideoFilter)) && (localObject3 != null) && (!((NormalVideoFilter)localObject2).isStaticSticker())) {
          ((TriggerCtrlItem)localObject3).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
      }
    }
  }
  
  private void hitGenderRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.renderItems != null)
      {
        if ((!this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          this.mGenderValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        if (i < this.renderItems.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
          localObject1 = ((RenderItem)this.renderItems.get(i)).triggerCtrlItem;
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((localObject2 != null) && (localObject1 != null))
            {
              ((TriggerCtrlItem)localObject1).setGenderRangeValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerRenderItemList != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mMaskStickerRenderItemList.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject2 = (RenderItem)paramVideoPreviewFaceOutlineDetector.next();
          localObject1 = (VideoFilterBase)((RenderItem)localObject2).filter;
          localObject2 = ((RenderItem)localObject2).triggerCtrlItem;
          if (((localObject1 instanceof NormalVideoFilter)) && (localObject2 != null)) {
            ((TriggerCtrlItem)localObject2).setGenderRangeValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mBeautyTransformListRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mBeautyTransformListRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setGenderRangeValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mRemodelRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mRemodelRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setGenderRangeValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
    }
  }
  
  private void hitHandRandomGroupItem()
  {
    if (this.gestureRenderItems != null)
    {
      int i = 0;
      while (i < this.gestureRenderItems.size())
      {
        NormalVideoFilter localNormalVideoFilter = (NormalVideoFilter)((RenderItem)this.gestureRenderItems.get(i)).filter;
        ((RenderItem)this.gestureRenderItems.get(i)).triggerCtrlItem.hitRangeGroup(RandomGroupManager.getInstance().getHandValue());
        i += 1;
      }
    }
  }
  
  private void hitHandsRangeItem()
  {
    if (!CharmRandomManager.getInstance().containsHandCharm(0)) {}
    for (;;)
    {
      return;
      if (this.gestureRenderItems != null)
      {
        int i = 0;
        while (i < this.gestureRenderItems.size())
        {
          StickerItem localStickerItem = ((NormalVideoFilter)((RenderItem)this.gestureRenderItems.get(i)).filter).getStickerItem();
          if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
            localStickerItem.charmRange.hit(CharmRandomManager.getInstance().getHandCharmValue());
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitPopularRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.renderItems != null)
      {
        if ((!this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          this.mPopularValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        int i = 0;
        if (i < this.renderItems.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
          localObject1 = ((RenderItem)this.renderItems.get(i)).triggerCtrlItem;
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((localObject2 != null) && (localObject1 != null))
            {
              ((TriggerCtrlItem)localObject1).setPopularRangeValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (((StickerItem)localObject2).markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerRenderItemList != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mMaskStickerRenderItemList.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject2 = (RenderItem)paramVideoPreviewFaceOutlineDetector.next();
          localObject1 = (VideoFilterBase)((RenderItem)localObject2).filter;
          localObject2 = ((RenderItem)localObject2).triggerCtrlItem;
          if (((localObject1 instanceof NormalVideoFilter)) && (localObject2 != null)) {
            ((TriggerCtrlItem)localObject2).setPopularRangeValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mBeautyTransformListRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mBeautyTransformListRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setPopularRangeValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
      if (this.mRemodelRenderItems != null)
      {
        paramVideoPreviewFaceOutlineDetector = this.mRemodelRenderItems.iterator();
        while (paramVideoPreviewFaceOutlineDetector.hasNext())
        {
          localObject1 = ((RenderItem)paramVideoPreviewFaceOutlineDetector.next()).triggerCtrlItem;
          if (localObject1 != null) {
            ((TriggerCtrlItem)localObject1).setPopularRangeValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
          }
        }
      }
    }
  }
  
  private void hitRenderItemsCharmRange(List<RenderItem> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TriggerCtrlItem localTriggerCtrlItem = ((RenderItem)paramList.next()).triggerCtrlItem;
      if (localTriggerCtrlItem != null) {
        localTriggerCtrlItem.hitCharmRange(CharmRandomManager.getInstance().getFaceCharmValue(paramInt));
      }
    }
  }
  
  private void hitStaticFaceRandomGroupItem()
  {
    Object localObject1;
    Object localObject2;
    if (this.renderItems != null)
    {
      int i = 0;
      while (i < this.renderItems.size())
      {
        localObject1 = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
        localObject2 = ((RenderItem)this.renderItems.get(i)).triggerCtrlItem;
        if (((localObject1 instanceof NormalVideoFilter)) && (((NormalVideoFilter)localObject1).isStaticSticker())) {
          ((TriggerCtrlItem)localObject2).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(-1));
        }
        i += 1;
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject1 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (RenderItem)((Iterator)localObject1).next();
        localObject2 = (VideoFilterBase)((RenderItem)localObject3).filter;
        localObject3 = ((RenderItem)localObject3).triggerCtrlItem;
        if (((localObject2 instanceof NormalVideoFilter)) && (localObject3 != null) && (((NormalVideoFilter)localObject2).isStaticSticker())) {
          ((TriggerCtrlItem)localObject3).hitRangeGroup(RandomGroupManager.getInstance().getFaceValue(-1));
        }
      }
    }
  }
  
  private void init()
  {
    this.mCurPersonParam.setPersonID(-1).setGenderType(0);
    MaterialManager.getInstance().setCurrentMaterial(this.material);
  }
  
  private boolean isHandPointsValid(List<PointF> paramList)
  {
    if (paramList == null) {}
    int i;
    do
    {
      return false;
      paramList = paramList.iterator();
      PointF localPointF;
      float f1;
      float f2;
      float f3;
      float f4;
      for (i = 0; paramList.hasNext(); i = (int)(localPointF.y * f4 + f2 * f3 + f1))
      {
        localPointF = (PointF)paramList.next();
        f1 = i;
        f2 = localPointF.x;
        f3 = localPointF.x;
        f4 = localPointF.y;
      }
    } while (i <= 0.0001D);
    return true;
  }
  
  private boolean isMultViewDetectEmotion()
  {
    if (this.multiViewerFilters == null) {
      return false;
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewerFilter)localIterator.next()).needDetectEmotion()) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isMultViewSegmentRequired()
  {
    Iterator localIterator = this.multiViewerFilters.iterator();
    if (localIterator.hasNext()) {
      return ((MultiViewerFilter)localIterator.next()).isSegRequired();
    }
    return false;
  }
  
  private boolean isMultiViewDetectGender()
  {
    if (this.multiViewerFilters == null) {
      return false;
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewerFilter)localIterator.next()).needDetectGender()) {
        return true;
      }
    }
    return false;
  }
  
  private void mappingFace(List<Face> paramList, List<List<PointF>> paramList1, List<Float[]> paramList2, List<float[]> paramList3, List<FaceStatus> paramList4, int paramInt)
  {
    if ((paramList3.size() != paramList1.size()) || (paramList2 == null) || (paramList2.size() != paramList1.size())) {
      return;
    }
    Object localObject2 = new HashSet();
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (j < paramList1.size())
    {
      localObject3 = (List)paramList1.get(j);
      localObject4 = (float[])paramList3.get(j);
      if (paramList2 == null)
      {
        localObject1 = null;
        if ((paramList4 == null) || (paramList4.size() <= j)) {
          break label824;
        }
      }
    }
    label169:
    label821:
    label824:
    for (int k = ((FaceStatus)paramList4.get(j)).gender;; k = 0)
    {
      PointF localPointF = (PointF)((List)localObject3).get(64);
      double d1 = paramInt;
      int i = 0;
      int m = -1;
      d1 *= 0.1D;
      if (i < paramList.size())
      {
        double d2;
        if (((Set)localObject2).contains(Integer.valueOf(i))) {
          d2 = d1;
        }
        for (;;)
        {
          i += 1;
          d1 = d2;
          break label169;
          localObject1 = (Float[])paramList2.get(j);
          break;
          double d3 = AlgoUtils.getDistance(localPointF, (PointF)((Face)paramList.get(i)).facePoints.get(64));
          d2 = d1;
          if (d3 < d1)
          {
            d2 = d3;
            m = i;
          }
        }
      }
      if (m != -1)
      {
        ((Set)localObject2).add(Integer.valueOf(m));
        localHashSet.add(Integer.valueOf(j));
        ((Face)paramList.get(m)).facePoints = ((List)localObject3);
        ((Face)paramList.get(m)).faceAngles = ((float[])localObject4);
        ((Face)paramList.get(m)).gender = k;
        ((Face)paramList.get(m)).facePointVis = ((Float[])localObject1);
      }
      j += 1;
      break;
      localObject3 = new HashSet();
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        ((Set)localObject3).add(Integer.valueOf(((Face)paramList.get(paramInt)).faceIndex));
        if (((Set)localObject2).contains(Integer.valueOf(paramInt))) {
          ((List)localObject1).add(paramList.get(paramInt));
        }
        paramInt += 1;
      }
      localObject2 = getNewFaceIndexList(paramList1.size() - localHashSet.size(), (Set)localObject2, paramList);
      i = 0;
      paramInt = 0;
      if (i < paramList1.size())
      {
        if (localHashSet.contains(Integer.valueOf(i))) {
          break label821;
        }
        localObject4 = new Face();
        ((Face)localObject4).facePoints = ((List)paramList1.get(i));
        ((Face)localObject4).faceAngles = ((float[])paramList3.get(i));
        ((Face)localObject4).faceIndex = ((Integer)((List)localObject2).get(paramInt)).intValue();
        ((Face)localObject4).facePointVis = ((Float[])paramList2.get(i));
        ((Face)localObject4).gender = 0;
        if ((paramList4 != null) && (paramList4.size() > i)) {
          ((Face)localObject4).gender = ((FaceStatus)paramList4.get(i)).gender;
        }
        CharmRandomManager.getInstance().removeCharmRange(((Face)localObject4).faceIndex);
        ((List)localObject1).add(localObject4);
        paramInt += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        paramList1 = new HashSet();
        paramInt = 0;
        while (paramInt < ((List)localObject1).size())
        {
          paramList1.add(Integer.valueOf(((Face)((List)localObject1).get(paramInt)).faceIndex));
          paramInt += 1;
        }
        paramList2 = ((Set)localObject3).iterator();
        while (paramList2.hasNext())
        {
          paramList3 = (Integer)paramList2.next();
          if (!paramList1.contains(paramList3)) {
            removeValueRangeForFace(paramList3.intValue());
          }
        }
        paramList.clear();
        paramList.addAll((Collection)localObject1);
        return;
      }
    }
  }
  
  private Frame mergeFrame(Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame = paramFrame1;
    if (this.mMaskMergeFilter != null)
    {
      localFrame = paramFrame1;
      if (paramFrame2 != null)
      {
        localFrame = paramFrame1;
        if (paramFrame1 != null)
        {
          localFrame = paramFrame1;
          if (this.mMergeMaskFrame != null)
          {
            this.mMaskMergeFilter.updateTexture(paramFrame2.getTextureId());
            this.mMergeMaskFrame.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
            FrameUtil.clearFrame(this.mMergeMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mMergeMaskFrame.width, this.mMergeMaskFrame.height);
            this.mMaskMergeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.mMergeMaskFrame);
            localFrame = this.mMergeMaskFrame;
          }
        }
      }
    }
    return localFrame;
  }
  
  private boolean needRender(VideoFilterBase paramVideoFilterBase)
  {
    Object localObject;
    if ((paramVideoFilterBase instanceof NormalVideoFilter))
    {
      localObject = ((NormalVideoFilter)paramVideoFilterBase).getStickerItem();
      if ((localObject == null) || (!((NormalVideoFilter)paramVideoFilterBase).isRenderReady())) {
        return false;
      }
      if ((this.mCurPersonParam.getPersonID() == -1) && ((((StickerItem)localObject).genderType == 0) || (this.mCurPersonParam.isGenderMatch(((StickerItem)localObject).genderType)))) {
        return true;
      }
      if ((((StickerItem)localObject).personID != -1) && (((StickerItem)localObject).personID != this.mCurPersonParam.getPersonID())) {
        return false;
      }
      if (!this.mCurPersonParam.isGenderMatch(((StickerItem)localObject).genderType)) {
        return false;
      }
    }
    FaceItem localFaceItem;
    if ((paramVideoFilterBase instanceof FaceOffFilter))
    {
      localObject = (FaceOffFilter)paramVideoFilterBase;
      localFaceItem = ((FaceOffFilter)localObject).getFaceOffItem();
      if ((localFaceItem == null) || (!((FaceOffFilter)localObject).isRenderReady())) {
        return false;
      }
      if ((this.mCurPersonParam.getPersonID() == -1) && ((localFaceItem.genderType == 0) || (this.mCurPersonParam.isGenderMatch(localFaceItem.genderType)))) {
        return true;
      }
      if ((localFaceItem.personID != -1) && (localFaceItem.personID != this.mCurPersonParam.getPersonID())) {
        return false;
      }
      if (!this.mCurPersonParam.isGenderMatch(localFaceItem.genderType)) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof FaceOff3DFilter))
    {
      localObject = (FaceOff3DFilter)paramVideoFilterBase;
      localFaceItem = ((FaceOff3DFilter)localObject).getFaceOffItem();
      if ((localFaceItem == null) || (!((FaceOff3DFilter)localObject).isRenderReady())) {
        return false;
      }
      if (this.mCurPersonParam.getPersonID() == -1) {
        return true;
      }
      if ((localFaceItem.personID != -1) && (localFaceItem.personID != this.mCurPersonParam.getPersonID())) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof TransformFilter))
    {
      localObject = ((TransformFilter)paramVideoFilterBase).getFaceMeshItem();
      if ((localObject != null) && (((((FaceMeshItem)localObject).personID != -1) && (this.mCurPersonParam.getPersonID() != -1) && (((FaceMeshItem)localObject).personID != this.mCurPersonParam.getPersonID())) || ((this.mCurPersonParam.getPersonID() != -1) && (((FaceMeshItem)localObject).charmRange != null) && (!((FaceMeshItem)localObject).charmRange.isHit())))) {
        return false;
      }
    }
    if ((paramVideoFilterBase instanceof BuckleFaceFilter)) {
      return ((BuckleFaceFilter)paramVideoFilterBase).isNeedRender();
    }
    if ((paramVideoFilterBase instanceof FaceCropFilter)) {
      return ((FaceCropFilter)paramVideoFilterBase).isNeedRender();
    }
    return true;
  }
  
  private void processMappingFace(List<List<PointF>> paramList, List<float[]> paramList1, List<Float[]> paramList2, List<FaceStatus> paramList3, int paramInt)
  {
    if (!this.mFaceList.isEmpty())
    {
      mappingFace(this.mFaceList, paramList, paramList2, paramList1, paramList3, paramInt);
      Collections.sort(this.mFaceList, this.mFaceIndexComperator);
    }
    for (;;)
    {
      return;
      this.mFaceList.clear();
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        Face localFace = new Face();
        if (paramList != null) {
          localFace.facePoints = ((List)paramList.get(paramInt));
        }
        if (paramList1 != null) {
          localFace.faceAngles = ((float[])paramList1.get(paramInt));
        }
        if (paramList2 != null) {
          localFace.facePointVis = ((Float[])paramList2.get(paramInt));
        }
        if ((paramList3 != null) && (paramList3.size() > paramInt)) {
          localFace.gender = ((FaceStatus)paramList3.get(paramInt)).gender;
        }
        localFace.faceIndex = paramInt;
        this.mFaceList.add(localFace);
        paramInt += 1;
      }
    }
  }
  
  private void removeValueRangeForFace(int paramInt)
  {
    CharmRandomManager.getInstance().removeCharmRange(paramInt);
    this.mAgeValueMap.remove(Integer.valueOf(paramInt));
    this.mGenderValueMap.remove(Integer.valueOf(paramInt));
    this.mPopularValueMap.remove(Integer.valueOf(paramInt));
    this.mCpValueMap.remove(Integer.valueOf(paramInt));
  }
  
  private int selectFace(LinkedList<FaceInfo> paramLinkedList, List<LinkedList<FaceInfo>> paramList)
  {
    int k;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      k = -1;
      return k;
    }
    float f1 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
    int i = 0;
    label44:
    if (i < paramList.size())
    {
      paramLinkedList = (LinkedList)paramList.get(i);
      float f2;
      int j;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        f2 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
        if (this.shookType != 1) {
          break label139;
        }
        if (f2 <= f1) {
          break label160;
        }
        j = 1;
      }
      for (;;)
      {
        k = i;
        if (j != 0) {
          break;
        }
        i += 1;
        break label44;
        if ((this.shookType == 2) && (f2 < f1)) {
          j = 1;
        } else {
          j = 0;
        }
      }
    }
    label139:
    label160:
    return -1;
  }
  
  private void splitFgStaticStickerRenderItemsFromTransform(List<RenderItem> paramList)
  {
    this.fgStaticStickerRenderItems = new ArrayList();
    this.fgStaticStickerBeforeTransformRenderItems = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if (localRenderItem.filter != null) {
        if ((localRenderItem.filter instanceof StaticStickerFilter))
        {
          if (((StaticStickerFilter)localRenderItem.filter).getStickerItem().orderMode == VideoMaterialUtil.STICKER_ORDER_MODE.BEFORE_TRANSFORM) {
            this.fgStaticStickerBeforeTransformRenderItems.add(localRenderItem);
          } else {
            this.fgStaticStickerRenderItems.add(localRenderItem);
          }
        }
        else if ((localRenderItem.filter instanceof StaticNumFilter)) {
          this.fgStaticStickerRenderItems.add(localRenderItem);
        } else if (((localRenderItem.filter instanceof ParticleFilter)) && (((ParticleFilter)localRenderItem.filter).isStatic())) {
          this.fgStaticStickerRenderItems.add(localRenderItem);
        } else if (((localRenderItem.filter instanceof ParticleFilter3D)) && (((ParticleFilter3D)localRenderItem.filter).isStatic())) {
          this.fgStaticStickerRenderItems.add(localRenderItem);
        }
      }
    }
  }
  
  private void syncRandomGroupValue(boolean paramBoolean)
  {
    if (this.material.getRandomGroupCount() <= 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mFaceList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Integer.valueOf(((Face)localIterator.next()).faceIndex));
    }
    RandomGroupManager.getInstance().updateValue(localArrayList, paramBoolean, this.material.getRandomGroupCount());
  }
  
  private Frame updateAndRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr == null) {}
    List localList2;
    long l;
    for (Object localObject3 = null;; localObject3 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value))
    {
      if (localObject3 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject3).getHandType()));
      }
      paramPTFaceAttr.getBodyPoints();
      localList2 = paramPTFaceAttr.getAllFaceAngles();
      l = paramPTFaceAttr.getTimeStamp();
      GlUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      paramFrame = updateAndRenderBeforeEffectTriggerFilters(updateAndRenderBeforeComicEffectFilters(paramFrame, paramPTFaceAttr), paramPTFaceAttr);
      if (!VideoMaterialUtil.isFaceCopyMaterial(getMaterial())) {
        break label200;
      }
      paramPTFaceAttr = this.renderItems.iterator();
      while (paramPTFaceAttr.hasNext())
      {
        paramAIAttr = (RenderItem)paramPTFaceAttr.next();
        if ((paramAIAttr.filter instanceof FaceCopyFilter))
        {
          paramAIAttr = (FaceCopyFilter)paramAIAttr.filter;
          paramAIAttr.setFaceParams(localList1, paramFrame.getTextureId());
          paramAIAttr.renderProcess(localSet);
        }
      }
    }
    Object localObject1;
    for (;;)
    {
      GlUtil.setBlendMode(false);
      localObject1 = paramFrame;
      label197:
      return localObject1;
      label200:
      if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
      {
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrame[0]);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
        paramPTFaceAttr = this.renderItems.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          paramAIAttr = (RenderItem)paramPTFaceAttr.next();
          if ((paramAIAttr.filter instanceof SwitchFaceFilter))
          {
            paramAIAttr = (SwitchFaceFilter)paramAIAttr.filter;
            paramAIAttr.setFaceParams(localList1, this.copyFrame[0].getTextureId());
            paramAIAttr.renderProcess(localSet);
          }
        }
      }
      else
      {
        if (getMaterial().getShaderType() != VideoMaterialUtil.SHADER_TYPE.DOODLE.value) {
          break;
        }
        paramPTFaceAttr = this.renderItems.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          paramAIAttr = (RenderItem)paramPTFaceAttr.next();
          if ((paramAIAttr.filter instanceof DoodleFilter))
          {
            paramAIAttr = (DoodleFilter)paramAIAttr.filter;
            paramAIAttr.setTouchPoints(localList1, this.mTouchPoints, paramFrame.width, paramFrame.height, this.mScaleFace);
            paramAIAttr.renderProcess();
          }
        }
      }
    }
    int j = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
    Object localObject2 = new ArrayList();
    if (VideoMaterialUtil.isBodyDetectMaterial(this.material)) {
      localObject2 = getBodyPoints(paramAIAttr);
    }
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      if ((this.crazyFaceFilters != null) && (j > 0))
      {
        localObject4 = (float[])localList2.get(0);
        localObject5 = (List)localList1.get(0);
        localObject1 = paramFrame;
        if (!PTFaceAttr.isPositiveFace((float[])localObject4, (List)localObject5, paramFrame.width, paramFrame.height, this.mFaceDetScale)) {
          break label197;
        }
        paramFrame = this.crazyFaceFilters.updateAndRender(paramFrame, paramFrame.width, paramFrame.height, (List)localObject5, (float[])localObject4);
      }
      for (;;)
      {
        localObject1 = paramFrame;
        if (j <= 0)
        {
          setCurPersonId(-1);
          setCurGender(0);
          localObject4 = new PTDetectInfo.Builder().triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).timestamp(l).aiAttr(paramAIAttr).displacementMaskFrame(this.displacementMaskFrame).build();
          updateRenderItems((PTDetectInfo)localObject4, this.fgDynamicRenderItems);
          paramFrame = RenderProcessForRenderItems(paramFrame, this.fgDynamicRenderItems);
          updateRenderItems((PTDetectInfo)localObject4, this.faceParticleDynamicRenderItems);
          paramFrame = RenderProcessForRenderItems(paramFrame, this.faceParticleDynamicRenderItems);
          updateRenderItems((PTDetectInfo)localObject4, this.faceGpuParticleDynamicRenderItems);
          localObject1 = RenderProcessForGpuParticleRenderItems(paramFrame, this.faceGpuParticleDynamicRenderItems);
          if (this.mMaskStickerRenderItemList != null)
          {
            paramFrame = this.mMaskStickerRenderItemList.iterator();
            while (paramFrame.hasNext())
            {
              localObject5 = (RenderItem)paramFrame.next();
              if (((VideoFilterBase)((RenderItem)localObject5).filter instanceof DynamicMaskFilter)) {
                ((RenderItem)localObject5).updatePreview(localObject4);
              }
            }
          }
        }
        resetPersonParam(paramPTFaceAttr);
        paramFrame = (Frame)localObject1;
        if (this.mFastFaceStickerRenderItems != null) {
          paramFrame = RenderProcessForFastFaceStickerRenderItem((Frame)localObject1, this.multiViewerOutFrame, this.mFaceList, j, paramPTFaceAttr, this.mCurPersonParam, paramAIAttr);
        }
        hitStaticFaceRandomGroupItem();
        localObject1 = new PTDetectInfo.Builder().phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).timestamp(l).displacementMaskFrame(this.displacementMaskFrame).aiAttr(paramAIAttr).build();
        updateFilters((PTDetectInfo)localObject1, this.qqGestureDynamicFilters);
        paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.qqGestureDynamicFilters);
        updateFilters((PTDetectInfo)localObject1, this.qqGestureStaticFilters);
        paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.qqGestureStaticFilters);
        int i = 0;
        label868:
        if ((i < j) && (i < this.mFaceList.size()))
        {
          localObject4 = (Face)this.mFaceList.get(i);
          setCurPersonId(((Face)localObject4).faceIndex);
          setCurGender(((Face)localObject4).gender);
          hitCharmRangeItem(((Face)localObject4).faceIndex);
          hitDynamicFaceRandomGroupItem(((Face)localObject4).faceIndex);
          hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
          hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
          hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
          hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex, j);
          localObject1 = ((Face)localObject4).facePoints;
          localObject4 = ((Face)localObject4).faceAngles;
          if ((!needShookHeadCount()) || (this.currentFaceInfo == null) || (this.selectFaceIndex < 0) || (this.selectFaceIndex >= localList1.size())) {
            break label1702;
          }
          setCurPersonId(i);
          localObject1 = (List)localList1.get(this.selectFaceIndex);
          localObject4 = (float[])localList2.get(this.selectFaceIndex);
        }
        label1684:
        label1690:
        label1702:
        for (;;)
        {
          localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject1).faceAngles((float[])localObject4).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).displacementMaskFrame(this.displacementMaskFrame).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(paramAIAttr).build();
          updateRenderItems((PTDetectInfo)localObject1, this.fgDynamicRenderItems);
          paramFrame = RenderProcessForRenderItems(paramFrame, this.multiViewerOutFrame, this.fgDynamicRenderItems);
          updateRenderItems((PTDetectInfo)localObject1, this.faceParticleDynamicRenderItems);
          paramFrame = RenderProcessForRenderItems(paramFrame, this.multiViewerOutFrame, this.faceParticleDynamicRenderItems);
          updateRenderItems((PTDetectInfo)localObject1, this.faceGpuParticleDynamicRenderItems);
          paramFrame = RenderProcessForGpuParticleRenderItems(paramFrame, this.multiViewerOutFrame, this.faceGpuParticleDynamicRenderItems);
          i += 1;
          break label868;
          resetPersonParam(paramPTFaceAttr);
          if (this.mPhantomFilter != null)
          {
            GlUtil.setBlendMode(false);
            this.mPhantomFilter.updatePreview(paramPTFaceAttr.getTimeStamp());
            this.mPhantomFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mPhantomFrame);
            paramFrame = this.mPhantomFrame;
            GlUtil.setBlendMode(true);
          }
          for (;;)
          {
            if (localObject3 != null) {}
            for (localObject1 = ((PTHandAttr)localObject3).getHandPointList();; localObject1 = null)
            {
              localObject3 = AIActionCounter.getActions(AEDetectorType.HAND);
              localObject4 = new PTDetectInfo.Builder().handPoints((List)localObject1).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).handActionCounter((Map)localObject3).displacementMaskFrame(this.displacementMaskFrame).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
              if (localList2.size() > 0)
              {
                localObject3 = (float[])localList2.get(0);
                label1390:
                localObject3 = ((PTDetectInfo.Builder)localObject4).faceAngles((float[])localObject3).aiAttr(paramAIAttr).build();
                if (!isHandPointsValid((List)localObject1)) {
                  break label1690;
                }
                updateRenderItems((PTDetectInfo)localObject3, this.gestureRenderItems);
                paramFrame = RenderProcessForRenderItems(paramFrame, this.gestureRenderItems);
              }
              for (;;)
              {
                updateRenderItems((PTDetectInfo)localObject3, this.gestureParticleRenderItems);
                paramFrame = RenderProcessForRenderItems(paramFrame, this.gestureParticleRenderItems);
                updateRenderItems((PTDetectInfo)localObject3, this.gestureGpuParticleRenderItems);
                localObject1 = RenderProcessForGpuParticleRenderItems(paramFrame, this.gestureGpuParticleRenderItems);
                localObject2 = new PTDetectInfo.Builder().triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).bodyPoints((List)localObject2).displacementMaskFrame(this.displacementMaskFrame).timestamp(l).aiAttr(paramAIAttr).build();
                paramFrame = (Frame)localObject1;
                if (this.mFastBodyStickerRenderItems != null) {
                  paramFrame = RenderProcessForFastBodyStickerRenderItem((Frame)localObject1, null, (PTDetectInfo)localObject2);
                }
                updateRenderItems((PTDetectInfo)localObject2, this.bodyRenderItems);
                paramFrame = RenderProcessForRenderItems(paramFrame, this.bodyRenderItems);
                updateRenderItems((PTDetectInfo)localObject2, this.bodyParticleRenderItems);
                localObject1 = RenderProcessForRenderItems(paramFrame, this.bodyParticleRenderItems);
                if (paramAIAttr == null) {}
                for (paramFrame = null;; paramFrame = (AECatAttr)paramAIAttr.getAvailableData(AEDetectorType.CAT.value))
                {
                  if (paramFrame == null) {
                    break label1684;
                  }
                  updateRenderItems(new PTDetectInfo.Builder().triggeredExpression(localSet).catFacePoints(paramFrame.getCatPointList()).catFaceAngles(paramFrame.getAngles()).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).timestamp(l).aiAttr(paramAIAttr).build(), this.catRenderItems);
                  paramFrame = RenderProcessForRenderItems((Frame)localObject1, this.catRenderItems);
                  break;
                  localObject3 = null;
                  break label1390;
                }
                paramFrame = (Frame)localObject1;
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private Frame updateAndRenderPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr == null) {}
    List localList2;
    long l;
    for (Object localObject2 = null;; localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value))
    {
      if (localObject2 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
      paramPTFaceAttr.getBodyPoints();
      localList2 = paramPTFaceAttr.getAllFaceAngles();
      l = paramPTFaceAttr.getTimeStamp();
      GlUtil.setBlendMode(true);
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      if (getMaterial().getShaderType() != VideoMaterialUtil.SHADER_TYPE.DOODLE.value) {
        break;
      }
      paramAIAttr = this.renderItems.iterator();
      for (;;)
      {
        paramPTFaceAttr = paramFrame;
        if (!paramAIAttr.hasNext()) {
          break;
        }
        paramPTFaceAttr = (RenderItem)paramAIAttr.next();
        if ((paramPTFaceAttr.filter instanceof DoodleFilter))
        {
          paramPTFaceAttr = (DoodleFilter)paramPTFaceAttr.filter;
          paramPTFaceAttr.setTouchPoints(localList1, this.mTouchPoints, paramFrame.width, paramFrame.height, this.mScaleFace);
          paramPTFaceAttr.renderProcess();
        }
      }
    }
    int j = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
    Object localObject1 = new ArrayList();
    if (VideoMaterialUtil.isBodyDetectMaterial(this.material)) {
      localObject1 = getBodyPoints(paramAIAttr);
    }
    for (;;)
    {
      Object localObject4;
      if (j <= 0)
      {
        setCurPersonId(-1);
        setCurGender(0);
        localObject4 = new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).aiAttr(paramAIAttr).build();
        updateRenderItems((PTDetectInfo)localObject4, this.fgDynamicRenderItems);
        localObject3 = RenderProcessForRenderItems(paramFrame, this.fgDynamicRenderItems);
        paramFrame = (Frame)localObject3;
        if (this.mMaskStickerRenderItemList != null)
        {
          Iterator localIterator = this.mMaskStickerRenderItemList.iterator();
          for (;;)
          {
            paramFrame = (Frame)localObject3;
            if (!localIterator.hasNext()) {
              break;
            }
            paramFrame = (RenderItem)localIterator.next();
            if (((VideoFilterBase)paramFrame.filter instanceof DynamicMaskFilter)) {
              paramFrame.updatePreview(localObject4);
            }
          }
        }
      }
      resetPersonParam(paramPTFaceAttr);
      if (this.mFastFaceStickerRenderItems != null) {
        RenderProcessForFastFaceStickerRenderItem(paramFrame, this.multiViewerOutFrame, this.mFaceList, j, paramPTFaceAttr, this.mCurPersonParam, paramAIAttr);
      }
      hitStaticFaceRandomGroupItem();
      Object localObject3 = new PTDetectInfo.Builder().timestamp(l).aiAttr(paramAIAttr).build();
      updateFilters((PTDetectInfo)localObject3, this.qqGestureDynamicFilters);
      paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.qqGestureDynamicFilters);
      updateFilters((PTDetectInfo)localObject3, this.qqGestureStaticFilters);
      paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.qqGestureStaticFilters);
      int i = 0;
      if ((i < j) && (i < this.mFaceList.size()))
      {
        localObject4 = (Face)this.mFaceList.get(i);
        setCurPersonId(((Face)localObject4).faceIndex);
        setCurGender(((Face)localObject4).gender);
        hitCharmRangeItem(((Face)localObject4).faceIndex);
        hitDynamicFaceRandomGroupItem(((Face)localObject4).faceIndex);
        hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
        hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
        hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex);
        hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject4).faceIndex, j);
        localObject3 = ((Face)localObject4).facePoints;
        localObject4 = ((Face)localObject4).faceAngles;
        if ((!needShookHeadCount()) || (this.currentFaceInfo == null) || (this.selectFaceIndex < 0) || (this.selectFaceIndex >= localList1.size())) {
          break label991;
        }
        setCurPersonId(i);
        localObject3 = (List)localList1.get(this.selectFaceIndex);
        localObject4 = (float[])localList2.get(this.selectFaceIndex);
      }
      label982:
      label991:
      for (;;)
      {
        updateRenderItems(new PTDetectInfo.Builder().facePoints((List)localObject3).faceAngles((float[])localObject4).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(paramAIAttr).build(), this.fgDynamicRenderItems);
        paramFrame = RenderProcessForRenderItems(paramFrame, this.multiViewerOutFrame, this.fgDynamicRenderItems);
        i += 1;
        break;
        resetPersonParam(paramPTFaceAttr);
        if (localObject2 != null) {}
        for (localObject2 = ((PTHandAttr)localObject2).getHandPointList();; localObject2 = null)
        {
          localObject3 = AIActionCounter.getActions(AEDetectorType.HAND);
          localObject3 = new PTDetectInfo.Builder().handPoints((List)localObject2).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handActionCounter((Map)localObject3).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
          if (localList2.size() > 0)
          {
            paramPTFaceAttr = (float[])localList2.get(0);
            paramPTFaceAttr = ((PTDetectInfo.Builder)localObject3).faceAngles(paramPTFaceAttr).aiAttr(paramAIAttr).build();
            if (!isHandPointsValid((List)localObject2)) {
              break label982;
            }
            updateRenderItems(paramPTFaceAttr, this.gestureRenderItems);
            paramFrame = RenderProcessForRenderItems(paramFrame, this.gestureRenderItems);
          }
          for (;;)
          {
            paramAIAttr = new PTDetectInfo.Builder().triggeredExpression(localSet).bodyPoints((List)localObject1).timestamp(l).aiAttr(paramAIAttr).build();
            paramPTFaceAttr = paramFrame;
            if (this.mFastBodyStickerRenderItems != null) {
              paramPTFaceAttr = RenderProcessForFastBodyStickerRenderItem(paramFrame, null, paramAIAttr);
            }
            updateRenderItems(paramAIAttr, this.bodyRenderItems);
            paramPTFaceAttr = RenderProcessForRenderItems(paramPTFaceAttr, this.bodyRenderItems);
            GlUtil.setBlendMode(false);
            return paramPTFaceAttr;
            paramPTFaceAttr = null;
            break;
          }
        }
      }
    }
  }
  
  private void updateDetectorSettingListener(IStickerListener paramIStickerListener)
  {
    if ((this.triggerManager == null) || (this.triggerManager.getTriggers() == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.triggerManager.getTriggers().iterator();
      while (localIterator.hasNext())
      {
        AETriggerI localAETriggerI = (AETriggerI)localIterator.next();
        if ((localAETriggerI != null) && ((localAETriggerI instanceof DetectorSettingTrigerCtrlItem))) {
          ((DetectorSettingTrigerCtrlItem)localAETriggerI).setDetectorSettingLisener(paramIStickerListener);
        }
      }
    }
  }
  
  private void updateShookHead(List<LinkedList<FaceInfo>> paramList)
  {
    if (needShookHeadCount()) {
      if (paramList.size() > 1)
      {
        if ((this.currentFaceInfo == null) || (this.currentFaceInfo.size() == 0) || (this.detecFaceCount != paramList.size()))
        {
          this.currentFaceInfo = ((LinkedList)paramList.get(0));
          this.selectFaceIndex = 0;
          this.shookType = 0;
        }
        if ((this.shookType == 0) || (this.currentFaceInfo == null) || (this.currentFaceInfo.size() <= 0)) {
          break label321;
        }
        this.selectFaceIndex = selectFace(this.currentFaceInfo, paramList);
        if ((this.selectFaceIndex < 0) || (this.selectFaceIndex >= paramList.size())) {
          break label321;
        }
        this.currentFaceInfo = ((LinkedList)paramList.get(this.selectFaceIndex));
        this.shookHeadCount += 1;
      }
    }
    label321:
    for (int i = 1;; i = 0)
    {
      this.shookType = 0;
      if (i == 0) {
        this.shookType = analysisShookHead(this.currentFaceInfo);
      }
      for (;;)
      {
        this.detecFaceCount = paramList.size();
        if (this.shookHeadCount > 99) {
          this.shookHeadCount = 99;
        }
        if (this.staticCountRenderItems == null) {
          break;
        }
        paramList = this.staticCountRenderItems.iterator();
        while (paramList.hasNext())
        {
          RenderItem localRenderItem = (RenderItem)paramList.next();
          if ((localRenderItem.filter instanceof StaticCountFilter)) {
            ((StaticCountFilter)localRenderItem.filter).updateShookCount(this.shookHeadCount);
          }
        }
        if (paramList.size() == 1)
        {
          this.currentFaceInfo = ((LinkedList)paramList.get(0));
          this.selectFaceIndex = 0;
        }
        else if (paramList.size() <= 0)
        {
          this.currentFaceInfo = null;
          this.selectFaceIndex = -1;
        }
      }
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    int j = 0;
    Object localObject2;
    if (this.renderItems != null)
    {
      localObject1 = this.renderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
        }
      }
    }
    if (this.gestureRenderItems != null)
    {
      localObject1 = this.gestureRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
        }
      }
    }
    if (this.catRenderItems != null)
    {
      localObject1 = this.catRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
        }
      }
    }
    if (this.mBeautyTransformListRenderItems != null)
    {
      localObject1 = this.mBeautyTransformListRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof BeautyTransformList)) {
          ((BeautyTransformList)((RenderItem)localObject2).filter).initial();
        }
      }
    }
    if (this.mRemodelRenderItems != null)
    {
      localObject1 = this.mRemodelRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof RemodelFilter)) {
          ((RemodelFilter)((RenderItem)localObject2).filter).init();
        }
      }
    }
    if (this.bodyRenderItems != null)
    {
      localObject1 = this.bodyRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
        }
      }
    }
    if (this.mFaceOffRenderItems != null)
    {
      localObject1 = this.mFaceOffRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof FaceOffFilter)) {
          ((FaceOffFilter)localObject2).ApplyGLSLFilter();
        } else if ((localObject2 instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localObject2).ApplyGLSLFilter();
        } else if ((localObject2 instanceof FaceOffByImageFilter)) {
          ((FaceOffByImageFilter)localObject2).ApplyGLSLFilter();
        }
      }
    }
    Object localObject1 = this.qqGestureStaticFilters.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject1).next()).ApplyGLSLFilter();
    }
    localObject1 = this.qqGestureDynamicFilters.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject1).next()).ApplyGLSLFilter();
    }
    localObject1 = this.faceParticleDynamicRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.faceParticleStaticRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.gestureParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.bodyParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.starParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.faceGpuParticleDynamicRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.faceGpuParticleStaticRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.gestureGpuParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).ApplyGLSLFilter();
      }
    }
    localObject1 = this.headCropRenderItems.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((RenderItem)((Iterator)localObject1).next()).filter).ApplyGLSLFilter();
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject1 = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject1 != null) {
        ((FabbyFilters)localObject1).ApplyGLSLFilter(this.material.getDataPath());
      }
    }
    if ((this.headCropRenderItem != null) && (this.headCropRenderItem.filter != null)) {
      ((VideoFilterBase)this.headCropRenderItem.filter).ApplyGLSLFilter();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.ApplyGLSLFilter();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject1 = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FacialFeatureFilter)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((FacialFeatureFilter)localObject2).ApplyGLSLFilter();
        }
      }
    }
    if (this.mPhantomFilter != null) {
      this.mPhantomFilter.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter();
    }
    if (this.styleCustomFilterGroup != null) {
      this.styleCustomFilterGroup.apply();
    }
    if (this.cosFunInnerStyleCustomFilterGroup != null) {
      this.cosFunInnerStyleCustomFilterGroup.apply();
    }
    if (this.mComicEffectRenderItems != null)
    {
      localObject1 = this.mComicEffectRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof ComicEffectFilter)) {
          ((ComicEffectFilter)((RenderItem)localObject2).filter).apply();
        }
      }
    }
    if (this.mStyleFilterRenderItems != null)
    {
      localObject1 = this.mStyleFilterRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof AEChainI)) {
          ((AEChainI)((RenderItem)localObject2).filter).apply();
        }
      }
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.ApplyGLSLFilter();
    }
    if (this.filamentParticleFilter != null) {
      this.filamentParticleFilter.init();
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.ApplyGLSLFilter();
    }
    if (this.mActFilters != null) {
      this.mActFilters.ApplyGLSLFilter();
    }
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.ApplyGLSLFilter();
    }
    if (this.multiViewerFilters != null)
    {
      localObject1 = this.multiViewerFilters.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MultiViewerFilter)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((MultiViewerFilter)localObject2).ApplyGLSLFilter();
        }
      }
    }
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).initial();
    }
    if (isMaterialSegmentRequired())
    {
      this.fabbyExtractFilter = new FabbyExtractFilter();
      if ((this.material == null) || ((this.material.getSegmentBorderType() != VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_FLOW_LINES.type) && (this.material.getSegmentBorderType() != VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_TRIGGER.type))) {
        break label1879;
      }
      if (this.material.getSegmentStrokeItem() == null) {
        break label1790;
      }
      localObject1 = new TriggerCtrlItem(this.material.getSegmentStrokeItem());
      this.triggerManager.addTriggers((AETriggerI)localObject1);
      this.fabbyStrokeRenderItem = new RenderItem(new FabbyStrokeFilter(this.material.getSegmentStrokeItem()), (TriggerCtrlItem)localObject1);
    }
    label1879:
    for (;;)
    {
      this.fastBlurFilter = new FastBlurFilter();
      this.fabbyShakeStrokeFilter = new FabbyShakeStrokeFilter();
      this.mMaskFilter = new BaseFilter("mee179x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963604837x1868982638x1931505010x1819307361x1144156773x1886284064x1833530485x1415931745x1970567269x171664754x1768912394x1634541668x690515561x175835680x538976288x1180658791x1130848626x1919904879x1948269856x1970567269x1144153458x1852385312x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x687370x");
      this.fabbyExtractFilter.apply();
      ((FabbyStrokeFilter)this.fabbyStrokeRenderItem.filter).apply();
      this.fastBlurFilter.apply();
      this.fabbyShakeStrokeFilter.apply();
      this.mMaskFilter.apply();
      if (this.mMaskMergeFilter != null) {
        this.mMaskMergeFilter.apply();
      }
      if (this.mFastFaceStickerRenderItems != null)
      {
        localObject1 = this.mFastFaceStickerRenderItems.filter;
        if (localObject1 != null) {
          ((FastStickerFilter)localObject1).ApplyGLSLFilter();
        }
      }
      if (this.mFastBodyStickerRenderItems != null)
      {
        localObject1 = this.mFastBodyStickerRenderItems.filter;
        if (localObject1 != null) {
          ((FastStickerFilter)localObject1).ApplyGLSLFilter();
        }
      }
      localObject1 = this.mEffectTriggerRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof EffectTriggerFilter)) {
          ((EffectTriggerFilter)((RenderItem)localObject2).filter).ApplyGLSLFilter();
        }
      }
      label1790:
      if (this.material.getSegmentStrokeTriggerItems() != null)
      {
        localObject1 = new FabbyStrokeFilterExt(this.material.getSegmentStrokeTriggerItems());
        localObject2 = new FabbyStrokeExtTriggerCtrlItem(this.material.getSegmentStrokeTriggerItems());
        this.triggerManager.addTriggers((AETriggerI)localObject2);
        this.fabbyStrokeRenderItem = new RenderItem((AEFilterI)localObject1, (TriggerCtrlItem)localObject2);
      }
      else
      {
        this.fabbyStrokeRenderItem = new RenderItem(new FabbyStrokeFilter(), null);
        continue;
        this.fabbyStrokeRenderItem = new RenderItem(new FabbyStrokeFilter(), null);
      }
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.apply();
    }
    if (this.snapShotFrameToSticker != null) {
      this.snapShotFrameToSticker.ApplyGLSLFilter();
    }
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new Frame();
      i += 1;
    }
    if (this.fastParticleFilter != null) {
      this.fastParticleFilter.applyGLSLFilter();
    }
    if (this.starOverlayFilter != null) {
      this.starOverlayFilter.apply();
    }
    this.displacementBlurFilter.applyFilterChain(true, 0.0F, 0.0F);
    if (this.mZoomRenderItem != null)
    {
      localObject1 = this.mZoomRenderItem.filter;
      if (localObject1 != null) {
        ((ZoomFilter)localObject1).ApplyGLSLFilter();
      }
    }
    this.mFaceOffNoseOcclusionFilter.ApplyGLSLFilter();
    if (this.mHairCosRenderItem != null)
    {
      localObject1 = this.mHairCosRenderItem.filter;
      if (localObject1 != null) {
        ((HairCos)localObject1).ApplyGLSLFilter();
      }
    }
    if ((this.lutItemsRenderItem != null) && (this.lutItemsRenderItem.filter != null)) {
      ((LutItemsFilter)this.lutItemsRenderItem.filter).apply();
    }
    if ((this.skyboxItemsRenderItem != null) && (this.skyboxItemsRenderItem.filter != null)) {
      ((SkyboxItemsFilter)this.skyboxItemsRenderItem.filter).apply();
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject1 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFilterBase)((RenderItem)((Iterator)localObject1).next()).filter).ApplyGLSLFilter();
      }
    }
    if (this.mCopyMaskFrame != null)
    {
      i = j;
      while (i < this.mCopyMaskFrame.length)
      {
        this.mCopyMaskFrame[i] = new Frame();
        i += 1;
      }
    }
  }
  
  public Frame RenderEffectFilter(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mEffectFilter != null)
    {
      this.mEffectFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      FrameUtil.clearFrame(this.mEffectFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
      this.mEffectFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mEffectFrame);
      localFrame = this.mEffectFrame;
    }
    return localFrame;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if (CollectionUtils.isEmpty(this.renderItems)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame;
    }
    Frame localFrame2;
    int i;
    Frame localFrame1;
    label81:
    VideoFilterBase localVideoFilterBase;
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      i = 0;
      localFrame1 = paramFrame;
      if (i >= this.renderItems.size()) {
        return localFrame1;
      }
      localVideoFilterBase = (VideoFilterBase)((RenderItem)this.renderItems.get(i)).filter;
      if (needRender(localVideoFilterBase)) {
        break label142;
      }
    }
    for (;;)
    {
      i += 1;
      break label81;
      localFrame2 = this.copyFrame[0];
      break;
      label142:
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        Frame localFrame3 = localFrame1;
        if (VideoFilterUtil.needCopy(localVideoFilterBase)) {
          localFrame3 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, this.mCopyFilter, paramFrame, localFrame2);
        }
        if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform())) {
          localFrame1 = VideoFrameUtil.renderProcessByCopy(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, this.mCopyFilter, paramFrame, localFrame2);
        } else {
          localFrame1 = VideoFrameUtil.renderProcessBySwitchFbo(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, paramFrame, localFrame2);
        }
      }
      else
      {
        localVideoFilterBase.OnDrawFrameGLSL();
        localVideoFilterBase.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      }
    }
    return localFrame1;
  }
  
  public void addARFilterGesture()
  {
    if (this.arFilterGesture == null) {
      this.arFilterGesture = new CameraARFilterGesture(this);
    }
    GLGestureProxy.getInstance().addListener(this.arFilterGesture);
  }
  
  public void addMaskTouchPoint(PointF paramPointF)
  {
    if (paramPointF == null) {}
    float f1;
    float f2;
    do
    {
      return;
      if (this.mMaskTouchPoints.size() <= 0) {
        break;
      }
      PointF localPointF = (PointF)this.mMaskTouchPoints.get(this.mMaskTouchPoints.size() - 1);
      f1 = localPointF.x - paramPointF.x;
      f2 = localPointF.y - paramPointF.y;
    } while (Math.abs(f2 * f2 + f1 * f1) < 9.0F);
    this.mMaskTouchPoints.add(paramPointF);
  }
  
  public void addRenderItem(RenderItem paramRenderItem)
  {
    this.renderItems.add(paramRenderItem);
  }
  
  public void addTouchPoint(PointF paramPointF)
  {
    this.mARTouchPointQueue.offer(paramPointF);
  }
  
  public void addTouchPoint(PointF paramPointF, float paramFloat, boolean paramBoolean)
  {
    if (paramPointF == null) {
      return;
    }
    if ((paramBoolean) || (this.mTouchPoints.size() == 0)) {
      this.mTouchPoints.add(new ArrayList());
    }
    ((List)this.mTouchPoints.get(this.mTouchPoints.size() - 1)).add(paramPointF);
    this.mScaleFace = paramFloat;
  }
  
  public void addTransformRenderItem(RenderItem paramRenderItem)
  {
    this.mTransformRenderItems.add(paramRenderItem);
  }
  
  public void arTracked()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).arTracked();
    }
  }
  
  public Frame blurAfterRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    if (this.mBlurMaskFilter != null) {}
    for (paramPTFaceAttr = this.mBlurMaskFilter.renderBlurAfter(paramFrame, paramPTFaceAttr, paramPTSegAttr);; paramPTFaceAttr = paramFrame)
    {
      if (paramFrame != paramPTFaceAttr) {
        paramFrame.unlock();
      }
      return paramPTFaceAttr;
    }
  }
  
  public Frame blurBeforeRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    resetPersonParam(paramPTFaceAttr);
    paramAIAttr = paramFrame;
    if (this.mBlurMaskFilter != null) {
      paramAIAttr = this.mBlurMaskFilter.renderBlurBefore(paramFrame, paramPTFaceAttr, paramPTSegAttr);
    }
    return paramAIAttr;
  }
  
  public void checkNeedARGesture()
  {
    if ((this.material != null) && (this.material.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) && (this.material.isSupportTouchEvent()))
    {
      removeARFilterGesture();
      addARFilterGesture();
    }
  }
  
  public void clearComicEffectFiltersRenderStatus(List<RenderItem> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if ((localRenderItem.filter instanceof ComicEffectFilter)) {
          ((ComicEffectFilter)localRenderItem.filter).setAlreadyRenderInSingleFrame(false);
        }
      }
    }
  }
  
  public void clearEffectTriggerFiltersRenderStatus(List<EffectTriggerFilter> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((EffectTriggerFilter)paramList.next()).setAlreadyRenderInSingleFrame(false);
      }
    }
  }
  
  public void clearRenderItems()
  {
    if (this.renderItems != null) {
      this.renderItems.clear();
    }
  }
  
  public void clearTouchPoint()
  {
    if (this.mMaskTouchPoints != null) {
      this.mMaskTouchPoints.clear();
    }
  }
  
  public void clearTransformRenderItems()
  {
    if (this.mTransformRenderItems != null) {
      this.mTransformRenderItems.clear();
    }
  }
  
  public Frame cosFunFilterGroupRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    if (this.cosFunFilterGroup == null) {
      return paramFrame;
    }
    return this.cosFunFilterGroup.render(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
  }
  
  public void destroy()
  {
    destroyAudio();
    Object localObject1 = this.renderItems.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase))
      {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
        if ((((RenderItem)localObject2).filter instanceof SnapShotFilter)) {
          ((SnapShotFilter)((RenderItem)localObject2).filter).clear();
        }
      }
    }
    localObject1 = this.gestureRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.bodyRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    if (this.mFaceOffRenderItems != null)
    {
      localObject1 = this.mFaceOffRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof FaceOffFilter)) {
          ((FaceOffFilter)localObject2).clearGLSLSelf();
        } else if ((localObject2 instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localObject2).clearGLSLSelf();
        } else if ((localObject2 instanceof FaceOffByImageFilter)) {
          ((FaceOffByImageFilter)localObject2).clearGLSLSelf();
        }
      }
    }
    if (this.catRenderItems != null)
    {
      localObject1 = this.catRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
          ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
        }
      }
    }
    localObject1 = this.qqGestureStaticFilters.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject1).next()).clearGLSLSelf();
    }
    localObject1 = this.qqGestureDynamicFilters.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject1).next()).clearGLSLSelf();
    }
    localObject1 = this.faceParticleDynamicRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.faceParticleStaticRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.gestureParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.bodyParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.starParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.faceGpuParticleDynamicRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.faceGpuParticleStaticRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.gestureGpuParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)((RenderItem)localObject2).filter).clearGLSLSelf();
      }
    }
    localObject1 = this.mBeautyTransformListRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof BeautyTransformList)) {
        ((BeautyTransformList)((RenderItem)localObject2).filter).clear();
      }
    }
    localObject1 = this.mRemodelRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof RemodelFilter)) {
        ((RemodelFilter)((RenderItem)localObject2).filter).clear();
      }
    }
    localObject1 = this.headCropRenderItems.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((VideoFilterBase)((RenderItem)((Iterator)localObject1).next()).filter).clearGLSLSelf();
    }
    localObject1 = this.mEffectTriggerRenderItems.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EffectTriggerFilter)((RenderItem)((Iterator)localObject1).next()).filter).clearGLSLSelf();
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject1 = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject1 != null) {
        ((FabbyFilters)localObject1).clear();
      }
    }
    if (this.mBlurMaskFilter != null)
    {
      this.mBlurMaskFilter.clear();
      this.mBlurMaskFilter = null;
    }
    if (this.mZoomRenderItem != null)
    {
      localObject1 = this.mZoomRenderItem.filter;
      if (localObject1 != null) {
        ((ZoomFilter)localObject1).clear();
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject1 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFilterBase)((RenderItem)((Iterator)localObject1).next()).filter).clearGLSLSelf();
      }
    }
    if (this.mMaskMergeFilter != null) {
      this.mMaskMergeFilter.clearGLSLSelf();
    }
    if (this.multiViewerFilters != null)
    {
      localObject1 = this.multiViewerFilters.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((MultiViewerFilter)((Iterator)localObject1).next()).clear();
      }
    }
    this.mFaceOffNoseOcclusionFilter.clearGLSLSelf();
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).destroy();
    }
    if (this.cosFunFilterGroup != null) {
      this.cosFunFilterGroup.release();
    }
    this.renderFrame.clear();
    this.mEffectFrame.clear();
    this.mMaskStickerFrame.clear();
    this.mMergeMaskFrame.clear();
    if (this.mCopyMaskFrame != null)
    {
      localObject1 = this.mCopyMaskFrame;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          ((Frame)localObject2).clear();
        }
        i += 1;
      }
    }
    this.mHeadCropFrame.clear();
    this.mBgFrame.clear();
    this.fabbyStrokeFrame.clear();
    this.fabbyStrokeShakeFrame.clear();
    this.fabbyFeatheredMaskStep1.clear();
    this.fabbyFeatheredMaskStep2.clear();
    this.mPhantomFrame.clear();
    this.displacementMaskFrame.clear();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      if (this.copyFrame[i] != null) {
        this.copyFrame[i].clear();
      }
      i += 1;
    }
    localObject1 = this.multiViewerFrameMap.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Frame)((Iterator)localObject1).next()).clear();
    }
    this.multiViewerFrameMap.clear();
    this.mvPartsAndMultiViewerFrameMap.clear();
    if (this.fabbyFrameBitmap != null)
    {
      BitmapUtils.recycle(this.fabbyFrameBitmap);
      this.fabbyFrameBitmap = null;
    }
    this.mCopyFilter.ClearGLSL();
    if (this.snapShotFrameToSticker != null) {
      this.snapShotFrameToSticker.clear();
    }
    if ((this.headCropRenderItem != null) && (this.headCropRenderItem.filter != null)) {
      ((VideoFilterBase)this.headCropRenderItem.filter).clearGLSLSelf();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.clear();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject1 = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((FacialFeatureFilter)((Iterator)localObject1).next()).clearGLSLSelf();
      }
    }
    updateDetectorSettingListener(null);
    if (this.mPhantomFilter != null) {
      this.mPhantomFilter.clearGLSLSelf();
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.clear();
    }
    if (this.filamentParticleFilter != null) {
      this.filamentParticleFilter.destroy();
    }
    if (this.mActFilters != null) {
      this.mActFilters.clear();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.clearGLSLSelf();
    }
    if (this.styleCustomFilterGroup != null) {
      this.styleCustomFilterGroup.destroy();
    }
    if (this.cosFunInnerStyleCustomFilterGroup != null) {
      this.cosFunInnerStyleCustomFilterGroup.destroy();
    }
    if (this.mComicEffectRenderItems != null)
    {
      localObject1 = this.mComicEffectRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof ComicEffectFilter)) {
          ((ComicEffectFilter)((RenderItem)localObject2).filter).clearGLSLSelf();
        }
      }
    }
    if (this.mStyleFilterRenderItems != null)
    {
      localObject1 = this.mStyleFilterRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((localObject2 != null) && ((localObject2 instanceof StyleFilterRender))) {
          ((StyleFilterRender)localObject2).clear();
        }
      }
      this.mStyleFilterRenderItems.clear();
      this.mStyleFilterRenderItems = null;
    }
    if (this.fabbyExtractFilter != null) {
      this.fabbyExtractFilter.ClearGLSL();
    }
    if ((this.fabbyStrokeRenderItem != null) && ((this.fabbyStrokeRenderItem.filter instanceof FabbyStrokeFilter))) {
      ((FabbyStrokeFilter)this.fabbyStrokeRenderItem.filter).ClearGLSL();
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.ClearGLSL();
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject1 = this.mFastFaceStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).clearGLSLSelf();
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject1 = this.mFastBodyStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).clearGLSLSelf();
      }
    }
    if (this.fabbyOriginCopyFrame != null) {
      this.fabbyOriginCopyFrame.clear();
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.clearGLSLSelf();
    }
    this.fastParticleFilter.clearGLSLSelf();
    this.starOverlayFilter.ClearGLSL();
    this.starOverlayFrame.clear();
    this.displacementBlurFilter.ClearGLSL();
    if (this.mFrozenRender != null)
    {
      this.mFrozenRender.clear();
      this.mFrozenRender = null;
    }
    destroyAudio();
    if (this.gaussianCompose != null)
    {
      this.gaussianCompose.destroy();
      this.gaussianCompose = null;
    }
    removeARFilterGesture();
    TriggerStateManager.getInstance().clear();
    TouchTriggerManager.getInstance().clear();
    if (this.mHairCosRenderItem != null)
    {
      localObject1 = this.mHairCosRenderItem.filter;
      if (localObject1 != null) {
        ((HairCos)localObject1).clearGLSLSelf();
      }
    }
    if ((this.lutItemsRenderItem != null) && (this.lutItemsRenderItem.filter != null)) {
      ((LutItemsFilter)this.lutItemsRenderItem.filter).clear();
    }
    if ((this.skyboxItemsRenderItem != null) && (this.skyboxItemsRenderItem.filter != null)) {
      ((SkyboxItemsFilter)this.skyboxItemsRenderItem.filter).clear();
    }
    if (this.mMaskTouchPoints != null) {
      this.mMaskTouchPoints.clear();
    }
    if (this.rapidNetRenderItems != null)
    {
      localObject1 = this.rapidNetRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof RapidNetFilter)) {
          ((RapidNetFilter)((RenderItem)localObject2).filter).destroy();
        }
      }
    }
    if (this.styleChildRenderItems != null)
    {
      localObject1 = this.styleChildRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RenderItem)((Iterator)localObject1).next();
        if ((((RenderItem)localObject2).filter instanceof StyleChildFilter)) {
          ((StyleChildFilter)((RenderItem)localObject2).filter).destroy();
        }
      }
    }
  }
  
  public void destroyAudio()
  {
    destroyNormalAudio();
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.destroyAudioPlayer();
    }
    if (this.mActFilters != null) {
      this.mActFilters.destroyAudio();
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject != null) {
        ((FabbyFilters)localObject).destroyAudio();
      }
    }
    Object localObject = this.multiViewerFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MultiViewerFilter)((Iterator)localObject).next()).destroyAudio();
    }
  }
  
  public Frame doFabbyStroke(Frame paramFrame1, Frame paramFrame2)
  {
    return doFabbyStroke(paramFrame1, paramFrame2, null);
  }
  
  public Frame doFabbyStroke(Frame paramFrame1, Frame paramFrame2, PTFaceAttr paramPTFaceAttr)
  {
    if (paramFrame2 == null) {}
    do
    {
      return paramFrame1;
      if ((this.material.getSegmentStrokeWidth() <= 0.0D) && (this.material.getSegmentBorderType() != VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_TRIGGER.type)) {
        break label267;
      }
      if (paramPTFaceAttr == null) {
        break;
      }
      Map localMap = paramPTFaceAttr.getFaceActionCounter();
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      long l = paramPTFaceAttr.getTimeStamp();
      paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      this.fabbyStrokeRenderItem.updatePreview(paramPTFaceAttr);
      paramPTFaceAttr = (FabbyStrokeFilter)this.fabbyStrokeRenderItem.filter;
      paramPTFaceAttr.setmMaskTex(paramFrame2.getTextureId());
      paramPTFaceAttr.setStepX(1.0F / paramFrame1.width);
      paramPTFaceAttr.setStepY(1.0F / paramFrame1.height);
      paramPTFaceAttr.setStrokeGapInPixel((float)this.material.getSegmentStrokeGap() * Math.min(paramFrame1.width, paramFrame1.height));
      paramPTFaceAttr.setStrokeWidthInPixel((float)this.material.getSegmentStrokeWidth() * Math.min(paramFrame1.width, paramFrame1.height));
      paramPTFaceAttr.setStrokeColor(this.material.getSegmentStrokeColor());
    } while ((this.fabbyStrokeRenderItem.triggerCtrlItem != null) && (!this.fabbyStrokeRenderItem.triggerCtrlItem.isTriggered()));
    paramPTFaceAttr.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
    for (;;)
    {
      return this.fabbyStrokeFrame;
      this.fabbyStrokeRenderItem.updatePreview(null);
      break;
      label267:
      if (this.material.getSegmentFeather() > 0)
      {
        int i = paramFrame1.width / 2;
        int j = paramFrame1.height / 2;
        this.fastBlurFilter.updateParams(1.2F / i, 0.0F);
        paramFrame2 = this.fastBlurFilter.RenderProcess(paramFrame2.getTextureId(), i, j);
        this.fastBlurFilter.updateParams(0.0F, 1.2F / j);
        paramPTFaceAttr = this.fastBlurFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame1.width, paramFrame1.height);
        paramFrame2.unlock();
        this.fabbyExtractFilter.setTex(paramPTFaceAttr.getTextureId());
        this.fabbyExtractFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
        paramPTFaceAttr.unlock();
      }
      else
      {
        this.fabbyExtractFilter.setTex(paramFrame2.getTextureId());
        this.fabbyExtractFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
      }
    }
  }
  
  public Frame doFabbyStrokeShake(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3, boolean paramBoolean)
  {
    if (paramFrame2 == null) {
      return paramFrame1;
    }
    Object localObject = this.material;
    this.fabbyStrokeShakeFrame.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    FrameUtil.clearFrame(this.fabbyStrokeShakeFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.fabbyStrokeShakeFrame.width, this.fabbyStrokeShakeFrame.height);
    label103:
    int k;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    int[] arrayOfInt;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    int i;
    if (paramFrame2 != null) {
      if (paramBoolean)
      {
        this.gaussianCompose.drawTexture(paramFrame2.getTextureId());
        this.fabbyShakeStrokeFilter.setmMaskTex(this.gaussianCompose.getTextureId());
        if (paramFrame3 != null) {
          break label326;
        }
        this.fabbyShakeStrokeFilter.setBgTex(paramFrame1.getTextureId());
        this.fabbyShakeStrokeFilter.setFeather(this.material.getSegmentFeather());
        this.fabbyShakeStrokeFilter.setStepX(1.0F / paramFrame1.width);
        this.fabbyShakeStrokeFilter.setStepY(1.0F / paramFrame1.height);
        paramFrame2 = this.material.getSegmentStrokeList();
        k = paramFrame2.size();
        this.fabbyShakeStrokeFilter.setStrokeCount(k);
        if ((((VideoMaterial)localObject).getSegmentBorderType() == -1) || (k <= 0)) {
          break label607;
        }
        paramFrame3 = new float[k * 4];
        localObject = new float[k * 4];
        arrayOfFloat1 = new float[k * 4];
        arrayOfFloat2 = new float[k * 2];
        arrayOfInt = new int[k];
        arrayOfFloat3 = new float[k];
        arrayOfFloat4 = new float[k];
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label545;
      }
      VideoMaterial.SegmentStroke localSegmentStroke = (VideoMaterial.SegmentStroke)paramFrame2.get(i);
      int j = 0;
      for (;;)
      {
        if (j < localSegmentStroke.segmentStrokeColor.length)
        {
          paramFrame3[(localSegmentStroke.segmentStrokeColor.length * i + j)] = localSegmentStroke.segmentStrokeColor[j];
          j += 1;
          continue;
          this.fabbyShakeStrokeFilter.setmMaskTex(paramFrame2.getTextureId());
          break;
          this.fabbyShakeStrokeFilter.setmMaskTex(-1);
          break;
          label326:
          this.fabbyShakeStrokeFilter.setBgTex(paramFrame3.getTextureId());
          break label103;
        }
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeShakeAmplitude.length)
      {
        localObject[(localSegmentStroke.segmentStrokeShakeAmplitude.length * i + j)] = localSegmentStroke.segmentStrokeShakeAmplitude[j];
        j += 1;
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeShakeFrequency.length)
      {
        arrayOfFloat1[(localSegmentStroke.segmentStrokeShakeFrequency.length * i + j)] = localSegmentStroke.segmentStrokeShakeFrequency[j];
        j += 1;
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeOffset.length)
      {
        arrayOfFloat2[(localSegmentStroke.segmentStrokeOffset.length * i + j)] = localSegmentStroke.segmentStrokeOffset[j];
        j += 1;
      }
      arrayOfInt[i] = localSegmentStroke.segmentStrokeType;
      arrayOfFloat3[i] = ((float)localSegmentStroke.segmentStrokeGap * Math.min(paramFrame1.width, paramFrame1.height));
      arrayOfFloat4[i] = ((float)localSegmentStroke.segmentStrokeWidth * Math.min(paramFrame1.width, paramFrame1.height));
      i += 1;
    }
    label545:
    this.fabbyShakeStrokeFilter.setStrokeColorArr(paramFrame3);
    this.fabbyShakeStrokeFilter.setStrokeShakeAmplitudeArr((float[])localObject);
    this.fabbyShakeStrokeFilter.setStrokeShakeFrequencyArr(arrayOfFloat1);
    this.fabbyShakeStrokeFilter.setStrokeOffsetInPixelArr(arrayOfFloat2);
    this.fabbyShakeStrokeFilter.setStrokeTypeArr(arrayOfInt);
    this.fabbyShakeStrokeFilter.setStrokeGapInPixelArr(arrayOfFloat3);
    this.fabbyShakeStrokeFilter.setStrokeWidthInPixelArr(arrayOfFloat4);
    label607:
    this.fabbyShakeStrokeFilter.updateUTime();
    this.fabbyShakeStrokeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeShakeFrame);
    return this.fabbyStrokeShakeFrame;
  }
  
  public void doReset()
  {
    Object localObject1 = this.faceGpuParticleDynamicRenderItems.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof GPUParticleFilter)) {
        ((GPUParticleFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.faceGpuParticleStaticRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof GPUParticleFilter)) {
        ((GPUParticleFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.gestureGpuParticleRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof GPUParticleFilter)) {
        ((GPUParticleFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.renderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)((RenderItem)localObject2).filter).reset();
      }
      if ((((RenderItem)localObject2).filter instanceof TransformFilter)) {
        ((TransformFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    if (this.mFaceOffRenderItems != null)
    {
      localObject1 = this.mFaceOffRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof FaceOffFilter)) {
          ((FaceOffFilter)localObject2).reset();
        }
        if ((localObject2 instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localObject2).reset();
        }
      }
    }
    localObject1 = this.gestureRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.bodyRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.catRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.headCropRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject1 = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject1 != null) {
        ((FabbyFilters)localObject1).reset();
      }
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject1 = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((FacialFeatureFilter)((Iterator)localObject1).next()).reset();
      }
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject1 = this.mFastFaceStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).reset();
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject1 = this.mFastBodyStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).reset();
      }
    }
    localObject1 = this.mEffectTriggerRenderItems.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RenderItem)((Iterator)localObject1).next();
      if ((((RenderItem)localObject2).filter instanceof EffectTriggerFilter)) {
        ((EffectTriggerFilter)((RenderItem)localObject2).filter).reset();
      }
    }
    localObject1 = this.multiViewerFilters.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((MultiViewerFilter)((Iterator)localObject1).next()).reset();
    }
    if (this.mActFilters != null) {
      this.mActFilters.reset();
    }
    AIActionCounter.clearAction(AEDetectorType.HAND);
    AIActionCounter.clearAction(AEDetectorType.VOICE_RECOGNIZE);
    TriggerStateManager.getInstance().reset();
    TouchTriggerManager.getInstance().reset();
    if ((this.fabbyStrokeRenderItem != null) && ((this.fabbyStrokeRenderItem.filter instanceof FabbyStrokeFilterExt))) {
      ((FabbyStrokeFilterExt)this.fabbyStrokeRenderItem.filter).reset();
    }
    if (this.mZoomRenderItem != null)
    {
      localObject1 = this.mZoomRenderItem.filter;
      if (localObject1 != null) {
        ((ZoomFilter)localObject1).reset();
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject1 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((NormalVideoFilter)((RenderItem)((Iterator)localObject1).next()).filter).reset();
      }
    }
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).reset();
    }
    if (this.cosFunFilterGroup != null) {
      this.cosFunFilterGroup.reset();
    }
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.reset();
    }
    this.triggerManager.reset();
  }
  
  public boolean exportFilamentParams()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      return ((FilamentFilter)this.filamentRenderItem.filter).exportParams();
    }
    return false;
  }
  
  public AIAttr getAiAttr()
  {
    return this.aiAttr;
  }
  
  public StyleCustomFilterGroup getCosFunInnerStyleCustomFilterGroup()
  {
    return this.cosFunInnerStyleCustomFilterGroup;
  }
  
  public double getCosFunProgress()
  {
    if ((this.cosFunFilterGroup != null) && (this.cosFunFilterGroup.getItemCount() > 0)) {
      return (this.cosFunFilterGroup.getItemIndex() + 0.5D) / this.cosFunFilterGroup.getItemCount();
    }
    return 0.0D;
  }
  
  public CrazyFaceFilters getCrazyFaceFilters()
  {
    return this.crazyFaceFilters;
  }
  
  public VideoFilterBase getEffectFilter()
  {
    return this.mEffectFilter;
  }
  
  public List<EffectTriggerFilter> getEffectTriggerFilters()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mEffectTriggerRenderItems != null)
    {
      Iterator localIterator = this.mEffectTriggerRenderItems.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((EffectTriggerFilter)((RenderItem)localIterator.next()).filter);
      }
    }
    return localArrayList;
  }
  
  public List<Integer> getFaceIndexes()
  {
    if (!CollectionUtils.isEmpty(this.mFaceList))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mFaceList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Integer.valueOf(((Face)localIterator.next()).faceIndex));
      }
      return localArrayList;
    }
    return null;
  }
  
  public FastStickerFilter getFastBodyStickerFilter()
  {
    if (this.mFastBodyStickerRenderItems != null) {
      return (FastStickerFilter)this.mFastBodyStickerRenderItems.filter;
    }
    return null;
  }
  
  public FastStickerFilter getFastFaceStickerFilter()
  {
    if (this.mFastFaceStickerRenderItems != null) {
      return (FastStickerFilter)this.mFastFaceStickerRenderItems.filter;
    }
    return null;
  }
  
  public float[] getFilamentAssetPosition()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      return ((FilamentFilter)this.filamentRenderItem.filter).getFilamentAssetPosition();
    }
    return null;
  }
  
  public List<VideoFilterBase> getFilters()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.renderItems != null)
    {
      Iterator localIterator = this.renderItems.iterator();
      while (localIterator.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)localIterator.next();
        if ((localRenderItem.filter != null) && ((localRenderItem.filter instanceof VideoFilterBase))) {
          localArrayList.add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    return localArrayList;
  }
  
  public PTFaceAttr getFreezeFaceInfo()
  {
    if (isFreezeFrame()) {
      return this.mFrozenRender.getPTFaceSnapshot();
    }
    return null;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public int getOnlyDetectOneGesture()
  {
    return this.onlyDetectOneGesture;
  }
  
  public List<RenderItem> getRenderItems()
  {
    return this.renderItems;
  }
  
  public int getSegmentBorderType()
  {
    return this.material.getSegmentBorderType();
  }
  
  public List<VideoFilterBase> getTransformFilters()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mTransformRenderItems != null)
    {
      Iterator localIterator = this.mTransformRenderItems.iterator();
      while (localIterator.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)localIterator.next();
        if ((localRenderItem.filter != null) && ((localRenderItem.filter instanceof VideoFilterBase))) {
          localArrayList.add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    return localArrayList;
  }
  
  public TriggerManager getTriggerManager()
  {
    return this.triggerManager;
  }
  
  public int getVideoEffectOrder()
  {
    return this.mEffectOrder;
  }
  
  public BlurMaskFilter getmBlurMaskFilter()
  {
    return this.mBlurMaskFilter;
  }
  
  public boolean hasCosFunGroup()
  {
    return this.cosFunFilterGroup != null;
  }
  
  public boolean hasFreezeSetting()
  {
    if (this.hasFreezeFrameStatus >= 0)
    {
      if (this.hasFreezeFrameStatus == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    if (this.mFrozenRender != null)
    {
      this.hasFreezeFrameStatus = 1;
      return true;
    }
    if (this.multiViewerFilters != null)
    {
      Iterator localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        if (((MultiViewerFilter)localIterator.next()).hasFreezeFrameSetting())
        {
          this.hasFreezeFrameStatus = 1;
          return true;
        }
      }
    }
    this.hasFreezeFrameStatus = 0;
    return false;
  }
  
  public boolean hasHands(PTHandAttr paramPTHandAttr)
  {
    if (paramPTHandAttr == null) {}
    Object localObject1;
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          return false;
          localObject1 = paramPTHandAttr.getHandPointList();
          Object localObject2;
          if ((localObject1 != null) && (((List)localObject1).size() > 0) && (this.gestureRenderItems != null) && (this.gestureRenderItems.size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (PointF)((Iterator)localObject1).next();
              float f1 = ((PointF)localObject2).x;
              float f2 = ((PointF)localObject2).x;
              float f3 = ((PointF)localObject2).y;
              if (((PointF)localObject2).y * f3 + f1 * f2 >= 0.0001D)
              {
                localObject2 = ((RenderItem)this.gestureRenderItems.get(0)).filter;
                if (((localObject2 instanceof NormalVideoFilter)) && (localObject2 != null) && (((NormalVideoFilter)localObject2).getStickerItem() != null) && (TriggerUtil.isGestureTriggered(paramPTHandAttr, ((NormalVideoFilter)localObject2).getStickerItem().getTriggerTypeInt(), 0, 0, null, null))) {
                  return true;
                }
              }
            }
          }
          if (this.mFacialFeatureFilterList != null)
          {
            localObject1 = this.mFacialFeatureFilterList.iterator();
            do
            {
              while (!((Iterator)localObject2).hasNext())
              {
                do
                {
                  do
                  {
                    if (!((Iterator)localObject1).hasNext()) {
                      break;
                    }
                    localObject2 = (FacialFeatureFilter)((Iterator)localObject1).next();
                  } while ((localObject2 == null) || (((FacialFeatureFilter)localObject2).getCharmGestureTypes() == null));
                  localObject2 = ((FacialFeatureFilter)localObject2).getCharmGestureTypes();
                } while ((localObject2 == null) || (((List)localObject2).size() == 0));
                localObject2 = ((List)localObject2).iterator();
              }
            } while (!TriggerUtil.isGestureTriggered(paramPTHandAttr, ((Integer)((Iterator)localObject2).next()).intValue(), 0, 0, null, null));
            return true;
          }
        } while (this.multiViewerFilters == null);
        localObject1 = this.multiViewerFilters.iterator();
      }
    } while (!((MultiViewerFilter)((Iterator)localObject1).next()).hasHand(paramPTHandAttr));
    return true;
  }
  
  public boolean hasParticleFilter()
  {
    if (this.renderItems != null)
    {
      Iterator localIterator = this.renderItems.iterator();
      while (localIterator.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)localIterator.next();
        if (((localRenderItem.filter instanceof ParticleFilter)) || ((localRenderItem.filter instanceof ParticleFilter3D))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasVoiceTextFilter()
  {
    if (this.renderItems != null)
    {
      Iterator localIterator = this.renderItems.iterator();
      while (localIterator.hasNext()) {
        if ((((RenderItem)localIterator.next()).filter instanceof VoiceTextFilter)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasZoomFilter()
  {
    return (this.mZoomRenderItem != null) && (this.mZoomRenderItem.filter != null);
  }
  
  public boolean isAllFreezeFrame()
  {
    boolean bool2;
    boolean bool1;
    if (this.mFrozenRender != null)
    {
      bool2 = this.mFrozenRender.isFreeze();
      bool1 = bool2;
      if (this.multiViewerFilters != null)
      {
        if (this.multiViewerFilters.size() != 0) {
          break label45;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      setAllFrameFreeze(bool1);
      return bool1;
      label45:
      if ((bool2) && (isAllMultiViewrsFreeze()))
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
        continue;
        bool1 = isAllMultiViewrsFreeze();
      }
    }
  }
  
  public boolean isAllMultiViewrsFreeze()
  {
    if ((this.multiViewerFilters == null) || (this.multiViewerFilters.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewerFilter)localIterator.next()).isFreezeFrame() == 1) {
        return false;
      }
    }
    return hasFreezeSetting();
  }
  
  public boolean isCosFunEnableGAN()
  {
    return this.cosFunEnableGAN;
  }
  
  public boolean isDualPeople()
  {
    if (this.material != null) {
      return this.material.isDualPeople;
    }
    return false;
  }
  
  public boolean isFilamentModelReady()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      return ((FilamentFilter)this.filamentRenderItem.filter).isModelReady();
    }
    return false;
  }
  
  public boolean isFreezeFrame()
  {
    if (this.mFrozenRender == null) {
      return false;
    }
    return this.mFrozenRender.isFreeze();
  }
  
  public boolean isGpuParticleDismiss()
  {
    if (this.material == null) {}
    for (;;)
    {
      return false;
      List localList = this.material.getItemList();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          StickerItem localStickerItem = (StickerItem)localList.get(i);
          if ((localStickerItem.gpuParticleConfig != null) && (("*".equals(localStickerItem.gpuParticleConfig.startColorReference)) || ((localStickerItem.gpuParticleConfig.backgroundConfig != null) && ("*".equals(localStickerItem.gpuParticleConfig.backgroundConfig.texture))))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean isHairSegmentRequired()
  {
    return (this.mHairCosRenderItem != null) && (this.mHairCosRenderItem.filter != null);
  }
  
  public boolean isMaterialSegmentRequired()
  {
    if (this.material == null) {
      return false;
    }
    return this.material.isSegmentRequired();
  }
  
  public boolean isNeedDetectGestureBonePoint()
  {
    return (this.needDetectGestureBonePoint) || (multiViewNeedDetectGestureBonePoint());
  }
  
  public boolean isSegmentRequired()
  {
    boolean bool2 = false;
    if (this.mBlurMaskFilter != null) {}
    for (boolean bool1 = this.mBlurMaskFilter.isRequiedSegment();; bool1 = false)
    {
      if ((!isMaterialSegmentRequired()) && (!bool1))
      {
        bool1 = bool2;
        if (!isMultViewSegmentRequired()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public boolean isSupportPause()
  {
    if (this.material == null) {
      return false;
    }
    return this.material.isSupportPause();
  }
  
  public boolean isUseMesh()
  {
    return this.material.isUseMesh();
  }
  
  public boolean multiViewNeedDetectGesture()
  {
    if (this.multiViewerFilters == null) {
      return false;
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewerFilter)localIterator.next()).needDetectGesture()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean multiViewNeedDetectGestureBonePoint()
  {
    if (this.multiViewerFilters == null) {
      return false;
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewerFilter)localIterator.next()).needDetectGestureBonePoint()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean needDetectEmotion()
  {
    return (this.needDetectEmotion) || (isMultViewDetectEmotion());
  }
  
  public boolean needDetectGender()
  {
    return (this.needDetectGender) || (isMultiViewDetectGender());
  }
  
  public boolean needDetectGesture()
  {
    return (this.needDetectGesture) || (multiViewNeedDetectGesture());
  }
  
  public boolean needFaceInfo(int paramInt)
  {
    paramInt = (paramInt + 360) % 360;
    return ((paramInt != 90) && (paramInt != 270)) || (this.material.isSupportLandscape());
  }
  
  public boolean needShookHeadCount()
  {
    return (getMaterial() != null) && (getMaterial().isShookHeadPendant());
  }
  
  public void onPause()
  {
    destroyAudio();
    setBlurMaskPause(true);
  }
  
  public void onResume()
  {
    if (this.mActFilters != null) {
      this.mActFilters.reset(System.currentTimeMillis());
    }
    setBlurMaskPause(false);
  }
  
  public void pauseAnimaiton()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).pauseAnimation();
    }
  }
  
  public Frame processTransformRelatedFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    this.directDraw = false;
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localObject1 != null)
    {
      localSet.add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
      if (localObject1 == null) {}
    }
    for (List localList = ((PTHandAttr)localObject1).getHandPointList();; localList = null)
    {
      Object localObject2 = new ArrayList();
      if ((VideoMaterialUtil.isBodyDetectMaterial(this.material)) && (this.aiAttr != null)) {
        localObject2 = getBodyPoints(this.aiAttr);
      }
      for (;;)
      {
        long l = paramPTFaceAttr.getTimeStamp();
        int j = Math.min(this.mFaceList.size(), getMaterial().getMaxFaceCount());
        GlUtil.setBlendMode(true);
        if (j <= 0)
        {
          localObject1 = new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
          updateRenderItems((PTDetectInfo)localObject1, this.mFaceOffRenderItems);
          updateRenderItems((PTDetectInfo)localObject1, this.mTransformRenderItems);
          updateRenderItems((PTDetectInfo)localObject1, this.mBeautyTransformListRenderItems);
          updateRenderItems((PTDetectInfo)localObject1, this.mRemodelRenderItems);
        }
        hitStaticFaceRandomGroupItem();
        int i = 0;
        Object localObject3;
        Object localObject4;
        PTDetectInfo localPTDetectInfo;
        if (i < j)
        {
          localObject3 = (Face)this.mFaceList.get(i);
          setCurPersonId(((Face)localObject3).faceIndex);
          setCurGender(((Face)localObject3).gender);
          hitCharmRangeItem(((Face)localObject3).faceIndex);
          hitDynamicFaceRandomGroupItem(((Face)localObject3).faceIndex);
          hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject3).faceIndex);
          hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject3).faceIndex);
          hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject3).faceIndex);
          hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject3).faceIndex, j);
          if (paramPTFaceAttr.getTransformFacePoints() != null)
          {
            localObject1 = (List)paramPTFaceAttr.getTransformFacePoints().get(i);
            localObject4 = new PTDetectInfo.Builder().facePoints(((Face)localObject3).facePoints).faceAngles(((Face)localObject3).faceAngles).triggeredExpression(localSet).aiAttr(this.aiAttr).timestamp(l).pointsVis(((Face)localObject3).facePointVis).handPoints(localList).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).bodyPoints((List)localObject2).transformPoints((List)localObject1).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).phoneAngle(paramPTFaceAttr.getRotation()).realPhoneAngle(paramPTFaceAttr.getSrcRotation()).faceDetector(paramPTFaceAttr.getFaceDetector());
            localObject1 = (PointF)((Face)localObject3).facePoints.get(63);
            if (((paramPTFaceAttr.getFacePiont2DCenter() == null) || (((PointF)localObject1).x != paramPTFaceAttr.getFacePiont2DCenter().x) || (((PointF)localObject1).y != paramPTFaceAttr.getFacePiont2DCenter().y)) || ((paramPTFaceAttr.getFace3DVerticesArray() != null) && (paramPTFaceAttr.getFace3DVerticesArray().size() > 0))) {
              ((PTDetectInfo.Builder)localObject4).face3DVerticesArray((float[])paramPTFaceAttr.getFace3DVerticesArray().get(0));
            }
            if ((paramPTFaceAttr.getFace3DRotationArray() != null) && (paramPTFaceAttr.getFace3DRotationArray().size() > 0)) {
              ((PTDetectInfo.Builder)localObject4).face3DRotationArray((float[])paramPTFaceAttr.getFace3DRotationArray().get(0));
            }
            localPTDetectInfo = null;
            localObject1 = localPTDetectInfo;
            if (this.mFaceOffRenderItems != null)
            {
              localObject1 = localPTDetectInfo;
              if (this.mFaceOffRenderItems.size() > 0)
              {
                localObject1 = new PTDetectInfo.Builder().facePoints(((Face)localObject3).facePoints).faceAngles(((Face)localObject3).faceAngles).build();
                this.mFaceOffNoseOcclusionFilter.updatePreview(localObject1);
                localObject1 = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
                FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
                this.mFaceOffNoseOcclusionFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, (Frame)localObject1);
                ((PTDetectInfo.Builder)localObject4).noseOcclusionFrame((Frame)localObject1);
              }
            }
            localPTDetectInfo = ((PTDetectInfo.Builder)localObject4).build();
            if (this.mFaceOffRenderItems == null) {
              break label1364;
            }
            FaceOffFilterManager.getInstance().updateIndex();
            updateRenderItems(localPTDetectInfo, this.mFaceOffRenderItems, j, i);
            paramFrame = RenderProcessForRenderItems(paramFrame, this.mFaceOffRenderItems);
          }
        }
        label1364:
        for (;;)
        {
          if (localObject1 != null) {
            ((Frame)localObject1).unlock();
          }
          if (this.mFacialFeatureFilterList != null)
          {
            GlUtil.setBlendMode(false);
            localObject1 = this.mFacialFeatureFilterList.iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                ((FacialFeatureFilter)((Iterator)localObject1).next()).updateStickerFilterList(((Face)localObject3).facePoints, localList, (List)localObject2, ((Face)localObject3).faceAngles, paramFrame);
                continue;
                localObject1 = null;
                break;
              }
            }
            GlUtil.setBlendMode(true);
          }
          localObject1 = paramFrame;
          if (this.mTransformRenderItems != null)
          {
            localObject1 = new ArrayList();
            localObject3 = this.mTransformRenderItems.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (RenderItem)((Iterator)localObject3).next();
              if ((localObject4 != null) && (((RenderItem)localObject4).filter != null))
              {
                Object localObject5 = (TransformFilter)((RenderItem)localObject4).filter;
                ((TransformFilter)localObject5).setNeedReCaculateFace(this.material.isNeedReCaculateFace());
                localObject5 = ((TransformFilter)localObject5).getFaceMeshItem();
                if ((localObject5 == null) || (((FaceMeshItem)localObject5).genderType <= 0) || (this.mCurPersonParam.isGenderMatch(((FaceMeshItem)localObject5).genderType))) {
                  ((List)localObject1).add(localObject4);
                }
              }
            }
            updateRenderItems(localPTDetectInfo, (List)localObject1);
            localObject1 = RenderProcessForRenderItems(paramFrame, (List)localObject1);
          }
          paramFrame = (Frame)localObject1;
          if (this.mBeautyTransformListRenderItems != null)
          {
            localObject3 = this.mBeautyTransformListRenderItems.iterator();
            for (;;)
            {
              paramFrame = (Frame)localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              paramFrame = (RenderItem)((Iterator)localObject3).next();
              if ((paramFrame != null) && (paramFrame.filter != null))
              {
                localObject4 = (BeautyTransformList)paramFrame.filter;
                ((BeautyTransformList)localObject4).setNeedReCaculateFace(this.material.isNeedReCaculateFace());
                localObject4 = ((BeautyTransformList)localObject4).getFaceBeautyItem();
                if ((localObject4 == null) || (((FaceBeautyItem)localObject4).genderType <= 0) || (this.mCurPersonParam.isGenderMatch(((FaceBeautyItem)localObject4).genderType)))
                {
                  paramFrame.updatePreview(localPTDetectInfo);
                  paramFrame = paramFrame.RenderProcess((Frame)localObject1);
                  if (paramFrame != localObject1) {
                    ((Frame)localObject1).unlock();
                  }
                  localObject1 = paramFrame;
                }
              }
            }
          }
          GlUtil.setBlendMode(false);
          localObject1 = paramFrame;
          if (this.mRemodelRenderItems != null)
          {
            localObject3 = this.mRemodelRenderItems.iterator();
            for (;;)
            {
              localObject1 = paramFrame;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject1 = (RenderItem)((Iterator)localObject3).next();
              if ((localObject1 != null) && (((RenderItem)localObject1).filter != null))
              {
                localObject4 = (RemodelFilter)((RenderItem)localObject1).filter;
                ((RemodelFilter)localObject4).setNeedReCaculateFace(this.material.isNeedReCaculateFace());
                localObject4 = ((RemodelFilter)localObject4).getFaceBeautyItem();
                if ((localObject4 == null) || (((FaceBeautyItem)localObject4).genderType <= 0) || (this.mCurPersonParam.isGenderMatch(((FaceBeautyItem)localObject4).genderType)))
                {
                  ((RenderItem)localObject1).updatePreview(localPTDetectInfo);
                  paramFrame = ((RenderItem)localObject1).RenderProcess(paramFrame);
                }
              }
            }
          }
          GlUtil.setBlendMode(true);
          paramFrame = (Frame)localObject1;
          if (this.mFacialFeatureFilterList != null)
          {
            localObject3 = this.mFacialFeatureFilterList.iterator();
            for (;;)
            {
              paramFrame = (Frame)localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              paramFrame = ((FacialFeatureFilter)((Iterator)localObject3).next()).getStickerRenderItems();
              updateRenderItems(localPTDetectInfo, paramFrame);
              localObject1 = RenderProcessForRenderItems((Frame)localObject1, paramFrame);
            }
          }
          i += 1;
          break;
          resetPersonParam(paramPTFaceAttr);
          GlUtil.setBlendMode(false);
          return paramFrame;
        }
      }
    }
  }
  
  public void removeARFilterGesture()
  {
    if (this.arFilterGesture != null) {
      GLGestureProxy.getInstance().removeListener(this.arFilterGesture);
    }
  }
  
  public boolean render3DFirst()
  {
    return this.material.getOrderMode() == 2;
  }
  
  public void renderARFilterIfNeeded(Frame paramFrame)
  {
    if (this.mARParticleFilter != null)
    {
      GlUtil.setBlendMode(true);
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      while (!this.mARTouchPointQueue.isEmpty())
      {
        PointF localPointF = (PointF)this.mARTouchPointQueue.poll();
        if (localPointF != null) {
          this.mARParticleFilter.addTouchPoint(localPointF);
        }
      }
      this.mARParticleFilter.updateAndRender(paramFrame);
      GlUtil.setBlendMode(false);
    }
  }
  
  public Frame renderCosFunCustomGroup(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.cosFunInnerStyleCustomFilterGroup != null) {
      localFrame = this.cosFunInnerStyleCustomFilterGroup.render(paramFrame);
    }
    return localFrame;
  }
  
  public Frame renderCustomEffectFilter(Frame paramFrame, int paramInt)
  {
    Frame localFrame = paramFrame;
    if (this.mEffectOrder == paramInt)
    {
      localFrame = paramFrame;
      if (this.mEffectFilter != null)
      {
        localFrame = paramFrame;
        if ((this.mEffectFilter instanceof CustomVideoFilter))
        {
          this.mEffectFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
          FrameUtil.clearFrame(this.mEffectFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
          this.mEffectFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mEffectFrame);
          localFrame = this.mEffectFrame;
        }
      }
    }
    return localFrame;
  }
  
  public Frame renderCustomGroup(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.styleCustomFilterGroup != null) {
      localFrame = this.styleCustomFilterGroup.render(paramFrame);
    }
    return localFrame;
  }
  
  public void renderDisplacementBlurMask(PTFaceAttr paramPTFaceAttr, Frame paramFrame)
  {
    if ((this.material.getItemList() != null) && (!this.material.getItemList().isEmpty()))
    {
      float f = Math.min(1.0F, 360.0F / Math.min(paramFrame.width, paramFrame.height));
      int i = Math.round(paramFrame.width * f);
      int j = Math.round(f * paramFrame.height);
      this.displacementBlurFilter.updateParam(paramPTFaceAttr, paramFrame.width, paramFrame.height);
      this.displacementBlurFilter.RenderProcess(paramFrame.getTextureId(), i, j, -1, 0.0D, this.displacementMaskFrame);
    }
  }
  
  public Frame renderEffectFilter(Frame paramFrame, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      Frame localFrame = paramFrame;
      if (i < j)
      {
        int k = paramVarArgs[i];
        if (this.mEffectOrder != k) {
          break label109;
        }
        localFrame = paramFrame;
        if (this.mEffectFilter != null)
        {
          this.mEffectFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
          FrameUtil.clearFrame(this.mEffectFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
          this.mEffectFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mEffectFrame);
          localFrame = this.mEffectFrame;
        }
      }
      return localFrame;
      label109:
      i += 1;
    }
  }
  
  public Bitmap renderForBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.renderItems == null) {
      return RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3);
    }
    GlUtil.setBlendMode(true);
    Frame localFrame2 = new Frame();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame2);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramInt1 = 0;
    Frame localFrame1 = localFrame2;
    if (paramInt1 < this.renderItems.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)((RenderItem)this.renderItems.get(paramInt1)).filter;
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        localObject = localFrame1;
        if (VideoFilterUtil.needCopy(localVideoFilterBase)) {
          localObject = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), paramInt2, paramInt3, this.mCopyFilter, localFrame2, this.copyFrame[0]);
        }
        localFrame1 = VideoFrameUtil.renderProcessBySwitchFbo(((Frame)localObject).getTextureId(), paramInt2, paramInt3, localVideoFilterBase, localFrame2, this.copyFrame[0]);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localVideoFilterBase.OnDrawFrameGLSL();
        localVideoFilterBase.renderTexture(localFrame1.getTextureId(), paramInt2, paramInt3);
      }
    }
    GlUtil.setBlendMode(false);
    Object localObject = RendererUtils.saveTexture(localFrame1.getTextureId(), paramInt2, paramInt3);
    localFrame1.clear();
    return localObject;
  }
  
  public int renderOder()
  {
    int j = 0;
    int i = j;
    if (this.material != null)
    {
      i = j;
      if (this.material.getGlbList() != null)
      {
        i = j;
        if (this.material.getGlbList().size() > 0) {
          i = ((GLBItemJava)this.material.getGlbList().get(0)).order;
        }
      }
    }
    return i;
  }
  
  public boolean renderStaticStickerFirst()
  {
    return this.material.getStickerOrderMode() == 1;
  }
  
  public boolean reset()
  {
    if ((!this.material.isResetWhenStartRecord()) && (!this.material.isHasCosFun())) {
      return false;
    }
    doReset();
    return true;
  }
  
  public void resetPersonParam(PTFaceAttr paramPTFaceAttr)
  {
    boolean bool1 = false;
    boolean bool2;
    FaceStatus localFaceStatus;
    if ((paramPTFaceAttr != null) && (paramPTFaceAttr.getFaceStatusList() != null))
    {
      paramPTFaceAttr = paramPTFaceAttr.getFaceStatusList().iterator();
      bool2 = false;
      bool1 = false;
      if (paramPTFaceAttr.hasNext())
      {
        localFaceStatus = (FaceStatus)paramPTFaceAttr.next();
        if (localFaceStatus.gender == GenderType.FEMALE.value)
        {
          bool1 = bool2;
          bool2 = true;
          label65:
          if ((!bool1) || (!bool2)) {
            break label108;
          }
        }
      }
    }
    for (;;)
    {
      this.mCurPersonParam.resetParam(bool2, bool1);
      return;
      if (localFaceStatus.gender == GenderType.MALE.value)
      {
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
        break label65;
        label108:
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        break;
      }
      boolean bool3 = bool1;
      bool1 = bool2;
      bool2 = bool3;
      break label65;
      bool3 = bool1;
      bool1 = bool2;
      bool2 = bool3;
      continue;
      bool2 = false;
    }
  }
  
  public void resumeAnimation()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).resumeAnimation();
    }
  }
  
  public void setARParticleFilter(ARParticleFilter paramARParticleFilter)
  {
    this.mARParticleFilter = paramARParticleFilter;
  }
  
  public void setActFilter(ActFilters paramActFilters)
  {
    this.mActFilters = paramActFilters;
  }
  
  public void setAiAttr(AIAttr paramAIAttr)
  {
    this.aiAttr = paramAIAttr;
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewerFilter)localIterator.next()).getVideoFilterList().setAiAttr(paramAIAttr);
    }
  }
  
  public void setAllFrameFreeze(boolean paramBoolean)
  {
    if (this.mFrozenRender != null) {
      this.mFrozenRender.setAllFrameFreeze(paramBoolean);
    }
    if (this.multiViewerFilters != null)
    {
      Iterator localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setAllFrameFreeze(paramBoolean);
      }
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject = this.mFastFaceStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).setAudioPause(paramBoolean);
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject = this.mFastBodyStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).setAudioPause(paramBoolean);
      }
    }
    Object localObject = this.renderItems.iterator();
    RenderItem localRenderItem;
    while (((Iterator)localObject).hasNext())
    {
      localRenderItem = (RenderItem)((Iterator)localObject).next();
      if ((localRenderItem.filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localRenderItem.filter).setAudioPause(paramBoolean);
      }
    }
    localObject = this.gestureRenderItems.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localRenderItem = (RenderItem)((Iterator)localObject).next();
      if ((localRenderItem.filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localRenderItem.filter).setAudioPause(paramBoolean);
      }
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject != null) {
        ((FabbyFilters)localObject).setAudioPause(paramBoolean);
      }
    }
    if (this.catRenderItems != null)
    {
      localObject = this.catRenderItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject).next();
        if ((localRenderItem.filter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localRenderItem.filter).setAudioPause(paramBoolean);
        }
      }
    }
    if (this.mActFilters != null) {
      this.mActFilters.setAudioPause(paramBoolean);
    }
    if (this.multiViewerFilters != null)
    {
      localObject = this.multiViewerFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MultiViewerFilter)((Iterator)localObject).next()).setAudioPause(paramBoolean);
      }
    }
  }
  
  public void setBeautyTransformListRenderItems(List<RenderItem> paramList)
  {
    this.mBeautyTransformListRenderItems = paramList;
  }
  
  public void setBlurMaskFilter(BlurMaskFilter paramBlurMaskFilter)
  {
    this.mBlurMaskFilter = paramBlurMaskFilter;
  }
  
  public void setBlurMaskPause(boolean paramBoolean)
  {
    if (this.mBlurMaskFilter != null)
    {
      if (paramBoolean) {
        this.mBlurMaskFilter.pauseMask();
      }
    }
    else {
      return;
    }
    this.mBlurMaskFilter.resumeMask();
  }
  
  public void setBodyParticleRenderItems(List<RenderItem> paramList)
  {
    this.bodyParticleRenderItems = paramList;
  }
  
  public void setBodyRenderItems(List<RenderItem> paramList)
  {
    this.bodyRenderItems = paramList;
  }
  
  public void setCatRenderItems(List<RenderItem> paramList)
  {
    this.catRenderItems = paramList;
  }
  
  public void setComicEffectRenderItems(List<RenderItem> paramList)
  {
    this.mComicEffectRenderItems = paramList;
  }
  
  public void setCosFunEnableGAN(boolean paramBoolean)
  {
    this.cosFunEnableGAN = paramBoolean;
  }
  
  public void setCosFunFilterGroup(CosFunFilterGroup paramCosFunFilterGroup)
  {
    this.cosFunFilterGroup = paramCosFunFilterGroup;
  }
  
  public void setCosFunInnerStyleCustomFilterGroup(StyleCustomFilterGroup paramStyleCustomFilterGroup)
  {
    this.cosFunInnerStyleCustomFilterGroup = paramStyleCustomFilterGroup;
  }
  
  public void setCrazyFaceFilters(CrazyFaceFilters paramCrazyFaceFilters)
  {
    this.crazyFaceFilters = paramCrazyFaceFilters;
  }
  
  public void setCurGender(int paramInt)
  {
    this.mCurPersonParam.setGenderType(paramInt);
  }
  
  public void setCurPartInMultView(int paramInt)
  {
    this.mCurMVPart = paramInt;
  }
  
  public void setCurPersonId(int paramInt)
  {
    this.mCurPersonParam.setPersonID(paramInt);
  }
  
  public void setCyberpunkFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    if (this.mStyleFilterRenderItems != null)
    {
      Iterator localIterator = this.mStyleFilterRenderItems.iterator();
      while (localIterator.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)localIterator.next();
        if ((localRenderItem != null) && ((localRenderItem.filter instanceof CyberpunkFilter))) {
          ((CyberpunkFilter)localRenderItem.filter).setFaceAttr(paramPTFaceAttr);
        }
      }
    }
  }
  
  public void setDownEventUnProjectionPoint(ArrayList<float[]> paramArrayList)
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).setDownEventUnProjectionPoint(paramArrayList);
    }
  }
  
  public void setFabbyFrameForGpuParticle(Bitmap paramBitmap)
  {
    this.fabbyFrameBitmap = paramBitmap;
  }
  
  public void setFabbyMvFiltersRenderItem(RenderItem paramRenderItem)
  {
    this.mFabbyMvFiltersRenderItem = paramRenderItem;
  }
  
  public void setFaceGpuParticleRenderItems(List<RenderItem> paramList)
  {
    this.faceGpuParticleDynamicRenderItems = getStickerRenderItems(paramList, false, true);
    this.faceGpuParticleStaticRenderItems = getStickerRenderItems(paramList, true, true);
  }
  
  public void setFaceParticleRenderItems(List<RenderItem> paramList)
  {
    this.faceParticleDynamicRenderItems = getStickerRenderItems(paramList, false, true);
    this.faceParticleStaticRenderItems = getStickerRenderItems(paramList, true, true);
  }
  
  public void setFacialFeatureFilterList(List<FacialFeatureFilter> paramList)
  {
    this.mFacialFeatureFilterList = paramList;
  }
  
  public void setFastBodyStickerRenderItems(RenderItem paramRenderItem)
  {
    this.mFastBodyStickerRenderItems = paramRenderItem;
  }
  
  public void setFastFaceStickerRenderItems(RenderItem paramRenderItem)
  {
    this.mFastFaceStickerRenderItems = paramRenderItem;
  }
  
  public void setFilamentFilterFrames()
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).setFrames(this.mvPartsAndMultiViewerFrameMap);
    }
  }
  
  public void setFilamentParticleFilter(FilamentParticleFilter paramFilamentParticleFilter)
  {
    this.filamentParticleFilter = paramFilamentParticleFilter;
  }
  
  public void setFilamentRenderItem(RenderItem paramRenderItem)
  {
    this.filamentRenderItem = paramRenderItem;
  }
  
  public void setFrozenFrameRender(FrozenFrameRender paramFrozenFrameRender)
  {
    this.mFrozenRender = paramFrozenFrameRender;
  }
  
  public void setGestureGpuParticleRenderItems(List<RenderItem> paramList)
  {
    this.gestureGpuParticleRenderItems = paramList;
  }
  
  public void setGestureParticleRenderItems(List<RenderItem> paramList)
  {
    this.gestureParticleRenderItems = paramList;
  }
  
  public void setGestureRenderItems(List<RenderItem> paramList)
  {
    this.gestureRenderItems = paramList;
  }
  
  public void setHairCosRenderItem(RenderItem paramRenderItem)
  {
    this.mHairCosRenderItem = paramRenderItem;
  }
  
  public void setHeadCropRenderItem(RenderItem paramRenderItem)
  {
    this.headCropRenderItem = paramRenderItem;
  }
  
  public void setHeadCropRenderItems(List<RenderItem> paramList)
  {
    this.headCropRenderItems = paramList;
  }
  
  public void setHotAreaPositions(ArrayList<RedPacketPosition> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    RenderItem localRenderItem;
    if (this.gestureRenderItems != null)
    {
      localObject2 = this.gestureRenderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.headCropRenderItems != null)
    {
      localObject2 = this.headCropRenderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.catRenderItems != null)
    {
      localObject2 = this.catRenderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.bodyRenderItems != null)
    {
      localObject2 = this.bodyRenderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.fgStaticStickerRenderItems != null)
    {
      localObject2 = this.fgStaticStickerRenderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.renderItems != null)
    {
      localObject2 = this.renderItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRenderItem = (RenderItem)((Iterator)localObject2).next();
        if ((localRenderItem.filter instanceof VideoFilterBase)) {
          ((ArrayList)localObject1).add((VideoFilterBase)localRenderItem.filter);
        }
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject2 = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add((VideoFilterBase)((RenderItem)((Iterator)localObject2).next()).filter);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoFilterBase)((Iterator)localObject1).next();
      if ((localObject2 instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localObject2).setHotAreaPosition(paramArrayList);
      }
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject1 = this.mFastFaceStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).setHotArea(paramArrayList);
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject1 = this.mFastBodyStickerRenderItems.filter;
      if (localObject1 != null) {
        ((FastStickerFilter)localObject1).setHotArea(paramArrayList);
      }
    }
    if (this.gestureParticleRenderItems != null)
    {
      localObject1 = this.gestureParticleRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof ParticleFilter)) {
          ((ParticleFilter)localObject2).setHotAreaPosition(paramArrayList);
        } else if ((localObject2 instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localObject2).setHotAreaPosition(paramArrayList);
        }
      }
    }
    if (this.bodyParticleRenderItems != null)
    {
      localObject1 = this.bodyParticleRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof ParticleFilter)) {
          ((ParticleFilter)localObject2).setHotAreaPosition(paramArrayList);
        } else if ((localObject2 instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localObject2).setHotAreaPosition(paramArrayList);
        }
      }
    }
    if (this.starParticleRenderItems != null)
    {
      localObject1 = this.starParticleRenderItems.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((RenderItem)((Iterator)localObject1).next()).filter;
        if ((localObject2 instanceof ParticleFilter)) {
          ((ParticleFilter)localObject2).setHotAreaPosition(paramArrayList);
        } else if ((localObject2 instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localObject2).setHotAreaPosition(paramArrayList);
        }
      }
    }
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setImageData(paramArrayOfByte);
    }
    if (this.mFaceOffRenderItems != null)
    {
      Iterator localIterator = this.mFaceOffRenderItems.iterator();
      while (localIterator.hasNext())
      {
        AEFilterI localAEFilterI = ((RenderItem)localIterator.next()).filter;
        if ((localAEFilterI instanceof FaceOffFilter)) {
          ((FaceOffFilter)localAEFilterI).setImageData(paramArrayOfByte);
        }
        if ((localAEFilterI instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localAEFilterI).setImageData(paramArrayOfByte);
        }
      }
    }
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    Iterator localIterator = this.renderItems.iterator();
    while (localIterator.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)localIterator.next();
      if ((localRenderItem.filter instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localRenderItem.filter).setRenderForBitmap(paramBoolean);
      }
    }
    this.triggerManager.setIsRenderForBitmap(paramBoolean);
  }
  
  public void setLut(RenderItem paramRenderItem)
  {
    this.lutItemsRenderItem = paramRenderItem;
  }
  
  public void setMaskStickerRenderItems(List<RenderItem> paramList)
  {
    this.mMaskStickerRenderItemList = paramList;
  }
  
  public void setMaterial(VideoMaterial paramVideoMaterial)
  {
    this.material = paramVideoMaterial;
  }
  
  public void setMultiViewerFilters(List<MultiViewerFilter> paramList)
  {
    this.multiViewerFilters = paramList;
  }
  
  public void setMultiViewerOutFrame(Frame paramFrame)
  {
    this.multiViewerOutFrame = paramFrame;
  }
  
  public void setMultiViewerSrcTexture(int paramInt)
  {
    this.multiViewerSrcTexture = paramInt;
  }
  
  public void setNeedDetectEmotion(boolean paramBoolean)
  {
    this.needDetectEmotion = paramBoolean;
  }
  
  public void setNeedDetectGender(boolean paramBoolean)
  {
    this.needDetectGender = paramBoolean;
  }
  
  public void setNeedDetectGesture(boolean paramBoolean)
  {
    this.needDetectGesture = paramBoolean;
  }
  
  public void setNeedDetectGestureBonePoint(boolean paramBoolean)
  {
    this.needDetectGestureBonePoint = paramBoolean;
  }
  
  public void setOnlyDetectOneGesture(int paramInt)
  {
    this.onlyDetectOneGesture = paramInt;
  }
  
  public void setPhantomFilter(PhantomFilter paramPhantomFilter)
  {
    this.mPhantomFilter = paramPhantomFilter;
  }
  
  public void setQQGestureFilters(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2)
  {
    VideoFilterUtil.removeEmptyFilters(paramList1);
    VideoFilterUtil.removeEmptyFilters(paramList2);
    this.qqGestureDynamicFilters = paramList1;
    this.qqGestureStaticFilters = paramList2;
  }
  
  public void setRapidNetRenderItems(List<RenderItem> paramList)
  {
    this.rapidNetRenderItems = paramList;
  }
  
  public void setRatio(float paramFloat)
  {
    Object localObject = this.renderItems.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RenderItem localRenderItem = (RenderItem)((Iterator)localObject).next();
      if ((localRenderItem.filter instanceof StaticStickerFilter)) {
        ((StaticStickerFilter)localRenderItem.filter).setRatio(paramFloat);
      }
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject = this.mFastFaceStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).setRatio(paramFloat);
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject = this.mFastBodyStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).setRatio(paramFloat);
      }
    }
    if (this.multiViewerFilters != null)
    {
      localObject = this.multiViewerFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MultiViewerFilter)((Iterator)localObject).next()).setRatio(paramFloat);
      }
    }
  }
  
  public void setRemodelRenderItems(List<RenderItem> paramList)
  {
    this.mRemodelRenderItems = paramList;
  }
  
  public void setRenderItems(List<RenderItem> paramList1, List<RenderItem> paramList2, List<RenderItem> paramList3)
  {
    VideoFilterUtil.removeEmptyRenderItems(paramList1);
    VideoFilterUtil.removeEmptyRenderItems(paramList2);
    VideoFilterUtil.removeEmptyRenderItems(paramList3);
    splitFgStaticStickerRenderItemsFromTransform(getStickerRenderItems(paramList1, true, true));
    this.fgDynamicRenderItems = getStickerRenderItems(paramList1, false, true);
    this.bgStaticStickerRenderItems = getStickerRenderItems(paramList1, true, false);
    this.bgDynamicStickerRenderItems = getStickerRenderItems(paramList1, false, false);
    this.renderItems.addAll(paramList1);
    this.renderItems.addAll(paramList3);
    this.staticCountRenderItems = getStaticStickerRenderItems(this.fgStaticStickerRenderItems);
    this.mFaceOffRenderItems = paramList2;
    this.mTransformRenderItems = paramList3;
  }
  
  public void setRenderMode(int paramInt)
  {
    VideoFilterUtil.setRenderModes(this.renderItems, paramInt);
    Object localObject;
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject != null) {
        ((FabbyFilters)localObject).setRenderMode(paramInt);
      }
    }
    if (this.mFaceOffRenderItems != null)
    {
      localObject = this.mFaceOffRenderItems.iterator();
      while (((Iterator)localObject).hasNext()) {
        VideoFilterUtil.setRenderMode((VideoFilterBase)((RenderItem)((Iterator)localObject).next()).filter, paramInt);
      }
    }
    if (this.headCropRenderItems != null)
    {
      localObject = this.headCropRenderItems.iterator();
      while (((Iterator)localObject).hasNext()) {
        VideoFilterUtil.setRenderMode((VideoFilterBase)((RenderItem)((Iterator)localObject).next()).filter, paramInt);
      }
    }
    if (this.mBeautyTransformListRenderItems != null)
    {
      localObject = this.mBeautyTransformListRenderItems.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BeautyTransformList)((RenderItem)((Iterator)localObject).next()).filter).setRenderMode(paramInt);
      }
    }
    if (this.mRemodelRenderItems != null)
    {
      localObject = this.mRemodelRenderItems.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RemodelFilter)((RenderItem)((Iterator)localObject).next()).filter).setRenderMode(paramInt);
      }
    }
    this.mCopyFilter.setRenderMode(paramInt);
    this.snapShotFrameToSticker.setRenderMode(paramInt);
    if ((this.headCropRenderItem != null) && (this.headCropRenderItem.filter != null)) {
      ((VideoFilterBase)this.headCropRenderItem.filter).setRenderMode(paramInt);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setRenderMode(paramInt);
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FacialFeatureFilter)((Iterator)localObject).next()).setRenderMode(paramInt);
      }
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.setRenderMode(paramInt);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setRenderMode(paramInt);
    }
    if (this.fabbyExtractFilter != null) {
      this.fabbyExtractFilter.setRenderMode(paramInt);
    }
    if ((this.fabbyStrokeRenderItem != null) && ((this.fabbyStrokeRenderItem.filter instanceof FabbyStrokeFilter))) {
      ((FabbyStrokeFilter)this.fabbyStrokeRenderItem.filter).setRenderMode(paramInt);
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.setRenderMode(paramInt);
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.setRenderMode(paramInt);
    }
    if (this.mZoomRenderItem != null)
    {
      localObject = this.mZoomRenderItem.filter;
      if (localObject != null) {
        ((ZoomFilter)localObject).setRenderMode(paramInt);
      }
    }
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFilterBase)((RenderItem)((Iterator)localObject).next()).filter).setRenderMode(paramInt);
      }
    }
  }
  
  public void setScreenMidPoint(float[] paramArrayOfFloat)
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).setScreenMidPoint(paramArrayOfFloat);
    }
  }
  
  public void setSkyBox(RenderItem paramRenderItem)
  {
    this.skyboxItemsRenderItem = paramRenderItem;
  }
  
  public void setStarParticleRenderItems(List<RenderItem> paramList)
  {
    this.starParticleRenderItems = paramList;
  }
  
  public void setStickerListener(int paramInt, IStickerListener paramIStickerListener)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while ((this.filamentRenderItem == null) || (this.filamentRenderItem.filter == null) || (!(paramIStickerListener instanceof MaterialLoadFinishListener)));
      ((FilamentFilter)this.filamentRenderItem.filter).setOnLoadFinishListener((MaterialLoadFinishListener)paramIStickerListener);
      return;
    }
    updateDetectorSettingListener(paramIStickerListener);
  }
  
  public void setStyleChildRenderItems(List<RenderItem> paramList)
  {
    this.styleChildRenderItems = paramList;
  }
  
  public void setStyleCustomFilterGroup(StyleCustomFilterGroup paramStyleCustomFilterGroup)
  {
    this.styleCustomFilterGroup = paramStyleCustomFilterGroup;
  }
  
  public void setStyleFilterRenderItems(List<RenderItem> paramList)
  {
    this.mStyleFilterRenderItems = paramList;
  }
  
  public void setTouchScale(float paramFloat)
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).setFilamentAssetScale(paramFloat);
    }
  }
  
  public void setTriggerManager(TriggerManager paramTriggerManager)
  {
    this.triggerManager = paramTriggerManager;
  }
  
  public void setTriggerWords(String paramString)
  {
    if (this.triggerManager != null) {
      this.triggerManager.setTriggerWords(paramString);
    }
  }
  
  public void setUnProjectionHitPoint(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((this.filamentRenderItem != null) && (this.filamentRenderItem.filter != null)) {
      ((FilamentFilter)this.filamentRenderItem.filter).setUnProjectionHitPoint(paramArrayOfFloat, paramBoolean);
    }
  }
  
  public void setVideoEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    this.mEffectFilter = paramVideoFilterBase;
  }
  
  public void setVideoEffectOrder(int paramInt)
  {
    this.mEffectOrder = paramInt;
  }
  
  public void setVoiceTextFilter(VoiceTextFilter paramVoiceTextFilter)
  {
    this.voiceTextFilter = paramVoiceTextFilter;
  }
  
  public void setZoomRenderItem(RenderItem paramRenderItem)
  {
    this.mZoomRenderItem = paramRenderItem;
  }
  
  public void setmEffectTriggerRenderItems(List<RenderItem> paramList)
  {
    this.mEffectTriggerRenderItems = paramList;
  }
  
  public Frame undateAndRenderMaskSticker(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    if ((this.mMaskStickerRenderItemList == null) || (this.mMaskStickerRenderItemList.size() < 1)) {
      return paramFrame;
    }
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = this.mMaskStickerRenderItemList.iterator();
    label54:
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (RenderItem)((Iterator)localObject2).next();
      localObject5 = (VideoFilterBase)((RenderItem)localObject4).filter;
      if ((localObject5 instanceof StaticMaskFilter)) {
        ((List)localObject3).add(localObject4);
      }
      if (!(localObject5 instanceof FastMaskFilter)) {
        break label978;
      }
      localObject1 = (FastMaskFilter)localObject5;
    }
    label403:
    label965:
    label978:
    for (;;)
    {
      if ((localObject5 instanceof DynamicMaskFilter)) {
        localArrayList.add(localObject4);
      }
      break label54;
      this.mMaskStickerFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      if (this.mCopyFilter == null) {
        break;
      }
      int i = paramFrame.getTextureId();
      localObject2 = getSpaceFrame(i);
      this.mCopyFilter.RenderProcess(i, paramFrame.width, paramFrame.height, -1, 0.0D, (Frame)localObject2);
      i = getMaskType((List)localObject3, (FastMaskFilter)localObject1, localArrayList);
      if (i == 1)
      {
        FrameUtil.clearFrame((Frame)localObject2, 1.0F, 1.0F, 1.0F, 1.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label478;
        }
        if (i != 1) {
          break label403;
        }
        FrameUtil.clearFrame(this.mMaskStickerFrame, 1.0F, 1.0F, 1.0F, 1.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
      }
      Object localObject6;
      for (;;)
      {
        localObject4 = new PTDetectInfo.Builder().aiAttr(paramAIAttr).build();
        localObject5 = ((List)localObject3).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (RenderItem)((Iterator)localObject5).next();
          if (((VideoFilterBase)((RenderItem)localObject6).filter instanceof StaticMaskFilter)) {
            ((RenderItem)localObject6).updatePreview(localObject4);
          }
        }
        if (i == 2)
        {
          FrameUtil.clearFrame((Frame)localObject2, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
          break;
        }
        FrameUtil.clearFrame((Frame)localObject2, 1.0F, 1.0F, 1.0F, 1.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
        break;
        if (i == 2) {
          FrameUtil.clearFrame(this.mMaskStickerFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
        } else {
          FrameUtil.clearFrame(this.mMaskStickerFrame, 1.0F, 1.0F, 1.0F, 1.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
        }
      }
      RenderProcessForRenderItem(this.mMaskStickerFrame, (Frame)localObject2, (List)localObject3);
      label478:
      if (localObject1 != null) {
        ((FastMaskFilter)localObject1).addSrcTexture(((Frame)localObject2).getTextureId());
      }
      for (localObject1 = ((FastMaskFilter)localObject1).render((Frame)localObject2);; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        Set localSet;
        long l;
        if (paramPTFaceAttr != null)
        {
          localObject6 = paramPTFaceAttr.getAllFacePoints();
          int j = Math.min(((List)localObject6).size(), getMaterial().getMaxFaceCount());
          localSet = paramPTFaceAttr.getTriggeredExpression();
          List localList = paramPTFaceAttr.getAllFaceAngles();
          l = paramPTFaceAttr.getTimeStamp();
          i = 0;
          localObject2 = localObject1;
          if (i < j)
          {
            localObject2 = localObject1;
            if (i < this.mFaceList.size())
            {
              localObject2 = (Face)this.mFaceList.get(i);
              localObject4 = ((Face)localObject2).facePoints;
              localObject5 = ((Face)localObject2).faceAngles;
              localObject3 = localObject5;
              localObject2 = localObject4;
              if (needShookHeadCount())
              {
                localObject3 = localObject5;
                localObject2 = localObject4;
                if (this.currentFaceInfo != null)
                {
                  localObject3 = localObject5;
                  localObject2 = localObject4;
                  if (this.selectFaceIndex >= 0)
                  {
                    localObject3 = localObject5;
                    localObject2 = localObject4;
                    if (this.selectFaceIndex < ((List)localObject6).size())
                    {
                      setCurPersonId(i);
                      localObject2 = (List)((List)localObject6).get(this.selectFaceIndex);
                      localObject3 = (float[])localList.get(this.selectFaceIndex);
                    }
                  }
                }
              }
              localObject5 = AIActionCounter.getActions(AEDetectorType.HAND);
              if (paramAIAttr == null)
              {
                localObject4 = null;
                if (localObject4 == null) {
                  break label965;
                }
              }
            }
          }
        }
        for (localObject4 = ((PTHandAttr)localObject4).getHandPointList();; localObject4 = null)
        {
          localObject2 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject3).handPoints((List)localObject4).handActionCounter((Map)localObject5).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject3 = localArrayList.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (RenderItem)((Iterator)localObject3).next();
                if (((VideoFilterBase)((RenderItem)localObject4).filter instanceof DynamicMaskFilter))
                {
                  ((RenderItem)localObject4).updatePreview(localObject2);
                  continue;
                  localObject4 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
                  break;
                }
              }
            }
            localObject2 = getSpaceFrame(((Frame)localObject1).getTextureId());
            this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, (Frame)localObject2);
            RenderProcessForRenderItem((Frame)localObject1, (Frame)localObject2, localArrayList);
            localObject1 = localObject2;
          }
          for (;;)
          {
            i += 1;
            break;
            return mergeFrame(paramFrame, (Frame)localObject2);
          }
        }
      }
    }
  }
  
  public void updateAllFilters(PTDetectInfo paramPTDetectInfo)
  {
    updateRenderItems(paramPTDetectInfo, this.renderItems);
  }
  
  public Frame updateAndRenderActMaterial(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt, long paramLong)
  {
    Frame localFrame = paramFrame;
    if (this.mActFilters != null)
    {
      GlUtil.setBlendMode(true);
      localFrame = this.mActFilters.updateAndRender(paramFrame, paramLong, paramList, paramList1, paramInt);
      GlUtil.setBlendMode(false);
    }
    return localFrame;
  }
  
  public Frame updateAndRenderAllStickers4QQ(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    Frame localFrame = updateAndRender(paramFrame, paramPTFaceAttr, null);
    if (allBusinessPrivateProcess(this.renderItems)) {
      localFrame = updateAndRenderStaticStickers(paramFrame, paramPTFaceAttr);
    }
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return localFrame;
  }
  
  public Frame updateAndRenderBeforeComicEffectFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mComicEffectRenderItems != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearComicEffectFiltersRenderStatus(this.mComicEffectRenderItems);
      if (j > 0) {
        break label125;
      }
      updateComicEffectRenderItems(1, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
      localObject1 = RenderProcessForComicEffectRenderItems(1, paramFrame, this.mComicEffectRenderItems);
    }
    label125:
    int i;
    do
    {
      do
      {
        return localObject1;
        i = 0;
        localObject1 = paramFrame;
      } while (i >= j);
      localObject1 = paramFrame;
    } while (i >= this.mFaceList.size());
    Face localFace = (Face)this.mFaceList.get(i);
    localObject2 = new ArrayList();
    if (this.aiAttr == null)
    {
      localObject1 = null;
      label186:
      if (localObject1 == null) {
        break label337;
      }
    }
    label337:
    for (localObject1 = ((PTHandAttr)localObject1).getHandPointList();; localObject1 = localObject2)
    {
      updateComicEffectRenderItems(1, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
      paramFrame = RenderProcessForComicEffectRenderItems(1, paramFrame, this.mComicEffectRenderItems);
      i += 1;
      break;
      localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break label186;
    }
  }
  
  public Frame updateAndRenderBeforeEffectTriggerFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mEffectTriggerRenderItems != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearEffectTriggerFiltersRenderStatus(getEffectTriggerFilters());
      if (j > 0) {
        break label108;
      }
      updateEffectTriggerFilters(1, new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerRenderItems);
      localObject1 = paramFrame;
    }
    label108:
    int i;
    do
    {
      do
      {
        return localObject1;
        i = 0;
        localObject1 = paramFrame;
      } while (i >= j);
      localObject1 = paramFrame;
    } while (i >= this.mFaceList.size());
    Face localFace = (Face)this.mFaceList.get(i);
    localObject2 = new ArrayList();
    if (this.aiAttr == null)
    {
      localObject1 = null;
      label169:
      if (localObject1 == null) {
        break label303;
      }
    }
    label303:
    for (localObject1 = ((PTHandAttr)localObject1).getHandPointList();; localObject1 = localObject2)
    {
      updateEffectTriggerFilters(1, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mEffectTriggerRenderItems);
      paramFrame = RenderProcessForEffectTriggerRenderItems(1, paramFrame, this.mEffectTriggerRenderItems);
      i += 1;
      break;
      localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break label169;
    }
  }
  
  public Frame updateAndRenderBgFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if (this.mMaskFilter == null) {
      return paramFrame;
    }
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Map localMap1 = paramPTFaceAttr.getFaceActionCounter();
    Map localMap2 = AIActionCounter.getActions(AEDetectorType.HAND);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject2;
    if (this.aiAttr == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label527;
      }
      localObject2 = ((PTHandAttr)localObject1).getHandPointList();
      localSet.add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
    }
    label527:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      long l = paramPTFaceAttr.getTimeStamp();
      this.mBgFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      FrameUtil.clearFrame(this.mBgFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
      localObject2 = this.mBgFrame;
      GlUtil.setBlendMode(true);
      int j = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          updateRenderItems(new PTDetectInfo.Builder().facePoints((List)localList1.get(i)).faceAngles((float[])localList2.get(i)).faceActionCounter(localMap1).handPoints((List)localObject1).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.bgDynamicStickerRenderItems);
          localObject2 = RenderProcessForRenderItems((Frame)localObject2, this.bgDynamicStickerRenderItems);
          i += 1;
          continue;
          localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
          break;
        }
      }
      if (localList1.size() <= 0)
      {
        paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap1).aiAttr(this.aiAttr).handPoints((List)localObject1).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerRenderItems, paramFrame, paramPTFaceAttr);
        updateRenderItems(paramPTFaceAttr, this.bgStaticStickerRenderItems);
      }
      for (paramPTFaceAttr = RenderProcessForRenderItems((Frame)localObject2, this.bgStaticStickerRenderItems);; paramPTFaceAttr = RenderProcessForRenderItems((Frame)localObject2, this.bgStaticStickerRenderItems))
      {
        this.mMaskFilter.OnDrawFrameGLSL();
        this.mMaskFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        GlUtil.setBlendMode(false);
        return paramPTFaceAttr;
        paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap1).handPoints((List)localObject1).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerRenderItems, paramFrame, paramPTFaceAttr);
        updateRenderItems(paramPTFaceAttr, this.bgStaticStickerRenderItems);
      }
    }
  }
  
  public Frame updateAndRenderBlingFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    GlUtil.setBlendMode(true);
    if (paramPTFaceAttr.getStarMaskFrame() != null)
    {
      this.starOverlayFilter.setTexture2(paramPTFaceAttr.getStarMaskFrame().getTextureId());
      this.starOverlayFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.starOverlayFrame);
      paramFrame = this.starOverlayFrame;
      paramPTFaceAttr.getStarMaskFrame().unlock();
      paramPTFaceAttr = paramFrame;
    }
    for (;;)
    {
      GlUtil.setBlendMode(false);
      return paramPTFaceAttr;
      paramPTFaceAttr = paramFrame;
      if (paramList != null)
      {
        paramPTFaceAttr = paramFrame;
        if (paramList.size() > 0)
        {
          updateRenderItems(paramPTDetectInfo, this.starParticleRenderItems.subList(0, Math.min(paramList.size(), this.starParticleRenderItems.size())));
          paramPTFaceAttr = RenderProcessForFastParticleRenderItem(paramFrame, this.starParticleRenderItems.subList(0, Math.min(paramList.size(), this.starParticleRenderItems.size())));
        }
      }
    }
  }
  
  public Frame updateAndRenderComicEffectFilters(int paramInt, Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mComicEffectRenderItems != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearComicEffectFiltersRenderStatus(this.mComicEffectRenderItems);
      if (j > 0) {
        break label125;
      }
      updateComicEffectRenderItems(paramInt, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
      localObject1 = RenderProcessForComicEffectRenderItems(paramInt, paramFrame, this.mComicEffectRenderItems);
    }
    label125:
    int i;
    do
    {
      do
      {
        return localObject1;
        i = 0;
        localObject1 = paramFrame;
      } while (i >= j);
      localObject1 = paramFrame;
    } while (i >= this.mFaceList.size());
    Face localFace = (Face)this.mFaceList.get(i);
    localObject2 = new ArrayList();
    if (this.aiAttr == null)
    {
      localObject1 = null;
      label190:
      if (localObject1 == null) {
        break label343;
      }
    }
    label343:
    for (localObject1 = ((PTHandAttr)localObject1).getHandPointList();; localObject1 = localObject2)
    {
      updateComicEffectRenderItems(paramInt, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
      paramFrame = RenderProcessForComicEffectRenderItems(paramInt, paramFrame, this.mComicEffectRenderItems);
      i += 1;
      break;
      localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break label190;
    }
  }
  
  public Frame updateAndRenderCrazyFace(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    int i = Math.min(paramList.size(), getMaterial().getMaxFaceCount());
    Frame localFrame = paramFrame;
    if (this.crazyFaceFilters != null)
    {
      localFrame = paramFrame;
      if (i > 0)
      {
        paramList1 = (float[])paramList1.get(0);
        paramList = (List)paramList.get(0);
        localFrame = paramFrame;
        if (PTFaceAttr.isPositiveFace(paramList1, paramList, paramFrame.width, paramFrame.height, this.mFaceDetScale)) {
          localFrame = this.crazyFaceFilters.updateAndRender(paramFrame, paramFrame.width, paramFrame.height, paramList, paramList1);
        }
      }
    }
    return localFrame;
  }
  
  public Frame updateAndRenderDynamicStickers(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    if (paramFrame == null) {
      return paramFrame;
    }
    if ((paramPTFaceAttr.isLandscape()) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramFrame;
    }
    if (paramPTFaceAttr.getFaceCount() > 0) {
      setImageData(paramPTFaceAttr.getData());
    }
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFrame = updateAndRender(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFrame;
  }
  
  public Frame updateAndRenderDynamicStickersPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    if ((paramPTFaceAttr.isLandscape()) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramFrame;
    }
    if (paramPTFaceAttr.getFaceCount() > 0) {
      setImageData(paramPTFaceAttr.getData());
    }
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFrame = updateAndRenderPluggable(paramFrame, paramPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFrame;
  }
  
  public Frame updateAndRenderEffectTriggerFilters(int paramInt, Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mEffectTriggerRenderItems != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearEffectTriggerFiltersRenderStatus(getEffectTriggerFilters());
      if (j > 0) {
        break label108;
      }
      updateEffectTriggerFilters(paramInt, new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerRenderItems);
      localObject1 = paramFrame;
    }
    label108:
    int i;
    do
    {
      do
      {
        return localObject1;
        i = 0;
        localObject1 = paramFrame;
      } while (i >= j);
      localObject1 = paramFrame;
    } while (i >= this.mFaceList.size());
    Face localFace = (Face)this.mFaceList.get(i);
    localObject2 = new ArrayList();
    if (this.aiAttr == null)
    {
      localObject1 = null;
      label173:
      if (localObject1 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = ((PTHandAttr)localObject1).getHandPointList();; localObject1 = localObject2)
    {
      updateEffectTriggerFilters(paramInt, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mEffectTriggerRenderItems);
      paramFrame = RenderProcessForEffectTriggerRenderItems(paramInt, paramFrame, this.mEffectTriggerRenderItems);
      i += 1;
      break;
      localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break label173;
    }
  }
  
  public Frame updateAndRenderFabbyMVRenderItem(Frame paramFrame, AIAttr paramAIAttr, Map<Integer, Frame> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    if (this.mFabbyMvFiltersRenderItem == null) {
      return paramFrame;
    }
    FabbyFilters localFabbyFilters = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;
    if (localFabbyFilters != null)
    {
      if ((paramMap == null) || (!paramMap.containsKey(Integer.valueOf(0))) || (paramFrame.getTextureId() != ((Frame)paramMap.get(Integer.valueOf(0))).getTextureId())) {
        break label176;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.fabbyOriginCopyFrame);
      paramFrame = this.fabbyOriginCopyFrame;
    }
    label176:
    for (;;)
    {
      localFabbyFilters.setTouchPoints(this.mMaskTouchPoints);
      if (paramAIAttr != null) {
        localFabbyFilters.updateHandAttr((PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value));
      }
      paramFrame = localFabbyFilters.updateAndRender(paramFrame, paramMap, paramMap1, paramSet, paramLong);
      this.mvPartsAndMultiViewerFrameMap.put("$preservedTexture_mvPart", paramFrame);
      return paramFrame;
      return (Frame)paramMap.values().iterator().next();
    }
  }
  
  public Frame updateAndRenderFaceOffFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    this.directDraw = false;
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject1 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localObject1 != null) {
      localSet.add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
    }
    long l = paramPTFaceAttr.getTimeStamp();
    int j = Math.min(this.mFaceList.size(), getMaterial().getMaxFaceCount());
    GlUtil.setBlendMode(true);
    if (j <= 0) {
      updateRenderItems(new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).aiAttr(paramAIAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mFaceOffRenderItems);
    }
    hitStaticFaceRandomGroupItem();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject1 = (Face)this.mFaceList.get(i);
      setCurPersonId(((Face)localObject1).faceIndex);
      setCurGender(((Face)localObject1).gender);
      hitCharmRangeItem(((Face)localObject1).faceIndex);
      hitDynamicFaceRandomGroupItem(((Face)localObject1).faceIndex);
      hitAgeRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
      hitGenderRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
      hitPopularRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex);
      hitCpRangeItem(paramPTFaceAttr.getFaceDetector(), ((Face)localObject1).faceIndex, j);
      localObject2 = new PTDetectInfo.Builder().facePoints(((Face)localObject1).facePoints).faceAngles(((Face)localObject1).faceAngles).triggeredExpression(localSet).aiAttr(paramAIAttr).timestamp(l).pointsVis(((Face)localObject1).facePointVis).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).phoneAngle(paramPTFaceAttr.getRotation()).realPhoneAngle(paramPTFaceAttr.getSrcRotation()).faceDetector(paramPTFaceAttr.getFaceDetector());
      PointF localPointF = (PointF)((Face)localObject1).facePoints.get(63);
      if ((paramPTFaceAttr.getFace3DVerticesArray() != null) && (paramPTFaceAttr.getFace3DVerticesArray().size() > 0)) {
        ((PTDetectInfo.Builder)localObject2).face3DVerticesArray((float[])paramPTFaceAttr.getFace3DVerticesArray().get(0));
      }
      if ((paramPTFaceAttr.getFace3DRotationArray() != null) && (paramPTFaceAttr.getFace3DRotationArray().size() > 0)) {
        ((PTDetectInfo.Builder)localObject2).face3DRotationArray((float[])paramPTFaceAttr.getFace3DRotationArray().get(0));
      }
      if (this.mFaceOffRenderItems == null) {
        break label593;
      }
      localObject1 = new PTDetectInfo.Builder().facePoints(((Face)localObject1).facePoints).faceAngles(((Face)localObject1).faceAngles).build();
      this.mFaceOffNoseOcclusionFilter.updatePreview(localObject1);
      localObject1 = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
      FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
      this.mFaceOffNoseOcclusionFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, (Frame)localObject1);
      ((PTDetectInfo.Builder)localObject2).noseOcclusionFrame((Frame)localObject1);
    }
    for (;;)
    {
      localObject2 = ((PTDetectInfo.Builder)localObject2).build();
      if (this.mFaceOffRenderItems != null)
      {
        FaceOffFilterManager.getInstance().updateIndex();
        updateRenderItems((PTDetectInfo)localObject2, this.mFaceOffRenderItems, j, i);
        paramFrame = RenderProcessForRenderItems(paramFrame, this.mFaceOffRenderItems);
      }
      for (;;)
      {
        if (localObject1 != null) {
          ((Frame)localObject1).unlock();
        }
        i += 1;
        break;
        GlUtil.setBlendMode(false);
        return paramFrame;
      }
      label593:
      localObject1 = null;
    }
  }
  
  public Frame updateAndRenderFaceSwitch(Frame paramFrame, List<List<PointF>> paramList, Set<Integer> paramSet)
  {
    Iterator localIterator;
    Object localObject;
    if (VideoMaterialUtil.isFaceCopyMaterial(getMaterial()))
    {
      localIterator = this.renderItems.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RenderItem)localIterator.next();
        if ((((RenderItem)localObject).filter instanceof FaceCopyFilter))
        {
          localObject = (FaceCopyFilter)((RenderItem)localObject).filter;
          ((FaceCopyFilter)localObject).setFaceParams(paramList, paramFrame.getTextureId());
          ((FaceCopyFilter)localObject).renderProcess(paramSet);
        }
      }
    }
    if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
    {
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrame[0]);
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      localIterator = this.renderItems.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RenderItem)localIterator.next();
        if ((((RenderItem)localObject).filter instanceof SwitchFaceFilter))
        {
          localObject = (SwitchFaceFilter)((RenderItem)localObject).filter;
          ((SwitchFaceFilter)localObject).setFaceParams(paramList, this.copyFrame[0].getTextureId());
          ((SwitchFaceFilter)localObject).renderProcess(paramSet);
        }
      }
    }
    return paramFrame;
  }
  
  public Frame updateAndRenderFilamentFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = null;
    Object localObject1 = paramFrame;
    if (this.filamentRenderItem != null)
    {
      localObject1 = paramFrame;
      if (this.filamentRenderItem.filter != null)
      {
        FilamentFilter localFilamentFilter = (FilamentFilter)this.filamentRenderItem.filter;
        this.filamentRenderItem.updatePreview(null);
        localObject1 = localObject2;
        if (!this.mMaskTouchPoints.isEmpty()) {
          localObject1 = (PointF)this.mMaskTouchPoints.get(this.mMaskTouchPoints.size() - 1);
        }
        localFilamentFilter.addTouchPoint((PointF)localObject1);
        localObject1 = localFilamentFilter.render(paramFrame, this.aiAttr, paramPTFaceAttr);
      }
    }
    return localObject1;
  }
  
  public Frame updateAndRenderFilamentParticleFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.filamentParticleFilter != null) {
      localFrame = this.filamentParticleFilter.render(paramFrame, paramPTFaceAttr);
    }
    return localFrame;
  }
  
  public Frame updateAndRenderHairCos(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTHairAttr paramPTHairAttr)
  {
    if ((this.mHairCosRenderItem == null) || (paramPTHairAttr == null) || (!paramPTHairAttr.isReady())) {
      return paramFrame;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localObject2 != null) {
      localObject1 = ((PTHandAttr)localObject2).getHandPointList();
    }
    for (;;)
    {
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      if (localObject2 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
      localObject2 = new ArrayList();
      Object localObject3 = new float[0];
      FaceStatus localFaceStatus = new FaceStatus();
      if (paramPTFaceAttr.getAllFacePoints().size() > 0)
      {
        localObject2 = (List)paramPTFaceAttr.getAllFacePoints().get(0);
        localObject3 = (float[])paramPTFaceAttr.getAllFaceAngles().get(0);
        localFaceStatus = (FaceStatus)paramPTFaceAttr.getFaceStatusList().get(0);
      }
      localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject3).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      if (this.mFabbyMvFiltersRenderItem != null) {}
      for (paramPTFaceAttr = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; paramPTFaceAttr = null)
      {
        if (this.mHairCosRenderItem == null) {
          break label399;
        }
        localObject2 = this.mHairCosRenderItem.filter;
        if (localObject2 == null) {
          break;
        }
        localObject3 = (HairCosTriggerCtrlItem)this.mHairCosRenderItem.triggerCtrlItem;
        if (paramPTFaceAttr == null)
        {
          i = this.mCurMVPart;
          ((HairCosTriggerCtrlItem)localObject3).updateTriggerStatus((PTDetectInfo)localObject1, i);
          if (!((HairCosTriggerCtrlItem)localObject3).isTriggered()) {
            break label386;
          }
          ((HairCos)localObject2).setRenderHairItemMaps(((HairCosTriggerCtrlItem)localObject3).getRenderHairItem());
          localObject2 = (HairCos)localObject2;
          if (paramPTFaceAttr != null) {
            break label377;
          }
        }
        label377:
        for (int i = this.mCurMVPart;; i = paramPTFaceAttr.getCurPartIndex())
        {
          return ((HairCos)localObject2).render(paramFrame, paramPTHairAttr, (PTDetectInfo)localObject1, i);
          i = paramPTFaceAttr.getCurPartIndex();
          break;
        }
        label386:
        ((HairCos)localObject2).stopRender();
        return paramFrame;
      }
      label399:
      break;
    }
  }
  
  public Frame updateAndRenderHeadCropItemFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    GlUtil.setBlendMode(true);
    if ((this.headCropRenderItem != null) && (this.headCropRenderItem.filter != null))
    {
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mHeadCropFrame);
      ((HeadCropFilter)this.headCropRenderItem.filter).setInputFrame(this.mHeadCropFrame);
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    }
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    PTHandAttr localPTHandAttr;
    long l;
    if (this.aiAttr == null)
    {
      localPTHandAttr = null;
      if (localPTHandAttr != null) {
        localSet.add(Integer.valueOf(localPTHandAttr.getHandType()));
      }
      l = paramPTFaceAttr.getTimeStamp();
      if (localList1.size() > 0) {
        break label270;
      }
      updateRenderItems(new PTDetectInfo.Builder().faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.headCropRenderItems);
    }
    for (paramFrame = RenderProcessForRenderItems(paramFrame, this.headCropRenderItems);; paramFrame = RenderProcessForRenderItems(paramFrame, this.headCropRenderItems))
    {
      GlUtil.setBlendMode(false);
      return paramFrame;
      localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break;
      label270:
      updateRenderItems(new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.headCropRenderItems);
    }
  }
  
  public Frame updateAndRenderLut(Frame paramFrame, PTFaceAttr paramPTFaceAttr, Bitmap paramBitmap)
  {
    if ((this.lutItemsRenderItem == null) || (this.lutItemsRenderItem.filter == null) || ((this.lutItemsRenderItem.triggerCtrlItem != null) && (!this.lutItemsRenderItem.triggerCtrlItem.isTriggered()))) {
      return paramFrame;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localObject2 != null) {
      localObject1 = ((PTHandAttr)localObject2).getHandPointList();
    }
    for (;;)
    {
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      if (localObject2 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
      localObject2 = new ArrayList();
      float[] arrayOfFloat = new float[0];
      FaceStatus localFaceStatus = new FaceStatus();
      if (paramPTFaceAttr.getAllFacePoints().size() > 0)
      {
        localObject2 = (List)paramPTFaceAttr.getAllFacePoints().get(0);
        arrayOfFloat = (float[])paramPTFaceAttr.getAllFaceAngles().get(0);
        localFaceStatus = (FaceStatus)paramPTFaceAttr.getFaceStatusList().get(0);
      }
      localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles(arrayOfFloat).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      if (this.mFabbyMvFiltersRenderItem != null) {}
      for (paramPTFaceAttr = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; paramPTFaceAttr = null)
      {
        localObject2 = (LutItemsFilter)this.lutItemsRenderItem.filter;
        if (paramPTFaceAttr == null) {}
        for (int i = this.mCurMVPart;; i = paramPTFaceAttr.getCurPartIndex()) {
          return ((LutItemsFilter)localObject2).render(paramFrame, (PTDetectInfo)localObject1, i, paramBitmap);
        }
      }
    }
  }
  
  public void updateAndRenderMultiViewerMaterial(Map<Integer, Frame> paramMap, Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, PTHairAttr paramPTHairAttr)
  {
    if (paramPTFaceAttr == null) {}
    Object localObject1;
    FabbyFaceActionCounter localFabbyFaceActionCounter;
    do
    {
      do
      {
        return;
        localObject1 = paramPTFaceAttr.getFaceActionCounter();
        paramMap.clear();
      } while (this.multiViewerFilters == null);
      localFabbyFaceActionCounter = (FabbyFaceActionCounter)((Map)localObject1).get(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value));
    } while (localFabbyFaceActionCounter == null);
    Frame localFrame1 = this.mCopyFilter.render(paramFrame);
    localFrame1.setCanUnlock(false);
    int k = 0;
    int i = 0;
    MultiViewerFilter localMultiViewerFilter;
    int j;
    Object localObject2;
    label182:
    float f;
    int m;
    int n;
    PTFaceAttr localPTFaceAttr;
    if (k < this.multiViewerFilters.size())
    {
      localMultiViewerFilter = (MultiViewerFilter)this.multiViewerFilters.get(k);
      j = i;
      if (localMultiViewerFilter != null)
      {
        j = i;
        if (localMultiViewerFilter.needRenderThisPart(localFabbyFaceActionCounter.count))
        {
          localObject2 = localMultiViewerFilter.getVideoFilterList();
          j = localMultiViewerFilter.getRenderId();
          if (localFabbyFaceActionCounter.scaleMap.get(Integer.valueOf(j)) == null) {
            break label546;
          }
          localObject1 = (PointF)localFabbyFaceActionCounter.scaleMap.get(Integer.valueOf(j));
          f = Math.max(((PointF)localObject1).x, ((PointF)localObject1).y);
          if (localMultiViewerFilter.hasZoomFilter()) {
            f = 1.0F;
          }
          m = (int)(localFrame1.width * f);
          n = (int)(localFrame1.height * f);
          if ((localObject2 == null) || (!((VideoFilterList)localObject2).isFreezeFrame())) {
            break label599;
          }
          localObject1 = ((VideoFilterList)localObject2).updateInputFrame(paramFrame, FrameBufferCache.getInstance().get(m, n));
          localPTFaceAttr = ((VideoFilterList)localObject2).updatePTFaceAttr(paramPTFaceAttr);
          localObject2 = ((VideoFilterList)localObject2).updatePTSegAttr(paramPTSegAttr);
        }
      }
    }
    for (;;)
    {
      localMultiViewerFilter.updateVideoSize(m, n, this.mFaceDetScale / f);
      if (!this.multiViewerFrameMap.containsKey(Integer.valueOf(j)))
      {
        localFrame2 = new Frame();
        this.multiViewerFrameMap.put(Integer.valueOf(j), localFrame2);
        this.mvPartsAndMultiViewerFrameMap.put("$preservedTexture_multiViewer_" + j, localFrame2);
      }
      Frame localFrame2 = (Frame)this.multiViewerFrameMap.get(Integer.valueOf(j));
      localFrame2.bindFrame(-1, m, n, 0.0D);
      BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - clearFrame");
      FrameUtil.clearFrame(localFrame2, 0.0F, 0.0F, 0.0F, 0.0F, localFrame2.width, localFrame2.height);
      BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - clearFrame");
      BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
      if ((localMultiViewerFilter.getStickersMap() != null) && (localMultiViewerFilter.getStickersMap().isChangeRenderOrder())) {}
      for (localObject2 = localMultiViewerFilter.renderPlugin((Frame)localObject1, localFrame2, paramAIAttr, localPTFaceAttr, (PTSegAttr)localObject2, paramPTHairAttr);; localObject2 = localMultiViewerFilter.render((Frame)localObject1, localFrame2, paramAIAttr, localPTFaceAttr, (PTSegAttr)localObject2, paramPTHairAttr))
      {
        if ((localObject1 != localFrame2) && (localObject2 != localObject1)) {
          ((Frame)localObject1).unlock();
        }
        if (localObject2 == localFrame1) {
          i = 1;
        }
        BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
        paramMap.put(Integer.valueOf(j), localObject2);
        j = i;
        k += 1;
        i = j;
        break;
        label546:
        localObject1 = new PointF(1.0F, 1.0F);
        break label182;
      }
      if (i != 0) {
        break;
      }
      localFrame1.setCanUnlock(true);
      localFrame1.unlock();
      return;
      label599:
      localObject2 = paramPTSegAttr;
      localPTFaceAttr = paramPTFaceAttr;
      localObject1 = localFrame1;
    }
  }
  
  public Frame updateAndRenderPhantomFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.mPhantomFilter != null)
    {
      GlUtil.setBlendMode(false);
      this.mPhantomFilter.updatePreview(paramPTFaceAttr.getTimeStamp());
      this.mPhantomFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mPhantomFrame);
      localFrame = this.mPhantomFrame;
      GlUtil.setBlendMode(true);
    }
    return localFrame;
  }
  
  public Frame updateAndRenderRapidNet(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if ((FeatureManager.Features.RAPID_NET_GENDER_SWITCH.isModelLoaded(0)) && (this.rapidNetRenderItems != null) && (this.rapidNetRenderItems.size() > 0) && (this.mFaceList.size() > 0) && (paramPTFaceAttr.getAllFacePoints().size() > 0))
    {
      localObject = (RenderItem)this.rapidNetRenderItems.get(0);
      if ((localObject != null) && (((RenderItem)localObject).filter != null) && ((((RenderItem)localObject).triggerCtrlItem == null) || (((RenderItem)localObject).triggerCtrlItem.isTriggered()))) {}
    }
    else
    {
      return paramFrame;
    }
    RapidNetFilter localRapidNetFilter = (RapidNetFilter)((RenderItem)localObject).filter;
    Face localFace = (Face)this.mFaceList.get(0);
    Object localObject = new ArrayList();
    PTHandAttr localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localPTHandAttr != null) {
      localObject = localPTHandAttr.getHandPointList();
    }
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (localPTHandAttr != null) {
      localSet.add(Integer.valueOf(localPTHandAttr.getHandType()));
    }
    new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
    localRapidNetFilter.updateAndRender(paramFrame, (List)paramPTFaceAttr.getAllFacePoints().get(0), this.mFaceDetScale);
    return localRapidNetFilter.render(paramFrame);
  }
  
  public Frame updateAndRenderSkybox(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject4 = null;
    if ((this.skyboxItemsRenderItem == null) || ((this.skyboxItemsRenderItem.triggerCtrlItem != null) && (!this.skyboxItemsRenderItem.triggerCtrlItem.isTriggered()))) {
      return paramFrame;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (localObject2 != null) {
      localObject1 = ((PTHandAttr)localObject2).getHandPointList();
    }
    for (;;)
    {
      Set localSet = paramPTFaceAttr.getTriggeredExpression();
      if (localObject2 != null) {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
      }
      localObject2 = new ArrayList();
      Object localObject3 = new float[0];
      FaceStatus localFaceStatus = new FaceStatus();
      if (paramPTFaceAttr.getAllFacePoints().size() > 0)
      {
        localObject2 = (List)paramPTFaceAttr.getAllFacePoints().get(0);
        localObject3 = (float[])paramPTFaceAttr.getAllFaceAngles().get(0);
        localFaceStatus = (FaceStatus)paramPTFaceAttr.getFaceStatusList().get(0);
      }
      localObject2 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject3).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      if ("sky".equals(((StickerItem)((SkyboxItemsFilter)this.skyboxItemsRenderItem.filter).getItems().get(0)).maskType))
      {
        paramPTFaceAttr = (PTSkyAttr)this.aiAttr.getRealtimeData(AEDetectorType.SKY_SEGMENT.value);
        if (paramPTFaceAttr == null) {}
      }
      for (paramPTFaceAttr = paramPTFaceAttr.getMaskBitmap();; paramPTFaceAttr = null)
      {
        localObject1 = localObject4;
        if (this.mFabbyMvFiltersRenderItem != null) {
          localObject1 = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;
        }
        localObject3 = (SkyboxItemsFilter)this.skyboxItemsRenderItem.filter;
        if (localObject1 == null) {}
        for (int i = this.mCurMVPart;; i = ((FabbyFilters)localObject1).getCurPartIndex()) {
          return ((SkyboxItemsFilter)localObject3).render(paramFrame, (PTDetectInfo)localObject2, i, paramPTFaceAttr);
        }
      }
    }
  }
  
  public Frame updateAndRenderStaticStickers(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
    Object localObject4 = paramPTFaceAttr.getTriggeredExpression();
    PTHandAttr localPTHandAttr;
    Object localObject5;
    long l;
    Object localObject3;
    if (this.aiAttr == null)
    {
      localPTHandAttr = null;
      if (localPTHandAttr != null) {
        ((Set)localObject4).add(Integer.valueOf(localPTHandAttr.getHandType()));
      }
      localObject5 = paramPTFaceAttr.getAllFaceAngles();
      l = paramPTFaceAttr.getTimeStamp();
      GlUtil.setBlendMode(true);
      if (((List)localObject2).size() > 0) {
        break label865;
      }
      localObject3 = paramPTFaceAttr.getStarPoints();
      localObject4 = new PTDetectInfo.Builder().faceActionCounter((Map)localObject1).aiAttr(this.aiAttr).triggeredExpression((Set)localObject4).timestamp(l).phoneAngle(i).faceDetector(paramPTFaceAttr.getFaceDetector()).displacementMaskFrame(this.displacementMaskFrame).starPoints((List)localObject3).build();
      this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerRenderItems, paramFrame, (PTDetectInfo)localObject4);
      if (this.mZoomRenderItem != null) {
        if (this.mFabbyMvFiltersRenderItem == null) {
          break label1796;
        }
      }
    }
    label1796:
    for (localObject1 = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; localObject1 = null)
    {
      localObject5 = this.mZoomRenderItem.filter;
      Object localObject6;
      label253:
      int j;
      int k;
      if (localObject5 != null)
      {
        localObject6 = (ZoomTriggerCtrlItem)this.mZoomRenderItem.triggerCtrlItem;
        if (localObject1 != null) {
          break label422;
        }
        i = this.mCurMVPart;
        ((ZoomTriggerCtrlItem)localObject6).updateTriggerStatus((PTDetectInfo)localObject4, i);
        ((ZoomFilter)localObject5).setZoomModel(((ZoomTriggerCtrlItem)localObject6).getZoomModel());
        localObject5 = (ZoomFilter)localObject5;
        j = paramFrame.width;
        k = paramFrame.height;
        if (localObject1 != null) {
          break label431;
        }
      }
      label422:
      label431:
      for (i = this.mCurMVPart;; i = ((FabbyFilters)localObject1).getCurPartIndex())
      {
        ((ZoomFilter)localObject5).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject4, j, k, i);
        if (this.mMaskStickerRenderItemList == null) {
          break label440;
        }
        localObject1 = this.mMaskStickerRenderItemList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (RenderItem)((Iterator)localObject1).next();
          localObject6 = (VideoFilterBase)((RenderItem)localObject5).filter;
          if ((localObject6 instanceof NormalVideoFilter))
          {
            ((VideoFilterBase)localObject6).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
            ((RenderItem)localObject5).updatePreview(localObject4);
          }
        }
        localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
        break;
        i = ((FabbyFilters)localObject1).getCurPartIndex();
        break label253;
      }
      label440:
      updateRenderItems((PTDetectInfo)localObject4, this.fgStaticStickerRenderItems);
      paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerRenderItems);
      updateRenderItems((PTDetectInfo)localObject4, this.faceParticleStaticRenderItems);
      paramFrame = RenderProcessForRenderItems(paramFrame, this.faceParticleStaticRenderItems);
      updateRenderItems((PTDetectInfo)localObject4, this.faceGpuParticleStaticRenderItems);
      localObject1 = RenderProcessForGpuParticleRenderItems(paramFrame, this.faceGpuParticleStaticRenderItems);
      if (paramPTFaceAttr.getStarMaskFrame() != null)
      {
        this.starOverlayFilter.setTexture2(paramPTFaceAttr.getStarMaskFrame().getTextureId());
        this.starOverlayFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.starOverlayFrame);
        paramFrame = this.starOverlayFrame;
        paramPTFaceAttr.getStarMaskFrame().unlock();
      }
      for (;;)
      {
        GlUtil.setBlendMode(false);
        if (this.mEffectTriggerRenderItems == null) {
          break label1787;
        }
        j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
        if (j > 0) {
          break;
        }
        updateEffectTriggerFilters(2, new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).displacementMaskFrame(this.displacementMaskFrame).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerRenderItems);
        label659:
        localObject1 = paramFrame;
        if (this.mComicEffectRenderItems != null)
        {
          j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
          if (j > 0) {
            break label1603;
          }
          updateComicEffectRenderItems(2, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
          localObject1 = RenderProcessForComicEffectRenderItems(2, paramFrame, this.mComicEffectRenderItems);
        }
        return localObject1;
        paramFrame = (Frame)localObject1;
        if (localObject3 != null)
        {
          paramFrame = (Frame)localObject1;
          if (((List)localObject3).size() > 0)
          {
            updateRenderItems((PTDetectInfo)localObject4, this.starParticleRenderItems.subList(0, Math.min(((List)localObject3).size(), this.starParticleRenderItems.size())));
            paramFrame = RenderProcessForFastParticleRenderItem((Frame)localObject1, this.starParticleRenderItems.subList(0, Math.min(((List)localObject3).size(), this.starParticleRenderItems.size())));
          }
        }
      }
      label865:
      localObject3 = paramPTFaceAttr.getStarPoints();
      localObject4 = new PTDetectInfo.Builder().facePoints((List)((List)localObject2).get(0)).faceAngles((float[])((List)localObject5).get(0)).phoneAngle(i).faceActionCounter((Map)localObject1).aiAttr(this.aiAttr).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression((Set)localObject4).displacementMaskFrame(this.displacementMaskFrame).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints((List)localObject3).build();
      this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerRenderItems, paramFrame, (PTDetectInfo)localObject4);
      if (this.mZoomRenderItem != null) {
        if (this.mFabbyMvFiltersRenderItem == null) {
          break label1790;
        }
      }
      label1190:
      label1199:
      label1208:
      label1603:
      label1787:
      label1790:
      for (localObject1 = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; localObject1 = null)
      {
        localObject5 = this.mZoomRenderItem.filter;
        if (localObject5 != null)
        {
          localObject6 = (ZoomTriggerCtrlItem)this.mZoomRenderItem.triggerCtrlItem;
          if (localObject1 != null) {
            break label1190;
          }
          i = this.mCurMVPart;
          ((ZoomTriggerCtrlItem)localObject6).updateTriggerStatus((PTDetectInfo)localObject4, i);
          ((ZoomFilter)localObject5).setZoomModel(((ZoomTriggerCtrlItem)localObject6).getZoomModel());
          localObject5 = (ZoomFilter)localObject5;
          j = paramFrame.width;
          k = paramFrame.height;
          if (localObject1 != null) {
            break label1199;
          }
        }
        for (i = this.mCurMVPart;; i = ((FabbyFilters)localObject1).getCurPartIndex())
        {
          ((ZoomFilter)localObject5).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject4, j, k, i);
          if (this.mMaskStickerRenderItemList == null) {
            break label1208;
          }
          localObject1 = this.mMaskStickerRenderItemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject5 = (RenderItem)((Iterator)localObject1).next();
            localObject6 = (VideoFilterBase)((RenderItem)localObject5).filter;
            if ((localObject6 instanceof NormalVideoFilter))
            {
              ((VideoFilterBase)localObject6).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
              ((RenderItem)localObject5).updatePreview(localObject4);
            }
          }
          i = ((FabbyFilters)localObject1).getCurPartIndex();
          break;
        }
        updateRenderItems((PTDetectInfo)localObject4, this.fgStaticStickerRenderItems);
        paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerRenderItems);
        updateRenderItems((PTDetectInfo)localObject4, this.faceParticleStaticRenderItems);
        paramFrame = RenderProcessForRenderItems(paramFrame, this.faceParticleStaticRenderItems);
        updateRenderItems((PTDetectInfo)localObject4, this.faceGpuParticleStaticRenderItems);
        localObject1 = RenderProcessForGpuParticleRenderItems(paramFrame, this.faceGpuParticleStaticRenderItems);
        if (paramPTFaceAttr.getStarMaskFrame() != null)
        {
          this.starOverlayFilter.setTexture2(paramPTFaceAttr.getStarMaskFrame().getTextureId());
          this.starOverlayFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.starOverlayFrame);
          paramFrame = this.starOverlayFrame;
          paramPTFaceAttr.getStarMaskFrame().unlock();
          break;
        }
        paramFrame = (Frame)localObject1;
        if (localObject3 == null) {
          break;
        }
        paramFrame = (Frame)localObject1;
        if (((List)localObject3).size() <= 0) {
          break;
        }
        updateRenderItems((PTDetectInfo)localObject4, this.starParticleRenderItems.subList(0, Math.min(((List)localObject3).size(), this.starParticleRenderItems.size())));
        paramFrame = RenderProcessForFastParticleRenderItem((Frame)localObject1, this.starParticleRenderItems.subList(0, Math.min(((List)localObject3).size(), this.starParticleRenderItems.size())));
        break;
        i = 0;
        while ((i < j) && (i < this.mFaceList.size()))
        {
          localObject3 = (Face)this.mFaceList.get(i);
          localObject1 = new ArrayList();
          if (localPTHandAttr != null) {
            localObject1 = localPTHandAttr.getHandPointList();
          }
          updateEffectTriggerFilters(2, new PTDetectInfo.Builder().facePoints(((Face)localObject3).facePoints).faceAngles(((Face)localObject3).faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).displacementMaskFrame(this.displacementMaskFrame).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerRenderItems);
          paramFrame = RenderProcessForEffectTriggerRenderItems(2, paramFrame, this.mEffectTriggerRenderItems);
          i += 1;
          continue;
          i = 0;
          for (;;)
          {
            localObject1 = paramFrame;
            if (i >= j) {
              break;
            }
            localObject1 = paramFrame;
            if (i >= this.mFaceList.size()) {
              break;
            }
            localObject2 = (Face)this.mFaceList.get(i);
            localObject1 = new ArrayList();
            if (localPTHandAttr != null) {
              localObject1 = localPTHandAttr.getHandPointList();
            }
            updateComicEffectRenderItems(2, new PTDetectInfo.Builder().facePoints(((Face)localObject2).facePoints).faceAngles(((Face)localObject2).faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectRenderItems, paramFrame.width, paramFrame.height);
            paramFrame = RenderProcessForComicEffectRenderItems(2, paramFrame, this.mComicEffectRenderItems);
            i += 1;
          }
        }
        break label659;
        break label659;
      }
    }
  }
  
  public Frame updateAndRenderStaticStickersBeforeTransform(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    Map localMap = paramPTFaceAttr.getFaceActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    long l = paramPTFaceAttr.getTimeStamp();
    GlUtil.setBlendMode(true);
    if (localList1.size() <= 0)
    {
      paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap).aiAttr(this.aiAttr).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      if (!isMaterialSegmentRequired()) {
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerRenderItems, paramFrame, paramPTFaceAttr);
      }
      updateRenderItems(paramPTFaceAttr, this.fgStaticStickerBeforeTransformRenderItems);
    }
    for (paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerBeforeTransformRenderItems);; paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerBeforeTransformRenderItems))
    {
      GlUtil.setBlendMode(false);
      return paramFrame;
      paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression(localSet).aiAttr(this.aiAttr).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
      if (!isMaterialSegmentRequired()) {
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerRenderItems, paramFrame, paramPTFaceAttr);
      }
      updateRenderItems(paramPTFaceAttr, this.fgStaticStickerBeforeTransformRenderItems);
    }
  }
  
  public Frame updateAndRenderStaticStickersPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    int i = (paramPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    Object localObject4 = paramPTFaceAttr.getAllFacePoints();
    Object localObject2 = paramPTFaceAttr.getFaceActionCounter();
    Object localObject3 = paramPTFaceAttr.getTriggeredExpression();
    long l;
    if (this.aiAttr == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((Set)localObject3).add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
      }
      localObject1 = paramPTFaceAttr.getAllFaceAngles();
      l = paramPTFaceAttr.getTimeStamp();
      GlUtil.setBlendMode(true);
      if (((List)localObject4).size() > 0) {
        break label479;
      }
      localObject1 = paramPTFaceAttr.getStarPoints();
      localObject2 = new PTDetectInfo.Builder().faceActionCounter((Map)localObject2).aiAttr(this.aiAttr).triggeredExpression((Set)localObject3).timestamp(l).phoneAngle(i).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints((List)localObject1).build();
      this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerRenderItems, paramFrame, (PTDetectInfo)localObject2);
      if (this.mZoomRenderItem != null) {
        if (this.mFabbyMvFiltersRenderItem == null) {
          break label844;
        }
      }
    }
    label415:
    label424:
    label433:
    label838:
    label844:
    for (Object localObject1 = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; localObject1 = null)
    {
      localObject3 = this.mZoomRenderItem.filter;
      label246:
      int j;
      int k;
      if (localObject3 != null)
      {
        localObject4 = (ZoomTriggerCtrlItem)this.mZoomRenderItem.triggerCtrlItem;
        if (localObject1 != null) {
          break label415;
        }
        i = this.mCurMVPart;
        ((ZoomTriggerCtrlItem)localObject4).updateTriggerStatus((PTDetectInfo)localObject2, i);
        ((ZoomFilter)localObject3).setZoomModel(((ZoomTriggerCtrlItem)localObject4).getZoomModel());
        localObject3 = (ZoomFilter)localObject3;
        j = paramFrame.width;
        k = paramFrame.height;
        if (localObject1 != null) {
          break label424;
        }
      }
      for (i = this.mCurMVPart;; i = ((FabbyFilters)localObject1).getCurPartIndex())
      {
        ((ZoomFilter)localObject3).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject2, j, k, i);
        if (this.mMaskStickerRenderItemList == null) {
          break label433;
        }
        localObject1 = this.mMaskStickerRenderItemList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (RenderItem)((Iterator)localObject1).next();
          localObject4 = (VideoFilterBase)((RenderItem)localObject3).filter;
          if ((localObject4 instanceof NormalVideoFilter))
          {
            ((VideoFilterBase)localObject4).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
            ((RenderItem)localObject3).updatePreview(localObject2);
          }
        }
        localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
        break;
        i = ((FabbyFilters)localObject1).getCurPartIndex();
        break label246;
      }
      updateRenderItems((PTDetectInfo)localObject2, this.fgStaticStickerRenderItems);
      paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerRenderItems);
      updateRenderItems((PTDetectInfo)localObject2, this.faceParticleStaticRenderItems);
      paramFrame = RenderProcessForRenderItems(paramFrame, this.faceParticleStaticRenderItems);
      GlUtil.setBlendMode(false);
      return paramFrame;
      label479:
      List localList = paramPTFaceAttr.getStarPoints();
      localObject2 = new PTDetectInfo.Builder().facePoints((List)((List)localObject4).get(0)).faceAngles((float[])((List)localObject1).get(0)).phoneAngle(i).faceActionCounter((Map)localObject2).aiAttr(this.aiAttr).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).triggeredExpression((Set)localObject3).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints(localList).build();
      this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerRenderItems, paramFrame, (PTDetectInfo)localObject2);
      if (this.mZoomRenderItem != null) {
        if (this.mFabbyMvFiltersRenderItem == null) {
          break label838;
        }
      }
      for (localObject1 = (FabbyFilters)this.mFabbyMvFiltersRenderItem.filter;; localObject1 = null)
      {
        localObject3 = this.mZoomRenderItem.filter;
        if (localObject3 != null)
        {
          localObject4 = (ZoomTriggerCtrlItem)this.mZoomRenderItem.triggerCtrlItem;
          if (localObject1 != null) {
            break label797;
          }
          i = this.mCurMVPart;
          ((ZoomTriggerCtrlItem)localObject4).updateTriggerStatus((PTDetectInfo)localObject2, i);
          ((ZoomFilter)localObject3).setZoomModel(((ZoomTriggerCtrlItem)localObject4).getZoomModel());
          localObject3 = (ZoomFilter)localObject3;
          j = paramFrame.width;
          k = paramFrame.height;
          if (localObject1 != null) {
            break label806;
          }
        }
        for (i = this.mCurMVPart;; i = ((FabbyFilters)localObject1).getCurPartIndex())
        {
          ((ZoomFilter)localObject3).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject2, j, k, i);
          if (this.mMaskStickerRenderItemList == null) {
            break label815;
          }
          localObject1 = this.mMaskStickerRenderItemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (RenderItem)((Iterator)localObject1).next();
            localObject4 = (VideoFilterBase)((RenderItem)localObject3).filter;
            if ((localObject4 instanceof NormalVideoFilter))
            {
              ((VideoFilterBase)localObject4).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
              ((RenderItem)localObject3).updatePreview(localObject2);
            }
          }
          i = ((FabbyFilters)localObject1).getCurPartIndex();
          break;
        }
        updateRenderItems((PTDetectInfo)localObject2, this.fgStaticStickerRenderItems);
        paramFrame = RenderProcessForRenderItems(paramFrame, this.fgStaticStickerRenderItems);
        break;
      }
    }
  }
  
  public Frame updateAndRenderStyleChild(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject1;
    if ((FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isModelLoaded(6)) && (this.styleChildRenderItems != null) && (this.styleChildRenderItems.size() > 0))
    {
      localObject1 = (RenderItem)this.styleChildRenderItems.get(0);
      if ((localObject1 != null) && (((RenderItem)localObject1).filter != null)) {
        break label60;
      }
    }
    label60:
    StyleChildFilter localStyleChildFilter;
    do
    {
      return paramFrame;
      localStyleChildFilter = (StyleChildFilter)((RenderItem)localObject1).filter;
      if ((paramPTFaceAttr.getAllFacePoints().size() <= 0) && (!localStyleChildFilter.isCartoonStyleMaterial())) {
        break;
      }
    } while ((((RenderItem)localObject1).triggerCtrlItem != null) && (!((RenderItem)localObject1).triggerCtrlItem.isTriggered()));
    boolean bool1;
    if (((localObject1 == null) || (((RenderItem)localObject1).filter == null) || ((((RenderItem)localObject1).triggerCtrlItem != null) && (((RenderItem)localObject1).triggerCtrlItem.isTriggered()))) && ((((RenderItem)localObject1).triggerCtrlItem instanceof StyleChildTriggerCtrlItem)))
    {
      localObject1 = (StyleChildTriggerCtrlItem)((RenderItem)localObject1).triggerCtrlItem;
      Object localObject2 = ((StyleChildTriggerCtrlItem)localObject1).getTriggeredPhoto();
      if ((localObject2 != null) && (!((String)localObject2).equals(this.preImagePath)))
      {
        LogUtils.d(TAG, "updateAndRenderStyleChild: photo:" + (String)localObject2);
        localStyleChildFilter.updateTextureBitmapList((String)localObject2);
        this.preImagePath = ((String)localObject2);
      }
      if ((((StyleChildTriggerCtrlItem)localObject1).getTriggeredCosFun() != null) && (!TextUtils.isEmpty(((StyleChildTriggerCtrlItem)localObject1).getTriggeredCosFun())))
      {
        LogUtils.d(TAG, "updateAndRenderStyleChild: crazyFace:" + ((StyleChildTriggerCtrlItem)localObject1).getTriggeredCosFun());
        bool2 = getIsPositiveFace(paramPTFaceAttr, paramFrame);
        if (this.preFaceCounts == paramPTFaceAttr.getAllFacePoints().size()) {
          break label490;
        }
        bool1 = true;
        label301:
        if (bool2) {
          this.postiveFaceCounts += 1;
        }
        localObject2 = this.material;
        if (this.postiveFaceCounts < 3) {
          break label495;
        }
        bool2 = true;
        label333:
        localStyleChildFilter.initCosFunTransitionFilter((VideoMaterial)localObject2, bool1, bool2, paramPTFaceAttr, paramFrame, ((StyleChildTriggerCtrlItem)localObject1).getTriggeredCosFun(), ((StyleChildTriggerCtrlItem)localObject1).getTriggeredStickerItem());
        this.preFaceCounts = paramPTFaceAttr.getAllFacePoints().size();
      }
    }
    if ((localStyleChildFilter != null) && (localStyleChildFilter.isCrazyFacePath()))
    {
      bool2 = getIsPositiveFace(paramPTFaceAttr, paramFrame);
      if (this.preFaceCounts == paramPTFaceAttr.getAllFacePoints().size()) {
        break label501;
      }
      bool1 = true;
      label407:
      if (bool2) {
        this.postiveFaceCounts += 1;
      }
      localObject1 = this.material;
      if (this.postiveFaceCounts < 3) {
        break label506;
      }
    }
    label490:
    label495:
    label501:
    label506:
    for (boolean bool2 = true;; bool2 = false)
    {
      localStyleChildFilter.initCosFunTransitionFilter((VideoMaterial)localObject1, bool1, bool2, paramPTFaceAttr, paramFrame, null);
      this.preFaceCounts = paramPTFaceAttr.getAllFacePoints().size();
      if (!localStyleChildFilter.getIsCosTransProcessed()) {
        break;
      }
      return localStyleChildFilter.render(localStyleChildFilter.updateAndRender(paramFrame, paramPTFaceAttr, this.mFaceDetScale));
      bool1 = false;
      break label301;
      bool2 = false;
      break label333;
      bool1 = false;
      break label407;
    }
    localStyleChildFilter.resetNeedCalFaceMoveDownParam();
    this.preFaceCounts = paramPTFaceAttr.getAllFacePoints().size();
    return paramFrame;
  }
  
  public Frame updateAndRenderStyleChildWarp(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    RenderItem localRenderItem;
    if ((FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isModelLoaded(6)) && (this.styleChildRenderItems != null) && (this.styleChildRenderItems.size() > 0))
    {
      localRenderItem = (RenderItem)this.styleChildRenderItems.get(0);
      if ((localRenderItem != null) && (localRenderItem.filter != null)) {
        break label57;
      }
    }
    label57:
    StyleChildFilter localStyleChildFilter;
    do
    {
      return paramFrame;
      localStyleChildFilter = (StyleChildFilter)localRenderItem.filter;
    } while ((paramPTFaceAttr == null) || (paramPTFaceAttr.getAllFacePoints().size() <= 0) || ((localRenderItem.triggerCtrlItem != null) && (!localRenderItem.triggerCtrlItem.isTriggered())));
    return localStyleChildFilter.renderWarp(paramFrame);
  }
  
  public Frame updateAndRenderStylyFilters(int paramInt, Frame paramFrame)
  {
    Object localObject = paramFrame;
    if (this.mStyleFilterRenderItems != null)
    {
      Iterator localIterator = this.mStyleFilterRenderItems.iterator();
      for (;;)
      {
        localObject = paramFrame;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (RenderItem)localIterator.next();
        if (localObject != null)
        {
          if ((localObject instanceof RenderOrderItem)) {
            ((RenderOrderItem)localObject).updateCurrentOrder(paramInt);
          }
          localObject = ((RenderItem)localObject).RenderProcess(paramFrame);
          if (localObject != paramFrame) {
            paramFrame.unlock();
          }
          paramFrame = (Frame)localObject;
        }
      }
    }
    return localObject;
  }
  
  public Frame updateCatStickers(Frame paramFrame, PTDetectInfo paramPTDetectInfo)
  {
    GlUtil.setBlendMode(true);
    if (this.aiAttr == null) {}
    for (AECatAttr localAECatAttr = null;; localAECatAttr = (AECatAttr)this.aiAttr.getAvailableData(AEDetectorType.CAT.value))
    {
      Frame localFrame = paramFrame;
      if (localAECatAttr != null)
      {
        paramPTDetectInfo.catFacePoints = localAECatAttr.getCatPointList();
        paramPTDetectInfo.catFaceAngles = localAECatAttr.getAngles();
        updateRenderItems(paramPTDetectInfo, this.catRenderItems);
        localFrame = RenderProcessForRenderItems(paramFrame, this.catRenderItems);
      }
      GlUtil.setBlendMode(false);
      return localFrame;
    }
  }
  
  public void updateComicEffectRenderItems(int paramInt1, PTDetectInfo paramPTDetectInfo, List<RenderItem> paramList, int paramInt2, int paramInt3)
  {
    if (this.filters == null) {}
    for (;;)
    {
      return;
      paramPTDetectInfo = paramList.iterator();
      while (paramPTDetectInfo.hasNext())
      {
        paramList = (RenderItem)paramPTDetectInfo.next();
        if (((paramList.filter instanceof ComicEffectFilter)) && (paramInt1 == ((ComicEffectFilter)paramList.filter).getOrderMode())) {
          ((ComicEffectFilter)paramList.filter).setAlreadyRenderInSingleFrame(false);
        }
      }
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
    if ((VideoMaterialUtil.isCosMaterial(getMaterial())) && (this.mFaceOffRenderItems != null))
    {
      Iterator localIterator = this.mFaceOffRenderItems.iterator();
      while (localIterator.hasNext())
      {
        AEFilterI localAEFilterI = ((RenderItem)localIterator.next()).filter;
        if ((localAEFilterI instanceof FaceOffFilter)) {
          ((FaceOffFilter)localAEFilterI).setCosAlpha(paramInt / 100.0F);
        }
        if ((localAEFilterI instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localAEFilterI).setCosAlpha(paramInt / 100.0F);
        }
      }
    }
  }
  
  @Deprecated
  public void updateCurrentTriggerParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr) {}
  
  public void updateEffectTriggerFilters(int paramInt, PTDetectInfo paramPTDetectInfo, List<RenderItem> paramList)
  {
    if (this.filters == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        if (((localRenderItem.filter instanceof EffectTriggerFilter)) && (paramInt == ((EffectTriggerFilter)localRenderItem.filter).getOrderMode())) {
          localRenderItem.filter.updatePreview(paramPTDetectInfo);
        }
      }
    }
  }
  
  public void updateFaceParams(AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, int paramInt)
  {
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    List localList3 = paramPTFaceAttr.getShookFaceInfos();
    List localList4 = paramPTFaceAttr.getFaceStatusList();
    List localList5 = paramPTFaceAttr.getPointsVis();
    int i = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
    processMappingFace(localList1, localList2, localList5, localList4, paramInt);
    updateShookHead(localList3);
    if (i <= 0)
    {
      clearGenderRangeItemStatus();
      clearPopularRangeItemStatus();
      clearAgeRangeItemStatus();
      clearFaceMappingData();
    }
    if (i < 2) {
      clearCpRangeItemStatus();
    }
    boolean bool = hasHands((PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value));
    if (!bool) {
      clearHandsRangeItemStatus();
    }
    if (this.cosFunFilterGroup != null)
    {
      this.cosFunFilterGroup.updateParams(paramPTFaceAttr);
      if (CosFunHelper.isRestart) {
        doReset();
      }
    }
    syncRandomGroupValue(bool);
  }
  
  public void updateFilters(PTDetectInfo paramPTDetectInfo, List<? extends VideoFilterBase> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoFilterBase)paramList.next()).updatePreview(paramPTDetectInfo);
      }
    }
  }
  
  public void updateFilters(PTDetectInfo paramPTDetectInfo, List<? extends VideoFilterBase> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
        if ((localVideoFilterBase instanceof FaceOffFilter)) {
          localVideoFilterBase.updatePreview(paramPTDetectInfo, paramInt1, paramInt2);
        } else {
          localVideoFilterBase.updatePreview(paramPTDetectInfo);
        }
      }
    }
  }
  
  public Frame updateInputFrame(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mFrozenRender != null) {
      localFrame = this.mFrozenRender.updateInputFrame(paramFrame, this.mCopyFilter);
    }
    return localFrame;
  }
  
  public Frame updateInputFrame(Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame = paramFrame1;
    if (this.mFrozenRender != null) {
      localFrame = this.mFrozenRender.updateInputFrame(paramFrame1, paramFrame2, this.mCopyFilter);
    }
    return localFrame;
  }
  
  public PTFaceAttr updatePTFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.mFrozenRender != null) {
      localPTFaceAttr = this.mFrozenRender.updatePTFaceAttr(paramPTFaceAttr);
    }
    return localPTFaceAttr;
  }
  
  public PTSegAttr updatePTSegAttr(PTSegAttr paramPTSegAttr)
  {
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.mFrozenRender != null) {
      localPTSegAttr = this.mFrozenRender.updatePTSegAttr(paramPTSegAttr, this.mCopyFilter);
    }
    return localPTSegAttr;
  }
  
  public Frame updateParticleStatic(Frame paramFrame, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    GlUtil.setBlendMode(true);
    updateRenderItems(paramPTDetectInfo, this.faceParticleStaticRenderItems);
    paramFrame = RenderProcessForRenderItems(paramFrame, this.faceParticleStaticRenderItems);
    updateRenderItems(paramPTDetectInfo, this.faceGpuParticleStaticRenderItems);
    paramFrame = RenderProcessForGpuParticleRenderItems(paramFrame, this.faceGpuParticleStaticRenderItems);
    updateRenderItems(paramPTDetectInfo, this.faceParticleDynamicRenderItems);
    paramFrame = RenderProcessForRenderItems(paramFrame, this.multiViewerOutFrame, this.faceParticleDynamicRenderItems);
    updateRenderItems(paramPTDetectInfo, this.faceGpuParticleDynamicRenderItems);
    paramFrame = RenderProcessForGpuParticleRenderItems(paramFrame, this.multiViewerOutFrame, this.faceGpuParticleDynamicRenderItems);
    updateRenderItems(paramPTDetectInfo, this.bodyParticleRenderItems);
    Frame localFrame = RenderProcessForFastParticleRenderItem(paramFrame, this.bodyParticleRenderItems);
    paramFrame = localFrame;
    if (isHandPointsValid(paramList))
    {
      updateRenderItems(paramPTDetectInfo, this.gestureParticleRenderItems);
      paramFrame = RenderProcessForRenderItems(localFrame, this.gestureParticleRenderItems);
      updateRenderItems(paramPTDetectInfo, this.gestureGpuParticleRenderItems);
      paramFrame = RenderProcessForGpuParticleRenderItems(paramFrame, this.gestureGpuParticleRenderItems);
    }
    GlUtil.setBlendMode(false);
    return paramFrame;
  }
  
  public void updateRandomValues()
  {
    if (this.cosFunFilterGroup != null) {
      hitCharmRangeItem(0);
    }
    hitHandsRangeItem();
    hitHandRandomGroupItem();
  }
  
  public void updateRenderItems(PTDetectInfo paramPTDetectInfo, List<RenderItem> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((RenderItem)paramList.next()).updatePreview(paramPTDetectInfo);
      }
    }
  }
  
  public void updateRenderItems(PTDetectInfo paramPTDetectInfo, List<RenderItem> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RenderItem localRenderItem = (RenderItem)paramList.next();
        AEFilterI localAEFilterI = localRenderItem.filter;
        if ((localAEFilterI instanceof FaceOffFilter)) {
          ((FaceOffFilter)localAEFilterI).updatePreview(paramPTDetectInfo, paramInt1, paramInt2, localRenderItem.triggerCtrlItem.getFrameIndex());
        } else {
          localAEFilterI.updatePreview(paramPTDetectInfo);
        }
      }
    }
  }
  
  public void updateRenderItemsVideoSize(List<RenderItem> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if ((localRenderItem.filter instanceof VideoFilterBase)) {
        ((VideoFilterBase)localRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong, AIAttr paramAIAttr)
  {
    Object localObject;
    if (this.multiViewerFilters != null)
    {
      localObject = this.multiViewerFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MultiViewerFilter)((Iterator)localObject).next()).updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
      }
    }
    updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
    if (this.cosFunFilterGroup != null) {
      this.cosFunFilterGroup.updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
    }
    if ((isAllFreezeFrame()) && (paramSet != null)) {
      paramSet.add(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject != null)
      {
        this.mFabbyMvFiltersRenderItem.updatePreview(null);
        ((FabbyFilters)localObject).updateTextureParam(paramMap, paramSet, paramLong, paramAIAttr);
      }
    }
  }
  
  public void updateTriggerManager(PTDetectInfo paramPTDetectInfo)
  {
    if (this.triggerManager != null) {
      this.triggerManager.updateTriggerStatus(paramPTDetectInfo);
    }
    if (this.multiViewerFilters != null)
    {
      Iterator localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext())
      {
        MultiViewerFilter localMultiViewerFilter = (MultiViewerFilter)localIterator.next();
        if (localMultiViewerFilter != null) {
          localMultiViewerFilter.updateTriggerManager(paramPTDetectInfo);
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mFaceDetScale = paramDouble;
    updateRenderItemsVideoSize(this.renderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.gestureRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.bodyRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.mFaceOffRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.catRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.faceParticleDynamicRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.faceParticleStaticRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.gestureParticleRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.bodyParticleRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.starParticleRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.faceGpuParticleDynamicRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.faceGpuParticleStaticRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.gestureGpuParticleRenderItems, paramInt1, paramInt2, paramDouble);
    updateRenderItemsVideoSize(this.headCropRenderItems, paramInt1, paramInt2, paramDouble);
    Object localObject = this.qqGestureStaticFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localObject = this.qqGestureDynamicFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFabbyMvFiltersRenderItem != null)
    {
      localObject = this.mFabbyMvFiltersRenderItem.filter;
      if (localObject != null) {
        ((FabbyFilters)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if ((this.headCropRenderItem != null) && (this.headCropRenderItem.filter != null)) {
      ((VideoFilterBase)this.headCropRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FacialFeatureFilter)((Iterator)localObject).next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFastFaceStickerRenderItems != null)
    {
      localObject = this.mFastFaceStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if (this.mFastBodyStickerRenderItems != null)
    {
      localObject = this.mFastBodyStickerRenderItems.filter;
      if (localObject != null) {
        ((FastStickerFilter)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    this.mFaceOffNoseOcclusionFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.mMaskStickerRenderItemList != null)
    {
      localObject = this.mMaskStickerRenderItemList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)((RenderItem)((Iterator)localObject).next()).filter;
        if ((localVideoFilterBase instanceof FastMaskFilter)) {
          ((FastMaskFilter)localVideoFilterBase).updateVideoSize(paramInt1, paramInt2, paramDouble);
        } else if ((localVideoFilterBase instanceof DynamicMaskFilter)) {
          ((DynamicMaskFilter)localVideoFilterBase).updateVideoSize(paramInt1, paramInt2, paramDouble);
        }
      }
    }
    if ((paramInt1 != this.filterWidth) || (paramInt2 != this.filterHeight))
    {
      if (this.gaussianCompose != null) {
        this.gaussianCompose.destroy();
      }
      this.gaussianCompose = new GaussianBlurFilterCompose();
      this.gaussianCompose.setRadius(2.0F);
      this.gaussianCompose.init(paramInt1, paramInt2);
      this.filterWidth = paramInt1;
      this.filterHeight = paramInt2;
    }
  }
  
  public Frame zoomFrame(Frame paramFrame)
  {
    if (this.mZoomRenderItem != null)
    {
      localObject = this.mZoomRenderItem.filter;
      if (localObject == null) {}
    }
    for (Object localObject = ((ZoomFilter)localObject).RenderProcess(paramFrame);; localObject = paramFrame)
    {
      if (localObject != paramFrame) {
        paramFrame.unlock();
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */