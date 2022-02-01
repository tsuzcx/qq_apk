package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.wxa.su.g;
import com.tencent.luggage.wxa.su.h;
import com.tencent.xweb.r;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public class f$a
  implements b, r
{
  private ReflectMethod a;
  private ReflectMethod b;
  private ReflectMethod c;
  private ReflectMethod d;
  private ReflectMethod e;
  private ReflectMethod f;
  private ReflectMethod g;
  private ReflectMethod h;
  private ReflectMethod i;
  private ReflectMethod j;
  private ReflectMethod k;
  private ReflectMethod l;
  private ReflectMethod m;
  private ReflectMethod n;
  private Object o;
  
  public f$a(Object paramObject)
  {
    this.o = paramObject;
    this.a = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
    this.b = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
    this.c = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
    this.d = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
    this.e = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
    this.f = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
    this.g = new ReflectMethod(paramObject, "disableJsCallback", new Class[] { Boolean.TYPE });
    this.h = new ReflectMethod(paramObject, "setVideoJsCallback", new Class[] { Object.class });
    this.k = new ReflectMethod(paramObject, "videoChangeStatus", new Class[0]);
    this.i = new ReflectMethod(paramObject, "videoPlay", new Class[0]);
    this.j = new ReflectMethod(paramObject, "videoPause", new Class[0]);
    this.l = new ReflectMethod(paramObject, "videoSeek", new Class[] { Double.TYPE });
    this.m = new ReflectMethod(paramObject, "videoExitFullscreen", new Class[0]);
    this.n = new ReflectMethod(paramObject, "supportSetRequestedOrientationCallback", new Class[0]);
  }
  
  public void a()
  {
    try
    {
      this.d.invoke(new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoNativeInterfaceRuntime onHideCustomView error:");
      localStringBuilder.append(localException.getMessage());
      Log.e("VideoNativeInterface", localStringBuilder.toString());
    }
  }
  
  public void a(Activity paramActivity, View paramView1, View paramView2, Context paramContext, String paramString)
  {
    try
    {
      this.a.invoke(new Object[] { paramActivity, paramView1, paramView2, paramContext, paramString });
      return;
    }
    catch (Exception paramActivity)
    {
      paramView1 = new StringBuilder();
      paramView1.append("VideoNativeInterfaceRuntime init error:");
      paramView1.append(paramActivity.getMessage());
      Log.e("VideoNativeInterface", paramView1.toString());
    }
  }
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    try
    {
      this.c.invoke(new Object[] { paramView, paramCustomViewCallback });
      return;
    }
    catch (Exception paramView)
    {
      paramCustomViewCallback = new StringBuilder();
      paramCustomViewCallback.append("VideoNativeInterfaceRuntime onShowCustomView error:");
      paramCustomViewCallback.append(paramView.getMessage());
      Log.e("VideoNativeInterface", paramCustomViewCallback.toString());
    }
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.f.invoke(new Object[] { paramObject });
      return;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoNativeInterfaceRuntime registerJavascriptInterface error:");
      localStringBuilder.append(paramObject.getMessage());
      Log.e("VideoNativeInterface", localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.g.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoNativeInterfaceRuntime disableJsCallback error:");
      localStringBuilder.append(localException.getMessage());
      Log.e("VideoNativeInterface", localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.b.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoNativeInterfaceRuntime evaluteJavascript error:");
      localStringBuilder.append(localException.getMessage());
      Log.e("VideoNativeInterface", localStringBuilder.toString());
    }
  }
  
  public boolean b(Object paramObject)
  {
    Object localObject = h.a("FullScreenVideo");
    if ((localObject != null) && (((g)localObject).e() >= 10)) {
      try
      {
        boolean bool = ((Boolean)this.h.invoke(new Object[] { paramObject })).booleanValue();
        return bool;
      }
      catch (Exception paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setVideoJsCallback invoke error:");
        ((StringBuilder)localObject).append(paramObject.getMessage());
        Log.i("VideoNativeInterface", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if (localObject != null)
    {
      paramObject = new StringBuilder();
      paramObject.append("setVideoJsCallback return false fullScreenVideoPlugin is not available version:");
      paramObject.append(((g)localObject).e());
      Log.i("VideoNativeInterface", paramObject.toString());
      return false;
    }
    Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.f.a
 * JD-Core Version:    0.7.0.1
 */