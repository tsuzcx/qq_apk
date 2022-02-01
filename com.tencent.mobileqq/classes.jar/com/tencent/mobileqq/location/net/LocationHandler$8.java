package com.tencent.mobileqq.location.net;

import android.content.Intent;
import awpq;
import awqd;
import bdll;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class LocationHandler$8
  implements Runnable
{
  public LocationHandler$8(awpq paramawpq) {}
  
  public void run()
  {
    if (awpq.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "run: invoked. ", " bgHandlerForDelayExitRoomStopped: ", Boolean.valueOf(awpq.a(this.this$0)) });
      }
      return;
    }
    this.this$0.a(awpq.a(this.this$0), true);
    this.this$0.a.a();
    QQToast.a(BaseApplicationImpl.context, this.this$0.app.getApp().getString(2131692856), 0).a();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      String str = localBaseActivity.getIntent().getStringExtra("FRAGMENT_KEY");
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onAppBackground::run: invoked[仅用来关闭地图页]. ", " fragmentKey: ", str });
      }
      if ("LocationShareFragment".equals(str)) {
        localBaseActivity.finish();
      }
    }
    bdll.b(null, "CliOper", "", "", "0X800A8BB", "0X800A8BB", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.8
 * JD-Core Version:    0.7.0.1
 */