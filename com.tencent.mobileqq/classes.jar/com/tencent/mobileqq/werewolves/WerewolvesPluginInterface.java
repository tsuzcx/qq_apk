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
  Context jdField_a_of_type_AndroidContentContext;
  WerewolvesHostInterface jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface;
  Class jdField_a_of_type_JavaLangClass;
  ClassLoader jdField_a_of_type_JavaLangClassLoader;
  Object jdField_a_of_type_JavaLangObject;
  Method jdField_a_of_type_JavaLangReflectMethod = null;
  boolean jdField_a_of_type_Boolean = false;
  Class jdField_b_of_type_JavaLangClass;
  Object jdField_b_of_type_JavaLangObject;
  Method jdField_b_of_type_JavaLangReflectMethod;
  Method c = null;
  Method d = null;
  Method e = null;
  Method f = null;
  Method g = null;
  Method h = null;
  Method i = null;
  Method j = null;
  Method k = null;
  Method l;
  Method m = null;
  Method n = null;
  Method o;
  Method p;
  Method q;
  Method r;
  Method s = null;
  Method t = null;
  Method u;
  Method v;
  Method w;
  Method x;
  Method y;
  
  public WerewolvesPluginInterface(WerewolvesPluginManager paramWerewolvesPluginManager, ClassLoader paramClassLoader)
  {
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface = new WerewolvesHostInterface(paramWerewolvesPluginManager);
    a(paramWerewolvesPluginManager.a.a);
  }
  
  public int a()
  {
    try
    {
      int i1 = ((Integer)this.w.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurRoomNumber Failed:", localException);
    }
    return 10;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.n.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString });
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
  
  public ArrayList<String> a()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.o.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
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
  
  public HashMap<String, Integer> a()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.q.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:d	Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: getfield 101	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokevirtual 107	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: goto +33 -> 49
    //   19: astore_1
    //   20: goto +35 -> 55
    //   23: astore_1
    //   24: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +22 -> 49
    //   30: ldc 114
    //   32: iconst_2
    //   33: ldc 157
    //   35: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: ldc 114
    //   40: iconst_2
    //   41: aload_1
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 159	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   54: return
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 159	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
      if (this.y != null)
      {
        this.y.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
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
      this.jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt), paramObject });
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangClass = ReflectUtils.a(this.jdField_a_of_type_JavaLangClassLoader, "com.tencent.mobileqq.werewolves.PluginRuntime");
    this.jdField_b_of_type_JavaLangClass = ReflectUtils.a(this.jdField_a_of_type_JavaLangClassLoader, "com.tencent.mobileqq.werewolves.PluginInterface");
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_JavaLangObject = ReflectUtils.a(this.jdField_a_of_type_JavaLangClass, "getRuntime", null).invoke(null, null);
      }
      ReflectUtils.a(this.jdField_a_of_type_JavaLangClass, "initFromHost", new Class[] { Object.class, Context.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface, paramContext });
      this.jdField_b_of_type_JavaLangObject = ReflectUtils.a(this.jdField_a_of_type_JavaLangClass, "getPlulginInterface", null).invoke(this.jdField_a_of_type_JavaLangObject, null);
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "init failed");
        QLog.e("WereWolfPluginInterface", 2, paramContext, new Object[0]);
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramContext = this.jdField_b_of_type_JavaLangClass;
      if (paramContext != null)
      {
        this.jdField_a_of_type_JavaLangReflectMethod = ReflectUtils.a(paramContext, "onReceive", new Class[] { Integer.TYPE, String.class, [B.class });
        this.c = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "attachGameUI", new Class[] { ViewGroup.class, Context.class });
        this.d = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onDestroy", new Class[0]);
        this.f = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "isReady", new Class[0]);
        this.g = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "isPlaying", new Class[0]);
        this.h = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "isDead", new Class[0]);
        this.i = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "canSpeak", new Class[0]);
        this.j = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onFaceDownloaded", new Class[] { String.class, Bitmap.class });
        this.o = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getQuickWords", new Class[0]);
        this.m = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "stopGame", new Class[0]);
        this.k = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "startGame", new Class[] { Integer.TYPE });
        this.l = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "startGameWithType", new Class[] { Integer.TYPE });
        this.n = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getRoomNick", new Class[] { String.class });
        this.p = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onUserSpeakingStateChanged", new Class[] { String.class, Boolean.TYPE });
        this.q = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getAIOColors", new Class[0]);
        this.r = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getAIODrawables", new Class[] { Context.class });
        this.e = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "dettachGameUI", new Class[0]);
        this.s = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onUserLeftAIO", new Class[0]);
        this.t = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onUserEnterAIO", new Class[0]);
        this.u = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onSpeakBtnPressed", new Class[] { Boolean.TYPE });
        this.v = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "startGameForGold", new Class[0]);
        this.x = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getCurZoneId", new Class[0]);
        this.w = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "getCurRoomNumber", new Class[0]);
        this.jdField_b_of_type_JavaLangReflectMethod = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "notify", new Class[] { Integer.TYPE, Object.class });
        this.y = ReflectUtils.a(this.jdField_b_of_type_JavaLangClass, "onPhoneStateChange", new Class[] { Integer.TYPE });
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, ViewPluginContext paramViewPluginContext)
  {
    try
    {
      this.c.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramViewGroup, paramViewPluginContext });
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
      this.j.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString, paramBitmap });
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
      this.p.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
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
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(1), paramString, paramArrayOfByte });
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
      this.u.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public boolean a()
  {
    try
    {
      boolean bool = ((Boolean)this.f.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
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
  
  public int b()
  {
    try
    {
      int i1 = ((Integer)this.x.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurZoneId Failed:", localException);
    }
    return 0;
  }
  
  public HashMap<String, Drawable> b()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.r.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { this.jdField_a_of_type_AndroidContentContext });
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
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:e	Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: getfield 101	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokevirtual 107	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: goto +34 -> 50
    //   19: astore_1
    //   20: goto +36 -> 56
    //   23: astore_1
    //   24: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +23 -> 50
    //   30: ldc 114
    //   32: iconst_2
    //   33: ldc_w 326
    //   36: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: ldc 114
    //   41: iconst_2
    //   42: aload_1
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 159	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: return
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 159	com/tencent/mobileqq/werewolves/WerewolvesPluginInterface:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
  
  public boolean b()
  {
    try
    {
      boolean bool = ((Boolean)this.g.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
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
  
  public void c()
  {
    try
    {
      this.m.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
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
  
  public boolean c()
  {
    try
    {
      boolean bool = ((Boolean)this.h.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
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
  
  public void d()
  {
    try
    {
      this.s.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
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
  
  public boolean d()
  {
    try
    {
      boolean bool = ((Boolean)this.i.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
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
  
  public void e()
  {
    try
    {
      this.t.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
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
  
  public void f()
  {
    try
    {
      this.v.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "startGoldBeanFailed:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginInterface
 * JD-Core Version:    0.7.0.1
 */