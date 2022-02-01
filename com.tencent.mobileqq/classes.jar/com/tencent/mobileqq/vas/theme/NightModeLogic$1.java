package com.tencent.mobileqq.vas.theme;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class NightModeLogic$1
  extends ThemeSwitchCallback
{
  NightModeLogic$1(NightModeLogic paramNightModeLogic) {}
  
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    this.this$0.b.doScreenShot();
    return false;
  }
  
  public void beginSwitch()
  {
    Activity localActivity;
    if (NightModeLogic.a(this.this$0) == null) {
      localActivity = null;
    } else {
      localActivity = (Activity)NightModeLogic.a(this.this$0).get();
    }
    if (localActivity != null) {
      this.this$0.b.openSwitchDialog(localActivity);
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 <= 0L)
    {
      QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
      i = 4;
    }
    else
    {
      i = 100;
    }
    if (paramLong1 <= paramLong2)
    {
      double d1 = paramLong1;
      Double.isNaN(d1);
      double d2 = paramLong2;
      Double.isNaN(d2);
      i = (int)(d1 * 100.0D / d2);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mThemeDownloadListener onDownloadProgress readSize:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", allSize:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", percent:");
      ((StringBuilder)localObject).append(i);
      QLog.d("NightModeLogic", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("percent", i);
    ((Bundle)localObject).putInt("start_status", 3);
    this.this$0.e.sendMessage(Message.obtain(this.this$0.e, 4099, 1, 0, localObject));
  }
  
  public boolean postSwitch(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_status", 2);
    if (paramInt == 0)
    {
      this.this$0.e.sendMessage(Message.obtain(this.this$0.e, 4099, 1, 0, localBundle));
    }
    else
    {
      this.this$0.b.clearOnErr();
      this.this$0.e.sendEmptyMessage(4100);
      this.this$0.e.sendMessage(Message.obtain(this.this$0.e, 4099, -2, 0, localBundle));
    }
    return super.postSwitch(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.NightModeLogic.1
 * JD-Core Version:    0.7.0.1
 */