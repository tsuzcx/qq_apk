package dov.com.qq.im.ae.play;

import biwo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(biwo parambiwo) {}
  
  public void run()
  {
    synchronized (biwo.a(this.this$0))
    {
      List localList = biwo.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + biwo.b(this.this$0).hashCode());
      }
      if ((biwo.b(this.this$0) == null) || (biwo.b(this.this$0).size() < 1) || (localList.hashCode() != biwo.b(this.this$0).hashCode()))
      {
        if (biwo.b(this.this$0) != null)
        {
          biwo.b(this.this$0).clear();
          biwo.b(this.this$0).addAll(localList);
        }
        biwo.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */