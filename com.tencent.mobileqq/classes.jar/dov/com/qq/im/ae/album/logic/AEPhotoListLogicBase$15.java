package dov.com.qq.im.ae.album.logic;

import blmi;
import bmbx;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AEPhotoListLogicBase$15
  implements Runnable
{
  public AEPhotoListLogicBase$15(blmi paramblmi, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    bmbx.b("AEPhotoListLogicBase", "serialCompressVideos---begin, need compress count=" + this.a.size());
    blmi.b(this.this$0, false);
    blmi.a(this.this$0, this.a);
    bmbx.b("AEPhotoListLogicBase", "serialCompressVideos---end, canceled=" + blmi.a(this.this$0));
    if ((!blmi.a(this.this$0)) && (!blmi.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.1(this));
    }
    for (;;)
    {
      blmi.a(this.this$0, false);
      blmi.b(this.this$0, false);
      return;
      ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.15.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.15
 * JD-Core Version:    0.7.0.1
 */