package cooperation.qqdataline.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qqdataline.QQProxyForDataline;

class DatalineRemoteManager$12
  implements Runnable
{
  DatalineRemoteManager$12(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", true);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(BaseActivity.sTopActivity, localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130772014, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.12
 * JD-Core Version:    0.7.0.1
 */