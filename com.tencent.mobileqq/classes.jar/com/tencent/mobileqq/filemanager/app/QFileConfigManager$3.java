package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import aqud;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$3
  implements Runnable
{
  public QFileConfigManager$3(aqud paramaqud, Bundle paramBundle) {}
  
  public void run()
  {
    if (!this.a.containsKey("ipv6_all_switch")) {
      return;
    }
    aqud.d(this.this$0, this.a.getBoolean("ipv6_all_switch", false));
    QLog.i("QFileConfigManager", 1, "enableFileIPv6: set ipv6 config. enableFileIPv6[" + aqud.d(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.3
 * JD-Core Version:    0.7.0.1
 */