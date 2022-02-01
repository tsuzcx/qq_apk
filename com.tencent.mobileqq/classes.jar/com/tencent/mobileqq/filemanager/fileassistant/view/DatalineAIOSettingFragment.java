package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatSettingActivity.DeleteHistoryListener;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class DatalineAIOSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private void a()
  {
    boolean bool = ((DataLineHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).c();
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131365540);
    localFormSwitchItem.setChecked(bool);
    localFormSwitchItem.setOnCheckedChangeListener(new DatalineAIOSettingFragment.1(this));
  }
  
  private void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, ChatSettingActivity.DeleteHistoryListener paramDeleteHistoryListener, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    DeleteRecordDialog localDeleteRecordDialog = new DeleteRecordDialog(paramActivity, paramQQAppInterface, true);
    localDeleteRecordDialog.a(new DatalineAIOSettingFragment.5(this, paramDeleteHistoryListener, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localDeleteRecordDialog.a(paramInt2);
  }
  
  private void a(boolean paramBoolean)
  {
    ((DataLineHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).c(paramBoolean);
  }
  
  private void b()
  {
    Object localObject = (DataLineHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool1 = ((DataLineHandler)localObject).a();
    boolean bool2 = ((DataLineHandler)localObject).b();
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131365543);
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool1);
      ((FormSwitchItem)localObject).setOnCheckedChangeListener(new DatalineAIOSettingFragment.2(this));
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getActivity().app.getPreferences().edit();
    localEditor.putBoolean("dl_pc_online_notify", paramBoolean);
    localEditor.putBoolean("dl_ipad_online_notify", paramBoolean);
    localEditor.apply();
  }
  
  private void c()
  {
    String str2 = QFileAssistantUtils.a(getActivity().app);
    String str1 = ContactUtils.a(getActivity().app, str2);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.equals(str1, str2))) {
      str1 = getActivity().getString(2131698224);
    }
    for (;;)
    {
      ((TextView)this.mContentView.findViewById(2131369051)).setText(str1);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ((FileAssistTopHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a(paramBoolean);
  }
  
  private void d()
  {
    Object localObject = QFileAssistantUtils.a(getActivity().app);
    boolean bool = FriendsStatusUtil.a(getActivity().app, (String)localObject, 0);
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131365545);
    ((FormSwitchItem)localObject).setChecked(bool);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new DatalineAIOSettingFragment.3(this));
  }
  
  private void e()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getActivity().app.getApplication().getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131719981);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      localIntent.putExtra("open_with_qq_images", true);
      startActivityForResult(localIntent, 103);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    String str = ((IQFileConfigManager)getActivity().app.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    ChatHistoryActivity.a(getActivity(), str);
  }
  
  private void g()
  {
    getString(2131698209);
    if (FileManagerUtil.a(getActivity(), getString(2131698224)))
    {
      getString(2131692167);
      return;
    }
    FileManagerUtil.a(getActivity().app, getActivity(), "jump_shortcut_dataline", getString(2131698224), 2130844376);
    DataLineReportUtil.q(getActivity().app);
  }
  
  private void h()
  {
    String str = QFileAssistantUtils.a(getActivity().app);
    a(getActivity().app, getActivity(), str, 0, new DatalineAIOSettingFragment.4(this), 2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    this.mContentView.findViewById(2131365542).setOnClickListener(this);
    this.mContentView.findViewById(2131365544).setOnClickListener(this);
    this.mContentView.findViewById(2131365541).setOnClickListener(this);
    this.mContentView.findViewById(2131381629).setOnClickListener(this);
    d();
    b();
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560935;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      h();
      continue;
      f();
      continue;
      g();
      continue;
      StatisticAssist.a(getActivity().app.getApplication().getApplicationContext(), getActivity().app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment
 * JD-Core Version:    0.7.0.1
 */