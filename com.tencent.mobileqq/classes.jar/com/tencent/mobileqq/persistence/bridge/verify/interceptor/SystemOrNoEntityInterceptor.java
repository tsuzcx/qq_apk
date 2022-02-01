package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;

public class SystemOrNoEntityInterceptor
  extends FindTableClassInterceptor
{
  private final String[] a = { "android_metadata", "sqlite_sequence" };
  private final String[] b = { "msg_sync_log", "msg_upgrade_log" };
  
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    String str = a(paramChain);
    if ((!ArrayUtils.a(this.a, str)) && (!ArrayUtils.a(this.b, str))) {
      return (Class)paramChain.proceed();
    }
    if (QLog.isColorLevel())
    {
      paramChain = new StringBuilder();
      paramChain.append("check table with ");
      paramChain.append(str);
      paramChain.append(" is system or no entity table");
      QLog.d("SystemOrNoEntityInterceptor", 2, paramChain.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.SystemOrNoEntityInterceptor
 * JD-Core Version:    0.7.0.1
 */