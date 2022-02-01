package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.view.RendererUtils;

public class ImageCurveAdjustFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  float r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n  float g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n  float b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  gl_FragColor = vec4(r, g, b, color.a);\n}\n";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private int[] lastCurve = new int[256];
  private int paramTEXTRUEID = 0;
  
  public ImageCurveAdjustFilter()
  {
    super(BaseFilter.nativeDecrypt("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}"), "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  float r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n  float g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n  float b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  gl_FragColor = vec4(r, g, b, color.a);\n}\n");
    initParams();
  }
  
  private void setTextureParam(int paramInt1, int paramInt2)
  {
    paramInt2 += 2;
    String str = "inputImageTexture" + paramInt2;
    int i = GLES20.glGetUniformLocation(getProgramIds(), str);
    if (i >= 0)
    {
      GLES20.glActiveTexture(33984 + paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(i, paramInt2);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.clearGLSLSelf();
  }
  
  public void initParams()
  {
    int i = 0;
    while (i < 256)
    {
      this.lastCurve[i] = i;
      i += 1;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.paramTEXTRUEID, 0);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void updateCurve(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 256)
    {
      this.lastCurve[i] = paramArrayOfInt[i];
      i += 1;
    }
    GLSLRender.nativeTextCure(this.lastCurve, this.paramTEXTRUEID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ImageCurveAdjustFilter
 * JD-Core Version:    0.7.0.1
 */