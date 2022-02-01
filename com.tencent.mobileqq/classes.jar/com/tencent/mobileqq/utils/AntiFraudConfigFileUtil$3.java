package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class AntiFraudConfigFileUtil$3
  extends SecSvcObserver
{
  AntiFraudConfigFileUtil$3(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil) {}
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(AntiFraudConfigFileUtil.a(this.a));
    }
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("invalid notification type for onGetUinSafetyWordingConfig:");
        paramBundle.append(Integer.toString(paramInt));
        QLog.d("SecSvcObserver", 2, paramBundle.toString());
      }
      return;
    }
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("config_name");
    localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (TextUtils.equals("SenstiveMessageTipsCfg", str)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.post(new AntiFraudConfigFileUtil.3.1(this, (String)localObject, paramBundle.getInt("effect_time", 0), paramBundle.getString("md5"), paramBundle.getString("download_url")), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3
 * JD-Core Version:    0.7.0.1
 */