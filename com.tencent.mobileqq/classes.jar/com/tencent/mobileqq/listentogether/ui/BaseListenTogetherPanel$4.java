package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.OnJoinListenTogetherCallback;
import com.tencent.mobileqq.statistics.ReportController;

class BaseListenTogetherPanel$4
  implements OnJoinListenTogetherCallback
{
  BaseListenTogetherPanel$4(BaseListenTogetherPanel paramBaseListenTogetherPanel, int paramInt, String paramString) {}
  
  public void a()
  {
    ListenTogetherManager.a(this.c.a.d).a(this.c.b, this.a, this.b, 1000);
    String str1 = this.c.m.a;
    String str2 = this.c.m.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.m.b);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", str1, "", "music_tab", "clk_join", 0, 0, str2, "", localStringBuilder.toString(), "");
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4
 * JD-Core Version:    0.7.0.1
 */