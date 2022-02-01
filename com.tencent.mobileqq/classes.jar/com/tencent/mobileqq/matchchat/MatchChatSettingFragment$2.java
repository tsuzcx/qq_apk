package com.tencent.mobileqq.matchchat;

import asvi;
import atbf;
import axaw;
import bbcd;
import bdll;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    bdll.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    axaw.a(MatchChatSettingFragment.a(this.this$0));
    atbf.b(MatchChatSettingFragment.a(this.this$0));
    ((asvi)MatchChatSettingFragment.a(this.this$0).getManager(264)).d();
    ((bbcd)MatchChatSettingFragment.a(this.this$0).getManager(285)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */