package com.tencent.mqp.app.sec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bewd;
import com.tencent.qphone.base.util.BaseApplication;

public class MQPSensitiveMsgUtil$3
  implements Runnable
{
  public MQPSensitiveMsgUtil$3(bewd parambewd, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "sp_confirmed_sensmsg_" + bewd.a();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(this.a, this.b);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */