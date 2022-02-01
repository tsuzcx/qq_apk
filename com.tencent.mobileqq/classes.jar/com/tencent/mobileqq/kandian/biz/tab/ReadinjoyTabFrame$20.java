package com.tencent.mobileqq.kandian.biz.tab;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$20
  implements DialogInterface.OnClickListener
{
  ReadinjoyTabFrame$20(ReadinjoyTabFrame paramReadinjoyTabFrame, PositionData paramPositionData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog change confirm");
    }
    paramDialogInterface = ReadInJoyLogicEngine.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData);
    }
    paramDialogInterface = ReadInJoyLogicEngine.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a().b(41695);
    }
    ReadInJoyLogicEngine.a().a(41695, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPositionData.city);
    ReadInJoyLogicEngineEventDispatcher.a().g(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.20
 * JD-Core Version:    0.7.0.1
 */