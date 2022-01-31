package com.tencent.mobileqq.filemanager.activity.localfile;

import ajya;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$2$1
  implements Runnable
{
  QfileLocalFileMediaTabView$2$1(QfileLocalFileMediaTabView.2 param2, ArrayList paramArrayList, HashMap paramHashMap1, HashMap paramHashMap2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.f) && ((QfileLocalFileMediaTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0) & 0x2) > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.put("Camera", new ArrayList());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.containsKey(ajya.a(2131709694))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.put(ajya.a(2131709680), new ArrayList());
      }
      ((List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.get(ajya.a(2131709690))).addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.containsKey(ajya.a(2131709682))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.put(ajya.a(2131709678), new ArrayList());
      }
      ((List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.get(ajya.a(2131709700))).addAll((Collection)this.b.get(str));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.c.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$2.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.2.1
 * JD-Core Version:    0.7.0.1
 */