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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public static String e = "LocalFileBrowserActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  EditText jdField_a_of_type_AndroidWidgetEditText = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  LocalFileAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
  protected AdapterView.OnItemClickListener a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ArrayList<FileInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  TextView c;
  int e = -1;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString;
  String g;
  boolean l = false;
  boolean m;
  boolean n = true;
  
  public LocalFileBrowserActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new LocalFileBrowserActivity.5(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LocalFileBrowserActivity.6(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new LocalFileBrowserActivity.8(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.length() == 0) {
        return;
      }
      do
      {
        paramString = new File(str);
        if (paramString.exists()) {
          break;
        }
        paramString = paramString.getParent();
        str = paramString;
      } while (paramString != null);
      str = paramString;
      if (str == null) {
        return;
      }
      if (paramBoolean)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getFirstVisiblePosition();
        this.jdField_a_of_type_JavaUtilMap.put(this.jdField_f_of_type_JavaLangString, Integer.valueOf(i));
      }
      else if (this.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_f_of_type_JavaLangString);
      int i = this.jdField_f_of_type_Int;
      if ((i != 6) && ((i == 7) || (i == 8) || (i == 11))) {
        if (this.jdField_f_of_type_JavaLangString.equalsIgnoreCase(this.g)) {
          this.c.setText(2131692365);
        } else {
          this.c.setText(2131692597);
        }
      }
      paramString = this.jdField_a_of_type_AndroidOsAsyncTask;
      if (paramString != null) {
        paramString.cancel(true);
      }
      a(paramBoolean, str);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new LocalFileBrowserActivity.9(this, paramBoolean).execute(new String[] { paramString });
  }
  
  private void e(int paramInt)
  {
    m();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new LocalFileBrowserActivity.10(this, paramInt));
  }
  
  private boolean l()
  {
    int i = this.jdField_f_of_type_Int;
    if (((i == 8) || (i == 11)) && (this.jdField_f_of_type_JavaLangString.equals(this.g))) {
      return super.onBackEvent();
    }
    i = this.jdField_f_of_type_Int;
    if (i == 6) {
      return super.onBackEvent();
    }
    if (i == 23)
    {
      finish();
      return false;
    }
    String str = new File(this.jdField_f_of_type_JavaLangString).getParent();
    if (str != null)
    {
      a(str, false);
      return false;
    }
    return super.onBackEvent();
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.notifyDataSetChanged();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131370175));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131371906));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131691949);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    int i = this.jdField_f_of_type_Int;
    if ((i != 7) && (i != 8) && (i != 11))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
      return;
    }
    c(false);
  }
  
  private void o()
  {
    int i = this.jdField_f_of_type_Int;
    if (i != 6) {
      if (i != 7)
      {
        if (i != 8)
        {
          if (i != 11)
          {
            if (i != 23) {
              break label106;
            }
          }
          else
          {
            File localFile = (File)QQFileManagerUtil.a(this).get("externalSdCard");
            if (localFile == null)
            {
              this.jdField_f_of_type_JavaLangString = "/";
              break label106;
            }
            this.jdField_f_of_type_JavaLangString = localFile.getPath();
            break label106;
          }
        }
        else
        {
          this.jdField_f_of_type_JavaLangString = AppConstants.SDCARD_ROOT;
          break label106;
        }
      }
      else
      {
        this.jdField_f_of_type_JavaLangString = "/";
        break label106;
      }
    }
    this.jdField_f_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_PATH;
    label106:
    this.g = this.jdField_f_of_type_JavaLangString;
  }
  
  private void p()
  {
    Object localObject = AppConstants.SDCARD_FILE_SAVE_PATH;
    String str = AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
    File localFile = new File((String)localObject);
    if (!FileUtils.fileExists((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!FileUtils.fileExists(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_JavaLangString = getString(FileCategoryEntity.a(this.jdField_f_of_type_Int));
    setTitle(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    }
    this.c = this.leftView;
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setOnClickListener(new LocalFileBrowserActivity.7(this));
    }
    this.c = this.leftView;
  }
  
  public void b()
  {
    m();
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
    setContentView(2131560787);
    paramBundle = getIntent();
    this.jdField_f_of_type_Int = paramBundle.getBundleExtra("bundle").getInt("category");
    this.l = paramBundle.getBooleanExtra("open_with_qq_images", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = this;
    o();
    p();
    q();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365341));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370082));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = new LocalFileAdapter(this, this.jdField_b_of_type_JavaUtilArrayList, this);
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new LocalFileBrowserActivity.1(this));
    a(this.jdField_f_of_type_JavaLangString, true);
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
  
  protected void doOnDestroy()
  {
    AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    super.doOnDestroy();
  }
  
  protected boolean isWrapContent()
  {
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */