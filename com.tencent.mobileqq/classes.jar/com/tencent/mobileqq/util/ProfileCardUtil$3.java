package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProfileCardUtil$3
  implements Runnable
{
  ProfileCardUtil$3(String paramString) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      boolean bool = localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, "delete result=" + bool + " f.path=" + this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.3
 * JD-Core Version:    0.7.0.1
 */