package dov.com.qq.im.ae.camera.ui.bottom;

import bncv;
import bncw;
import com.tencent.biz.common.util.HttpUtil;
import java.util.List;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(bncw parambncw) {}
  
  public void run()
  {
    int i = HttpUtil.getNetWorkType();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (bncv.a(this.a.a).size() > 1)) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */