package com.tencent.mobileqq.filemanager.activity;

import acmb;
import acmc;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String e = "FileAssistantActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  public View.OnClickListener a;
  public FileCategoryAdapter a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public List a;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acmc(this);
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = null;
    switch (paramInt)
    {
    default: 
      if (paramInt == 7) {
        if (c()) {
          a().ai();
        }
      }
      break;
    }
    for (;;)
    {
      if (localIntent != null) {
        break label194;
      }
      return;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        break;
      }
      FMToastUtil.a(2131428201);
      break;
      a().ag();
      finish();
      overridePendingTransition(2131034309, 2131034310);
      return;
      a().ak();
      continue;
      if (paramInt == 8) {
        if (c()) {
          a().aj();
        } else {
          a().al();
        }
      }
    }
    try
    {
      label194:
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
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2131034309, 2131034310);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    this.b = getString(2131428086);
    setTitle(this.b);
  }
  
  private void n()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = getString(2131428120);
    String str2 = getString(2131428111);
    String str3 = getString(2131428112);
    String str4 = getString(2131428113);
    String str5 = getString(2131428102);
    String str6 = getString(2131428116);
    String str7 = getString(2131428117);
    String str8 = getString(2131428118);
    String str9 = getString(2131428093);
    Intent localIntent = getIntent();
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool1;
    boolean bool5;
    if (localIntent != null)
    {
      bool8 = localIntent.getBooleanExtra("STRING_Show_Music_Category", true);
      bool7 = localIntent.getBooleanExtra("STRING_Show_Video_Category", true);
      bool6 = localIntent.getBooleanExtra("STRING_Show_Apk_Category", true);
      bool2 = localIntent.getBooleanExtra("STRING_Show_Pic_Category", true);
      bool3 = localIntent.getBooleanExtra("STRING_Show_Download_Category", true);
      bool4 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      boolean bool9 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
      bool5 = bool3;
      bool3 = bool1;
      bool1 = bool9;
    }
    for (;;)
    {
      if (bool4) {
        a(2130970014, 2130842666, 2, null, 0, false, 0, 1);
      }
      if (bool2) {
        a(2130970012, 2130841634, 0, str1, FileCategoryUtil.a(this), true, 10, 2);
      }
      if (bool8) {
        a(2130970012, 2130841632, 0, str2, FileCategoryUtil.b(this), true, 1, 3);
      }
      if (bool7) {
        a(2130970012, 2130841638, 0, str3, FileCategoryUtil.c(this), true, 2, 3);
      }
      if (bool6) {
        a(2130970012, 2130841627, 0, str4, 0, true, 4, 4);
      }
      if (bool3) {
        a(2130970012, 2130841630, 0, str9, 0, false, 20, 2);
      }
      if (bool1) {
        a(2130970005, 2130842666, 1, null, 0, false, 0, 1);
      }
      if (bool5) {
        a(2130970012, 2130841629, 0, str5, 0, false, 6, 2);
      }
      a(2130970012, 2130841635, 0, str6, 0, false, 7, 3);
      if (FileManagerUtil.a(this).containsKey("externalSdCard"))
      {
        a(2130970012, 2130841636, 0, str7, 0, false, 8, 3);
        a(2130970012, 2130841636, 0, str8, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter == null)
      {
        return;
        a(2130970012, 2130841636, 0, str7, 0, false, 8, 4);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      l();
      return;
      bool1 = true;
      bool3 = false;
      bool5 = true;
      bool2 = true;
      bool6 = true;
      bool7 = true;
      bool8 = true;
      bool4 = true;
    }
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (paramInt2 == 5) {
        a().ah();
      }
      return;
    }
    n();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970016);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131368790));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    m();
    n();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!AppConstants.y.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      k();
      return true;
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131428086);
      return true;
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131428086);
      break;
      b(localIntent.getIntExtra("category", 0));
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    super.doOnDestroy();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new acmb(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */