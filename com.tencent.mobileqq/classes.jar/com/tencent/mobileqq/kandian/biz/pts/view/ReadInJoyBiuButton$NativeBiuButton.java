package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.widget.ImageView;

public class ReadInJoyBiuButton$NativeBiuButton
  extends ImageView
{
  ReadInJoyBiuButton.OnAttachedListener a;
  
  public ReadInJoyBiuButton$NativeBiuButton(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyBiuButton.OnAttachedListener localOnAttachedListener = this.a;
    if (localOnAttachedListener != null) {
      localOnAttachedListener.a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ReadInJoyBiuButton.OnAttachedListener localOnAttachedListener = this.a;
    if (localOnAttachedListener != null) {
      localOnAttachedListener.b();
    }
    super.onDetachedFromWindow();
  }
  
  public void setOnAttachedListener(ReadInJoyBiuButton.OnAttachedListener paramOnAttachedListener)
  {
    this.a = paramOnAttachedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyBiuButton.NativeBiuButton
 * JD-Core Version:    0.7.0.1
 */