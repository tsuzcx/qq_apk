package dov.com.qq.im.ae.camera.ui.bottom;

import bilv;
import bilw;
import java.util.List;
import naj;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(bilw parambilw) {}
  
  public void run()
  {
    int i = naj.a();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (bilv.a(this.a.a).size() > 1)) {
      bilv.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */