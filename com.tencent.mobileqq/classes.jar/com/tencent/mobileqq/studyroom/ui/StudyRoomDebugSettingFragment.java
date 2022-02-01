package com.tencent.mobileqq.studyroom.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.studyroom.utils.StudyRoomUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater;
import java.util.Iterator;
import java.util.List;

public class StudyRoomDebugSettingFragment
  extends QIphoneTitleBarFragment
{
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getQBaseActivity().getApplication().getSharedPreferences("studyroom_config_", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  private String b(String paramString1, String paramString2)
  {
    return getQBaseActivity().getApplication().getSharedPreferences("studyroom_config_", 0).getString(paramString1, paramString2);
  }
  
  private void b()
  {
    Iterator localIterator = ((ActivityManager)getQBaseActivity().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equals("com.tencent.mobileqq:live")) {
        Process.killProcess(localRunningAppProcessInfo.pid);
      }
    }
  }
  
  private void c()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.t.findViewById(2131446498);
    localFormSwitchItem.setChecked(StudyRoomUtils.a());
    localFormSwitchItem.setOnCheckedChangeListener(new StudyRoomDebugSettingFragment.1(this));
  }
  
  private void d()
  {
    boolean bool = PluginUpdater.b(getQBaseActivity());
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.t.findViewById(2131446502);
    EditText localEditText = (EditText)this.t.findViewById(2131446500);
    Button localButton = (Button)this.t.findViewById(2131446501);
    localFormSwitchItem.setChecked(bool);
    localEditText.setEnabled(bool);
    localButton.setEnabled(bool);
    localFormSwitchItem.setOnCheckedChangeListener(new StudyRoomDebugSettingFragment.2(this, localEditText, localButton));
  }
  
  private void e()
  {
    EditText localEditText = (EditText)this.t.findViewById(2131446500);
    Button localButton1 = (Button)this.t.findViewById(2131446501);
    Button localButton2 = (Button)this.t.findViewById(2131446499);
    localEditText.setText(b("studyroom_plugin_name", ""));
    localButton1.setOnClickListener(new StudyRoomDebugSettingFragment.3(this));
    localButton2.setOnClickListener(new StudyRoomDebugSettingFragment.4(this));
  }
  
  private void f()
  {
    String str = ((EditText)this.t.findViewById(2131446500)).getText().toString();
    PluginInfo localPluginInfo = new PluginInfo();
    localPluginInfo.mID = "StudyRoom";
    localPluginInfo.mURL = StudyRoomUtils.a(str);
    localPluginInfo.mMD5 = "";
    localPluginInfo.mSubType = 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("installDebugPlugin: branch=");
    ((StringBuilder)localObject).append(str);
    QLog.d("StudyRoomDebugSettingFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new QQProgressDialog(getActivity());
    ((QQProgressDialog)localObject).show();
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getQBaseActivity().getAppRuntime();
      if (localQQAppInterface == null) {
        return;
      }
      b();
      ((IPluginManager)localQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).a(localPluginInfo, new StudyRoomDebugSettingFragment.5(this, (QQProgressDialog)localObject, str));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void g()
  {
    ((EditText)this.t.findViewById(2131446500)).setText("");
    a("studyroom_plugin_name", "");
    QQAppInterface localQQAppInterface = (QQAppInterface)getQBaseActivity().getAppRuntime();
    if (localQQAppInterface != null)
    {
      b();
      ((IPluginManager)localQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).b();
    }
  }
  
  protected int a()
  {
    return 2131629324;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a("自习室测试配置");
    c();
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */