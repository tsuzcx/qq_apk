package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;

public class SimpleBlendFilter
  extends VideoFilterBase
{
  private Frame greenFrame = new Frame();
  
  public SimpleBlendFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.BASE.vertexShaderContent, ShaderCreateFactory.PROGRAM_TYPE.BASE.fragmentShaderContent);
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("blendMode", 6));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public Frame process(Frame paramFrame)
  {
    this.greenFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramFrame.getTextureId(), 33986));
    OnDrawFrameGLSL();
    renderTexture(this.greenFrame.getTextureId(), this.greenFrame.width, this.greenFrame.height);
    paramFrame.unlock();
    return this.greenFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleBlendFilter
 * JD-Core Version:    0.7.0.1
 */