package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.VasExtensionDownloader;
import mqq.app.MobileQQ;

public class VasExtensionDownloaderServiceImpl
  implements IVasExtensionDownloaderService
{
  public AbsDownloader createVasExtensionDownloader()
  {
    return new VasExtensionDownloader(MobileQQ.sMobileQQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.VasExtensionDownloaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */