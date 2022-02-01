package de.robv.android.xposed;

import com.taobao.android.dexposed.XC_MethodHook;

class DexposedBridge$AdditionalHookInfo
{
  final DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook> callbacks;
  final Class<?>[] parameterTypes;
  final Class<?> returnType;
  
  private DexposedBridge$AdditionalHookInfo(DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook> paramCopyOnWriteSortedSet, Class<?>[] paramArrayOfClass, Class<?> paramClass)
  {
    this.callbacks = paramCopyOnWriteSortedSet;
    this.parameterTypes = paramArrayOfClass;
    this.returnType = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.DexposedBridge.AdditionalHookInfo
 * JD-Core Version:    0.7.0.1
 */