package com.tencent.mobileqq.minigame.ui;

import aqoa;
import aqoi;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameActivity1$1
  implements aqoa
{
  GameActivity1$1(GameActivity1 paramGameActivity1, MiniAppInfo paramMiniAppInfo) {}
  
  public ColorNote getColorNote()
  {
    byte[] arrayOfByte = null;
    if (this.val$miniAppInfo == null)
    {
      QLog.e("qqBaseActivity", 1, "getColorNote, miniAppInfo: " + this.val$miniAppInfo);
      return null;
    }
    QLog.d("qqBaseActivity", 2, "getColorNote, appId: " + this.val$miniAppInfo.appId + ", name: " + this.val$miniAppInfo.name + ", colorNoteQueryPath: " + GameActivity1.access$000(this.this$0));
    if (GameActivity1.access$000(this.this$0) != null) {
      arrayOfByte = GameActivity1.access$000(this.this$0).getBytes();
    }
    return new aqoi().a(16842752).a(this.val$miniAppInfo.appId + "." + this.val$miniAppInfo.verType).b(this.val$miniAppInfo.name).c(this.val$miniAppInfo.desc).d(this.val$miniAppInfo.iconUrl).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.1
 * JD-Core Version:    0.7.0.1
 */