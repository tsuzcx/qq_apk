import android.opengl.GLES20;
import com.tencent.avgame.videorecord.GameVideoDarkCoverFilter.1;
import java.nio.FloatBuffer;

public class ngn
  extends ngl
{
  private int g;
  
  public ngn()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision mediump float;\nuniform vec4 coverColor;\nvoid main()\n{\n\tgl_FragColor = coverColor;\n}");
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(new GameVideoDarkCoverFilter.1(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (!a()) {
      a();
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    g();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.jdField_b_of_type_Int);
    c();
  }
  
  public void b()
  {
    super.b();
    this.g = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "coverColor");
  }
  
  public void h()
  {
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    a(-1, this.jdField_b_of_type_JavaNioFloatBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngn
 * JD-Core Version:    0.7.0.1
 */