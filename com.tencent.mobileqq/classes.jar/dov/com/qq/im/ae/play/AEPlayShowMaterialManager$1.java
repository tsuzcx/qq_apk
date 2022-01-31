package dov.com.qq.im.ae.play;

import blgg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(blgg paramblgg) {}
  
  public void run()
  {
    synchronized (blgg.a(this.this$0))
    {
      List localList = blgg.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + blgg.b(this.this$0).hashCode());
      }
      if ((blgg.b(this.this$0) == null) || (blgg.b(this.this$0).size() < 1) || (localList.hashCode() != blgg.b(this.this$0).hashCode()))
      {
        if (blgg.b(this.this$0) != null)
        {
          blgg.b(this.this$0).clear();
          blgg.b(this.this$0).addAll(localList);
        }
        blgg.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */