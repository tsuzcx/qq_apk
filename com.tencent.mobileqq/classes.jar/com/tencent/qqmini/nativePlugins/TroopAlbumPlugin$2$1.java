package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Context;
import anni;
import bglp;
import bgpa;
import bjtv;
import bjtx;
import bjty;
import bjtz;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class TroopAlbumPlugin$2$1
  implements Runnable
{
  public TroopAlbumPlugin$2$1(bjtx parambjtx) {}
  
  public void run()
  {
    bjtv.a(this.a.jdField_a_of_type_Bjtv, this.a.jdField_a_of_type_JavaLangString);
    Activity localActivity = bjtv.e(this.a.jdField_a_of_type_Bjtv).getAttachedActivity();
    if (bjtv.a(this.a.jdField_a_of_type_Bjtv) == null) {
      bjtv.a(this.a.jdField_a_of_type_Bjtv, bglp.a(localActivity, 230).setTitle(anni.a(2131713852)).setMessage(anni.a(2131713851)).setPositiveButton(anni.a(2131713850), new bjtz(this)).setNegativeButton(localActivity.getString(2131716691), new bjty(this)));
    }
    if (!bjtv.a(this.a.jdField_a_of_type_Bjtv).isShowing()) {
      bjtv.a(this.a.jdField_a_of_type_Bjtv).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */