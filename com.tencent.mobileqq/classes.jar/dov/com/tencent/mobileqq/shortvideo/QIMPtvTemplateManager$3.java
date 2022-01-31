package dov.com.tencent.mobileqq.shortvideo;

import azkt;
import bdin;
import bnpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class QIMPtvTemplateManager$3
  implements Runnable
{
  public QIMPtvTemplateManager$3(bnpl parambnpl) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = azkt.c();
    boolean bool2 = bdin.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.this$0.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */