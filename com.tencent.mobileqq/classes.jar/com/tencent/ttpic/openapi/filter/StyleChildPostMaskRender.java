package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;

public class StyleChildPostMaskRender
  extends VideoFilterBase
{
  public static String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D dstRGB;\nuniform sampler2D warpTex;\n\nuniform float dstWidth;\nuniform float dstHeight;\nuniform float oriWidth;\nuniform float oriHeight;\nuniform float transform[6];\nvoid main()\n{\n    vec2 nPos = vec2(textureCoordinate.x, textureCoordinate.y); // 归一化的坐标\n    vec4 dstColor = texture2D(dstRGB, nPos);//dstRGB.sample(qsampler, nPos); // 结果图\n\n    vec2 oriCoord; // 坐标乘以矩阵，换算到原图坐标\n    vec2 dstCoord = vec2(nPos.x * dstWidth, nPos.y * dstHeight); // 在warp图中绝对坐标\n    oriCoord.x = dstCoord.x * transform[0] + dstCoord.y * transform[1] + transform[2];\n    oriCoord.y = dstCoord.x * transform[3] + dstCoord.y * transform[4] + transform[5];\n    vec4 oriColor = texture2D(inputImageTexture, oriCoord/vec2(oriWidth, oriHeight));//oriTex.sample(qsampler, oriCoord/float2(oriWidth, oriHeight));\n\n    // 分别取出原图偏移位置和当前图位置的坐标\n    float alpha = dstColor.a;\n    dstColor += oriColor * (1.0 - alpha);\n    dstColor.a = oriColor.a;\n    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n}";
  private int[] tex = new int[2];
  
  public StyleChildPostMaskRender(int paramInt1, int paramInt2)
  {
    super(FRAGMENT_SHADER);
    this.width = paramInt1;
    this.height = paramInt2;
    initParams(paramInt1, paramInt2);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    int[] arrayOfInt = this.tex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    int[] arrayOfInt = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void initParams(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.TextureParam("dstRGB", 0, 33986));
    addParam(new UniformParam.TextureParam("warpTex", 0, 33987));
    addParam(new UniformParam.FloatParam("dstWidth", paramInt1));
    addParam(new UniformParam.FloatParam("dstHeight", paramInt2));
    addParam(new UniformParam.FloatParam("oriWidth", 0.0F));
    addParam(new UniformParam.FloatParam("oriHeight", 0.0F));
    addParam(new UniformParam.Float1sParam("transform", new float[0]));
  }
  
  public void render(Frame paramFrame1, Frame paramFrame2, boolean paramBoolean)
  {
    BenchUtil.benchStart("[child] render");
    addParam(new UniformParam.FloatParam("oriWidth", paramFrame1.width));
    addParam(new UniformParam.FloatParam("oriHeight", paramFrame1.height));
    paramFrame2.bindFrame(-1, paramFrame2.width, paramFrame2.height, 0.0D);
    if (paramBoolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    OnDrawFrameGLSL();
    renderTexture(paramFrame1.getTextureId(), this.width, this.height);
    BenchUtil.benchEnd("[child] render");
  }
  
  public void updateParams(Bitmap paramBitmap1, Bitmap paramBitmap2, float[] paramArrayOfFloat)
  {
    GlUtil.loadTexture(this.tex[0], paramBitmap1);
    GlUtil.loadTexture(this.tex[1], paramBitmap2);
    addParam(new UniformParam.TextureParam("dstRGB", this.tex[0], 33986));
    addParam(new UniformParam.TextureParam("warpTex", this.tex[1], 33987));
    addParam(new UniformParam.Float1sParam("transform", paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildPostMaskRender
 * JD-Core Version:    0.7.0.1
 */