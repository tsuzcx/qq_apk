package com.tencent.mobileqq.microapp.widget.media;

import android.content.Context;
import android.content.Intent;
import bbkk;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.c.a.a;

final class i
  implements a.a
{
  i(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (bbkk.a(paramContext)) {}
    do
    {
      do
      {
        return;
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          this.a.c();
          return;
        }
      } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
      paramContext = this.a.n.appBrandRuntime;
    } while ((paramContext == null) || (paramContext.j));
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.i
 * JD-Core Version:    0.7.0.1
 */