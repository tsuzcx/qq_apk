package com.tencent.mobileqq.minigame.ui;

import alsd;
import alsl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.QLog;

class GameActivity$22
  implements alsd
{
  GameActivity$22(GameActivity paramGameActivity) {}
  
  public ColorNote getColorNote()
  {
    if ((this.this$0.gameConfig == null) || (this.this$0.gameConfig.config == null))
    {
      QLog.e("[minigame] GameActivity", 1, "getColorNote, appConfig: " + this.this$0.gameConfig);
      return null;
    }
    byte[] arrayOfByte = MiniAppUtils.packMiniAppInfo(this.this$0.gameConfig.config);
    return new alsl().a(16842752).a(this.this$0.gameConfig.config.appId).b(this.this$0.gameConfig.config.name).c(this.this$0.gameConfig.config.desc).d(this.this$0.gameConfig.config.iconUrl).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.22
 * JD-Core Version:    0.7.0.1
 */