package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Message;
import android.text.TextUtils;
import com.vivo.push.q;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;
import com.vivo.push.util.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class a
  extends q
{
  private static a c;
  private static final List<Integer> e = Arrays.asList(new Integer[] { Integer.valueOf(3) });
  private String d;
  private String f = "";
  private long g;
  
  public static a a()
  {
    try
    {
      if (c == null) {
        c = new a();
      }
      a locala = c;
      return locala;
    }
    finally {}
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString2 = new Intent(paramString2);
      paramString2.setPackage(paramString1);
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext == null) {
          return null;
        }
        paramContext = paramContext.queryBroadcastReceivers(paramString2, 64);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = ((ResolveInfo)paramContext.get(0)).activityInfo.name;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramString1 = new StringBuilder("error  ");
        paramString1.append(paramContext.getMessage());
        o.a("CommandWorker", paramString1.toString());
      }
    }
    return null;
  }
  
  private boolean b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject = this.a.getPackageManager();
    if (this.g <= 0L) {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.vivo.pushservice", 0);
        if (localObject != null)
        {
          this.g = ((PackageInfo)localObject).versionCode;
          localObject = new StringBuilder("push service version:");
          ((StringBuilder)localObject).append(this.g);
          o.a("CommandWorker", ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder("getPackageInfo exception:");
        localStringBuilder2.append(localException.getMessage());
        o.a("CommandWorker", localStringBuilder2.toString());
      }
    }
    if (this.g >= 4040000L)
    {
      paramIntent = paramIntent.getStringExtra("security_avoid_pull");
      if (TextUtils.isEmpty(paramIntent))
      {
        o.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
        return false;
      }
      try
      {
        paramIntent = com.vivo.push.util.a.a(this.a).b(paramIntent);
        if (!"com.vivo.pushservice".equals(paramIntent))
        {
          o.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(paramIntent)));
          return false;
        }
      }
      catch (Exception paramIntent)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("checkIntentIsSecurity Exception: ");
        localStringBuilder1.append(paramIntent.getMessage());
        o.a("CommandWorker", localStringBuilder1.toString());
        return false;
      }
    }
    return true;
  }
  
  public final void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.a != null))
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = paramIntent;
      a((Message)localObject);
      return;
    }
    Object localObject = new StringBuilder(" sendMessage error: intent : ");
    ((StringBuilder)localObject).append(paramIntent);
    ((StringBuilder)localObject).append(", mContext: ");
    ((StringBuilder)localObject).append(this.a);
    o.d("CommandWorker", ((StringBuilder)localObject).toString());
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
  
  public final void b()
  {
    this.d = null;
  }
  
  public final void b(Message paramMessage)
  {
    paramMessage = (Intent)paramMessage.obj;
    if ((paramMessage != null) && (this.a != null))
    {
      if ((!TextUtils.isEmpty(this.f)) && (this.f.contains("CommandService")) && (!b(paramMessage)))
      {
        o.a("CommandWorker", " !checkIntentIsSecurity(intent)");
        return;
      }
      localObject1 = this.a.getPackageName();
      try
      {
        String str = paramMessage.getStringExtra("command_type");
        if ((!TextUtils.isEmpty(str)) && (str.equals("reflect_receiver")))
        {
          int j = paramMessage.getIntExtra("command", -1);
          int i = j;
          if (j < 0) {
            i = paramMessage.getIntExtra("method", -1);
          }
          if ((e.contains(Integer.valueOf(i))) && (s.c(this.a, (String)localObject1)) && (!s.c(this.a)))
          {
            o.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
            return;
          }
          str = paramMessage.getAction();
          if (TextUtils.isEmpty(this.d))
          {
            this.d = a(this.a, (String)localObject1, str);
            if (TextUtils.isEmpty(this.d))
            {
              localObject3 = new StringBuilder(" reflectReceiver error: receiver for: ");
              ((StringBuilder)localObject3).append(str);
              ((StringBuilder)localObject3).append(" not found, package: ");
              ((StringBuilder)localObject3).append((String)localObject1);
              o.d("CommandWorker", ((StringBuilder)localObject3).toString());
              paramMessage.setPackage((String)localObject1);
              this.a.sendBroadcast(paramMessage);
            }
          }
        }
        else
        {
          o.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(str)));
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        o.a("CommandWorker", localException);
        try
        {
          localObject3 = Class.forName(this.d);
          Object localObject2 = ((Class)localObject3).getConstructor(new Class[0]).newInstance(new Object[0]);
          localObject3 = ((Class)localObject3).getMethod("onReceive", new Class[] { Context.class, Intent.class });
          paramMessage.setClassName((String)localObject1, this.d);
          ((Method)localObject3).invoke(localObject2, new Object[] { ContextDelegate.getContext(this.a).getApplicationContext(), paramMessage });
          return;
        }
        catch (Exception paramMessage)
        {
          o.b("CommandWorker", "reflect e: ", paramMessage);
          return;
        }
      }
    }
    Object localObject1 = new StringBuilder(" handleMessage error: intent : ");
    ((StringBuilder)localObject1).append(paramMessage);
    ((StringBuilder)localObject1).append(", mContext: ");
    ((StringBuilder)localObject1).append(this.a);
    o.d("CommandWorker", ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.a
 * JD-Core Version:    0.7.0.1
 */