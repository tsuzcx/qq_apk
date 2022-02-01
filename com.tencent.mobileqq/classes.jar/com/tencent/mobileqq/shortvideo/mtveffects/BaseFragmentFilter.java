package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class BaseFragmentFilter
  extends GPUBaseFilter
{
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  private int mAttrMVPMatrix = -1;
  private int mAttrPosition = -1;
  private int mAttrTextureCoord = -1;
  private int mAttrTextureMatrix = -1;
  private float[] mDefaultMvpMatirx;
  private float[] mDefaultTextureMatirx;
  
  public BaseFragmentFilter(String paramString)
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", paramString);
  }
  
  public FloatBuffer getTextureBuffer(RectF paramRectF)
  {
    if (paramRectF == null) {
      return GlUtil.createFloatBuffer(TEXUTURE_COORDS);
    }
    return GlUtil.createFloatBuffer(new float[] { paramRectF.left, paramRectF.bottom, paramRectF.right, paramRectF.bottom, paramRectF.right, paramRectF.top, paramRectF.left, paramRectF.top });
  }
  
  protected void onInitialized()
  {
    this.mDefaultTextureMatirx = new float[16];
    Matrix.setIdentityM(this.mDefaultTextureMatirx, 0);
    this.mDefaultMvpMatirx = new float[16];
    Matrix.setIdentityM(this.mDefaultMvpMatirx, 0);
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    GLES20.glUseProgram(i);
    this.mAttrPosition = GLES20.glGetAttribLocation(i, "aPosition");
    this.mAttrTextureCoord = GLES20.glGetAttribLocation(i, "aTextureCoord");
    this.mAttrMVPMatrix = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    this.mAttrTextureMatrix = GLES20.glGetUniformLocation(i, "uTextureMatrix");
  }
  
  public boolean processBegin(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null) {
      arrayOfFloat = this.mDefaultTextureMatirx;
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      paramArrayOfFloat1 = this.mDefaultMvpMatirx;
    }
    int i = getProgram();
    if (i <= 0) {
      return false;
    }
    GLES20.glUseProgram(i);
    GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 8, VERTEXT_BUF);
    GLES20.glEnableVertexAttribArray(this.mAttrPosition);
    GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 8, TEXTURE_BUF);
    GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
    i = this.mAttrMVPMatrix;
    if (i >= 0) {
      GLES20.glUniformMatrix4fv(i, 1, false, paramArrayOfFloat1, 0);
    }
    i = this.mAttrTextureMatrix;
    if (i >= 0) {
      GLES20.glUniformMatrix4fv(i, 1, false, arrayOfFloat, 0);
    }
    return true;
  }
  
  public void processEnd(boolean paramBoolean, int... paramVarArgs)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    int i = 0;
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.mAttrPosition);
    GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
    if (paramBoolean) {
      GLES20.glDisable(3042);
    }
    if (paramVarArgs != null) {
      while (i < paramVarArgs.length)
      {
        releaseTextureUnit(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public void releaseTextureUnit(int paramInt)
  {
    GLES20.glActiveTexture(paramInt);
    GLES20.glBindTexture(this.mTextureType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.BaseFragmentFilter
 * JD-Core Version:    0.7.0.1
 */