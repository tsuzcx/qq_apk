package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (PlayOperationViewModelImpl.access$1100(this.c))
      {
        paramView = this.c;
        PlayOperationViewModelImpl.access$1202(paramView, DialogUtil.a(paramView.mBinding.getContext(), 230, HardCodeUtil.a(2131906026), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131906029), new PlayOperationViewModelImpl.20.1(this), new PlayOperationViewModelImpl.20.2(this)));
        PlayOperationViewModelImpl.access$1200(this.c).show();
        ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
      else if ((this.c.mVideoData != null) && (this.c.mHeadBinding != null) && (this.c.app != null))
      {
        String str = String.valueOf(this.c.mVideoData.i);
        if ((!TextUtils.isEmpty(str)) && (!"0".equals(str)))
        {
          if (this.c.mVideoData.G == 4)
          {
            if (this.c.mVideoData.M.get(0) != null) {
              paramView = ((ImageData)this.c.mVideoData.M.get(0)).a;
            } else {
              paramView = "";
            }
          }
          else {
            paramView = this.c.mVideoData.e;
          }
          paramView = new ProfileCardUtil.ReportBundleBuilder().b(this.c.mVideoData.e).d(paramView).a(this.c.mVideoData.A).a();
          ProfileCardUtil.a(this.a, 0L, str, null, 20006, "", paramView);
          ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
          ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportTrendDetailSafeReportClick(this.c.app, String.valueOf(this.c.mVideoData.i));
        }
        else
        {
          QQToast.makeText(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131906025), 0).show();
          return;
        }
      }
    }
    paramView = this.b;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.20
 * JD-Core Version:    0.7.0.1
 */