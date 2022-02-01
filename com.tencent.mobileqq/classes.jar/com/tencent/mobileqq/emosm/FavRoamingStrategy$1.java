package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FavRoamingStrategy$1
  implements CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback
{
  FavRoamingStrategy$1(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void a(List<EmoticonInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= FavEmoConstant.a) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= FavEmoConstant.b) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.b((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.1
 * JD-Core Version:    0.7.0.1
 */