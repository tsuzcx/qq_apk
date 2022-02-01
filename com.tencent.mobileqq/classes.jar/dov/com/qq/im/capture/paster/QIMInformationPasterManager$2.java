package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import bojy;
import bojz;
import bokc;
import bpba;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(bojy parambojy, List paramList) {}
  
  public void run()
  {
    bojy.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!NetworkUtil.isNetworkAvailable(bojy.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      bpba localbpba;
      while (localIterator.hasNext())
      {
        localbpba = (bpba)localIterator.next();
        if ((!TextUtils.isEmpty(localbpba.e)) && (!this.this$0.a(localbpba)) && (localbpba.b != 2)) {
          bojy.a(this.this$0).add(localbpba);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + bojy.a(this.this$0).size());
      }
      localIterator = bojy.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localbpba = (bpba)localIterator.next();
        this.this$0.a.a(localbpba, new bojz(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */