package dov.com.qq.im.ae.camera.ui.bottom;

import bkur;
import bkzy;
import blab;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$5
  implements Runnable
{
  public AEBottomListAdapter$5(bkur parambkur, blab paramblab) {}
  
  public void run()
  {
    if (bkur.a(this.this$0).getVisibility() == 0)
    {
      bkur.a(this.this$0).a(this.a, true);
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.5
 * JD-Core Version:    0.7.0.1
 */