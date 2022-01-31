package dov.com.qq.im.ae.camera.ui.bottom;

import bkur;
import bkuy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEBottomListPart$7
  implements Runnable
{
  public AEBottomListPart$7(bkuy parambkuy, long paramLong) {}
  
  public void run()
  {
    if (bkuy.b(this.this$0))
    {
      bkuy.a(this.this$0).setVisibility(0);
      bkuy.a(this.this$0).a(new ArrayList());
      QLog.d("AEWaterMarkListPart", 4, "hot data is empty, updatePackage, total cost=" + (System.currentTimeMillis() - this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */