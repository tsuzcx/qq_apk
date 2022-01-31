package com.tencent.plato;

import com.tencent.plato.core.IExportedMethod;
import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

class ExportedModuleWrapper
{
  private static final String TAG = "ExportedModuleWrapper";
  private final int mMethodSize;
  private final ArrayList<IExportedMethod> mMethods;
  private final IExportedModule mModule;
  private final IPlatoRuntime mPlatoManager;
  
  ExportedModuleWrapper(IPlatoRuntime paramIPlatoRuntime, IExportedModule paramIExportedModule)
  {
    this.mModule = paramIExportedModule;
    this.mPlatoManager = paramIPlatoRuntime;
    this.mMethods = new ArrayList(paramIExportedModule.getExportedMethods().values());
    this.mMethodSize = this.mMethods.size();
  }
  
  Object invoke(int paramInt, IReadableArray paramIReadableArray)
  {
    if ((paramInt < 0) || (paramInt >= this.mMethodSize))
    {
      PLog.e("ExportedModuleWrapper", "callNative methodId is not correct:" + this.mModule.getName() + "->" + paramInt + " args:" + paramIReadableArray);
      return null;
    }
    IExportedMethod localIExportedMethod = (IExportedMethod)this.mMethods.get(paramInt);
    PLog.i("ExportedModuleWrapper", this.mModule.getName() + "." + localIExportedMethod.getName() + ":" + paramIReadableArray);
    Class[] arrayOfClass = localIExportedMethod.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    paramInt = 0;
    int i = 0;
    if (i < arrayOfClass.length)
    {
      Class localClass = arrayOfClass[i];
      if (IPlatoRuntime.class == localClass) {
        arrayOfObject[i] = this.mPlatoManager;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt >= paramIReadableArray.length())
        {
          PLog.e("ExportedModuleWrapper", String.format(Locale.CHINESE, "call %s.%s, but args length(%d) not enough", new Object[] { this.mModule.getName(), localIExportedMethod.getName(), Integer.valueOf(paramIReadableArray.length()) }));
          return null;
        }
        if ((localClass == Boolean.class) || (localClass == Boolean.TYPE))
        {
          arrayOfObject[i] = Boolean.valueOf(paramIReadableArray.getBoolean(paramInt, false));
          paramInt += 1;
        }
        else if ((localClass == Integer.class) || (localClass == Integer.TYPE))
        {
          arrayOfObject[i] = Integer.valueOf(paramIReadableArray.getInt(paramInt, 0));
          paramInt += 1;
        }
        else if ((localClass == Double.class) || (localClass == Double.TYPE))
        {
          arrayOfObject[i] = Double.valueOf(paramIReadableArray.getDouble(paramInt, 0.0D));
          paramInt += 1;
        }
        else if ((localClass == Long.class) || (localClass == Long.TYPE))
        {
          arrayOfObject[i] = Long.valueOf(paramIReadableArray.getLong(paramInt, 0L));
          paramInt += 1;
        }
        else if ((localClass == Float.class) || (localClass == Float.TYPE))
        {
          arrayOfObject[i] = Float.valueOf(paramIReadableArray.getFloat(paramInt, 0.0F));
          paramInt += 1;
        }
        else if (localClass == String.class)
        {
          arrayOfObject[i] = paramIReadableArray.getString(paramInt, null);
          paramInt += 1;
        }
        else if (localClass == IReadableArray.class)
        {
          arrayOfObject[i] = paramIReadableArray.getReadableArray(paramInt);
          paramInt += 1;
        }
        else if (localClass == IReadableMap.class)
        {
          arrayOfObject[i] = paramIReadableArray.getReadableMap(paramInt);
          paramInt += 1;
        }
        else
        {
          if (localClass != IFunction.class) {
            break label536;
          }
          arrayOfObject[i] = paramIReadableArray.getFunction(paramInt);
          paramInt += 1;
        }
      }
      label536:
      throw new RuntimeException(String.format(Locale.CHINESE, "unknown argument type:%s in class:%s[%s]", new Object[] { localClass.getSimpleName(), this.mModule.getClass().getName(), localIExportedMethod.getName() }));
    }
    if (paramInt < paramIReadableArray.length()) {
      PLog.e("ExportedModuleWrapper", String.format(Locale.CHINESE, "call %s.%s, but args length(%d) too long", new Object[] { this.mModule.getName(), localIExportedMethod.getName(), Integer.valueOf(paramIReadableArray.length()) }));
    }
    return localIExportedMethod.invoke(this.mModule, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.ExportedModuleWrapper
 * JD-Core Version:    0.7.0.1
 */