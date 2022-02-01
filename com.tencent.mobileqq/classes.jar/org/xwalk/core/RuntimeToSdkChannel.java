package org.xwalk.core;

import android.text.TextUtils;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.s;

public class RuntimeToSdkChannel
{
  public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
  public static final String KEY_GET_CONFIG_CMD_EXTEND = "GET_CONFIG_CMD_EXTEND";
  public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
  public static final String KEY_REPORT_JAVA_EXCEPTION = "REPORT_JAVA_EXCEPTION";
  public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";
  public static final String KEY_XPROFILE_RESULT_FORWARD_TO_SDK = "KEY_XPROFILE_RESULT_FORWARD_TO_SDK";
  public static final String KEY_XPROFILE_TRACING_FRAME_COST_RESULT = "KEY_XPROFILE_TRACING_FRAME_COST_RESULT";
  
  public static void initRuntimeToSdkChannel()
  {
    try
    {
      XWalkCoreWrapper localXWalkCoreWrapper = XWalkCoreWrapper.getInstance();
      if (localXWalkCoreWrapper == null) {
        return;
      }
      XWalkCoreWrapper.getInstance();
      XWalkCoreWrapper.invokeRuntimeChannel(80005, new Object[] { new RuntimeToSdkChannel.1() });
      return;
    }
    finally {}
  }
  
  public static Object onRuntimeCalled(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2069614781: 
      if (paramString.equals("REPORT_JAVA_EXCEPTION")) {
        i = 4;
      }
      break;
    case 1291018756: 
      if (paramString.equals("KEY_XPROFILE_RESULT_FORWARD_TO_SDK")) {
        i = 5;
      }
      break;
    case 886431819: 
      if (paramString.equals("INVOKE_STATIC_METHOD")) {
        i = 3;
      }
      break;
    case 59342662: 
      if (paramString.equals("GET_CONFIG_CMD")) {
        i = 0;
      }
      break;
    case 51739140: 
      if (paramString.equals("INVOKE_INSTANCE_METHOD")) {
        i = 2;
      }
      break;
    case -648440269: 
      if (paramString.equals("GET_CONFIG_CMD_EXTEND")) {
        i = 1;
      }
      break;
    case -1744471054: 
      if (paramString.equals("KEY_XPROFILE_TRACING_FRAME_COST_RESULT")) {
        i = 6;
      }
      break;
    }
    int i = -1;
    String str;
    switch (i)
    {
    default: 
      return null;
    case 5: 
    case 6: 
      s.b().a(paramObject);
      return null;
    case 4: 
      if (!(paramObject instanceof Object[])) {
        return null;
      }
      paramString = (Object[])paramObject;
      if (paramString.length < 1) {
        return null;
      }
      if (!(paramString[0] instanceof Throwable)) {
        return null;
      }
      paramString = (Throwable)paramString[0];
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramString);
      return null;
    case 3: 
      if (!(paramObject instanceof Object[])) {
        return null;
      }
      paramString = (Object[])paramObject;
      if (paramString != null)
      {
        if (paramString.length < 2) {
          return null;
        }
        if (!(paramString[0] instanceof String)) {
          return null;
        }
        if (!(paramString[1] instanceof String)) {
          return null;
        }
        paramObject = (String)paramString[0];
        str = (String)paramString[1];
        if (2 == paramString.length) {
          return g.a(paramObject, str);
        }
        if (4 == paramString.length)
        {
          if (!(paramString[2] instanceof Class[])) {
            return g.a(paramObject, str);
          }
          if (!(paramString[3] instanceof Object[])) {
            return g.a(paramObject, str);
          }
          return g.a(paramObject, str, (Class[])paramString[2], (Object[])paramString[3]);
        }
        return g.a(paramObject, str);
      }
      return null;
    case 2: 
      if (!(paramObject instanceof Object[])) {
        return null;
      }
      paramObject = (Object[])paramObject;
      if (paramObject != null)
      {
        if (paramObject.length < 2) {
          return null;
        }
        if (!(paramObject[0] instanceof Object)) {
          return null;
        }
        if (!(paramObject[1] instanceof String)) {
          return null;
        }
        paramString = paramObject[0];
        if ((paramObject[0] instanceof String)) {
          paramString = g.a((String)paramObject[0]);
        }
        if (paramString == null) {
          return null;
        }
        str = (String)paramObject[1];
        if (2 == paramObject.length) {
          return g.a(paramString, str);
        }
        if (4 == paramObject.length)
        {
          if (!(paramObject[2] instanceof Class[])) {
            return g.a(paramString, str);
          }
          if (!(paramObject[3] instanceof Object[])) {
            return g.a(paramString, str);
          }
          return g.a(paramString, str, (Class[])paramObject[2], (Object[])paramObject[3]);
        }
        return g.a(paramString, str);
      }
      return null;
    case 1: 
      if (!(paramObject instanceof String[])) {
        return "";
      }
      paramString = (String[])paramObject;
      if (paramString.length < 2) {
        return "";
      }
      if (TextUtils.isEmpty(paramString[1])) {
        return b.o(paramString[0]);
      }
      return b.c(paramString[0], paramString[1]);
    }
    if (!(paramObject instanceof String[])) {
      return "";
    }
    paramString = (String[])paramObject;
    if (paramString.length < 2) {
      return "";
    }
    if (TextUtils.isEmpty(paramString[1])) {
      return a.g(paramString[0]);
    }
    return a.a(paramString[0], paramString[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.RuntimeToSdkChannel
 * JD-Core Version:    0.7.0.1
 */