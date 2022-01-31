package dov.com.qq.im.ae;

import android.app.Activity;
import bkpl;
import bljp;
import bmhh;

public class AEPituCameraUnit$11
  implements Runnable
{
  public AEPituCameraUnit$11(bkpl parambkpl) {}
  
  public void run()
  {
    Activity localActivity = bkpl.a(this.this$0).a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (bkpl.a(this.this$0) == null) {
      bkpl.a(this.this$0, new bljp(localActivity));
    }
    bkpl.a(this.this$0).a(new AEPituCameraUnit.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */