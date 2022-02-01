package com.tencent.mobileqq.emosm;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FavEmosmViewPage$2
  implements ActionSheet.OnButtonClickListener
{
  FavEmosmViewPage$2(FavEmosmViewPage paramFavEmosmViewPage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.f();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    ReportController.b(FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage), "CliOper", "", "", "ep_mall", "0X80057D7", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.2
 * JD-Core Version:    0.7.0.1
 */