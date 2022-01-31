package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bdee;
import blrc;
import blrd;
import blrg;
import bmrn;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(blrc paramblrc, List paramList) {}
  
  public void run()
  {
    blrc.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bdee.g(blrc.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bmrn localbmrn;
      while (localIterator.hasNext())
      {
        localbmrn = (bmrn)localIterator.next();
        if ((!TextUtils.isEmpty(localbmrn.e)) && (!this.this$0.a(localbmrn)) && (localbmrn.b != 2)) {
          blrc.a(this.this$0).add(localbmrn);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + blrc.a(this.this$0).size());
      }
      localIterator = blrc.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbmrn = (bmrn)localIterator.next();
        this.this$0.a.a(localbmrn, new blrd(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */