package com.tencent.mobileqq.microapp.appbrand.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;

final class e
  implements Runnable
{
  e(d paramd, b.a parama) {}
  
  public void run()
  {
    int i = this.a.a;
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 3) {
          return;
        }
        h.a().a(this.b.a);
      }
      if (this.a.b != null) {
        this.b.a.a.a(this.a.b, this.a.b.f.launchParam.entryPath);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.a.c))
      {
        a locala = this.b.a.a.a(this.a.c, this.a.d);
        if (locala != null) {
          locala.b();
        }
      }
      AppBrandUI.a(this.b.a, true);
      AppBrandUI.a(this.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */