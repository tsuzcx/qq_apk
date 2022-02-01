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
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("EmotionHotPicSearchAdapter", 1, paramView.toString());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("EmotionHotPicSearchAdapter", 1, paramView.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadInterrupted: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("EmotionHotPicSearchAdapter", 1, paramView.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadSuccessed: ");
      paramView.append(this.val$emotionInfo.toString());
      QLog.i("EmotionHotPicSearchAdapter", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter.1
 * JD-Core Version:    0.7.0.1
 */