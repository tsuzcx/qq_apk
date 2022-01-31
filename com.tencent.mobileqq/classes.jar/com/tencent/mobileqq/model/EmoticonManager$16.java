package com.tencent.mobileqq.model;

import askf;
import aukp;
import bbkb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonTab;

public class EmoticonManager$16
  implements Runnable
{
  public EmoticonManager$16(askf paramaskf, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.jdField_a_of_type_Aukp.a(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
    if (localEmoticonTab != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localEmoticonTab.aioHave = false;
      }
      if (this.b) {
        localEmoticonTab.kandianHave = false;
      }
      if ((localEmoticonTab.aioHave) || (localEmoticonTab.kandianHave)) {
        break label112;
      }
      this.this$0.jdField_a_of_type_Aukp.b(localEmoticonTab);
    }
    for (;;)
    {
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      bbkb.m(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis());
      return;
      label112:
      askf.a(this.this$0, localEmoticonTab);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.16
 * JD-Core Version:    0.7.0.1
 */