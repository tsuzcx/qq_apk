package com.tencent.mobileqq.profile.PersonalityLabel;

import awlv;
import awlw;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ShareHelper$1$3
  implements Runnable
{
  public ShareHelper$1$3(awlw paramawlw, long paramLong) {}
  
  public void run()
  {
    String str = awlv.a(this.jdField_a_of_type_Awlw.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.3.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3
 * JD-Core Version:    0.7.0.1
 */