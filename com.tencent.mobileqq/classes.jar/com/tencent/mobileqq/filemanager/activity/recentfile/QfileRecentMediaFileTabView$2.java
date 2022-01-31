package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentMediaFileTabView$2
  implements Runnable
{
  QfileRecentMediaFileTabView$2(QfileRecentMediaFileTabView paramQfileRecentMediaFileTabView, String paramString, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (!this.this$0.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.a.put(this.jdField_a_of_type_JavaLangString, new ArrayList());
    }
    List localList = (List)this.this$0.a.get(this.jdField_a_of_type_JavaLangString);
    if (localList.contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) == true) {
      return;
    }
    localList.add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView.2
 * JD-Core Version:    0.7.0.1
 */