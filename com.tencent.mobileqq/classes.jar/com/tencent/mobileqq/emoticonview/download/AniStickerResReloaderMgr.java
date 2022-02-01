package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import mqq.os.MqqHandler;

public class AniStickerResReloaderMgr
  extends BaseLottieResReloaderMgr
  implements EmoLottieResReloader.IResReloadListener
{
  private static final String TAG = "AniStickerResReloaderMgr";
  
  public static final AniStickerResReloaderMgr getInstance()
  {
    return AniStickerResReloaderMgr.AniStickerResReloaderMgrHolder.access$000();
  }
  
  public EmoLottieResReloader createLottieResReloader(int paramInt)
  {
    if (paramInt == 1) {
      return new EmoLottieResReloader(this);
    }
    return null;
  }
  
  public void startReloadDrawable(String paramString)
  {
    AniStickerLottieView.startReloadDrawable(paramString);
  }
  
  public void triggerDownloadRes()
  {
    ThreadManager.getSubThreadHandler().post(new AniStickerResReloaderMgr.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr
 * JD-Core Version:    0.7.0.1
 */