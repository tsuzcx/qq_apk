package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

public class C2CListenTogetherPanel
  extends BaseListenTogetherPanel
{
  public C2CListenTogetherPanel(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    if ((this.a instanceof FriendChatPie)) {
      ((FriendChatPie)this.a).bB();
    }
  }
  
  public String getTag()
  {
    return "BaseListenTogetherPanel_C2C";
  }
  
  public void k()
  {
    super.k();
    this.e.a = 2;
    this.e.b = this.a.ae();
    if (this.e.b == null) {
      this.e.b = "";
    }
    this.m = new BaseListenTogetherPanel.ReportInfo();
    this.m.a = "c2c_AIO";
    this.m.b = -1;
    this.m.c = "";
  }
  
  public void m()
  {
    boolean bool;
    if ((AIOMusicSkin.a().du_()) && (!QQTheme.isNowSimpleUI())) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("BaseListenTogetherPanel_C2C", 1, String.format("[music-panel] onVasSkinStateChange mutualLevel=%d vasSkinShowing [%b-->%b]", new Object[] { Integer.valueOf(this.e.p), Boolean.valueOf(this.l), Boolean.valueOf(bool) }));
    if (bool != this.l)
    {
      this.l = bool;
      a(this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */