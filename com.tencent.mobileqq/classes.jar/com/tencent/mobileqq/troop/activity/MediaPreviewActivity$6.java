package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MediaPreviewActivity$6
  implements ActionSheet.OnButtonClickListener
{
  MediaPreviewActivity$6(MediaPreviewActivity paramMediaPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.jdField_a_of_type_Int);
    String str = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131693302).equals(str)) && (paramView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, paramView.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131693308).equals(str)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */