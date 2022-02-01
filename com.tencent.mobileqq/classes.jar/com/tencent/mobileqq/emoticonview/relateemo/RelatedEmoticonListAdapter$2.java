package com.tencent.mobileqq.emoticonview.relateemo;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class RelatedEmoticonListAdapter$2
  implements URLDrawableDownListener
{
  RelatedEmoticonListAdapter$2(RelatedEmoticonListAdapter paramRelatedEmoticonListAdapter, EmoticonInfo paramEmoticonInfo) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadInterrupted: " + this.val$emotionInfo.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelatedEmoticonListAdapter", 2, "onLoadSuccessed: " + this.val$emotionInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter.2
 * JD-Core Version:    0.7.0.1
 */