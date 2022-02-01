package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import android.opengl.GLES20;
import com.tencent.tkd.R.raw;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;
import org.jetbrains.annotations.NotNull;

public class GPUDrawPartFilter
  extends GPUBaseFilter
{
  private static String c = GlUtil.a(AppContext.a, R.raw.a);
  private int d;
  private int e;
  private int f;
  private boolean g = true;
  private float h = 0.0F;
  private boolean i = false;
  
  GPUDrawPartFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", c);
  }
  
  GPUDrawPartFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.b = 0;
  }
  
  protected void a()
  {
    this.d = GLES20.glGetUniformLocation(e(), "percent");
    this.e = GLES20.glGetUniformLocation(e(), "drawPart");
    this.f = GLES20.glGetUniformLocation(e(), "cutX");
  }
  
  protected void b()
  {
    int j = this.e;
    boolean bool = this.i;
    float f2 = 1.0F;
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(j, f1);
    GLES20.glUniform1f(this.d, this.h);
    j = this.f;
    if (this.g) {
      f1 = f2;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(j, f1);
  }
  
  @NotNull
  public String toString()
  {
    int j = this.b;
    boolean bool = this.i;
    double d2 = 1.0D;
    double d1;
    if (bool) {
      d1 = 1.0D;
    } else {
      d1 = 2.0D;
    }
    float f1 = this.h;
    if (!this.g) {
      d2 = 2.0D;
    }
    return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(j), Double.valueOf(d1), Float.valueOf(f1), Double.valueOf(d2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.GPUDrawPartFilter
 * JD-Core Version:    0.7.0.1
 */