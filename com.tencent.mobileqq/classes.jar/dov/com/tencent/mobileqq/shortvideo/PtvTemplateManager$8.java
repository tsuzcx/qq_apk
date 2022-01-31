package dov.com.tencent.mobileqq.shortvideo;

import axlc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class PtvTemplateManager$8
  implements Runnable
{
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaIoFile, null);
    if (localList != null) {}
    synchronized (this.this$0.jdField_c_of_type_JavaLangObject)
    {
      if (this.this$0.jdField_c_of_type_Boolean) {
        return;
      }
      this.this$0.b.clear();
      this.this$0.b.addAll(localList);
      this.this$0.d = true;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (axlc.c())) {
        this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.b);
      }
      PtvTemplateManager.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */