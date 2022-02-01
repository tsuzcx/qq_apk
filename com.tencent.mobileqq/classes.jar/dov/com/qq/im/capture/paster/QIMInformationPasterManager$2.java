package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bgnt;
import boos;
import boot;
import boow;
import bpnf;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(boos paramboos, List paramList) {}
  
  public void run()
  {
    boos.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!bgnt.g(boos.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bpnf localbpnf;
      while (localIterator.hasNext())
      {
        localbpnf = (bpnf)localIterator.next();
        if ((!TextUtils.isEmpty(localbpnf.e)) && (!this.this$0.a(localbpnf)) && (localbpnf.b != 2)) {
          boos.a(this.this$0).add(localbpnf);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + boos.a(this.this$0).size());
      }
      localIterator = boos.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbpnf = (bpnf)localIterator.next();
        this.this$0.a.a(localbpnf, new boot(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */