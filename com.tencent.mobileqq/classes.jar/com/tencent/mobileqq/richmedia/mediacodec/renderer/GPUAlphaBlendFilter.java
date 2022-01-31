package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GPUAlphaBlendFilter
  extends GPUBaseFilter
{
  private static final String TAG = "GPUAlphaBlendFilter";
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int m = getProgram();
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
    GLES20.glUseProgram(m);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    checkLocation(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
    checkLocation(m, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, VERTEXT_BUF);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, TEXTURE_BUF);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    onDrawTexture();
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glDisable(3042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter
 * JD-Core Version:    0.7.0.1
 */