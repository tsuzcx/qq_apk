package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.model.StickerItem;

public class FabbyStrokeFilterOptim
  extends FabbyStrokeFilter
{
  private static final int MAX_WIDTH = 360;
  private BaseFilter mMixFilter;
  private float mScale = 1.0F;
  
  public FabbyStrokeFilterOptim() {}
  
  public FabbyStrokeFilterOptim(StickerItem paramStickerItem)
  {
    super(paramStickerItem);
  }
  
  private String getMixShader(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("precision mediump float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvoid main(){\n    vec4 base = texture2D(inputImageTexture, textureCoordinate);\n    vec4 overlay = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y));\n    vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n");
    if (paramBoolean) {}
    for (String str = "    gl_FragColor = mix(base, overlay, mask.r);\n";; str = "    gl_FragColor = mix(overlay, base,  mask.r);\n") {
      return str + "}\n";
    }
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    if (paramInt2 > 360) {}
    for (int i = 360;; i = paramInt2)
    {
      int j = i * paramInt3 / paramInt2;
      this.mScale = (i * 1.0F / paramInt2);
      Frame localFrame = FrameBufferCache.getInstance().get(i, j);
      super.RenderProcess(paramInt1, paramInt2, paramInt3, i, j, paramInt4, paramDouble, localFrame);
      if (this.mMixFilter != null)
      {
        this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", localFrame.getTextureId(), 33986));
        this.mMixFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame);
      }
      localFrame.unlock();
      return;
    }
  }
  
  public void apply()
  {
    super.apply();
    this.mMixFilter = new BaseFilter(getMixShader(false));
    this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    this.mMixFilter.apply();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.mMixFilter != null) {
      this.mMixFilter.clearGLSLSelf();
    }
  }
  
  public void setStepX(float paramFloat)
  {
    super.setStepX(paramFloat / this.mScale);
  }
  
  public void setStepY(float paramFloat)
  {
    super.setStepY(paramFloat / this.mScale);
  }
  
  public void setStrokeGapInPixel(float paramFloat)
  {
    super.setStrokeGapInPixel(this.mScale * paramFloat);
  }
  
  public void setStrokeWidthInPixel(float paramFloat)
  {
    super.setStrokeWidthInPixel(this.mScale * paramFloat);
  }
  
  public void setmMaskTex(int paramInt)
  {
    super.setmMaskTex(paramInt);
    if (this.mMixFilter != null) {
      this.mMixFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyStrokeFilterOptim
 * JD-Core Version:    0.7.0.1
 */