package com.tencent.mobileqq.profile;

import atww;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardCheckUpdate$1
  implements Runnable
{
  public ProfileCardCheckUpdate$1(atww paramatww) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = new QvipSpecialSoundManager(BaseApplicationImpl.getContext(), (AppInterface)localObject);
      ((QvipSpecialSoundManager)localObject).a();
      ((QvipSpecialSoundManager)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.1
 * JD-Core Version:    0.7.0.1
 */