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
    Object localObject2 = "generateThrowableString err";
    Object localObject1 = localObject2;
    try
    {
      new ByteArrayOutputStream();
      localObject1 = localObject2;
      paramString = b(paramThrowable, paramString);
      localObject1 = paramString;
      localObject2 = new StringBuilder();
      localObject1 = paramString;
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = paramString;
      ((StringBuilder)localObject2).append(a(paramThrowable.getStackTrace(), ""));
      localObject1 = paramString;
      paramThrowable = ((StringBuilder)localObject2).toString();
      return paramThrowable;
    }
    catch (IOException paramThrowable)
    {
      label73:
      break label73;
    }
    return localObject1;
  }
  
  private String b(Throwable paramThrowable, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
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
        localStringBuilder.append(paramString);
        localStringBuilder.append(localStackTraceElement);
        localStringBuilder.append("\n");
        i += 1;
      }
      paramArrayOfStackTraceElement = localStringBuilder.toString();
      return paramArrayOfStackTraceElement;
    }
    catch (Exception paramArrayOfStackTraceElement)
    {
      label64:
      break label64;
    }
    return "generateStackTraceString err";
  }
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new CustomLogBuilder.2(this, new CustomLogBuilder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log.CustomLogBuilder
 * JD-Core Version:    0.7.0.1
 */