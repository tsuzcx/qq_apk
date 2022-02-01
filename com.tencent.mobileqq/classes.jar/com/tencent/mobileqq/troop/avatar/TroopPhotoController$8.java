package com.tencent.mobileqq.troop.avatar;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.AccountObserver;

class TroopPhotoController$8
  extends AccountObserver
{
  TroopPhotoController$8(TroopPhotoController paramTroopPhotoController) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null)
    {
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        paramString1 = this.a;
        paramString1 = TroopPhotoController.a(paramString1, ((TroopClipPic)paramString1.jdField_a_of_type_JavaUtilArrayList.get(j)).ts);
        if (paramString1 != null)
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(paramString1);
          this.a.b(paramString1);
        }
        i = j;
      }
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    paramString2 = this.a;
    paramString2.a(paramString2.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.8
 * JD-Core Version:    0.7.0.1
 */