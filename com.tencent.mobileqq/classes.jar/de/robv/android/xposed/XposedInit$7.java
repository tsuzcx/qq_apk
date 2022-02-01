package de.robv.android.xposed;

import android.content.res.XResources;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class XposedInit$7
  extends XC_MethodHook
{
  XposedInit$7(Class paramClass) {}
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    int i = XposedHelpers.getParameterIndexByType(paramMethodHookParam.method, IBinder.class);
    int j = XposedHelpers.getParameterIndexByType(paramMethodHookParam.method, this.val$classResKey);
    XResources localXResources = XposedInit.access$100(paramMethodHookParam, (String)XposedHelpers.getObjectField(paramMethodHookParam.args[j], "mResDir"));
    if (localXResources == null) {
      return;
    }
    Object localObject2 = paramMethodHookParam.args[i];
    Object localObject1 = paramMethodHookParam.thisObject;
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        paramMethodHookParam = (ArrayList)XposedHelpers.getObjectField(XposedHelpers.callMethod(paramMethodHookParam.thisObject, "getOrCreateActivityResourcesStructLocked", new Object[] { localObject2 }), "activityResources");
        paramMethodHookParam.add(new WeakReference(localXResources));
        return;
      }
      finally {}
      paramMethodHookParam = (ArrayList)XposedHelpers.getObjectField(paramMethodHookParam.thisObject, "mResourceReferences");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.7
 * JD-Core Version:    0.7.0.1
 */