package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.util.List;

public class WatermarkFilter
{
  private static String TAG = WatermarkFilter.class.getSimpleName();
  private boolean inited = false;
  private NormalVideoFilter innerWatermarkFilter;
  
  public WatermarkFilter(VideoMaterial paramVideoMaterial)
  {
    createWatermarkFilters(paramVideoMaterial);
  }
  
  private void createWatermarkFilters(VideoMaterial paramVideoMaterial)
  {
    List localList = paramVideoMaterial.getItemList();
    if ((localList != null) && (!localList.isEmpty()) && (((StickerItem)localList.get(0)).stickerType == VideoFilterFactory.STICKER_TYPE.WATERMARK.type)) {
      this.innerWatermarkFilter = VideoFilterFactory.createFilter((StickerItem)localList.get(0), paramVideoMaterial.getDataPath());
    }
  }
  
  private void render(Frame paramFrame)
  {
    if (this.innerWatermarkFilter == null) {
      return;
    }
    GlUtil.setBlendMode(true);
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    this.innerWatermarkFilter.OnDrawFrameGLSL();
    this.innerWatermarkFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    GlUtil.setBlendMode(false);
  }
  
  public void clear()
  {
    if (this.innerWatermarkFilter != null)
    {
      this.innerWatermarkFilter.clearGLSLSelf();
      this.innerWatermarkFilter = null;
    }
    this.inited = false;
  }
  
  public void init()
  {
    if (this.innerWatermarkFilter == null) {
      return;
    }
    this.innerWatermarkFilter.ApplyGLSLFilter();
    this.innerWatermarkFilter.addParam(new UniformParam.FloatParam("alpha", 0.85F));
    if ((this.innerWatermarkFilter instanceof WatermarkStaticFilter)) {
      ((WatermarkStaticFilter)this.innerWatermarkFilter).setPostScale(0.5F);
    }
    this.inited = true;
  }
  
  public Frame render(Frame paramFrame, int paramInt)
  {
    if (!this.inited) {
      init();
    }
    if (this.innerWatermarkFilter == null) {
      return paramFrame;
    }
    render(paramFrame);
    return paramFrame;
  }
  
  public void setRatio(float paramFloat)
  {
    if ((this.innerWatermarkFilter != null) && ((this.innerWatermarkFilter instanceof WatermarkStaticFilter))) {
      ((WatermarkStaticFilter)this.innerWatermarkFilter).setRatio(paramFloat);
    }
  }
  
  public void setWMPositionCallback(WatermarkFilter.WMPositionCallback paramWMPositionCallback)
  {
    if ((this.innerWatermarkFilter != null) && ((this.innerWatermarkFilter instanceof WatermarkStaticFilter))) {
      ((WatermarkStaticFilter)this.innerWatermarkFilter).setWMPositionCallback(paramWMPositionCallback);
    }
  }
  
  public void update(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    if (!this.inited) {
      init();
    }
    if (this.innerWatermarkFilter == null) {
      return;
    }
    paramPTFaceAttr = new PTDetectInfo.Builder().faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).timestamp(paramPTFaceAttr.getTimeStamp()).faceDetector(paramPTFaceAttr.getFaceDetector()).phoneAngle(paramInt3).build();
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      this.innerWatermarkFilter.updateVideoSize(paramInt2, paramInt1, paramFloat);
    }
    for (;;)
    {
      this.innerWatermarkFilter.updatePreview(paramPTFaceAttr);
      return;
      this.innerWatermarkFilter.updateVideoSize(paramInt1, paramInt2, paramFloat);
    }
  }
  
  public void updateMaterial(VideoMaterial paramVideoMaterial)
  {
    clear();
    createWatermarkFilters(paramVideoMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.WatermarkFilter
 * JD-Core Version:    0.7.0.1
 */