package com.tencent.mobileqq.filemanager.activity;

import ajsd;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aoob;
import aooc;
import apen;
import apep;
import aptx;
import apug;
import apvj;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String g = "FileAssistantActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  public View.OnClickListener a;
  public apen a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public List<apep> a;
  boolean j;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Apen = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aooc(this);
  }
  
  private void c(int paramInt)
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
      aptx.a(2131720343);
      break;
      a().ag();
      finish();
      overridePendingTransition(2130772200, 2130772201);
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
      localIntent.putExtra("select_file_only_docs_file", this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
      localIntent.putExtra("qrlogin_appid", this.jdField_b_of_type_Long);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772200, 2130772201);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_b_of_type_JavaLangString = getString(2131692494);
    setTitle(this.jdField_b_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    getString(2131692438);
    getString(2131692427);
    getString(2131692495);
    getString(2131692398);
    getString(2131692441);
    String str1 = getString(2131692426);
    String str2 = getString(2131692453);
    String str3 = getString(2131692452);
    String str4 = getString(2131692428);
    Intent localIntent = getIntent();
    boolean bool2;
    boolean bool1;
    boolean bool3;
    if (localIntent != null)
    {
      bool2 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      bool3 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
    }
    for (;;)
    {
      if (bool2) {
        a(2131560454, 2130844493, 2, null, 0, false, 0, 1);
      }
      if (bool1) {
        a(2131560452, 2130843468, 0, str4, 0, false, 20, 2);
      }
      if (bool3) {
        a(2131560445, 2130844493, 1, null, 0, false, 0, 1);
      }
      a(2131560452, 2130843469, 0, str1, 0, false, 7, 3);
      if (apug.a(this).containsKey("externalSdCard"))
      {
        a(2131560452, 2130843470, 0, str2, 0, false, 8, 3);
        a(2131560452, 2130843470, 0, str3, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_Apen == null)
      {
        return;
        a(2131560452, 2130843470, 0, str2, 0, false, 8, 4);
      }
      this.jdField_a_of_type_Apen.notifyDataSetChanged();
      m();
      return;
      bool3 = true;
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    apep localapep = new apep();
    localapep.b = paramInt1;
    localapep.c = paramInt2;
    localapep.jdField_a_of_type_Int = paramInt3;
    localapep.jdField_a_of_type_JavaLangString = paramString;
    localapep.d = paramInt4;
    localapep.jdField_a_of_type_Boolean = paramBoolean;
    localapep.e = paramInt5;
    localapep.f = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localapep);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (paramInt2 == 5) {
        a().ah();
      }
      return;
    }
    o();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560456);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369519));
    this.jdField_a_of_type_Apen = new apen(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Apen);
    n();
    o();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      this.j = localIntent.getBooleanExtra("select_file_only_docs_file", false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.j);
      if (this.j) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
      }
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!ajsd.z.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      l();
      return true;
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692494);
      return true;
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692494);
      break;
      c(localIntent.getIntExtra("category", 0));
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    super.doOnDestroy();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new aoob(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */