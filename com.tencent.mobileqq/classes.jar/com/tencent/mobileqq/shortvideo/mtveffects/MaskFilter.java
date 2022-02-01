package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class MaskFilter
  extends GPUBaseFilter
{
  private static final String A_POSITION = "a_Position";
  private static final String MASK_FRAGMENT_SHADER = "precision mediump float;\nuniform vec4 u_Color;\nvoid main() {\n    gl_FragColor = u_Color;\n}\n";
  private static final String MASK_VERTEX_SHADER = "uniform mat4 u_Matrix;\nattribute vec4 a_Position;\nvoid main() {\n    gl_Position = u_Matrix * a_Position;\n}\n";
  private static final String TAG = "MaskFilter";
  private static final String U_COLOR = "u_Color";
  private static final String U_MATRIX = "u_Matrix";
  private final int BYTES_PER_FLOAT = 4;
  private final int COORDS_PER_VERTEX = 2;
  private int mColorLocation;
  private float[] mDefaultMvpMatirx;
  private int mMatrixLocation;
  private FloatBuffer mVertexBuffer;
  private int maPositionLocation;
  
  public MaskFilter()
  {
    super("uniform mat4 u_Matrix;\nattribute vec4 a_Position;\nvoid main() {\n    gl_Position = u_Matrix * a_Position;\n}\n", "precision mediump float;\nuniform vec4 u_Color;\nvoid main() {\n    gl_FragColor = u_Color;\n}\n");
  }
  
  private void getFloatBuffer(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      paramArrayOfFloat = this.mVertexBuffer;
      if (paramArrayOfFloat != null) {
        paramArrayOfFloat.clear();
      }
      return;
    }
    FloatBuffer localFloatBuffer = this.mVertexBuffer;
    if ((localFloatBuffer != null) && (localFloatBuffer.capacity() >= paramArrayOfFloat.length * 4))
    {
      this.mVertexBuffer.clear();
      this.mVertexBuffer.put(paramArrayOfFloat);
      this.mVertexBuffer.rewind();
      return;
    }
    this.mVertexBuffer = GlUtil.createFloatBuffer(paramArrayOfFloat);
  }
  
  public boolean drawShape(float[] paramArrayOfFloat1, int paramInt, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      arrayOfFloat = this.mDefaultMvpMatirx;
    }
    int j = getProgram();
    if (j <= 0) {
      return false;
    }
    getFloatBuffer(paramArrayOfFloat1);
    paramArrayOfFloat1 = this.mVertexBuffer;
    if (paramArrayOfFloat1 != null)
    {
      if (paramArrayOfFloat1.limit() == 0) {
        return false;
      }
      int i = this.mVertexBuffer.limit() / 2;
      GLES20.glUseProgram(j);
      GLES20.glVertexAttribPointer(this.maPositionLocation, 2, 5126, false, 0, this.mVertexBuffer);
      GLES20.glEnableVertexAttribArray(this.maPositionLocation);
      GLES20.glUniform4f(this.mColorLocation, paramInt >> 16 & 0xFF, paramInt >> 8 & 0xFF, paramInt & 0xFF, paramInt >> 24 & 0xFF);
      paramInt = this.mMatrixLocation;
      if (paramInt >= 0) {
        GLES20.glUniformMatrix4fv(paramInt, 1, false, arrayOfFloat, 0);
      }
      GLES20.glDrawArrays(6, 0, i);
      GLES20.glDisableVertexAttribArray(this.maPositionLocation);
      return true;
    }
    return false;
  }
  
  protected void onInitialized()
  {
    this.mDefaultMvpMatirx = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    GLES20.glUseProgram(i);
    this.mMatrixLocation = GLES20.glGetUniformLocation(i, "u_Matrix");
    this.maPositionLocation = GLES20.glGetAttribLocation(i, "a_Position");
    this.mColorLocation = GLES20.glGetUniformLocation(i, "u_Color");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MaskFilter
 * JD-Core Version:    0.7.0.1
 */