import android.opengl.GLES20;

public class lhe
  extends lhd
{
  public lhe(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lie.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhe
 * JD-Core Version:    0.7.0.1
 */