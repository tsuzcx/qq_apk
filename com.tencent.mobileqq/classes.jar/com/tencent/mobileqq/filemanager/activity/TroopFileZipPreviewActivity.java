package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TroopFileZipPreviewActivity
  extends IphoneTitleBarActivity
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  ZipFilesListAdapter jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new TroopFileZipPreviewActivity.4(this);
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<ZipFilePresenter.FileData> jdField_a_of_type_JavaUtilList = new ArrayList();
  short jdField_a_of_type_Short = 0;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  String f;
  
  private TroopFileProtocol.OnGetZipFileList a(FileManagerEntity paramFileManagerEntity)
  {
    return new TroopFileZipPreviewActivity.2(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    String str;
    ArrayList localArrayList;
    boolean bool;
    if (paramBoolean)
    {
      str = "https://";
      str = str + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + URLUtil.a(paramString4) + "&";
      localArrayList = new ArrayList();
      if (paramFileManagerEntity.getCloudType() != 2) {
        break label273;
      }
      bool = true;
      label97:
      if (!bool) {
        break label279;
      }
      paramString5 = "FTN5K=" + paramString5;
    }
    label273:
    label279:
    for (;;)
    {
      paramString1 = new HttpWebCgiAsyncTask2(str, "GET", new TroopFileZipPreviewActivity.3(this, localArrayList, paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramOnGetZipFileList), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", DeviceInfoUtil.c());
      paramString2.putString("Cookie", paramString5);
      if (paramBoolean) {
        paramString2.putString("Referer", "https://" + paramString6);
      }
      paramString3 = new HashMap();
      paramString3.put("BUNDLE", paramString2);
      paramString3.put("CONTEXT", this.app.getApp().getApplicationContext());
      paramString1.a(paramString3);
      return;
      str = "http://";
      break;
      bool = false;
      break label97;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("isNeedFinish", true);
      setResult(-1, paramIntent);
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)getIntent().getParcelableExtra("fileinfo"));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("busId", 0);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("troop_uin", 0L);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("str_download_dns");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("int32_server_port");
    this.c = getIntent().getStringExtra("string_download_url");
    this.d = getIntent().getStringExtra("str_cookie_val");
    this.e = getIntent().getStringExtra("filepath");
    paramBundle = getIntent().getStringExtra("filename");
    this.jdField_b_of_type_Long = getIntent().getLongExtra("nSessionId", 0L);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("isHttps", false);
    this.f = getIntent().getStringExtra("httpsDomain");
    this.jdField_a_of_type_Short = getIntent().getShortExtra("httpsPort", (short)0);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(paramBundle);
    paramBundle = this.app.getFileManagerProxy().a(this.jdField_b_of_type_Long);
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.jdField_b_of_type_Int = FileManagerUtil.b(paramBundle);
    if (this.jdField_a_of_type_Long != 0L) {
      TroopFileProtocol.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.e, this.d, paramBundle, a(paramBundle));
    }
    for (;;)
    {
      startTitleProgress();
      super.setRightButton(2131690946, new TroopFileZipPreviewActivity.1(this, paramBundle));
      return true;
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.e, this.d, paramBundle, this.jdField_a_of_type_Boolean, this.f, this.jdField_a_of_type_Short, a(paramBundle));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */