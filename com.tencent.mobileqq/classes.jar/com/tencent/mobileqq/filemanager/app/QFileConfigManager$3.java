package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import atsh;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$3
  implements Runnable
{
  public QFileConfigManager$3(atsh paramatsh, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.a == null) {}
    do
    {
      return;
      QLog.i("QFileConfigManager", 1, "setFileIPv6Config[" + this.a.toString() + "]");
      if (this.a.containsKey("ipv6_all_switch")) {
        atsh.e(this.this$0, this.a.getBoolean("ipv6_all_switch", false));
      }
      if (this.a.containsKey("ipv6_c2c_switch")) {
        atsh.f(this.this$0, this.a.getBoolean("ipv6_c2c_switch", false));
      }
      if (this.a.containsKey("ipv6_group_switch")) {
        atsh.g(this.this$0, this.a.getBoolean("ipv6_group_switch", false));
      }
      if (this.a.containsKey("ipv6_disc_switch")) {
        atsh.h(this.this$0, this.a.getBoolean("ipv6_disc_switch", false));
      }
      if (this.a.containsKey("ipv6_dataline_switch")) {
        atsh.i(this.this$0, this.a.getBoolean("ipv6_dataline_switch", false));
      }
    } while (!this.a.containsKey("ipv6_strategy"));
    atsh.a(this.this$0, this.a.getInt("ipv6_strategy", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.3
 * JD-Core Version:    0.7.0.1
 */