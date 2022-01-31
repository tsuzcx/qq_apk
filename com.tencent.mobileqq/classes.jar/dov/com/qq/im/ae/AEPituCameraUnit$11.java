package dov.com.qq.im.ae;

import android.app.Activity;
import bijd;
import bjaj;
import bjrl;

public class AEPituCameraUnit$11
  implements Runnable
{
  public AEPituCameraUnit$11(bijd parambijd) {}
  
  public void run()
  {
    Activity localActivity = bijd.a(this.this$0).a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (bijd.a(this.this$0) == null) {
      bijd.a(this.this$0, new bjaj(localActivity));
    }
    bijd.a(this.this$0).a(new AEPituCameraUnit.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */