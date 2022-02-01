package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
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
    if ((paramActivity == null) && (SplashActivity.sWeakInstance != null)) {
      paramActivity = (Activity)SplashActivity.sWeakInstance.get();
    }
    for (;;)
    {
      Object localObject = paramActivity;
      if (paramActivity == null) {
        localObject = QBaseActivity.sTopActivity;
      }
      if (localObject != null)
      {
        DoraemonOpenAPI.a();
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = DoraemonOpenAPI.a((Activity)localObject, 6, "101490787");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager == null)
      {
        QLog.e("ILiveLoginTicketManager", 1, "requestHostTicketByDoraemon:  doraemonAPIManager is null ");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new ILiveLoginTicketManager.1(this, paramAPICallback));
      return;
    }
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    QLog.d("ILiveLoginTicketManager", 1, "now qq connect auth time diff = " + (l1 - l2) / 1000L);
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager == null) || (l1 - l2 > 1728000000L) || (StringUtil.a(this.jdField_a_of_type_JavaLangString)) || (StringUtil.a(this.b)))
    {
      QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----Need request Ticket");
      return true;
    }
    QLog.i("ILiveLoginTicketManager", 1, "isNeedUpdateTicket----No Need request Ticket");
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.ILiveLoginTicketManager
 * JD-Core Version:    0.7.0.1
 */