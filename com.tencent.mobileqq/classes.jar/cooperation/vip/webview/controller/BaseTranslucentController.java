package cooperation.vip.webview.controller;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.util.QZLog;

public class BaseTranslucentController
{
  protected QQBrowserActivity a;
  protected Handler b;
  private long c;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private BroadcastReceiver f = new BaseTranslucentController.1(this);
  private Runnable g = new BaseTranslucentController.2(this);
  
  public BaseTranslucentController(QQBrowserActivity paramQQBrowserActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current controller = ");
    localStringBuilder.append(getClass().getName());
    QZLog.i("BaseTranslucentControll", localStringBuilder.toString());
    this.a = paramQQBrowserActivity;
    this.b = new Handler(Looper.getMainLooper());
  }
  
  private void h()
  {
    if (this.d) {
      return;
    }
    try
    {
      QZLog.i("BaseTranslucentControll", "registerBroadcast");
      IntentFilter localIntentFilter = new IntentFilter();
      String[] arrayOfString = g();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localIntentFilter.addAction(arrayOfString[i]);
          i += 1;
        }
      }
      boolean bool = this.d;
      if (!bool) {
        try
        {
          this.a.registerReceiver(this.f, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.d = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("BaseTranslucentControll", "regist receiver error:", localException1);
          return;
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("BaseTranslucentControll", "registerBroadcast error", localException2);
    }
  }
  
  private void i()
  {
    try
    {
      if (this.d)
      {
        QZLog.i("BaseTranslucentControll", "removeBroadcast");
        try
        {
          this.a.unregisterReceiver(this.f);
        }
        catch (Exception localException1)
        {
          QZLog.e("BaseTranslucentControll", "unregisterReceiver error ", localException1);
        }
        this.d = false;
        return;
      }
    }
    catch (Exception localException2)
    {
      QZLog.e("BaseTranslucentControll", "removeBroadcast error", localException2);
    }
  }
  
  public void a()
  {
    this.c = System.currentTimeMillis();
    a(false);
    h();
    this.b.postDelayed(this.g, 6100L);
  }
  
  public void a(Intent paramIntent) {}
  
  protected void a(View paramView)
  {
    int i;
    if (!this.e)
    {
      i = 1;
      this.e = true;
      QZLog.i("BaseTranslucentControll", "setAlpha(1)");
      if (paramView != null) {
        paramView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      try
      {
        if (this.a.getCurrentWebViewFragment() != null)
        {
          paramView = this.a.getCurrentWebViewFragment().getWebView();
          if (paramView != null)
          {
            Object localObject = paramView.getTag(2131444056);
            if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
              break label132;
            }
            paramView.setTag(2131444053, Boolean.TRUE);
            if (i != 0)
            {
              QZLog.i("BaseTranslucentControll", "tiantai jsReady true,notify webview.");
              ((IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class)).notifyWebviewStartAnimation(paramView);
              return;
            }
            QZLog.i("BaseTranslucentControll", "tiantai jsReady false,not notify webview.");
            return;
          }
        }
      }
      catch (Exception paramView)
      {
        QZLog.e("BaseTranslucentControll", "notify webview qzRoofStartAnimation fail.", paramView);
      }
      return;
      label132:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    View localView = this.a.findViewById(2131431345);
    if (localView == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (System.currentTimeMillis() - this.c < 6000L)
      {
        localView.setAlpha(0.0F);
        this.e = false;
        QZLog.i("BaseTranslucentControll", "setAlpha(0)");
        return;
      }
      QZLog.i("BaseTranslucentControll", "isLoadSuccess = true，setAlpha(1)");
      a(localView);
      return;
    }
    QZLog.i("BaseTranslucentControll", "isLoadSuccess = false，setAlpha(1)");
    a(localView);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    i();
    this.b.removeCallbacks(this.g);
  }
  
  public void e()
  {
    a(true);
  }
  
  public boolean f()
  {
    return true;
  }
  
  public String[] g()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.webview.controller.BaseTranslucentController
 * JD-Core Version:    0.7.0.1
 */