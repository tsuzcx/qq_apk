package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class VideoBlendFilterFormal
  extends BaseFilter
{
  private static final String FRAGREMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/BlendFragmentShader.dat");
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/BlendVertexShader.dat");
  private int blendmode;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame = new Frame();
  
  public VideoBlendFilterFormal()
  {
    super(VERTEX_SHADER, FRAGREMENT_SHADER);
    initParams();
  }
  
  private void setBlendMode(int paramInt)
  {
    this.blendmode = paramInt;
    addParam(new Param.IntParam("blendmode", paramInt));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clearSelf();
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("blendmode", 0));
    addParam(new Param.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public boolean needRender()
  {
    return this.blendmode != 0;
  }
  
  public Frame renderWatermark(int paramInt1, int paramInt2, int paramInt3)
  {
    VideoFilterUtil.setBlendMode(true);
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mCopyFrame);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    VideoFilterUtil.setBlendMode(false);
    return this.mCopyFrame;
  }
  
  public void setWartermarkPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setPositions(AlgoUtils.calPositions(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramInt5, paramInt6));
  }
  
  public void setWatermarkBitmap(Bitmap paramBitmap)
  {
    if (VideoBitmapUtil.isLegal(paramBitmap))
    {
      paramBitmap = new Param.TextureBitmapParam("inputImageTexture2", paramBitmap, 33986, true);
      paramBitmap.initialParams(getmProgramIds());
      addParam(paramBitmap);
      setBlendMode(1);
      return;
    }
    setBlendMode(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoBlendFilterFormal
 * JD-Core Version:    0.7.0.1
 */