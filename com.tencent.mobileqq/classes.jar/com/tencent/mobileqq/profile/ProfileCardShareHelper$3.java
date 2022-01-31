package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import arof;
import awmn;
import bcwc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ProfileCardShareHelper$3
  implements Runnable
{
  public ProfileCardShareHelper$3(awmn paramawmn, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap;
      if (arof.a(this.a))
      {
        awmn.a(this.this$0, BitmapFactory.decodeFile(awmn.b(this.this$0)));
        localBitmap = awmn.a(this.this$0);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new ProfileCardShareHelper.3.1(this, localBitmap));
        return;
        localBitmap = bcwc.b(BaseApplicationImpl.getApplication().getResources(), 2130840085);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3
 * JD-Core Version:    0.7.0.1
 */