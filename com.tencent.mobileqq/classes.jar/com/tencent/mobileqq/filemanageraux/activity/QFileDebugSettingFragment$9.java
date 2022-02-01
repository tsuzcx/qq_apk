package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$9
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$9(QFileDebugSettingFragment paramQFileDebugSettingFragment, IQFileDatalineConfigBean paramIQFileDatalineConfigBean) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    QFileDebugSettingFragment.a(this.b).setDatalineConfig();
    QQAppInterface localQQAppInterface = this.b.getBaseActivity().app;
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(localQQAppInterface.getAccount());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("file_dataline_key", "{}");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDatalineConfig: load dataline config. ");
      localStringBuilder.append((String)localObject);
      QLog.i("IphoneTitleBarFragment", 1, localStringBuilder.toString());
    }
    this.a.a(localQQAppInterface, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */