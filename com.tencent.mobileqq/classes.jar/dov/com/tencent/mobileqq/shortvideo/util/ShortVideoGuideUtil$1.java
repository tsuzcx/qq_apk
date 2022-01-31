package dov.com.tencent.mobileqq.shortvideo.util;

import bjlp;
import bjlq;
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
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication().getApplicationContext(), new bjlq(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(bjlp.a, 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil.1
 * JD-Core Version:    0.7.0.1
 */