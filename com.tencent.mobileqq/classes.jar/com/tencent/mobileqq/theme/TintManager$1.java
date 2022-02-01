package com.tencent.mobileqq.theme;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class TintManager$1
  implements QuickUpdateListener
{
  TintManager$1(TintManager paramTintManager) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.e("TintManager", 1, "tint config download onCompleted");
    this.a.loadConfig(BaseApplicationImpl.getApplication().getResources(), TintManager.a(this.a));
    paramString1 = new Intent("com.tencent.qplus.THEME_UPDATE");
    BaseApplicationImpl.getApplication().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify");
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.TintManager.1
 * JD-Core Version:    0.7.0.1
 */