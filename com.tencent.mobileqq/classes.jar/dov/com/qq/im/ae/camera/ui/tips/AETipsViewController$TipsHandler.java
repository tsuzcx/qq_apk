package dov.com.qq.im.ae.camera.ui.tips;

import android.os.Handler;
import android.os.Message;

class AETipsViewController$TipsHandler
  extends Handler
{
  private AETipsViewController$TipsHandler(AETipsViewController paramAETipsViewController) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1004: 
    case 1009: 
      AETipsViewController.a(this.a);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.tips.AETipsViewController.TipsHandler
 * JD-Core Version:    0.7.0.1
 */