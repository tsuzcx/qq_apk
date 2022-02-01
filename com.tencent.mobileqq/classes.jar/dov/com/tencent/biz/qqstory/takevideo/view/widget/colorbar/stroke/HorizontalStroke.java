package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;

public class HorizontalStroke
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c = { 2130847130, 2130847133, 2130847131, 2130847136, 2130847135 };
  public static final int[] d = { 2130847132, 2130847130, 2130847133, 2130847131, 2130847136, 2130847135 };
  public int a;
  public Drawable a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, -2148308, -1009097, -8136876, -13338378 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -1, -2148308, -1009097, -8136876, -13338378 };
  }
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 == 0) {
      this.jdField_b_of_type_JavaLangString = ColorPicker.a(paramInt2);
    }
  }
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return jdField_b_of_type_ArrayOfInt[2];
    }
    return jdField_a_of_type_ArrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke
 * JD-Core Version:    0.7.0.1
 */