package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.vivo.push.util.o;
import com.vivo.push.util.z;
import java.util.List;

public class LinkProxyActivity
  extends Activity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      o.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
      finish();
      return;
    }
    boolean bool2 = false;
    try
    {
      Window localWindow = getWindow();
      localWindow.setGravity(8388659);
      localObject2 = localWindow.getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).height = 1;
      ((WindowManager.LayoutParams)localObject2).width = 1;
      localWindow.setAttributes((WindowManager.LayoutParams)localObject2);
    }
    catch (Throwable localThrowable)
    {
      o.b("LinkProxyActivity", "enter onCreate error ", localThrowable);
    }
    Object localObject1 = getPackageName();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(hashCode());
    ((StringBuilder)localObject2).append(" enter onCreate ");
    ((StringBuilder)localObject2).append((String)localObject1);
    o.d("LinkProxyActivity", ((StringBuilder)localObject2).toString());
    if ("com.vivo.abe".equals(localObject1))
    {
      if (paramBundle == null) {}
      try
      {
        o.d("LinkProxyActivity", "adapterToService intent is null");
      }
      catch (Exception paramBundle)
      {
        o.a("LinkProxyActivity", paramBundle.toString(), paramBundle);
      }
      if (paramBundle.getExtras() == null)
      {
        o.d("LinkProxyActivity", "adapterToService getExtras() is null");
      }
      else
      {
        paramBundle = (Intent)paramBundle.getExtras().get("previous_intent");
        if (paramBundle == null) {
          o.d("LinkProxyActivity", "adapterToService proxyIntent is null");
        } else {
          z.a(this, paramBundle);
        }
      }
    }
    else
    {
      try
      {
        if (paramBundle.getExtras() != null)
        {
          paramBundle = (Intent)paramBundle.getExtras().get("previous_intent");
          boolean bool1 = bool2;
          if (paramBundle != null)
          {
            localObject1 = getPackageManager();
            bool1 = bool2;
            if (localObject1 != null)
            {
              localObject1 = ((PackageManager)localObject1).queryIntentServices(paramBundle, 576);
              bool1 = bool2;
              if (localObject1 != null) {
                if (((List)localObject1).isEmpty())
                {
                  bool1 = bool2;
                }
                else
                {
                  localObject1 = (ResolveInfo)((List)localObject1).get(0);
                  bool1 = bool2;
                  if (localObject1 != null)
                  {
                    bool1 = bool2;
                    if (((ResolveInfo)localObject1).serviceInfo != null)
                    {
                      bool1 = bool2;
                      if (((ResolveInfo)localObject1).serviceInfo.exported) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
          if (bool1) {
            startService(paramBundle);
          } else {
            o.b("LinkProxyActivity", "service's exported is ".concat(String.valueOf(bool1)));
          }
        }
      }
      catch (Exception paramBundle)
      {
        o.a("LinkProxyActivity", paramBundle.toString(), paramBundle);
      }
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" onDestory ");
    localStringBuilder.append(getPackageName());
    o.d("LinkProxyActivity", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.service.LinkProxyActivity
 * JD-Core Version:    0.7.0.1
 */