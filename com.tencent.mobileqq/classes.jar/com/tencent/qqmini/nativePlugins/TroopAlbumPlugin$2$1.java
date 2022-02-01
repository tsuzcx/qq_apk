package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Context;
import anvx;
import bhdj;
import bkll;
import bkln;
import bklo;
import bklp;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class TroopAlbumPlugin$2$1
  implements Runnable
{
  public TroopAlbumPlugin$2$1(bkln parambkln) {}
  
  public void run()
  {
    bkll.a(this.a.jdField_a_of_type_Bkll, this.a.jdField_a_of_type_JavaLangString);
    Activity localActivity = bkll.e(this.a.jdField_a_of_type_Bkll).getAttachedActivity();
    if (bkll.a(this.a.jdField_a_of_type_Bkll) == null) {
      bkll.a(this.a.jdField_a_of_type_Bkll, bhdj.a(localActivity, 230).setTitle(anvx.a(2131714540)).setMessage(anvx.a(2131714539)).setPositiveButton(anvx.a(2131714538), new bklp(this)).setNegativeButton(localActivity.getString(2131717404), new bklo(this)));
    }
    if (!bkll.a(this.a.jdField_a_of_type_Bkll).isShowing()) {
      bkll.a(this.a.jdField_a_of_type_Bkll).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */