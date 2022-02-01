package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$1$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1$1(QfileLocalFileMediaTabView.1 param1, ArrayList paramArrayList, HashMap paramHashMap1, HashMap paramHashMap2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.f) && ((QfileLocalFileMediaTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0) & 0x2) > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.put("Camera", new ArrayList());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.containsKey(HardCodeUtil.a(2131698191))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.put(HardCodeUtil.a(2131698191), new ArrayList());
      }
      ((List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.get(HardCodeUtil.a(2131698191))).addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localObject = this.b.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.containsKey(HardCodeUtil.a(2131698188))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.put(HardCodeUtil.a(2131698188), new ArrayList());
      }
      ((List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.get(HardCodeUtil.a(2131698188))).addAll((Collection)this.b.get(str));
    }
    localObject = HardCodeUtil.a(2131698191);
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.containsKey(localObject))) {
      ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.get(localObject));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.c.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView$1.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1.1
 * JD-Core Version:    0.7.0.1
 */