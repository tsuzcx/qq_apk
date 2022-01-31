package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import avvf;
import avvk;
import avvt;
import avvu;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public avvk a()
  {
    return this.jdField_a_of_type_Avvk;
  }
  
  public avvt a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avvu.a(this.c);
    this.jdField_a_of_type_Avvu.a(this.d);
    this.jdField_a_of_type_Avvu.a(this.jdField_a_of_type_Avvt);
    this.jdField_a_of_type_Avvu.a(this.b);
    if (this.jdField_a_of_type_Avvu.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(avvf paramavvf)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramavvf);
  }
  
  public void a(avvk paramavvk)
  {
    this.jdField_a_of_type_Avvk = paramavvk;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Avvu.a(this.c))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureProxy
 * JD-Core Version:    0.7.0.1
 */