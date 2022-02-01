package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TroopFileSearchManager$CallableForSearchData
  implements Callable<List<IContactSearchable>>
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public TroopFileSearchManager$CallableForSearchData(TroopFileSearchManager paramTroopFileSearchManager, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public List<IContactSearchable> a()
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if (IContactSearchable.E == this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.a = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true);
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.a);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.b = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "CallableForSearchData time = " + (System.currentTimeMillis() - l));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager.CallableForSearchData
 * JD-Core Version:    0.7.0.1
 */