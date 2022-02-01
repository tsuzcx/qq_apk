package com.tencent.mobileqq.troop.avatar;

import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TroopAvatarManger$1
  implements Runnable
{
  TroopAvatarManger$1(TroopAvatarManger paramTroopAvatarManger, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, UploadingTask paramUploadingTask, Class paramClass, ArrayList paramArrayList, HashMap paramHashMap) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "0", "0", this.jdField_a_of_type_JavaLangString, this.b, this.c);
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarUploadingTask.a(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarManger.1
 * JD-Core Version:    0.7.0.1
 */