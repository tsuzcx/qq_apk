package cooperation.qzone.networkedmodule;

import axrn;
import com.tencent.qphone.base.util.QLog;

class QzoneModuleManager$2
  implements Runnable
{
  QzoneModuleManager$2(QzoneModuleManager paramQzoneModuleManager) {}
  
  public void run()
  {
    int i = axrn.a();
    QLog.i("QzoneModuleManager", 1, "current versionNum is:" + i);
    axrn.a(i + 6000);
    QzoneModuleManager.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager.2
 * JD-Core Version:    0.7.0.1
 */