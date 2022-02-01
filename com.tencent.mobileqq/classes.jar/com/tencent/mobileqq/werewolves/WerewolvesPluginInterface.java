package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.biz.viewplugin.ViewPluginLoader;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class WerewolvesPluginInterface
{
  Method A = null;
  Method B = null;
  Method C;
  Method D;
  Method E;
  Method F;
  Method G;
  ClassLoader a;
  Class b;
  Class c;
  Object d;
  Object e;
  WerewolvesHostInterface f;
  boolean g = false;
  Context h;
  Method i = null;
  Method j;
  Method k = null;
  Method l = null;
  Method m = null;
  Method n = null;
  Method o = null;
  Method p = null;
  Method q = null;
  Method r = null;
  Method s = null;
  Method t;
  Method u = null;
  Method v = null;
  Method w;
  Method x;
  Method y;
  Method z;
  
  public WerewolvesPluginInterface(WerewolvesPluginManager paramWerewolvesPluginManager, ClassLoader paramClassLoader)
  {
    this.a = paramClassLoader;
    this.f = new WerewolvesHostInterface(paramWerewolvesPluginManager);
    a(paramWerewolvesPluginManager.a.b);
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.v.invoke(this.e, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getRoomIndex called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:l	Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: getfield 107	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:e	Ljava/lang/Object;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: goto +33 -> 49
    //   19: astore_1
    //   20: goto +35 -> 55
    //   23: astore_1
    //   24: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +22 -> 49
    //   30: ldc 123
    //   32: iconst_2
    //   33: ldc 133
    //   35: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: ldc 123
    //   40: iconst_2
    //   41: aload_1
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 135	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:h	Landroid/content/Context;
    //   54: return
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 135	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:h	Landroid/content/Context;
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	WerewolvesPluginInterface
    //   19	1	1	localObject	Object
    //   23	38	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	16	19	finally
    //   24	49	19	finally
    //   0	16	23	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.G != null)
      {
        this.G.invoke(this.e, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onPhoneStateChange called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    try
    {
      this.j.invoke(this.e, new Object[] { Integer.valueOf(paramInt), paramObject });
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WereWolfPluginInterface", 2, "notify failed", paramObject);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.h = paramContext;
    this.b = ReflectUtils.a(this.a, "com.tencent.mobileqq.werewolves.PluginRuntime");
    this.c = ReflectUtils.a(this.a, "com.tencent.mobileqq.werewolves.PluginInterface");
    try
    {
      if (this.d == null) {
        this.d = ReflectUtils.a(this.b, "getRuntime", null).invoke(null, null);
      }
      ReflectUtils.a(this.b, "initFromHost", new Class[] { Object.class, Context.class }).invoke(this.d, new Object[] { this.f, paramContext });
      this.e = ReflectUtils.a(this.b, "getPlulginInterface", null).invoke(this.d, null);
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "init failed");
        QLog.e("WereWolfPluginInterface", 2, paramContext, new Object[0]);
      }
    }
    if (!this.g)
    {
      paramContext = this.c;
      if (paramContext != null)
      {
        this.i = ReflectUtils.a(paramContext, "onReceive", new Class[] { Integer.TYPE, String.class, [B.class });
        this.k = ReflectUtils.a(this.c, "attachGameUI", new Class[] { ViewGroup.class, Context.class });
        this.l = ReflectUtils.a(this.c, "onDestroy", new Class[0]);
        this.n = ReflectUtils.a(this.c, "isReady", new Class[0]);
        this.o = ReflectUtils.a(this.c, "isPlaying", new Class[0]);
        this.p = ReflectUtils.a(this.c, "isDead", new Class[0]);
        this.q = ReflectUtils.a(this.c, "canSpeak", new Class[0]);
        this.r = ReflectUtils.a(this.c, "onFaceDownloaded", new Class[] { String.class, Bitmap.class });
        this.w = ReflectUtils.a(this.c, "getQuickWords", new Class[0]);
        this.u = ReflectUtils.a(this.c, "stopGame", new Class[0]);
        this.s = ReflectUtils.a(this.c, "startGame", new Class[] { Integer.TYPE });
        this.t = ReflectUtils.a(this.c, "startGameWithType", new Class[] { Integer.TYPE });
        this.v = ReflectUtils.a(this.c, "getRoomNick", new Class[] { String.class });
        this.x = ReflectUtils.a(this.c, "onUserSpeakingStateChanged", new Class[] { String.class, Boolean.TYPE });
        this.y = ReflectUtils.a(this.c, "getAIOColors", new Class[0]);
        this.z = ReflectUtils.a(this.c, "getAIODrawables", new Class[] { Context.class });
        this.m = ReflectUtils.a(this.c, "dettachGameUI", new Class[0]);
        this.A = ReflectUtils.a(this.c, "onUserLeftAIO", new Class[0]);
        this.B = ReflectUtils.a(this.c, "onUserEnterAIO", new Class[0]);
        this.C = ReflectUtils.a(this.c, "onSpeakBtnPressed", new Class[] { Boolean.TYPE });
        this.D = ReflectUtils.a(this.c, "startGameForGold", new Class[0]);
        this.F = ReflectUtils.a(this.c, "getCurZoneId", new Class[0]);
        this.E = ReflectUtils.a(this.c, "getCurRoomNumber", new Class[0]);
        this.j = ReflectUtils.a(this.c, "notify", new Class[] { Integer.TYPE, Object.class });
        this.G = ReflectUtils.a(this.c, "onPhoneStateChange", new Class[] { Integer.TYPE });
        this.g = true;
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, ViewPluginContext paramViewPluginContext)
  {
    try
    {
      this.k.invoke(this.e, new Object[] { paramViewGroup, paramViewPluginContext });
      return;
    }
    catch (Exception paramViewGroup)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "attachGameUI called failed");
        QLog.e("WereWolfPluginInterface", 2, paramViewGroup, new Object[0]);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      this.r.invoke(this.e, new Object[] { paramString, paramBitmap });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onFaceDownloaded called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.x.invoke(this.e, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserSpeakingStateChanged called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.i.invoke(this.e, new Object[] { Integer.valueOf(1), paramString, paramArrayOfByte });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onReceive called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.C.invoke(this.e, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onSpeakBtnPressed called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:m	Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: getfield 107	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:e	Ljava/lang/Object;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: goto +34 -> 50
    //   19: astore_1
    //   20: goto +36 -> 56
    //   23: astore_1
    //   24: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +23 -> 50
    //   30: ldc 123
    //   32: iconst_2
    //   33: ldc_w 287
    //   36: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: ldc 123
    //   41: iconst_2
    //   42: aload_1
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 135	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:h	Landroid/content/Context;
    //   55: return
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 135	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:h	Landroid/content/Context;
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	WerewolvesPluginInterface
    //   19	1	1	localObject	Object
    //   23	39	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	16	19	finally
    //   24	50	19	finally
    //   0	16	23	java/lang/Exception
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = ((Boolean)this.n.invoke(this.e, new Object[0])).booleanValue();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isReady = ");
        localStringBuilder.append(bool);
        QLog.d("WereWolfPluginInterface", 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isReady called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = ((Boolean)this.o.invoke(this.e, new Object[0])).booleanValue();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPlaying = ");
        localStringBuilder.append(bool);
        QLog.d("WereWolfPluginInterface", 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isPlaying called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public boolean e()
  {
    try
    {
      boolean bool = ((Boolean)this.p.invoke(this.e, new Object[0])).booleanValue();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDead = ");
        localStringBuilder.append(bool);
        QLog.d("WereWolfPluginInterface", 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isDead called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public boolean f()
  {
    try
    {
      boolean bool = ((Boolean)this.q.invoke(this.e, new Object[0])).booleanValue();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canSpeak = ");
        localStringBuilder.append(bool);
        QLog.d("WereWolfPluginInterface", 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "canSpeak called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public void g()
  {
    try
    {
      this.u.invoke(this.e, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "stopGame called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
  }
  
  public ArrayList<String> h()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.w.invoke(this.e, new Object[0]);
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getQuickWords called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return null;
  }
  
  public HashMap<String, Integer> i()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.y.invoke(this.e, new Object[0]);
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIOColors called failed", localException);
      }
    }
    return null;
  }
  
  public HashMap<String, Drawable> j()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.z.invoke(this.e, new Object[] { this.h });
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIODrawables called failed", localException);
      }
    }
    return null;
  }
  
  public void k()
  {
    try
    {
      this.A.invoke(this.e, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserLeftAIO called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      localException.printStackTrace();
    }
  }
  
  public void l()
  {
    try
    {
      this.B.invoke(this.e, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserEnterAIO called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
  }
  
  public void m()
  {
    try
    {
      this.D.invoke(this.e, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "startGoldBeanFailed:", localException);
    }
  }
  
  public int n()
  {
    try
    {
      int i1 = ((Integer)this.E.invoke(this.e, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurRoomNumber Failed:", localException);
    }
    return 10;
  }
  
  public int o()
  {
    try
    {
      int i1 = ((Integer)this.F.invoke(this.e, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurZoneId Failed:", localException);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginInterface
 * JD-Core Version:    0.7.0.1
 */