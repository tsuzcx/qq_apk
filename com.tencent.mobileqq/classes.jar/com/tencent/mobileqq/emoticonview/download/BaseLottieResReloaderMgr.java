package com.tencent.mobileqq.emoticonview.download;

import com.tencent.qphone.base.util.QLog;

public abstract class BaseLottieResReloaderMgr
{
  protected EmoLottieResReloader mResReloader;
  
  public void addReloadDrawable(int paramInt, String paramString)
  {
    if (this.mResReloader == null) {
      this.mResReloader = createLottieResReloader(paramInt);
    }
    EmoLottieResReloader localEmoLottieResReloader = this.mResReloader;
    if (localEmoLottieResReloader == null)
    {
      QLog.e("EmoLottieResReloaderMgr", 2, "resReloader is null.");
      return;
    }
    localEmoLottieResReloader.addReloadList(paramString);
  }
  
  public void clearReloadList()
  {
    EmoLottieResReloader localEmoLottieResReloader = this.mResReloader;
    if (localEmoLottieResReloader != null)
    {
      localEmoLottieResReloader.clearReloadList();
      this.mResReloader = null;
    }
  }
  
  public abstract EmoLottieResReloader createLottieResReloader(int paramInt);
  
  public void nofityReloadList()
  {
    EmoLottieResReloader localEmoLottieResReloader = this.mResReloader;
    if (localEmoLottieResReloader != null) {
      localEmoLottieResReloader.nofityReloadList();
    }
  }
  
  public void resDownloadFinish()
  {
    nofityReloadList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.BaseLottieResReloaderMgr
 * JD-Core Version:    0.7.0.1
 */