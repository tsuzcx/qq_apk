package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
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
import cooperation.qzone.QZoneHelper;

class QQSettingMsgClearFragment$1
  implements ActionSheet.OnButtonClickListener
{
  QQSettingMsgClearFragment$1(QQSettingMsgClearFragment paramQQSettingMsgClearFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!this.b.getBaseActivity().isFinishing())
    {
      this.a.cancel();
      QQSettingMsgClearFragment.a(this.b, true);
    }
    ReportController.b(null, "dc00898", "", "", "0X800A0C5", "0X800A0C5", 0, 0, "", "", "", "");
    try
    {
      QZoneHelper.onQQClearLocalCache(QQSettingMsgClearFragment.a(this.b).getLongAccountUin());
    }
    catch (Exception paramView)
    {
      QLog.w("QQSettingMsgClearFragment", 1, "onQQClearLocalCache error.", paramView);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actCleanCacheData", true, 0L, 0L, null, null);
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      paramView = new Intent(this.b.getBaseActivity(), WebProcessReceiver.class);
      paramView.setAction("action_clear_cache");
      this.b.getBaseActivity().sendBroadcast(paramView, "com.tencent.msg.permission.pushnotify");
    }
    else
    {
      paramView = WebAccelerateHelper.getSonicEngine();
      if (paramView != null) {
        paramView.cleanCache();
      }
      WebSoUtils.a();
    }
    paramView = new StringBuilder();
    paramView.append(BaseApplication.getContext().getCacheDir());
    paramView.append("/mini");
    FileUtils.delete(paramView.toString(), false);
    paramView = new StringBuilder();
    paramView.append(BaseApplication.getContext().getExternalCacheDir());
    paramView.append("/superplayer");
    FileUtils.delete(paramView.toString(), false);
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).deleteApolloResource(false, QQSettingMsgClearFragment.a(this.b));
    FileUtils.delete(AppConstants.PATH_CUSTOM_HEAD_ROOT, false);
    ThreadManagerV2.excute(new QQSettingMsgClearFragment.1.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1
 * JD-Core Version:    0.7.0.1
 */