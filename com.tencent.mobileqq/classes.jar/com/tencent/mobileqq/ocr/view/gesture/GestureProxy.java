package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import avzo;
import avzt;
import awac;
import awad;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public avzt a()
  {
    return this.jdField_a_of_type_Avzt;
  }
  
  public awac a()
  {
    return this.c;
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Awad.a(this.c);
    this.jdField_a_of_type_Awad.a(this.d);
    this.jdField_a_of_type_Awad.a(this.jdField_a_of_type_Awac);
    this.jdField_a_of_type_Awad.a(this.b);
    if (this.jdField_a_of_type_Awad.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(avzo paramavzo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramavzo);
  }
  
  public void a(avzt paramavzt)
  {
    this.jdField_a_of_type_Avzt = paramavzt;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_Awad.a(this.c))
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