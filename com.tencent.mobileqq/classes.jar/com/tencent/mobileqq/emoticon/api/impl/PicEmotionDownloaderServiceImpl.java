package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.api.IPicEmotionDownloaderService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicEmotionDownloader;
import mqq.app.MobileQQ;

public class PicEmotionDownloaderServiceImpl
  implements IPicEmotionDownloaderService
{
  public AbsDownloader createPicEmotionDownloader(MobileQQ paramMobileQQ)
  {
    return new PicEmotionDownloader(paramMobileQQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.PicEmotionDownloaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */