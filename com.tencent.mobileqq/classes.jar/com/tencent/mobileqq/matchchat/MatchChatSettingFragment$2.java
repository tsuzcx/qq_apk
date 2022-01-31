package com.tencent.mobileqq.matchchat;

import amfi;
import apwx;
import aqbv;
import atwl;
import azmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    azmj.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    atwl.a(MatchChatSettingFragment.a(this.this$0));
    aqbv.b(MatchChatSettingFragment.a(this.this$0));
    ((apwx)MatchChatSettingFragment.a(this.this$0).getManager(264)).c();
    ((amfi)MatchChatSettingFragment.a(this.this$0).getManager(285)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */