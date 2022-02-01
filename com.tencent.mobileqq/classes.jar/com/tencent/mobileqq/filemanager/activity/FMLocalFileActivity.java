package com.tencent.mobileqq.filemanager.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import asyb;
import asyc;
import atpp;
import atpr;
import audr;
import auea;
import aufb;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String f = "FileAssistantActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  public View.OnClickListener a;
  public atpp a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public List<atpr> a;
  boolean l;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Atpp = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new asyc(this);
  }
  
  private void e(int paramInt)
  {
    Intent localIntent = null;
    switch (paramInt)
    {
    default: 
      if (paramInt == 7) {
        if (c()) {
          a().ag();
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
      audr.a(2131719418);
      break;
      a().ae();
      finish();
      overridePendingTransition(2130772222, 2130772223);
      return;
      a().ai();
      continue;
      if (paramInt == 8) {
        if (c()) {
          a().ah();
        } else {
          a().aj();
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
      localIntent.putExtra("qrlogin_appid", this.b);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772222, 2130772223);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_JavaLangString = getString(2131692300);
    setTitle(this.jdField_a_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    getString(2131692243);
    getString(2131692232);
    getString(2131692301);
    getString(2131692202);
    getString(2131692246);
    String str1 = getString(2131692231);
    String str2 = getString(2131692258);
    String str3 = getString(2131692257);
    String str4 = getString(2131692233);
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
        a(2131560818, 2130845308, 2, null, 0, false, 0, 1);
      }
      if (bool1) {
        a(2131560816, 2130844256, 0, str4, 0, false, 20, 2);
      }
      if (bool3) {
        a(2131560809, 2130845308, 1, null, 0, false, 0, 1);
      }
      a(2131560816, 2130844257, 0, str1, 0, false, 7, 3);
      if (auea.a(this).containsKey("externalSdCard"))
      {
        a(2131560816, 2130844258, 0, str2, 0, false, 8, 3);
        a(2131560816, 2130844258, 0, str3, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_Atpp == null)
      {
        return;
        a(2131560816, 2130844258, 0, str2, 0, false, 8, 4);
      }
      this.jdField_a_of_type_Atpp.notifyDataSetChanged();
      m();
      return;
      bool3 = true;
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    atpr localatpr = new atpr();
    localatpr.b = paramInt1;
    localatpr.c = paramInt2;
    localatpr.jdField_a_of_type_Int = paramInt3;
    localatpr.jdField_a_of_type_JavaLangString = paramString;
    localatpr.d = paramInt4;
    localatpr.jdField_a_of_type_Boolean = paramBoolean;
    localatpr.e = paramInt5;
    localatpr.f = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localatpr);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (paramInt2 == 5) {
        a().af();
      }
      return;
    }
    o();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560820);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370485));
    this.jdField_a_of_type_Atpp = new atpp(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Atpp);
    n();
    o();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      this.l = localIntent.getBooleanExtra("select_file_only_docs_file", false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.l);
      if (this.l) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
      }
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!AppConstants.DATALINE_PC_UIN.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      l();
      return true;
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692300);
      return true;
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131692300);
      break;
      e(localIntent.getIntExtra("category", 0));
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
    this.jdField_a_of_type_AndroidOsAsyncTask = new asyb(this).execute(new Void[0]);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */