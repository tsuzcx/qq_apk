package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import aorr;
import apty;
import apxx;
import com.tencent.util.Pair;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class QfileLocalFileDelFileTabView$1
  implements Runnable
{
  QfileLocalFileDelFileTabView$1(QfileLocalFileDelFileTabView paramQfileLocalFileDelFileTabView) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    this.this$0.jdField_b_of_type_Boolean = true;
    this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.this$0.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    TreeMap localTreeMap = new TreeMap(new aorr(this));
    Iterator localIterator = QfileLocalFileDelFileTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      apxx localapxx = (apxx)localIterator.next();
      QfileLocalFileDelFileTabView.a(this.this$0, localapxx.a(), localapxx, this.this$0.jdField_b_of_type_JavaUtilList, ((Integer)this.this$0.jdField_a_of_type_ComTencentUtilPair.second).intValue(), localTreeMap, 1000, null);
    }
    apty.a(localTreeMap, ((Integer)this.this$0.jdField_a_of_type_ComTencentUtilPair.second).intValue(), this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap, this.this$0.jdField_b_of_type_JavaUtilLinkedHashMap, this.this$0.jdField_a_of_type_JavaUtilList);
    QfileLocalFileDelFileTabView.a(this.this$0, new QfileLocalFileDelFileTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.1
 * JD-Core Version:    0.7.0.1
 */