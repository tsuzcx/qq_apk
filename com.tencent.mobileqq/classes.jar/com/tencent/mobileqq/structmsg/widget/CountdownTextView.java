package com.tencent.mobileqq.structmsg.widget;

import agjc;
import agjd;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import axaa;
import axab;

public class CountdownTextView
  extends TextView
{
  private agjc jdField_a_of_type_Agjc = new agjc();
  private agjd jdField_a_of_type_Agjd;
  
  public CountdownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    agjc localagjc = this.jdField_a_of_type_Agjc;
    if (localagjc != null) {
      localagjc.b(this.jdField_a_of_type_Agjd);
    }
  }
  
  public void a(long paramLong, axab paramaxab)
  {
    agjc localagjc = this.jdField_a_of_type_Agjc;
    if (localagjc != null)
    {
      this.jdField_a_of_type_Agjd = new axaa(this, paramLong, paramaxab);
      localagjc.a(this.jdField_a_of_type_Agjd);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */