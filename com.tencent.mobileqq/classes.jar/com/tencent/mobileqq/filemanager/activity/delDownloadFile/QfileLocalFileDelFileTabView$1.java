package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.util.Pair;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

class QfileLocalFileDelFileTabView$1
  implements Runnable
{
  QfileLocalFileDelFileTabView$1(QfileLocalFileDelFileTabView paramQfileLocalFileDelFileTabView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.this$0;
    ((QfileLocalFileDelFileTabView)localObject).jdField_b_of_type_Boolean = true;
    ((QfileLocalFileDelFileTabView)localObject).jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.this$0.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    localObject = new TreeMap(new QfileLocalFileDelFileTabView.1.1(this));
    Iterator localIterator = QfileLocalFileDelFileTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QfileTabBarView.ScanParams localScanParams = (QfileTabBarView.ScanParams)localIterator.next();
      QfileLocalFileDelFileTabView.a(this.this$0, localScanParams.a(), localScanParams, this.this$0.jdField_b_of_type_JavaUtilList, ((Integer)this.this$0.jdField_a_of_type_ComTencentUtilPair.second).intValue(), (TreeMap)localObject, 1000, null);
    }
    QQFileManagerUtil.a((TreeMap)localObject, ((Integer)this.this$0.jdField_a_of_type_ComTencentUtilPair.second).intValue(), this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, this.this$0.jdField_b_of_type_JavaUtilLinkedHashMap, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelFileTabView.a(this.this$0, new QfileLocalFileDelFileTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.1
 * JD-Core Version:    0.7.0.1
 */