package com.tencent.mobileqq.nearby.widget;

import android.graphics.drawable.Drawable;

public class ButtonInfo
{
  public String a;
  public Drawable b;
  public int c = -1;
  public NearbyCustomDialog.OnClickListener d;
  
  public ButtonInfo(String paramString, NearbyCustomDialog.OnClickListener paramOnClickListener)
  {
    this.a = paramString;
    this.d = paramOnClickListener;
    a();
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */