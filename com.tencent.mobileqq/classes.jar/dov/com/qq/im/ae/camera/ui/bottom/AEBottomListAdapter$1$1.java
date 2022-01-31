package dov.com.qq.im.ae.camera.ui.bottom;

import bile;
import bilf;
import java.util.List;
import nam;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(bilf parambilf) {}
  
  public void run()
  {
    int i = nam.a();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (bile.a(this.a.a).size() > 1)) {
      bile.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */