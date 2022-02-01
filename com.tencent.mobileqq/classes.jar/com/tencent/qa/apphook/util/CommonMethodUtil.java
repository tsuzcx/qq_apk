package com.tencent.qa.apphook.util;

import com.android.dx.Code;
import com.android.dx.DexMaker;
import com.android.dx.Local;
import com.android.dx.TypeId;
import java.lang.reflect.Constructor;

public class CommonMethodUtil
{
  public static void addDefaultConstructor(DexMaker paramDexMaker, TypeId<?> paramTypeId)
  {
    paramDexMaker = paramDexMaker.declare(paramTypeId.getConstructor(new TypeId[0]), 1);
    paramTypeId = paramDexMaker.getThis(paramTypeId);
    paramDexMaker.invokeDirect(TypeId.OBJECT.getConstructor(new TypeId[0]), null, paramTypeId, new Local[0]);
    paramDexMaker.returnVoid();
  }
  
  public static void generateInvokerFromConstructor(DexMaker paramDexMaker, TypeId<?> paramTypeId, Constructor paramConstructor)
  {
    paramConstructor = paramConstructor.getParameterTypes();
    TypeId[] arrayOfTypeId = new TypeId[paramConstructor.length];
    int i = 0;
    while (i < paramConstructor.length)
    {
      arrayOfTypeId[i] = BasicTypeMethodUtil.getTypeIdFromClass(paramConstructor[i]);
      i += 1;
    }
    paramDexMaker.declare(paramTypeId.getMethod(TypeId.get(Void.TYPE), "init_Invoker", arrayOfTypeId), 9).returnVoid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.CommonMethodUtil
 * JD-Core Version:    0.7.0.1
 */