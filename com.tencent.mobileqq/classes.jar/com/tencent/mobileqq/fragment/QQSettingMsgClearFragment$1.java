package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qzone.QZoneHelper;

class QQSettingMsgClearFragment$1
  implements ActionSheet.OnButtonClickListener
{
  QQSettingMsgClearFragment$1(QQSettingMsgClearFragment paramQQSettingMsgClearFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment.getActivity().isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      QQSettingMsgClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment, true);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A0C5", "0X800A0C5", 0, 0, "", "", "", "");
    try
    {
      QZoneHelper.onQQClearLocalCache(QQSettingMsgClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment).getLongAccountUin());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actCleanCacheData", true, 0L, 0L, null, null);
      if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment.getActivity(), WebProcessReceiver.class);
        paramView.setAction("action_clear_cache");
        this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment.getActivity().sendBroadcast(paramView, "com.tencent.msg.permission.pushnotify");
        QRBridgeUtil.clearReaderBookCache();
        FileUtils.a(BaseApplication.getContext().getCacheDir() + "/mini", false);
        FileUtils.a(BaseApplication.getContext().getExternalCacheDir() + "/superplayer", false);
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).deleteApolloResource(false, QQSettingMsgClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingMsgClearFragment));
        FileUtils.a(AppConstants.PATH_CUSTOM_HEAD_ROOT, false);
        ThreadManagerV2.excute(new QQSettingMsgClearFragment.1.1(this), 64, null, true);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.w("QQSettingMsgClearFragment", 1, "onQQClearLocalCache error.", paramView);
        continue;
        paramView = WebAccelerateHelper.getSonicEngine();
        if (paramView != null) {
          paramView.cleanCache();
        }
        WebSoUtils.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1
 * JD-Core Version:    0.7.0.1
 */