package dov.com.qq.im.capture;

import com.tencent.common.app.AppInterface;

public abstract class IQIMManager
{
  public AppInterface getApp()
  {
    return CaptureContext.a();
  }
  
  public abstract void onDestroy();
  
  public abstract void onInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.IQIMManager
 * JD-Core Version:    0.7.0.1
 */