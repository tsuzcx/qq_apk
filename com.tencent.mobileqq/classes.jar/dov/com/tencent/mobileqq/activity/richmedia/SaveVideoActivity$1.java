package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.common.app.AppInterface;
import dov.com.qq.im.capture.CaptureContext;

class SaveVideoActivity$1
  implements Runnable
{
  SaveVideoActivity$1(SaveVideoActivity paramSaveVideoActivity, String paramString) {}
  
  public void run()
  {
    AppInterface localAppInterface = CaptureContext.a();
    SaveVideoActivity.a(localAppInterface, SaveVideoActivity.a(localAppInterface, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */