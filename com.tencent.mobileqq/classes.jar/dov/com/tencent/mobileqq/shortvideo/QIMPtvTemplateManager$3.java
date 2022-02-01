package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class QIMPtvTemplateManager$3
  implements Runnable
{
  QIMPtvTemplateManager$3(QIMPtvTemplateManager paramQIMPtvTemplateManager) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = PtvFilterSoLoad.a();
    boolean bool2 = NetworkUtil.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.this$0.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */