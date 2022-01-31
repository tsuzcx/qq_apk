package com.tencent.mobileqq.profile.PersonalityLabel;

import awqe;
import awqf;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ShareHelper$1$2
  implements Runnable
{
  public ShareHelper$1$2(awqf paramawqf) {}
  
  public void run()
  {
    String str = awqe.a(this.a.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.2.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2
 * JD-Core Version:    0.7.0.1
 */