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
  private Uri jdField_a_of_type_AndroidNetUri;
  
  public ScreenShotDetector$MediaContentObserver(ScreenShotDetector paramScreenShotDetector, Uri paramUri, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidNetUri = paramUri;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector.a()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector.MediaContentObserver
 * JD-Core Version:    0.7.0.1
 */