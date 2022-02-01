package com.tencent.mobileqq.screendetect;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ScreenShotDetector$MediaContentObserver
  extends ContentObserver
{
  private Uri b;
  
  public ScreenShotDetector$MediaContentObserver(ScreenShotDetector paramScreenShotDetector, Uri paramUri, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramUri;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.a.b()) {
      return;
    }
    try
    {
      ThreadManager.getSubThreadHandler().post(new ScreenShotDetector.MediaContentObserver.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ScreenShotDetector", 2, "ScreenShot: onChange error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector.MediaContentObserver
 * JD-Core Version:    0.7.0.1
 */