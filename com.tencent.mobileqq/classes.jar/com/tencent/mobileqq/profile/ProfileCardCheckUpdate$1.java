package com.tencent.mobileqq.profile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;

class ProfileCardCheckUpdate$1
  implements Runnable
{
  ProfileCardCheckUpdate$1(ProfileCardCheckUpdate paramProfileCardCheckUpdate) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = VasUtil.a().getSpecialSoundManager();
      ((IQvipSpecialSoundManager)localObject).updateSpecialSoundConfig();
      ((IQvipSpecialSoundManager)localObject).parseSpecialSoundConfigFile();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardCheckUpdate.1
 * JD-Core Version:    0.7.0.1
 */