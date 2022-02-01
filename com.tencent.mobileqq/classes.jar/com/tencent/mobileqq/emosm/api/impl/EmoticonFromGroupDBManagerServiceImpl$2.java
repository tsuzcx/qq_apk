package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class EmoticonFromGroupDBManagerServiceImpl$2
  implements Runnable
{
  EmoticonFromGroupDBManagerServiceImpl$2(EmoticonFromGroupDBManagerServiceImpl paramEmoticonFromGroupDBManagerServiceImpl, int paramInt, EmoticonFromGroupEntity paramEmoticonFromGroupEntity) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("db operation start single. opType: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("EmoticonFromGroup_DBManager", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if ((i == 2) && (!this.this$0.mEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.getStatus() != 1000))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove error, e.md5=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, localStringBuilder.toString());
      }
    }
    else if ((!this.this$0.updateEntity(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity error, e.md5=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
      QLog.e("EmoticonFromGroup_DBManager.dberror", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end single.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonFromGroupDBManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */