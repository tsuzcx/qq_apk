package com.tencent.mobileqq.location.net;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class LocationHandler$8
  implements Runnable
{
  LocationHandler$8(LocationHandler paramLocationHandler) {}
  
  public void run()
  {
    if (LocationHandler.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "run: invoked. ", " bgHandlerForDelayExitRoomStopped: ", Boolean.valueOf(LocationHandler.a(this.this$0)) });
      }
      return;
    }
    this.this$0.a(LocationHandler.a(this.this$0), true);
    this.this$0.a.a();
    QQToast.a(BaseApplication.getContext(), BaseApplication.getContext().getString(2131693159), 0).a();
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
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.8
 * JD-Core Version:    0.7.0.1
 */