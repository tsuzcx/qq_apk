package com.tencent.mobileqq.emoticon;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract interface IEmojiListenerManager
{
  public abstract void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener);
  
  public abstract void addEmotionJsonDownloadListener(EmotionJsonDownloadListener paramEmotionJsonDownloadListener);
  
  public abstract void notifyEmoticonCoverListener(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void notifyPackageFail(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, AppInterface paramAppInterface);
  
  public abstract void notifyPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2);
  
  public abstract void notifyPackageStart(EmoticonPackage paramEmoticonPackage);
  
  public abstract void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener);
  
  public abstract void removeEmotionJsonDownloadListener(EmotionJsonDownloadListener paramEmotionJsonDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IEmojiListenerManager
 * JD-Core Version:    0.7.0.1
 */