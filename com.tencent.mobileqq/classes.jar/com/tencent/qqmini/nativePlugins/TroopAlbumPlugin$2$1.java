package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

class TroopAlbumPlugin$2$1
  implements Runnable
{
  TroopAlbumPlugin$2$1(TroopAlbumPlugin.2 param2) {}
  
  public void run()
  {
    TroopAlbumPlugin.a(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin, this.a.jdField_a_of_type_JavaLangString);
    Activity localActivity = TroopAlbumPlugin.e(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin).getAttachedActivity();
    if (TroopAlbumPlugin.a(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin) == null) {
      TroopAlbumPlugin.a(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin, DialogUtil.a(localActivity, 230).setTitle(HardCodeUtil.a(2131715035)).setMessage(HardCodeUtil.a(2131715034)).setPositiveButton(HardCodeUtil.a(2131715033), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131717899), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.a(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin).isShowing()) {
      TroopAlbumPlugin.a(this.a.jdField_a_of_type_ComTencentQqminiNativePluginsTroopAlbumPlugin).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */