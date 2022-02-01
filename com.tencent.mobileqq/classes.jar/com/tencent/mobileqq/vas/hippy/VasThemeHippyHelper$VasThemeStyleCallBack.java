package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mtt.hippy.modules.Promise;

class VasThemeHippyHelper$VasThemeStyleCallBack
  implements ThemeDiyStyleLogic.StyleCallBack
{
  String a;
  ThemeUtil.ThemeInfo b;
  Promise c;
  
  public VasThemeHippyHelper$VasThemeStyleCallBack(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString1, boolean paramBoolean, String paramString2, ThemeUtil.ThemeInfo paramThemeInfo, Promise paramPromise)
  {
    this.a = paramString2;
    this.b = paramThemeInfo;
    this.c = paramPromise;
  }
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = new Bundle();
    paramResData.putString("themeId", paramBundle.getString("themeId"));
    if (paramInt2 == 4) {
      paramInt1 = 0;
    } else {
      paramInt1 = -2;
    }
    paramResData.putInt("themeStatus", paramInt1);
    paramBundle.putBundle("response", paramResData);
    this.d.a(paramBundle, this.c, this.b);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.VasThemeStyleCallBack
 * JD-Core Version:    0.7.0.1
 */