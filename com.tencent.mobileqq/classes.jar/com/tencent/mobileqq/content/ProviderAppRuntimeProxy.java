package com.tencent.mobileqq.content;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import mqq.app.AppRuntime;

public class ProviderAppRuntimeProxy
{
  SQLiteDatabase a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramBoolean) {
        return paramAppRuntime.getReadableDatabase(paramString);
      }
      return paramAppRuntime.getWritableDatabase(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.content.ProviderAppRuntimeProxy
 * JD-Core Version:    0.7.0.1
 */