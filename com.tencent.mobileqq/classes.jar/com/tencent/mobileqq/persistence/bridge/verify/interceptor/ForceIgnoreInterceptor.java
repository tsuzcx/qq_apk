package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;

public class ForceIgnoreInterceptor
  extends FindTableClassInterceptor
{
  static final String[] a = { "PAReportInfo", "CircleBuddy ", "CircleGroup ", "Sticker", "TopicInfo", "FriendMore", "FreshNewsNotify", "QQCardFolder", "bubble_diytext", "ApolloGameBtnData", "ApolloGameActivityConfig", "CardProfilev2", "SecMsgSession" };
  
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    String str = a(paramChain);
    if (ArrayUtils.a(a, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForceIgnoreInterceptor", 2, "check table with " + str + " is force ignored");
      }
      return null;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.ForceIgnoreInterceptor
 * JD-Core Version:    0.7.0.1
 */