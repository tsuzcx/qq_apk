package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.webview.util.IWebColorNoteInject;

public class WebColorNoteInjectImpl
  implements IWebColorNoteInject
{
  WebColorNoteController a = null;
  
  public void a()
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      localWebColorNoteController.g();
    }
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      localWebColorNoteController.a(paramIServiceInfo);
    }
  }
  
  public boolean a()
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      return localWebColorNoteController.b();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      return localWebColorNoteController.a(paramString);
    }
    return false;
  }
  
  public boolean b()
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      return localWebColorNoteController.a();
    }
    return false;
  }
  
  public boolean c()
  {
    WebColorNoteController localWebColorNoteController = this.a;
    if (localWebColorNoteController != null) {
      return localWebColorNoteController.c();
    }
    return false;
  }
  
  public void doOnActivityCreate(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof QQBrowserActivity))
    {
      this.a = WebColorNoteInjectImpl.WebColorNoteFactory.a((QQBrowserActivity)paramActivity);
      this.a.a(paramBundle);
    }
  }
  
  public void doOnActivityDestroyed(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public void doOnActivityOnStart(Activity paramActivity) {}
  
  public void doOnActivityPause(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.d();
    }
  }
  
  public void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityPostPaused(Activity paramActivity) {}
  
  public void doOnActivityPostResumed(Activity paramActivity) {}
  
  public void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityPrePaused(Activity paramActivity) {}
  
  public void doOnActivityPreResumed(Activity paramActivity) {}
  
  public void doOnActivityResume(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.c();
    }
  }
  
  public void doOnActivityStopped(Activity paramActivity) {}
  
  public void doOnNewIntent(Activity paramActivity, Intent paramIntent) {}
  
  public void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onAccountChanged(Activity paramActivity) {}
  
  public void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onPostThemeChanged(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebColorNoteInjectImpl
 * JD-Core Version:    0.7.0.1
 */