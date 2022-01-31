package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileBaseRecentFileTabView$11
  implements Runnable
{
  QfileBaseRecentFileTabView$11(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) && (this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap != null) && (this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0))
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((FileManagerEntity)((Iterator)localObject).next()).sendCloudUnsuccessful()) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    this.this$0.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.11
 * JD-Core Version:    0.7.0.1
 */