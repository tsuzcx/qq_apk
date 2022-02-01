package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$11
  implements ActionSheet.OnButtonClickListener
{
  String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mIndex);
  
  TroopAvatarWallPreviewActivity$11(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((localITroopAvatarUtilApi.isNumeric(this.jdField_a_of_type_JavaLangString) ^ true))
    {
      paramView = this.jdField_a_of_type_JavaLangString;
    }
    else
    {
      if (this.jdField_a_of_type_JavaLangString.equals(AvatarInfo.jdField_a_of_type_JavaLangString)) {
        paramView = localITroopAvatarUtilApi.getAvatarAddress(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mTroopUin, 0);
      } else {
        paramView = localITroopAvatarUtilApi.getAvatarAddress(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mTroopUin, 1);
      }
      localITroopAvatarUtilApi.getThumbPhoto(paramView);
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693256).equals(paramView))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.forward(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693262).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.access$1400(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693260).equals(paramView))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
      paramView.onQRDecodeSucceed(paramView.tempPath, this.jdField_a_of_type_JavaLangString);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131697761).equals(paramView))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
      paramView.setDefaultAvatar(paramView.mIndex);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693253).equals(paramView))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mDeleteAbility) && (TroopAvatarWallPreviewActivity.access$300(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity) != null) && (TroopAvatarWallPreviewActivity.access$300(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity).getBoolean("from_personality_label", false)))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
        TroopAvatarWallPreviewActivity.access$1500(paramView, paramView.mIndex, TroopAvatarWallPreviewActivity.access$300(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity));
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.mDeleteAbility)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
          if (paramView.canDelete(paramView.mIndex))
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
            paramView.deletePhotoWall(paramView.mIndex);
            break label365;
          }
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity;
        paramView.setDefaultAvatar(paramView.mIndex);
      }
    }
    label365:
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */