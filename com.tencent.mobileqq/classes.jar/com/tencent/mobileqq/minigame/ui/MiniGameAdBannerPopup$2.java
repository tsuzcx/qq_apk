package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$2
  implements Runnable
{
  MiniGameAdBannerPopup$2(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem) {}
  
  public void run()
  {
    try
    {
      MiniGameAdBannerPopup.access$200(this.val$context, this.val$finalType, this.val$finalText, this.val$finalPic, this.val$finalUrl, this.val$finalTianShuAdItem);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniGameAdBannerPopup", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.2
 * JD-Core Version:    0.7.0.1
 */