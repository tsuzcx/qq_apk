package com.tencent.mobileqq.filter;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import mqq.app.MobileQQ;

public class GPUDrawPartFilter
  extends GPUBaseFilter
{
  private static String g = GlUtil.readTextFromRawResource(MobileQQ.getContext(), 2131230831);
  private int a;
  private int b;
  private int c;
  private boolean d = true;
  private float e = 0.0F;
  private boolean f = false;
  
  public GPUDrawPartFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", g);
  }
  
  public GPUDrawPartFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.mFilterType = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    paramFloat = f1;
    if (f1 < 0.0F) {
      paramFloat = 0.0F;
    }
    this.f = paramBoolean;
    this.e = paramFloat;
  }
  
  protected void onDrawTexture()
  {
    int i = this.b;
    boolean bool = this.f;
    float f2 = 1.0F;
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
    GLES20.glUniform1f(this.a, this.e);
    i = this.c;
    if (this.d) {
      f1 = f2;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
  }
  
  protected void onInitialized()
  {
    this.a = GLES20.glGetUniformLocation(getProgram(), "percent");
    this.b = GLES20.glGetUniformLocation(getProgram(), "drawPart");
    this.c = GLES20.glGetUniformLocation(getProgram(), "cutX");
  }
  
  public String toString()
  {
    int i = this.mFilterType;
    boolean bool = this.f;
    double d2 = 1.0D;
    double d1;
    if (bool) {
      d1 = 1.0D;
    } else {
      d1 = 2.0D;
    }
    float f1 = this.e;
    if (!this.d) {
      d2 = 2.0D;
    }
    return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Float.valueOf(f1), Double.valueOf(d2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GPUDrawPartFilter
 * JD-Core Version:    0.7.0.1
 */