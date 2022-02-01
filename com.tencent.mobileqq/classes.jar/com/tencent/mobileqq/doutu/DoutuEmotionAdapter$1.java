package com.tencent.mobileqq.doutu;

import android.view.View;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.util.HashMap;

class DoutuEmotionAdapter$1
  implements URLDrawableDownListener
{
  DoutuEmotionAdapter$1(DoutuEmotionAdapter paramDoutuEmotionAdapter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof DoutuEmotionAdapter.ViewHolder)))
    {
      paramView = (DoutuEmotionAdapter.ViewHolder)paramView;
      if (paramView.c != null) {
        paramView.c.setVisibility(4);
      }
      if (this.a.j == null) {
        this.a.j = new HashMap();
      }
      if ((paramView.d != null) && (paramView.d.picMd5 != null) && (paramView.d.picDownUrl != null)) {
        this.a.j.put(paramView.d.picMd5, paramView.d.picDownUrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */