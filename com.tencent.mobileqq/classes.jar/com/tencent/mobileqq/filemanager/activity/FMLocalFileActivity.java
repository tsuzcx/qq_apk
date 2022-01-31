package com.tencent.mobileqq.filemanager.activity;

import aljq;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqgz;
import aqha;
import aqxl;
import aqxn;
import armz;
import arni;
import arol;
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
  public aqxl a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public List<aqxn> a;
  boolean j;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aqxl = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqha(this);
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
      armz.a(2131720879);
      break;
      a().ag();
      finish();
      overridePendingTransition(2130772215, 2130772216);
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
      overridePendingTransition(2130772215, 2130772216);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_b_of_type_JavaLangString = getString(2131692570);
    setTitle(this.jdField_b_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    getString(2131692514);
    getString(2131692503);
    getString(2131692571);
    getString(2131692474);
    getString(2131692517);
    String str1 = getString(2131692502);
    String str2 = getString(2131692529);
    String str3 = getString(2131692528);
    String str4 = getString(2131692504);
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
        a(2131560629, 2130844857, 2, null, 0, false, 0, 1);
      }
      if (bool1) {
        a(2131560627, 2130843827, 0, str4, 0, false, 20, 2);
      }
      if (bool3) {
        a(2131560620, 2130844857, 1, null, 0, false, 0, 1);
      }
      a(2131560627, 2130843828, 0, str1, 0, false, 7, 3);
      if (arni.a(this).containsKey("externalSdCard"))
      {
        a(2131560627, 2130843829, 0, str2, 0, false, 8, 3);
        a(2131560627, 2130843829, 0, str3, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_Aqxl == null)
      {
        return;
        a(2131560627, 2130843829, 0, str2, 0, false, 8, 4);
      }
      this.jdField_a_of_type_Aqxl.notifyDataSetChanged();
      m();
      return;
      bool3 = true;
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    aqxn localaqxn = new aqxn();
    localaqxn.b = paramInt1;
    localaqxn.c = paramInt2;
    localaqxn.jdField_a_of_type_Int = paramInt3;
    localaqxn.jdField_a_of_type_JavaLangString = paramString;
    localaqxn.d = paramInt4;
    localaqxn.jdField_a_of_type_Boolean = paramBoolean;
    localaqxn.e = paramInt5;
    localaqxn.f = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localaqxn);
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
    setContentView(2131560631);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369781));
    this.jdField_a_of_type_Aqxl = new aqxl(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aqxl);
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
      if ((paramBundle == null) || (!aljq.z.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      l();
      return true;
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692570);
      return true;
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692570);
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
    this.jdField_a_of_type_AndroidOsAsyncTask = new aqgz(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */