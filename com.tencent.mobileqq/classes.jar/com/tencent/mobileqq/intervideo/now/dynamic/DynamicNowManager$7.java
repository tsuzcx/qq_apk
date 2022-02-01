package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.qphone.base.util.QLog;

class DynamicNowManager$7
  implements ILiveLoginTicketListener
{
  DynamicNowManager$7(DynamicNowManager paramDynamicNowManager, Bundle paramBundle) {}
  
  public void a(int paramInt, IBizLoginObserver paramIBizLoginObserver)
  {
    QLog.i("DynamicNowManager", 1, "Recv Refresh Token Reqest");
    DynamicNowManager.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicDynamicNowManager).a(null, new DynamicNowManager.7.1(this, paramIBizLoginObserver));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(LoginResult paramLoginResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.7
 * JD-Core Version:    0.7.0.1
 */