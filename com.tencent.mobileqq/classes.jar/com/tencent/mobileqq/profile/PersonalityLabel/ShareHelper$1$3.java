package com.tencent.mobileqq.profile.PersonalityLabel;

import azxc;
import azxd;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ShareHelper$1$3
  implements Runnable
{
  public ShareHelper$1$3(azxd paramazxd, long paramLong) {}
  
  public void run()
  {
    String str = azxc.a(this.jdField_a_of_type_Azxd.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.3.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3
 * JD-Core Version:    0.7.0.1
 */