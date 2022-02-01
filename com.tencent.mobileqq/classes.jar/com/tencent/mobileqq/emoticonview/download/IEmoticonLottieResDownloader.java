package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.Builder;

public abstract interface IEmoticonLottieResDownloader
{
  public abstract boolean checkFileExists();
  
  public abstract void loadLottieRes(String paramString, AniStickerHelper.Builder paramBuilder, LoadListener paramLoadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.IEmoticonLottieResDownloader
 * JD-Core Version:    0.7.0.1
 */