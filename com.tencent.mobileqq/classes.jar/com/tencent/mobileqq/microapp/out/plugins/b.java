package com.tencent.mobileqq.microapp.out.plugins;

import android.content.Intent;
import com.tencent.mobileqq.microapp.appbrand.b.c;
import com.tencent.mobileqq.microapp.sdk.MiniAppController.ActivityResultListener;

final class b
  implements MiniAppController.ActivityResultListener
{
  b(OtherJsPlugin paramOtherJsPlugin, String paramString1, String paramString2, int paramInt) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (c.b(this.a))
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",data=");
      localStringBuilder.append(paramIntent);
      c.a("OtherJsPlugin", 2, str, localStringBuilder.toString());
    }
    if (paramInt1 == 5) {
      OtherJsPlugin.access$200(this.d, this.b, this.a, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.plugins.b
 * JD-Core Version:    0.7.0.1
 */