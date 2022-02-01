package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomLogBuilder
  implements BaseServiceBuilder
{
  private String a(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length != 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return str;
  }
  
  private String a(Throwable paramThrowable, String paramString)
  {
    String str2 = "generateThrowableString err";
    String str1 = str2;
    try
    {
      new ByteArrayOutputStream();
      str1 = str2;
      paramString = b(paramThrowable, paramString);
      str1 = paramString;
      paramThrowable = paramString + a(paramThrowable.getStackTrace(), "");
      return paramThrowable;
    }
    catch (IOException paramThrowable) {}
    return str1;
  }
  
  private String b(Throwable paramThrowable, String paramString)
  {
    paramString = new StringBuilder().append(paramString);
    paramString.append(": ").append(paramThrowable.getMessage()).append("\n");
    return paramString.toString();
  }
  
  public String a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString).append(localStackTraceElement).append("\n");
        i += 1;
      }
      paramArrayOfStackTraceElement = localStringBuilder.toString();
      return paramArrayOfStackTraceElement;
    }
    catch (Exception paramArrayOfStackTraceElement) {}
    return "generateStackTraceString err";
  }
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new CustomLogBuilder.2(this, new CustomLogBuilder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log.CustomLogBuilder
 * JD-Core Version:    0.7.0.1
 */