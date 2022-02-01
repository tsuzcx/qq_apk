package com.tencent.mqp.app.sec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

class MQPSensitiveMsgUtil$3
  implements Runnable
{
  MQPSensitiveMsgUtil$3(MQPSensitiveMsgUtil paramMQPSensitiveMsgUtil, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sp_confirmed_sensmsg_");
    ((StringBuilder)localObject).append(MQPSensitiveMsgUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(this.a, this.b);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */