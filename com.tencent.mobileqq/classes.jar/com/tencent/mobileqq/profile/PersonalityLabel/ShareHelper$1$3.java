package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ShareHelper$1$3
  implements Runnable
{
  ShareHelper$1$3(ShareHelper.1 param1, long paramLong) {}
  
  public void run()
  {
    String str = ShareHelper.a(this.b.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.3.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3
 * JD-Core Version:    0.7.0.1
 */