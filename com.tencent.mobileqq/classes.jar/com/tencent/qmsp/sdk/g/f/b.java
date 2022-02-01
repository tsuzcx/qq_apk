package com.tencent.qmsp.sdk.g.f;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qmsp.sdk.base.c;

public class b
{
  private static final Uri a = Uri.parse("content://cn.nubia.identity/identity");
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = null;
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 17)
      {
        ContentProviderClient localContentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        paramString = localContentProviderClient.call("getAAID", paramString, null);
        paramContext = paramString;
        if (localContentProviderClient != null) {
          if (Build.VERSION.SDK_INT >= 24)
          {
            localContentProviderClient.close();
            paramContext = paramString;
          }
          else
          {
            localContentProviderClient.release();
            paramContext = paramString;
          }
        }
      }
      else
      {
        paramContext = paramContext.getContentResolver().call(a, "getAAID", paramString, null);
      }
      i = paramContext.getInt("code", -1);
      if (i == 0)
      {
        paramString = paramContext.getString("id");
        paramContext = paramString;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        paramContext = paramString;
        localStringBuilder.append("NubiaLog succeed:");
        for (;;)
        {
          paramContext = paramString;
          localStringBuilder.append(paramString);
          break;
          paramString = paramContext.getString("message");
          paramContext = paramString;
          localStringBuilder = new StringBuilder();
          paramContext = paramString;
          localStringBuilder.append("NubiaLog failed:");
        }
        paramContext = paramString;
        c.c(localStringBuilder.toString());
        return paramString;
      }
      catch (Exception paramString) {}
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      paramContext = localStringBuilder;
    }
    return paramContext;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 17)
      {
        ContentProviderClient localContentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        localObject = localContentProviderClient.call("isSupport", null, null);
        paramContext = (Context)localObject;
        if (localContentProviderClient != null) {
          if (Build.VERSION.SDK_INT >= 24)
          {
            localContentProviderClient.close();
            paramContext = (Context)localObject;
          }
          else
          {
            localContentProviderClient.release();
            paramContext = (Context)localObject;
          }
        }
      }
      else
      {
        paramContext = paramContext.getContentResolver().call(a, "isSupport", null, null);
      }
      i = paramContext.getInt("code", -1);
      if (i == 0)
      {
        c.c("NubiaLog succeed");
        boolean bool = paramContext.getBoolean("issupport", true);
        return bool;
      }
      paramContext = paramContext.getString("message");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NubiaLog failed:");
      ((StringBuilder)localObject).append(paramContext);
      c.c(((StringBuilder)localObject).toString());
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = null;
    try
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject;
      if (i >= 17)
      {
        ContentProviderClient localContentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        localObject = localContentProviderClient.call("getOAID", null, null);
        paramContext = (Context)localObject;
        if (localContentProviderClient != null) {
          if (Build.VERSION.SDK_INT >= 24)
          {
            localContentProviderClient.close();
            paramContext = (Context)localObject;
          }
          else
          {
            localContentProviderClient.release();
            paramContext = (Context)localObject;
          }
        }
      }
      else
      {
        paramContext = paramContext.getContentResolver().call(a, "getOAID", null, null);
      }
      i = paramContext.getInt("code", -1);
      if (i == 0)
      {
        localObject = paramContext.getString("id");
        paramContext = (Context)localObject;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        paramContext = (Context)localObject;
        localStringBuilder.append("NubiaLog succeed:");
        for (;;)
        {
          paramContext = (Context)localObject;
          localStringBuilder.append((String)localObject);
          break;
          localObject = paramContext.getString("message");
          paramContext = (Context)localObject;
          localStringBuilder = new StringBuilder();
          paramContext = (Context)localObject;
          localStringBuilder.append("NubiaLog failed:");
        }
        paramContext = (Context)localObject;
        c.c(localStringBuilder.toString());
        return localObject;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramContext = localStringBuilder;
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.f.b
 * JD-Core Version:    0.7.0.1
 */