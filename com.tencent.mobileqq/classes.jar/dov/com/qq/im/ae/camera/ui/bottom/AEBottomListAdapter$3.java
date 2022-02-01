package dov.com.qq.im.ae.camera.ui.bottom;

import blnv;
import blpm;
import bluy;
import blvb;
import bmap;
import bmbx;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$3
  implements Runnable
{
  public AEBottomListAdapter$3(blpm paramblpm, blvb paramblvb) {}
  
  public void run()
  {
    if (blpm.a(this.this$0).getVisibility() == 0)
    {
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] visible, select material " + this.a.a);
      blpm.a(this.this$0).a(this.a, true);
    }
    if (blpm.a(this.this$0).getVisibility() == 0)
    {
      if (blpm.a(this.this$0).b())
      {
        blpm.a(this.this$0).a(this.a);
        return;
      }
      bmbx.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
      return;
    }
    bmbx.d("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */