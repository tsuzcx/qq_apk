package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$9
  implements ActionSheet.OnButtonClickListener
{
  TroopAvatarWallPreviewActivity$9(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable, String paramString1, String paramString2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693308).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, Long.parseLong(this.jdField_a_of_type_JavaLangString), "0", null, 20006);
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", this.jdField_a_of_type_JavaLangString, "video", "clk_rep", 0, 0, "", "", "", "");
      break;
      if ((TextUtils.isEmpty(this.b)) || ("0".equals(this.b))) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, 2, HardCodeUtil.a(2131715069), 0).a();
      } else {
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, 0L, this.b, null, 20006);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */