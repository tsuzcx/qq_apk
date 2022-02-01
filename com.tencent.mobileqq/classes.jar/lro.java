import android.opengl.GLES20;

public class lro
  extends lrp
{
  public lro(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lsq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lro
 * JD-Core Version:    0.7.0.1
 */