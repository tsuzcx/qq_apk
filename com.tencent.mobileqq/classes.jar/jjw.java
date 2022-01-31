import android.opengl.GLES20;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter;
import java.nio.FloatBuffer;

public class jjw
  implements Runnable
{
  public jjw(QQAVImageWrongEraseFilter paramQQAVImageWrongEraseFilter, int paramInt1, int paramInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GLES20.glUniform4fv(this.jdField_a_of_type_Int, this.b, FloatBuffer.wrap(this.jdField_a_of_type_ArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     jjw
 * JD-Core Version:    0.7.0.1
 */