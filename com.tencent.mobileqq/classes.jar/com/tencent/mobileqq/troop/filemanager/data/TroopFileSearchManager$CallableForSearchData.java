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
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    long l2 = IContactSearchable.E;
    long l3 = this.jdField_a_of_type_Long;
    Object localObject;
    if (l2 == l3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager;
      ((TroopFileSearchManager)localObject).a = ((TroopFileSearchManager)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3, true);
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager.a);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileSearchManager;
      ((TroopFileSearchManager)localObject).b = ((TroopFileSearchManager)localObject).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CallableForSearchData time = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager.CallableForSearchData
 * JD-Core Version:    0.7.0.1
 */