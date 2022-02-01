package com.tencent.mobileqq.intervideo.now.dynamic;

import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.manager.TicketManager;

class DynamicNowManager$9
  implements DynamicNowManager.OnGetSkeyListener
{
  DynamicNowManager$9(DynamicNowManager paramDynamicNowManager, LoginData paramLoginData, TicketManager paramTicketManager, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((!DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager, paramInt)) || (TextUtils.isEmpty(paramString)))
    {
      QLog.w("XProxy|NowProxy", 1, "asyn get skey error. retCode: " + paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setSkey(paramString.getBytes());
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setST(this.jdField_a_of_type_MqqManagerTicketManager.getSt(this.jdField_a_of_type_JavaLangString, 16));
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setSTKey(this.jdField_a_of_type_MqqManagerTicketManager.getStkey(this.jdField_a_of_type_JavaLangString, 16));
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setUserId(this.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).b())) || (TextUtils.isEmpty(DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a())))
    {
      NowLive.login(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData);
      return;
    }
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setKey(DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).b().getBytes());
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setAuthAppId("101490787");
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setOriginalId(DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a());
    NowLive.login(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData);
    DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).set(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.9
 * JD-Core Version:    0.7.0.1
 */