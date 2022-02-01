package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$8
  implements ActionSheet.OnButtonClickListener
{
  String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
  
  TroopAvatarWallPreviewActivity$8(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    int i;
    if (!localITroopAvatarUtilApi.isNumeric(this.jdField_a_of_type_JavaLangString))
    {
      i = 1;
      if (i == 0) {
        break label88;
      }
      paramView = this.jdField_a_of_type_JavaLangString;
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693302).equals(paramView)) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      i = 0;
      break;
      label88:
      if (this.jdField_a_of_type_JavaLangString.equals(AvatarInfo.jdField_a_of_type_JavaLangString)) {}
      for (paramView = localITroopAvatarUtilApi.getAvatarAddress(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaLangString, 0);; paramView = localITroopAvatarUtilApi.getAvatarAddress(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaLangString, 1))
      {
        localITroopAvatarUtilApi.getThumbPhoto(paramView);
        break;
      }
      label156:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693308).equals(paramView)) {
        TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693306).equals(paramView)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.d, this.jdField_a_of_type_JavaLangString);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131697755).equals(paramView)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693299).equals(paramView)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Boolean) && (TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity) != null) && (TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity).getBoolean("from_personality_label", false))) {
          TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int, TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity));
        } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int))) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */