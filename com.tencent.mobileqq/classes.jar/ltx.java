import android.opengl.GLES20;

public class ltx
  extends ltw
{
  public ltx(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lux.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ltx
 * JD-Core Version:    0.7.0.1
 */