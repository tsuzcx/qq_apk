package com.tencent.mobileqq.filemanager.activity.cloudfile;

import apea;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$4
  implements Runnable
{
  QfileCloudFileTabView$4(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      String str = apea.a(localWeiYunFileInfo.b);
      if (!this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localWeiYunFileInfo);
    }
    this.this$0.i();
    this.this$0.setSelect(0);
    this.this$0.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.4
 * JD-Core Version:    0.7.0.1
 */