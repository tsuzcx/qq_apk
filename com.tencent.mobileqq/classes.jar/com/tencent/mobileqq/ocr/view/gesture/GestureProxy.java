package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import audz;
import auee;
import auen;
import aueo;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public auee a()
  {
    return this.jdField_a_of_type_Auee;
  }
  
  public auen a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aueo.a(this.c);
    this.jdField_a_of_type_Aueo.a(this.d);
    this.jdField_a_of_type_Aueo.a(this.jdField_a_of_type_Auen);
    this.jdField_a_of_type_Aueo.a(this.b);
    if (this.jdField_a_of_type_Aueo.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(audz paramaudz)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaudz);
  }
  
  public void a(auee paramauee)
  {
    this.jdField_a_of_type_Auee = paramauee;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Aueo.a(this.c))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureProxy
 * JD-Core Version:    0.7.0.1
 */