package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import java.util.Set;

public class Chamaeleon$if
  implements Dorado
{
  public void onActivityPaused(Activity paramActivity)
  {
    ComaBerenices localComaBerenices = ComaBerenices.a();
    paramActivity.getApplicationContext();
    localComaBerenices.a(paramActivity.getClass().getName());
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Dorado localDorado = Chamaeleon.b;
    if (localDorado != null) {
      localDorado.onActivityResumed(paramActivity);
    }
    int i;
    if (Chamaeleon.c.contains(paramActivity.getClass().getName())) {
      i = 100;
    } else {
      i = 999;
    }
    ComaBerenices.a().a(paramActivity.getApplicationContext(), paramActivity.getClass().getName(), i, Chamaeleon.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Chamaeleon.if
 * JD-Core Version:    0.7.0.1
 */