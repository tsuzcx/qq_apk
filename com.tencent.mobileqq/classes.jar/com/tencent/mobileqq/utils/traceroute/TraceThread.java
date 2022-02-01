package com.tencent.mobileqq.utils.traceroute;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TraceThread
  extends Thread
{
  private int jdField_a_of_type_Int;
  private TraceConstants.TraceMethod jdField_a_of_type_ComTencentMobileqqUtilsTracerouteTraceConstants$TraceMethod;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ping ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" -c ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return c(localStringBuilder.toString());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramString;
    paramString = (Handler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null) {
      paramString.sendMessage(localMessage);
    }
  }
  
  @SuppressLint({"all"})
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/com.tencent.mobileqq/traceroute ");
    localStringBuilder.append(paramString);
    return c(localStringBuilder.toString());
  }
  
  private String c(String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramString);
      localObject1 = localObject2;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      localObject1 = localObject2;
      String str2 = localBufferedReader.readLine();
      paramString = (String)localObject2;
      String str1 = str2;
      if (str2 == null)
      {
        localObject1 = localObject2;
        localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getErrorStream()));
        localObject1 = localObject2;
        str1 = localBufferedReader.readLine();
        paramString = (String)localObject2;
      }
      while (str1 != null)
      {
        localObject1 = paramString;
        localObject2 = new StringBuilder();
        localObject1 = paramString;
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = paramString;
        ((StringBuilder)localObject2).append(str1);
        localObject1 = paramString;
        ((StringBuilder)localObject2).append("\r\n");
        localObject1 = paramString;
        paramString = ((StringBuilder)localObject2).toString();
        localObject1 = paramString;
        str1 = localBufferedReader.readLine();
      }
      localObject1 = paramString;
      localBufferedReader.close();
      localObject1 = paramString;
      localProcess.destroy();
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return localObject1;
  }
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trace-");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      setName(((StringBuilder)localObject).toString());
      localObject = InetAddress.getByName(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsTracerouteTraceConstants$TraceMethod == TraceConstants.TraceMethod.UDP) {
        localObject = b(((InetAddress)localObject).getHostAddress());
      } else {
        localObject = a(this.jdField_a_of_type_JavaLangString);
      }
      if (((String)localObject).length() > 0)
      {
        a((String)localObject, TraceConstants.TraceAction.TRACE_COMPLETE.ordinal());
        return;
      }
      a((String)localObject, TraceConstants.TraceAction.TRACE_ERROR.ordinal());
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    try
    {
      str = localUnknownHostException.getMessage();
    }
    catch (Exception localException)
    {
      String str;
      label115:
      break label115;
    }
    str = "";
    a(str, TraceConstants.TraceAction.TRACE_ERROR.ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.traceroute.TraceThread
 * JD-Core Version:    0.7.0.1
 */