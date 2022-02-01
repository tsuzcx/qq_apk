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
    if ((AudioHelperUtil.c()) && (TextUtils.isEmpty(paramString2)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" getSP, 获取配置需要UIN, uin[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], spName[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("]");
      paramString2 = ((StringBuilder)localObject).toString();
      QLog.w(paramString1, 1, paramString2, new Throwable("打印调用栈"));
      paramString3 = new StringBuilder();
      paramString3.append(paramString1);
      paramString3.append(paramString2);
      throw new IllegalArgumentException(paramString3.toString());
    }
    Object localObject = BaseApplication.getContext();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append(paramString2);
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
      if ((localObject == null) && (AudioHelperUtil.c()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSP, sp为null, uin[");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("], spName[");
        localStringBuilder.append(paramString3);
        localStringBuilder.append("]");
        QLog.w(paramString1, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
      return localObject;
    }
    if (AudioHelperUtil.c())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSP, BaseApplicationImpl为null, uin[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], spName[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramString1, 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.configsp.BaseConfigSP
 * JD-Core Version:    0.7.0.1
 */