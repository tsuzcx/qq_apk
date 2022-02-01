package com.tencent.yahfa.apphook;

import android.content.Context;
import android.os.Build.VERSION;
import com.android.dx.DexMaker;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.XC_MethodHook.Unhook;
import com.taobao.android.dexposed.YahfaHelpers;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import com.tencent.yahfa.apphook.classfactory.GenedClassInfo;
import com.tencent.yahfa.apphook.classfactory.GenedClassInfoDexMaker;
import com.tencent.yahfa.apphook.classfactory.HookedMethodInfo;
import java.io.File;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class YahfaHookManager
{
  private static Context context = null;
  private static HashMap<String, GenedClassInfo> hookedInfo = new HashMap();
  private static boolean isYahfaInit = false;
  private static File outputDir;
  private static final String prefix = "LYahfaHook/YahfaGenedClass_";
  private static int suffix = 0;
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    if (!isYahfaInit)
    {
      isYahfaInit = true;
      YahfaNative.yahfaInit(Build.VERSION.SDK_INT);
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    paramVarArgs = GalileoHookHelper.getParameterClasses(paramClass.getClassLoader(), paramVarArgs);
    if (paramVarArgs != null) {
      try
      {
        paramVarArgs = hookMethod(paramClass.getDeclaredMethod(paramString, paramVarArgs), localXC_MethodHook);
        return paramVarArgs;
      }
      catch (NoSuchMethodException paramVarArgs)
      {
        YahfaLog.e("can not find method:" + paramClass.toString() + "#" + paramString);
        paramVarArgs.printStackTrace();
      }
    }
    return null;
  }
  
  private static XC_MethodHook.Unhook hookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    YahfaLog.d("YahfaHookManager hookMethod method is " + paramMember.getName());
    Object localObject1 = GalileoHookHelper.genClassName(paramMember);
    if (hookedInfo.containsKey(localObject1))
    {
      YahfaLog.v("already hook method:" + paramMember.toString());
      paramMember = (GenedClassInfo)hookedInfo.get(localObject1);
      if (paramMember != null)
      {
        paramMember = paramMember.getHookedMethodInfo();
        if (paramMember != null) {
          paramMember.setCallBack(paramXC_MethodHook);
        }
      }
      return null;
    }
    YahfaHelpers.ensureResolved(paramMember);
    localObject1 = new StringBuilder().append("LYahfaHook/YahfaGenedClass_");
    int i = suffix;
    suffix = i + 1;
    String str = i + ";";
    Object localObject2 = new HookedMethodInfo(paramMember, paramXC_MethodHook);
    localObject1 = new GenedClassInfo(str, (HookedMethodInfo)localObject2);
    DexMaker localDexMaker = new DexMaker();
    GenedClassInfoDexMaker.initGenedClass(localDexMaker, str, (HookedMethodInfo)localObject2);
    try
    {
      if (!((GenedClassInfo)localObject1).initGenedClass(localDexMaker.generateAndLoad(context.getClassLoader(), outputDir)))
      {
        YahfaLog.e("error occured while load class:" + ((GenedClassInfo)localObject1).toString());
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = ((GenedClassInfo)localObject1).getReplace();
      Method localMethod = ((GenedClassInfo)localObject1).getBackup();
      YahfaNative.yahfaHook(paramMember, (Method)localObject2, localMethod);
      YahfaLog.d("YahfaHookManager hookMethod name is " + paramMember.getName() + ",hookMethod is " + paramMember + ",backupMethod is " + localMethod);
      paramXC_MethodHook.getClass();
      paramXC_MethodHook = new XC_MethodHook.Unhook(paramXC_MethodHook, paramMember);
      paramXC_MethodHook.setHookType(3);
      paramXC_MethodHook.setBackupMethod(localMethod);
      hookedInfo.put(GalileoHookHelper.genClassName(paramMember), localObject1);
    }
    return paramXC_MethodHook;
  }
  
  public static void init(Context paramContext)
  {
    context = paramContext.getApplicationContext();
    outputDir = new File(paramContext.getDir("path", 0).getPath());
    GalileoHookHelper.deleteDir(outputDir);
  }
  
  public static Object invoke(String paramString, Object paramObject, Object[] paramArrayOfObject)
  {
    paramString = (GenedClassInfo)hookedInfo.get(paramString);
    if (paramString == null)
    {
      YahfaLog.d("YahfaHookManager invoke method is null ");
      throw new NullPointerException("find back null");
    }
    XC_MethodHook localXC_MethodHook = paramString.getHookedMethodInfo().getCallback();
    return YahfaHelpers.invoke(paramString.getBackup(), localXC_MethodHook, paramObject, paramArrayOfObject);
  }
  
  public static void unhookAllMethods()
  {
    if ((hookedInfo != null) && (hookedInfo.size() > 0))
    {
      Iterator localIterator = hookedInfo.entrySet().iterator();
      while (localIterator.hasNext()) {
        unhookMethod((String)((Map.Entry)localIterator.next()).getKey());
      }
    }
  }
  
  public static void unhookMethod(String paramString)
  {
    if ((hookedInfo != null) && (hookedInfo.containsKey(paramString))) {
      ((GenedClassInfo)hookedInfo.get(paramString)).getHookedMethodInfo().setCallBack(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.YahfaHookManager
 * JD-Core Version:    0.7.0.1
 */