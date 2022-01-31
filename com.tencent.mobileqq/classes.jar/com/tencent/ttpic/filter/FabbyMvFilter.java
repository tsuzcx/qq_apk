package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.factory.ShakaFilterFactory;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FrameAlphaFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.MaskMergeFilter;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.MaskTransformFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.model.Rect;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFrameUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FabbyMvFilter
{
  private float alphaValue = 1.0F;
  public BaseFilter bgEffectFilter;
  public RenderItem bgRenderItem;
  public BaseFilter cameraEffectFilter;
  public RenderItem coverRenderItem;
  private FastRenderFilter fastRenderFilter = new FastRenderFilter();
  public RenderItem fgRenderItem;
  public FrameAlphaFilter frameAlphaFilter = new FrameAlphaFilter();
  private GridEffectFilter gridEffectFilter = new GridEffectFilter();
  private Frame mAlphaFrame = new Frame();
  private Frame mBgFilterFrame = new Frame();
  private CanvasFilters mCanvasFilters = new CanvasFilters();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] mCopyFrame = new Frame[2];
  private Frame mDoodlerMaskFrame;
  private int mDoodlerMaskMergeType = 1;
  private int mDoodlerMaskRenderId = -1;
  public BaseFilter mEffectFilter;
  private Frame mFgFilterFrame = new Frame();
  private Frame mFilterFrame = new Frame();
  private Frame mGridDoodlerMaskFrame = new Frame();
  private Frame mGridFrame = new Frame();
  private Frame mLastRenderFrame;
  private BaseFilter mMaskFilter = new BaseFilter(BaseFilter.nativeDecrypt("mee179x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963604837x1868982638x1931505010x1819307361x1144156773x1886284064x1833530485x1415931745x1970567269x171664754x1768912394x1634541668x690515561x175835680x538976288x1180658791x1130848626x1919904879x1948269856x1970567269x1144153458x1852385312x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x687370x"));
  private MaskMergeFilter mMaskMergeFilter = new MaskMergeFilter();
  private MaskTransformFilter mMaskTransformFilter = new MaskTransformFilter();
  private Frame mMergeMaskFrame = new Frame();
  private Frame mMotionBlurFrame = new Frame();
  private Frame mRotateScaleFrame = new Frame();
  public ShakaFilterBase mShakaFilter;
  private Frame mShakaFrame = new Frame();
  private ShakaMotionBlurFilter motionBlurFilter = new ShakaMotionBlurFilter();
  public FabbyMvPart mvPart;
  private float progress;
  private RotateScaleFilter rotateScaleFilter = new RotateScaleFilter();
  private long startTimeStamp = -1L;
  
  private boolean isRenderReady()
  {
    boolean bool3 = true;
    boolean bool2;
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      if (((StaticStickerFilter)this.bgRenderItem.filter).isRenderReady()) {
        bool2 = true;
      }
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (this.coverRenderItem != null)
      {
        bool1 = bool2;
        if (this.coverRenderItem.filter != null)
        {
          if ((!bool2) || (!((StaticStickerFilter)this.coverRenderItem.filter).isRenderReady())) {
            break label132;
          }
          bool1 = true;
        }
      }
      label80:
      bool2 = bool1;
      if (this.fgRenderItem != null)
      {
        bool2 = bool1;
        if (this.fgRenderItem.filter != null) {
          if ((!bool1) || (!((StaticStickerFilter)this.fgRenderItem.filter).isRenderReady())) {
            break label137;
          }
        }
      }
      label132:
      label137:
      for (bool1 = bool3;; bool1 = false)
      {
        bool2 = bool1;
        return bool2;
        bool2 = false;
        break;
        bool1 = false;
        break label80;
      }
      bool2 = true;
    }
  }
  
  private Frame mergeDoodlerMaskFrame(Frame paramFrame1, Frame paramFrame2, int paramInt)
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
            this.mMaskMergeFilter.setMergeType(paramInt);
            this.mMaskMergeFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.mMergeMaskFrame);
            localFrame = this.mMergeMaskFrame;
          }
        }
      }
    }
    return localFrame;
  }
  
  private void mergeFrame(Frame paramFrame1, Frame paramFrame2)
  {
    paramFrame1.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    GlUtil.setBlendMode(true);
    this.mMaskFilter.OnDrawFrameGLSL();
    this.mMaskFilter.renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
    GlUtil.setBlendMode(false);
  }
  
  private boolean needMotionBlur(float paramFloat)
  {
    return Float.compare(paramFloat, 0.0F) != 0;
  }
  
  private boolean needTransform(double paramDouble1, double paramDouble2, double paramDouble3, PointF paramPointF1, PointF paramPointF2)
  {
    return (Double.compare(paramDouble1, 1.0D) != 0) || (paramDouble2 % 360.0D != 0.0D) || (Double.compare(paramDouble3, 1.0D) != 0) || (Float.compare(paramPointF1.x, 0.0F) != 0) || (Float.compare(paramPointF1.y, 0.0F) != 0) || (Float.compare(paramPointF2.x, 0.0F) != 0) || (Float.compare(paramPointF2.y, 0.0F) != 0);
  }
  
  private Frame renderForStaticFilters(Frame paramFrame, StaticStickerFilter paramStaticStickerFilter)
  {
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    if ((paramStaticStickerFilter == null) || (!paramStaticStickerFilter.isRenderReady())) {
      return paramFrame;
    }
    paramStaticStickerFilter.updateVideoSize(paramFrame.width, paramFrame.height, 0.0D);
    Frame localFrame1;
    if (paramFrame.getTextureId() == this.mCopyFrame[0].getTextureId())
    {
      localFrame1 = this.mCopyFrame[1];
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      GlUtil.setBlendMode(true);
      if (VideoFilterUtil.canUseBlendMode(paramStaticStickerFilter)) {
        break label215;
      }
      if (!VideoFilterUtil.needCopy(paramStaticStickerFilter)) {
        break label252;
      }
    }
    label215:
    label252:
    for (Frame localFrame2 = FrameUtil.renderProcessBySwitchFbo(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, this.mCopyFilter, paramFrame, localFrame1);; localFrame2 = paramFrame)
    {
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
      paramFrame = VideoFrameUtil.renderProcessBySwitchFbo(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, paramStaticStickerFilter, paramFrame, localFrame1);
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
      for (;;)
      {
        GlUtil.setBlendMode(false);
        return paramFrame;
        localFrame1 = this.mCopyFrame[0];
        break;
        BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
        paramStaticStickerFilter.OnDrawFrameGLSL();
        paramStaticStickerFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
      }
    }
  }
  
  private Frame renderForStaticRenderItems(Frame paramFrame, RenderItem paramRenderItem)
  {
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    if (paramRenderItem == null) {}
    StaticStickerFilter localStaticStickerFilter;
    do
    {
      return paramFrame;
      localStaticStickerFilter = (StaticStickerFilter)paramRenderItem.filter;
    } while ((localStaticStickerFilter == null) || (!localStaticStickerFilter.isRenderReady()));
    localStaticStickerFilter.updateVideoSize(paramFrame.width, paramFrame.height, 0.0D);
    if (paramFrame.getTextureId() == this.mCopyFrame[0].getTextureId())
    {
      paramRenderItem = this.mCopyFrame[1];
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      GlUtil.setBlendMode(true);
      if (VideoFilterUtil.canUseBlendMode(localStaticStickerFilter)) {
        break label232;
      }
      if (!VideoFilterUtil.needCopy(localStaticStickerFilter)) {
        break label271;
      }
    }
    label271:
    for (Frame localFrame = FrameUtil.renderProcessBySwitchFbo(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, this.mCopyFilter, paramFrame, paramRenderItem);; localFrame = paramFrame)
    {
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + localStaticStickerFilter.getClass().getName());
      paramFrame = VideoFrameUtil.renderProcessBySwitchFbo(localFrame.getTextureId(), localFrame.width, localFrame.height, localStaticStickerFilter, paramFrame, paramRenderItem);
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + localStaticStickerFilter.getClass().getName());
      for (;;)
      {
        GlUtil.setBlendMode(false);
        return paramFrame;
        paramRenderItem = this.mCopyFrame[0];
        break;
        label232:
        BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
        localStaticStickerFilter.OnDrawFrameGLSL();
        localStaticStickerFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
      }
    }
  }
  
  private Frame updateAndRenderCameraFrame(Frame paramFrame, float paramFloat)
  {
    return updateAndRenderCameraFrame(paramFrame, paramFloat, 0.0F);
  }
  
  private Frame updateAndRenderCameraFrame(Frame paramFrame, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = updateAndRenderShakaEffect(paramFrame, paramFloat1);
    double d2 = this.mvPart.getScale(paramFloat1);
    double d1;
    double d3;
    PointF localPointF1;
    PointF localPointF2;
    double d4;
    if (paramFloat2 == 0.0F)
    {
      d1 = this.mvPart.getDegree(paramFloat1);
      d3 = this.mvPart.getAlpha(paramFloat1);
      boolean bool1 = this.mvPart.isUseScaleWidthX(paramFloat1);
      boolean bool2 = this.mvPart.isUseScaleHeightY(paramFloat1);
      localPointF1 = this.mvPart.getAnchor(paramFloat1, bool1, bool2);
      localPointF2 = this.mvPart.getTranslate(paramFloat1, bool1, bool2);
      d4 = this.mvPart.getBlurSize(paramFloat1);
      double d5 = this.mvPart.getBlurAngle(paramFloat1);
      this.rotateScaleFilter.updateParams((float)d2, (float)(3.141592653589793D * d1 / 180.0D), (float)d3, localPointF1, localPointF2, new PointF(((Frame)localObject2).width, ((Frame)localObject2).height));
      this.motionBlurFilter.updateParams((float)d4, (float)d5, ((Frame)localObject2).width, ((Frame)localObject2).height);
      if ((this.frameAlphaFilter == null) || (this.alphaValue >= 1.0F)) {
        break label447;
      }
      this.frameAlphaFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, this.mAlphaFrame);
      localObject2 = this.mAlphaFrame;
    }
    label447:
    for (;;)
    {
      Object localObject1 = localObject2;
      if (needTransform(d2, d1, d3, localPointF1, localPointF2))
      {
        FrameUtil.clearFrame(this.mRotateScaleFrame, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
        this.rotateScaleFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, this.mRotateScaleFrame);
        localObject1 = this.mRotateScaleFrame;
      }
      localObject2 = localObject1;
      if (needMotionBlur((float)d4))
      {
        FrameUtil.clearFrame(this.mMotionBlurFrame, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject1).width, ((Frame)localObject1).height);
        this.motionBlurFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.mMotionBlurFrame);
        localObject2 = FrameUtil.getLastRenderFrame(this.mMotionBlurFrame);
      }
      localObject1 = localObject2;
      if (this.cameraEffectFilter != null) {
        localObject1 = updateAndRenderFilterEffect((Frame)localObject2, this.cameraEffectFilter, this.mFgFilterFrame);
      }
      if (paramFrame != localObject1) {
        this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, paramFrame);
      }
      return paramFrame;
      d1 = paramFloat2;
      break;
    }
  }
  
  private Frame updateAndRenderFilterEffect(Frame paramFrame, float paramFloat)
  {
    if (this.mvPart.getFilterParam(paramFloat) != 0) {}
    for (int i = 1; (this.mEffectFilter == null) || (i == 0); i = 0) {
      return paramFrame;
    }
    this.mEffectFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  private Frame updateAndRenderFilterEffect(Frame paramFrame1, BaseFilter paramBaseFilter, Frame paramFrame2)
  {
    if (paramBaseFilter == null) {
      return paramFrame1;
    }
    paramBaseFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
    return FrameUtil.getLastRenderFrame(paramFrame2);
  }
  
  private Frame updateAndRenderGrid(Frame paramFrame1, Frame paramFrame2, float paramFloat)
  {
    this.gridEffectFilter.setGridType(this.mvPart.getGridType(paramFloat));
    paramFrame1.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    GlUtil.setBlendMode(true);
    this.gridEffectFilter.OnDrawFrameGLSL();
    this.gridEffectFilter.renderTexture(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height);
    GlUtil.setBlendMode(false);
    return paramFrame1;
  }
  
  private Frame updateAndRenderShakaEffect(Frame paramFrame, float paramFloat)
  {
    if (this.mShakaFilter == null) {
      return paramFrame;
    }
    Map localMap = this.mvPart.getShakaValueMap(paramFloat);
    this.mShakaFilter.setParameters(localMap);
    FrameUtil.clearFrame(this.mShakaFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
    this.mShakaFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mShakaFrame);
    return this.mShakaFrame;
  }
  
  public void ApplyGLSLFilter()
  {
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).ApplyGLSLFilter();
    }
    if (this.bgEffectFilter != null) {
      this.bgEffectFilter.applyFilterChain(false, 0.0F, 0.0F);
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).ApplyGLSLFilter();
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).ApplyGLSLFilter();
    }
    if (this.cameraEffectFilter != null) {
      this.cameraEffectFilter.applyFilterChain(false, 0.0F, 0.0F);
    }
    this.mCopyFilter.apply();
    this.mCanvasFilters.ApplyGLSLFilter();
    this.gridEffectFilter.apply();
    this.rotateScaleFilter.ApplyGLSLFilter();
    this.mMaskFilter.apply();
    this.frameAlphaFilter.ApplyGLSLFilter();
    if (this.mMaskTransformFilter != null) {
      this.mMaskTransformFilter.ApplyGLSLFilter();
    }
    if (this.mMaskMergeFilter != null) {
      this.mMaskMergeFilter.apply();
    }
    if (this.mvPart.getShakaEffectItem() != null)
    {
      this.mShakaFilter = ShakaFilterFactory.create(this.mvPart.getShakaEffectItem().getFilterType());
      if (this.mShakaFilter != null) {
        this.mShakaFilter.ApplyGLSLFilter();
      }
    }
    if (this.mShakaFilter != null) {
      this.mShakaFilter.ApplyGLSLFilter();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.applyFilterChain(false, 0.0F, 0.0F);
    }
    int i = 0;
    while (i < this.mCopyFrame.length)
    {
      this.mCopyFrame[i] = new Frame();
      i += 1;
    }
    this.motionBlurFilter.applyFilterChain(false, 0.0F, 0.0F);
    this.fastRenderFilter.applyGLSLFilter();
  }
  
  public void clear()
  {
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).clearGLSLSelf();
    }
    if (this.bgEffectFilter != null) {
      this.bgEffectFilter.clearGLSLSelf();
    }
    if (this.frameAlphaFilter != null) {
      this.frameAlphaFilter.clearGLSLSelf();
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).clearGLSLSelf();
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).clearGLSLSelf();
    }
    if (this.cameraEffectFilter != null) {
      this.cameraEffectFilter.clearGLSLSelf();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.clearGLSLSelf();
    }
    if (this.gridEffectFilter != null) {
      this.gridEffectFilter.clearGLSLSelf();
    }
    if (this.rotateScaleFilter != null) {
      this.rotateScaleFilter.clearGLSLSelf();
    }
    if (this.mMaskFilter != null) {
      this.mMaskFilter.clearGLSLSelf();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.clearGLSLSelf();
    }
    if (this.mCanvasFilters != null) {
      this.mCanvasFilters.clearGLSLSelf();
    }
    if (this.motionBlurFilter != null) {
      this.motionBlurFilter.ClearGLSL();
    }
    Frame[] arrayOfFrame = this.mCopyFrame;
    int j = arrayOfFrame.length;
    int i = 0;
    while (i < j)
    {
      Frame localFrame = arrayOfFrame[i];
      if (localFrame != null) {
        localFrame.clear();
      }
      i += 1;
    }
    this.mShakaFrame.clear();
    this.mMotionBlurFrame.clear();
    this.mRotateScaleFrame.clear();
    this.mFilterFrame.clear();
    this.mFgFilterFrame.clear();
    this.mBgFilterFrame.clear();
    this.mAlphaFrame.clear();
    if (this.mLastRenderFrame != null) {
      this.mLastRenderFrame.clear();
    }
    if (this.fastRenderFilter != null) {
      this.fastRenderFilter.clearGLSLSelf();
    }
    if (this.mGridFrame != null) {
      this.mGridFrame.clear();
    }
    if (this.mMaskTransformFilter != null) {
      this.mMaskTransformFilter.clearGLSLSelf();
    }
    if (this.mMaskMergeFilter != null) {
      this.mMaskMergeFilter.clearGLSLSelf();
    }
    this.mMergeMaskFrame.clear();
  }
  
  public Map<Integer, PointF> getGridScaleMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.mvPart.getGridType(this.progress) == 6)
    {
      GridSettingModel localGridSettingModel = this.mvPart.getGridSetting(this.progress);
      if (localGridSettingModel != null)
      {
        Iterator localIterator = localGridSettingModel.canvasRectList.iterator();
        while (localIterator.hasNext())
        {
          GridModel localGridModel = (GridModel)localIterator.next();
          float f = Math.min(Math.max(localGridModel.canvasRect.width / localGridSettingModel.canvasRect.width, localGridModel.canvasRect.height / localGridSettingModel.canvasRect.height), 1.0F);
          PointF localPointF;
          if (localHashMap.get(Integer.valueOf(localGridModel.renderId)) != null)
          {
            localPointF = (PointF)localHashMap.get(Integer.valueOf(localGridModel.renderId));
            if ((localPointF.x < f) || (localPointF.y < f))
            {
              localPointF.x = f;
              localPointF.y = f;
              localHashMap.put(Integer.valueOf(localGridModel.renderId), localPointF);
            }
          }
          else
          {
            localPointF = new PointF(f, f);
            localHashMap.put(Integer.valueOf(localGridModel.renderId), localPointF);
          }
        }
      }
    }
    else
    {
      localHashMap.put(Integer.valueOf(0), new PointF(1.0F, 1.0F));
    }
    return localHashMap;
  }
  
  public Frame getLastRenderFrame()
  {
    return this.mLastRenderFrame;
  }
  
  public long getTimestamp()
  {
    return this.startTimeStamp;
  }
  
  public Frame renderBgFilter(Frame paramFrame)
  {
    Frame localFrame = renderForStaticRenderItems(paramFrame, this.bgRenderItem);
    paramFrame = localFrame;
    if (this.bgEffectFilter != null) {
      paramFrame = updateAndRenderFilterEffect(localFrame, this.bgEffectFilter, this.mBgFilterFrame);
    }
    return paramFrame;
  }
  
  public Frame renderCoverFilter(Frame paramFrame)
  {
    return renderForStaticRenderItems(paramFrame, this.coverRenderItem);
  }
  
  public Frame renderFgFilter(Frame paramFrame)
  {
    return renderForStaticRenderItems(paramFrame, this.fgRenderItem);
  }
  
  public void reset()
  {
    this.startTimeStamp = -1L;
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).resetFabbyProgress();
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).resetFabbyProgress();
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).resetFabbyProgress();
    }
  }
  
  public void setDoodlerMaskFrame(Frame paramFrame)
  {
    this.mDoodlerMaskFrame = paramFrame;
  }
  
  public void setDoodlerMaskMergeType(int paramInt)
  {
    this.mDoodlerMaskMergeType = paramInt;
  }
  
  public void setDoodlerMaskRenderId(int paramInt)
  {
    this.mDoodlerMaskRenderId = paramInt;
  }
  
  public void setRenderMode(int paramInt)
  {
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.bgRenderItem.filter, paramInt);
    }
    if (this.bgEffectFilter != null) {
      VideoFilterUtil.setRenderMode(this.bgEffectFilter, paramInt);
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.fgRenderItem.filter, paramInt);
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.coverRenderItem.filter, paramInt);
    }
    if (this.cameraEffectFilter != null) {
      VideoFilterUtil.setRenderMode(this.cameraEffectFilter, paramInt);
    }
    if (this.mEffectFilter != null) {
      VideoFilterUtil.setRenderMode(this.mEffectFilter, paramInt);
    }
    VideoFilterUtil.setRenderMode(this.gridEffectFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.rotateScaleFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.frameAlphaFilter, paramInt);
    this.mCanvasFilters.setRenderMode(paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame, Map<Integer, Frame> paramMap, long paramLong)
  {
    if (!isRenderReady()) {
      return paramFrame;
    }
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.mvPart.getGridType(this.progress) == 6)
    {
      i = this.mvPart.getGridOrder(this.progress);
      BenchUtil.benchStart("[showPreview][FABBY] bg");
      localObject1 = renderBgFilter(paramFrame);
      BenchUtil.benchEnd("[showPreview][FABBY] bg");
      this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.mGridFrame);
      if (i == 0)
      {
        BenchUtil.benchStart("[showPreview][FABBY] grid");
        localObject1 = new ArrayList();
        localObject2 = this.mvPart.getGridSetting(this.progress);
        if (localObject2 != null)
        {
          localObject3 = ((GridSettingModel)localObject2).canvasRectList.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (GridModel)((Iterator)localObject3).next();
              if (paramMap.containsKey(Integer.valueOf(((GridModel)localObject4).renderId)))
              {
                paramFrame = (Frame)paramMap.get(Integer.valueOf(((GridModel)localObject4).renderId));
                if (((GridModel)localObject4).alpha < 1.0D) {
                  updateParamAlpha(((GridModel)localObject4).alpha);
                }
                paramFrame = updateAndRenderCameraFrame(paramFrame, this.progress);
                if ((this.mDoodlerMaskRenderId != ((GridModel)localObject4).renderId) || (this.mDoodlerMaskFrame == null)) {
                  break label1089;
                }
                this.mGridDoodlerMaskFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
                if (this.mDoodlerMaskMergeType == 1)
                {
                  FrameUtil.clearFrame(this.mGridDoodlerMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mGridDoodlerMaskFrame.width, this.mGridDoodlerMaskFrame.height);
                  label292:
                  this.mMaskTransformFilter.RenderProcess(this.mDoodlerMaskFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mGridDoodlerMaskFrame);
                  Frame localFrame = this.mGridDoodlerMaskFrame;
                  if (this.mDoodlerMaskMergeType != 1) {
                    break label454;
                  }
                  i = 2;
                  label337:
                  paramFrame = mergeDoodlerMaskFrame(paramFrame, localFrame, i);
                }
              }
            }
          }
        }
      }
    }
    label1086:
    label1089:
    for (;;)
    {
      paramFrame = this.mCanvasFilters.drawOnFrame((GridModel)localObject4, paramFrame, ((GridSettingModel)localObject2).canvasRect.width, ((GridSettingModel)localObject2).canvasRect.height);
      if (paramFrame == null) {
        break;
      }
      ((List)localObject1).add(paramFrame);
      break;
      if (this.mDoodlerMaskMergeType == 2)
      {
        FrameUtil.clearFrame(this.mGridDoodlerMaskFrame, 1.0F, 1.0F, 1.0F, 1.0F, this.mGridDoodlerMaskFrame.width, this.mGridDoodlerMaskFrame.height);
        break label292;
      }
      FrameUtil.clearFrame(this.mGridDoodlerMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mGridDoodlerMaskFrame.width, this.mGridDoodlerMaskFrame.height);
      break label292;
      label454:
      i = 1;
      break label337;
      GlUtil.setBlendMode(true);
      this.fastRenderFilter.render((List)localObject1, this.mGridFrame);
      GlUtil.setBlendMode(false);
      paramFrame = this.mGridFrame;
      BenchUtil.benchEnd("[showPreview][FABBY] grid");
      for (;;)
      {
        BenchUtil.benchStart("[showPreview][FABBY] cover");
        paramFrame = renderCoverFilter(paramFrame);
        BenchUtil.benchEnd("[showPreview][FABBY] cover");
        BenchUtil.benchStart("[showPreview][FABBY] fg");
        paramFrame = renderFgFilter(paramFrame);
        BenchUtil.benchEnd("[showPreview][FABBY] fg");
        BenchUtil.benchStart("[showPreview][FABBY] effect");
        paramFrame = updateAndRenderFilterEffect(paramFrame, this.progress);
        BenchUtil.benchEnd("[showPreview][FABBY] effect");
        this.mLastRenderFrame = paramFrame;
        return paramFrame;
        if (i == 1)
        {
          BenchUtil.benchStart("[showPreview][FABBY] grid");
          paramFrame = new ArrayList();
          localObject1 = this.mvPart.getGridSetting(this.progress);
          if (localObject1 != null)
          {
            localObject2 = ((GridSettingModel)localObject1).canvasRectList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (GridModel)((Iterator)localObject2).next();
              if (paramMap.containsKey(Integer.valueOf(((GridModel)localObject3).renderId)))
              {
                localObject4 = (Frame)paramMap.get(Integer.valueOf(((GridModel)localObject3).renderId));
                localObject3 = this.mCanvasFilters.drawOnFrame((GridModel)localObject3, (Frame)localObject4, ((GridSettingModel)localObject1).canvasRect.width, ((GridSettingModel)localObject1).canvasRect.height);
                if (localObject3 != null) {
                  paramFrame.add(localObject3);
                }
              }
            }
          }
          GlUtil.setBlendMode(true);
          this.fastRenderFilter.render(paramFrame, this.mGridFrame);
          GlUtil.setBlendMode(false);
          paramFrame = updateAndRenderCameraFrame(this.mGridFrame, this.progress);
          BenchUtil.benchEnd("[showPreview][FABBY] grid");
        }
      }
      paramMap = (Frame)paramMap.values().iterator().next();
      BenchUtil.benchStart("[showPreview][FABBY] bg");
      paramFrame = renderBgFilter(paramFrame);
      BenchUtil.benchEnd("[showPreview][FABBY] bg");
      i = this.mvPart.getGridMode(this.progress);
      int j = this.mvPart.getGridOrder(this.progress);
      if (i == 0)
      {
        BenchUtil.benchStart("[showPreview][FABBY] merge");
        if (j == 0)
        {
          mergeFrame(paramFrame, updateAndRenderCameraFrame(paramMap, this.progress));
          label853:
          BenchUtil.benchEnd("[showPreview][FABBY] merge");
        }
      }
      for (;;)
      {
        label860:
        BenchUtil.benchStart("[showPreview][FABBY] cover");
        paramFrame = renderCoverFilter(paramFrame);
        BenchUtil.benchEnd("[showPreview][FABBY] cover");
        BenchUtil.benchStart("[showPreview][FABBY] fg");
        paramFrame = renderFgFilter(paramFrame);
        BenchUtil.benchEnd("[showPreview][FABBY] fg");
        if (i == 0)
        {
          BenchUtil.benchStart("[showPreview][FABBY] grid");
          FrameUtil.clearFrame(this.mGridFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
          paramMap = updateAndRenderGrid(this.mGridFrame, paramFrame, this.progress);
          BenchUtil.benchEnd("[showPreview][FABBY] grid");
          paramFrame = paramMap;
          if (j == 1) {
            paramFrame = updateAndRenderCameraFrame(paramMap, this.progress);
          }
        }
        for (;;)
        {
          paramFrame = updateAndRenderFilterEffect(paramFrame, this.progress);
          break;
          if (j != 1) {
            break label853;
          }
          mergeFrame(paramFrame, paramMap);
          break label853;
          this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mGridFrame);
          if (j == 0)
          {
            paramFrame = updateAndRenderCameraFrame(paramMap, this.progress);
            paramFrame = updateAndRenderGrid(this.mGridFrame, paramFrame, this.progress);
            break label860;
          }
          if (j != 1) {
            break label1086;
          }
          paramFrame = updateAndRenderCameraFrame(updateAndRenderGrid(this.mGridFrame, paramMap, this.progress), this.progress);
          break label860;
        }
      }
    }
  }
  
  public void updateParamAlpha(float paramFloat)
  {
    this.alphaValue = paramFloat;
    this.frameAlphaFilter.updateAlpha((float)Math.sqrt(paramFloat));
  }
  
  public void updateTextureParam(long paramLong)
  {
    if (this.startTimeStamp < 0L) {
      this.startTimeStamp = paramLong;
    }
    this.progress = ((float)(paramLong - this.startTimeStamp) / (float)this.mvPart.duration);
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).updateFabbyProgress(paramLong);
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).updateFabbyProgress(paramLong);
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).updateFabbyProgress(paramLong);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.bgRenderItem != null) && (this.bgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if ((this.fgRenderItem != null) && (this.fgRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if ((this.coverRenderItem != null) && (this.coverRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvFilter
 * JD-Core Version:    0.7.0.1
 */