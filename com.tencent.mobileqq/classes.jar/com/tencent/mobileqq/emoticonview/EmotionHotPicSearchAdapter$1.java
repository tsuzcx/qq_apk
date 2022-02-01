package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class EmotionHotPicSearchAdapter$1
  implements URLDrawableDownListener
{
  EmotionHotPicSearchAdapter$1(EmotionHotPicSearchAdapter paramEmotionHotPicSearchAdapter, EmoticonInfo paramEmoticonInfo) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("EmotionHotPicSearchAdapter", 1, "onLoadInterrupted: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmotionHotPicSearchAdapter", 2, "onLoadSuccessed: " + this.val$emotionInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter.1
 * JD-Core Version:    0.7.0.1
 */