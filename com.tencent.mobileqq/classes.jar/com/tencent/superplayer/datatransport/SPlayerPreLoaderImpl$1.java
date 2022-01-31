package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.ISPlayerPreLoader.Listener;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;

class SPlayerPreLoaderImpl$1
  implements ITPPreloadProxy.IPreloadListener
{
  SPlayerPreLoaderImpl$1(SPlayerPreLoaderImpl paramSPlayerPreLoaderImpl, ISPlayerPreLoader.Listener paramListener) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void onPrepareError()
  {
    this.val$listener.onPrepareError();
  }
  
  public void onPrepareSuccess()
  {
    this.val$listener.onPrepareSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreLoaderImpl.1
 * JD-Core Version:    0.7.0.1
 */