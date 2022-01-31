package com.tencent.mobileqq.emosm.favroaming;

import apjs;
import awbw;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;

public class EmoticonFromGroupDBManager$2
  implements Runnable
{
  public EmoticonFromGroupDBManager$2(apjs paramapjs, int paramInt, EmoticonFromGroupEntity paramEmoticonFromGroupEntity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_DBManager", 2, "db operation start single. opType: " + this.jdField_a_of_type_Int);
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_DBManager", 2, "db operation end single.");
      }
      return;
      if ((!this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()))
      {
        QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "updateEntity error, e.md5=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
        continue;
        if ((!this.this$0.a.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity)) && (QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.getStatus() != 1000)) {
          QLog.e("EmoticonFromGroup_DBManager.dberror", 2, "remove error, e.md5=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonFromGroupEntity.md5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager.2
 * JD-Core Version:    0.7.0.1
 */