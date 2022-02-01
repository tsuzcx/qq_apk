package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class FavoriteEmotionAdapter$2
  implements URLDrawableDownListener
{
  FavoriteEmotionAdapter$2(FavoriteEmotionAdapter paramFavoriteEmotionAdapter, EmoticonInfo paramEmoticonInfo, URLImageView paramURLImageView1, URLImageView paramURLImageView2) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("FavoriteEmotionAdapter", 1, paramView.toString());
    FavoriteEmotionAdapter.access$300(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFailed: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("FavoriteEmotionAdapter", 1, paramView.toString());
    FavoriteEmotionAdapter.access$300(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadInterrupted: ");
    paramView.append(this.val$emotionInfo.toString());
    QLog.e("FavoriteEmotionAdapter", 1, paramView.toString());
    FavoriteEmotionAdapter.access$300(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadProgressed: ");
      paramView.append(this.val$emotionInfo.toString());
      QLog.i("FavoriteEmotionAdapter", 2, paramView.toString());
    }
    FavoriteEmotionAdapter.access$300(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadSuccess: ");
      paramView.append(this.val$emotionInfo.toString());
      QLog.i("FavoriteEmotionAdapter", 2, paramView.toString());
    }
    FavoriteEmotionAdapter.access$300(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */