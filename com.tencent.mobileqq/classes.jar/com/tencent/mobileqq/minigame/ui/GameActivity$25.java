package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import aqrh;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.AddColorSignListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$25
  extends aqrh
{
  GameActivity$25(GameActivity paramGameActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("[minigame] GameActivity", 1, new Object[] { "[ColorNote exist] serviceType:", Integer.valueOf(paramBundle.getInt("param_service_type")), " subType:", paramBundle.getString("param_sub_type") });
    if (GameActivity.access$3800(this.this$0) != null)
    {
      GameActivity.access$3800(this.this$0).onAddColorSign(paramBoolean);
      GameActivity.access$3802(this.this$0, null);
    }
    this.this$0.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.25
 * JD-Core Version:    0.7.0.1
 */