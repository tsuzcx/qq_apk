package com.tencent.mobileqq.utils.configsp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;

public class BaseConfigSP
{
  public static SharedPreferences a(String paramString1, String paramString2, String paramString3)
  {
    if ((AudioHelperUtil.b()) && (TextUtils.isEmpty(paramString2)))
    {
      paramString2 = " getSP, 获取配置需要UIN, uin[" + paramString2 + "], spName[" + paramString3 + "]";
      QLog.w(paramString1, 1, paramString2, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(paramString1 + paramString2);
    }
    Object localObject = BaseApplication.getContext();
    if (localObject != null)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences(paramString3 + paramString2, 4);
      if ((localObject == null) && (AudioHelperUtil.b())) {
        QLog.w(paramString1, 1, "getSP, sp为null, uin[" + paramString2 + "], spName[" + paramString3 + "]", new Throwable("打印调用栈"));
      }
      return localObject;
    }
    if (AudioHelperUtil.b()) {
      QLog.w(paramString1, 1, "getSP, BaseApplicationImpl为null, uin[" + paramString2 + "], spName[" + paramString3 + "]", new Throwable("打印调用栈"));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.configsp.BaseConfigSP
 * JD-Core Version:    0.7.0.1
 */