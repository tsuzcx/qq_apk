package com.tencent.mobileqq.model;

import awyr;
import bhhr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

public class EmoticonManager$16
  implements Runnable
{
  public EmoticonManager$16(awyr paramawyr, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localEmoticonTab);
    }
    for (;;)
    {
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      bhhr.m(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), System.currentTimeMillis());
      return;
      label112:
      awyr.a(this.this$0, localEmoticonTab);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.16
 * JD-Core Version:    0.7.0.1
 */