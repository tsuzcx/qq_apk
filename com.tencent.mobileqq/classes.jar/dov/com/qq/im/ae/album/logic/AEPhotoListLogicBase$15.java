package dov.com.qq.im.ae.album.logic;

import bmzr;
import bnrh;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AEPhotoListLogicBase$15
  implements Runnable
{
  public AEPhotoListLogicBase$15(bmzr parambmzr, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    bnrh.b("AEPhotoListLogicBase", "serialCompressVideos---begin, need compress count=" + this.a.size());
    bmzr.b(this.this$0, false);
    bmzr.a(this.this$0, this.a);
    bnrh.b("AEPhotoListLogicBase", "serialCompressVideos---end, canceled=" + bmzr.a(this.this$0));
    if ((!bmzr.a(this.this$0)) && (!bmzr.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.1(this));
    }
    for (;;)
    {
      bmzr.a(this.this$0, false);
      bmzr.b(this.this$0, false);
      return;
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.15
 * JD-Core Version:    0.7.0.1
 */