package dov.com.qq.im.ae.play;

import bixf;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(bixf parambixf) {}
  
  public void run()
  {
    synchronized (bixf.a(this.this$0))
    {
      List localList = bixf.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + bixf.b(this.this$0).hashCode());
      }
      if ((bixf.b(this.this$0) == null) || (bixf.b(this.this$0).size() < 1) || (localList.hashCode() != bixf.b(this.this$0).hashCode()))
      {
        if (bixf.b(this.this$0) != null)
        {
          bixf.b(this.this$0).clear();
          bixf.b(this.this$0).addAll(localList);
        }
        bixf.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */