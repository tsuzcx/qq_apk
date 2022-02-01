package com.tencent.mobileqq.vas.theme.diy;

import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import org.json.JSONObject;

class ThemeDiyModule$1
  implements QueryCallback<ThemeLocator>
{
  ThemeDiyModule$1(ThemeDiyModule paramThemeDiyModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a(ThemeLocator paramThemeLocator)
  {
    if ((paramThemeLocator != null) && (paramThemeLocator.i()))
    {
      if (ThemeDiyModule.a(this.c) != null) {
        ThemeDiyModule.a(this.c).diyThemeSetup(this.a, this.b);
      }
    }
    else if (ThemeDiyModule.a(this.c) != null) {
      ThemeDiyModule.a(this.c).startDownload(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.1
 * JD-Core Version:    0.7.0.1
 */