package com.tencent.qa.apphook;

import android.content.Context;
import android.text.TextUtils;
import com.android.dx.DexMaker;
import com.taobao.android.dexposed.GalileoHookBridge;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.XC_MethodHook.Unhook;
import com.tencent.qa.apphook.dexfactory.GalileoGenDex;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import java.io.File;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GalileoHookManager
{
  private static ConcurrentHashMap<String, GalileoBackupMethod> hookedMethods = new ConcurrentHashMap();
  private static Context mApplicationContext = null;
  protected static List<GalileoBackupMethod> needHooks = new ArrayList();
  private static File outputDir;
  
  protected static void beginHook(List<GalileoBackupMethod> paramList)
  {
    if (GalileoHookNative.isArt())
    {
      startArtHook(paramList);
      return;
    }
    GalileoHookLog.e("do not support art");
  }
  
  public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> paramClass, Object... paramVarArgs)
  {
    return findAndHookMember(paramClass, null, false, paramVarArgs);
  }
  
  protected static XC_MethodHook.Unhook findAndHookMember(Class<?> paramClass, String paramString, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    Class[] arrayOfClass = GalileoHookHelper.getParameterClasses(paramClass.getClassLoader(), paramVarArgs);
    try
    {
      GalileoBackupMethod localGalileoBackupMethod = new GalileoBackupMethod();
      if (TextUtils.isEmpty(paramString)) {
        localGalileoBackupMethod.setOriginMethod(paramClass.getDeclaredConstructor(GalileoHookHelper.getParameterClasses(paramClass.getClassLoader(), paramVarArgs)));
      }
      for (;;)
      {
        localGalileoBackupMethod.setCallback(localXC_MethodHook);
        localGalileoBackupMethod.setParameterClasses(arrayOfClass);
        localGalileoBackupMethod.setClazz(paramClass);
        needHooks.add(localGalileoBackupMethod);
        localXC_MethodHook.getClass();
        paramClass = new XC_MethodHook.Unhook(localXC_MethodHook, localGalileoBackupMethod.getOriginMethod());
        paramClass.setHookType(2);
        paramClass.setGalileoBackupMethod(localGalileoBackupMethod);
        if (paramBoolean) {
          break;
        }
        beginHook(needHooks);
        break;
        localGalileoBackupMethod.setOriginMethod(paramClass.getDeclaredMethod(paramString, arrayOfClass));
      }
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return findAndHookMember(paramClass, paramString, false, paramVarArgs);
  }
  
  public static void initAndroidHook(Context paramContext)
  {
    mApplicationContext = paramContext.getApplicationContext();
    outputDir = new File(mApplicationContext.getDir("path", 0).getPath());
    GalileoHookHelper.deleteDir(outputDir);
  }
  
  public static Object invoke(String paramString, Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject = (GalileoBackupMethod)hookedMethods.get(paramString);
    if (localObject == null)
    {
      GalileoHookLog.d("GalileoHookManager invoke GalileoBackupMethod is nul ");
      throw new NullPointerException("find back null");
    }
    paramString = (XC_MethodHook)((GalileoBackupMethod)localObject).getCallback();
    localObject = GalileoHookNative.repairMethod(((GalileoBackupMethod)localObject).getOriginMethod(), ((GalileoBackupMethod)localObject).getInvoker(), ((GalileoBackupMethod)localObject).getBackAddr());
    if (localObject == null) {
      throw new NullPointerException("find old Method null");
    }
    GalileoHookLog.d("GalileoHookManager invoke old member name is " + ((Member)localObject).getName());
    return GalileoHookBridge.invoke((Member)localObject, paramString, paramObject, paramArrayOfObject);
  }
  
  public static boolean isHooked(GalileoBackupMethod paramGalileoBackupMethod)
  {
    String str = paramGalileoBackupMethod.getMethodExact();
    if (!TextUtils.isEmpty(str))
    {
      Iterator localIterator = hookedMethods.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (str.equals(((GalileoBackupMethod)localEntry.getValue()).getMethodExact()))
        {
          if (((GalileoBackupMethod)localEntry.getValue()).getCallback() == null) {
            ((GalileoBackupMethod)localEntry.getValue()).setCallback(paramGalileoBackupMethod.getCallback());
          }
          for (;;)
          {
            return true;
            ((GalileoBackupMethod)localEntry.getValue()).setCallback(paramGalileoBackupMethod.getCallback());
          }
        }
      }
    }
    return false;
  }
  
  private static void startArtHook(List<GalileoBackupMethod> paramList)
  {
    if (mApplicationContext == null) {
      throw new NullPointerException("mApplicationContext is null!");
    }
    localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GalileoBackupMethod)((Iterator)localObject1).next();
      if (isHooked((GalileoBackupMethod)localObject2))
      {
        GalileoHookLog.d(((GalileoBackupMethod)localObject2).getOriginMethod().getName() + " is hookedMethod!");
        ((Iterator)localObject1).remove();
      }
    }
    GalileoHookLog.e("methods.size() is " + paramList.size());
    if (paramList.size() <= 0) {
      return;
    }
    try
    {
      localObject1 = new DexMaker();
      localObject2 = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        GalileoGenDex.genMethodInfo((DexMaker)localObject1, (GalileoBackupMethod)localIterator.next(), (Map)localObject2);
      }
      try
      {
        GalileoHookBridge.galileoHook(((DexMaker)localObject1).generateAndLoad(mApplicationContext.getClassLoader(), outputDir), paramList, hookedMethods);
        return;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static void unhookAllMethods()
  {
    Iterator localIterator = needHooks.iterator();
    while (localIterator.hasNext()) {
      ((GalileoBackupMethod)localIterator.next()).setCallback(null);
    }
  }
  
  public static void unhookBackMethod(GalileoBackupMethod paramGalileoBackupMethod)
  {
    String str = paramGalileoBackupMethod.getMethodExact();
    if (!TextUtils.isEmpty(str))
    {
      Iterator localIterator = hookedMethods.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((GalileoBackupMethod)((Map.Entry)localIterator.next()).getValue()).getMethodExact())) {
          paramGalileoBackupMethod.setCallback(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.GalileoHookManager
 * JD-Core Version:    0.7.0.1
 */