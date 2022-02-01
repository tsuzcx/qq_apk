package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ILiveLoginTicketManager
{
  private DoraemonAPIManager a;
  private QQAppInterface b;
  private String c = "";
  private String d = "";
  
  public ILiveLoginTicketManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public void a(Activity paramActivity, APICallback paramAPICallback)
  {
    Object localObject = paramActivity;
    if (paramActivity == null)
    {
      localObject = paramActivity;
      if (SplashActivity.sWeakInstance != null) {
        localObject = (Activity)SplashActivity.sWeakInstance.get();
      }
    }
    paramActivity = (Activity)localObject;
    if (localObject == null) {
      paramActivity = QBaseActivity.sTopActivity;
    }
    if (paramActivity != null)
    {
      localObject = (IDoraemonService)QRoute.api(IDoraemonService.class);
      ((IDoraemonService)localObject).prepare();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.b.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(System.currentTimeMillis()));
      this.a = ((IDoraemonService)localObject).createAPIManager(paramActivity, 6, "101490787");
    }
    paramActivity = this.a;
    if (paramActivity == null)
    {
      QLog.e("ILiveLoginTicketManager", 1, "requestHostTicketByDoraemon:  doraemonAPIManager is null ");
      return;
    }
    paramActivity.a("loginSilent", null, new ILiveLoginTicketManager.1(this, paramAPICallback));
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.b.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now qq connect auth time diff = ");
    l1 -= l2;
    localStringBuilder.append(l1 / 1000L);
    QLog.d("ILiveLoginTicketManager", 1, localStringBuilder.toString());
    if ((this.a != null) && (l1 <= 1728000000L) && (!StringUtil.isEmpty(this.c)) && (!StringUtil.isEmpty(this.d)))
    {
      QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----No Need request Ticket");
      return false;
    }
    QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----Need request Ticket");
    return true;
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.ILiveLoginTicketManager
 * JD-Core Version:    0.7.0.1
 */