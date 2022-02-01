package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$1
  extends NearbyCardObserver
{
  LoginWelcomeManager$1(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  public void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    Object localObject1;
    if ((paramBoolean1) && (paramObject != null))
    {
      localObject1 = paramObject.vTempChatSig;
      String str = paramObject.nickname;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onNearbyCardDownload ");
        ((StringBuilder)localObject2).append(paramObject.uin);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(str);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = LoginWelcomeManager.a(this.a).getBundle("request");
      ((Bundle)localObject2).putString("uin", paramObject.uin);
      ((Bundle)localObject2).putByteArray("sig", (byte[])localObject1);
      ((Bundle)localObject2).putString("nick", str);
      ((Bundle)localObject2).putString("tinyId", String.valueOf(paramObject.tinyId));
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onNearbyCardDownload err");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.a.b();
    LoginWelcomeManager.a(this.a).removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.1
 * JD-Core Version:    0.7.0.1
 */