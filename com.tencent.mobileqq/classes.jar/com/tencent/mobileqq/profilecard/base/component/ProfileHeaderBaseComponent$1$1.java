package com.tencent.mobileqq.profilecard.base.component;

import anvk;
import azrb;
import azwx;
import azwy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class ProfileHeaderBaseComponent$1$1
  implements Runnable
{
  public ProfileHeaderBaseComponent$1$1(azwy paramazwy) {}
  
  public void run()
  {
    try
    {
      ((anvk)azwx.a(this.a.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((azrb)azwx.h(this.a.a)).a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1.1
 * JD-Core Version:    0.7.0.1
 */