package com.tencent.mobileqq.structmsg.widget;

import aipo;
import aipp;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import azvy;
import azvz;

public class CountdownTextView
  extends TextView
{
  private aipo jdField_a_of_type_Aipo = new aipo();
  private aipp jdField_a_of_type_Aipp;
  
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
    aipo localaipo = this.jdField_a_of_type_Aipo;
    if (localaipo != null) {
      localaipo.b(this.jdField_a_of_type_Aipp);
    }
  }
  
  public void a(long paramLong, azvz paramazvz)
  {
    aipo localaipo = this.jdField_a_of_type_Aipo;
    if (localaipo != null)
    {
      this.jdField_a_of_type_Aipp = new azvy(this, paramLong, paramazvz);
      localaipo.a(this.jdField_a_of_type_Aipp);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */