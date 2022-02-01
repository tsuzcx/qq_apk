package com.tencent.mobileqq.microapp.widget.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.microapp.a.a.a;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.utils.StringUtil;

final class i
  implements a.a
{
  i(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (StringUtil.isEmpty(paramContext)) {
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      this.a.c();
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      paramContext = this.a.n.appBrandRuntime;
      if (paramContext == null) {
        return;
      }
      if (paramContext.j) {
        return;
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.i
 * JD-Core Version:    0.7.0.1
 */