import android.graphics.drawable.Drawable;

public class sgt
  implements Comparable<sgt>
{
  public int a;
  public Drawable a;
  public String a;
  
  public sgt(String paramString, int paramInt, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public int a(sgt paramsgt)
  {
    if (this.jdField_a_of_type_Int < paramsgt.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramsgt.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgt
 * JD-Core Version:    0.7.0.1
 */