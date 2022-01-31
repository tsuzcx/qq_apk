package com.tencent.mobileqq.structmsg.widget;

import aiud;
import aiue;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import baah;
import baai;

public class CountdownTextView
  extends TextView
{
  private aiud jdField_a_of_type_Aiud = new aiud();
  private aiue jdField_a_of_type_Aiue;
  
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
    aiud localaiud = this.jdField_a_of_type_Aiud;
    if (localaiud != null) {
      localaiud.b(this.jdField_a_of_type_Aiue);
    }
  }
  
  public void a(long paramLong, baai parambaai)
  {
    aiud localaiud = this.jdField_a_of_type_Aiud;
    if (localaiud != null)
    {
      this.jdField_a_of_type_Aiue = new baah(this, paramLong, parambaai);
      localaiud.a(this.jdField_a_of_type_Aiue);
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