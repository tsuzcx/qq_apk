package dov.com.qq.im.ae.camera.ui.bottom;

import bilv;
import birb;
import bire;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$3
  implements Runnable
{
  public AEBottomListAdapter$3(bilv parambilv, bire parambire) {}
  
  public void run()
  {
    if (bilv.a(this.this$0).getVisibility() == 0)
    {
      bilv.a(this.this$0).a(this.a, true);
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */