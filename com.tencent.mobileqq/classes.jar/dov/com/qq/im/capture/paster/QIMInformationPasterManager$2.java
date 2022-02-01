package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bhnv;
import bpqn;
import bpqo;
import bpqr;
import bqpa;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bpqn parambpqn, List paramList) {}
  
  public void run()
  {
    bpqn.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bhnv.g(bpqn.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bqpa localbqpa;
      while (localIterator.hasNext())
      {
        localbqpa = (bqpa)localIterator.next();
        if ((!TextUtils.isEmpty(localbqpa.e)) && (!this.this$0.a(localbqpa)) && (localbqpa.b != 2)) {
          bpqn.a(this.this$0).add(localbqpa);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bpqn.a(this.this$0).size());
      }
      localIterator = bpqn.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbqpa = (bqpa)localIterator.next();
        this.this$0.a.a(localbqpa, new bpqo(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */