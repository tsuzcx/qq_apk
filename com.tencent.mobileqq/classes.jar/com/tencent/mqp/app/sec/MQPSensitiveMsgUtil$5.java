package com.tencent.mqp.app.sec;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;

final class MQPSensitiveMsgUtil$5
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sp_confirmed_sensmsg_");
    ((StringBuilder)localObject1).append(MQPSensitiveMsgUtil.a());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = BaseApplication.getContext();
    int i = 0;
    localObject1 = ((BaseApplication)localObject2).getSharedPreferences((String)localObject1, 0);
    localObject2 = new Bundle();
    while (i < 10)
    {
      String str1 = Integer.toString(i);
      if (((SharedPreferences)localObject1).contains(str1))
      {
        String str2 = ((SharedPreferences)localObject1).getString(str1, null);
        if (!TextUtils.isEmpty(str2)) {
          ((Bundle)localObject2).putString(str2, str1);
        }
      }
      i += 1;
    }
    if (((Bundle)localObject2).size() > 0) {
      MQPSensitiveMsgUtil.a(((Bundle)localObject2).size() - 1);
    }
    MQPSensitiveMsgUtil.a().putBundle(MQPSensitiveMsgUtil.a(), (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.5
 * JD-Core Version:    0.7.0.1
 */