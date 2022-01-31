package com.tencent.mobileqq.profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import apvd;
import auvb;
import baxi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ProfileCardShareHelper$3
  implements Runnable
{
  public ProfileCardShareHelper$3(auvb paramauvb, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap;
      if (apvd.a(this.a))
      {
        auvb.a(this.this$0, BitmapFactory.decodeFile(auvb.b(this.this$0)));
        localBitmap = auvb.a(this.this$0);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new ProfileCardShareHelper.3.1(this, localBitmap));
        return;
        localBitmap = baxi.b(BaseApplicationImpl.getApplication().getResources(), 2130839737);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.3
 * JD-Core Version:    0.7.0.1
 */