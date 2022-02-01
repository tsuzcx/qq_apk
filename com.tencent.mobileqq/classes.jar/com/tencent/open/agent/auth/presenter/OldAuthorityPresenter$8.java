package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class OldAuthorityPresenter$8
  implements Runnable
{
  OldAuthorityPresenter$8(OldAuthorityPresenter paramOldAuthorityPresenter, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap2;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.this$0.jdField_a_of_type_AndroidAppActivity.getResources(), 2130840321);
    }
    catch (Throwable localThrowable)
    {
      SSOLog.c("OldAuthorityPresenter", "useDefaultIcon", localThrowable);
      localBitmap2 = null;
    }
    if (localBitmap2 == null) {
      return;
    }
    Bitmap localBitmap3 = AuthorityUtil.a(this.this$0.jdField_a_of_type_AndroidAppActivity, localBitmap2, 63, 63);
    localBitmap2.recycle();
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new OldAuthorityPresenter.8.1(this, localBitmap3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.8
 * JD-Core Version:    0.7.0.1
 */