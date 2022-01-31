package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import badq;
import bhki;
import bhkj;
import bhkm;
import bior;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bhki parambhki, List paramList) {}
  
  public void run()
  {
    bhki.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!badq.g(bhki.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bior localbior;
      while (localIterator.hasNext())
      {
        localbior = (bior)localIterator.next();
        if ((!TextUtils.isEmpty(localbior.e)) && (!this.this$0.a(localbior)) && (localbior.b != 2)) {
          bhki.a(this.this$0).add(localbior);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bhki.a(this.this$0).size());
      }
      localIterator = bhki.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbior = (bior)localIterator.next();
        this.this$0.a.a(localbior, new bhkj(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */