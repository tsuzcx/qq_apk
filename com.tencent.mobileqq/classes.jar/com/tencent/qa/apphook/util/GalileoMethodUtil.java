package com.tencent.qa.apphook.util;

import android.util.Log;
import com.android.dx.Code;
import com.android.dx.DexMaker;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import com.tencent.qa.apphook.GalileoHookLog;
import com.tencent.qa.apphook.GalileoHookManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class GalileoMethodUtil
  extends CommonMethodUtil
{
  private static TypeId<GalileoMethodUtil> galileoMethodUtilType = TypeId.get(GalileoMethodUtil.class);
  
  public static void addDefaultInstanceField(DexMaker paramDexMaker, TypeId<?> paramTypeId)
  {
    paramDexMaker.declare(paramTypeId.getField(TypeId.INT, "flag"), 1, null);
  }
  
  public static void generateInvokerFromMethod(DexMaker paramDexMaker, TypeId<?> paramTypeId, Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object localObject1 = new TypeId[arrayOfClass.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      localObject1[i] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
      i += 1;
    }
    MethodId localMethodId = paramTypeId.getMethod(TypeId.get(paramMethod.getReturnType()), paramMethod.getName() + "_Invoker", (TypeId[])localObject1);
    Local localLocal3;
    Local localLocal4;
    Local localLocal5;
    Local localLocal6;
    Local localLocal7;
    Local localLocal1;
    Local localLocal9;
    Local localLocal2;
    if (Modifier.isStatic(paramMethod.getModifiers()))
    {
      paramDexMaker = paramDexMaker.declare(localMethodId, 9);
      localLocal3 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal4 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal5 = paramDexMaker.newLocal(TypeId.INT);
      localLocal6 = paramDexMaker.newLocal(TypeId.get([Ljava.lang.Object.class));
      Object localObject2 = paramDexMaker.newLocal(TypeId.INT);
      localLocal7 = paramDexMaker.newLocal(TypeId.INT);
      Local localLocal8 = paramDexMaker.newLocal(TypeId.OBJECT);
      localLocal1 = paramDexMaker.newLocal(TypeId.OBJECT);
      localLocal9 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal2 = paramDexMaker.newLocal(TypeId.get(paramMethod.getReturnType()));
      if (!paramMethod.getReturnType().equals(Void.TYPE)) {
        break label380;
      }
      localObject1 = null;
      label209:
      if (!Modifier.isStatic(paramMethod.getModifiers())) {
        break label396;
      }
      paramTypeId = paramDexMaker.newLocal(paramTypeId);
      paramDexMaker.loadConstant(paramTypeId, null);
      label231:
      paramDexMaker.loadConstant(localLocal9, GalileoHookHelper.genClassName(paramMethod));
      paramDexMaker.loadConstant((Local)localObject2, Integer.valueOf(localMethodId.getParameters().size()));
      paramDexMaker.newArray(localLocal6, (Local)localObject2);
      i = 0;
      label270:
      if (i >= arrayOfClass.length) {
        break label435;
      }
      paramDexMaker.loadConstant(localLocal7, Integer.valueOf(i));
      localObject2 = BasicTypeMethodUtil.getValueFromClass(arrayOfClass[i]);
      if (localObject2 == null) {
        break label405;
      }
      paramDexMaker.invokeStatic((MethodId)localObject2, localLocal8, new Local[] { paramDexMaker.getParameter(i, (TypeId)localMethodId.getParameters().get(i)) });
      paramDexMaker.aput(localLocal6, localLocal7, localLocal8);
    }
    for (;;)
    {
      i += 1;
      break label270;
      if (Modifier.isPrivate(paramMethod.getModifiers())) {}
      for (i = 2;; i = 1)
      {
        paramDexMaker = paramDexMaker.declare(localMethodId, i);
        break;
      }
      label380:
      localObject1 = paramDexMaker.newLocal(BasicTypeMethodUtil.getClassTypeFromClass(paramMethod.getReturnType()));
      break label209;
      label396:
      paramTypeId = paramDexMaker.getThis(paramTypeId);
      break label231;
      label405:
      paramDexMaker.aput(localLocal6, localLocal7, paramDexMaker.getParameter(i, (TypeId)localMethodId.getParameters().get(i)));
    }
    label435:
    paramDexMaker.loadConstant(localLocal3, "androidHook");
    paramDexMaker.loadConstant(localLocal4, "invoke auto class Invoke method ====================");
    paramDexMaker.invokeStatic(TypeId.get(Log.class).getMethod(TypeId.INT, "d", new TypeId[] { TypeId.STRING, TypeId.STRING }), localLocal5, new Local[] { localLocal3, localLocal4 });
    paramDexMaker.invokeStatic(galileoMethodUtilType.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.STRING, TypeId.OBJECT, TypeId.get([Ljava.lang.Object.class) }), localLocal1, new Local[] { localLocal9, paramTypeId, localLocal6 });
    if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramDexMaker.returnVoid();
      return;
    }
    if (BasicTypeMethodUtil.getValueFromClass(paramMethod.getReturnType()) != null)
    {
      paramTypeId = BasicTypeMethodUtil.toValueFromClass(paramMethod.getReturnType());
      paramDexMaker.cast((Local)localObject1, localLocal1);
      paramDexMaker.invokeVirtual(paramTypeId, localLocal2, (Local)localObject1, new Local[0]);
      paramDexMaker.returnValue(localLocal2);
      return;
    }
    paramDexMaker.cast(localLocal2, localLocal1);
    paramDexMaker.returnValue(localLocal2);
  }
  
  public static void generateMethodFromConstructor(DexMaker paramDexMaker, TypeId<?> paramTypeId, Constructor paramConstructor)
  {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    Object localObject = new TypeId[arrayOfClass.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      localObject[i] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
      i += 1;
    }
    localObject = paramTypeId.getConstructor((TypeId[])localObject);
    paramDexMaker = paramDexMaker.declare((MethodId)localObject, 1);
    Local localLocal1 = paramDexMaker.newLocal(TypeId.get([Ljava.lang.Object.class));
    Local localLocal5 = paramDexMaker.newLocal(TypeId.INT);
    Local localLocal2 = paramDexMaker.newLocal(TypeId.INT);
    Local localLocal3 = paramDexMaker.newLocal(TypeId.OBJECT);
    Local localLocal4 = paramDexMaker.newLocal(TypeId.OBJECT);
    paramTypeId = paramDexMaker.getThis(paramTypeId);
    Local localLocal6 = paramDexMaker.newLocal(TypeId.STRING);
    paramDexMaker.loadConstant(localLocal6, paramConstructor.getDeclaringClass().getName().replace(".", "_") + "_" + SignatureUtil.sign(paramConstructor));
    paramDexMaker.invokeDirect(TypeId.OBJECT.getConstructor(new TypeId[0]), null, paramTypeId, new Local[0]);
    paramDexMaker.loadConstant(localLocal5, Integer.valueOf(((MethodId)localObject).getParameters().size()));
    paramDexMaker.newArray(localLocal1, localLocal5);
    i = 0;
    if (i < arrayOfClass.length)
    {
      paramDexMaker.loadConstant(localLocal2, Integer.valueOf(i));
      paramConstructor = BasicTypeMethodUtil.getValueFromClass(arrayOfClass[i]);
      if (paramConstructor != null)
      {
        paramDexMaker.invokeStatic(paramConstructor, localLocal3, new Local[] { paramDexMaker.getParameter(i, (TypeId)((MethodId)localObject).getParameters().get(i)) });
        paramDexMaker.aput(localLocal1, localLocal2, localLocal3);
      }
      for (;;)
      {
        i += 1;
        break;
        paramDexMaker.aput(localLocal1, localLocal2, paramDexMaker.getParameter(i, (TypeId)((MethodId)localObject).getParameters().get(i)));
      }
    }
    paramDexMaker.invokeStatic(galileoMethodUtilType.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.STRING, TypeId.OBJECT, TypeId.get([Ljava.lang.Object.class) }), localLocal4, new Local[] { localLocal6, paramTypeId, localLocal1 });
    paramDexMaker.returnVoid();
  }
  
  public static void generateMethodFromMethod(DexMaker paramDexMaker, TypeId<?> paramTypeId, Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object localObject1 = new TypeId[arrayOfClass.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      localObject1[i] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
      i += 1;
    }
    MethodId localMethodId = paramTypeId.getMethod(TypeId.get(paramMethod.getReturnType()), paramMethod.getName(), (TypeId[])localObject1);
    Local localLocal3;
    Local localLocal4;
    Local localLocal5;
    Local localLocal6;
    Local localLocal7;
    Local localLocal1;
    Local localLocal9;
    Local localLocal2;
    if (Modifier.isStatic(paramMethod.getModifiers()))
    {
      paramDexMaker = paramDexMaker.declare(localMethodId, 9);
      localLocal3 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal4 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal5 = paramDexMaker.newLocal(TypeId.INT);
      localLocal6 = paramDexMaker.newLocal(TypeId.get([Ljava.lang.Object.class));
      Object localObject2 = paramDexMaker.newLocal(TypeId.INT);
      localLocal7 = paramDexMaker.newLocal(TypeId.INT);
      Local localLocal8 = paramDexMaker.newLocal(TypeId.OBJECT);
      localLocal1 = paramDexMaker.newLocal(TypeId.OBJECT);
      localLocal9 = paramDexMaker.newLocal(TypeId.STRING);
      localLocal2 = paramDexMaker.newLocal(TypeId.get(paramMethod.getReturnType()));
      if (!paramMethod.getReturnType().equals(Void.TYPE)) {
        break label362;
      }
      localObject1 = null;
      label191:
      if (!Modifier.isStatic(paramMethod.getModifiers())) {
        break label378;
      }
      paramTypeId = paramDexMaker.newLocal(paramTypeId);
      paramDexMaker.loadConstant(paramTypeId, null);
      label213:
      paramDexMaker.loadConstant(localLocal9, GalileoHookHelper.genClassName(paramMethod));
      paramDexMaker.loadConstant((Local)localObject2, Integer.valueOf(localMethodId.getParameters().size()));
      paramDexMaker.newArray(localLocal6, (Local)localObject2);
      i = 0;
      label252:
      if (i >= arrayOfClass.length) {
        break label417;
      }
      paramDexMaker.loadConstant(localLocal7, Integer.valueOf(i));
      localObject2 = BasicTypeMethodUtil.getValueFromClass(arrayOfClass[i]);
      if (localObject2 == null) {
        break label387;
      }
      paramDexMaker.invokeStatic((MethodId)localObject2, localLocal8, new Local[] { paramDexMaker.getParameter(i, (TypeId)localMethodId.getParameters().get(i)) });
      paramDexMaker.aput(localLocal6, localLocal7, localLocal8);
    }
    for (;;)
    {
      i += 1;
      break label252;
      if (Modifier.isPrivate(paramMethod.getModifiers())) {}
      for (i = 2;; i = 1)
      {
        paramDexMaker = paramDexMaker.declare(localMethodId, i);
        break;
      }
      label362:
      localObject1 = paramDexMaker.newLocal(BasicTypeMethodUtil.getClassTypeFromClass(paramMethod.getReturnType()));
      break label191;
      label378:
      paramTypeId = paramDexMaker.getThis(paramTypeId);
      break label213;
      label387:
      paramDexMaker.aput(localLocal6, localLocal7, paramDexMaker.getParameter(i, (TypeId)localMethodId.getParameters().get(i)));
    }
    label417:
    paramDexMaker.loadConstant(localLocal3, "androidHook");
    paramDexMaker.loadConstant(localLocal4, "invoke auto class new method ====================");
    paramDexMaker.invokeStatic(TypeId.get(Log.class).getMethod(TypeId.INT, "d", new TypeId[] { TypeId.STRING, TypeId.STRING }), localLocal5, new Local[] { localLocal3, localLocal4 });
    paramDexMaker.invokeStatic(galileoMethodUtilType.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.STRING, TypeId.OBJECT, TypeId.get([Ljava.lang.Object.class) }), localLocal1, new Local[] { localLocal9, paramTypeId, localLocal6 });
    if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramDexMaker.returnVoid();
      return;
    }
    if (BasicTypeMethodUtil.getValueFromClass(paramMethod.getReturnType()) != null)
    {
      paramTypeId = BasicTypeMethodUtil.toValueFromClass(paramMethod.getReturnType());
      paramDexMaker.cast((Local)localObject1, localLocal1);
      paramDexMaker.invokeVirtual(paramTypeId, localLocal2, (Local)localObject1, new Local[0]);
      paramDexMaker.returnValue(localLocal2);
      return;
    }
    paramDexMaker.cast(localLocal2, localLocal1);
    paramDexMaker.returnValue(localLocal2);
  }
  
  public static Object invoke(String paramString, Object paramObject, Object[] paramArrayOfObject)
  {
    GalileoHookLog.d("invoke! caller is " + paramString + ",thiz is " + paramObject + ",args is " + paramArrayOfObject);
    return GalileoHookManager.invoke(paramString, paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.GalileoMethodUtil
 * JD-Core Version:    0.7.0.1
 */