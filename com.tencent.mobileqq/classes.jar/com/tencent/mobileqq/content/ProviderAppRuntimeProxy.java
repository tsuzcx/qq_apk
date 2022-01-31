package com.tencent.mobileqq.content;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import mqq.app.AppRuntime;

public class ProviderAppRuntimeProxy
{
  SQLiteDatabase a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (!paramBoolean) {
          break label41;
        }
        localObject1 = paramAppRuntime.b(paramString);
      }
    }
    return localObject1;
    label41:
    return paramAppRuntime.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.content.ProviderAppRuntimeProxy
 * JD-Core Version:    0.7.0.1
 */