package com.tencent.mobileqq.location.net;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class LocationHandler$3
  implements Runnable
{
  LocationHandler$3(LocationHandler paramLocationHandler) {}
  
  public void run()
  {
    if (LocationHandler.b(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "run: invoked. ", " bgHandlerForDelayExitRoomStopped: ", Boolean.valueOf(LocationHandler.b(this.this$0)) });
      }
      return;
    }
    LocationShareLocationManager.a().a(LocationShareRoomManager.a().a, true);
    LocationShareRoomManager.a().c.a();
    QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getString(2131890657), 0).show();
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null)
    {
      String str = localQBaseActivity.getIntent().getStringExtra("FRAGMENT_KEY");
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onAppBackground::run: invoked[仅用来关闭地图页]. ", " fragmentKey: ", str });
      }
      if ("LocationShareFragment".equals(str)) {
        localQBaseActivity.finish();
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X800A8BB", "0X800A8BB", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.3
 * JD-Core Version:    0.7.0.1
 */