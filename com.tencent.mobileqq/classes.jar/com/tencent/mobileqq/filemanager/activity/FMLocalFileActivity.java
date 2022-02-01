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
  public static String e = "FileAssistantActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask = null;
  public View.OnClickListener a;
  FileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List<FileCategoryEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean l;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new FMLocalFileActivity.2(this);
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
        a().ae();
        finish();
        overridePendingTransition(2130772266, 2130772267);
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
      FMToastUtil.a(2131719713);
    }
    Intent localIntent = null;
    label104:
    if (paramInt == 7)
    {
      if (c()) {
        a().ag();
      } else {
        a().ai();
      }
    }
    else if (paramInt == 8) {
      if (c()) {
        a().ah();
      } else {
        a().aj();
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
      localIntent.putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
      localIntent.putExtra("qrlogin_appid", this.b);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772266, 2130772267);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_JavaLangString = getString(2131692365);
    setTitle(this.jdField_a_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    getString(2131692587);
    getString(2131692584);
    getString(2131692589);
    getString(2131692578);
    getString(2131698215);
    Object localObject = getString(2131692582);
    String str1 = getString(2131692317);
    String str2 = getString(2131692316);
    String str3 = getString(2131692363);
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
      a(2131560783, 2130845496, 2, null, 0, false, 0, 1);
    }
    if (bool1) {
      a(2131560781, 2130844351, 0, str3, 0, false, 20, 2);
    }
    if (bool2) {
      a(2131560774, 2130845496, 1, null, 0, false, 0, 1);
    }
    a(2131560781, 2130844352, 0, (String)localObject, 0, false, 7, 3);
    if (QQFileManagerUtil.a(this).containsKey("externalSdCard"))
    {
      a(2131560781, 2130844353, 0, str1, 0, false, 8, 3);
      a(2131560781, 2130844353, 0, str2, 0, false, 11, 4);
    }
    else
    {
      a(2131560781, 2130844353, 0, str1, 0, false, 8, 4);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter;
    if (localObject == null) {
      return;
    }
    ((FileCategoryAdapter)localObject).notifyDataSetChanged();
    m();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.b = paramInt1;
    localFileCategoryEntity.c = paramInt2;
    localFileCategoryEntity.jdField_a_of_type_Int = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString;
    localFileCategoryEntity.d = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean;
    localFileCategoryEntity.e = paramInt5;
    localFileCategoryEntity.f = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
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
      o();
      return;
    }
    if (paramInt2 == 5) {
      a().af();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560785);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370403));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    n();
    o();
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      break;
    case 1408041717: 
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692365);
      break;
    case 1408041716: 
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692365);
      return true;
    }
    Intent localIntent = getIntent();
    this.l = localIntent.getBooleanExtra("select_file_only_docs_file", false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.l);
    if (this.l) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
    }
    String str = localIntent.getStringExtra("targetUin");
    if ((paramBundle == null) || (!AppConstants.DATALINE_PC_UIN.equals(str))) {
      e(localIntent.getIntExtra("category", 0));
    }
    l();
    return true;
  }
  
  protected void doOnDestroy()
  {
    AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    super.doOnDestroy();
  }
  
  public void m()
  {
    AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new FMLocalFileActivity.1(this).execute(new Void[0]);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */