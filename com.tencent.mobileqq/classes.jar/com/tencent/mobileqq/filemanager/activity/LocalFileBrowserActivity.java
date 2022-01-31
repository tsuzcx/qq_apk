package com.tencent.mobileqq.filemanager.activity;

import acnd;
import acne;
import acnf;
import acng;
import acnh;
import acni;
import acnj;
import acnk;
import acnl;
import acnm;
import acnp;
import acnq;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
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
  public static String e;
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public BaseActivity a;
  public LocalFileAdapter a;
  public NoFileRelativeLayout a;
  public SlideDetectListView a;
  protected AdapterView.OnItemClickListener a;
  public BubblePopupWindow a;
  public Map a;
  public View.OnClickListener b;
  TextView b;
  public ArrayList b;
  TextView c;
  public int d;
  TextView d;
  public int e;
  public String f;
  String g;
  
  static
  {
    jdField_e_of_type_JavaLangString = "LocalFileBrowserActivity<FileAssistant>";
  }
  
  public LocalFileBrowserActivity()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = null;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new acni(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new acnm(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new acnp(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new acne(this);
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
        File localFile = new File(str);
        paramString = str;
        if (localFile.exists()) {
          break;
        }
        paramString = localFile.getParent();
        str = paramString;
      } while (paramString != null);
    } while (paramString == null);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getFirstVisiblePosition();
      this.jdField_a_of_type_JavaUtilMap.put(this.f, Integer.valueOf(i));
      this.f = paramString;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.f);
      switch (this.jdField_e_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
        this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      }
      this.jdField_a_of_type_AndroidOsAsyncTask = new acnf(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.f)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.f);
      break;
      if (this.f.equalsIgnoreCase(this.g)) {
        this.c.setText(2131428086);
      } else {
        this.c.setText(2131428249);
      }
    }
  }
  
  private void b(int paramInt)
  {
    m();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new acng(this, paramInt));
  }
  
  private boolean i()
  {
    if (((this.jdField_e_of_type_Int == 8) || (this.jdField_e_of_type_Int == 11)) && (this.f.equals(this.g))) {
      return super.onBackEvent();
    }
    if (this.jdField_e_of_type_Int == 6) {
      return super.onBackEvent();
    }
    String str = new File(this.f).getParent();
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
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131368796));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131368797));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131435629);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if ((this.jdField_e_of_type_Int == 7) || (this.jdField_e_of_type_Int == 8) || (this.jdField_e_of_type_Int == 11))
    {
      c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new acnh(this));
  }
  
  private void o()
  {
    switch (this.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      this.g = this.f;
      return;
      this.f = FMSettings.a().b();
      continue;
      this.f = AppConstants.aI;
      continue;
      this.f = "/";
      continue;
      File localFile = (File)FileManagerUtil.a(this).get("externalSdCard");
      if (localFile == null) {
        this.f = "/";
      } else {
        this.f = localFile.getPath();
      }
    }
  }
  
  private void p()
  {
    Object localObject = FMSettings.a().b();
    String str = FMSettings.a().c();
    File localFile = new File((String)localObject);
    if (!FileUtils.a((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!FileUtils.a(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void q()
  {
    this.jdField_b_of_type_JavaLangString = getString(FileCategoryEntity.a(this.jdField_e_of_type_Int));
    setTitle(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    }
    this.c = this.leftView;
    if (this.c != null) {
      this.c.setOnClickListener(new acnq(this));
    }
    this.c = this.leftView;
  }
  
  public void b()
  {
    m();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970018);
    this.jdField_e_of_type_Int = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    o();
    p();
    q();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368795));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368794));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter = new LocalFileAdapter(this, this.jdField_b_of_type_JavaUtilArrayList, this);
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new acnd(this));
    a(this.f, true);
    if (this.jdField_e_of_type_Int == 6) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (getIntent().getIntExtra("localSdCardfile", -1) != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      d();
    }
    k();
    return true;
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getStringArray(2131296340)[1], 3);
    localActionSheet.a(new acnj(this, localActionSheet));
    localActionSheet.setOnDismissListener(new acnk(this));
    localActionSheet.setOnCancelListener(new acnl(this));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  public void onBackPressed()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */