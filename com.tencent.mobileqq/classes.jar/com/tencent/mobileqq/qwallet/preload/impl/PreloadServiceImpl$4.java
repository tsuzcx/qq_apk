package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.vip.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;

class PreloadServiceImpl$4
  extends TimerTask
{
  PreloadServiceImpl$4(PreloadServiceImpl paramPreloadServiceImpl, WeakReference paramWeakReference, List paramList, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    PreloadServiceImpl localPreloadServiceImpl = (PreloadServiceImpl)this.a.get();
    if (PreloadServiceImpl.isManagerValid(localPreloadServiceImpl)) {
      PreloadServiceImpl.access$200(localPreloadServiceImpl, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */