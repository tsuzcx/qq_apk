package com.tencent.mobileqq.pluspanel;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class AIOPanelIconItem
  implements Comparable<AIOPanelIconItem>
{
  public int a;
  public Drawable a;
  public String a;
  public int[] a;
  public int b;
  public Drawable b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public AIOPanelIconItem() {}
  
  public AIOPanelIconItem(AIOPanelIconItem paramAIOPanelIconItem)
  {
    this.jdField_a_of_type_Int = paramAIOPanelIconItem.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramAIOPanelIconItem.jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramAIOPanelIconItem.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramAIOPanelIconItem.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramAIOPanelIconItem.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_Int = paramAIOPanelIconItem.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = paramAIOPanelIconItem.jdField_d_of_type_Int;
    this.jdField_d_of_type_JavaLangString = paramAIOPanelIconItem.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramAIOPanelIconItem.jdField_e_of_type_JavaLangString;
    this.f = paramAIOPanelIconItem.f;
    this.g = paramAIOPanelIconItem.g;
    this.h = paramAIOPanelIconItem.h;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_e_of_type_Int = paramAIOPanelIconItem.jdField_e_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt = paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt;
  }
  
  public int a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (paramAIOPanelIconItem != null) {
      return this.jdField_c_of_type_Int - paramAIOPanelIconItem.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public Drawable a()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.f)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.f, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
      }
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public Drawable b()
  {
    try
    {
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.g, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.h, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
      }
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPanelIconItem
 * JD-Core Version:    0.7.0.1
 */