package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import android.text.TextUtils;

class VasThemeHippyHelper$1
  implements Runnable
{
  VasThemeHippyHelper$1(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", this.a);
    localBundle.putInt("actionResult", this.b);
    if (!TextUtils.isEmpty(this.c))
    {
      localBundle.putString("actionName", this.c);
      localBundle.putLong("downloadTime", this.d);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localBundle.putString("statistic_key", this.e);
      localBundle.putString("param_FailCode", this.f);
    }
    if (!TextUtils.isEmpty(this.g))
    {
      localBundle.putString("from", this.g);
      localBundle.putInt("step", this.h);
      localBundle.putInt("code", this.i);
      localBundle.putString("version", this.j);
      localBundle.putString("r5", this.k);
      localBundle.putString("path", this.l);
    }
    VasThemeHippyHelper.a(localBundle, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.1
 * JD-Core Version:    0.7.0.1
 */