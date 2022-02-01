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
      if (FileUtil.d(this.a))
      {
        ProfileCardShareHelper.a(this.this$0, BitmapFactory.decodeFile(ProfileCardShareHelper.c(this.this$0)));
        localBitmap = ProfileCardShareHelper.h(this.this$0);
      }
      else
      {
        localBitmap = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130841061);
        QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace facePath: %s is not exist", new Object[] { this.a }));
      }
      ThreadManager.getUIHandler().post(new ProfileCardShareHelper.3.1(this, localBitmap));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ProfileCardShareHelper", 1, "decode bitmap exception...", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("ProfileCardShareHelper", 1, "decode bitmap oom...", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3
 * JD-Core Version:    0.7.0.1
 */