package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bbev;
import bjfa;
import bjfb;
import bjfe;
import bkfm;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bjfa parambjfa, List paramList) {}
  
  public void run()
  {
    bjfa.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bbev.g(bjfa.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bkfm localbkfm;
      while (localIterator.hasNext())
      {
        localbkfm = (bkfm)localIterator.next();
        if ((!TextUtils.isEmpty(localbkfm.e)) && (!this.this$0.a(localbkfm)) && (localbkfm.b != 2)) {
          bjfa.a(this.this$0).add(localbkfm);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bjfa.a(this.this$0).size());
      }
      localIterator = bjfa.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbkfm = (bkfm)localIterator.next();
        this.this$0.a.a(localbkfm, new bjfb(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */