package com.tencent.mobileqq.filemanager.activity.localfile;

import aptw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileMediaTabView$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap;
    Iterator localIterator;
    String str;
    if ((this.this$0.f) && ((QfileLocalFileMediaTabView.a(this.this$0) & 0x1) > 0))
    {
      localMap = aptw.c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if ("QQfile_recv".equalsIgnoreCase(str) != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    if ((this.this$0.f) && ((QfileLocalFileMediaTabView.a(this.this$0) & 0x2) > 0))
    {
      localMap = aptw.b(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if ("QQfile_recv".equalsIgnoreCase(str) != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    QfileLocalFileMediaTabView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */