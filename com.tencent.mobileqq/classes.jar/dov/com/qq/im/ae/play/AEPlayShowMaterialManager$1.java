package dov.com.qq.im.ae.play;

import bnvo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(bnvo parambnvo) {}
  
  public void run()
  {
    synchronized (bnvo.a(this.this$0))
    {
      List localList = bnvo.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + bnvo.b(this.this$0).hashCode());
      }
      if ((bnvo.b(this.this$0) == null) || (bnvo.b(this.this$0).size() < 1) || (localList.hashCode() != bnvo.b(this.this$0).hashCode()))
      {
        if (bnvo.b(this.this$0) != null)
        {
          bnvo.b(this.this$0).clear();
          bnvo.b(this.this$0).addAll(localList);
        }
        bnvo.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */