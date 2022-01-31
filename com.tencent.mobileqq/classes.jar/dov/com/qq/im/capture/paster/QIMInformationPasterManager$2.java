package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bdin;
import blvo;
import blvp;
import blvs;
import bmvz;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(blvo paramblvo, List paramList) {}
  
  public void run()
  {
    blvo.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bdin.g(blvo.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bmvz localbmvz;
      while (localIterator.hasNext())
      {
        localbmvz = (bmvz)localIterator.next();
        if ((!TextUtils.isEmpty(localbmvz.e)) && (!this.this$0.a(localbmvz)) && (localbmvz.b != 2)) {
          blvo.a(this.this$0).add(localbmvz);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + blvo.a(this.this$0).size());
      }
      localIterator = blvo.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbmvz = (bmvz)localIterator.next();
        this.this$0.a.a(localbmvz, new blvp(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */