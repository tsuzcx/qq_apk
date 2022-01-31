package com.tencent.mobileqq.filemanager.activity.fileassistant;

import acgr;
import acgt;
import acgu;
import acgw;
import acgx;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunRemoteCommand;
import cooperation.weiyun.WeiyunRemoteCommand.OnStateChangeListener;
import cooperation.weiyun.sdk.api.WeiyunApi;
import cooperation.weiyun.utils.PreferenceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileFileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String e = "FileAssistantActivity<FileAssistant>";
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  QfileFileAssistantActivity.BroadcastMain jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain;
  public FileCategoryAdapter a;
  public XListView a;
  private WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = new acgx(this);
  private WeiyunRemoteCommand jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acgu(this);
  public boolean g = false;
  private volatile boolean h;
  
  public QfileFileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acgt(this);
  }
  
  private void l()
  {
    String str1 = getString(2131436135);
    String str2 = getString(2131436136);
    String str3 = getString(2131439301);
    String str4 = getString(2131428096);
    String str5 = getString(2131428094);
    String str6 = getString(2131428102);
    String str7 = getString(2131431780);
    String str8 = getString(2131428104);
    String str9 = getString(2131428093);
    getString(2131428090);
    a(2130970000, 2130842574, 2, "", 0, false, 0, "video", 1, false, false);
    a(2130969997, 2130841550, 0, str1, 0, false, 12, "offline", 2, true, false);
    a(2130969997, 2130842070, 0, str7, 0, false, 17, "other", 3, true, false);
    a(2130969997, 2130846265, 0, str3, 0, false, 16, "offline", 4, true, false);
    a(2130970016, 2130842574, 1, str9, 0, true, 0, "other", 1, false, false);
    a(2130969998, 2130841594, 0, str6, 0, false, 13, "picture", 2, false, false);
    a(2130969998, 2130841596, 0, str5, 0, false, 15, "other", 3, false, false);
    a(2130969998, 2130841551, 0, str2, 0, false, 19, "music", 3, false, false);
    if (getSharedPreferences("tim_convert_teamwork_pre_" + this.app.c(), 0).getBoolean("tim_myfile_teamwork_entry_list", false))
    {
      a(2130969998, 2130841591, 0, str4, 0, false, 14, "music", 3, false, false);
      a(2130969998, 2130841600, 0, str8, 0, false, 22, "document", 4, false, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      return;
      a(2130969998, 2130841591, 0, str4, 0, false, 14, "music", 4, false, false);
    }
  }
  
  private void m()
  {
    this.app.a().a("0X800474E", 1);
    QQProxyForQlink.a(this, 2, null);
  }
  
  private void n()
  {
    this.h = false;
    if (this.app.a().a() == true)
    {
      this.app.a().c();
      return;
    }
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131433196));
  }
  
  private void o()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void p()
  {
    try
    {
      startActivity(new Intent(getApplicationContext(), QQBrowserActivity.class).putExtra("url", getSharedPreferences("tim_convert_teamwork_pre_" + this.app.c(), 0).getString("tim_myfile_teamwork_list_url", "https://docs.qq.com/desktop/m/index.html?_from=1")));
      return;
    }
    catch (Exception localException)
    {
      QLog.i(e, 1, localException.toString());
    }
  }
  
  private void q()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = this.centerView;
    setTitle(2131428087);
    d();
  }
  
  private void s()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf("100160.100162"));
    JSONObject localJSONObject;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("service_type", 2);
      localJSONObject.put("act_id", 1001);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localRedTouchManager.b(localAppInfo, localJSONObject.toString());
      localRedTouchManager.a(localAppInfo);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand == null) {
      return;
    }
    try
    {
      i = Integer.valueOf(PreferenceUtils.a(this, getAppRuntime().getAccount(), "sp_un_backup_photo_num")).intValue();
      ThreadManager.executeOnSubThread(new acgw(this));
      int j = this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label202;
        }
        localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
        if (localFileCategoryEntity.e != 16) {
          break label174;
        }
        if (j != 4) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(e, 2, "AlbumBackup:updateBackupInfo, upload state");
        }
        localFileCategoryEntity.jdField_b_of_type_JavaLangString = getResources().getString(2131439303);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        FileCategoryEntity localFileCategoryEntity;
        int i = 0;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(e, 2, "AlbumBackup:updateBackupInfo, other state");
        }
        if (i > 0)
        {
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = Integer.toString(i);
        }
        else
        {
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = null;
          continue;
          label174:
          if (localFileCategoryEntity.e == 13) {
            localFileCategoryEntity.jdField_c_of_type_Boolean = this.app.a().b();
          }
        }
      }
      label202:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand);
    WeiyunHelper.a(this.app.getApplication());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.jdField_b_of_type_Int = paramInt1;
    localFileCategoryEntity.jdField_c_of_type_Int = paramInt2;
    localFileCategoryEntity.jdField_a_of_type_Int = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.d = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean1;
    localFileCategoryEntity.e = paramInt5;
    localFileCategoryEntity.jdField_c_of_type_JavaLangString = paramString2;
    localFileCategoryEntity.f = paramInt6;
    localFileCategoryEntity.jdField_b_of_type_Boolean = paramBoolean2;
    localFileCategoryEntity.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      WeiyunApi.a(this);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970002);
    if (FileManagerUtil.a(this.app, false))
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131368722));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      findViewById(2131368750).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.g = getIntent().getBooleanExtra("COMEFROMDESK", false);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131368723));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    r();
    l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain = new QfileFileAssistantActivity.BroadcastMain(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.process.stopping");
    paramBundle.addAction("com.tencent.fileassistant.createshrotcut");
    registerReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain, paramBundle);
    paramBundle = new FileManagerReporter.fileAssistantReportData();
    paramBundle.jdField_b_of_type_JavaLangString = "file_asst_in";
    paramBundle.jdField_a_of_type_Int = 11;
    FileManagerReporter.a(this.app.getCurrentAccountUin(), paramBundle);
    this.app.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    u();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    WeiyunHelper.b(this.app.getApplication());
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
    unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.h = true;
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    t();
    s();
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    String str = getString(2131428090);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (str.equalsIgnoreCase(((FileCategoryEntity)localIterator.next()).jdField_a_of_type_JavaLangString) == true) {
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      if (FileManagerUtil.a(this.app, false)) {
        break label130;
      }
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new acgr(this, str));
      return;
      label130:
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */