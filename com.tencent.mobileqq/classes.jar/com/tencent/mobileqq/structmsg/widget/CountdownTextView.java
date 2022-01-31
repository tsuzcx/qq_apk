package com.tencent.mobileqq.structmsg.widget;

import agvr;
import agvs;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import ayac;
import ayad;

public class CountdownTextView
  extends TextView
{
  private agvr jdField_a_of_type_Agvr = new agvr();
  private agvs jdField_a_of_type_Agvs;
  
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
    agvr localagvr = this.jdField_a_of_type_Agvr;
    if (localagvr != null) {
      localagvr.b(this.jdField_a_of_type_Agvs);
    }
  }
  
  public void a(long paramLong, ayad paramayad)
  {
    agvr localagvr = this.jdField_a_of_type_Agvr;
    if (localagvr != null)
    {
      this.jdField_a_of_type_Agvs = new ayac(this, paramLong, paramayad);
      localagvr.a(this.jdField_a_of_type_Agvs);
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