package com.tencent.mobileqq.vas.theme;

import android.content.Intent;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class TintManager$1
  implements QuickUpdateListener
{
  TintManager$1(TintManager paramTintManager) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.e("TintManager", 1, "tint config download onCompleted");
    this.a.loadConfig(MobileQQ.getContext().getResources(), TintManager.a(this.a));
    paramString1 = new Intent("com.tencent.qplus.THEME_UPDATE");
    MobileQQ.getContext().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify");
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.TintManager.1
 * JD-Core Version:    0.7.0.1
 */