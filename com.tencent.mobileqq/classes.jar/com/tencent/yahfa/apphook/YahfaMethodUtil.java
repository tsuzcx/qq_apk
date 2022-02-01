package com.tencent.yahfa.apphook;

import android.util.Log;
import com.android.dx.Code;
import com.android.dx.DexMaker;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import com.tencent.qa.apphook.util.BasicTypeMethodUtil;
import com.tencent.qa.apphook.util.CommonMethodUtil;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import com.tencent.qa.apphook.util.SignatureUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class YahfaMethodUtil
  extends CommonMethodUtil
{
  private static TypeId<YahfaMethodUtil> yahfaMethodUtilType = TypeId.get(YahfaMethodUtil.class);
  
  public static void generateBackupMethod(DexMaker paramDexMaker, TypeId<?> paramTypeId, Method paramMethod, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    TypeId[] arrayOfTypeId;
    if (paramBoolean)
    {
      arrayOfTypeId = new TypeId[arrayOfClass.length];
      while (i < arrayOfClass.length)
      {
        arrayOfTypeId[i] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
        i += 1;
      }
    }
    for (;;)
    {
      paramDexMaker = paramDexMaker.declare(paramTypeId.getMethod(TypeId.get(paramMethod.getReturnType()), paramString, arrayOfTypeId), 9);
      paramTypeId = paramMethod.getReturnType();
      if (paramTypeId.equals(Void.TYPE))
      {
        paramDexMaker.returnVoid();
        return;
        arrayOfTypeId = new TypeId[arrayOfClass.length + 1];
        arrayOfTypeId[0] = TypeId.get(Object.class);
        i = j;
        while (i < arrayOfClass.length)
        {
          arrayOfTypeId[(i + 1)] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
          i += 1;
        }
      }
      paramTypeId = paramDexMaker.newLocal(TypeId.get(paramTypeId));
      paramDexMaker.loadConstant(paramTypeId, BasicTypeMethodUtil.getDefaultValue(paramMethod.getReturnType()));
      paramDexMaker.returnValue(paramTypeId);
      return;
    }
  }
  
  public static void generateMethod(DexMaker paramDexMaker, TypeId<?> paramTypeId, Method paramMethod, String paramString, boolean paramBoolean)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object localObject1;
    int i;
    if (paramBoolean)
    {
      localObject1 = new TypeId[arrayOfClass.length];
      i = 0;
      while (i < arrayOfClass.length)
      {
        localObject1[i] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
        i += 1;
      }
    }
    for (;;)
    {
      MethodId localMethodId = paramTypeId.getMethod(TypeId.get(paramMethod.getReturnType()), paramString, (TypeId[])localObject1);
      paramTypeId = paramDexMaker.declare(localMethodId, 9);
      Local localLocal4 = paramTypeId.newLocal(TypeId.STRING);
      Local localLocal5 = paramTypeId.newLocal(TypeId.STRING);
      Local localLocal6 = paramTypeId.newLocal(TypeId.INT);
      Local localLocal2 = paramTypeId.newLocal(TypeId.get([Ljava.lang.Object.class));
      Object localObject2 = paramTypeId.newLocal(TypeId.INT);
      Local localLocal7 = paramTypeId.newLocal(TypeId.INT);
      Local localLocal8 = paramTypeId.newLocal(TypeId.OBJECT);
      localObject1 = paramTypeId.newLocal(TypeId.OBJECT);
      Local localLocal3 = paramTypeId.newLocal(TypeId.STRING);
      Local localLocal1 = paramTypeId.newLocal(TypeId.get(paramMethod.getReturnType()));
      Local localLocal9;
      if (paramMethod.getReturnType().equals(Void.TYPE))
      {
        paramDexMaker = null;
        localLocal9 = paramTypeId.newLocal(TypeId.OBJECT);
        paramTypeId.loadConstant(localLocal9, null);
        paramTypeId.loadConstant(localLocal3, GalileoHookHelper.genClassName(paramMethod));
        if (!paramBoolean) {
          break label412;
        }
        paramTypeId.loadConstant((Local)localObject2, Integer.valueOf(localMethodId.getParameters().size()));
        label238:
        paramTypeId.newArray(localLocal2, (Local)localObject2);
        i = 0;
        label249:
        if (i >= arrayOfClass.length) {
          break label562;
        }
        paramTypeId.loadConstant(localLocal7, Integer.valueOf(i));
        localObject2 = BasicTypeMethodUtil.getValueFromClass(arrayOfClass[i]);
        if (!paramBoolean) {
          break label468;
        }
        if (localObject2 == null) {
          break label436;
        }
        paramTypeId.invokeStatic((MethodId)localObject2, localLocal8, new Local[] { paramTypeId.getParameter(i, (TypeId)localMethodId.getParameters().get(i)) });
        paramTypeId.aput(localLocal2, localLocal7, localLocal8);
      }
      for (;;)
      {
        i += 1;
        break label249;
        localObject1 = new TypeId[arrayOfClass.length + 1];
        localObject1[0] = TypeId.get(Object.class);
        i = 0;
        while (i < arrayOfClass.length)
        {
          localObject1[(i + 1)] = BasicTypeMethodUtil.getTypeIdFromClass(arrayOfClass[i]);
          i += 1;
        }
        paramDexMaker = paramTypeId.newLocal(BasicTypeMethodUtil.getClassTypeFromClass(paramMethod.getReturnType()));
        break;
        label412:
        paramTypeId.loadConstant((Local)localObject2, Integer.valueOf(localMethodId.getParameters().size() - 1));
        break label238;
        label436:
        paramTypeId.aput(localLocal2, localLocal7, paramTypeId.getParameter(i, (TypeId)localMethodId.getParameters().get(i)));
        continue;
        label468:
        if (localObject2 != null)
        {
          paramTypeId.invokeStatic((MethodId)localObject2, localLocal8, new Local[] { paramTypeId.getParameter(i + 1, (TypeId)localMethodId.getParameters().get(i + 1)) });
          paramTypeId.aput(localLocal2, localLocal7, localLocal8);
        }
        else
        {
          paramTypeId.aput(localLocal2, localLocal7, paramTypeId.getParameter(i + 1, (TypeId)localMethodId.getParameters().get(i + 1)));
        }
      }
      label562:
      paramTypeId.loadConstant(localLocal4, "androidHook");
      paramTypeId.loadConstant(localLocal5, paramString + " invoke auto class new method ====================");
      paramTypeId.invokeStatic(TypeId.get(Log.class).getMethod(TypeId.INT, "d", new TypeId[] { TypeId.STRING, TypeId.STRING }), localLocal6, new Local[] { localLocal4, localLocal5 });
      paramString = yahfaMethodUtilType.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.STRING, TypeId.OBJECT, TypeId.get([Ljava.lang.Object.class) });
      if (paramBoolean) {
        paramTypeId.invokeStatic(paramString, (Local)localObject1, new Local[] { localLocal3, localLocal9, localLocal2 });
      }
      while (paramMethod.getReturnType().equals(Void.TYPE))
      {
        paramTypeId.returnVoid();
        return;
        paramTypeId.invokeStatic(paramString, (Local)localObject1, new Local[] { localLocal3, paramTypeId.getParameter(0, TypeId.OBJECT), localLocal2 });
      }
      if (BasicTypeMethodUtil.getValueFromClass(paramMethod.getReturnType()) != null)
      {
        paramMethod = BasicTypeMethodUtil.toValueFromClass(paramMethod.getReturnType());
        paramTypeId.cast(paramDexMaker, (Local)localObject1);
        paramTypeId.invokeVirtual(paramMethod, localLocal1, paramDexMaker, new Local[0]);
        paramTypeId.returnValue(localLocal1);
        return;
      }
      paramTypeId.cast(localLocal1, (Local)localObject1);
      paramTypeId.returnValue(localLocal1);
      return;
    }
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
    paramDexMaker.invokeStatic(yahfaMethodUtilType.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.STRING, TypeId.OBJECT, TypeId.get([Ljava.lang.Object.class) }), localLocal4, new Local[] { localLocal6, paramTypeId, localLocal1 });
    paramDexMaker.returnVoid();
  }
  
  public static Object invoke(String paramString, Object paramObject, Object[] paramArrayOfObject)
  {
    YahfaLog.d("invoke! caller is " + paramString + ",obj is " + paramObject + ",args is " + paramArrayOfObject);
    return YahfaHookManager.invoke(paramString, paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.YahfaMethodUtil
 * JD-Core Version:    0.7.0.1
 */