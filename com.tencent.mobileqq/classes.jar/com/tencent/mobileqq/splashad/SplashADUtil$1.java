package com.tencent.mobileqq.splashad;

import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.utils.Tools;
import java.net.HttpURLConnection;
import java.net.URL;

final class SplashADUtil$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Int != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        int i = this.jdField_a_of_type_Int;
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        String str = "";
        if (i != 1)
        {
          if (i != 2)
          {
            localObject1 = localObject2;
            if (i != 3)
            {
              localObject1 = localObject2;
              break label212;
            }
          }
          else
          {
            localObject1 = localObject2;
            if (((String)localObject2).contains("__APP__")) {
              localObject1 = ((String)localObject2).replace("__APP__", MD5Utils.encodeHexStr("android_qq_splash"));
            }
          }
          localObject2 = Tools.b();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            str = MD5Utils.encodeHexStr((String)localObject2);
          }
          localObject2 = localObject1;
          if (((String)localObject1).contains("__OS__")) {
            localObject2 = ((String)localObject1).replace("__OS__", "0");
          }
          localObject1 = localObject2;
          if (((String)localObject2).contains("__IMEI__"))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(str)) {
              localObject1 = ((String)localObject2).replace("__IMEI__", str);
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (((String)localObject2).contains("[timestamp]"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(System.currentTimeMillis());
            ((StringBuilder)localObject1).append("");
            localObject1 = ((String)localObject2).replace("[timestamp]", ((StringBuilder)localObject1).toString());
          }
        }
        label212:
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("exporsure platform = ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", url :");
          ((StringBuilder)localObject2).append(((String)localObject1).toString());
          QLog.d("SplashAD", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        ((HttpURLConnection)localObject1).setRequestMethod("POST");
        ((HttpURLConnection)localObject1).setConnectTimeout(10000);
        ((HttpURLConnection)localObject1).setReadTimeout(10000);
        boolean bool = false;
        ((HttpURLConnection)localObject1).setUseCaches(false);
        ((HttpURLConnection)localObject1).connect();
        i = ((HttpURLConnection)localObject1).getResponseCode();
        if (i == 200) {
          bool = true;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("exporsure rspCode ");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("， request thirdparty");
          ((StringBuilder)localObject1).append(bool);
          QLog.i("SplashAD", 1, ((StringBuilder)localObject1).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("SplashAD", 2, "exporsure failed , adEntry not ready");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SplashAD", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADUtil.1
 * JD-Core Version:    0.7.0.1
 */