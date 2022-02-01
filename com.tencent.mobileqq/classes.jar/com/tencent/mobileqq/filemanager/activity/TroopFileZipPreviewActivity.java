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
  ForwardFileInfo a;
  int b;
  long c;
  int d;
  String e;
  String f;
  String g;
  String h;
  String i;
  XListView j;
  ZipFilesListAdapter k;
  Context l;
  List<ZipFilePresenter.FileData> m = new ArrayList();
  long n = 0L;
  boolean o = false;
  String p;
  short q = 0;
  private FMObserver r = new TroopFileZipPreviewActivity.4(this);
  
  private TroopFileProtocol.OnGetZipFileList a(FileManagerEntity paramFileManagerEntity)
  {
    return new TroopFileZipPreviewActivity.2(this, paramFileManagerEntity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    if (paramBoolean) {
      str = "https://";
    } else {
      str = "http://";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("/ftn_compress_list/rkey=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("&filetype=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("&path=");
    ((StringBuilder)localObject).append(URLUtil.c(paramString4));
    ((StringBuilder)localObject).append("&");
    String str = ((StringBuilder)localObject).toString();
    localObject = new ArrayList();
    boolean bool;
    if (paramFileManagerEntity.getCloudType() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FTN5K=");
      localStringBuilder.append(paramString5);
      paramString5 = localStringBuilder.toString();
    }
    paramString1 = new HttpWebCgiAsyncTask2(str, "GET", new TroopFileZipPreviewActivity.3(this, (List)localObject, paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramOnGetZipFileList), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", DeviceInfoUtil.e());
    paramString2.putString("Cookie", paramString5);
    if (paramBoolean)
    {
      paramString3 = new StringBuilder();
      paramString3.append("https://");
      paramString3.append(paramString6);
      paramString2.putString("Referer", paramString3.toString());
    }
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", this.app.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    this.l = this;
    this.a = ((ForwardFileInfo)getIntent().getParcelableExtra("fileinfo"));
    this.b = getIntent().getIntExtra("busId", 0);
    this.c = getIntent().getLongExtra("troop_uin", 0L);
    this.e = getIntent().getStringExtra("str_download_dns");
    this.f = getIntent().getStringExtra("int32_server_port");
    this.g = getIntent().getStringExtra("string_download_url");
    this.h = getIntent().getStringExtra("str_cookie_val");
    this.i = getIntent().getStringExtra("filepath");
    paramBundle = getIntent().getStringExtra("filename");
    this.n = getIntent().getLongExtra("nSessionId", 0L);
    this.o = getIntent().getBooleanExtra("isHttps", false);
    this.p = getIntent().getStringExtra("httpsDomain");
    this.q = getIntent().getShortExtra("httpsPort", (short)0);
    this.j = new XListView(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.j.setLayoutParams(localLayoutParams);
    this.j.setBackgroundResource(2130838958);
    this.j.setDivider(null);
    setContentView(this.j);
    setTitle(paramBundle);
    paramBundle = this.app.getFileManagerProxy().a(this.n);
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.d = FileManagerUtil.o(paramBundle);
    if (this.c != 0L) {
      TroopFileProtocol.a(this.app, this.e, this.f, this.g, this.d, this.i, this.h, paramBundle, a(paramBundle));
    } else {
      a(this.e, this.f, this.g, this.d, this.i, this.h, paramBundle, this.o, this.p, this.q, a(paramBundle));
    }
    startTitleProgress();
    super.setRightButton(2131887812, new TroopFileZipPreviewActivity.1(this, paramBundle));
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.r != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.r);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.r);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity
 * JD-Core Version:    0.7.0.1
 */