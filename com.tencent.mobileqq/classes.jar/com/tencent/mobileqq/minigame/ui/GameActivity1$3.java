package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.AddColorSignListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameActivity1$3
  extends ColorNoteCurd.OnColorNoteCurdListener
{
  GameActivity1$3(GameActivity1 paramGameActivity1, MiniAppInfo paramMiniAppInfo) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("qqBaseActivity", 1, new Object[] { "[ColorNote exist] serviceType:", Integer.valueOf(paramBundle.getInt("param_service_type")), " subType:", paramBundle.getString("param_sub_type") });
    if (GameActivity1.access$200(this.this$0) != null)
    {
      GameActivity1.access$200(this.this$0).a(paramBoolean);
      GameActivity1.access$202(this.this$0, null);
    }
    this.this$0.doOnBackPressed();
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
    if (this.val$miniAppInfo != null) {}
    for (paramString = new MiniAppConfig(MiniSdkLauncher.convert(this.val$miniAppInfo));; paramString = null)
    {
      if ((0x80000000 & paramInt) != 0)
      {
        if (paramString != null)
        {
          MiniProgramLpReportDC04239.reportAsync(paramString, "addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
          return;
        }
        MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
        return;
      }
      if (paramString != null)
      {
        MiniProgramLpReportDC04239.reportAsync(paramString, "addColorSign", "colorSign_enter", "remove_ColorSign", null);
        return;
      }
      MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.3
 * JD-Core Version:    0.7.0.1
 */