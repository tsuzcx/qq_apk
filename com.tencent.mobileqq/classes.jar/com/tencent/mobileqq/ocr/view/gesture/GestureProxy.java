package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import ayvs;
import ayvx;
import aywg;
import aywh;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public ayvx a()
  {
    return this.jdField_a_of_type_Ayvx;
  }
  
  public aywg a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aywh.a(this.c);
    this.jdField_a_of_type_Aywh.a(this.d);
    this.jdField_a_of_type_Aywh.a(this.jdField_a_of_type_Aywg);
    this.jdField_a_of_type_Aywh.a(this.b);
    if (this.jdField_a_of_type_Aywh.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(ayvs paramayvs)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramayvs);
  }
  
  public void a(ayvx paramayvx)
  {
    this.jdField_a_of_type_Ayvx = paramayvx;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Aywh.a(this.c))
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