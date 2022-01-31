package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import ayob;
import ayok;
import ayom;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import org.json.JSONObject;

public class TroopFeedsDataManager$3$1
  implements Runnable
{
  public TroopFeedsDataManager$3$1(ayom paramayom, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = ayob.a(this.jdField_a_of_type_OrgJsonJSONObject, "" + this.jdField_a_of_type_Ayom.a.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Ayom.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    List localList = (List)localObject[0];
    localObject = (List)localObject[1];
    ((List)localObject).addAll(this.jdField_a_of_type_Ayom.a.jdField_a_of_type_JavaUtilList);
    Message localMessage = this.jdField_a_of_type_Ayom.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = this.jdField_a_of_type_Ayom.a.a(localList, (List)localObject);
    this.jdField_a_of_type_Ayom.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */