package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQSettingAutoDownloadAndSaveFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  QQSettingAutoDownloadAndSaveFragment$2(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a.getActivity(), null, this.a.getString(2131694996), "qqsetting_auto_receive_magic_face_key", paramBoolean);
    QQAppInterface localQQAppInterface = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment.2
 * JD-Core Version:    0.7.0.1
 */