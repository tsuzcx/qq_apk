package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class QfileBaseRecentFileTabView$2
  implements Runnable
{
  QfileBaseRecentFileTabView$2(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB thread start");
    }
    List localList;
    if ((this.this$0.b != null) && (this.this$0.b.trim().length() != 0)) {
      localList = ((IQQFileDataCenter)QfileBaseRecentFileTabView.a(this.this$0).getRuntimeService(IQQFileDataCenter.class)).queryMaxRecentReocrdsWithUin(this.this$0.b);
    } else {
      localList = ((IQQFileDataCenter)QfileBaseRecentFileTabView.b(this.this$0).getRuntimeService(IQQFileDataCenter.class)).queryMaxRecentReocrds();
    }
    Collections.sort(localList, this.this$0.jdField_a_of_type_JavaUtilComparator);
    if (localList != null) {
      QfileBaseRecentFileTabView.a(this.this$0, new QfileBaseRecentFileTabView.2.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2
 * JD-Core Version:    0.7.0.1
 */