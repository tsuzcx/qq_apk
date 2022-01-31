package com.tencent.mobileqq.shortvideo.util;

import azla;
import azlb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public final class ShortVideoGuideUtil$1
  implements Runnable
{
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication().getApplicationContext(), new azlb(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(azla.a, 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil.1
 * JD-Core Version:    0.7.0.1
 */