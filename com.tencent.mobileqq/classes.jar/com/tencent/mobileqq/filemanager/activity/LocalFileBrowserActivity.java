package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String f;
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  EditText jdField_a_of_type_AndroidWidgetEditText = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  LocalFileAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
  protected AdapterView.OnItemClickListener a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  public View.OnClickListener b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList<FileInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  TextView c;
  int e = -1;
  int f;
  String g;
  String h;
  boolean l = false;
  boolean m;
  boolean n = true;
  
  static
  {
    jdField_f_of_type_JavaLangString = "LocalFileBrowserActivity<FileAssistant>";
  }
  
  public LocalFileBrowserActivity()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LocalFileBrowserActivity.3(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new LocalFileBrowserActivity.7(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new LocalFileBrowserActivity.8(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new LocalFileBrowserActivity.10(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {
        break label15;
      }
    }
    label15:
    do
    {
      return;
      do
      {
        VFSFile localVFSFile = new VFSFile(str);
        paramString = str;
        if (localVFSFile.exists()) {
          break;
        }
        paramString = localVFSFile.getParent();
        str = paramString;
      } while (paramString != null);
    } while (paramString == null);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getFirstVisiblePosition();
      this.jdField_a_of_type_JavaUtilMap.put(this.g, Integer.valueOf(i));
      this.g = paramString;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.g);
      switch (this.jdField_f_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
        this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      }
      a(paramBoolean, paramString);
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.g)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.g);
      break;
      if (this.g.equalsIgnoreCase(this.h)) {
        this.c.setText(2131692432);
      } else {
        this.c.setText(2131692640);
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new LocalFileBrowserActivity.11(this, paramBoolean).execute(new String[] { paramString });
  }
  
  private void e(int paramInt)
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new LocalFileBrowserActivity.12(this, paramInt));
  }
  
  private boolean l()
  {
    if (((this.jdField_f_of_type_Int == 8) || (this.jdField_f_of_type_Int == 11)) && (this.g.equals(this.h))) {
      return super.onBackEvent();
    }
    if (this.jdField_f_of_type_Int == 6) {
      return super.onBackEvent();
    }
    if (this.jdField_f_of_type_Int == 23)
    {
      finish();
      return false;
    }
    String str = new VFSFile(this.g).getParent();
    if (str != null)
    {
      a(str, false);
      return false;
    }
    return super.onBackEvent();
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131370515));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131372321));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692030);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if ((this.jdField_f_of_type_Int == 7) || (this.jdField_f_of_type_Int == 8) || (this.jdField_f_of_type_Int == 11))
    {
      c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new LocalFileBrowserActivity.2(this));
  }
  
  private void p()
  {
    switch (this.jdField_f_of_type_Int)
    {
    }
    for (;;)
    {
      this.h = this.g;
      return;
      this.g = FMSettings.a().b();
      continue;
      this.g = AppConstants.SDCARD_ROOT;
      continue;
      this.g = "/";
      continue;
      File localFile = (File)FileManagerUtil.a(this).get("externalSdCard");
      if (localFile == null) {
        this.g = "/";
      } else {
        this.g = localFile.getPath();
      }
    }
  }
  
  private void q()
  {
    Object localObject = FMSettings.a().b();
    String str = FMSettings.a().c();
    VFSFile localVFSFile = new VFSFile((String)localObject);
    if (!FileUtils.a((String)localObject)) {
      localVFSFile.mkdirs();
    }
    localObject = new VFSFile(str);
    if (!FileUtils.a(str)) {
      ((VFSFile)localObject).mkdirs();
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_JavaLangString = getString(FileCategoryEntity.a(this.jdField_f_of_type_Int));
    setTitle(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    }
    this.c = this.leftView;
    if (this.c != null) {
      this.c.setOnClickListener(new LocalFileBrowserActivity.9(this));
    }
    this.c = this.leftView;
  }
  
  public void b()
  {
    n();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560913);
    paramBundle = getIntent();
    this.jdField_f_of_type_Int = paramBundle.getBundleExtra("bundle").getInt("category");
    this.l = paramBundle.getBooleanExtra("open_with_qq_images", false);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    p();
    q();
    r();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365496));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370423));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = new LocalFileAdapter(this, this.jdField_b_of_type_JavaUtilArrayList, this);
    o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new LocalFileBrowserActivity.1(this));
    a(this.g, true);
    if (this.jdField_f_of_type_Int == 6) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (paramBundle.getIntExtra("localSdCardfile", -1) != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      d();
    }
    this.m = paramBundle.getBooleanExtra("select_file_only_docs_file", false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.m);
    if (this.m) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setOnlyDocsChecked();
    }
    l();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    super.doOnDestroy();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void m()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(getResources().getStringArray(2130968635)[1], 3);
    localActionSheet.setOnButtonClickListener(new LocalFileBrowserActivity.4(this, localActionSheet));
    localActionSheet.setOnDismissListener(new LocalFileBrowserActivity.5(this));
    localActionSheet.setOnCancelListener(new LocalFileBrowserActivity.6(this));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  public void onBackPressed()
  {
    l();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */