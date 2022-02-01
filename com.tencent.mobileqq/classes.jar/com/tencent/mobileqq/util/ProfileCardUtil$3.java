package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProfileCardUtil$3
  implements Runnable
{
  ProfileCardUtil$3(String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.a);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      boolean bool = ((File)localObject).delete();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete result=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" f.path=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.3
 * JD-Core Version:    0.7.0.1
 */