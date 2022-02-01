package com.tencent.securemodule.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.aa;
import com.tencent.securemodule.ab;
import com.tencent.securemodule.ae;
import com.tencent.securemodule.ah;
import com.tencent.securemodule.as;
import com.tencent.securemodule.at;
import com.tencent.securemodule.ax;
import com.tencent.securemodule.az;
import com.tencent.securemodule.c;
import com.tencent.securemodule.e;
import com.tencent.securemodule.o;
import com.tencent.securemodule.ui.SecureEventReceiver;
import com.tencent.securemodule.w;
import com.tencent.securemodule.x;
import com.tencent.securemodule.z;
import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecureService
  extends Service
{
  private Context a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private SecureService.a f = new SecureService.a(this);
  
  private int a(String paramString)
  {
    this.b += 1;
    if (paramString == null) {
      return -6;
    }
    Object localObject1 = new UniAttribute();
    ((UniAttribute)localObject1).setEncodeName("UTF-8");
    ((UniAttribute)localObject1).decode(az.b(paramString));
    paramString = (e)((UniAttribute)localObject1).getByClass("data", new e());
    if (paramString != null)
    {
      if (paramString.c() == null) {
        return -6;
      }
      Object localObject2 = paramString.c();
      localObject1 = x.a(this.a.getApplicationContext());
      localObject2 = ((List)localObject2).iterator();
      int i = -2;
      while (((Iterator)localObject2).hasNext())
      {
        int j = ((x)localObject1).a(paramString, (c)((Iterator)localObject2).next());
        i = j;
        if (j != 0) {
          i = j;
        }
      }
      this.b -= 1;
      return i;
    }
    return -6;
  }
  
  private void a()
  {
    this.b += 1;
    new w(this.a).a(new ab(this));
    this.b -= 1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SecureService.class);
    localIntent.setAction(paramString);
    paramContext.startService(localIntent);
  }
  
  private void a(String paramString, Parcelable paramParcelable)
  {
    Intent localIntent;
    if (this.e)
    {
      localIntent = new Intent(paramString);
      paramString = localIntent;
      if (paramParcelable == null) {
        break label65;
      }
      paramString = localIntent;
    }
    else
    {
      localIntent = new Intent();
      localIntent.setClass(this, SecureEventReceiver.class);
      localIntent.setAction(paramString);
      paramString = localIntent;
      if (paramParcelable == null) {
        break label65;
      }
      paramString = localIntent;
    }
    paramString.putExtra("data", paramParcelable);
    label65:
    sendBroadcast(paramString);
  }
  
  private void a(String paramString, Serializable paramSerializable)
  {
    if (!at.a(this.a, 10002, true)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramSerializable != null) {
      localIntent.putExtra("data", paramSerializable);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(ArrayList<o> paramArrayList, int paramInt)
  {
    o localo = new o();
    localo.a = paramInt;
    localo.c = "1";
    localo.b = ((int)(System.currentTimeMillis() / 1000L));
    paramArrayList.add(localo);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      localObject[0] = 48;
      localObject[1] = 49;
      localObject[2] = 50;
      localObject[3] = 51;
      localObject[4] = 52;
      localObject[5] = 53;
      localObject[6] = 54;
      localObject[7] = 55;
      localObject[8] = 56;
      localObject[9] = 57;
      localObject[10] = 65;
      localObject[11] = 66;
      localObject[12] = 67;
      localObject[13] = 68;
      localObject[14] = 69;
      localObject[15] = 70;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void b()
  {
    this.b += 1;
    x localx = x.a(this.a);
    localx.b();
    this.d = localx.a();
    this.b -= 1;
  }
  
  private void b(String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b += 1;
    a("1000024", null);
    Object localObject = new ae(this.a);
    ((ae)localObject).a(new aa(this));
    ((ae)localObject).a(1);
    int i;
    do
    {
      i = ((ae)localObject).a(paramString, false);
    } while (i == -7);
    if (i == 0)
    {
      paramString = ((ae)localObject).b();
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_path", paramString);
      a("1000027", (Parcelable)localObject);
      localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      this.a.startActivity((Intent)localObject);
    }
    this.b -= 1;
    this.c = false;
    this.e = false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      Thread.sleep(500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Process.killProcess(Process.myPid());
    ax.b("myPid", Integer.valueOf(Process.myPid()));
    System.exit(0);
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.qqpimsecure", "com.tencent.qqpimsecure.service.TMSLiteService");
      paramContext.startService(localIntent);
    }
  }
  
  private void d()
  {
    int i = ah.a(this.a).a(as.b(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportRunningProcessInfo ret = ");
    localStringBuilder.append(i);
    ax.b("Secure", localStringBuilder.toString());
  }
  
  private void e()
  {
    boolean bool1 = a(this.a);
    boolean bool2 = b(this.a);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (bool1)
    {
      if (bool2) {
        i = 235002;
      } else {
        i = 235003;
      }
      a(localArrayList, i);
    }
    if ((x.a(this.a).c()) && (bool1) && (!bool2))
    {
      c(this.a);
      try
      {
        Thread.sleep(15000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (b(this.a)) {
        i = 235006;
      } else {
        i = 235007;
      }
      a(localArrayList, i);
    }
    ah.a(this.a).a(localArrayList);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (paramIntent != null)
    {
      if ("1000012".equals(paramIntent.getAction())) {
        return;
      }
      if (!az.a(getApplicationContext(), "sm_mq"))
      {
        stopSelf();
        c();
        return;
      }
      try
      {
        new Thread(new z(this, paramIntent)).start();
        return;
      }
      finally {}
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.b == 0)
    {
      stopSelf();
      c();
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureService
 * JD-Core Version:    0.7.0.1
 */