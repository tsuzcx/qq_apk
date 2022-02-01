package dov.com.qq.im.ae.camera.ui.bottom;

import bolg;
import boqr;
import boqu;
import com.tencent.qphone.base.util.QLog;

public class AEBottomListAdapter$3
  implements Runnable
{
  public AEBottomListAdapter$3(bolg parambolg, boqu paramboqu) {}
  
  public void run()
  {
    if (bolg.a(this.this$0).getVisibility() == 0)
    {
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] visible, select material " + this.a.a);
      bolg.a(this.this$0).a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */