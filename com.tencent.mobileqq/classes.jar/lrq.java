import android.opengl.GLES20;

public class lrq
  extends lrp
{
  public lrq(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lsq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lrq
 * JD-Core Version:    0.7.0.1
 */