package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import axph;
import axpm;
import axpv;
import axpw;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public axpm a()
  {
    return this.jdField_a_of_type_Axpm;
  }
  
  public axpv a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Axpw.a(this.c);
    this.jdField_a_of_type_Axpw.a(this.d);
    this.jdField_a_of_type_Axpw.a(this.jdField_a_of_type_Axpv);
    this.jdField_a_of_type_Axpw.a(this.b);
    if (this.jdField_a_of_type_Axpw.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(axph paramaxph)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaxph);
  }
  
  public void a(axpm paramaxpm)
  {
    this.jdField_a_of_type_Axpm = paramaxpm;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Axpw.a(this.c))
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