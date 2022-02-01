package dov.com.qq.im.ae.camera.ui.bottom;

import bnbg;
import bncv;
import bnkb;
import bnke;
import bnpz;
import bnrh;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$3
  implements Runnable
{
  public AEBottomListAdapter$3(bncv parambncv, bnke parambnke) {}
  
  public void run()
  {
    if (bncv.a(this.this$0).getVisibility() == 0)
    {
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] visible, select material " + this.a.a);
      bncv.a(this.this$0).a(this.a, true);
    }
    if (bncv.a(this.this$0).getVisibility() == 0)
    {
      if (bncv.a(this.this$0).b())
      {
        bncv.a(this.this$0).a(this.a);
        return;
      }
      bnrh.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
      return;
    }
    bnrh.d("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */