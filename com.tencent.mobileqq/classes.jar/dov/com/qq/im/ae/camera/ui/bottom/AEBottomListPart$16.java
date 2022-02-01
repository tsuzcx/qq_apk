package dov.com.qq.im.ae.camera.ui.bottom;

import bnda;
import bndg;
import bnkb;
import bnke;
import bnki;
import bnrh;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class AEBottomListPart$16
  implements Runnable
{
  public AEBottomListPart$16(bnda parambnda, String paramString) {}
  
  public void run()
  {
    Object localObject = bnki.a().a();
    localObject = bnda.a(this.this$0, this.a, (List)localObject);
    if (localObject != null)
    {
      if (((bnke)localObject).e)
      {
        ThreadManager.getUIHandler().post(new AEBottomListPart.16.1(this, (bnke)localObject));
        return;
      }
      this.this$0.a.a(this.this$0.a.getApp(), (bnke)localObject, new bndg(this, (bnke)localObject));
      return;
    }
    bnrh.d("AEBottomListPart", "meta data is null =======");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16
 * JD-Core Version:    0.7.0.1
 */