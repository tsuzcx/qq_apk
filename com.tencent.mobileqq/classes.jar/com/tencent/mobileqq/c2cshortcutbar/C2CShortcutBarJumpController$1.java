package com.tencent.mobileqq.c2cshortcutbar;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreController.IStoreItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class C2CShortcutBarJumpController$1
  implements C2CShortcutBarStoreController.IStoreItemClickListener
{
  C2CShortcutBarJumpController$1(C2CShortcutBarJumpController paramC2CShortcutBarJumpController, Activity paramActivity, AIOShortcutBarContext paramAIOShortcutBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void a(int paramInt, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    this.e.a(this.a, this.b, this.c, this.d, paramC2CShortcutAppInfo, false);
    QQAppInterface localQQAppInterface = this.c;
    int i = C2CShortcutBarManager.a(localQQAppInterface).a(this.d.b);
    paramC2CShortcutAppInfo = paramC2CShortcutAppInfo.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B32D", "0X800B32D", i, 0, paramC2CShortcutAppInfo, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarJumpController.1
 * JD-Core Version:    0.7.0.1
 */