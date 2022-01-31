package com.tencent.mobileqq.structmsg.widget;

import agvp;
import agvq;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import ayae;
import ayaf;

public class CountdownTextView
  extends TextView
{
  private agvp jdField_a_of_type_Agvp = new agvp();
  private agvq jdField_a_of_type_Agvq;
  
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
    agvp localagvp = this.jdField_a_of_type_Agvp;
    if (localagvp != null) {
      localagvp.b(this.jdField_a_of_type_Agvq);
    }
  }
  
  public void a(long paramLong, ayaf paramayaf)
  {
    agvp localagvp = this.jdField_a_of_type_Agvp;
    if (localagvp != null)
    {
      this.jdField_a_of_type_Agvq = new ayae(this, paramLong, paramayaf);
      localagvp.a(this.jdField_a_of_type_Agvq);
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