package dov.com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PtvTemplateManager$14
  implements Runnable
{
  public void run()
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        bool = true;
        QLog.i("PtvTemplateManager", 2, String.format("initBlessSpecialPendantConfigInfo, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.this$0.jdField_e_of_type_Boolean), Integer.valueOf(hashCode()) }));
      }
    }
    else {
      if (!this.this$0.jdField_e_of_type_Boolean) {
        break label76;
      }
    }
    label76:
    Object localObject1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = PtvTemplateManager.a(this.this$0, (String)localObject1);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    ??? = ((List)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
      if (localPtvTemplateInfo != null)
      {
        localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
        localPtvTemplateInfo.businessID = 1;
      }
    }
    synchronized (this.this$0.jdField_e_of_type_JavaUtilArrayList)
    {
      if (this.this$0.jdField_e_of_type_Boolean) {
        return;
      }
    }
    this.this$0.jdField_e_of_type_JavaUtilArrayList.clear();
    this.this$0.jdField_e_of_type_JavaUtilArrayList.addAll(localCollection);
    this.this$0.f = true;
    PtvTemplateManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.14
 * JD-Core Version:    0.7.0.1
 */