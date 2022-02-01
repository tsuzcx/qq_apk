package com.tencent.qqperf.opt.vm;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

final class HackVmImpl$1
  implements Runnable
{
  public void run()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_hack_dvm", 4);
    if (HackVmImpl.b == 21) {
      localSharedPreferences.edit().putInt("key_continuous_crash_count", 0);
    }
    localSharedPreferences.edit().putLong("key_last_hack_time", 0L).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.vm.HackVmImpl.1
 * JD-Core Version:    0.7.0.1
 */