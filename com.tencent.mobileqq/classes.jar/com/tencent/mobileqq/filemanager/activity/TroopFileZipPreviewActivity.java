package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import aqih;
import aqii;
import aqij;
import aqik;
import aqnl;
import aqse;
import aqxp;
import arjn;
import arni;
import bcgp;
import bdcb;
import bhos;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ypf;
import ypq;
import ypy;

public class TroopFileZipPreviewActivity
  extends IphoneTitleBarActivity
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private aqnl jdField_a_of_type_Aqnl = new aqik(this);
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  public XListView a;
  public String a;
  public List<arjn> a;
  public ypy a;
  public short a;
  public boolean a;
  int b;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public TroopFileZipPreviewActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Short = 0;
  }
  
  private ypq a(FileManagerEntity paramFileManagerEntity)
  {
    return new aqii(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, ypq paramypq)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + bhos.a(paramString4) + "&";
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if (paramFileManagerEntity.getCloudType() == 2)
    {
      bool = true;
      if (!bool) {
        break label232;
      }
      paramString5 = "FTN5K=" + paramString5;
    }
    label232:
    for (;;)
    {
      paramString1 = new bcgp(str, "GET", new aqij(this, localArrayList, paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramypq), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", bdcb.c());
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
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838591);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(paramBundle);
    paramBundle = this.app.a().a(this.jdField_b_of_type_Long);
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.jdField_b_of_type_Int = arni.b(paramBundle);
    if (this.jdField_a_of_type_Long != 0L) {
      ypf.a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.e, this.d, paramBundle, a(paramBundle));
    }
    for (;;)
    {
      startTitleProgress();
      super.setRightButton(2131690884, new aqih(this, paramBundle));
      return true;
      a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.e, this.d, paramBundle, this.jdField_a_of_type_Boolean, this.f, this.jdField_a_of_type_Short, a(paramBundle));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aqnl != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_Aqnl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */