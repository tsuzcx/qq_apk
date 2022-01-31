package com.tencent.mobileqq.microapp.out.plugins;

import android.content.Intent;
import com.tencent.mobileqq.microapp.appbrand.utils.c;
import com.tencent.mobileqq.microapp.sdk.MiniAppController.ActivityResultListener;

final class b
  implements MiniAppController.ActivityResultListener
{
  b(OtherJsPlugin paramOtherJsPlugin, String paramString1, String paramString2, int paramInt) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (c.b(this.a)) {
      c.a("OtherJsPlugin", 2, this.a, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    }
    if (paramInt1 == 5) {
      OtherJsPlugin.access$200(this.d, this.b, this.a, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.plugins.b
 * JD-Core Version:    0.7.0.1
 */