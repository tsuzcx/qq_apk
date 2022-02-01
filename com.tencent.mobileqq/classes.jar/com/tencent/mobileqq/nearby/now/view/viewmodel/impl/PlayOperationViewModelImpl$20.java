package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

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

class PlayOperationViewModelImpl$20
  implements ActionSheet.OnButtonClickListener
{
  PlayOperationViewModelImpl$20(PlayOperationViewModelImpl paramPlayOperationViewModelImpl, BaseActivity paramBaseActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (PlayOperationViewModelImpl.access$1100(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl;
        PlayOperationViewModelImpl.access$1202(paramView, DialogUtil.a(paramView.mBinding.getContext(), 230, HardCodeUtil.a(2131708231), null, HardCodeUtil.a(2131708239), HardCodeUtil.a(2131708234), new PlayOperationViewModelImpl.20.1(this), new PlayOperationViewModelImpl.20.2(this)));
        PlayOperationViewModelImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl).show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.app, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mHeadBinding != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.app != null))
      {
        String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.jdField_a_of_type_Long);
        if ((!TextUtils.isEmpty(str)) && (!"0".equals(str)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.k == 4)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
              paramView = ((ImageData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
            } else {
              paramView = "";
            }
          }
          else {
            paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.c;
          }
          paramView = new ProfileCardUtil.ReportBundleBuilder().b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.c).d(paramView).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.mVideoData.j).a();
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelImplPlayOperationViewModelImpl.app, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.a(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131708230), 0).a();
          return;
        }
      }
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.20
 * JD-Core Version:    0.7.0.1
 */