package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.vip.DownloadListener;

class PreloadComDownloader$2
  extends AbsPreDownloadTask
{
  PreloadComDownloader$2(PreloadComDownloader paramPreloadComDownloader, BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, DownloadListener paramDownloadListener, DownloadParam paramDownloadParam)
  {
    super(paramBaseQQAppInterface, paramString);
  }
  
  protected void realCancel() {}
  
  protected void realStart()
  {
    PreloadComDownloader.a(this.d, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.2
 * JD-Core Version:    0.7.0.1
 */