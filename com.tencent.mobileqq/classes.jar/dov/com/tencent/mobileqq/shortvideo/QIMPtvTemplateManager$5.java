package dov.com.tencent.mobileqq.shortvideo;

import bltq;
import bnpl;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class QIMPtvTemplateManager$5
  implements Runnable
{
  public QIMPtvTemplateManager$5(bnpl parambnpl, File paramFile) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, templateInfos[%s]", new Object[] { localList }));
    }
    if (localList != null) {}
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.jdField_a_of_type_JavaUtilList.addAll(localList);
      if (this.this$0.a() != null) {
        this.this$0.a().notifyObservers(bltq.class, 3, true, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */