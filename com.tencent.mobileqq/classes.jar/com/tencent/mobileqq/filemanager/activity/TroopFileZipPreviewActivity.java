package com.tencent.mobileqq.filemanager.activity;

import acea;
import aceb;
import acec;
import aced;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
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
  public ZipFilesListAdapter a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new aced(this);
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  public XListView a;
  public String a;
  public List a;
  int b;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public TroopFileZipPreviewActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Long = 0L;
  }
  
  private TroopFileProtocol.OnGetZipFileList a(FileManagerEntity paramFileManagerEntity)
  {
    return new aceb(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + URLUtil.a(paramString4) + "&";
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if (paramFileManagerEntity.getCloudType() == 2)
    {
      bool = true;
      if (!bool) {
        break label226;
      }
      paramString5 = "FTN5K=" + paramString5;
    }
    label226:
    for (;;)
    {
      paramString1 = new HttpWebCgiAsyncTask2(str, "GET", new acec(this, localArrayList, paramString4, paramFileManagerEntity, bool, paramString5, paramString1, paramString2, paramString3, paramInt, paramOnGetZipFileList), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", DeviceInfoUtil.d());
      paramString2.putString("Cookie", paramString5);
      paramString3 = new HashMap();
      paramString3.put("BUNDLE", paramString2);
      paramString3.put("CONTEXT", this.app.getApp().getApplicationContext());
      paramString1.a(paramString3);
      return;
      bool = false;
      break;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838210);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(paramBundle);
    paramBundle = this.app.a().a(this.jdField_b_of_type_Long);
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
      super.setRightButton(2131434920, new acea(this, paramBundle));
      return true;
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.e, this.d, paramBundle, a(paramBundle));
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */