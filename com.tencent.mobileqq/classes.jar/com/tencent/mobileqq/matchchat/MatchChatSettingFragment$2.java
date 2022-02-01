package com.tencent.mobileqq.matchchat;

import aslo;
import asrt;
import awui;
import bbdh;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    bdla.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    awui.a(MatchChatSettingFragment.a(this.this$0));
    asrt.b(MatchChatSettingFragment.a(this.this$0));
    ((aslo)MatchChatSettingFragment.a(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).d();
    ((bbdh)MatchChatSettingFragment.a(this.this$0).getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */