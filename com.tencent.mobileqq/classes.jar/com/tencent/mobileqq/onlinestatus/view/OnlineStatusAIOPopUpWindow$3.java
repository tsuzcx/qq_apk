package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnStatusChangeByUserListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class OnlineStatusAIOPopUpWindow$3
  implements IAccountPanel.OnStatusChangeByUserListener
{
  OnlineStatusAIOPopUpWindow$3(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void a(String paramString)
  {
    if (OnlineStatusAIOPopUpWindow.a(this.a).isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusAIOPopUpWindow", 2, "close panel onStatueChanged");
      }
      ReportHelperKt.a("0X800BBE0", 0, "0", paramString);
      paramString = MobileQQ.sMobileQQ.getResources().getString(2131698509, new Object[] { paramString });
      QQToast.a(MobileQQ.sMobileQQ, 2, paramString, 1).a();
      if (TextUtils.equals(OnlineStatusAIOPopUpWindow.a(this.a).uin, OnlineStatusAIOPopUpWindow.a(this.a).getCurrentUin())) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new OnlineStatusAIOPopUpWindow.3.1(this), 500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.3
 * JD-Core Version:    0.7.0.1
 */