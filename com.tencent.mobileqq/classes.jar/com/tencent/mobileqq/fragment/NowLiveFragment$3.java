package com.tencent.mobileqq.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class NowLiveFragment$3
  implements WtTicketPromise
{
  NowLiveFragment$3(NowLiveFragment paramNowLiveFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "preGetKeyInPreloadService : Done");
      }
      String str = new String((byte[])paramTicket._pskey_map.get("now.qq.com"));
      Object localObject = this.a.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p_skey=");
      localStringBuilder.append(str);
      ((CookieManager)localObject).setCookie("now.qq.com", localStringBuilder.toString());
      CookieSyncManager.getInstance().sync();
      localObject = this.a.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(str);
      ((SharedPreferences.Editor)localObject).putString("pskey", localStringBuilder.toString()).commit();
      this.a.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit().putLong("pskey_t", System.currentTimeMillis()).commit();
      NowLiveFragment.i = new String((byte[])paramTicket._pskey_map.get("now.qq.com"));
    }
    this.a.l.post(new NowLiveFragment.3.1(this));
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGetKeyInPreloadService failed ");
      localStringBuilder.append(paramErrMsg);
      QLog.i("NowLiveFragment", 2, localStringBuilder.toString());
    }
    this.a.l.post(new NowLiveFragment.3.2(this));
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGetKeyInPreloadService timeout!");
      localStringBuilder.append(paramErrMsg);
      QLog.i("NowLiveFragment", 2, localStringBuilder.toString());
    }
    this.a.l.post(new NowLiveFragment.3.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.3
 * JD-Core Version:    0.7.0.1
 */