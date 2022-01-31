package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import com.tencent.qqmini.sdk.log.QMLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$3
  implements Runnable
{
  MiniGameAdBannerPopup$3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem) {}
  
  public void run()
  {
    try
    {
      MiniGameAdBannerPopup.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniGameAdBannerPopup", "showAdBannerPopupWindow exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup.3
 * JD-Core Version:    0.7.0.1
 */