package com.tencent.timi.game.scheme.tools;

import android.content.Context;
import android.content.Intent;

final class SchemeUtil$3
  implements Runnable
{
  SchemeUtil$3(Intent paramIntent, Context paramContext, String paramString, SchemeUtil.LaunchSchemeCallback paramLaunchSchemeCallback) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        this.b.startActivity(this.a);
        return;
      }
      SchemeUtil.a(this.b, this.c);
      return;
    }
    catch (Exception localException)
    {
      SchemeUtil.LaunchSchemeCallback localLaunchSchemeCallback = this.d;
      if (localLaunchSchemeCallback != null) {
        localLaunchSchemeCallback.a(localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.SchemeUtil.3
 * JD-Core Version:    0.7.0.1
 */