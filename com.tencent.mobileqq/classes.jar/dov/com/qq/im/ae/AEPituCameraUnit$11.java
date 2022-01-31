package dov.com.qq.im.ae;

import android.app.Activity;
import biim;
import bizs;
import bjqu;

public class AEPituCameraUnit$11
  implements Runnable
{
  public AEPituCameraUnit$11(biim parambiim) {}
  
  public void run()
  {
    Activity localActivity = biim.a(this.this$0).a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (biim.a(this.this$0) == null) {
      biim.a(this.this$0, new bizs(localActivity));
    }
    biim.a(this.this$0).a(new AEPituCameraUnit.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */