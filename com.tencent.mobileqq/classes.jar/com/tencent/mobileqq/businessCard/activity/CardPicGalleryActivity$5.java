package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class CardPicGalleryActivity$5
  implements View.OnClickListener
{
  CardPicGalleryActivity$5(CardPicGalleryActivity paramCardPicGalleryActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    if (2 == this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.d)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.b) {
        break label70;
      }
    }
    label70:
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", 4, 0, str, "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.5
 * JD-Core Version:    0.7.0.1
 */