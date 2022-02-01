package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bmug;
import bmuh;
import bmuk;
import bnli;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bmug parambmug, List paramList) {}
  
  public void run()
  {
    bmug.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!NetworkUtil.isNetworkAvailable(bmug.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bnli localbnli;
      while (localIterator.hasNext())
      {
        localbnli = (bnli)localIterator.next();
        if ((!TextUtils.isEmpty(localbnli.e)) && (!this.this$0.a(localbnli)) && (localbnli.b != 2)) {
          bmug.a(this.this$0).add(localbnli);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bmug.a(this.this$0).size());
      }
      localIterator = bmug.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbnli = (bnli)localIterator.next();
        this.this$0.a.a(localbnli, new bmuh(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */