package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileConfigManager$3
  implements Runnable
{
  QFileConfigManager$3(QFileConfigManager paramQFileConfigManager, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFileIPv6Config[");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append("]");
    QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    if (this.a.containsKey("ipv6_all_switch")) {
      QFileConfigManager.e(this.this$0, this.a.getBoolean("ipv6_all_switch", false));
    }
    if (this.a.containsKey("ipv6_c2c_switch")) {
      QFileConfigManager.f(this.this$0, this.a.getBoolean("ipv6_c2c_switch", false));
    }
    if (this.a.containsKey("ipv6_group_switch")) {
      QFileConfigManager.g(this.this$0, this.a.getBoolean("ipv6_group_switch", false));
    }
    if (this.a.containsKey("ipv6_disc_switch")) {
      QFileConfigManager.h(this.this$0, this.a.getBoolean("ipv6_disc_switch", false));
    }
    if (this.a.containsKey("ipv6_dataline_switch")) {
      QFileConfigManager.i(this.this$0, this.a.getBoolean("ipv6_dataline_switch", false));
    }
    if (this.a.containsKey("ipv6_strategy")) {
      QFileConfigManager.a(this.this$0, this.a.getInt("ipv6_strategy", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.3
 * JD-Core Version:    0.7.0.1
 */