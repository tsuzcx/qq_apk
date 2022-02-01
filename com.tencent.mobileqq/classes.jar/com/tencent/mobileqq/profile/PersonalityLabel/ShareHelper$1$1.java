package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ShareHelper$1$1
  implements Runnable
{
  ShareHelper$1$1(ShareHelper.1 param1) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.a.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1
 * JD-Core Version:    0.7.0.1
 */