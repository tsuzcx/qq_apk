package com.tencent.qqmini.nativePlugins;

import amtj;
import android.app.Activity;
import android.content.Context;
import bfur;
import bjae;
import bjag;
import bjah;
import bjai;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class TroopAlbumPlugin$2$1
  implements Runnable
{
  public TroopAlbumPlugin$2$1(bjag parambjag) {}
  
  public void run()
  {
    bjae.a(this.a.jdField_a_of_type_Bjae, this.a.jdField_a_of_type_JavaLangString);
    Activity localActivity = bjae.e(this.a.jdField_a_of_type_Bjae).getAttachedActivity();
    if (bjae.a(this.a.jdField_a_of_type_Bjae) == null) {
      bjae.a(this.a.jdField_a_of_type_Bjae, bfur.a(localActivity, 230).setTitle(amtj.a(2131714193)).setMessage(amtj.a(2131714192)).setPositiveButton(amtj.a(2131714191), new bjai(this)).setNegativeButton(localActivity.getString(2131717041), new bjah(this)));
    }
    if (!bjae.a(this.a.jdField_a_of_type_Bjae).isShowing()) {
      bjae.a(this.a.jdField_a_of_type_Bjae).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */