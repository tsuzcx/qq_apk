package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Context;
import anzj;
import bhlq;
import bhpc;
import bkuw;
import bkuy;
import bkuz;
import bkva;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class TroopAlbumPlugin$2$1
  implements Runnable
{
  public TroopAlbumPlugin$2$1(bkuy parambkuy) {}
  
  public void run()
  {
    bkuw.a(this.a.jdField_a_of_type_Bkuw, this.a.jdField_a_of_type_JavaLangString);
    Activity localActivity = bkuw.e(this.a.jdField_a_of_type_Bkuw).getAttachedActivity();
    if (bkuw.a(this.a.jdField_a_of_type_Bkuw) == null) {
      bkuw.a(this.a.jdField_a_of_type_Bkuw, bhlq.a(localActivity, 230).setTitle(anzj.a(2131713961)).setMessage(anzj.a(2131713960)).setPositiveButton(anzj.a(2131713959), new bkva(this)).setNegativeButton(localActivity.getString(2131716807), new bkuz(this)));
    }
    if (!bkuw.a(this.a.jdField_a_of_type_Bkuw).isShowing()) {
      bkuw.a(this.a.jdField_a_of_type_Bkuw).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */