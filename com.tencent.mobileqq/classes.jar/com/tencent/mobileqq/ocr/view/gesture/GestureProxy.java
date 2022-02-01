package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import azbz;
import azce;
import azcn;
import azco;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public azce a()
  {
    return this.jdField_a_of_type_Azce;
  }
  
  public azcn a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azco.a(this.c);
    this.jdField_a_of_type_Azco.a(this.d);
    this.jdField_a_of_type_Azco.a(this.jdField_a_of_type_Azcn);
    this.jdField_a_of_type_Azco.a(this.b);
    if (this.jdField_a_of_type_Azco.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(azbz paramazbz)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramazbz);
  }
  
  public void a(azce paramazce)
  {
    this.jdField_a_of_type_Azce = paramazce;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Azco.a(this.c))
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