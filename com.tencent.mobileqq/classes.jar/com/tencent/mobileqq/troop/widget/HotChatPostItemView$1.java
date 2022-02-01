package com.tencent.mobileqq.troop.widget;

import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;

final class HotChatPostItemView$1
  implements URLDrawable.URLDrawableListener
{
  HotChatPostItemView$1(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString, URLDrawable paramURLDrawable, float paramFloat, int paramInt4) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(null);
    this.a.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    int i = this.h;
    if (i != 0)
    {
      this.a.setBackgroundResource(i);
      return;
    }
    this.a.setImageDrawable(null);
    this.a.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(null);
    if ((this.b != 0) && (this.c != 0) && (this.d != 0))
    {
      ThreadManager.post(new HotChatPostItemView.1.1(this), 5, null, true);
      return;
    }
    this.a.setImageDrawable(HotChatPostItemView.a(this.f, this.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1
 * JD-Core Version:    0.7.0.1
 */