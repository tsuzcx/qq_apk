package com.tencent.mobileqq.profile.PersonalityLabel;

import atwi;
import atwj;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ShareHelper$1$3
  implements Runnable
{
  public ShareHelper$1$3(atwj paramatwj, long paramLong) {}
  
  public void run()
  {
    String str = atwi.a(this.jdField_a_of_type_Atwj.a);
    ThreadManager.getUIHandler().post(new ShareHelper.1.3.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3
 * JD-Core Version:    0.7.0.1
 */