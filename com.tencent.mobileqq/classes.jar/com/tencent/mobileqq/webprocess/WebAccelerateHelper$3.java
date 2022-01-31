package com.tencent.mobileqq.webprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mvs;
import nau;

class WebAccelerateHelper$3
  implements Runnable
{
  WebAccelerateHelper$3(WebAccelerateHelper paramWebAccelerateHelper, String paramString) {}
  
  public void run()
  {
    Object localObject1 = CookieManager.getInstance().getCookie(this.val$url);
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "cookie=" + nau.c((String)localObject1, new String[0]));
    }
    boolean bool3 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool2;
    boolean bool1;
    if (!bool3)
    {
      Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject2 != null) && (((AppRuntime)localObject2).isLogin()))
      {
        String str = ((AppRuntime)localObject2).getAccount();
        localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey(str);
        if ((!((String)localObject1).contains("uin")) || (!((String)localObject1).contains(str)))
        {
          bool2 = true;
          if (!mvs.a().a(this.val$url)) {
            break label272;
          }
          if ((((String)localObject1).contains("skey")) && (((String)localObject1).contains((CharSequence)localObject2))) {
            break label183;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if ((!bool3) && (!bool2) && (!bool1))
      {
        return;
        bool2 = false;
        break;
        label183:
        bool1 = false;
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(bool3).append('|');
      ((StringBuilder)localObject1).append(bool2).append('|');
      ((StringBuilder)localObject1).append(bool1).append('|');
      ((StringBuilder)localObject1).append(false);
      VipUtils.a(null, "webview_report", "0X8006117", "0X8006117", 2, 0, new String[] { this.val$url, ((StringBuilder)localObject1).toString() });
      return;
      label272:
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.3
 * JD-Core Version:    0.7.0.1
 */