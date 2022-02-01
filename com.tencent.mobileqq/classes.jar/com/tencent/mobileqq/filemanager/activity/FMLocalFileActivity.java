package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String F = "FileAssistantActivity<FileAssistant>";
  List<FileCategoryEntity> G = new ArrayList();
  XListView H;
  FileCategoryAdapter I = null;
  boolean J;
  public View.OnClickListener K = new FMLocalFileActivity.2(this);
  private AsyncTask L = null;
  
  private void O()
  {
    this.g = getString(2131889353);
    setTitle(this.g);
  }
  
  private void P()
  {
    this.G.clear();
    getString(2131889610);
    getString(2131889607);
    getString(2131889612);
    getString(2131889601);
    getString(2131896116);
    Object localObject = getString(2131889605);
    String str1 = getString(2131889305);
    String str2 = getString(2131889304);
    String str3 = getString(2131889351);
    Intent localIntent = getIntent();
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if (localIntent != null)
    {
      bool3 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      bool2 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
    }
    else
    {
      bool1 = false;
      bool2 = true;
    }
    if (bool3) {
      a(2131627041, 2130846959, 2, null, 0, false, 0, 1);
    }
    if (bool1) {
      a(2131627039, 2130845668, 0, str3, 0, false, 20, 2);
    }
    if (bool2) {
      a(2131627032, 2130846959, 1, null, 0, false, 0, 1);
    }
    a(2131627039, 2130845669, 0, (String)localObject, 0, false, 7, 3);
    if (QQFileManagerUtil.b(this).containsKey("externalSdCard"))
    {
      a(2131627039, 2130845670, 0, str1, 0, false, 8, 3);
      a(2131627039, 2130845670, 0, str2, 0, false, 11, 4);
    }
    else
    {
      a(2131627039, 2130845670, 0, str1, 0, false, 8, 4);
    }
    localObject = this.I;
    if (localObject == null) {
      return;
    }
    ((FileCategoryAdapter)localObject).notifyDataSetChanged();
    N();
  }
  
  private void e(int paramInt)
  {
    if (paramInt != 11)
    {
      if (paramInt != 20) {}
      switch (paramInt)
      {
      default: 
        break;
        A().ae();
        finish();
        overridePendingTransition(2130772345, 2130772346);
        return;
      }
    }
    else
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        break label104;
      }
      FMToastUtil.a(2131917316);
    }
    Intent localIntent = null;
    label104:
    if (paramInt == 7)
    {
      if (q()) {
        A().ag();
      } else {
        A().ai();
      }
    }
    else if (paramInt == 8) {
      if (q()) {
        A().ah();
      } else {
        A().aj();
      }
    }
    if (localIntent == null) {
      return;
    }
    try
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("category", paramInt);
      localIntent.putExtra("bundle", (Bundle)localObject);
      localObject = getIntent();
      boolean bool = ((Intent)localObject).getBooleanExtra("STRING_SingleSelect", false);
      localIntent.putExtra("localSdCardfile", ((Intent)localObject).getIntExtra("localSdCardfile", -1));
      if (bool) {
        localIntent.putExtra("STRING_SingleSelect", bool);
      }
      localObject = ((Intent)localObject).getStringArrayExtra("STRING_Show_Within_Suffixs");
      if (localObject != null) {
        localIntent.putExtra("STRING_Show_Within_Suffixs", (String[])localObject);
      }
      localIntent.putExtra("select_file_only_docs_file", this.a.f());
      localIntent.putExtra("qrlogin_appid", this.C);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772345, 2130772346);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void N()
  {
    AsyncTask localAsyncTask = this.L;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.L = new FMLocalFileActivity.1(this).execute(new Void[0]);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.b = paramInt1;
    localFileCategoryEntity.c = paramInt2;
    localFileCategoryEntity.a = paramInt3;
    localFileCategoryEntity.d = paramString;
    localFileCategoryEntity.e = paramInt4;
    localFileCategoryEntity.f = paramBoolean;
    localFileCategoryEntity.g = paramInt5;
    localFileCategoryEntity.l = paramInt6;
    this.G.add(localFileCategoryEntity);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != 4) && (paramInt2 != 5))
    {
      P();
      return;
    }
    if (paramInt2 == 5) {
      A().af();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627043);
    this.H = ((XListView)findViewById(2131437671));
    this.I = new FileCategoryAdapter(this, this.G, this.K);
    this.H.setAdapter(this.I);
    O();
    P();
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      break;
    case 1408041717: 
      this.leftView.setVisibility(8);
      this.a.setEditBtnVisible(false);
      setTitle(2131889353);
      break;
    case 1408041716: 
      f();
      this.a.setEditBtnVisible(false);
      setTitle(2131889353);
      return true;
    }
    Intent localIntent = getIntent();
    this.J = localIntent.getBooleanExtra("select_file_only_docs_file", false);
    this.a.setDocsCheck(this.J);
    if (this.J) {
      this.a.setOnlyDocsChecked();
    }
    String str = localIntent.getStringExtra("targetUin");
    if ((paramBundle == null) || (!AppConstants.DATALINE_PC_UIN.equals(str))) {
      e(localIntent.getIntExtra("category", 0));
    }
    B();
    return true;
  }
  
  protected void doOnDestroy()
  {
    AsyncTask localAsyncTask = this.L;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.L = null;
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */