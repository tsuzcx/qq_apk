package com.tencent.qmsp.sdk.g.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class e
{
  public static final e f = new e();
  public d a;
  public String b;
  public String c;
  public final Object d = new Object();
  public ServiceConnection e = new e.a(this);
  
  public String a(Context paramContext, String paramString)
  {
    try
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        if (this.a == null)
        {
          ??? = new Intent();
          ((Intent)???).setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
          ((Intent)???).setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
          if (paramContext.bindService((Intent)???, this.e, 1))
          {
            try
            {
              synchronized (this.d)
              {
                this.d.wait(3000L);
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            throw paramContext;
          }
          ??? = this.a;
          if (??? == null) {}
        }
        else
        {
          try
          {
            paramContext = b(paramContext, paramString);
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        paramContext = "";
        return paramContext;
      }
      throw new IllegalStateException("Cannot run on MainThread");
    }
    finally {}
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getPackageInfo("com.heytap.openid", 0);
      if (Build.VERSION.SDK_INT >= 28)
      {
        if (paramContext == null) {
          break label59;
        }
        if (paramContext.getLongVersionCode() < 1L) {
          return false;
        }
      }
      else
      {
        if (paramContext == null) {
          break label59;
        }
        int i = paramContext.versionCode;
        if (i < 1) {
          return false;
        }
      }
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    label59:
    return false;
  }
  
  public final String b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = paramContext.getPackageName();
    }
    if (TextUtils.isEmpty(this.c))
    {
      Object localObject1 = this.b;
      Object localObject2 = null;
      try
      {
        localObject1 = paramContext.getPackageManager().getPackageInfo((String)localObject1, 64).signatures;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        localObject1 = null;
      }
      paramContext = localObject2;
      if (localObject1 != null)
      {
        paramContext = localObject2;
        if (localObject1.length > 0)
        {
          int i = 0;
          localObject1 = localObject1[0].toByteArray();
          try
          {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
            paramContext = localObject2;
            if (localMessageDigest != null)
            {
              paramContext = localMessageDigest.digest((byte[])localObject1);
              localObject1 = new StringBuilder();
              while (i < paramContext.length)
              {
                ((StringBuilder)localObject1).append(Integer.toHexString(paramContext[i] & 0xFF | 0x100).substring(1, 3));
                i += 1;
              }
              paramContext = ((StringBuilder)localObject1).toString();
            }
          }
          catch (NoSuchAlgorithmException paramContext)
          {
            paramContext.printStackTrace();
            paramContext = localObject2;
          }
        }
      }
      this.c = paramContext;
    }
    paramString = ((d.a.a)this.a).a(this.b, this.c, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.e
 * JD-Core Version:    0.7.0.1
 */