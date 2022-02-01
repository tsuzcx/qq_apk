package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GpuRoundRectFilter2
  extends GPUBaseFilter
{
  private float a;
  protected int a;
  protected FloatBuffer a;
  protected FloatBuffer b;
  
  public GpuRoundRectFilter2()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = 3;
  }
  
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
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.b);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    onDrawTexture();
    GLES20.glDrawArrays(6, 0, this.jdField_a_of_type_Int * 4 * 2 + 1 + 1);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuRoundRectFilter2
 * JD-Core Version:    0.7.0.1
 */