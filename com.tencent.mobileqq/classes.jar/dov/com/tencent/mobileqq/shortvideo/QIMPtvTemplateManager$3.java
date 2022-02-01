package dov.com.tencent.mobileqq.shortvideo;

import bcls;
import bgnt;
import bqgc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class QIMPtvTemplateManager$3
  implements Runnable
{
  public QIMPtvTemplateManager$3(bqgc parambqgc) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = bcls.a();
    boolean bool2 = bgnt.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.this$0.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */