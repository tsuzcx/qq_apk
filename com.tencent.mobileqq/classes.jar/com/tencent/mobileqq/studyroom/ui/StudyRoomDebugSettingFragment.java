package com.tencent.mobileqq.studyroom.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.studyroom.utils.StudyRoomUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class StudyRoomDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private String a(String paramString1, String paramString2)
  {
    return getActivity().app.getApp().getSharedPreferences("studyroom_config_", 0).getString(paramString1, paramString2);
  }
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131378619);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(StudyRoomUtils.a());
    localFormSwitchItem.setOnCheckedChangeListener(new StudyRoomDebugSettingFragment.1(this));
  }
  
  private void a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      boolean bool = localFile.delete();
      QLog.i("StudyRoomDebugSettingFragment", 1, "removePlugin: remove result[" + bool + "].");
      return;
    }
    QLog.i("StudyRoomDebugSettingFragment", 1, "removePlugin: path[" + paramString + "] is not exist.");
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getActivity().app.getApp().getSharedPreferences("studyroom_config_", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  private void b()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131378621);
    Button localButton1 = (Button)this.mContentView.findViewById(2131378622);
    Button localButton2 = (Button)this.mContentView.findViewById(2131378620);
    localEditText.setText(a("studyroom_plugin_name", ""));
    localButton1.setOnClickListener(new StudyRoomDebugSettingFragment.2(this));
    localButton2.setOnClickListener(new StudyRoomDebugSettingFragment.3(this));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int getContentLayoutId()
  {
    return 2131563049;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setTitle("自习室测试配置");
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */