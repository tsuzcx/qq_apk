package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GPUAlphaFilter
  extends GPUBaseFilter
{
  public static final String ALPHA_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nvarying vec4 v_color;\n\nvoid main() {\n    gl_FragColor = v_color * texture2D(uTexture, vTextureCoord);\n}\n";
  public static final String ALPHA_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nattribute vec4 a_color;\nvarying vec4 v_color;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    v_color = a_color;\n}\n";
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  
  public GPUAlphaFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nattribute vec4 a_color;\nvarying vec4 v_color;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    v_color = a_color;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nvarying vec4 v_color;\n\nvoid main() {\n    gl_FragColor = v_color * texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUAlphaFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer)
  {
    checkGlError("onDrawFrame start");
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    int n = getProgram();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(n);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(n, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(n, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetAttribLocation(n, "a_color");
    checkLocation(k, "a_color");
    int m = GLES20.glGetUniformLocation(n, "uMVPMatrix");
    checkLocation(m, "uMVPMatrix");
    n = GLES20.glGetUniformLocation(n, "uTextureMatrix");
    checkLocation(n, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, VERTEXT_BUF);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, TEXTURE_BUF);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glVertexAttribPointer(k, 4, 5126, false, 0, paramFloatBuffer);
    checkGlError("glVertexAttribPointer aColor");
    GLES20.glEnableVertexAttribArray(k);
    checkGlError("glEnableVertexAttribArray aColor");
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glDisable(3042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaFilter
 * JD-Core Version:    0.7.0.1
 */