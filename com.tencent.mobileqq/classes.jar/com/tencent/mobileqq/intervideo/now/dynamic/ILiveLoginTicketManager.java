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
  private DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public ILiveLoginTicketManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
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
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = ((IDoraemonService)localObject).createAPIManager(paramActivity, 6, "101490787");
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
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
    long l2 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now qq connect auth time diff = ");
    l1 -= l2;
    localStringBuilder.append(l1 / 1000L);
    QLog.d("ILiveLoginTicketManager", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager != null) && (l1 <= 1728000000L) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (!StringUtil.a(this.b)))
    {
      QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----No Need request Ticket");
      return false;
    }
    QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----Need request Ticket");
    return true;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.ILiveLoginTicketManager
 * JD-Core Version:    0.7.0.1
 */