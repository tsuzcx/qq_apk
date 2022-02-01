package com.tencent.mobileqq.minigame.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.util.StorageUtil;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$3
  implements DialogInterface.OnShowListener
{
  MiniGameAdBannerPopup$3(TianShuAccess.AdItem paramAdItem, String paramString) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    StorageUtil.getPreference().edit().putLong("pref_key_banner_ad_popup_last_show_time_millis", System.currentTimeMillis()).putInt("pref_key_banner_ad_current_show_times", 1).apply();
    MiniGameAdBannerPopup.access$300(this.val$adItem, this.val$type, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.3
 * JD-Core Version:    0.7.0.1
 */