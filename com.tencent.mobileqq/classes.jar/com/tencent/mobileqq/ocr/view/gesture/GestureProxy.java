package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import ayjg;
import ayjl;
import ayju;
import ayjv;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public ayjl a()
  {
    return this.jdField_a_of_type_Ayjl;
  }
  
  public ayju a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ayjv.a(this.c);
    this.jdField_a_of_type_Ayjv.a(this.d);
    this.jdField_a_of_type_Ayjv.a(this.jdField_a_of_type_Ayju);
    this.jdField_a_of_type_Ayjv.a(this.b);
    if (this.jdField_a_of_type_Ayjv.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(ayjg paramayjg)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramayjg);
  }
  
  public void a(ayjl paramayjl)
  {
    this.jdField_a_of_type_Ayjl = paramayjl;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Ayjv.a(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    return super.b(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureProxy
 * JD-Core Version:    0.7.0.1
 */