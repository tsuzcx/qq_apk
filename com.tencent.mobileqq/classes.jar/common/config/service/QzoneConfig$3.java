package common.config.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;

class QzoneConfig$3
  extends BroadcastReceiver
{
  QzoneConfig$3(QzoneConfig paramQzoneConfig) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ThreadManagerV2.excute(new QzoneConfig.3.1(this, paramIntent), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.config.service.QzoneConfig.3
 * JD-Core Version:    0.7.0.1
 */