package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import aqnu;
import bkod;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

class GameActivity1$3
  extends aqnu
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
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
    if ((0x80000000 & paramInt) != 0)
    {
      MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
      return;
    }
    MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.3
 * JD-Core Version:    0.7.0.1
 */