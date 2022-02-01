package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ProfileCardShareHelper$3
  implements Runnable
{
  ProfileCardShareHelper$3(ProfileCardShareHelper paramProfileCardShareHelper, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap;
      if (FileUtil.a(this.a))
      {
        ProfileCardShareHelper.a(this.this$0, BitmapFactory.decodeFile(ProfileCardShareHelper.b(this.this$0)));
        localBitmap = ProfileCardShareHelper.a(this.this$0);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new ProfileCardShareHelper.3.1(this, localBitmap));
        return;
        localBitmap = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130840453);
        QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace facePath: %s is not exist", new Object[] { this.a }));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("ProfileCardShareHelper", 1, "decode bitmap oom...", localOutOfMemoryError);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ProfileCardShareHelper", 1, "decode bitmap exception...", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3
 * JD-Core Version:    0.7.0.1
 */