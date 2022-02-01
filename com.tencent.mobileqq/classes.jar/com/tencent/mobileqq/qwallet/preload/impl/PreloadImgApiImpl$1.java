package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.os.MqqHandler;

class PreloadImgApiImpl$1
  extends DownloadListener
{
  PreloadImgApiImpl$1(PreloadImgApiImpl paramPreloadImgApiImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ThreadManager.getFileThreadHandler().post(new PreloadImgApiImpl.1.1(this, paramDownloadTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.1
 * JD-Core Version:    0.7.0.1
 */