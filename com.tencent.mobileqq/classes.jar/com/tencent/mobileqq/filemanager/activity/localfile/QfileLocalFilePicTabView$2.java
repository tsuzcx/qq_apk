package com.tencent.mobileqq.filemanager.activity.localfile;

import ajjy;
import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFilePicTabView$2
  implements Runnable
{
  QfileLocalFilePicTabView$2(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(ajjy.a(2131643890), new ArrayList());
    localLinkedHashMap.put(ajjy.a(2131643889), new ArrayList());
    try
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        FileInfo localFileInfo = (FileInfo)localIterator.next();
        Object localObject3 = localFileInfo.a();
        Object localObject1;
        if ((localObject3 != null) && (((String)localObject3).length() != 0))
        {
          localObject1 = localObject3;
          if (!((String)localObject3).equalsIgnoreCase("QQfile_recv")) {}
        }
        else
        {
          localObject1 = ajjy.a(2131643881);
        }
        localObject3 = localObject1;
        if (((String)localObject1).equalsIgnoreCase("camera") == true) {
          localObject3 = ajjy.a(2131643905);
        }
        if (!localLinkedHashMap.containsKey(localObject3)) {
          localLinkedHashMap.put(localObject3, new ArrayList());
        }
        ((List)localLinkedHashMap.get(localObject3)).add(localFileInfo);
        continue;
        localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      int i = ((SharedPreferences)localObject2).getInt("GROUP", -1);
      int j = ((SharedPreferences)localObject2).getInt("CHILD", -1);
      QfileLocalFilePicTabView.a(this.this$0, new QfileLocalFilePicTabView.2.1(this, localLinkedHashMap, i, j));
      return;
      Object localObject2 = localLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((List)localLinkedHashMap.get((String)((Iterator)localObject2).next())).size() == 0) {
          ((Iterator)localObject2).remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.2
 * JD-Core Version:    0.7.0.1
 */