package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import auog;
import azxu;
import bhgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ProfileCardShareHelper$3
  implements Runnable
{
  public ProfileCardShareHelper$3(azxu paramazxu, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap;
      if (auog.a(this.a))
      {
        azxu.a(this.this$0, BitmapFactory.decodeFile(azxu.b(this.this$0)));
        localBitmap = azxu.a(this.this$0);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new ProfileCardShareHelper.3.1(this, localBitmap));
        return;
        localBitmap = bhgm.b(BaseApplicationImpl.getApplication().getResources(), 2130840275);
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