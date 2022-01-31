package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bdfb;
import com.tencent.qphone.base.util.QLog;

class AuthorityActivity$2
  implements Runnable
{
  AuthorityActivity$2(AuthorityActivity paramAuthorityActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap3 = null;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.this$0.getResources(), 2130839736);
      localBitmap3 = bdfb.a(this.this$0, localBitmap1, 63, 63);
      if (localBitmap1 != null) {
        localBitmap1.recycle();
      }
      this.this$0.runOnUiThread(new AuthorityActivity.2.1(this, localBitmap3));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap2 = localBitmap3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorityActivity", 2, "initUI decodeResource has OutOfMemoryError!");
          localBitmap2 = localBitmap3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.2
 * JD-Core Version:    0.7.0.1
 */