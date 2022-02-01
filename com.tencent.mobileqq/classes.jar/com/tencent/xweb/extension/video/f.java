package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.i;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

public class f
{
  private static ClassLoader a;
  
  public static b a(Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    Activity localActivity = XWalkEnvironment.activityFromContext(paramContext);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("createXWebNativeInterface:activity:");
    ((StringBuilder)localObject1).append(localActivity);
    Log.i("VideoNativeInterface", ((StringBuilder)localObject1).toString());
    localObject1 = XWalkCoreWrapper.getInstance();
    f.a locala = null;
    if (localObject1 != null)
    {
      Log.i("VideoNativeInterface", "createXWebNativeInterface get class by xwalk");
      localObject2 = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      localObject1 = null;
    }
    else
    {
      Log.i("VideoNativeInterface", "createXWebNativeInterface get class by sys");
      localObject1 = Boolean.valueOf(XWalkEnvironment.getXWebInitArgs("isgpversion", false));
      if ((localObject1 != null) && ((localObject1 instanceof Boolean)) && (((Boolean)localObject1).booleanValue())) {}
    }
    try
    {
      localClassLoader = a();
      localObject1 = localClassLoader;
      localObject2 = locala;
      if (localClassLoader == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      ClassLoader localClassLoader;
      label153:
      break label181;
    }
    try
    {
      localObject2 = localClassLoader.loadClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      localObject1 = localClassLoader;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label153;
    }
    localObject1 = localClassLoader;
    Object localObject2 = locala;
    break label188;
    Log.e("VideoNativeInterface", "createXWebNativeInterface current is gpversion not load dex");
    break label181;
    Log.e("VideoNativeInterface", "createXWebNativeInterface no gpversion value");
    label181:
    localObject1 = null;
    localObject2 = locala;
    label188:
    if (localObject2 != null) {}
    try
    {
      Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal");
      locala = new f.a(((Class)localObject2).newInstance());
      localObject2 = paramContext;
      if (!(paramContext instanceof XWalkContextWrapper)) {
        localObject2 = new XWalkContextWrapper(paramWebView.getContext(), XWalkEnvironment.getAvailableVersion());
      }
      if (localObject1 != null) {
        ((XWalkContextWrapper)localObject2).setClassLoader((ClassLoader)localObject1);
      }
      locala.a(localActivity, paramWebView, paramView, (Context)localObject2, paramString);
      return locala;
    }
    catch (Exception paramContext)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("XWebNativeInterfaceInternal found but error:");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      Log.e("VideoNativeInterface", ((StringBuilder)localObject1).toString());
    }
    Log.i("VideoNativeInterface", "createXWebNativeInterface try using runtime class:XWebNativeInterfaceInternal but bot found");
    Log.i("VideoNativeInterface", "createXWebNativeInterface using local class:XWebNativeInterface");
    paramContext = new e();
    paramContext.a(localActivity, paramWebView, paramView, paramView.getContext(), paramString);
    return paramContext;
  }
  
  private static ClassLoader a()
  {
    ClassLoader localClassLoader = a;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    try
    {
      a = i.a();
      return a;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getXWalkClassLoader error:");
      localStringBuilder.append(localException.getMessage());
      Log.e("VideoNativeInterface", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.f
 * JD-Core Version:    0.7.0.1
 */