package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AEPhotoListLogicBase$15
  implements Runnable
{
  AEPhotoListLogicBase$15(AEPhotoListLogicBase paramAEPhotoListLogicBase, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    AEQLog.b("AEPhotoListLogicBase", "serialCompressVideos---begin, need compress count=" + this.a.size());
    AEPhotoListLogicBase.b(this.this$0, false);
    AEPhotoListLogicBase.a(this.this$0, this.a);
    AEQLog.b("AEPhotoListLogicBase", "serialCompressVideos---end, canceled=" + AEPhotoListLogicBase.a(this.this$0));
    if ((!AEPhotoListLogicBase.a(this.this$0)) && (!AEPhotoListLogicBase.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.1(this));
    }
    for (;;)
    {
      AEPhotoListLogicBase.a(this.this$0, false);
      AEPhotoListLogicBase.b(this.this$0, false);
      return;
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.15
 * JD-Core Version:    0.7.0.1
 */