package dov.com.qq.im.AECamera;

import bgyb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(bgyb parambgyb) {}
  
  public void run()
  {
    synchronized (bgyb.a(this.this$0))
    {
      List localList = bgyb.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + bgyb.b(this.this$0).hashCode());
      }
      if ((bgyb.b(this.this$0) == null) || (bgyb.b(this.this$0).size() < 1) || (localList.hashCode() != bgyb.b(this.this$0).hashCode()))
      {
        if (bgyb.b(this.this$0) != null)
        {
          bgyb.b(this.this$0).clear();
          bgyb.b(this.this$0).addAll(localList);
        }
        bgyb.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */