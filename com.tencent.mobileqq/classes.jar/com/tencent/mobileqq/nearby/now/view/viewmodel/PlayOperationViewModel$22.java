package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil.ReportBundleBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class PlayOperationViewModel$22
  implements ActionSheet.OnButtonClickListener
{
  PlayOperationViewModel$22(PlayOperationViewModel paramPlayOperationViewModel, BaseActivity paramBaseActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        return;
        if (!PlayOperationViewModel.e(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel)) {
          break;
        }
        PlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel, DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_AndroidViewView.getContext(), 230, HardCodeUtil.a(2131708222), null, HardCodeUtil.a(2131708230), HardCodeUtil.a(2131708225), new PlayOperationViewModel.22.1(this), new PlayOperationViewModel.22.2(this)));
        PlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel).show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131708221), 0).a();
      return;
    }
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((ImageData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;; paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c)
    {
      paramView = new ProfileCardUtil.ReportBundleBuilder().b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c).d(paramView).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString).a();
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.22
 * JD-Core Version:    0.7.0.1
 */