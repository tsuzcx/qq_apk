package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import java.util.Map;

class QQGameTroopManager$1
  implements Runnable
{
  QQGameTroopManager$1(QQGameTroopManager paramQQGameTroopManager, Activity paramActivity, Map paramMap, int[] paramArrayOfInt, String[] paramArrayOfString) {}
  
  public void run()
  {
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).updateGameData(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfJavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.1
 * JD-Core Version:    0.7.0.1
 */