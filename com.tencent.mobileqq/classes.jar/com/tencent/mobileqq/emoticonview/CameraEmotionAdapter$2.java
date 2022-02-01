package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class CameraEmotionAdapter$2
  implements URLDrawableDownListener
{
  CameraEmotionAdapter$2(CameraEmotionAdapter paramCameraEmotionAdapter, CameraEmoticonInfo paramCameraEmoticonInfo, URLImageView paramURLImageView, ImageView paramImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
    CameraEmotionAdapter.access$100(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadFailed: " + this.val$emotionInfo.toString());
    CameraEmotionAdapter.access$100(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("CameraEmotionAdapter", 1, "onLoadInterrupted: " + this.val$emotionInfo.toString());
    CameraEmotionAdapter.access$100(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    CameraEmotionAdapter.access$100(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionAdapter", 2, "onLoadSuccessed: " + this.val$emotionInfo.toString());
    }
    CameraEmotionAdapter.access$100(this.this$0, this.val$emoticonImg, this.val$progressView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */