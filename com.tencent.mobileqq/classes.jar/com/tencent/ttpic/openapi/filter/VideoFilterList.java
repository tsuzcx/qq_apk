package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
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
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FaceOffNoseOcclusionFilter;
import com.tencent.ttpic.filter.FacialFeatureFilter;
import com.tencent.ttpic.filter.FastBlurFilter;
import com.tencent.ttpic.filter.FastParticleFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.HairCos;
import com.tencent.ttpic.filter.HairDecolor;
import com.tencent.ttpic.filter.HairSticker;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LutItemsFilter;
import com.tencent.ttpic.filter.MaterialLoadFinishListener;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.PhantomFilter;
import com.tencent.ttpic.filter.SkyboxItemsFilter;
import com.tencent.ttpic.filter.StarOverlayFilter;
import com.tencent.ttpic.filter.StaticCountFilter;
import com.tencent.ttpic.filter.StaticNumFilter;
import com.tencent.ttpic.filter.SwitchFaceFilter;
import com.tencent.ttpic.filter.VideoFilterInputFreeze;
import com.tencent.ttpic.filter.VideoFilterListSnapshot;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter;
import com.tencent.ttpic.manager.MaterialManager;
import com.tencent.ttpic.manager.RandomGroupManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
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
import com.tencent.ttpic.openapi.filter.zoomfilter.ZoomFilter;
import com.tencent.ttpic.openapi.initializer.RapidNetSDKInitializer;
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
import com.tencent.ttpic.particle.GPUParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter3D;
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
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class VideoFilterList
{
  private static final int ALWAYS_TRIGGERED_RANDOM_INDEX = 0;
  public static final String FABBY_LOG = "[FABBY]";
  private static final int HAND_RANDOM_INDEX = 0;
  public static final int MAX_FACE_COUNT = 99;
  public static final String PERF_LOG = "[showPreview]";
  private static String TAG = VideoFilterList.class.getSimpleName();
  private static final Random mRandom = new Random(System.currentTimeMillis());
  public static boolean sIsUseFreezeFrame = false;
  private AIAttr aiAttr;
  private CameraARFilterGesture arFilterGesture;
  private List<VideoFilterBase> bgDynamicStickerFilters;
  private List<VideoFilterBase> bgStaticStickerFilters;
  private List<NormalVideoFilter> bodyFilters = new ArrayList();
  private List<VideoFilterBase> bodyParticleFilters = new ArrayList();
  private Frame[] copyFrame = new Frame[2];
  private CosFunFilterGroup cosFunFilterGroup;
  private CrazyFaceFilters crazyFaceFilters;
  private LinkedList<FaceInfo> currentFaceInfo;
  public int detecFaceCount = 0;
  private boolean directDraw;
  private FabbyExtractFilter fabbyExtractFilter;
  private Frame fabbyFeatheredMaskStep1 = new Frame();
  private Frame fabbyFeatheredMaskStep2 = new Frame();
  private FabbyFilters fabbyMvFilters;
  private Frame fabbyOriginCopyFrame = new Frame();
  private FabbyShakeStrokeFilter fabbyShakeStrokeFilter;
  private FabbyStrokeFilter fabbyStrokeFilter;
  private Frame fabbyStrokeFrame = new Frame();
  private Frame fabbyStrokeShakeFrame = new Frame();
  private List<VideoFilterBase> faceGpuParticleDynamicFilters = new ArrayList();
  private List<VideoFilterBase> faceGpuParticleStaticFilters = new ArrayList();
  private List<VideoFilterBase> faceParticleDynamicFilters = new ArrayList();
  private List<VideoFilterBase> faceParticleStaticFilters = new ArrayList();
  private FastBlurFilter fastBlurFilter;
  private FastStickerFilter fastBodyStickerFilter;
  private FastStickerFilter fastFaceStickerFilter;
  private FastParticleFilter fastParticleFilter = new FastParticleFilter();
  private List<VideoFilterBase> fgDynamicFilters;
  private List<VideoFilterBase> fgStaticStickerBeforeTransformFilters;
  private List<VideoFilterBase> fgStaticStickerFilters;
  private FilamentFilter filamentFilter;
  private FilamentParticleFilter filamentParticleFilter;
  public int filterHeight = 0;
  public int filterWidth = 0;
  private List<VideoFilterBase> filters = new ArrayList();
  private Frame freezeFrameSnapshotFrame;
  private GaussianBlurFilterCompose gaussianCompose;
  private List<NormalVideoFilter> gestureFilters = new ArrayList();
  private List<GPUParticleFilter> gestureGpuParticleFilters = new ArrayList();
  private List<VideoFilterBase> gestureParticleFilters = new ArrayList();
  private HairCos hairCos;
  private int hasFreezeFrameStatus = -1;
  private HeadCropFilter headCropFilter;
  private List<NormalVideoFilter> headCropItemFilters = new ArrayList();
  private VideoFilterInputFreeze inputFreezeFrameFilter;
  private LutItemsFilter lutItemsFilter;
  private ARParticleFilter mARParticleFilter;
  private Queue<PointF> mARTouchPointQueue = new LinkedList();
  private ActFilters mActFilters;
  private Map<Integer, Float> mAgeValueMap = new HashMap();
  private Frame mBgFrame = new Frame();
  private BlurMaskFilter mBlurMaskFilter;
  private Map<Integer, Double> mCharmValueMap = new HashMap();
  private List<ComicEffectFilter> mComicEffectFilters;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] mCopyMaskFrame = new Frame[2];
  private Map<Integer, Float> mCpValueMap = new HashMap();
  private int mCurMVPart = 0;
  private PersonParam mCurPersonParam = new PersonParam();
  private VideoFilterBase mEffectFilter;
  private Frame mEffectFrame = new Frame();
  private int mEffectOrder = -1;
  private List<EffectTriggerFilter> mEffectTriggerFilters;
  private double mFaceDetScale;
  private Comparator<Face> mFaceIndexComperator = new VideoFilterList.2(this);
  private List<Face> mFaceList = new ArrayList();
  private List<VideoFilterBase> mFaceOffFilters;
  private FaceOffNoseOcclusionFilter mFaceOffNoseOcclusionFilter = new FaceOffNoseOcclusionFilter();
  private List<FacialFeatureFilter> mFacialFeatureFilterList;
  private Map<Integer, Float> mGenderValueMap = new HashMap();
  private Map<Integer, Double> mHandsValueMap = new HashMap();
  private Frame mHeadCropFrame = new Frame();
  private BaseFilter mMaskFilter;
  private MaskMergeFilter mMaskMergeFilter = new MaskMergeFilter();
  private List<VideoFilterBase> mMaskStickerFilterList;
  private Frame mMaskStickerFrame = new Frame();
  private List<PointF> mMaskTouchPoints = new ArrayList();
  private Frame mMergeMaskFrame = new Frame();
  private PhantomFilter mPhantomFilter;
  private Frame mPhantomFrame = new Frame();
  private Map<Integer, Float> mPopularValueMap = new HashMap();
  private float mScaleFace = 1.0F;
  private List<List<PointF>> mTouchPoints = new ArrayList();
  private List<VideoFilterBase> mTransformFilters;
  private ZoomFilter mZoomFilter;
  private VideoMaterial material;
  private List<MultiViewerFilter> multiViewerFilters;
  public Map<Integer, Frame> multiViewerFrameMap = new HashMap();
  private Frame multiViewerOutFrame;
  private int multiViewerSrcTexture;
  private boolean needDetectEmotion = false;
  private boolean needDetectGender = false;
  private boolean needDetectGesture = false;
  private boolean needDetectGestureBonePoint = false;
  private int onlyDetectOneGesture = -999;
  private List<VideoFilterBase> qqGestureDynamicFilters = new ArrayList();
  private List<VideoFilterBase> qqGestureStaticFilters = new ArrayList();
  private List<RapidNetFilter> rapidNetFilterList = new ArrayList();
  private Frame renderFrame = new Frame();
  private int selectFaceIndex = -1;
  public int shookHeadCount = 0;
  private int shookType = 0;
  private SkyboxItemsFilter skyboxItemsFilter;
  private SnapShotFrameToSticker snapShotFrameToSticker = new SnapShotFrameToSticker();
  private int snapshotTexture;
  private StarOverlayFilter starOverlayFilter = new StarOverlayFilter();
  private Frame starOverlayFrame = new Frame();
  private List<VideoFilterBase> starParticleFilters = new ArrayList();
  public List<StaticCountFilter> staticCountFilters;
  private VoiceTextFilter voiceTextFilter;
  
  private Frame RenderProcessForComicEffectFilters(int paramInt, Frame paramFrame, List<ComicEffectFilter> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame;
    }
    Frame localFrame2;
    int i;
    Frame localFrame1;
    label80:
    ComicEffectFilter localComicEffectFilter;
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      i = 0;
      localFrame1 = paramFrame;
      if (i >= paramList.size()) {
        break label189;
      }
      localComicEffectFilter = (ComicEffectFilter)paramList.get(i);
      if (paramInt == localComicEffectFilter.getOrderMode()) {
        break label133;
      }
    }
    for (;;)
    {
      i += 1;
      break label80;
      localFrame2 = this.copyFrame[0];
      break;
      label133:
      if ((localComicEffectFilter.isRenderReady()) && (!localComicEffectFilter.isAlreadyRenderInSingleFrame()))
      {
        localFrame1 = VideoFrameUtil.renderProcessByForAnimationEffectFilter(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localComicEffectFilter, paramFrame, localFrame2);
        localComicEffectFilter.setAlreadyRenderInSingleFrame(true);
      }
    }
    label189:
    return localFrame1;
  }
  
  private Frame RenderProcessForEffectTriggerFilters(int paramInt, Frame paramFrame, List<EffectTriggerFilter> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    while ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame;
    }
    Frame localFrame2;
    int i;
    Frame localFrame1;
    label80:
    EffectTriggerFilter localEffectTriggerFilter;
    if (paramFrame.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame2 = this.copyFrame[1];
      GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
      GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
      i = 0;
      localFrame1 = paramFrame;
      if (i >= paramList.size()) {
        break label189;
      }
      localEffectTriggerFilter = (EffectTriggerFilter)paramList.get(i);
      if (paramInt == localEffectTriggerFilter.getOrderMode()) {
        break label133;
      }
    }
    for (;;)
    {
      i += 1;
      break label80;
      localFrame2 = this.copyFrame[0];
      break;
      label133:
      if ((localEffectTriggerFilter.isRenderReady()) && (!localEffectTriggerFilter.isAlreadyRenderInSingleFrame()))
      {
        localFrame1 = VideoFrameUtil.renderProcessByForEffectTriggerFilter(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localEffectTriggerFilter, paramFrame, localFrame2);
        localEffectTriggerFilter.setAlreadyRenderInSingleFrame(true);
      }
    }
    label189:
    return localFrame1;
  }
  
  private Frame RenderProcessForFastBodyStickerFilter(Frame paramFrame1, Frame paramFrame2, PTDetectInfo paramPTDetectInfo)
  {
    if (paramFrame2 == null) {}
    for (;;)
    {
      this.fastBodyStickerFilter.setFaceCount(1);
      this.fastBodyStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
      this.fastBodyStickerFilter.updatePreview(paramPTDetectInfo);
      this.fastBodyStickerFilter.setRenderParams(new PersonParam().setPersonID(0));
      this.fastBodyStickerFilter.Render(paramFrame1);
      return paramFrame1;
      paramFrame1 = paramFrame2;
    }
  }
  
  private Frame RenderProcessForFastFaceStickerFilter(Frame paramFrame1, Frame paramFrame2, List<Face> paramList, int paramInt, PTFaceAttr paramPTFaceAttr, PersonParam paramPersonParam, AIAttr paramAIAttr)
  {
    if (paramFrame2 == null) {}
    for (;;)
    {
      this.fastFaceStickerFilter.setFaceCount(paramInt);
      this.fastFaceStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
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
      paramFrame2 = new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramFrame2).timestamp(paramPTFaceAttr.getTimeStamp()).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      this.fastFaceStickerFilter.updatePreview(paramFrame2);
      this.fastFaceStickerFilter.Render(paramFrame1);
      return paramFrame1;
      paramFrame1 = paramFrame2;
    }
    paramAIAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (paramAIAttr != null) {}
    for (paramFrame2 = paramAIAttr.getHandPointList();; paramFrame2 = null)
    {
      int i = 0;
      while ((i < paramInt) && (i < paramList.size()))
      {
        Object localObject = (Face)paramList.get(i);
        Set localSet = paramPTFaceAttr.getTriggeredExpression();
        if (paramAIAttr != null) {
          localSet.add(Integer.valueOf(paramAIAttr.getHandType()));
        }
        localObject = new PTDetectInfo.Builder().facePoints(((Face)localObject).facePoints).faceAngles(((Face)localObject).faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints(paramFrame2).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
        this.fastFaceStickerFilter.updatePreview(localObject);
        this.fastFaceStickerFilter.setRenderParams(paramPersonParam);
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
          break label395;
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
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
      if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform()))
      {
        paramFrame2 = VideoFrameUtil.renderProcessByCopy(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, this.mCopyFilter, paramFrame1, localFrame2);
        label287:
        BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
        localFrame1 = paramFrame2;
      }
    }
    for (;;)
    {
      this.directDraw = true;
      break;
      paramFrame2 = VideoFrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, localVideoFilterBase, paramFrame1, localFrame2);
      break label287;
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
    label395:
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
  
  private boolean allBusinessPrivateProcess(List<VideoFilterBase> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if ((localVideoFilterBase instanceof BuckleFaceFilter)) {
        return ((BuckleFaceFilter)localVideoFilterBase).isNeedRender();
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
    if (this.filters != null)
    {
      int i = 0;
      if (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
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
    if (this.filters != null)
    {
      int i = 0;
      if (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
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
    this.mCharmValueMap.clear();
  }
  
  private void clearCpRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      if (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
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
    if (this.filters != null)
    {
      int i = 0;
      if (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
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
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        StickerItem localStickerItem = ((NormalVideoFilter)this.gestureFilters.get(i)).getStickerItem();
        if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
          localStickerItem.charmRange.clearStatus();
        }
        i += 1;
      }
    }
    this.mHandsValueMap.clear();
  }
  
  private void clearPopularRangeItemStatus()
  {
    if (this.filters != null)
    {
      int i = 0;
      if (i < this.filters.size())
      {
        Object localObject = (VideoFilterBase)this.filters.get(i);
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
    Iterator localIterator = this.filters.iterator();
    VideoFilterBase localVideoFilterBase;
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
    localIterator = this.fgStaticStickerFilters.iterator();
    while (localIterator.hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).destroyAudio();
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.destroyAudio();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.destroyAudio();
    }
    if (this.bodyFilters != null)
    {
      localIterator = this.bodyFilters.iterator();
      while (localIterator.hasNext()) {
        ((NormalVideoFilter)localIterator.next()).destroyAudio();
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
  
  private int getMaskType(List<VideoFilterBase> paramList, FastMaskFilter paramFastMaskFilter)
  {
    int i = 0;
    int j = 0;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (i = j; paramList.hasNext(); i = ((StaticMaskFilter)paramList.next()).getMaskType()) {}
    }
    if (paramFastMaskFilter != null) {
      i = paramFastMaskFilter.getMaskType();
    }
    return i;
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
  
  private List<VideoFilterBase> getStickerFilters(List<? extends VideoFilterBase> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = getStaticStickerFilters(paramList);
    paramList = getExcludeFilters(paramList, localList);
    if (paramBoolean1) {
      return getZIndexFilters(localList, paramBoolean2);
    }
    return getZIndexFilters(paramList, paramBoolean2);
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
    Collections.sort(localArrayList, new VideoFilterList.1(this));
    return localArrayList;
  }
  
  private boolean hasHands(PTHandAttr paramPTHandAttr)
  {
    if (paramPTHandAttr == null) {
      return false;
    }
    Object localObject1 = paramPTHandAttr.getHandPointList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0) && (this.gestureFilters != null) && (this.gestureFilters.size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (PointF)((Iterator)localObject1).next();
        float f1 = ((PointF)localObject2).x;
        float f2 = ((PointF)localObject2).x;
        float f3 = ((PointF)localObject2).y;
        if (((PointF)localObject2).y * f3 + f1 * f2 >= 0.0001D)
        {
          localObject2 = (NormalVideoFilter)this.gestureFilters.get(0);
          if ((localObject2 != null) && (((NormalVideoFilter)localObject2).getStickerItem() != null)) {
            return TriggerUtil.isGestureTriggered(paramPTHandAttr, ((NormalVideoFilter)localObject2).getStickerItem().getTriggerTypeInt(), 0, null, null);
          }
        }
      }
    }
    return false;
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
    int j = 0;
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      int i;
      if (this.filters != null)
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
        i = 0;
        if (i < this.filters.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.ageRange != null) {
                localStickerItem.ageRange.setValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_AGE.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerFilterList != null)
      {
        i = j;
        while (i < this.mMaskStickerFilterList.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
          if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
          {
            paramVideoPreviewFaceOutlineDetector = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((paramVideoPreviewFaceOutlineDetector != null) && (paramVideoPreviewFaceOutlineDetector.ageRange != null)) {
              paramVideoPreviewFaceOutlineDetector.ageRange.setValue(((Float)this.mAgeValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitCharmRangeItem(int paramInt)
  {
    int j = 0;
    int i;
    Object localObject1;
    Object localObject2;
    if (this.filters != null)
    {
      i = 0;
      while (i < this.filters.size())
      {
        localObject1 = (VideoFilterBase)this.filters.get(i);
        if ((localObject1 instanceof NormalVideoFilter))
        {
          localObject2 = ((NormalVideoFilter)localObject1).getStickerItem();
          if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
            ((StickerItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof FaceOffFilter))
        {
          localObject2 = ((FaceOffFilter)localObject1).getFaceOffItem();
          if ((localObject2 != null) && (((FaceItem)localObject2).charmRange != null)) {
            ((FaceItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof FaceOff3DFilter))
        {
          localObject2 = ((FaceOff3DFilter)localObject1).getFaceOffItem();
          if ((localObject2 != null) && (((FaceItem)localObject2).charmRange != null)) {
            ((FaceItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        if ((localObject1 instanceof TransformFilter))
        {
          localObject1 = ((TransformFilter)localObject1).getFaceMeshItem();
          if ((localObject1 != null) && (((FaceMeshItem)localObject1).charmRange != null)) {
            ((FaceMeshItem)localObject1).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        i += 1;
      }
    }
    if (this.hairCos != null)
    {
      localObject1 = this.hairCos.getmLUTList();
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = ((HairDecolor)((List)localObject1).get(i)).getItem();
        if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
          ((StickerItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
        }
        i += 1;
      }
      localObject1 = this.hairCos.getmItemList();
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = ((HairSticker)((List)localObject1).get(i)).getItem();
        if ((localObject2 != null) && (((StickerItem)localObject2).charmRange != null)) {
          ((StickerItem)localObject2).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
        }
        i += 1;
      }
    }
    if (this.mMaskStickerFilterList != null)
    {
      i = j;
      while (i < this.mMaskStickerFilterList.size())
      {
        localObject1 = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
        if ((localObject1 instanceof NormalVideoFilter))
        {
          localObject1 = ((NormalVideoFilter)localObject1).getStickerItem();
          if ((localObject1 != null) && (((StickerItem)localObject1).charmRange != null)) {
            ((StickerItem)localObject1).charmRange.hit(((Double)this.mCharmValueMap.get(Integer.valueOf(paramInt))).doubleValue());
          }
        }
        i += 1;
      }
    }
  }
  
  private void hitCpRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue()) || (paramInt2 < 2)) {}
    for (;;)
    {
      return;
      if (this.filters != null)
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
        if (paramInt2 < this.filters.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(paramInt2);
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            paramInt2 += 1;
            break;
            StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.cpRange != null) {
                localStickerItem.cpRange.setValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerFilterList != null)
      {
        paramInt2 = i;
        while (paramInt2 < this.mMaskStickerFilterList.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.mMaskStickerFilterList.get(paramInt2);
          if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
          {
            paramVideoPreviewFaceOutlineDetector = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((paramVideoPreviewFaceOutlineDetector != null) && (paramVideoPreviewFaceOutlineDetector.cpRange != null)) {
              paramVideoPreviewFaceOutlineDetector.cpRange.setValue(((Float)this.mCpValueMap.get(Integer.valueOf(paramInt1))).floatValue());
            }
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  private void hitDynamicFaceRandomGroupItem(int paramInt)
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.filters != null)
    {
      i = 0;
      while (i < this.filters.size())
      {
        localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          NormalVideoFilter localNormalVideoFilter = (NormalVideoFilter)localObject;
          if (!localNormalVideoFilter.isStaticSticker()) {
            localNormalVideoFilter.updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
          }
        }
        if ((localObject instanceof FaceOffFilter)) {
          ((FaceOffFilter)localObject).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
        if ((localObject instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localObject).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
        }
        i += 1;
      }
    }
    if (this.mMaskStickerFilterList != null)
    {
      i = j;
      while (i < this.mMaskStickerFilterList.size())
      {
        localObject = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = (NormalVideoFilter)localObject;
          if (!((NormalVideoFilter)localObject).isStaticSticker()) {
            ((NormalVideoFilter)localObject).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(paramInt));
          }
        }
        i += 1;
      }
    }
  }
  
  private void hitGenderRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    int j = 0;
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      int i;
      if (this.filters != null)
      {
        if ((!this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mGenderValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          this.mGenderValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        i = 0;
        if (i < this.filters.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.genderRange != null) {
                localStickerItem.genderRange.setValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_SEX.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerFilterList != null)
      {
        i = j;
        while (i < this.mMaskStickerFilterList.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
          if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
          {
            paramVideoPreviewFaceOutlineDetector = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((paramVideoPreviewFaceOutlineDetector != null) && (paramVideoPreviewFaceOutlineDetector.genderRange != null)) {
              paramVideoPreviewFaceOutlineDetector.genderRange.setValue(((Float)this.mGenderValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitHandRandomGroupItem()
  {
    if (this.gestureFilters != null)
    {
      int i = 0;
      while (i < this.gestureFilters.size())
      {
        ((NormalVideoFilter)this.gestureFilters.get(i)).updateRandomGroupValue(RandomGroupManager.getInstance().getHandValue());
        i += 1;
      }
    }
  }
  
  private void hitHandsRangeItem()
  {
    if (!this.mHandsValueMap.containsKey(Integer.valueOf(0))) {}
    for (;;)
    {
      return;
      if (this.gestureFilters != null)
      {
        int i = 0;
        while (i < this.gestureFilters.size())
        {
          StickerItem localStickerItem = ((NormalVideoFilter)this.gestureFilters.get(i)).getStickerItem();
          if ((localStickerItem != null) && (localStickerItem.charmRange != null)) {
            localStickerItem.charmRange.hit(((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitPopularRangeItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, int paramInt)
  {
    int j = 0;
    if ((paramVideoPreviewFaceOutlineDetector == null) || (!paramVideoPreviewFaceOutlineDetector.needDetectFaceValue())) {}
    for (;;)
    {
      return;
      int i;
      if (this.filters != null)
      {
        if ((!this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) || ((this.mPopularValueMap.containsKey(Integer.valueOf(paramInt))) && (((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() < 0.0F)))
        {
          float f = paramVideoPreviewFaceOutlineDetector.getFaceValues(paramInt, FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value);
          if ((int)(f * 100.0F) == 0) {
            continue;
          }
          this.mPopularValueMap.put(Integer.valueOf(paramInt), Float.valueOf(f));
        }
        i = 0;
        if (i < this.filters.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.filters.get(i);
          if (!(paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter)) {}
          for (;;)
          {
            i += 1;
            break;
            StickerItem localStickerItem = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if (localStickerItem != null)
            {
              if (localStickerItem.popularRange != null) {
                localStickerItem.popularRange.setValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof DynamicNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((DynamicNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
              if (((paramVideoPreviewFaceOutlineDetector instanceof StaticNumFilter)) && (localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_POPULAR.value)) {
                ((StaticNumFilter)paramVideoPreviewFaceOutlineDetector).setNum((int)(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue() * 100.0F));
              }
            }
          }
        }
      }
      if (this.mMaskStickerFilterList != null)
      {
        i = j;
        while (i < this.mMaskStickerFilterList.size())
        {
          paramVideoPreviewFaceOutlineDetector = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
          if ((paramVideoPreviewFaceOutlineDetector instanceof NormalVideoFilter))
          {
            paramVideoPreviewFaceOutlineDetector = ((NormalVideoFilter)paramVideoPreviewFaceOutlineDetector).getStickerItem();
            if ((paramVideoPreviewFaceOutlineDetector != null) && (paramVideoPreviewFaceOutlineDetector.popularRange != null)) {
              paramVideoPreviewFaceOutlineDetector.popularRange.setValue(((Float)this.mPopularValueMap.get(Integer.valueOf(paramInt))).floatValue());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void hitStaticFaceRandomGroupItem()
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.filters != null)
    {
      i = 0;
      while (i < this.filters.size())
      {
        localObject = (VideoFilterBase)this.filters.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = (NormalVideoFilter)localObject;
          if (((NormalVideoFilter)localObject).isStaticSticker()) {
            ((NormalVideoFilter)localObject).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(-1));
          }
        }
        i += 1;
      }
    }
    if (this.mMaskStickerFilterList != null)
    {
      i = j;
      while (i < this.mMaskStickerFilterList.size())
      {
        localObject = (VideoFilterBase)this.mMaskStickerFilterList.get(i);
        if ((localObject instanceof NormalVideoFilter))
        {
          localObject = (NormalVideoFilter)localObject;
          if (((NormalVideoFilter)localObject).isStaticSticker()) {
            ((NormalVideoFilter)localObject).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(-1));
          }
        }
        i += 1;
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
          break label831;
        }
      }
    }
    label169:
    label828:
    label831:
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
          break label828;
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
        this.mCharmValueMap.remove(Integer.valueOf(((Face)localObject4).faceIndex));
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
    this.mCharmValueMap.remove(Integer.valueOf(paramInt));
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
  
  private void splitFgStaticStickerFiltersFromTransform(List<VideoFilterBase> paramList)
  {
    this.fgStaticStickerFilters = new ArrayList();
    this.fgStaticStickerBeforeTransformFilters = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if ((localVideoFilterBase instanceof StaticStickerFilter))
      {
        if (((StaticStickerFilter)localVideoFilterBase).getStickerItem().orderMode == VideoMaterialUtil.STICKER_ORDER_MODE.BEFORE_TRANSFORM) {
          this.fgStaticStickerBeforeTransformFilters.add(localVideoFilterBase);
        } else {
          this.fgStaticStickerFilters.add(localVideoFilterBase);
        }
      }
      else if ((localVideoFilterBase instanceof StaticNumFilter)) {
        this.fgStaticStickerFilters.add(localVideoFilterBase);
      } else if (((localVideoFilterBase instanceof ParticleFilter)) && (((ParticleFilter)localVideoFilterBase).isStatic())) {
        this.fgStaticStickerFilters.add(localVideoFilterBase);
      } else if (((localVideoFilterBase instanceof ParticleFilter3D)) && (((ParticleFilter3D)localVideoFilterBase).isStatic())) {
        this.fgStaticStickerFilters.add(localVideoFilterBase);
      }
    }
  }
  
  private void syncCharmRangeAndHandsRangeValue(boolean paramBoolean)
  {
    double d;
    if (((!CollectionUtils.isEmpty(this.mFaceList)) && (!this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex)))) || ((paramBoolean) && (!this.mHandsValueMap.containsKey(Integer.valueOf(0))))) {
      d = mRandom.nextDouble();
    }
    for (;;)
    {
      if (d < 0.0D) {
        d = mRandom.nextDouble();
      }
      for (;;)
      {
        if (!CollectionUtils.isEmpty(this.mFaceList))
        {
          i = ((Face)this.mFaceList.get(0)).faceIndex;
          this.mCharmValueMap.put(Integer.valueOf(i), Double.valueOf(d));
        }
        int i = 1;
        for (;;)
        {
          if (i < this.mFaceList.size())
          {
            int j = ((Face)this.mFaceList.get(i)).faceIndex;
            if (!this.mCharmValueMap.containsKey(Integer.valueOf(j))) {
              this.mCharmValueMap.put(Integer.valueOf(((Face)this.mFaceList.get(i)).faceIndex), Double.valueOf(mRandom.nextDouble()));
            }
            i += 1;
            continue;
            if ((!CollectionUtils.isEmpty(this.mFaceList)) && (this.mCharmValueMap.containsKey(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))))
            {
              d = ((Double)this.mCharmValueMap.get(Integer.valueOf(((Face)this.mFaceList.get(0)).faceIndex))).doubleValue();
              break;
            }
            if (!this.mHandsValueMap.containsKey(Integer.valueOf(0))) {
              break label373;
            }
            d = ((Double)this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue();
            break;
          }
        }
        if (paramBoolean) {
          this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(d));
        }
        return;
      }
      label373:
      d = -1.0D;
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
        break label194;
      }
      paramPTFaceAttr = this.filters.iterator();
      while (paramPTFaceAttr.hasNext())
      {
        paramAIAttr = (VideoFilterBase)paramPTFaceAttr.next();
        if ((paramAIAttr instanceof FaceCopyFilter))
        {
          paramAIAttr = (FaceCopyFilter)paramAIAttr;
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
      label191:
      return localObject1;
      label194:
      if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial()))
      {
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrame[0]);
        GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
        GLES20.glViewport(0, 0, paramFrame.width, paramFrame.height);
        paramPTFaceAttr = this.filters.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          paramAIAttr = (VideoFilterBase)paramPTFaceAttr.next();
          if ((paramAIAttr instanceof SwitchFaceFilter))
          {
            paramAIAttr = (SwitchFaceFilter)paramAIAttr;
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
        paramPTFaceAttr = this.filters.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          paramAIAttr = (VideoFilterBase)paramPTFaceAttr.next();
          if ((paramAIAttr instanceof DoodleFilter))
          {
            paramAIAttr = (DoodleFilter)paramAIAttr;
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
          break label191;
        }
      }
      for (localObject1 = this.crazyFaceFilters.updateAndRender(paramFrame, paramFrame.width, paramFrame.height, (List)localObject5, (float[])localObject4);; localObject1 = paramFrame)
      {
        paramFrame = (Frame)localObject1;
        if (j <= 0)
        {
          setCurPersonId(-1);
          setCurGender(0);
          localObject4 = new PTDetectInfo.Builder().triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).timestamp(l).aiAttr(paramAIAttr).build();
          updateFilters((PTDetectInfo)localObject4, this.fgDynamicFilters);
          paramFrame = RenderProcessForFilters((Frame)localObject1, this.fgDynamicFilters);
          updateFilters((PTDetectInfo)localObject4, this.faceParticleDynamicFilters);
          paramFrame = RenderProcessForFilters(paramFrame, this.faceParticleDynamicFilters);
          updateFilters((PTDetectInfo)localObject4, this.faceGpuParticleDynamicFilters);
          localObject1 = RenderProcessForGpuParticleFilters(paramFrame, this.faceGpuParticleDynamicFilters);
          paramFrame = (Frame)localObject1;
          if (this.mMaskStickerFilterList != null)
          {
            localObject5 = this.mMaskStickerFilterList.iterator();
            for (;;)
            {
              paramFrame = (Frame)localObject1;
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              paramFrame = (VideoFilterBase)((Iterator)localObject5).next();
              if ((paramFrame instanceof DynamicMaskFilter)) {
                paramFrame.updatePreview(localObject4);
              }
            }
          }
        }
        resetPersonParam(paramPTFaceAttr);
        localObject1 = paramFrame;
        if (this.fastFaceStickerFilter != null)
        {
          BenchUtil.benchStart("[showPreview]RenderProcessForFastFaceStickerFilter");
          localObject1 = RenderProcessForFastFaceStickerFilter(paramFrame, this.multiViewerOutFrame, this.mFaceList, j, paramPTFaceAttr, this.mCurPersonParam, paramAIAttr);
          BenchUtil.benchEnd("[showPreview]RenderProcessForFastFaceStickerFilter");
        }
        hitStaticFaceRandomGroupItem();
        paramFrame = new PTDetectInfo.Builder().phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).timestamp(l).aiAttr(paramAIAttr).build();
        updateFilters(paramFrame, this.qqGestureDynamicFilters);
        localObject1 = RenderProcessForFilters((Frame)localObject1, this.multiViewerOutFrame, this.qqGestureDynamicFilters);
        updateFilters(paramFrame, this.qqGestureStaticFilters);
        paramFrame = RenderProcessForFilters((Frame)localObject1, this.multiViewerOutFrame, this.qqGestureStaticFilters);
        int i = 0;
        label851:
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
          BenchUtil.benchStart("[showPreview]RenderProcess");
          localObject1 = ((Face)localObject4).facePoints;
          localObject4 = ((Face)localObject4).faceAngles;
          if ((!needShookHeadCount()) || (this.currentFaceInfo == null) || (this.selectFaceIndex < 0) || (this.selectFaceIndex >= localList1.size())) {
            break label1587;
          }
          setCurPersonId(i);
          localObject1 = (List)localList1.get(this.selectFaceIndex);
          localObject4 = (float[])localList2.get(this.selectFaceIndex);
        }
        label1575:
        label1587:
        for (;;)
        {
          localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject1).faceAngles((float[])localObject4).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(paramAIAttr).build();
          updateFilters((PTDetectInfo)localObject1, this.fgDynamicFilters);
          paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.fgDynamicFilters);
          updateFilters((PTDetectInfo)localObject1, this.faceParticleDynamicFilters);
          paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.faceParticleDynamicFilters);
          updateFilters((PTDetectInfo)localObject1, this.faceGpuParticleDynamicFilters);
          paramFrame = RenderProcessForGpuParticleFilters(paramFrame, this.multiViewerOutFrame, this.faceGpuParticleDynamicFilters);
          BenchUtil.benchEnd("[showPreview]RenderProcess");
          i += 1;
          break label851;
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
              localObject3 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
              localObject4 = new PTDetectInfo.Builder().handPoints((List)localObject1).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).handActionCounter((Map)localObject3).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
              if (localList2.size() > 0)
              {
                localObject3 = (float[])localList2.get(0);
                label1372:
                localObject3 = ((PTDetectInfo.Builder)localObject4).faceAngles((float[])localObject3).aiAttr(paramAIAttr).build();
                if (!isHandPointsValid((List)localObject1)) {
                  break label1575;
                }
                updateFilters((PTDetectInfo)localObject3, this.gestureFilters);
                paramFrame = RenderProcessForFilters(paramFrame, this.gestureFilters);
              }
              for (;;)
              {
                updateFilters((PTDetectInfo)localObject3, this.gestureParticleFilters);
                paramFrame = RenderProcessForFilters(paramFrame, this.gestureParticleFilters);
                updateFilters((PTDetectInfo)localObject3, this.gestureGpuParticleFilters);
                localObject1 = RenderProcessForGpuParticleFilters(paramFrame, this.gestureGpuParticleFilters);
                paramPTFaceAttr = new PTDetectInfo.Builder().triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRealPhoneRotation()).bodyPoints((List)localObject2).timestamp(l).aiAttr(paramAIAttr).build();
                paramFrame = (Frame)localObject1;
                if (this.fastBodyStickerFilter != null)
                {
                  BenchUtil.benchStart("[showPreview]RenderProcessForFastBodyStickerFilter");
                  paramFrame = RenderProcessForFastBodyStickerFilter((Frame)localObject1, null, paramPTFaceAttr);
                  BenchUtil.benchEnd("[showPreview]RenderProcessForFastBodyStickerFilter");
                }
                updateFilters(paramPTFaceAttr, this.bodyFilters);
                paramFrame = RenderProcessForFilters(paramFrame, this.bodyFilters);
                updateFilters(paramPTFaceAttr, this.bodyParticleFilters);
                paramFrame = RenderProcessForFastParticleFilter(paramFrame, this.bodyParticleFilters);
                break;
                localObject3 = null;
                break label1372;
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
      paramAIAttr = this.filters.iterator();
      for (;;)
      {
        paramPTFaceAttr = paramFrame;
        if (!paramAIAttr.hasNext()) {
          break;
        }
        paramPTFaceAttr = (VideoFilterBase)paramAIAttr.next();
        if ((paramPTFaceAttr instanceof DoodleFilter))
        {
          paramPTFaceAttr = (DoodleFilter)paramPTFaceAttr;
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
        updateFilters((PTDetectInfo)localObject4, this.fgDynamicFilters);
        localObject3 = RenderProcessForFilters(paramFrame, this.fgDynamicFilters);
        paramFrame = (Frame)localObject3;
        if (this.mMaskStickerFilterList != null)
        {
          Iterator localIterator = this.mMaskStickerFilterList.iterator();
          for (;;)
          {
            paramFrame = (Frame)localObject3;
            if (!localIterator.hasNext()) {
              break;
            }
            paramFrame = (VideoFilterBase)localIterator.next();
            if ((paramFrame instanceof DynamicMaskFilter)) {
              paramFrame.updatePreview(localObject4);
            }
          }
        }
      }
      resetPersonParam(paramPTFaceAttr);
      Object localObject3 = paramFrame;
      if (this.fastFaceStickerFilter != null)
      {
        BenchUtil.benchStart("[showPreview]RenderProcessForFastFaceStickerFilter");
        localObject3 = RenderProcessForFastFaceStickerFilter(paramFrame, this.multiViewerOutFrame, this.mFaceList, j, paramPTFaceAttr, this.mCurPersonParam, paramAIAttr);
        BenchUtil.benchEnd("[showPreview]RenderProcessForFastFaceStickerFilter");
      }
      hitStaticFaceRandomGroupItem();
      paramFrame = new PTDetectInfo.Builder().timestamp(l).aiAttr(paramAIAttr).build();
      updateFilters(paramFrame, this.qqGestureDynamicFilters);
      localObject3 = RenderProcessForFilters((Frame)localObject3, this.multiViewerOutFrame, this.qqGestureDynamicFilters);
      updateFilters(paramFrame, this.qqGestureStaticFilters);
      paramFrame = RenderProcessForFilters((Frame)localObject3, this.multiViewerOutFrame, this.qqGestureStaticFilters);
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
        BenchUtil.benchStart("[showPreview]RenderProcess");
        localObject3 = ((Face)localObject4).facePoints;
        localObject4 = ((Face)localObject4).faceAngles;
        if ((!needShookHeadCount()) || (this.currentFaceInfo == null) || (this.selectFaceIndex < 0) || (this.selectFaceIndex >= localList1.size())) {
          break label1015;
        }
        setCurPersonId(i);
        localObject3 = (List)localList1.get(this.selectFaceIndex);
        localObject4 = (float[])localList2.get(this.selectFaceIndex);
      }
      label1006:
      label1015:
      for (;;)
      {
        updateFilters(new PTDetectInfo.Builder().facePoints((List)localObject3).faceAngles((float[])localObject4).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(paramAIAttr).build(), this.fgDynamicFilters);
        paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.fgDynamicFilters);
        i += 1;
        break;
        resetPersonParam(paramPTFaceAttr);
        if (localObject2 != null) {}
        for (localObject2 = ((PTHandAttr)localObject2).getHandPointList();; localObject2 = null)
        {
          localObject3 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
          localObject3 = new PTDetectInfo.Builder().handPoints((List)localObject2).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handActionCounter((Map)localObject3).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
          if (localList2.size() > 0)
          {
            paramPTFaceAttr = (float[])localList2.get(0);
            paramPTFaceAttr = ((PTDetectInfo.Builder)localObject3).faceAngles(paramPTFaceAttr).aiAttr(paramAIAttr).build();
            if (!isHandPointsValid((List)localObject2)) {
              break label1006;
            }
            updateFilters(paramPTFaceAttr, this.gestureFilters);
            paramFrame = RenderProcessForFilters(paramFrame, this.gestureFilters);
          }
          for (;;)
          {
            paramAIAttr = new PTDetectInfo.Builder().triggeredExpression(localSet).bodyPoints((List)localObject1).timestamp(l).aiAttr(paramAIAttr).build();
            paramPTFaceAttr = paramFrame;
            if (this.fastBodyStickerFilter != null)
            {
              BenchUtil.benchStart("[showPreview]RenderProcessForFastBodyStickerFilter");
              paramPTFaceAttr = RenderProcessForFastBodyStickerFilter(paramFrame, null, paramAIAttr);
              BenchUtil.benchEnd("[showPreview]RenderProcessForFastBodyStickerFilter");
            }
            updateFilters(paramAIAttr, this.bodyFilters);
            paramPTFaceAttr = RenderProcessForFilters(paramPTFaceAttr, this.bodyFilters);
            GlUtil.setBlendMode(false);
            return paramPTFaceAttr;
            paramPTFaceAttr = null;
            break;
          }
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
          break label303;
        }
        this.selectFaceIndex = selectFace(this.currentFaceInfo, paramList);
        if ((this.selectFaceIndex < 0) || (this.selectFaceIndex >= paramList.size())) {
          break label303;
        }
        this.currentFaceInfo = ((LinkedList)paramList.get(this.selectFaceIndex));
        this.shookHeadCount += 1;
      }
    }
    label303:
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
        if (this.staticCountFilters == null) {
          break;
        }
        paramList = this.staticCountFilters.iterator();
        while (paramList.hasNext()) {
          ((StaticCountFilter)paramList.next()).updateShookCount(this.shookHeadCount);
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
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.qqGestureStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.qqGestureDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.bodyParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.starParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceGpuParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.faceGpuParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.gestureGpuParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.ApplyGLSLFilter(this.material.getDataPath());
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.ApplyGLSLFilter();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.ApplyGLSLFilter();
    }
    Object localObject;
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FacialFeatureFilter)localIterator.next();
        if (localObject != null) {
          ((FacialFeatureFilter)localObject).ApplyGLSLFilter();
        }
      }
    }
    if (this.mPhantomFilter != null) {
      this.mPhantomFilter.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter();
    }
    if (this.mComicEffectFilters != null)
    {
      localIterator = this.mComicEffectFilters.iterator();
      while (localIterator.hasNext()) {
        ((ComicEffectFilter)localIterator.next()).apply();
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
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MultiViewerFilter)localIterator.next();
        if (localObject != null) {
          ((MultiViewerFilter)localObject).ApplyGLSLFilter();
        }
      }
    }
    if (this.filamentFilter != null) {
      this.filamentFilter.initial();
    }
    if (isMaterialSegmentRequired())
    {
      this.fabbyExtractFilter = new FabbyExtractFilter();
      if ((this.material == null) || ((this.material.getSegmentBorderType() != VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_FLOW_LINES.type) && (this.material.getSegmentBorderType() != VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_TRIGGER.type))) {
        break label1057;
      }
      if (this.material.getSegmentStrokeItem() == null) {
        break label1012;
      }
      this.fabbyStrokeFilter = new FabbyStrokeFilter(this.material.getSegmentStrokeItem());
    }
    label1057:
    for (;;)
    {
      this.fastBlurFilter = new FastBlurFilter();
      this.fabbyShakeStrokeFilter = new FabbyShakeStrokeFilter();
      this.mMaskFilter = new BaseFilter("mee179x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963604837x1868982638x1931505010x1819307361x1144156773x1886284064x1833530485x1415931745x1970567269x171664754x1768912394x1634541668x690515561x175835680x538976288x1180658791x1130848626x1919904879x1948269856x1970567269x1144153458x1852385312x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x687370x");
      this.fabbyExtractFilter.apply();
      this.fabbyStrokeFilter.apply();
      this.fastBlurFilter.apply();
      this.fabbyShakeStrokeFilter.apply();
      this.mMaskFilter.apply();
      if (this.mMaskMergeFilter != null) {
        this.mMaskMergeFilter.apply();
      }
      if (this.fastFaceStickerFilter != null) {
        this.fastFaceStickerFilter.ApplyGLSLFilter();
      }
      if (this.fastBodyStickerFilter != null) {
        this.fastBodyStickerFilter.ApplyGLSLFilter();
      }
      localIterator = this.mEffectTriggerFilters.iterator();
      while (localIterator.hasNext()) {
        ((EffectTriggerFilter)localIterator.next()).ApplyGLSLFilter();
      }
      label1012:
      if (this.material.getSegmentStrokeTriggerItems() != null)
      {
        this.fabbyStrokeFilter = new FabbyStrokeFilterExt(this.material.getSegmentStrokeTriggerItems());
      }
      else
      {
        this.fabbyStrokeFilter = new FabbyStrokeFilter();
        continue;
        this.fabbyStrokeFilter = new FabbyStrokeFilter();
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
    if (this.mZoomFilter != null) {
      this.mZoomFilter.ApplyGLSLFilter();
    }
    this.mFaceOffNoseOcclusionFilter.ApplyGLSLFilter();
    if (this.hairCos != null) {
      this.hairCos.ApplyGLSLFilter();
    }
    if (this.lutItemsFilter != null) {
      this.lutItemsFilter.apply();
    }
    if (this.skyboxItemsFilter != null) {
      this.skyboxItemsFilter.apply();
    }
    if (this.mMaskStickerFilterList != null)
    {
      localIterator = this.mMaskStickerFilterList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
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
    if (CollectionUtils.isEmpty(this.filters)) {}
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
      if (i >= this.filters.size()) {
        return localFrame1;
      }
      localVideoFilterBase = (VideoFilterBase)this.filters.get(i);
      if (needRender(localVideoFilterBase)) {
        break label136;
      }
    }
    for (;;)
    {
      i += 1;
      break label81;
      localFrame2 = this.copyFrame[0];
      break;
      label136:
      if (!VideoFilterUtil.canUseBlendMode(localVideoFilterBase))
      {
        Frame localFrame3 = localFrame1;
        if (VideoFilterUtil.needCopy(localVideoFilterBase)) {
          localFrame3 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, this.mCopyFilter, paramFrame, localFrame2);
        }
        BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
        if ((VideoFilterUtil.maybeTransformFilter(localVideoFilterBase)) && (VideoMaterialUtil.needCopyTransform())) {}
        for (localFrame1 = VideoFrameUtil.renderProcessByCopy(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, this.mCopyFilter, paramFrame, localFrame2);; localFrame1 = VideoFrameUtil.renderProcessBySwitchFbo(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, localVideoFilterBase, paramFrame, localFrame2))
        {
          BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localVideoFilterBase.getClass().getName());
          break;
        }
      }
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      localVideoFilterBase.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
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
  
  public Frame blurAfterRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      localPTSegAttr = paramPTSegAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame())
      {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(null);
        localPTSegAttr = this.inputFreezeFrameFilter.getPTSegSnapshot(null);
      }
    }
    if (this.mBlurMaskFilter != null) {}
    for (paramPTFaceAttr = this.mBlurMaskFilter.renderBlurAfter(paramFrame, localPTFaceAttr, localPTSegAttr);; paramPTFaceAttr = paramFrame)
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
    Object localObject1 = paramFrame;
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      this.inputFreezeFrameFilter.updateTimeStamp(paramPTFaceAttr.getTimeStamp());
      localObject1 = paramFrame;
      localPTFaceAttr = paramPTFaceAttr;
      localPTSegAttr = paramPTSegAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame())
      {
        localObject1 = this.inputFreezeFrameFilter.getFrameInfoSnapShot();
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new VideoFilterListSnapshot(paramFrame.width, paramFrame.height);
          localObject1 = ((VideoFilterListSnapshot)localObject2).getInputFrameSnapshot();
          this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, (Frame)localObject1);
          ((VideoFilterListSnapshot)localObject2).setFaceAttrAndSegAttr(paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          if ((paramPTSegAttr != null) && (paramPTSegAttr.getMaskFrame() != null))
          {
            paramFrame = ((VideoFilterListSnapshot)localObject2).getSegMaskSnapshot();
            this.mCopyFilter.RenderProcess(paramPTSegAttr.getMaskFrame().getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
          }
          this.inputFreezeFrameFilter.setFrameInfoSnapShot((VideoFilterListSnapshot)localObject2);
        }
        paramFrame = ((VideoFilterListSnapshot)localObject2).getInputFrameSnapshot();
        if (this.freezeFrameSnapshotFrame == null) {
          this.freezeFrameSnapshotFrame = new Frame();
        }
        this.freezeFrameSnapshotFrame = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.freezeFrameSnapshotFrame);
        paramFrame = this.freezeFrameSnapshotFrame;
        paramPTFaceAttr = ((VideoFilterListSnapshot)localObject2).getPTFaceSnapshot();
        paramPTSegAttr = ((VideoFilterListSnapshot)localObject2).getPTSegSnapshot();
        localObject1 = paramFrame;
        localPTFaceAttr = paramPTFaceAttr;
        localPTSegAttr = paramPTSegAttr;
        if (paramPTFaceAttr != null)
        {
          ((VideoFilterListSnapshot)localObject2).updateCameraTriggerAction(paramPTFaceAttr.getTriggeredExpression());
          localPTSegAttr = paramPTSegAttr;
          localPTFaceAttr = paramPTFaceAttr;
          localObject1 = paramFrame;
        }
      }
    }
    paramFrame = (Frame)localObject1;
    if (this.mBlurMaskFilter != null) {
      paramFrame = this.mBlurMaskFilter.renderBlurBefore((Frame)localObject1, localPTFaceAttr, localPTSegAttr);
    }
    return paramFrame;
  }
  
  public void checkNeedARGesture()
  {
    if ((this.material != null) && (this.material.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) && (this.material.isSupportTouchEvent()))
    {
      removeARFilterGesture();
      addARFilterGesture();
    }
  }
  
  public void clearComicEffectFiltersRenderStatus(List<ComicEffectFilter> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ComicEffectFilter)paramList.next()).setAlreadyRenderInSingleFrame(false);
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
  
  public void clearTouchPoint()
  {
    if (this.mMaskTouchPoints != null) {
      this.mMaskTouchPoints.clear();
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
    Object localObject = this.filters.iterator();
    VideoFilterBase localVideoFilterBase;
    while (((Iterator)localObject).hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
      localVideoFilterBase.clearGLSLSelf();
      if ((localVideoFilterBase instanceof SnapShotFilter)) {
        ((SnapShotFilter)localVideoFilterBase).clear();
      }
    }
    localObject = this.gestureFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.qqGestureStaticFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.qqGestureDynamicFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.bodyFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.faceParticleDynamicFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.faceParticleStaticFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.gestureParticleFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.bodyParticleFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.starParticleFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.faceGpuParticleDynamicFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.faceGpuParticleStaticFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.gestureGpuParticleFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.headCropItemFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
    }
    localObject = this.mEffectTriggerFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EffectTriggerFilter)((Iterator)localObject).next()).clearGLSLSelf();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.clear();
    }
    if (this.mBlurMaskFilter != null)
    {
      this.mBlurMaskFilter.clear();
      this.mBlurMaskFilter = null;
    }
    if (this.mZoomFilter != null)
    {
      this.mZoomFilter.clear();
      this.mZoomFilter = null;
    }
    if (this.mMaskStickerFilterList != null)
    {
      localObject = this.mMaskStickerFilterList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFilterBase)((Iterator)localObject).next()).clearGLSLSelf();
      }
    }
    if (this.mMaskMergeFilter != null) {
      this.mMaskMergeFilter.clearGLSLSelf();
    }
    if (this.multiViewerFilters != null)
    {
      localObject = this.multiViewerFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MultiViewerFilter)((Iterator)localObject).next()).clear();
      }
    }
    this.mFaceOffNoseOcclusionFilter.clearGLSLSelf();
    if (this.filamentFilter != null) {
      this.filamentFilter.destroy();
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
      localObject = this.mCopyMaskFrame;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        localVideoFilterBase = localObject[i];
        if (localVideoFilterBase != null) {
          localVideoFilterBase.clear();
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
    int i = 0;
    while (i < this.copyFrame.length)
    {
      if (this.copyFrame[i] != null) {
        this.copyFrame[i].clear();
      }
      i += 1;
    }
    localObject = this.multiViewerFrameMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Frame)((Iterator)localObject).next()).clear();
    }
    this.multiViewerFrameMap.clear();
    this.mCopyFilter.ClearGLSL();
    if (this.snapShotFrameToSticker != null) {
      this.snapShotFrameToSticker.clear();
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.clearGLSLSelf();
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.clear();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localObject = this.mFacialFeatureFilterList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FacialFeatureFilter)((Iterator)localObject).next()).clearGLSLSelf();
      }
    }
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
    if (this.mComicEffectFilters != null)
    {
      localObject = this.mComicEffectFilters.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ComicEffectFilter)((Iterator)localObject).next()).clearGLSLSelf();
      }
    }
    if (this.fabbyExtractFilter != null) {
      this.fabbyExtractFilter.ClearGLSL();
    }
    if (this.fabbyStrokeFilter != null) {
      this.fabbyStrokeFilter.ClearGLSL();
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.ClearGLSL();
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.clearGLSLSelf();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.clearGLSLSelf();
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
    if (this.inputFreezeFrameFilter != null)
    {
      this.inputFreezeFrameFilter.clear();
      this.inputFreezeFrameFilter = null;
    }
    if (this.freezeFrameSnapshotFrame != null) {
      this.freezeFrameSnapshotFrame.clear();
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
    if (this.hairCos != null) {
      this.hairCos.clearGLSLSelf();
    }
    if (this.lutItemsFilter != null) {
      this.lutItemsFilter.clear();
    }
    if (this.skyboxItemsFilter != null) {
      this.skyboxItemsFilter.clear();
    }
    if (this.mMaskTouchPoints != null) {
      this.mMaskTouchPoints.clear();
    }
    if (this.rapidNetFilterList != null)
    {
      localObject = this.rapidNetFilterList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RapidNetFilter)((Iterator)localObject).next()).destroy();
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
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.destroyAudio();
    }
    Iterator localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewerFilter)localIterator.next()).destroyAudio();
    }
  }
  
  public Frame doFabbyStroke(Frame paramFrame1, Frame paramFrame2)
  {
    return doFabbyStroke(paramFrame1, paramFrame2, null);
  }
  
  public Frame doFabbyStroke(Frame paramFrame1, Frame paramFrame2, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame2;
    if (this.inputFreezeFrameFilter != null)
    {
      localFrame = paramFrame2;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        if (this.inputFreezeFrameFilter.getFrameInfoSnapShot() == null) {
          break label54;
        }
      }
    }
    label54:
    for (paramFrame2 = this.inputFreezeFrameFilter.getFrameInfoSnapShot().getSegMaskSnapshot();; paramFrame2 = null)
    {
      localFrame = paramFrame2;
      if (localFrame != null) {
        break;
      }
      return paramFrame1;
    }
    BenchUtil.benchStart("[showPreview][FABBY] doFabbyStroke");
    if ((this.material.getSegmentStrokeWidth() > 0.0D) || (this.material.getSegmentBorderType() == VideoMaterialUtil.SEGMENT_BORDER_TYPE.BORDER_TRIGGER.type)) {
      if (paramPTFaceAttr != null)
      {
        paramFrame2 = paramPTFaceAttr.getFaceActionCounter();
        Set localSet = paramPTFaceAttr.getTriggeredExpression();
        long l = paramPTFaceAttr.getTimeStamp();
        paramFrame2 = new PTDetectInfo.Builder().faceActionCounter(paramFrame2).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
        this.fabbyStrokeFilter.updateTextureParam(paramFrame2);
        this.fabbyStrokeFilter.setmMaskTex(localFrame.getTextureId());
        this.fabbyStrokeFilter.setStepX(1.0F / paramFrame1.width);
        this.fabbyStrokeFilter.setStepY(1.0F / paramFrame1.height);
        this.fabbyStrokeFilter.setStrokeGapInPixel((float)this.material.getSegmentStrokeGap() * Math.min(paramFrame1.width, paramFrame1.height));
        this.fabbyStrokeFilter.setStrokeWidthInPixel((float)this.material.getSegmentStrokeWidth() * Math.min(paramFrame1.width, paramFrame1.height));
        this.fabbyStrokeFilter.setStrokeColor(this.material.getSegmentStrokeColor());
        this.fabbyStrokeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
      }
    }
    for (;;)
    {
      BenchUtil.benchEnd("[showPreview][FABBY] doFabbyStroke");
      return this.fabbyStrokeFrame;
      this.fabbyStrokeFilter.updateTextureParam(null);
      break;
      if (this.material.getSegmentFeather() > 0)
      {
        int i = paramFrame1.width / 2;
        int j = paramFrame1.height / 2;
        this.fastBlurFilter.updateParams(1.2F / i, 0.0F);
        paramFrame2 = this.fastBlurFilter.RenderProcess(localFrame.getTextureId(), i, j);
        this.fastBlurFilter.updateParams(0.0F, 1.2F / j);
        paramPTFaceAttr = this.fastBlurFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame1.width, paramFrame1.height);
        paramFrame2.unlock();
        this.fabbyExtractFilter.setTex(paramPTFaceAttr.getTextureId());
        this.fabbyExtractFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
        paramPTFaceAttr.unlock();
      }
      else
      {
        this.fabbyExtractFilter.setTex(localFrame.getTextureId());
        this.fabbyExtractFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeFrame);
      }
    }
  }
  
  public Frame doFabbyStrokeShake(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3, boolean paramBoolean)
  {
    Object localObject1 = paramFrame2;
    if (this.inputFreezeFrameFilter != null)
    {
      localObject1 = paramFrame2;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        if (this.inputFreezeFrameFilter.getFrameInfoSnapShot() == null) {
          break label54;
        }
      }
    }
    label54:
    for (paramFrame2 = this.inputFreezeFrameFilter.getFrameInfoSnapShot().getSegMaskSnapshot();; paramFrame2 = null)
    {
      localObject1 = paramFrame2;
      if (localObject1 != null) {
        break;
      }
      return paramFrame1;
    }
    Object localObject2 = this.material;
    this.fabbyStrokeShakeFrame.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    FrameUtil.clearFrame(this.fabbyStrokeShakeFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.fabbyStrokeShakeFrame.width, this.fabbyStrokeShakeFrame.height);
    label158:
    int k;
    float[] arrayOfFloat1;
    int[] arrayOfInt;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    int i;
    if (localObject1 != null) {
      if (paramBoolean)
      {
        this.gaussianCompose.drawTexture(((Frame)localObject1).getTextureId());
        this.fabbyShakeStrokeFilter.setmMaskTex(this.gaussianCompose.getTextureId());
        if (paramFrame3 != null) {
          break label382;
        }
        this.fabbyShakeStrokeFilter.setBgTex(paramFrame1.getTextureId());
        this.fabbyShakeStrokeFilter.setFeather(this.material.getSegmentFeather());
        this.fabbyShakeStrokeFilter.setStepX(1.0F / paramFrame1.width);
        this.fabbyShakeStrokeFilter.setStepY(1.0F / paramFrame1.height);
        paramFrame2 = this.material.getSegmentStrokeList();
        k = paramFrame2.size();
        this.fabbyShakeStrokeFilter.setStrokeCount(k);
        if ((((VideoMaterial)localObject2).getSegmentBorderType() == -1) || (k <= 0)) {
          break label663;
        }
        paramFrame3 = new float[k * 4];
        localObject1 = new float[k * 4];
        localObject2 = new float[k * 4];
        arrayOfFloat1 = new float[k * 2];
        arrayOfInt = new int[k];
        arrayOfFloat2 = new float[k];
        arrayOfFloat3 = new float[k];
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label601;
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
          this.fabbyShakeStrokeFilter.setmMaskTex(((Frame)localObject1).getTextureId());
          break;
          this.fabbyShakeStrokeFilter.setmMaskTex(-1);
          break;
          label382:
          this.fabbyShakeStrokeFilter.setBgTex(paramFrame3.getTextureId());
          break label158;
        }
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeShakeAmplitude.length)
      {
        localObject1[(localSegmentStroke.segmentStrokeShakeAmplitude.length * i + j)] = localSegmentStroke.segmentStrokeShakeAmplitude[j];
        j += 1;
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeShakeFrequency.length)
      {
        localObject2[(localSegmentStroke.segmentStrokeShakeFrequency.length * i + j)] = localSegmentStroke.segmentStrokeShakeFrequency[j];
        j += 1;
      }
      j = 0;
      while (j < localSegmentStroke.segmentStrokeOffset.length)
      {
        arrayOfFloat1[(localSegmentStroke.segmentStrokeOffset.length * i + j)] = localSegmentStroke.segmentStrokeOffset[j];
        j += 1;
      }
      arrayOfInt[i] = localSegmentStroke.segmentStrokeType;
      arrayOfFloat2[i] = ((float)localSegmentStroke.segmentStrokeGap * Math.min(paramFrame1.width, paramFrame1.height));
      arrayOfFloat3[i] = ((float)localSegmentStroke.segmentStrokeWidth * Math.min(paramFrame1.width, paramFrame1.height));
      i += 1;
    }
    label601:
    this.fabbyShakeStrokeFilter.setStrokeColorArr(paramFrame3);
    this.fabbyShakeStrokeFilter.setStrokeShakeAmplitudeArr((float[])localObject1);
    this.fabbyShakeStrokeFilter.setStrokeShakeFrequencyArr((float[])localObject2);
    this.fabbyShakeStrokeFilter.setStrokeOffsetInPixelArr(arrayOfFloat1);
    this.fabbyShakeStrokeFilter.setStrokeTypeArr(arrayOfInt);
    this.fabbyShakeStrokeFilter.setStrokeGapInPixelArr(arrayOfFloat2);
    this.fabbyShakeStrokeFilter.setStrokeWidthInPixelArr(arrayOfFloat3);
    label663:
    this.fabbyShakeStrokeFilter.updateUTime();
    this.fabbyShakeStrokeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.fabbyStrokeShakeFrame);
    return this.fabbyStrokeShakeFrame;
  }
  
  public void doReset()
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).reset();
      }
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).reset();
      }
      if ((localVideoFilterBase instanceof FaceOff3DFilter)) {
        ((FaceOff3DFilter)localVideoFilterBase).reset();
      }
      if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).reset();
      }
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.reset();
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).reset();
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.reset();
    }
    localIterator = this.mEffectTriggerFilters.iterator();
    while (localIterator.hasNext()) {
      ((EffectTriggerFilter)localIterator.next()).reset();
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.reset();
    }
    localIterator = this.multiViewerFilters.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewerFilter)localIterator.next()).reset();
    }
    if (this.mActFilters != null) {
      this.mActFilters.reset();
    }
    if (this.inputFreezeFrameFilter != null) {
      this.inputFreezeFrameFilter.reset();
    }
    AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND).clear();
    TriggerStateManager.getInstance().reset();
    TouchTriggerManager.getInstance().reset();
    if ((this.fabbyStrokeFilter != null) && ((this.fabbyStrokeFilter instanceof FabbyStrokeFilterExt))) {
      ((FabbyStrokeFilterExt)this.fabbyStrokeFilter).reset();
    }
    if (this.mZoomFilter != null) {
      this.mZoomFilter.reset();
    }
    if (this.mMaskStickerFilterList != null)
    {
      localIterator = this.mMaskStickerFilterList.iterator();
      while (localIterator.hasNext()) {
        ((NormalVideoFilter)localIterator.next()).reset();
      }
    }
    if (this.filamentFilter != null) {
      this.filamentFilter.reset();
    }
    if (this.cosFunFilterGroup != null) {
      this.cosFunFilterGroup.reset();
    }
  }
  
  public boolean exportFilamentParams()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.exportParams();
    }
    return false;
  }
  
  public AIAttr getAiAttr()
  {
    return this.aiAttr;
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
    return this.mEffectTriggerFilters;
  }
  
  public FastStickerFilter getFastBodyStickerFilter()
  {
    return this.fastBodyStickerFilter;
  }
  
  public FastStickerFilter getFastFaceStickerFilter()
  {
    return this.fastFaceStickerFilter;
  }
  
  public List<VideoFilterBase> getFgStaticStickerFilters()
  {
    return this.fgStaticStickerFilters;
  }
  
  public String getFilamentDirectionColor()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getDirectionColor();
    }
    return null;
  }
  
  public int getFilamentDirectionIntensity()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getDirectionIntensity();
    }
    return 0;
  }
  
  public int getFilamentIblIntensity()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getIblIntensity();
    }
    return 0;
  }
  
  public int getFilamentIblRotation()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getIblRotation();
    }
    return 0;
  }
  
  public float[] getFilamentLightDirection()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getLightDirection();
    }
    return null;
  }
  
  public float[] getFilamentPosition()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getPosition();
    }
    return null;
  }
  
  public float[] getFilamentRotation()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getRotation();
    }
    return null;
  }
  
  public float[] getFilamentScale()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.getScale();
    }
    return null;
  }
  
  public List<VideoFilterBase> getFilters()
  {
    return this.filters;
  }
  
  public PTFaceAttr getFreezeFaceInfo()
  {
    PTFaceAttr localPTFaceAttr = null;
    if (isFreezeFrame()) {
      localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(null);
    }
    return localPTFaceAttr;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public int getOnlyDetectOneGesture()
  {
    return this.onlyDetectOneGesture;
  }
  
  public int getSegmentBorderType()
  {
    return this.material.getSegmentBorderType();
  }
  
  public List<VideoFilterBase> getTransformFilters()
  {
    return this.mTransformFilters;
  }
  
  public int getVideoEffectOrder()
  {
    return this.mEffectOrder;
  }
  
  public BlurMaskFilter getmBlurMaskFilter()
  {
    return this.mBlurMaskFilter;
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
    if (this.inputFreezeFrameFilter != null)
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
  
  public boolean hasParticleFilter()
  {
    if (this.filters != null)
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if (((localVideoFilterBase instanceof ParticleFilter)) || ((localVideoFilterBase instanceof ParticleFilter3D))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasVoiceTextFilter()
  {
    if (this.filters != null)
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        if (((VideoFilterBase)localIterator.next() instanceof VoiceTextFilter)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasZoomFilter()
  {
    return this.mZoomFilter != null;
  }
  
  public boolean isAllFreezeFrame()
  {
    boolean bool2;
    boolean bool1;
    if (this.inputFreezeFrameFilter != null)
    {
      bool2 = this.inputFreezeFrameFilter.isFreezeFrame();
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
  
  public boolean isDualPeople()
  {
    if (this.material != null) {
      return this.material.isDualPeople;
    }
    return false;
  }
  
  public boolean isFilamentModelReady()
  {
    if (this.filamentFilter != null) {
      return this.filamentFilter.isModelReady();
    }
    return false;
  }
  
  public boolean isFreezeFrame()
  {
    if (this.inputFreezeFrameFilter == null) {
      return false;
    }
    return this.inputFreezeFrameFilter.isFreezeFrame();
  }
  
  public boolean isHairSegmentRequired()
  {
    return this.hairCos != null;
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
  
  public Frame processTransformRelatedFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    this.directDraw = false;
    Set localSet = localPTFaceAttr.getTriggeredExpression();
    paramPTFaceAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    if (paramPTFaceAttr != null) {
      localSet.add(Integer.valueOf(paramPTFaceAttr.getHandType()));
    }
    long l = localPTFaceAttr.getTimeStamp();
    int k = Math.min(this.mFaceList.size(), getMaterial().getMaxFaceCount());
    GlUtil.setBlendMode(true);
    if (k <= 0)
    {
      paramPTFaceAttr = new PTDetectInfo.Builder().triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(localPTFaceAttr.getFaceDetector()).build();
      updateFilters(paramPTFaceAttr, this.mFaceOffFilters);
      updateFilters(paramPTFaceAttr, this.mTransformFilters);
    }
    hitStaticFaceRandomGroupItem();
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject2 = (Face)this.mFaceList.get(i);
      setCurPersonId(((Face)localObject2).faceIndex);
      setCurGender(((Face)localObject2).gender);
      hitCharmRangeItem(((Face)localObject2).faceIndex);
      hitDynamicFaceRandomGroupItem(((Face)localObject2).faceIndex);
      hitAgeRangeItem(localPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitGenderRangeItem(localPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitPopularRangeItem(localPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex);
      hitCpRangeItem(localPTFaceAttr.getFaceDetector(), ((Face)localObject2).faceIndex, k);
      localObject1 = new PTDetectInfo.Builder().facePoints(((Face)localObject2).facePoints).faceAngles(((Face)localObject2).faceAngles).triggeredExpression(localSet).aiAttr(this.aiAttr).timestamp(l).pointsVis(((Face)localObject2).facePointVis).faceActionCounter(localPTFaceAttr.getFaceActionCounter()).phoneAngle(localPTFaceAttr.getRotation()).realPhoneAngle(localPTFaceAttr.getSrcRotation()).faceDetector(localPTFaceAttr.getFaceDetector());
      paramPTFaceAttr = (PointF)((Face)localObject2).facePoints.get(63);
      if ((localPTFaceAttr.getFacePiont2DCenter() != null) && (paramPTFaceAttr.x == localPTFaceAttr.getFacePiont2DCenter().x) && (paramPTFaceAttr.y == localPTFaceAttr.getFacePiont2DCenter().y))
      {
        j = 1;
        if ((localPTFaceAttr.getFaceKitVerticesArray() != null) && (localPTFaceAttr.getFaceKitVerticesArray().size() > 0) && (j != 0)) {
          ((PTDetectInfo.Builder)localObject1).faceKitFaceVertices((float[])localPTFaceAttr.getFaceKitVerticesArray().get(0));
        }
        if ((localPTFaceAttr.getFeatureIndicesArray() != null) && (localPTFaceAttr.getFeatureIndicesArray().size() > 0) && (j != 0)) {
          ((PTDetectInfo.Builder)localObject1).featureIndices((int[])localPTFaceAttr.getFeatureIndicesArray().get(0));
        }
        paramPTFaceAttr = null;
        if (this.mFaceOffFilters != null)
        {
          paramPTFaceAttr = new PTDetectInfo.Builder().facePoints(((Face)localObject2).facePoints).faceAngles(((Face)localObject2).faceAngles).build();
          this.mFaceOffNoseOcclusionFilter.updatePreview(paramPTFaceAttr);
          paramPTFaceAttr = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
          FrameUtil.clearFrame(paramPTFaceAttr, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
          this.mFaceOffNoseOcclusionFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramPTFaceAttr);
          ((PTDetectInfo.Builder)localObject1).noseOcclusionFrame(paramPTFaceAttr);
        }
        localObject1 = ((PTDetectInfo.Builder)localObject1).build();
        if (this.mFaceOffFilters == null) {
          break label867;
        }
        FaceOffFilterManager.getInstance().updateIndex();
        updateFilters((PTDetectInfo)localObject1, this.mFaceOffFilters, k, i);
        paramFrame = RenderProcessForFilters(paramFrame, this.mFaceOffFilters);
      }
    }
    label867:
    for (;;)
    {
      if (paramPTFaceAttr != null) {
        paramPTFaceAttr.unlock();
      }
      if (this.mFacialFeatureFilterList != null)
      {
        GlUtil.setBlendMode(false);
        paramPTFaceAttr = this.mFacialFeatureFilterList.iterator();
        for (;;)
        {
          if (paramPTFaceAttr.hasNext())
          {
            ((FacialFeatureFilter)paramPTFaceAttr.next()).updateStickerFilterList(((Face)localObject2).facePoints, ((Face)localObject2).faceAngles, paramFrame);
            continue;
            j = 0;
            break;
          }
        }
        GlUtil.setBlendMode(true);
      }
      if (this.mTransformFilters != null)
      {
        updateFilters((PTDetectInfo)localObject1, this.mTransformFilters);
        paramFrame = RenderProcessForFilters(paramFrame, this.mTransformFilters);
      }
      for (;;)
      {
        if (this.mFacialFeatureFilterList != null)
        {
          localObject2 = this.mFacialFeatureFilterList.iterator();
          for (;;)
          {
            paramPTFaceAttr = paramFrame;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramPTFaceAttr = (FacialFeatureFilter)((Iterator)localObject2).next();
            updateFilters((PTDetectInfo)localObject1, paramPTFaceAttr.getStickerFilters());
            paramFrame = RenderProcessForFilters(paramFrame, paramPTFaceAttr.getStickerFilters());
          }
        }
        paramPTFaceAttr = paramFrame;
        i += 1;
        paramFrame = paramPTFaceAttr;
        break;
        resetPersonParam(localPTFaceAttr);
        GlUtil.setBlendMode(false);
        return paramFrame;
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
    if (this.filters == null) {
      return RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3);
    }
    GlUtil.setBlendMode(true);
    Frame localFrame2 = new Frame();
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame2);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramInt1 = 0;
    Frame localFrame1 = localFrame2;
    if (paramInt1 < this.filters.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
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
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.getFrameInfoSnapShot() != null))
    {
      if (!paramBoolean) {
        break label73;
      }
      this.inputFreezeFrameFilter.getFrameInfoSnapShot().addAllFreezeTrigger();
    }
    while (this.multiViewerFilters != null)
    {
      Iterator localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setAllFrameFreeze(paramBoolean);
      }
      label73:
      this.inputFreezeFrameFilter.getFrameInfoSnapShot().removeAllFreezeTrigger();
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.setAudioPause(paramBoolean);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.setAudioPause(paramBoolean);
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setAudioPause(paramBoolean);
      }
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).setAudioPause(paramBoolean);
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.setAudioPause(paramBoolean);
    }
    if (this.mActFilters != null) {
      this.mActFilters.setAudioPause(paramBoolean);
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setAudioPause(paramBoolean);
      }
    }
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
  
  public void setBodyFilters(List<NormalVideoFilter> paramList)
  {
    this.bodyFilters = paramList;
  }
  
  public void setBodyParticleFilters(List<VideoFilterBase> paramList)
  {
    this.bodyParticleFilters = paramList;
  }
  
  public void setComicEffectFilters(List<ComicEffectFilter> paramList)
  {
    this.mComicEffectFilters = paramList;
  }
  
  public void setCosFunFilterGroup(CosFunFilterGroup paramCosFunFilterGroup)
  {
    this.cosFunFilterGroup = paramCosFunFilterGroup;
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
  
  public void setEffectTriggerFilters(List<EffectTriggerFilter> paramList)
  {
    this.mEffectTriggerFilters = paramList;
  }
  
  public void setFabbyMvFilters(FabbyFilters paramFabbyFilters)
  {
    this.fabbyMvFilters = paramFabbyFilters;
  }
  
  public void setFaceGpuParticleFilters(List<GPUParticleFilter> paramList)
  {
    this.faceGpuParticleDynamicFilters = getStickerFilters(paramList, false, true);
    this.faceGpuParticleStaticFilters = getStickerFilters(paramList, true, true);
  }
  
  public void setFaceParticleFilters(List<VideoFilterBase> paramList)
  {
    this.faceParticleDynamicFilters = getStickerFilters(paramList, false, true);
    this.faceParticleStaticFilters = getStickerFilters(paramList, true, true);
  }
  
  public void setFacialFeatureFilterList(List<FacialFeatureFilter> paramList)
  {
    this.mFacialFeatureFilterList = paramList;
  }
  
  public void setFastBodyStickerFilter(FastStickerFilter paramFastStickerFilter)
  {
    this.fastBodyStickerFilter = paramFastStickerFilter;
  }
  
  public void setFastFaceStickerFilter(FastStickerFilter paramFastStickerFilter)
  {
    this.fastFaceStickerFilter = paramFastStickerFilter;
  }
  
  public void setFilamentDirectionColor(String paramString)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setDirectionColor(paramString);
    }
  }
  
  public void setFilamentDirectionIntensity(int paramInt)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setDirectionIntensity(paramInt);
    }
  }
  
  public void setFilamentFilter(FilamentFilter paramFilamentFilter)
  {
    this.filamentFilter = paramFilamentFilter;
  }
  
  public void setFilamentIblIntensity(int paramInt)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setIblIntensity(paramInt);
    }
  }
  
  public void setFilamentIblRotation(int paramInt)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setIblRotation(paramInt);
    }
  }
  
  public void setFilamentLightDirection(float paramFloat1, float paramFloat2)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setLightDirection(paramFloat1, paramFloat2);
    }
  }
  
  public void setFilamentLightIntensity(int paramInt)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setLightIntensity(paramInt);
    }
  }
  
  public void setFilamentParticleFilter(FilamentParticleFilter paramFilamentParticleFilter)
  {
    this.filamentParticleFilter = paramFilamentParticleFilter;
  }
  
  public void setFilamentPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setPosition(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void setFilamentRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setRotation(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void setFilamentScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setScale(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void setFilters(List<VideoFilterBase> paramList1, List<VideoFilterBase> paramList2, List<VideoFilterBase> paramList3)
  {
    VideoFilterUtil.removeEmptyFilters(paramList1);
    VideoFilterUtil.removeEmptyFilters(paramList2);
    VideoFilterUtil.removeEmptyFilters(paramList3);
    splitFgStaticStickerFiltersFromTransform(getStickerFilters(paramList1, true, true));
    this.fgDynamicFilters = getStickerFilters(paramList1, false, true);
    this.bgStaticStickerFilters = getStickerFilters(paramList1, true, false);
    this.bgDynamicStickerFilters = getStickerFilters(paramList1, false, false);
    this.filters = new ArrayList();
    this.filters.addAll(paramList2);
    this.filters.addAll(paramList3);
    this.filters.addAll(paramList1);
    this.mFaceOffFilters = paramList2;
    this.mTransformFilters = paramList3;
    this.staticCountFilters = getStaticCountFilters(this.fgStaticStickerFilters);
  }
  
  public void setGestureFilters(List<NormalVideoFilter> paramList)
  {
    this.gestureFilters = paramList;
  }
  
  public void setGestureGpuParticleFilters(List<GPUParticleFilter> paramList)
  {
    this.gestureGpuParticleFilters = paramList;
  }
  
  public void setGestureParticleFilters(List<VideoFilterBase> paramList)
  {
    this.gestureParticleFilters = paramList;
  }
  
  public void setHairCos(HairCos paramHairCos)
  {
    this.hairCos = paramHairCos;
  }
  
  public void setHeadCropFilter(HeadCropFilter paramHeadCropFilter)
  {
    this.headCropFilter = paramHeadCropFilter;
  }
  
  public void setHeadCropItemFilters(List<NormalVideoFilter> paramList)
  {
    this.headCropItemFilters = paramList;
  }
  
  public void setHotAreaPositions(ArrayList<RedPacketPosition> paramArrayList)
  {
    Object localObject = new ArrayList();
    if (this.gestureFilters != null) {
      ((ArrayList)localObject).addAll(this.gestureFilters);
    }
    if (this.headCropItemFilters != null) {
      ((ArrayList)localObject).addAll(this.headCropItemFilters);
    }
    if (this.bodyFilters != null) {
      ((ArrayList)localObject).addAll(this.bodyFilters);
    }
    if (this.filters != null) {
      ((ArrayList)localObject).addAll(this.filters);
    }
    if (this.fgStaticStickerFilters != null) {
      ((ArrayList)localObject).addAll(this.fgStaticStickerFilters);
    }
    if (this.mMaskStickerFilterList != null) {
      ((ArrayList)localObject).addAll(this.mMaskStickerFilterList);
    }
    localObject = ((ArrayList)localObject).iterator();
    VideoFilterBase localVideoFilterBase;
    while (((Iterator)localObject).hasNext())
    {
      localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setHotAreaPosition(paramArrayList);
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.setHotArea(paramArrayList);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.setHotArea(paramArrayList);
    }
    if (this.gestureParticleFilters != null)
    {
      localObject = this.gestureParticleFilters.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
        if ((localVideoFilterBase instanceof ParticleFilter)) {
          ((ParticleFilter)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        } else if ((localVideoFilterBase instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        }
      }
    }
    if (this.bodyParticleFilters != null)
    {
      localObject = this.bodyParticleFilters.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
        if ((localVideoFilterBase instanceof ParticleFilter)) {
          ((ParticleFilter)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        } else if ((localVideoFilterBase instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        }
      }
    }
    if (this.starParticleFilters != null)
    {
      localObject = this.starParticleFilters.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)((Iterator)localObject).next();
        if ((localVideoFilterBase instanceof ParticleFilter)) {
          ((ParticleFilter)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        } else if ((localVideoFilterBase instanceof ParticleFilter3D)) {
          ((ParticleFilter3D)localVideoFilterBase).setHotAreaPosition(paramArrayList);
        }
      }
    }
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setImageData(paramArrayOfByte);
    }
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setImageData(paramArrayOfByte);
      }
      if ((localVideoFilterBase instanceof FaceOff3DFilter)) {
        ((FaceOff3DFilter)localVideoFilterBase).setImageData(paramArrayOfByte);
      }
    }
  }
  
  public void setInputFrameFreezeSetting(VideoFilterInputFreeze paramVideoFilterInputFreeze)
  {
    this.inputFreezeFrameFilter = paramVideoFilterInputFreeze;
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      } else if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      } else if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      } else if ((localVideoFilterBase instanceof FaceOff3DFilter)) {
        ((FaceOff3DFilter)localVideoFilterBase).setRenderForBitmap(paramBoolean);
      }
    }
  }
  
  public void setLut(LutItemsFilter paramLutItemsFilter)
  {
    this.lutItemsFilter = paramLutItemsFilter;
  }
  
  public void setMaskStickerFilters(List<VideoFilterBase> paramList)
  {
    this.mMaskStickerFilterList = paramList;
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
  
  public void setOnLoadFinishListener(MaterialLoadFinishListener paramMaterialLoadFinishListener)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.setOnLoadFinishListener(paramMaterialLoadFinishListener);
    }
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
  
  public void setRapidNetFilterList(List<RapidNetFilter> paramList)
  {
    this.rapidNetFilterList = paramList;
  }
  
  public void setRatio(float paramFloat)
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof StaticStickerFilter)) {
        ((StaticStickerFilter)localVideoFilterBase).setRatio(paramFloat);
      }
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.setRatio(paramFloat);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.setRatio(paramFloat);
    }
    if (this.multiViewerFilters != null)
    {
      localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).setRatio(paramFloat);
      }
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    VideoFilterUtil.setRenderMode(this.filters, paramInt);
    VideoFilterUtil.setRenderMode(this.headCropItemFilters, paramInt);
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
    this.snapShotFrameToSticker.setRenderMode(paramInt);
    if (this.headCropFilter != null) {
      this.headCropFilter.setRenderMode(paramInt);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.setRenderMode(paramInt);
    }
    Iterator localIterator;
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).setRenderMode(paramInt);
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
    if (this.fabbyStrokeFilter != null) {
      this.fabbyStrokeFilter.setRenderMode(paramInt);
    }
    if (this.fastBlurFilter != null) {
      this.fastBlurFilter.setRenderMode(paramInt);
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.setRenderMode(paramInt);
    }
    if (this.mZoomFilter != null) {
      this.mZoomFilter.setRenderMode(paramInt);
    }
    if (this.mMaskStickerFilterList != null)
    {
      localIterator = this.mMaskStickerFilterList.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).setRenderMode(paramInt);
      }
    }
  }
  
  public void setSkyBox(SkyboxItemsFilter paramSkyboxItemsFilter)
  {
    this.skyboxItemsFilter = paramSkyboxItemsFilter;
  }
  
  public void setStarParticleFilters(List<VideoFilterBase> paramList)
  {
    this.starParticleFilters = paramList;
  }
  
  public void setTriggerWords(String paramString)
  {
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
      if ((localVideoFilterBase instanceof NormalVideoFilter)) {
        ((NormalVideoFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof FaceOffFilter)) {
        ((FaceOffFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof TransformFilter)) {
        ((TransformFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof VoiceTextFilter)) {
        ((VoiceTextFilter)localVideoFilterBase).setTriggerWords(paramString);
      } else if ((localVideoFilterBase instanceof FaceOff3DFilter)) {
        ((FaceOff3DFilter)localVideoFilterBase).setTriggerWords(paramString);
      }
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
  
  public void setZoomFilter(ZoomFilter paramZoomFilter)
  {
    this.mZoomFilter = paramZoomFilter;
  }
  
  public void syncCharmRangeValueForCosFunGroup(int paramInt1, int paramInt2, int paramInt3)
  {
    double d = (paramInt1 + 0.5D) / paramInt2;
    if (CosFunHelper.isRestart)
    {
      d = -1.0D;
      doReset();
    }
    Log.d(TAG, "[syncCharmRangeValueForCosFunGroup] index = " + paramInt1 + ", count = " + paramInt2 + ", randomValue = " + d);
    this.mCharmValueMap.put(Integer.valueOf(0), Double.valueOf(d));
    hitCharmRangeItem(0);
    paramInt1 = 1;
    while (paramInt1 < this.mFaceList.size())
    {
      paramInt2 = ((Face)this.mFaceList.get(paramInt1)).faceIndex;
      if (!this.mCharmValueMap.containsKey(Integer.valueOf(paramInt2))) {
        this.mCharmValueMap.put(Integer.valueOf(((Face)this.mFaceList.get(paramInt1)).faceIndex), Double.valueOf(d));
      }
      paramInt1 += 1;
    }
    this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(d));
  }
  
  public Frame undateAndRenderMaskSticker(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if ((this.mMaskStickerFilterList == null) || (this.mMaskStickerFilterList.size() < 1)) {
      return paramFrame;
    }
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = this.mMaskStickerFilterList.iterator();
    label54:
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (VideoFilterBase)((Iterator)localObject2).next();
      if ((localObject4 instanceof StaticMaskFilter)) {
        ((List)localObject3).add(localObject4);
      }
      if (!(localObject4 instanceof FastMaskFilter)) {
        break label787;
      }
      localObject1 = (FastMaskFilter)localObject4;
    }
    label264:
    label777:
    label780:
    label787:
    for (;;)
    {
      if ((localObject4 instanceof DynamicMaskFilter)) {
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
      i = getMaskType((List)localObject3, (FastMaskFilter)localObject1);
      if (i == 1)
      {
        FrameUtil.clearFrame((Frame)localObject2, 1.0F, 1.0F, 1.0F, 1.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          if (i != 1) {
            break label648;
          }
          FrameUtil.clearFrame(this.mMaskStickerFrame, 1.0F, 1.0F, 1.0F, 1.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
          RenderProcessForFilters(this.mMaskStickerFrame, (Frame)localObject2, (List)localObject3);
        }
        if (localObject1 == null) {
          break label780;
        }
        ((FastMaskFilter)localObject1).addSrcTexture(((Frame)localObject2).getTextureId());
      }
      for (localObject1 = ((FastMaskFilter)localObject1).render((Frame)localObject2);; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        Set localSet;
        long l;
        if (paramPTFaceAttr != null)
        {
          localObject4 = paramPTFaceAttr.getAllFacePoints();
          int j = Math.min(((List)localObject4).size(), getMaterial().getMaxFaceCount());
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
              localObject3 = (Face)this.mFaceList.get(i);
              localObject2 = ((Face)localObject3).facePoints;
              localObject3 = ((Face)localObject3).faceAngles;
              if ((!needShookHeadCount()) || (this.currentFaceInfo == null) || (this.selectFaceIndex < 0) || (this.selectFaceIndex >= ((List)localObject4).size())) {
                break label777;
              }
              setCurPersonId(i);
              localObject2 = (List)((List)localObject4).get(this.selectFaceIndex);
              localObject3 = (float[])localList.get(this.selectFaceIndex);
            }
          }
        }
        for (;;)
        {
          localObject2 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles((float[])localObject3).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(paramPTFaceAttr.getFaceDetector()).build();
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject3 = localArrayList.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                VideoFilterBase localVideoFilterBase = (VideoFilterBase)((Iterator)localObject3).next();
                if ((localVideoFilterBase instanceof DynamicMaskFilter))
                {
                  localVideoFilterBase.updatePreview(localObject2);
                  continue;
                  if (i == 2)
                  {
                    FrameUtil.clearFrame((Frame)localObject2, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
                    break;
                  }
                  FrameUtil.clearFrame((Frame)localObject2, 1.0F, 1.0F, 1.0F, 1.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
                  break;
                  if (i == 2)
                  {
                    FrameUtil.clearFrame(this.mMaskStickerFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
                    break label264;
                  }
                  FrameUtil.clearFrame(this.mMaskStickerFrame, 1.0F, 1.0F, 1.0F, 1.0F, this.mMaskStickerFrame.width, this.mMaskStickerFrame.height);
                  break label264;
                }
              }
            }
            localObject2 = getSpaceFrame(((Frame)localObject1).getTextureId());
            this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, (Frame)localObject2);
            RenderProcessForFilters((Frame)localObject1, (Frame)localObject2, localArrayList);
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
    updateFilters(paramPTDetectInfo, this.filters);
  }
  
  public Frame updateAndRenderActMaterial(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt, long paramLong)
  {
    Object localObject;
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.isFreezeFrame()))
    {
      localObject = this.inputFreezeFrameFilter.getPTFaceSnapshot(null);
      if (localObject != null)
      {
        paramList = ((PTFaceAttr)localObject).getAllFacePoints();
        paramList1 = ((PTFaceAttr)localObject).getAllFaceAngles();
        paramInt = ((PTFaceAttr)localObject).getRotation();
      }
    }
    for (;;)
    {
      localObject = paramFrame;
      if (this.mActFilters != null)
      {
        GlUtil.setBlendMode(true);
        localObject = this.mActFilters.updateAndRender(paramFrame, paramLong, paramList, paramList1, paramInt);
        GlUtil.setBlendMode(false);
      }
      return localObject;
    }
  }
  
  public Frame updateAndRenderAllStickers4QQ(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    Frame localFrame = updateAndRender(paramFrame, paramPTFaceAttr, null);
    if (allBusinessPrivateProcess(this.filters)) {
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
    if (this.mComicEffectFilters != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearComicEffectFiltersRenderStatus(this.mComicEffectFilters);
      if (j > 0) {
        break label125;
      }
      updateComicEffectFilters(1, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
      localObject1 = RenderProcessForComicEffectFilters(1, paramFrame, this.mComicEffectFilters);
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
      updateComicEffectFilters(1, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
      paramFrame = RenderProcessForComicEffectFilters(1, paramFrame, this.mComicEffectFilters);
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
    if (this.mEffectTriggerFilters != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearEffectTriggerFiltersRenderStatus(this.mEffectTriggerFilters);
      if (j > 0) {
        break label108;
      }
      updateEffectTriggerFilters(1, new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerFilters);
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
        break label312;
      }
    }
    label312:
    for (localObject1 = ((PTHandAttr)localObject1).getHandPointList();; localObject1 = localObject2)
    {
      updateEffectTriggerFilters(1, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mEffectTriggerFilters);
      paramFrame = RenderProcessForEffectTriggerFilters(1, paramFrame, this.mEffectTriggerFilters);
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
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    List localList1 = localPTFaceAttr.getAllFacePoints();
    List localList2 = localPTFaceAttr.getAllFaceAngles();
    Map localMap1 = localPTFaceAttr.getFaceActionCounter();
    Map localMap2 = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
    Set localSet = localPTFaceAttr.getTriggeredExpression();
    Object localObject;
    if (this.aiAttr == null)
    {
      paramPTFaceAttr = null;
      if (paramPTFaceAttr == null) {
        break label585;
      }
      localObject = paramPTFaceAttr.getHandPointList();
      localSet.add(Integer.valueOf(paramPTFaceAttr.getHandType()));
    }
    label585:
    for (paramPTFaceAttr = (PTFaceAttr)localObject;; paramPTFaceAttr = null)
    {
      long l = localPTFaceAttr.getTimeStamp();
      this.mBgFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      FrameUtil.clearFrame(this.mBgFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
      localObject = this.mBgFrame;
      GlUtil.setBlendMode(true);
      int j = Math.min(localList1.size(), getMaterial().getMaxFaceCount());
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          BenchUtil.benchStart("[showPreview]updateAllFilters");
          updateFilters(new PTDetectInfo.Builder().facePoints((List)localList1.get(i)).faceAngles((float[])localList2.get(i)).faceActionCounter(localMap1).handPoints(paramPTFaceAttr).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(localPTFaceAttr.getFaceDetector()).build(), this.bgDynamicStickerFilters);
          BenchUtil.benchEnd("[showPreview]updateAllFilters");
          BenchUtil.benchStart("[showPreview]RenderProcess");
          localObject = RenderProcessForFilters((Frame)localObject, this.bgDynamicStickerFilters);
          BenchUtil.benchEnd("[showPreview]RenderProcess");
          i += 1;
          continue;
          paramPTFaceAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
          break;
        }
      }
      if (localList1.size() <= 0)
      {
        paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap1).aiAttr(this.aiAttr).handPoints(paramPTFaceAttr).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).faceDetector(localPTFaceAttr.getFaceDetector()).build();
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerFilters, paramFrame, paramPTFaceAttr);
        updateFilters(paramPTFaceAttr, this.bgStaticStickerFilters);
      }
      for (paramPTFaceAttr = RenderProcessForFilters((Frame)localObject, this.bgStaticStickerFilters);; paramPTFaceAttr = RenderProcessForFilters((Frame)localObject, this.bgStaticStickerFilters))
      {
        this.mMaskFilter.OnDrawFrameGLSL();
        this.mMaskFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        GlUtil.setBlendMode(false);
        return paramPTFaceAttr;
        paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap1).handPoints(paramPTFaceAttr).handActionCounter(localMap2).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(localPTFaceAttr.getFaceDetector()).build();
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerFilters, paramFrame, paramPTFaceAttr);
        updateFilters(paramPTFaceAttr, this.bgStaticStickerFilters);
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
          updateFilters(paramPTDetectInfo, this.starParticleFilters.subList(0, Math.min(paramList.size(), this.starParticleFilters.size())));
          paramPTFaceAttr = RenderProcessForFastParticleFilter(paramFrame, this.starParticleFilters.subList(0, Math.min(paramList.size(), this.starParticleFilters.size())));
        }
      }
    }
  }
  
  public Frame updateAndRenderComicEffectFilters(int paramInt, Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mComicEffectFilters != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearComicEffectFiltersRenderStatus(this.mComicEffectFilters);
      if (j > 0) {
        break label125;
      }
      updateComicEffectFilters(paramInt, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
      localObject1 = RenderProcessForComicEffectFilters(paramInt, paramFrame, this.mComicEffectFilters);
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
      updateComicEffectFilters(paramInt, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
      paramFrame = RenderProcessForComicEffectFilters(paramInt, paramFrame, this.mComicEffectFilters);
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
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    if ((localPTFaceAttr.isLandscape()) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramFrame;
    }
    if (localPTFaceAttr.getFaceCount() > 0) {
      setImageData(localPTFaceAttr.getData());
    }
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFrame = updateAndRender(paramFrame, localPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFrame;
  }
  
  public Frame updateAndRenderDynamicStickersPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    if ((localPTFaceAttr.isLandscape()) && (!getMaterial().isSupportLandscape()))
    {
      destroyNormalAudio();
      return paramFrame;
    }
    if (localPTFaceAttr.getFaceCount() > 0) {
      setImageData(localPTFaceAttr.getData());
    }
    BenchUtil.benchStart("[VideoFilterList] updateAndRender");
    paramFrame = updateAndRenderPluggable(paramFrame, localPTFaceAttr, paramAIAttr);
    BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
    return paramFrame;
  }
  
  public Frame updateAndRenderEffectTriggerFilters(int paramInt, Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Object localObject2 = paramPTFaceAttr.getAllFacePoints();
    Object localObject1 = paramFrame;
    int j;
    if (this.mEffectTriggerFilters != null)
    {
      j = Math.min(((List)localObject2).size(), getMaterial().getMaxFaceCount());
      clearEffectTriggerFiltersRenderStatus(this.mEffectTriggerFilters);
      if (j > 0) {
        break label108;
      }
      updateEffectTriggerFilters(paramInt, new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerFilters);
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
      updateEffectTriggerFilters(paramInt, new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).aiAttr(this.aiAttr).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).build(), this.mEffectTriggerFilters);
      paramFrame = RenderProcessForEffectTriggerFilters(paramInt, paramFrame, this.mEffectTriggerFilters);
      i += 1;
      break;
      localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break label173;
    }
  }
  
  public Frame updateAndRenderFabbyMV(Frame paramFrame, AIAttr paramAIAttr, Map<Integer, Frame> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    if (this.fabbyMvFilters != null)
    {
      if ((paramMap == null) || (!paramMap.containsKey(Integer.valueOf(0))) || (paramFrame.getTextureId() != ((Frame)paramMap.get(Integer.valueOf(0))).getTextureId())) {
        break label148;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.fabbyOriginCopyFrame);
      paramFrame = this.fabbyOriginCopyFrame;
    }
    label148:
    for (;;)
    {
      this.fabbyMvFilters.setTouchPoints(this.mMaskTouchPoints);
      if (paramAIAttr != null) {
        this.fabbyMvFilters.updateHandAttr((PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value));
      }
      return this.fabbyMvFilters.updateAndRender(paramFrame, paramMap, paramMap1, paramSet, paramLong);
      return (Frame)paramMap.values().iterator().next();
    }
  }
  
  public Frame updateAndRenderFaceSwitch(Frame paramFrame, List<List<PointF>> paramList, Set<Integer> paramSet)
  {
    Iterator localIterator;
    Object localObject;
    if (VideoMaterialUtil.isFaceCopyMaterial(getMaterial()))
    {
      localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFilterBase)localIterator.next();
        if ((localObject instanceof FaceCopyFilter))
        {
          localObject = (FaceCopyFilter)localObject;
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
      localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFilterBase)localIterator.next();
        if ((localObject instanceof SwitchFaceFilter))
        {
          localObject = (SwitchFaceFilter)localObject;
          ((SwitchFaceFilter)localObject).setFaceParams(paramList, this.copyFrame[0].getTextureId());
          ((SwitchFaceFilter)localObject).renderProcess(paramSet);
        }
      }
    }
    return paramFrame;
  }
  
  public Frame updateAndRenderFilamentFilter(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    Frame localFrame = paramFrame;
    if (this.filamentFilter != null) {
      localFrame = this.filamentFilter.render(paramFrame, this.aiAttr, paramPTFaceAttr);
    }
    return localFrame;
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
    if ((this.hairCos == null) || (paramPTHairAttr == null) || (!paramPTHairAttr.isReady())) {
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
      paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles(arrayOfFloat).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      localObject1 = this.hairCos;
      if (this.fabbyMvFilters == null) {}
      for (int i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex()) {
        return ((HairCos)localObject1).render(paramFrame, paramPTHairAttr, paramPTFaceAttr, i);
      }
    }
  }
  
  public Frame updateAndRenderHeadCropItemFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    int i = (localPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    GlUtil.setBlendMode(true);
    if (this.headCropFilter != null)
    {
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mHeadCropFrame);
      this.headCropFilter.setInputFrame(this.mHeadCropFrame);
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    }
    List localList1 = localPTFaceAttr.getAllFacePoints();
    List localList2 = localPTFaceAttr.getAllFaceAngles();
    Map localMap = localPTFaceAttr.getFaceActionCounter();
    Set localSet = localPTFaceAttr.getTriggeredExpression();
    long l;
    if (this.aiAttr == null)
    {
      paramPTFaceAttr = null;
      if (paramPTFaceAttr != null) {
        localSet.add(Integer.valueOf(paramPTFaceAttr.getHandType()));
      }
      l = localPTFaceAttr.getTimeStamp();
      if (localList1.size() > 0) {
        break label290;
      }
      updateFilters(new PTDetectInfo.Builder().faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(localPTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
    }
    for (paramFrame = RenderProcessForFilters(paramFrame, this.headCropItemFilters);; paramFrame = RenderProcessForFilters(paramFrame, this.headCropItemFilters))
    {
      GlUtil.setBlendMode(false);
      return paramFrame;
      paramPTFaceAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
      break;
      label290:
      updateFilters(new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])localList2.get(0)).faceActionCounter(localMap).triggeredExpression(localSet).timestamp(l).aiAttr(this.aiAttr).faceDetector(localPTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
    }
  }
  
  public Frame updateAndRenderLut(Frame paramFrame, PTFaceAttr paramPTFaceAttr, Bitmap paramBitmap)
  {
    if (this.lutItemsFilter == null) {
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
      paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles(arrayOfFloat).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      localObject1 = this.lutItemsFilter;
      if (this.fabbyMvFilters == null) {}
      for (int i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex()) {
        return ((LutItemsFilter)localObject1).render(paramFrame, paramPTFaceAttr, i, paramBitmap);
      }
    }
  }
  
  public void updateAndRenderMultiViewerMaterial(Map<Integer, Frame> paramMap, Frame paramFrame, AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, PTHairAttr paramPTHairAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      localPTSegAttr = paramPTSegAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame())
      {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
        localPTSegAttr = this.inputFreezeFrameFilter.getPTSegSnapshot(paramPTSegAttr);
      }
    }
    if (localPTFaceAttr == null) {}
    do
    {
      do
      {
        return;
        paramPTFaceAttr = localPTFaceAttr.getFaceActionCounter();
        paramMap.clear();
      } while (this.multiViewerFilters == null);
      paramPTSegAttr = (FabbyFaceActionCounter)paramPTFaceAttr.get(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value));
    } while (paramPTSegAttr == null);
    int i = 0;
    label110:
    MultiViewerFilter localMultiViewerFilter;
    int j;
    if (i < this.multiViewerFilters.size())
    {
      localMultiViewerFilter = (MultiViewerFilter)this.multiViewerFilters.get(i);
      if ((localMultiViewerFilter != null) && (localMultiViewerFilter.needRenderThisPart(paramPTSegAttr.count)))
      {
        j = localMultiViewerFilter.getRenderId();
        if (paramPTSegAttr.scaleMap.get(Integer.valueOf(j)) == null) {
          break label445;
        }
        paramPTFaceAttr = (PointF)paramPTSegAttr.scaleMap.get(Integer.valueOf(j));
        label203:
        float f = Math.max(paramPTFaceAttr.x, paramPTFaceAttr.y);
        if (localMultiViewerFilter.hasZoomFilter()) {
          f = 1.0F;
        }
        int k = (int)(paramFrame.width * f);
        int m = (int)(paramFrame.height * f);
        localMultiViewerFilter.updateVideoSize(k, m, this.mFaceDetScale / f);
        if (!this.multiViewerFrameMap.containsKey(Integer.valueOf(j)))
        {
          paramPTFaceAttr = new Frame();
          this.multiViewerFrameMap.put(Integer.valueOf(j), paramPTFaceAttr);
        }
        paramPTFaceAttr = (Frame)this.multiViewerFrameMap.get(Integer.valueOf(j));
        paramPTFaceAttr.bindFrame(-1, k, m, 0.0D);
        BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - clearFrame");
        FrameUtil.clearFrame(paramPTFaceAttr, 0.0F, 0.0F, 0.0F, 0.0F, paramPTFaceAttr.width, paramPTFaceAttr.height);
        BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - clearFrame");
        BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
        if ((localMultiViewerFilter.getStickersMap() == null) || (!localMultiViewerFilter.getStickersMap().isChangeRenderOrder())) {
          break label459;
        }
      }
    }
    label445:
    label459:
    for (paramPTFaceAttr = localMultiViewerFilter.renderPlugin(paramFrame, paramPTFaceAttr, paramAIAttr, localPTFaceAttr, localPTSegAttr, paramPTHairAttr);; paramPTFaceAttr = localMultiViewerFilter.render(paramFrame, paramPTFaceAttr, paramAIAttr, localPTFaceAttr, localPTSegAttr, paramPTHairAttr))
    {
      BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
      paramMap.put(Integer.valueOf(j), paramPTFaceAttr);
      i += 1;
      break label110;
      break;
      paramPTFaceAttr = new PointF(1.0F, 1.0F);
      break label203;
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
    Object localObject = paramFrame;
    if (FeatureManager.Features.RAPID_NET.isModelLoaded(0))
    {
      localObject = paramFrame;
      if (this.rapidNetFilterList != null)
      {
        localObject = paramFrame;
        if (this.rapidNetFilterList.size() > 0)
        {
          localObject = paramFrame;
          if (this.mFaceList.size() > 0)
          {
            localObject = paramFrame;
            if (paramPTFaceAttr.getAllFacePoints().size() > 0)
            {
              RapidNetFilter localRapidNetFilter = (RapidNetFilter)this.rapidNetFilterList.get(0);
              Face localFace = (Face)this.mFaceList.get(0);
              localObject = new ArrayList();
              PTHandAttr localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
              if (localPTHandAttr != null) {
                localObject = localPTHandAttr.getHandPointList();
              }
              Set localSet = paramPTFaceAttr.getTriggeredExpression();
              if (localPTHandAttr != null) {
                localSet.add(Integer.valueOf(localPTHandAttr.getHandType()));
              }
              localRapidNetFilter.updateActionTriggered(new PTDetectInfo.Builder().facePoints(localFace.facePoints).faceAngles(localFace.faceAngles).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build());
              localRapidNetFilter.updateAndRender(paramFrame, (List)paramPTFaceAttr.getAllFacePoints().get(0), this.mFaceDetScale);
              localObject = localRapidNetFilter.render(paramFrame);
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public Frame updateAndRenderSkybox(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if (this.skyboxItemsFilter == null) {
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
      localObject1 = new PTDetectInfo.Builder().facePoints((List)localObject2).faceAngles(arrayOfFloat).faceStatus(localFaceStatus).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handPoints((List)localObject1).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).phoneAngle(paramPTFaceAttr.getRotation()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build();
      if ("sky".equals(((StickerItem)this.skyboxItemsFilter.getItems().get(0)).maskType))
      {
        paramPTFaceAttr = (PTSkyAttr)this.aiAttr.getRealtimeData(AEDetectorType.SKY_SEGMENT.value);
        if (paramPTFaceAttr == null) {}
      }
      for (paramPTFaceAttr = paramPTFaceAttr.getMaskBitmap();; paramPTFaceAttr = null)
      {
        localObject2 = this.skyboxItemsFilter;
        if (this.fabbyMvFilters == null) {}
        for (int i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex()) {
          return ((SkyboxItemsFilter)localObject2).render(paramFrame, (PTDetectInfo)localObject1, i, paramPTFaceAttr);
        }
      }
    }
  }
  
  public Frame updateAndRenderStaticStickers(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.isFreezeFrame())) {}
    label1418:
    for (PTFaceAttr localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);; localPTFaceAttr = paramPTFaceAttr)
    {
      int i = (localPTFaceAttr.getRotation() + 360) % 360;
      if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
        return paramFrame;
      }
      Object localObject1 = localPTFaceAttr.getAllFacePoints();
      paramPTFaceAttr = localPTFaceAttr.getFaceActionCounter();
      Object localObject3 = localPTFaceAttr.getTriggeredExpression();
      PTHandAttr localPTHandAttr;
      Object localObject4;
      long l;
      Object localObject2;
      int j;
      int k;
      if (this.aiAttr == null)
      {
        localPTHandAttr = null;
        if (localPTHandAttr != null) {
          ((Set)localObject3).add(Integer.valueOf(localPTHandAttr.getHandType()));
        }
        localObject4 = localPTFaceAttr.getAllFaceAngles();
        l = localPTFaceAttr.getTimeStamp();
        GlUtil.setBlendMode(true);
        if (((List)localObject1).size() > 0) {
          break label790;
        }
        localObject2 = localPTFaceAttr.getStarPoints();
        localObject3 = new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr).aiAttr(this.aiAttr).triggeredExpression((Set)localObject3).timestamp(l).phoneAngle(i).faceDetector(localPTFaceAttr.getFaceDetector()).starPoints((List)localObject2).build();
        this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerFilters, paramFrame, (PTDetectInfo)localObject3);
        if (this.mZoomFilter != null)
        {
          paramPTFaceAttr = this.mZoomFilter;
          j = paramFrame.width;
          k = paramFrame.height;
          if (this.fabbyMvFilters != null) {
            break label360;
          }
        }
      }
      label360:
      for (i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex())
      {
        paramPTFaceAttr.updateZoomParams(localPTFaceAttr, (PTDetectInfo)localObject3, j, k, i);
        if (this.mMaskStickerFilterList == null) {
          break label371;
        }
        paramPTFaceAttr = this.mMaskStickerFilterList.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          localObject4 = (VideoFilterBase)paramPTFaceAttr.next();
          if ((localObject4 instanceof NormalVideoFilter))
          {
            ((VideoFilterBase)localObject4).updateVideoSize(paramFrame.width, paramFrame.height, localPTFaceAttr.getFaceDetectScale());
            ((VideoFilterBase)localObject4).updatePreview(localObject3);
          }
        }
        localPTHandAttr = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
        break;
      }
      label371:
      updateFilters((PTDetectInfo)localObject3, this.fgStaticStickerFilters);
      paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerFilters);
      updateFilters((PTDetectInfo)localObject3, this.faceParticleStaticFilters);
      paramFrame = RenderProcessForFilters(paramFrame, this.faceParticleStaticFilters);
      updateFilters((PTDetectInfo)localObject3, this.faceGpuParticleStaticFilters);
      paramPTFaceAttr = RenderProcessForGpuParticleFilters(paramFrame, this.faceGpuParticleStaticFilters);
      if (localPTFaceAttr.getStarMaskFrame() != null)
      {
        this.starOverlayFilter.setTexture2(localPTFaceAttr.getStarMaskFrame().getTextureId());
        this.starOverlayFilter.RenderProcess(paramPTFaceAttr.getTextureId(), paramPTFaceAttr.width, paramPTFaceAttr.height, -1, 0.0D, this.starOverlayFrame);
        paramFrame = this.starOverlayFrame;
        localPTFaceAttr.getStarMaskFrame().unlock();
        GlUtil.setBlendMode(false);
        if (this.mEffectTriggerFilters == null) {
          break label1603;
        }
        j = Math.min(((List)localObject1).size(), getMaterial().getMaxFaceCount());
        if (j > 0) {
          break label1249;
        }
        updateEffectTriggerFilters(2, new PTDetectInfo.Builder().faceActionCounter(localPTFaceAttr.getFaceActionCounter()).triggeredExpression(localPTFaceAttr.getTriggeredExpression()).timestamp(localPTFaceAttr.getTimeStamp()).faceDetector(localPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerFilters);
      }
      label790:
      label1603:
      for (;;)
      {
        paramPTFaceAttr = paramFrame;
        if (this.mComicEffectFilters != null)
        {
          j = Math.min(((List)localObject1).size(), getMaterial().getMaxFaceCount());
          if (j > 0) {
            break label1418;
          }
          updateComicEffectFilters(2, new PTDetectInfo.Builder().aiAttr(this.aiAttr).faceActionCounter(localPTFaceAttr.getFaceActionCounter()).triggeredExpression(localPTFaceAttr.getTriggeredExpression()).timestamp(localPTFaceAttr.getTimeStamp()).faceDetector(localPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
        }
        for (paramPTFaceAttr = RenderProcessForComicEffectFilters(2, paramFrame, this.mComicEffectFilters);; paramPTFaceAttr = paramFrame)
        {
          return paramPTFaceAttr;
          paramFrame = paramPTFaceAttr;
          if (localObject2 == null) {
            break;
          }
          paramFrame = paramPTFaceAttr;
          if (((List)localObject2).size() <= 0) {
            break;
          }
          updateFilters((PTDetectInfo)localObject3, this.starParticleFilters.subList(0, Math.min(((List)localObject2).size(), this.starParticleFilters.size())));
          paramFrame = RenderProcessForFastParticleFilter(paramPTFaceAttr, this.starParticleFilters.subList(0, Math.min(((List)localObject2).size(), this.starParticleFilters.size())));
          break;
          localObject2 = localPTFaceAttr.getStarPoints();
          localObject3 = new PTDetectInfo.Builder().facePoints((List)((List)localObject1).get(0)).faceAngles((float[])((List)localObject4).get(0)).phoneAngle(i).faceActionCounter(paramPTFaceAttr).aiAttr(this.aiAttr).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression((Set)localObject3).timestamp(l).faceDetector(localPTFaceAttr.getFaceDetector()).starPoints((List)localObject2).build();
          this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerFilters, paramFrame, (PTDetectInfo)localObject3);
          if (this.mZoomFilter != null)
          {
            paramPTFaceAttr = this.mZoomFilter;
            j = paramFrame.width;
            k = paramFrame.height;
            if (this.fabbyMvFilters != null) {
              break label1021;
            }
          }
          label1021:
          for (i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex())
          {
            paramPTFaceAttr.updateZoomParams(localPTFaceAttr, (PTDetectInfo)localObject3, j, k, i);
            if (this.mMaskStickerFilterList == null) {
              break;
            }
            paramPTFaceAttr = this.mMaskStickerFilterList.iterator();
            while (paramPTFaceAttr.hasNext())
            {
              localObject4 = (VideoFilterBase)paramPTFaceAttr.next();
              if ((localObject4 instanceof NormalVideoFilter))
              {
                ((VideoFilterBase)localObject4).updateVideoSize(paramFrame.width, paramFrame.height, localPTFaceAttr.getFaceDetectScale());
                ((VideoFilterBase)localObject4).updatePreview(localObject3);
              }
            }
          }
          updateFilters((PTDetectInfo)localObject3, this.fgStaticStickerFilters);
          paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerFilters);
          updateFilters((PTDetectInfo)localObject3, this.faceParticleStaticFilters);
          paramFrame = RenderProcessForFilters(paramFrame, this.faceParticleStaticFilters);
          updateFilters((PTDetectInfo)localObject3, this.faceGpuParticleStaticFilters);
          paramPTFaceAttr = RenderProcessForGpuParticleFilters(paramFrame, this.faceGpuParticleStaticFilters);
          if (localPTFaceAttr.getStarMaskFrame() != null)
          {
            this.starOverlayFilter.setTexture2(localPTFaceAttr.getStarMaskFrame().getTextureId());
            this.starOverlayFilter.RenderProcess(paramPTFaceAttr.getTextureId(), paramPTFaceAttr.width, paramPTFaceAttr.height, -1, 0.0D, this.starOverlayFrame);
            paramFrame = this.starOverlayFrame;
            localPTFaceAttr.getStarMaskFrame().unlock();
            break;
          }
          paramFrame = paramPTFaceAttr;
          if (localObject2 == null) {
            break;
          }
          paramFrame = paramPTFaceAttr;
          if (((List)localObject2).size() <= 0) {
            break;
          }
          updateFilters((PTDetectInfo)localObject3, this.starParticleFilters.subList(0, Math.min(((List)localObject2).size(), this.starParticleFilters.size())));
          paramFrame = RenderProcessForFastParticleFilter(paramPTFaceAttr, this.starParticleFilters.subList(0, Math.min(((List)localObject2).size(), this.starParticleFilters.size())));
          break;
          label1249:
          i = 0;
          while ((i < j) && (i < this.mFaceList.size()))
          {
            localObject2 = (Face)this.mFaceList.get(i);
            paramPTFaceAttr = new ArrayList();
            if (localPTHandAttr != null) {
              paramPTFaceAttr = localPTHandAttr.getHandPointList();
            }
            updateEffectTriggerFilters(2, new PTDetectInfo.Builder().facePoints(((Face)localObject2).facePoints).faceAngles(((Face)localObject2).faceAngles).faceActionCounter(localPTFaceAttr.getFaceActionCounter()).handPoints(paramPTFaceAttr).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localPTFaceAttr.getTriggeredExpression()).phoneAngle(localPTFaceAttr.getRotation()).timestamp(localPTFaceAttr.getTimeStamp()).faceDetector(localPTFaceAttr.getFaceDetector()).aiAttr(this.aiAttr).build(), this.mEffectTriggerFilters);
            paramFrame = RenderProcessForEffectTriggerFilters(2, paramFrame, this.mEffectTriggerFilters);
            i += 1;
          }
          i = 0;
          while ((i < j) && (i < this.mFaceList.size()))
          {
            localObject1 = (Face)this.mFaceList.get(i);
            paramPTFaceAttr = new ArrayList();
            if (localPTHandAttr != null) {
              paramPTFaceAttr = localPTHandAttr.getHandPointList();
            }
            updateComicEffectFilters(2, new PTDetectInfo.Builder().facePoints(((Face)localObject1).facePoints).faceAngles(((Face)localObject1).faceAngles).faceActionCounter(localPTFaceAttr.getFaceActionCounter()).handPoints(paramPTFaceAttr).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).aiAttr(this.aiAttr).triggeredExpression(localPTFaceAttr.getTriggeredExpression()).phoneAngle(localPTFaceAttr.getRotation()).timestamp(localPTFaceAttr.getTimeStamp()).faceDetector(localPTFaceAttr.getFaceDetector()).build(), this.mComicEffectFilters, paramFrame.width, paramFrame.height);
            paramFrame = RenderProcessForComicEffectFilters(2, paramFrame, this.mComicEffectFilters);
            i += 1;
          }
        }
      }
    }
  }
  
  public Frame updateAndRenderStaticStickersBeforeTransform(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.inputFreezeFrameFilter != null)
    {
      localPTFaceAttr = paramPTFaceAttr;
      if (this.inputFreezeFrameFilter.isFreezeFrame()) {
        localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
      }
    }
    int i = (localPTFaceAttr.getRotation() + 360) % 360;
    if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
      return paramFrame;
    }
    paramPTFaceAttr = localPTFaceAttr.getAllFacePoints();
    Map localMap = localPTFaceAttr.getFaceActionCounter();
    Set localSet = localPTFaceAttr.getTriggeredExpression();
    List localList = localPTFaceAttr.getAllFaceAngles();
    long l = localPTFaceAttr.getTimeStamp();
    GlUtil.setBlendMode(true);
    if (paramPTFaceAttr.size() <= 0)
    {
      paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(localMap).aiAttr(this.aiAttr).triggeredExpression(localSet).timestamp(l).faceDetector(localPTFaceAttr.getFaceDetector()).build();
      if (!isMaterialSegmentRequired()) {
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerFilters, paramFrame, paramPTFaceAttr);
      }
      updateFilters(paramPTFaceAttr, this.fgStaticStickerBeforeTransformFilters);
    }
    for (paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerBeforeTransformFilters);; paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerBeforeTransformFilters))
    {
      GlUtil.setBlendMode(false);
      return paramFrame;
      paramPTFaceAttr = new PTDetectInfo.Builder().facePoints((List)paramPTFaceAttr.get(0)).faceAngles((float[])localList.get(0)).faceActionCounter(localMap).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression(localSet).aiAttr(this.aiAttr).timestamp(l).faceDetector(localPTFaceAttr.getFaceDetector()).build();
      if (!isMaterialSegmentRequired()) {
        this.snapShotFrameToSticker.updateTexture(this.fgStaticStickerFilters, paramFrame, paramPTFaceAttr);
      }
      updateFilters(paramPTFaceAttr, this.fgStaticStickerBeforeTransformFilters);
    }
  }
  
  public Frame updateAndRenderStaticStickersPluggable(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.isFreezeFrame())) {
      paramPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(paramPTFaceAttr);
    }
    for (;;)
    {
      int i = (paramPTFaceAttr.getRotation() + 360) % 360;
      if (((i == 90) || (i == 270)) && (!this.material.isSupportLandscape())) {
        return paramFrame;
      }
      List localList1 = paramPTFaceAttr.getAllFacePoints();
      Object localObject2 = paramPTFaceAttr.getFaceActionCounter();
      Object localObject3 = paramPTFaceAttr.getTriggeredExpression();
      Object localObject1;
      long l;
      int j;
      int k;
      if (this.aiAttr == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((Set)localObject3).add(Integer.valueOf(((PTHandAttr)localObject1).getHandType()));
        }
        localObject1 = paramPTFaceAttr.getAllFaceAngles();
        l = paramPTFaceAttr.getTimeStamp();
        GlUtil.setBlendMode(true);
        if (localList1.size() > 0) {
          break label413;
        }
        localObject1 = paramPTFaceAttr.getStarPoints();
        localObject1 = new PTDetectInfo.Builder().faceActionCounter((Map)localObject2).aiAttr(this.aiAttr).triggeredExpression((Set)localObject3).timestamp(l).phoneAngle(i).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints((List)localObject1).build();
        this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerFilters, paramFrame, (PTDetectInfo)localObject1);
        if (this.mZoomFilter != null)
        {
          localObject2 = this.mZoomFilter;
          j = paramFrame.width;
          k = paramFrame.height;
          if (this.fabbyMvFilters != null) {
            break label356;
          }
        }
      }
      label356:
      for (i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex())
      {
        ((ZoomFilter)localObject2).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject1, j, k, i);
        if (this.mMaskStickerFilterList == null) {
          break label367;
        }
        localObject2 = this.mMaskStickerFilterList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (VideoFilterBase)((Iterator)localObject2).next();
          if ((localObject3 instanceof NormalVideoFilter))
          {
            ((VideoFilterBase)localObject3).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
            ((VideoFilterBase)localObject3).updatePreview(localObject1);
          }
        }
        localObject1 = (PTHandAttr)this.aiAttr.getAvailableData(AEDetectorType.HAND.value);
        break;
      }
      label367:
      updateFilters((PTDetectInfo)localObject1, this.fgStaticStickerFilters);
      paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerFilters);
      updateFilters((PTDetectInfo)localObject1, this.faceParticleStaticFilters);
      for (paramFrame = RenderProcessForFilters(paramFrame, this.faceParticleStaticFilters);; paramFrame = RenderProcessForFilters(paramFrame, this.fgStaticStickerFilters))
      {
        GlUtil.setBlendMode(false);
        return paramFrame;
        label413:
        List localList2 = paramPTFaceAttr.getStarPoints();
        localObject1 = new PTDetectInfo.Builder().facePoints((List)localList1.get(0)).faceAngles((float[])((List)localObject1).get(0)).phoneAngle(i).faceActionCounter((Map)localObject2).aiAttr(this.aiAttr).handActionCounter(AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND)).triggeredExpression((Set)localObject3).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints(localList2).build();
        this.snapShotFrameToSticker.updateTextureWithSticker(this.fgStaticStickerFilters, paramFrame, (PTDetectInfo)localObject1);
        if (this.mZoomFilter != null)
        {
          localObject2 = this.mZoomFilter;
          j = paramFrame.width;
          k = paramFrame.height;
          if (this.fabbyMvFilters != null) {
            break label646;
          }
        }
        label646:
        for (i = this.mCurMVPart;; i = this.fabbyMvFilters.getCurPartIndex())
        {
          ((ZoomFilter)localObject2).updateZoomParams(paramPTFaceAttr, (PTDetectInfo)localObject1, j, k, i);
          if (this.mMaskStickerFilterList == null) {
            break;
          }
          localObject2 = this.mMaskStickerFilterList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (VideoFilterBase)((Iterator)localObject2).next();
            if ((localObject3 instanceof NormalVideoFilter))
            {
              ((VideoFilterBase)localObject3).updateVideoSize(paramFrame.width, paramFrame.height, paramPTFaceAttr.getFaceDetectScale());
              ((VideoFilterBase)localObject3).updatePreview(localObject1);
            }
          }
        }
        updateFilters((PTDetectInfo)localObject1, this.fgStaticStickerFilters);
      }
    }
  }
  
  public void updateComicEffectFilters(int paramInt1, PTDetectInfo paramPTDetectInfo, List<ComicEffectFilter> paramList, int paramInt2, int paramInt3)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ComicEffectFilter localComicEffectFilter = (ComicEffectFilter)paramList.next();
        if (paramInt1 == localComicEffectFilter.getOrderMode()) {
          localComicEffectFilter.updatePreview(paramPTDetectInfo, paramInt2, paramInt3);
        }
      }
    }
  }
  
  public void updateCosAlpha(int paramInt)
  {
    if (VideoMaterialUtil.isCosMaterial(getMaterial()))
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        VideoFilterBase localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof FaceOffFilter)) {
          ((FaceOffFilter)localVideoFilterBase).setCosAlpha(paramInt / 100.0F);
        }
        if ((localVideoFilterBase instanceof FaceOff3DFilter)) {
          ((FaceOff3DFilter)localVideoFilterBase).setCosAlpha(paramInt / 100.0F);
        }
      }
    }
  }
  
  public void updateCurrentTriggerParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.isStateTrigger())) {
      this.inputFreezeFrameFilter.checkFreezeFrameValiedByStateTrigger(paramMap, paramSet);
    }
    while ((this.inputFreezeFrameFilter == null) || (this.inputFreezeFrameFilter.isTimeTrigger())) {
      return;
    }
    this.inputFreezeFrameFilter.checkFreezeFrameValiedByTriggers(paramMap, paramSet, paramAIAttr);
  }
  
  public void updateEffectTriggerFilters(int paramInt, PTDetectInfo paramPTDetectInfo, List<EffectTriggerFilter> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EffectTriggerFilter localEffectTriggerFilter = (EffectTriggerFilter)paramList.next();
        if (paramInt == localEffectTriggerFilter.getOrderMode()) {
          localEffectTriggerFilter.updatePreview(paramPTDetectInfo);
        }
      }
    }
  }
  
  public void updateFaceParams(AIAttr paramAIAttr, PTFaceAttr paramPTFaceAttr, int paramInt)
  {
    Object localObject1 = paramPTFaceAttr.getAllFacePoints();
    Object localObject2 = paramPTFaceAttr.getAllFaceAngles();
    List localList1 = paramPTFaceAttr.getShookFaceInfos();
    List localList2 = paramPTFaceAttr.getFaceStatusList();
    List localList3 = paramPTFaceAttr.getPointsVis();
    PTFaceAttr localPTFaceAttr;
    if ((this.inputFreezeFrameFilter != null) && (this.inputFreezeFrameFilter.isFreezeFrame()))
    {
      localPTFaceAttr = this.inputFreezeFrameFilter.getPTFaceSnapshot(null);
      if (localPTFaceAttr != null)
      {
        paramPTFaceAttr = localPTFaceAttr.getAllFacePoints();
        localObject1 = localPTFaceAttr.getAllFaceAngles();
        localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
        localObject2 = this.inputFreezeFrameFilter.getFrameInfoSnapShot();
        if ((localObject2 != null) && (((VideoFilterListSnapshot)localObject2).getInputFrameSnapshot() != null))
        {
          paramInt = ((VideoFilterListSnapshot)localObject2).getInputFrameSnapshot().width;
          localObject2 = localObject1;
          localObject1 = paramPTFaceAttr;
        }
      }
    }
    for (;;)
    {
      int i = Math.min(((List)localObject1).size(), getMaterial().getMaxFaceCount());
      processMappingFace((List)localObject1, (List)localObject2, localList3, localList2, paramInt);
      updateShookHead(localList1);
      if (i <= 0)
      {
        clearCharmRangeItemStatus();
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
      if (this.cosFunFilterGroup == null) {
        syncCharmRangeAndHandsRangeValue(bool);
      }
      for (;;)
      {
        syncRandomGroupValue(bool);
        hitHandsRangeItem();
        hitHandRandomGroupItem();
        return;
        this.cosFunFilterGroup.updateParams(localPTFaceAttr);
        syncCharmRangeValueForCosFunGroup(this.cosFunFilterGroup.getItemIndex(), this.cosFunFilterGroup.getItemCount(), this.mFaceList.size());
      }
      localObject2 = localObject1;
      localObject1 = paramPTFaceAttr;
      continue;
      paramPTFaceAttr = (PTFaceAttr)localObject1;
      localObject1 = localObject2;
      break;
      localPTFaceAttr = paramPTFaceAttr;
    }
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
  
  public void updateIntensity(float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.filamentFilter != null) {
      this.filamentFilter.updateIntensity(paramFloat, paramInt1, paramInt2);
    }
  }
  
  public Frame updateParticleStatic(Frame paramFrame, PTDetectInfo paramPTDetectInfo, List<PointF> paramList)
  {
    GlUtil.setBlendMode(true);
    updateFilters(paramPTDetectInfo, this.faceParticleStaticFilters);
    paramFrame = RenderProcessForFilters(paramFrame, this.faceParticleStaticFilters);
    updateFilters(paramPTDetectInfo, this.faceParticleDynamicFilters);
    paramFrame = RenderProcessForFilters(paramFrame, this.multiViewerOutFrame, this.faceParticleDynamicFilters);
    updateFilters(paramPTDetectInfo, this.bodyParticleFilters);
    Frame localFrame = RenderProcessForFastParticleFilter(paramFrame, this.bodyParticleFilters);
    paramFrame = localFrame;
    if (isHandPointsValid(paramList))
    {
      updateFilters(paramPTDetectInfo, this.gestureParticleFilters);
      paramFrame = RenderProcessForFilters(localFrame, this.gestureParticleFilters);
    }
    GlUtil.setBlendMode(false);
    return paramFrame;
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong, AIAttr paramAIAttr)
  {
    if (this.multiViewerFilters != null)
    {
      Iterator localIterator = this.multiViewerFilters.iterator();
      while (localIterator.hasNext()) {
        ((MultiViewerFilter)localIterator.next()).updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
      }
    }
    updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
    if (this.cosFunFilterGroup != null) {
      this.cosFunFilterGroup.updateCurrentTriggerParam(paramMap, paramSet, paramAIAttr);
    }
    if ((isAllFreezeFrame()) && (paramSet != null)) {
      paramSet.add(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.updateTextureParam(paramMap, paramSet, paramLong, paramAIAttr);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mFaceDetScale = paramDouble;
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.qqGestureStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.qqGestureDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.bodyFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.bodyParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.starParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.headCropItemFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceGpuParticleDynamicFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.faceGpuParticleStaticFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localIterator = this.gestureGpuParticleFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fabbyMvFilters != null) {
      this.fabbyMvFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.headCropFilter != null) {
      this.headCropFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.crazyFaceFilters != null) {
      this.crazyFaceFilters.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFacialFeatureFilterList != null)
    {
      localIterator = this.mFacialFeatureFilterList.iterator();
      while (localIterator.hasNext()) {
        ((FacialFeatureFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
      }
    }
    if (this.mARParticleFilter != null) {
      this.mARParticleFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.voiceTextFilter != null) {
      this.voiceTextFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fastFaceStickerFilter != null) {
      this.fastFaceStickerFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fastBodyStickerFilter != null) {
      this.fastBodyStickerFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mBlurMaskFilter != null) {
      this.mBlurMaskFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    this.mFaceOffNoseOcclusionFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    VideoFilterBase localVideoFilterBase;
    if (this.mMaskStickerFilterList != null)
    {
      localIterator = this.mMaskStickerFilterList.iterator();
      while (localIterator.hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof FastMaskFilter)) {
          ((FastMaskFilter)localVideoFilterBase).updateVideoSize(paramInt1, paramInt2, paramDouble);
        }
      }
    }
    if (this.mMaskStickerFilterList != null)
    {
      localIterator = this.mMaskStickerFilterList.iterator();
      while (localIterator.hasNext())
      {
        localVideoFilterBase = (VideoFilterBase)localIterator.next();
        if ((localVideoFilterBase instanceof DynamicMaskFilter)) {
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
    if (this.mZoomFilter != null) {}
    for (Frame localFrame = this.mZoomFilter.RenderProcess(paramFrame);; localFrame = paramFrame)
    {
      if (localFrame != paramFrame) {
        paramFrame.unlock();
      }
      return localFrame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterList
 * JD-Core Version:    0.7.0.1
 */