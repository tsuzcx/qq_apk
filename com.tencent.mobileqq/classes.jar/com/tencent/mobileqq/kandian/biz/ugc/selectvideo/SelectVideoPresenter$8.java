package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.image.URLDrawable.DownloadListener;

class SelectVideoPresenter$8
  implements URLDrawable.DownloadListener
{
  SelectVideoPresenter$8(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    SelectVideoPresenter.e(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    SelectVideoPresenter.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.8
 * JD-Core Version:    0.7.0.1
 */