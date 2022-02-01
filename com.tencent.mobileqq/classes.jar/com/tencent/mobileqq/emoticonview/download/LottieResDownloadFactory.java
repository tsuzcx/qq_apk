package com.tencent.mobileqq.emoticonview.download;

public class LottieResDownloadFactory
{
  public static final int DOWNLOAD_ANISTICKER_RES = 1;
  
  public static <T extends IEmoticonLottieResDownloader> T createLottieResDownloader(int paramInt)
  {
    if (paramInt != 1) {
      return null;
    }
    return new AniStickerLottieResDownloader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.LottieResDownloadFactory
 * JD-Core Version:    0.7.0.1
 */