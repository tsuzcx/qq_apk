package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameActivity1$1
  implements IServiceInfo
{
  GameActivity1$1(GameActivity1 paramGameActivity1, MiniAppInfo paramMiniAppInfo) {}
  
  public ColorNote getColorNote()
  {
    if (this.val$miniAppInfo == null)
    {
      QLog.e("qqBaseActivity", 1, "getColorNote, miniAppInfo: " + this.val$miniAppInfo);
      return null;
    }
    QLog.d("qqBaseActivity", 2, "getColorNote, appId: " + this.val$miniAppInfo.appId + ", name: " + this.val$miniAppInfo.name + ", colorNoteQueryPath: " + GameActivity1.access$000(this.this$0));
    byte[] arrayOfByte = GameActivity1.access$100(this.this$0, this.val$miniAppInfo, GameActivity1.access$000(this.this$0));
    return new ColorNote.Builder().a(16842752).a(this.val$miniAppInfo.appId + "###" + this.val$miniAppInfo.verType).b(this.val$miniAppInfo.name).c(this.val$miniAppInfo.desc).d(this.val$miniAppInfo.iconUrl).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.1
 * JD-Core Version:    0.7.0.1
 */