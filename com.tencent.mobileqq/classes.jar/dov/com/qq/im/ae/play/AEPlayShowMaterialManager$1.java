package dov.com.qq.im.ae.play;

import bowy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(bowy parambowy) {}
  
  public void run()
  {
    synchronized (bowy.a(this.this$0))
    {
      List localList = bowy.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + bowy.b(this.this$0).hashCode());
      }
      if ((bowy.b(this.this$0) == null) || (bowy.b(this.this$0).size() < 1) || (localList.hashCode() != bowy.b(this.this$0).hashCode()))
      {
        if (bowy.b(this.this$0) != null)
        {
          bowy.b(this.this$0).clear();
          bowy.b(this.this$0).addAll(localList);
        }
        bowy.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */