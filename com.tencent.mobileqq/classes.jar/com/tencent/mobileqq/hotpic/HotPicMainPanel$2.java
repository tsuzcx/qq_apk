package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.DownloadListener;

class HotPicMainPanel$2
  implements URLDrawable.DownloadListener
{
  HotPicMainPanel$2(HotPicMainPanel paramHotPicMainPanel, ImageView paramImageView) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.v.post(new HotPicMainPanel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel.2
 * JD-Core Version:    0.7.0.1
 */