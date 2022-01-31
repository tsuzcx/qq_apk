package com.tencent.mobileqq.matchchat;

import aknu;
import aoeu;
import aojt;
import asfl;
import axqy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    axqy.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    asfl.a(MatchChatSettingFragment.a(this.this$0));
    aojt.b(MatchChatSettingFragment.a(this.this$0));
    ((aoeu)MatchChatSettingFragment.a(this.this$0).getManager(264)).c();
    ((aknu)MatchChatSettingFragment.a(this.this$0).getManager(285)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */