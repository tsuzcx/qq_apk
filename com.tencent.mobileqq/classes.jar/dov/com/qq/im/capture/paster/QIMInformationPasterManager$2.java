package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bbfj;
import bjfr;
import bjfs;
import bjfv;
import bkgd;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bjfr parambjfr, List paramList) {}
  
  public void run()
  {
    bjfr.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bbfj.g(bjfr.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bkgd localbkgd;
      while (localIterator.hasNext())
      {
        localbkgd = (bkgd)localIterator.next();
        if ((!TextUtils.isEmpty(localbkgd.e)) && (!this.this$0.a(localbkgd)) && (localbkgd.b != 2)) {
          bjfr.a(this.this$0).add(localbkgd);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bjfr.a(this.this$0).size());
      }
      localIterator = bjfr.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbkgd = (bkgd)localIterator.next();
        this.this$0.a.a(localbkgd, new bjfs(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */