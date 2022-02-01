package de.robv.android.xposed;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XResources;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.Map;

final class XposedInit$9
  extends XC_MethodHook
{
  XposedInit$9(ThreadLocal paramThreadLocal) {}
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam arg1)
  {
    Object localObject2 = this.val$latestResKey.get();
    if (localObject2 == null) {}
    XResources localXResources;
    do
    {
      return;
      this.val$latestResKey.set(null);
      localXResources = XposedInit.access$100(???, (String)XposedHelpers.getObjectField(localObject2, "mResDir"));
    } while (localXResources == null);
    Map localMap = (Map)XposedHelpers.getObjectField(???.thisObject, "mActiveResources");
    if (Build.VERSION.SDK_INT <= 18) {}
    for (;;)
    {
      synchronized (XposedHelpers.getObjectField(???.thisObject, "mPackages"))
      {
        localObject2 = (WeakReference)localMap.put(localObject2, new WeakReference(localXResources));
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null) && (((Resources)((WeakReference)localObject2).get()).getAssets() != localXResources.getAssets())) {
          ((Resources)((WeakReference)localObject2).get()).getAssets().close();
        }
        return;
      }
      ??? = ???.thisObject;
    }
  }
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    this.val$latestResKey.set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.9
 * JD-Core Version:    0.7.0.1
 */