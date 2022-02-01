package de.robv.android.xposed;

class XposedBridge$AdditionalHookInfo
{
  final XposedBridge.CopyOnWriteSortedSet<XC_MethodHook> callbacks;
  final Class<?>[] parameterTypes;
  final Class<?> returnType;
  
  private XposedBridge$AdditionalHookInfo(XposedBridge.CopyOnWriteSortedSet<XC_MethodHook> paramCopyOnWriteSortedSet, Class<?>[] paramArrayOfClass, Class<?> paramClass)
  {
    this.callbacks = paramCopyOnWriteSortedSet;
    this.parameterTypes = paramArrayOfClass;
    this.returnType = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedBridge.AdditionalHookInfo
 * JD-Core Version:    0.7.0.1
 */