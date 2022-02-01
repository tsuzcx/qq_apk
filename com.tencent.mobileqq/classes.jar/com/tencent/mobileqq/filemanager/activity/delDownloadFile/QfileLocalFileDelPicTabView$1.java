package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

class QfileLocalFileDelPicTabView$1
  implements Runnable
{
  QfileLocalFileDelPicTabView$1(QfileLocalFileDelPicTabView paramQfileLocalFileDelPicTabView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    this.this$0.jdField_b_of_type_Boolean = true;
    this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    TreeMap localTreeMap = new TreeMap(new QfileLocalFileDelPicTabView.1.1(this));
    Iterator localIterator = QfileLocalFileDelPicTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QfileTabBarView.ScanParams localScanParams = (QfileTabBarView.ScanParams)localIterator.next();
      QfileLocalFileDelPicTabView.a(this.this$0, localScanParams.a(), localScanParams, this.this$0.jdField_b_of_type_JavaUtilList, 0, localTreeMap, 1000, null);
    }
    FileCategoryUtil.a(localTreeMap, 0, this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelPicTabView.a(this.this$0, new QfileLocalFileDelPicTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1
 * JD-Core Version:    0.7.0.1
 */