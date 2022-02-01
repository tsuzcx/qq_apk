package com.tencent.yahfa.apphook.classfactory;

import com.android.dx.DexMaker;
import com.android.dx.TypeId;
import com.tencent.yahfa.apphook.YahfaLog;
import com.tencent.yahfa.apphook.YahfaMethodUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GenedClassInfoDexMaker
{
  public static void initGenedClass(DexMaker paramDexMaker, String paramString, HookedMethodInfo paramHookedMethodInfo)
  {
    boolean bool = true;
    paramString = TypeId.get(paramString);
    YahfaLog.d("initGenedClass wrapper class name is " + paramString.getName());
    paramDexMaker.declare(paramString, "", 1, TypeId.OBJECT, new TypeId[0]);
    YahfaMethodUtil.addDefaultConstructor(paramDexMaker, paramString);
    if ((paramHookedMethodInfo.getMember() instanceof Method))
    {
      paramHookedMethodInfo = paramHookedMethodInfo.getMethod();
      if ((Modifier.isPublic(paramHookedMethodInfo.getModifiers())) && (Modifier.isStatic(paramHookedMethodInfo.getModifiers()))) {}
      for (;;)
      {
        if (bool) {
          YahfaLog.d("initGenedClass " + paramHookedMethodInfo.getName() + " is Public Static Method ");
        }
        YahfaMethodUtil.generateBackupMethod(paramDexMaker, paramString, paramHookedMethodInfo, "backup", bool);
        YahfaMethodUtil.generateMethod(paramDexMaker, paramString, paramHookedMethodInfo, "replace", bool);
        return;
        bool = false;
      }
    }
    YahfaMethodUtil.generateMethodFromConstructor(paramDexMaker, paramString, paramHookedMethodInfo.getConstructor());
    YahfaMethodUtil.generateInvokerFromConstructor(paramDexMaker, paramString, paramHookedMethodInfo.getConstructor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.classfactory.GenedClassInfoDexMaker
 * JD-Core Version:    0.7.0.1
 */