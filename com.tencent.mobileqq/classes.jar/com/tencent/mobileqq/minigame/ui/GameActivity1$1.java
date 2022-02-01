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
    Object localObject2 = this.val$miniAppInfo;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getColorNote, miniAppInfo: ");
      ((StringBuilder)localObject1).append(this.val$miniAppInfo);
      QLog.e("qqBaseActivity", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getColorNote, appId: ");
    ((StringBuilder)localObject2).append(this.val$miniAppInfo.appId);
    ((StringBuilder)localObject2).append(", name: ");
    ((StringBuilder)localObject2).append(this.val$miniAppInfo.name);
    ((StringBuilder)localObject2).append(", colorNoteQueryPath: ");
    ((StringBuilder)localObject2).append(GameActivity1.access$000(this.this$0));
    QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject2).toString());
    if (GameActivity1.access$000(this.this$0) != null) {
      localObject1 = GameActivity1.access$000(this.this$0).getBytes();
    }
    localObject2 = new ColorNote.Builder().a(16842752);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$miniAppInfo.appId);
    localStringBuilder.append("#@#");
    localStringBuilder.append(this.val$miniAppInfo.verType);
    return ((ColorNote.Builder)localObject2).a(localStringBuilder.toString()).b(this.val$miniAppInfo.name).c(this.val$miniAppInfo.desc).d(this.val$miniAppInfo.iconUrl).a((byte[])localObject1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.1
 * JD-Core Version:    0.7.0.1
 */