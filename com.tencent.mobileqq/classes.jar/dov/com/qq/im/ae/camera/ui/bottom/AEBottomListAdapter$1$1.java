package dov.com.qq.im.ae.camera.ui.bottom;

import bkur;
import bkus;
import java.util.List;
import ndd;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(bkus parambkus) {}
  
  public void run()
  {
    int i = ndd.a();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (bkur.a(this.a.a).size() > 1)) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */