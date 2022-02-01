package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.OnExistListenTogetherCallback;
import com.tencent.mobileqq.statistics.ReportController;

class BaseListenTogetherPanel$3
  implements OnExistListenTogetherCallback
{
  BaseListenTogetherPanel$3(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    ListenTogetherManager.a(this.a.a.d).a(this.a.e.a, this.a.e.b, paramBoolean);
    String str1 = this.a.m.a;
    String str2 = this.a.m.c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.m.b);
    ((StringBuilder)localObject).append("");
    ReportController.b(null, "dc00899", str1, "", "music_tab", "clk_quit", 0, 0, str2, "", ((StringBuilder)localObject).toString(), "");
    if (this.a.b.app.getCurrentAccountUin().equalsIgnoreCase(this.a.e.m))
    {
      str2 = this.a.m.a;
      localObject = this.a.m.c;
      if (paramBoolean) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      ReportController.b(null, "dc00899", str2, "", "music_tab", "clk_quit_opener", 0, 0, (String)localObject, "", str1, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.3
 * JD-Core Version:    0.7.0.1
 */