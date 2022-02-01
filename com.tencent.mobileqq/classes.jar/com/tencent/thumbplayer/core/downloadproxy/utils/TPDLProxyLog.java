package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.util.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog
{
  private static ITPDLProxyLogListener mLogListener;
  private static int mServiceType;
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = mLogListener;
    if (localObject != null)
    {
      ((ITPDLProxyLogListener)localObject).d(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("][");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    Log.d(((StringBuilder)localObject).toString(), paramString3);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = mLogListener;
    if (localObject != null)
    {
      ((ITPDLProxyLogListener)localObject).e(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("][");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    Log.e(((StringBuilder)localObject).toString(), paramString3);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = mLogListener;
    if (localObject != null)
    {
      ((ITPDLProxyLogListener)localObject).i(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("][");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    Log.i(((StringBuilder)localObject).toString(), paramString3);
  }
  
  public static void setLogListener(int paramInt, ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    mServiceType = paramInt;
    mLogListener = paramITPDLProxyLogListener;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = mLogListener;
    if (localObject != null)
    {
      ((ITPDLProxyLogListener)localObject).w(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("][");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    Log.w(((StringBuilder)localObject).toString(), paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog
 * JD-Core Version:    0.7.0.1
 */