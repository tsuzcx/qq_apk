package dov.com.qq.im.ae.cmshow;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AECMShowRequestController$1
  implements Runnable
{
  AECMShowRequestController$1(AECMShowRequestController paramAECMShowRequestController) {}
  
  public void run()
  {
    if (AECMShowRequestController.a(this.this$0) + 2 > 99)
    {
      AECMShowRequestController.a(this.this$0, 99);
      if (AECMShowRequestController.a(this.this$0) != null) {
        AECMShowRequestController.a(this.this$0).b(AECMShowRequestController.a(this.this$0));
      }
      ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.a(this.this$0));
      return;
    }
    AECMShowRequestController.a(this.this$0, AECMShowRequestController.a(this.this$0) + 2);
    if (AECMShowRequestController.a(this.this$0) != null) {
      AECMShowRequestController.a(this.this$0).b(AECMShowRequestController.a(this.this$0));
    }
    ThreadManager.getUIHandler().postDelayed(AECMShowRequestController.a(this.this$0), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowRequestController.1
 * JD-Core Version:    0.7.0.1
 */