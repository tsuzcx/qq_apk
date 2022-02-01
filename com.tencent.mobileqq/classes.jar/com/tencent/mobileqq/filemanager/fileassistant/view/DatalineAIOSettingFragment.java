package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatSettingActivity.DeleteHistoryListener;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
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
    boolean bool = ((DataLineHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).k();
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131431583);
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
    ((DataLineHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).c(paramBoolean);
  }
  
  private void b()
  {
    Object localObject = (DataLineHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool1 = ((DataLineHandler)localObject).i();
    boolean bool2 = ((DataLineHandler)localObject).j();
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131431586);
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((FormSwitchItem)localObject).setChecked(bool1);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new DatalineAIOSettingFragment.2(this));
  }
  
  private void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getBaseActivity().app.getPreferences().edit();
    localEditor.putBoolean("dl_pc_online_notify", paramBoolean);
    localEditor.putBoolean("dl_ipad_online_notify", paramBoolean);
    localEditor.apply();
  }
  
  private void c()
  {
    String str3 = QFileAssistantUtils.b(getBaseActivity().app);
    String str2 = ContactUtils.a(getBaseActivity().app, str3);
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.equals(str2, str3)) {}
    }
    else
    {
      str1 = getBaseActivity().getString(2131896189);
    }
    ((TextView)this.mContentView.findViewById(2131435692)).setText(str1);
  }
  
  private void c(boolean paramBoolean)
  {
    ((FileAssistTopHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a(paramBoolean);
  }
  
  private void d()
  {
    Object localObject = QFileAssistantUtils.b(getBaseActivity().app);
    boolean bool = FriendsStatusUtil.a(getBaseActivity().app, (String)localObject, 0);
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131431588);
    ((FormSwitchItem)localObject).setChecked(bool);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new DatalineAIOSettingFragment.3(this));
  }
  
  private void e()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      FMToastUtil.a(2131917316);
      return;
    }
    try
    {
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByLiteAdvance(getActivity());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    String str = ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    ChatHistoryActivity.a(getBaseActivity(), str);
  }
  
  private void g()
  {
    getString(2131896174);
    if (FileManagerUtil.d(getBaseActivity(), getString(2131896189)))
    {
      getString(2131889065);
      return;
    }
    FileManagerUtil.a(getBaseActivity().app, getBaseActivity(), "jump_shortcut_dataline", getString(2131896189), 2130845599);
    DataLineReportUtil.q(getBaseActivity().app);
  }
  
  private void h()
  {
    String str = QFileAssistantUtils.b(getBaseActivity().app);
    a(getBaseActivity().app, getBaseActivity(), str, 0, new DatalineAIOSettingFragment.4(this), 2);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    this.mContentView.findViewById(2131431585).setOnClickListener(this);
    this.mContentView.findViewById(2131431587).setOnClickListener(this);
    this.mContentView.findViewById(2131431584).setOnClickListener(this);
    this.mContentView.findViewById(2131449841).setOnClickListener(this);
    d();
    b();
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627068;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131449841: 
      StatisticAssist.a(getBaseActivity().app.getApplication().getApplicationContext(), getBaseActivity().app.getCurrentAccountUin(), "dl_ckviewrecvfile");
      e();
      break;
    case 2131431587: 
      g();
      break;
    case 2131431585: 
      f();
      break;
    case 2131431584: 
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment
 * JD-Core Version:    0.7.0.1
 */