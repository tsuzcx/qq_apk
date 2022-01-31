package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import aors;
import apty;
import apxx;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class QfileLocalFileDelMediaTabView$1
  implements Runnable
{
  QfileLocalFileDelMediaTabView$1(QfileLocalFileDelMediaTabView paramQfileLocalFileDelMediaTabView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    this.this$0.jdField_b_of_type_Boolean = true;
    this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    TreeMap localTreeMap = new TreeMap(new aors(this));
    Iterator localIterator = QfileLocalFileDelMediaTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      apxx localapxx = (apxx)localIterator.next();
      QfileLocalFileDelMediaTabView.a(this.this$0, localapxx.a(), localapxx, this.this$0.jdField_b_of_type_JavaUtilList, 2, localTreeMap, 1000, null);
    }
    apty.a(localTreeMap, 0, this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelMediaTabView.a(this.this$0, new QfileLocalFileDelMediaTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */