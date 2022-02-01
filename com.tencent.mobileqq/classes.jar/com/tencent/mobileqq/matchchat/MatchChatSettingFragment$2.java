package com.tencent.mobileqq.matchchat;

import arhi;
import arnn;
import avod;
import azwy;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MatchChatSettingFragment$2
  implements Runnable
{
  MatchChatSettingFragment$2(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void run()
  {
    bcef.b(MatchChatSettingFragment.a(this.this$0), "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
    avod.a(MatchChatSettingFragment.a(this.this$0));
    arnn.b(MatchChatSettingFragment.a(this.this$0));
    ((arhi)MatchChatSettingFragment.a(this.this$0).getManager(264)).d();
    ((azwy)MatchChatSettingFragment.a(this.this$0).getManager(285)).a();
    ThreadManager.getUIHandler().post(new MatchChatSettingFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */