package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class NightModeLogic$1
  extends ThemeSwitchCallback
{
  NightModeLogic$1(NightModeLogic paramNightModeLogic) {}
  
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a();
    return false;
  }
  
  public void beginSwitch()
  {
    if (NightModeLogic.a(this.this$0) == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)NightModeLogic.a(this.this$0).get())
    {
      if (localActivity != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(localActivity);
      }
      return;
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    int i = 100;
    if (paramLong2 <= 0L)
    {
      QLog.e("NightModeLogic", 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
      i = 4;
    }
    if (paramLong1 <= paramLong2) {
      i = (int)(100.0D * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NightModeLogic", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", allSize:" + paramLong2 + ", percent:" + i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("percent", i);
    localBundle.putInt("start_status", 3);
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, localBundle));
  }
  
  public boolean postSwitch(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_status", 2);
    if (paramInt == 0) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 4099, 1, 0, localBundle));
    }
    for (;;)
    {
      return super.postSwitch(paramInt);
      this.this$0.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.b();
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4100);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.this$0.jdField_a_of_type_AndroidOsHandler, 4099, -2, 0, localBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.1
 * JD-Core Version:    0.7.0.1
 */