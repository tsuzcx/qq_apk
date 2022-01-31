import android.opengl.GLES20;

public class lrv
  extends lru
{
  public lrv(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lsv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrv
 * JD-Core Version:    0.7.0.1
 */