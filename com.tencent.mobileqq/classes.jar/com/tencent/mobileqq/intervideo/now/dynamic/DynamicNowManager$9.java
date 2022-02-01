package com.tencent.mobileqq.intervideo.now.dynamic;

import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.manager.TicketManager;

class DynamicNowManager$9
  implements OnGetSkeyListener
{
  DynamicNowManager$9(DynamicNowManager paramDynamicNowManager, LoginData paramLoginData, TicketManager paramTicketManager, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((DynamicNowManager.a(this.d, paramInt)) && (!TextUtils.isEmpty(paramString)))
    {
      this.a.setSkey(paramString.getBytes());
      this.a.setST(this.b.getSt(this.c, 16));
      this.a.setSTKey(this.b.getStkey(this.c, 16));
      this.a.setUserId(this.c);
      if ((!TextUtils.isEmpty(DynamicNowManager.d(this.d).d())) && (!TextUtils.isEmpty(DynamicNowManager.d(this.d).c())))
      {
        this.a.setKey(DynamicNowManager.d(this.d).d().getBytes());
        this.a.setAuthAppId("101490787");
        this.a.setOriginalId(DynamicNowManager.d(this.d).c());
        NowLive.login(this.a);
        DynamicNowManager.e(this.d).set(System.currentTimeMillis());
        return;
      }
      NowLive.login(this.a);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("asyn get skey error. retCode: ");
    paramString.append(paramInt);
    QLog.w("XProxy|NowProxy", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.9
 * JD-Core Version:    0.7.0.1
 */