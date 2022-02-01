import android.graphics.drawable.Drawable;

public class swc
  implements Comparable<swc>
{
  public int a;
  public Drawable a;
  public String a;
  
  public swc(String paramString, int paramInt, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public int a(swc paramswc)
  {
    if (this.jdField_a_of_type_Int < paramswc.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramswc.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swc
 * JD-Core Version:    0.7.0.1
 */