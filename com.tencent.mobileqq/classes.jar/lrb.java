import android.opengl.GLES20;

public class lrb
  extends lrc
{
  public lrb(String paramString)
  {
    super(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(paramInt, this.jdField_a_of_type_JavaLangString);
    lsd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrb
 * JD-Core Version:    0.7.0.1
 */