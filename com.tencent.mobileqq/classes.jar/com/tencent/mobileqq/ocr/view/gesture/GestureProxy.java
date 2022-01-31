package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import aueb;
import aueg;
import auep;
import aueq;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public aueg a()
  {
    return this.jdField_a_of_type_Aueg;
  }
  
  public auep a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aueq.a(this.c);
    this.jdField_a_of_type_Aueq.a(this.d);
    this.jdField_a_of_type_Aueq.a(this.jdField_a_of_type_Auep);
    this.jdField_a_of_type_Aueq.a(this.b);
    if (this.jdField_a_of_type_Aueq.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(aueb paramaueb)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaueb);
  }
  
  public void a(aueg paramaueg)
  {
    this.jdField_a_of_type_Aueg = paramaueg;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Aueq.a(this.c))
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