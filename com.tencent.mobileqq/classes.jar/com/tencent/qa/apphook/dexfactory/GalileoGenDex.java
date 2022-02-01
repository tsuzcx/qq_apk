package com.tencent.qa.apphook.dexfactory;

import com.android.dx.DexMaker;
import com.android.dx.TypeId;
import com.tencent.qa.apphook.GalileoBackupMethod;
import com.tencent.qa.apphook.GalileoHookLog;
import com.tencent.qa.apphook.GalileoHookNative;
import com.tencent.qa.apphook.util.GalileoMethodUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public class GalileoGenDex
{
  public static void genMethodInfo(DexMaker paramDexMaker, GalileoBackupMethod paramGalileoBackupMethod, Map<String, TypeId> paramMap)
  {
    Class localClass = paramGalileoBackupMethod.getOriginMethod().getDeclaringClass();
    String str = localClass.getName().replace(".", "_");
    GalileoHookLog.d("startArtHook class name is " + str);
    if (paramMap.get(str) == null)
    {
      TypeId localTypeId = TypeId.get("L" + str + ";");
      GalileoHookLog.d("startArtHook wrapper class name is " + localTypeId.getName());
      if ((Modifier.isFinal(localClass.getModifiers())) || (!GalileoHookNative.isArt())) {
        paramDexMaker.declare(localTypeId, "", 1, TypeId.OBJECT, new TypeId[0]);
      }
      for (;;)
      {
        GalileoMethodUtil.addDefaultInstanceField(paramDexMaker, localTypeId);
        GalileoMethodUtil.addDefaultConstructor(paramDexMaker, localTypeId);
        paramMap.put(str, localTypeId);
        if (!(paramGalileoBackupMethod.getOriginMethod() instanceof Method)) {
          break;
        }
        GalileoMethodUtil.generateMethodFromMethod(paramDexMaker, localTypeId, (Method)paramGalileoBackupMethod.getOriginMethod());
        GalileoMethodUtil.generateInvokerFromMethod(paramDexMaker, localTypeId, (Method)paramGalileoBackupMethod.getOriginMethod());
        return;
        paramDexMaker.declare(localTypeId, "", 1, TypeId.get(localClass), new TypeId[0]);
      }
      GalileoMethodUtil.generateMethodFromConstructor(paramDexMaker, localTypeId, (Constructor)paramGalileoBackupMethod.getOriginMethod());
      GalileoMethodUtil.generateInvokerFromConstructor(paramDexMaker, localTypeId, (Constructor)paramGalileoBackupMethod.getOriginMethod());
      return;
    }
    if ((paramGalileoBackupMethod.getOriginMethod() instanceof Method))
    {
      GalileoMethodUtil.generateMethodFromMethod(paramDexMaker, (TypeId)paramMap.get(str), (Method)paramGalileoBackupMethod.getOriginMethod());
      GalileoMethodUtil.generateInvokerFromMethod(paramDexMaker, (TypeId)paramMap.get(str), (Method)paramGalileoBackupMethod.getOriginMethod());
      return;
    }
    GalileoMethodUtil.generateMethodFromConstructor(paramDexMaker, (TypeId)paramMap.get(str), (Constructor)paramGalileoBackupMethod.getOriginMethod());
    GalileoMethodUtil.generateInvokerFromConstructor(paramDexMaker, (TypeId)paramMap.get(str), (Constructor)paramGalileoBackupMethod.getOriginMethod());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.dexfactory.GalileoGenDex
 * JD-Core Version:    0.7.0.1
 */