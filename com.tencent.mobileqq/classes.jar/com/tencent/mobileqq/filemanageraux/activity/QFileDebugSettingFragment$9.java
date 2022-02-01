package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$9
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$9(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).setFileAssistantSwitch(paramBoolean);
    QFileDebugSettingFragment.a(this.a).setDatalineConfig();
    QQAppInterface localQQAppInterface = this.a.getActivity().app;
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("file_config_" + localQQAppInterface.getAccount(), 0).getString("file_dataline_key", "{}");
    if (TextUtils.isEmpty(str)) {
      QLog.i("IphoneTitleBarFragment", 1, "loadDatalineConfig: load dataline config. " + str);
    }
    ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).setNewFileAssistantSwitch(localQQAppInterface, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */