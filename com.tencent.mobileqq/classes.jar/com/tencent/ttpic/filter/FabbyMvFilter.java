package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.factory.ShakaFilterFactory;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FrameAlphaFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.filter.maskstickerfilter.MaskMergeFilter;
import com.tencent.ttpic.openapi.filter.maskstickerfilter.MaskTransformFilter;
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
    RenderItem localRenderItem = this.bgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null) && (!((StaticStickerFilter)this.bgRenderItem.filter).isRenderReady())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    localRenderItem = this.coverRenderItem;
    boolean bool1 = bool2;
    if (localRenderItem != null)
    {
      bool1 = bool2;
      if (localRenderItem.filter != null) {
        if ((bool2) && (((StaticStickerFilter)this.coverRenderItem.filter).isRenderReady())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
    }
    localRenderItem = this.fgRenderItem;
    boolean bool2 = bool1;
    if (localRenderItem != null)
    {
      bool2 = bool1;
      if (localRenderItem.filter != null)
      {
        if ((bool1) && (((StaticStickerFilter)this.fgRenderItem.filter).isRenderReady())) {
          return true;
        }
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private Frame mergeDoodlerMaskFrame(Frame paramFrame1, Frame paramFrame2, int paramInt)
  {
    Frame localFrame1 = paramFrame1;
    MaskMergeFilter localMaskMergeFilter = this.mMaskMergeFilter;
    Frame localFrame2 = localFrame1;
    if (localMaskMergeFilter != null)
    {
      localFrame2 = localFrame1;
      if (paramFrame2 != null)
      {
        localFrame2 = localFrame1;
        if (localFrame1 != null)
        {
          localFrame2 = localFrame1;
          if (this.mMergeMaskFrame != null)
          {
            localMaskMergeFilter.updateTexture(paramFrame2.getTextureId());
            this.mMergeMaskFrame.bindFrame(-1, localFrame1.width, localFrame1.height, 0.0D);
            paramFrame2 = this.mMergeMaskFrame;
            FrameUtil.clearFrame(paramFrame2, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame2.width, this.mMergeMaskFrame.height);
            this.mMaskMergeFilter.setMergeType(paramInt);
            this.mMaskMergeFilter.RenderProcess(paramFrame1.getTextureId(), localFrame1.width, localFrame1.height, -1, 0.0D, this.mMergeMaskFrame);
            localFrame2 = this.mMergeMaskFrame;
          }
        }
      }
    }
    return localFrame2;
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
    Frame localFrame1 = paramFrame;
    if (paramStaticStickerFilter != null)
    {
      if (!paramStaticStickerFilter.isRenderReady()) {
        return paramFrame;
      }
      paramStaticStickerFilter.updateVideoSize(paramFrame.width, paramFrame.height, 0.0D);
      if (paramFrame.getTextureId() == this.mCopyFrame[0].getTextureId()) {
        localFrame1 = this.mCopyFrame[1];
      } else {
        localFrame1 = this.mCopyFrame[0];
      }
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      GlUtil.setBlendMode(true);
      if (!VideoFilterUtil.canUseBlendMode(paramStaticStickerFilter))
      {
        Frame localFrame2;
        if (VideoFilterUtil.needCopy(paramStaticStickerFilter)) {
          localFrame2 = FrameUtil.renderProcessBySwitchFbo(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, this.mCopyFilter, paramFrame, localFrame1);
        } else {
          localFrame2 = paramFrame;
        }
        paramFrame = VideoFrameUtil.renderProcessBySwitchFbo(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, paramStaticStickerFilter, paramFrame, localFrame1);
      }
      else
      {
        paramStaticStickerFilter.OnDrawFrameGLSL();
        paramStaticStickerFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      }
      GlUtil.setBlendMode(false);
      localFrame1 = paramFrame;
    }
    return localFrame1;
  }
  
  private Frame renderForStaticRenderItems(Frame paramFrame, RenderItem paramRenderItem)
  {
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    if (paramRenderItem == null) {
      return paramFrame;
    }
    StaticStickerFilter localStaticStickerFilter = (StaticStickerFilter)paramRenderItem.filter;
    paramRenderItem = paramFrame;
    if (localStaticStickerFilter != null)
    {
      if (!localStaticStickerFilter.isRenderReady()) {
        return paramFrame;
      }
      localStaticStickerFilter.updateVideoSize(paramFrame.width, paramFrame.height, 0.0D);
      if (paramFrame.getTextureId() == this.mCopyFrame[0].getTextureId()) {
        paramRenderItem = this.mCopyFrame[1];
      } else {
        paramRenderItem = this.mCopyFrame[0];
      }
      paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
      GlUtil.setBlendMode(true);
      if (!VideoFilterUtil.canUseBlendMode(localStaticStickerFilter))
      {
        Frame localFrame;
        if (VideoFilterUtil.needCopy(localStaticStickerFilter)) {
          localFrame = FrameUtil.renderProcessBySwitchFbo(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, this.mCopyFilter, paramFrame, paramRenderItem);
        } else {
          localFrame = paramFrame;
        }
        paramFrame = VideoFrameUtil.renderProcessBySwitchFbo(localFrame.getTextureId(), localFrame.width, localFrame.height, localStaticStickerFilter, paramFrame, paramRenderItem);
      }
      else
      {
        localStaticStickerFilter.OnDrawFrameGLSL();
        localStaticStickerFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      }
      GlUtil.setBlendMode(false);
      paramRenderItem = paramFrame;
    }
    return paramRenderItem;
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
    if (paramFloat2 == 0.0F) {
      d1 = this.mvPart.getDegree(paramFloat1);
    } else {
      d1 = paramFloat2;
    }
    double d3 = this.mvPart.getAlpha(paramFloat1);
    boolean bool1 = this.mvPart.isUseScaleWidthX(paramFloat1);
    boolean bool2 = this.mvPart.isUseScaleHeightY(paramFloat1);
    Object localObject3 = this.mvPart.getAnchor(paramFloat1, bool1, bool2);
    PointF localPointF = this.mvPart.getTranslate(paramFloat1, bool1, bool2);
    double d4 = this.mvPart.getBlurSize(paramFloat1);
    double d5 = this.mvPart.getBlurAngle(paramFloat1);
    this.rotateScaleFilter.updateParams((float)d2, (float)(3.141592653589793D * d1 / 180.0D), (float)d3, (PointF)localObject3, localPointF, new PointF(((Frame)localObject2).width, ((Frame)localObject2).height));
    Object localObject1 = this.motionBlurFilter;
    paramFloat1 = (float)d4;
    ((ShakaMotionBlurFilter)localObject1).updateParams(paramFloat1, (float)d5, ((Frame)localObject2).width, ((Frame)localObject2).height);
    FrameAlphaFilter localFrameAlphaFilter = this.frameAlphaFilter;
    localObject1 = localObject2;
    if (localFrameAlphaFilter != null)
    {
      localObject1 = localObject2;
      if (this.alphaValue < 1.0F)
      {
        localFrameAlphaFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, this.mAlphaFrame);
        localObject1 = this.mAlphaFrame;
      }
    }
    localObject2 = localObject1;
    localObject1 = localObject2;
    if (needTransform(d2, d1, d3, (PointF)localObject3, localPointF))
    {
      FrameUtil.clearFrame(this.mRotateScaleFrame, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject2).width, ((Frame)localObject2).height);
      this.rotateScaleFilter.RenderProcess(((Frame)localObject2).getTextureId(), ((Frame)localObject2).width, ((Frame)localObject2).height, -1, 0.0D, this.mRotateScaleFrame);
      localObject1 = this.mRotateScaleFrame;
    }
    localObject2 = localObject1;
    if (needMotionBlur(paramFloat1))
    {
      FrameUtil.clearFrame(this.mMotionBlurFrame, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject1).width, ((Frame)localObject1).height);
      this.motionBlurFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.mMotionBlurFrame);
      localObject2 = FrameUtil.getLastRenderFrame(this.mMotionBlurFrame);
    }
    localObject3 = this.cameraEffectFilter;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = updateAndRenderFilterEffect((Frame)localObject2, (BaseFilter)localObject3, this.mFgFilterFrame);
    }
    if (paramFrame != localObject1) {
      this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, paramFrame);
    }
    return paramFrame;
  }
  
  private Frame updateAndRenderFilterEffect(Frame paramFrame, float paramFloat)
  {
    int i;
    if (this.mvPart.getFilterParam(paramFloat) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    BaseFilter localBaseFilter = this.mEffectFilter;
    Frame localFrame = paramFrame;
    if (localBaseFilter != null)
    {
      if (i == 0) {
        return paramFrame;
      }
      localBaseFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mFilterFrame);
      localFrame = FrameUtil.getLastRenderFrame(this.mFilterFrame);
    }
    return localFrame;
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
    localMap.put("progress", Float.valueOf(paramFloat));
    this.mShakaFilter.setParameters(localMap);
    FrameUtil.clearFrame(this.mShakaFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
    this.mShakaFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mShakaFrame);
    return this.mShakaFrame;
  }
  
  public void ApplyGLSLFilter()
  {
    Object localObject = this.bgRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).ApplyGLSLFilter();
    }
    localObject = this.bgEffectFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(false, 0.0F, 0.0F);
    }
    localObject = this.fgRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).ApplyGLSLFilter();
    }
    localObject = this.coverRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).ApplyGLSLFilter();
    }
    localObject = this.cameraEffectFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(false, 0.0F, 0.0F);
    }
    this.mCopyFilter.apply();
    this.mCanvasFilters.ApplyGLSLFilter();
    this.gridEffectFilter.apply();
    this.rotateScaleFilter.ApplyGLSLFilter();
    this.mMaskFilter.apply();
    this.frameAlphaFilter.ApplyGLSLFilter();
    localObject = this.mMaskTransformFilter;
    if (localObject != null) {
      ((MaskTransformFilter)localObject).ApplyGLSLFilter();
    }
    localObject = this.mMaskMergeFilter;
    if (localObject != null) {
      ((MaskMergeFilter)localObject).apply();
    }
    if (this.mvPart.getShakaEffectItem() != null)
    {
      this.mShakaFilter = ShakaFilterFactory.create(this.mvPart.getShakaEffectItem());
      localObject = this.mShakaFilter;
      if (localObject != null) {
        ((ShakaFilterBase)localObject).ApplyGLSLFilter();
      }
    }
    localObject = this.mShakaFilter;
    if (localObject != null) {
      ((ShakaFilterBase)localObject).ApplyGLSLFilter();
    }
    localObject = this.mEffectFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(false, 0.0F, 0.0F);
    }
    int i = 0;
    for (;;)
    {
      localObject = this.mCopyFrame;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new Frame();
      i += 1;
    }
    this.motionBlurFilter.applyFilterChain(false, 0.0F, 0.0F);
    this.fastRenderFilter.applyGLSLFilter();
  }
  
  public void clear()
  {
    Object localObject1 = this.bgRenderItem;
    if ((localObject1 != null) && (((RenderItem)localObject1).filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).clearGLSLSelf();
    }
    localObject1 = this.bgEffectFilter;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.frameAlphaFilter;
    if (localObject1 != null) {
      ((FrameAlphaFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.fgRenderItem;
    if ((localObject1 != null) && (((RenderItem)localObject1).filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).clearGLSLSelf();
    }
    localObject1 = this.coverRenderItem;
    if ((localObject1 != null) && (((RenderItem)localObject1).filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).clearGLSLSelf();
    }
    localObject1 = this.cameraEffectFilter;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mEffectFilter;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.gridEffectFilter;
    if (localObject1 != null) {
      ((GridEffectFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.rotateScaleFilter;
    if (localObject1 != null) {
      ((RotateScaleFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mMaskFilter;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mCopyFilter;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mCanvasFilters;
    if (localObject1 != null) {
      ((CanvasFilters)localObject1).clearGLSLSelf();
    }
    localObject1 = this.motionBlurFilter;
    if (localObject1 != null) {
      ((ShakaMotionBlurFilter)localObject1).clearGLSL();
    }
    localObject1 = this.mCopyFrame;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.clear();
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
    localObject1 = this.mLastRenderFrame;
    if (localObject1 != null) {
      ((Frame)localObject1).clear();
    }
    localObject1 = this.fastRenderFilter;
    if (localObject1 != null) {
      ((FastRenderFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mGridFrame;
    if (localObject1 != null) {
      ((Frame)localObject1).clear();
    }
    localObject1 = this.mMaskTransformFilter;
    if (localObject1 != null) {
      ((MaskTransformFilter)localObject1).clearGLSLSelf();
    }
    localObject1 = this.mMaskMergeFilter;
    if (localObject1 != null) {
      ((MaskMergeFilter)localObject1).clearGLSLSelf();
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
    BaseFilter localBaseFilter = this.bgEffectFilter;
    paramFrame = localFrame;
    if (localBaseFilter != null) {
      paramFrame = updateAndRenderFilterEffect(localFrame, localBaseFilter, this.mBgFilterFrame);
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
    RenderItem localRenderItem = this.bgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).resetFabbyProgress();
    }
    localRenderItem = this.fgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).resetFabbyProgress();
    }
    localRenderItem = this.coverRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
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
    Object localObject = this.bgRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.bgRenderItem.filter, paramInt);
    }
    localObject = this.bgEffectFilter;
    if (localObject != null) {
      VideoFilterUtil.setRenderMode((BaseFilter)localObject, paramInt);
    }
    localObject = this.fgRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.fgRenderItem.filter, paramInt);
    }
    localObject = this.coverRenderItem;
    if ((localObject != null) && (((RenderItem)localObject).filter != null)) {
      VideoFilterUtil.setRenderMode((StaticStickerFilter)this.coverRenderItem.filter, paramInt);
    }
    localObject = this.cameraEffectFilter;
    if (localObject != null) {
      VideoFilterUtil.setRenderMode((BaseFilter)localObject, paramInt);
    }
    localObject = this.mEffectFilter;
    if (localObject != null) {
      VideoFilterUtil.setRenderMode((BaseFilter)localObject, paramInt);
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
    int j;
    if (this.mvPart.getGridType(this.progress) == 6)
    {
      i = this.mvPart.getGridOrder(this.progress);
      localObject1 = renderBgFilter(paramFrame);
      this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.mGridFrame);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (i == 0)
      {
        localObject2 = new ArrayList();
        localObject3 = this.mvPart.getGridSetting(this.progress);
        if (localObject3 != null)
        {
          localObject4 = ((GridSettingModel)localObject3).canvasRectList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            GridModel localGridModel = (GridModel)((Iterator)localObject4).next();
            if (paramMap.containsKey(Integer.valueOf(localGridModel.renderId)))
            {
              paramFrame = (Frame)paramMap.get(Integer.valueOf(localGridModel.renderId));
              if (localGridModel.alpha < 1.0D) {
                updateParamAlpha(localGridModel.alpha);
              }
              localObject1 = updateAndRenderCameraFrame(paramFrame, this.progress);
              paramFrame = (Frame)localObject1;
              if (this.mDoodlerMaskRenderId == localGridModel.renderId)
              {
                paramFrame = (Frame)localObject1;
                if (this.mDoodlerMaskFrame != null)
                {
                  this.mGridDoodlerMaskFrame.bindFrame(-1, ((Frame)localObject1).width, ((Frame)localObject1).height, 0.0D);
                  j = this.mDoodlerMaskMergeType;
                  i = 2;
                  if (j == 1)
                  {
                    paramFrame = this.mGridDoodlerMaskFrame;
                    FrameUtil.clearFrame(paramFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, this.mGridDoodlerMaskFrame.height);
                  }
                  else if (j == 2)
                  {
                    paramFrame = this.mGridDoodlerMaskFrame;
                    FrameUtil.clearFrame(paramFrame, 1.0F, 1.0F, 1.0F, 1.0F, paramFrame.width, this.mGridDoodlerMaskFrame.height);
                  }
                  else
                  {
                    paramFrame = this.mGridDoodlerMaskFrame;
                    FrameUtil.clearFrame(paramFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, this.mGridDoodlerMaskFrame.height);
                  }
                  this.mMaskTransformFilter.RenderProcess(this.mDoodlerMaskFrame.getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.mGridDoodlerMaskFrame);
                  paramFrame = this.mGridDoodlerMaskFrame;
                  if (this.mDoodlerMaskMergeType != 1) {
                    i = 1;
                  }
                  paramFrame = mergeDoodlerMaskFrame((Frame)localObject1, paramFrame, i);
                }
              }
              paramFrame = this.mCanvasFilters.drawOnFrame(localGridModel, paramFrame, ((GridSettingModel)localObject3).canvasRect.width, ((GridSettingModel)localObject3).canvasRect.height);
              if (paramFrame != null) {
                ((List)localObject2).add(paramFrame);
              }
            }
          }
        }
        GlUtil.setBlendMode(true);
        this.fastRenderFilter.render((List)localObject2, this.mGridFrame);
        GlUtil.setBlendMode(false);
        paramFrame = this.mGridFrame;
      }
      else if (i == 1)
      {
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
      }
      paramFrame = updateAndRenderFilterEffect(renderFgFilter(renderCoverFilter(paramFrame)), this.progress);
    }
    else
    {
      localObject1 = (Frame)paramMap.values().iterator().next();
      paramMap = renderBgFilter(paramFrame);
      i = this.mvPart.getGridMode(this.progress);
      j = this.mvPart.getGridOrder(this.progress);
      if (i == 0)
      {
        if (j == 0)
        {
          mergeFrame(paramMap, updateAndRenderCameraFrame((Frame)localObject1, this.progress));
          paramFrame = paramMap;
        }
        else
        {
          paramFrame = paramMap;
          if (j == 1)
          {
            mergeFrame(paramMap, (Frame)localObject1);
            paramFrame = paramMap;
          }
        }
      }
      else
      {
        this.mCopyFilter.RenderProcess(paramMap.getTextureId(), paramMap.width, paramMap.height, -1, 0.0D, this.mGridFrame);
        if (j == 0)
        {
          paramFrame = updateAndRenderCameraFrame((Frame)localObject1, this.progress);
          paramFrame = updateAndRenderGrid(this.mGridFrame, paramFrame, this.progress);
        }
        else
        {
          paramFrame = paramMap;
          if (j == 1) {
            paramFrame = updateAndRenderCameraFrame(updateAndRenderGrid(this.mGridFrame, (Frame)localObject1, this.progress), this.progress);
          }
        }
      }
      paramMap = renderFgFilter(renderCoverFilter(paramFrame));
      paramFrame = paramMap;
      if (i == 0)
      {
        FrameUtil.clearFrame(this.mGridFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramMap.width, paramMap.height);
        paramMap = updateAndRenderGrid(this.mGridFrame, paramMap, this.progress);
        paramFrame = paramMap;
        if (j == 1) {
          paramFrame = updateAndRenderCameraFrame(paramMap, this.progress);
        }
      }
      paramFrame = updateAndRenderFilterEffect(paramFrame, this.progress);
    }
    this.mLastRenderFrame = paramFrame;
    return paramFrame;
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
    RenderItem localRenderItem = this.bgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).updateFabbyProgress(paramLong);
    }
    localRenderItem = this.coverRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).updateFabbyProgress(paramLong);
    }
    localRenderItem = this.fgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).updateFabbyProgress(paramLong);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    RenderItem localRenderItem = this.bgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.bgRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localRenderItem = this.fgRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.fgRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localRenderItem = this.coverRenderItem;
    if ((localRenderItem != null) && (localRenderItem.filter != null)) {
      ((StaticStickerFilter)this.coverRenderItem.filter).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvFilter
 * JD-Core Version:    0.7.0.1
 */