package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

class QfileLocalFileDelMediaTabView$1
  implements Runnable
{
  QfileLocalFileDelMediaTabView$1(QfileLocalFileDelMediaTabView paramQfileLocalFileDelMediaTabView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.this$0;
    ((QfileLocalFileDelMediaTabView)localObject).jdField_b_of_type_Boolean = true;
    ((QfileLocalFileDelMediaTabView)localObject).jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    localObject = new TreeMap(new QfileLocalFileDelMediaTabView.1.1(this));
    Iterator localIterator = QfileLocalFileDelMediaTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QfileTabBarView.ScanParams localScanParams = (QfileTabBarView.ScanParams)localIterator.next();
      QfileLocalFileDelMediaTabView.a(this.this$0, localScanParams.a(), localScanParams, this.this$0.jdField_b_of_type_JavaUtilList, 2, (TreeMap)localObject, 1000, null);
    }
    QQFileManagerUtil.a((TreeMap)localObject, 0, this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelMediaTabView.a(this.this$0, new QfileLocalFileDelMediaTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */