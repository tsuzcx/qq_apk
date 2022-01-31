package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import aqkq;
import arna;
import arqz;
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
    TreeMap localTreeMap = new TreeMap(new aqkq(this));
    Iterator localIterator = QfileLocalFileDelMediaTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      arqz localarqz = (arqz)localIterator.next();
      QfileLocalFileDelMediaTabView.a(this.this$0, localarqz.a(), localarqz, this.this$0.jdField_b_of_type_JavaUtilList, 2, localTreeMap, 1000, null);
    }
    arna.a(localTreeMap, 0, this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelMediaTabView.a(this.this$0, new QfileLocalFileDelMediaTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */