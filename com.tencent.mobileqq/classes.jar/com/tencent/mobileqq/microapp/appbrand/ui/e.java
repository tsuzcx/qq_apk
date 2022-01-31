package com.tencent.mobileqq.microapp.appbrand.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.appbrand.utils.p;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;

final class e
  implements Runnable
{
  e(d paramd, b.a parama) {}
  
  public void run()
  {
    switch (this.a.a)
    {
    case 0: 
    case 2: 
    default: 
    case 3: 
    case 1: 
      do
      {
        return;
        p.a().a(this.b.a);
      } while (this.a.b == null);
      this.b.a.a.a(this.a.b, this.a.b.f.launchParam.entryPath);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */