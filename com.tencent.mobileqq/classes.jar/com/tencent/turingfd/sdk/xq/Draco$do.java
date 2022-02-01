package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Set;

public class Draco$do
  extends Hydra
{
  public void a(Activity paramActivity, String paramString)
  {
    if ((Draco.g.contains(paramActivity.getClass().getName())) || (Draco.f)) {
      try
      {
        paramString = Draco.i;
        Object localObject = paramActivity.getWindow();
        String str = paramActivity.getClass().getName();
        Window.Callback localCallback = ((Window)localObject).getCallback();
        if ((localCallback != null) && (!(localCallback instanceof Leo))) {
          ((Window)localObject).setCallback(new Leo(localCallback, paramString, str));
        }
        paramString = paramActivity.getWindow();
        paramActivity = paramActivity.getClass().getName();
        localObject = Draco.j;
        paramString.getDecorView().getViewTreeObserver().addOnPreDrawListener(new GalacticCore(paramString, paramActivity, (Cygnus)localObject));
        return;
      }
      finally
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Draco.e.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, "onActivityResumed");
    Draco.e.onActivityResumed(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Draco.do
 * JD-Core Version:    0.7.0.1
 */