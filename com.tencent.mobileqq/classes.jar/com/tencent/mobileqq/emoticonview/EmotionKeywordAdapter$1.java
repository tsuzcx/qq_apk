package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class EmotionKeywordAdapter$1
  implements URLDrawableDownListener
{
  EmotionKeywordAdapter$1(EmotionKeywordAdapter paramEmotionKeywordAdapter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof ProgressBar))) {
      ((ProgressBar)paramView).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter.1
 * JD-Core Version:    0.7.0.1
 */