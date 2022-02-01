package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import aqce;
import bjwg;
import com.tencent.qphone.base.util.QLog;

class GameActivity1$3
  extends aqce
{
  GameActivity1$3(GameActivity1 paramGameActivity1) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("qqBaseActivity", 1, new Object[] { "[ColorNote exist] serviceType:", Integer.valueOf(paramBundle.getInt("param_service_type")), " subType:", paramBundle.getString("param_sub_type") });
    if (GameActivity1.access$100(this.this$0) != null)
    {
      GameActivity1.access$100(this.this$0).a(paramBoolean);
      GameActivity1.access$102(this.this$0, null);
    }
    this.this$0.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.3
 * JD-Core Version:    0.7.0.1
 */