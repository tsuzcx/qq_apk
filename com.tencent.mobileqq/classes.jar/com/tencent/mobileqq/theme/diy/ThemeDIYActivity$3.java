package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

class ThemeDIYActivity$3
  extends VasQuickUpdateManager.CallBacker
{
  ThemeDIYActivity$3(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (1000L != paramLong) {}
    do
    {
      return;
      if ("diytheme.json".equals(paramString1))
      {
        this.this$0.loadResJson(100, true);
        return;
      }
    } while (!"diytheme.style.json".equals(paramString1));
    this.this$0.loadResJson(200, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.3
 * JD-Core Version:    0.7.0.1
 */