package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GpuRoundRectFilter
  extends GPUBaseFilter
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private float jdField_a_of_type_Float = 0.0327F;
  private int jdField_a_of_type_Int = -1;
  private int jdField_b_of_type_Int = -1;
  
  public GpuRoundRectFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nuniform sampler2D alphaTexture;\n\nvoid main() {\n      gl_FragColor = texture2D(uTexture, vTextureCoord);\n      gl_FragColor.a = texture2D(alphaTexture, vTextureCoord).a;\n}\n");
  }
  
  public void destroy()
  {
    super.destroy();
    GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_b_of_type_Int }, 0);
    GlUtil.deleteTexture(this.jdField_a_of_type_Int);
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int i = getProgram();
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
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(i);
    checkGlError("glUseProgram");
    int j = GLES20.glGetAttribLocation(i, "aPosition");
    checkLocation(j, "aPosition");
    int k = GLES20.glGetAttribLocation(i, "aTextureCoord");
    checkLocation(k, "aTextureCoord");
    int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    checkLocation(m, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    checkLocation(n, "uTextureMatrix");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(k);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "uTexture"), 0);
    checkGlError("uTextureLoc");
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "alphaTexture"), 1);
    checkGlError("alphaTextureLoc");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    checkGlError("glBindTexture GL_TEXTURE0");
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, this.jdField_a_of_type_Int);
    checkGlError("glBindTexture GL_TEXTURE1");
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glDisable(3042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuRoundRectFilter
 * JD-Core Version:    0.7.0.1
 */