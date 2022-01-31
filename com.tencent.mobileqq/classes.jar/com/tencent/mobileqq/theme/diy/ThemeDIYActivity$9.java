package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeSwitchListener;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$9
  implements ThemeSwitchManager.ThemeSwitchListener
{
  ThemeDIYActivity$9(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onSwitchCallback(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.themeSwitchManager.a(this, false, true);
    if (paramInt > 0)
    {
      this.this$0.mStyleSetStatus = 0;
      this.this$0.usedStyleRSD = this.this$0.tryOnStyleRSD;
      this.this$0.mAdapter.usedStyleRSD = this.this$0.usedStyleRSD;
      this.this$0.saveStyleCallback.callback(15, 4, null, null);
      ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "Diy_stock", 0, 1, "", "", "B", "");
      return;
    }
    if (-2 == paramInt)
    {
      this.this$0.mStyleSetStatus = 2;
      QLog.e("ThemeDIYActivity", 1, "onSwitchCallback save server ret = false");
      this.this$0.saveStyleCallback.callback(16, 8, null, null);
      return;
    }
    QLog.e("ThemeDIYActivity", 1, "onSwitchCallback ret = false");
    this.this$0.mStyleSetStatus = 2;
    this.this$0.saveStyleCallback.callback(15, 8, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.9
 * JD-Core Version:    0.7.0.1
 */