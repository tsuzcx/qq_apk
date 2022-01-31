package com.tencent.mobileqq.filemanager.activity;

import ajsd;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import aoor;
import aoos;
import aoot;
import aoou;
import aoov;
import aoow;
import aoox;
import aooy;
import aooz;
import aopc;
import aopd;
import apep;
import apev;
import aptm;
import apug;
import bbdx;
import bfpc;
import bfpp;
import bfpt;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String g = "LocalFileBrowserActivity<FileAssistant>";
  private AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  EditText jdField_a_of_type_AndroidWidgetEditText = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public apev a;
  protected bfpt a;
  public BaseActivity a;
  public NoFileRelativeLayout a;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  public Map<String, Integer> a;
  public View.OnClickListener b;
  TextView b;
  public ArrayList<FileInfo> b;
  TextView c;
  public int e = -1;
  public int f = 0;
  public String h;
  String i;
  boolean j;
  boolean k = true;
  
  public LocalFileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_Apev = null;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aoov(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new aooz(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aopc(this);
    this.jdField_a_of_type_Bfpt = new aoos(this);
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
      int m = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getFirstVisiblePosition();
      this.jdField_a_of_type_JavaUtilMap.put(this.h, Integer.valueOf(m));
      this.h = paramString;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.h);
      switch (this.f)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
        this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      }
      this.jdField_a_of_type_AndroidOsAsyncTask = new aoot(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.h)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.h);
      break;
      if (this.h.equalsIgnoreCase(this.i)) {
        this.c.setText(2131692494);
      } else {
        this.c.setText(2131692704);
      }
    }
  }
  
  private void c(int paramInt)
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.post(new LocalFileBrowserActivity.12(this, paramInt));
  }
  
  private boolean l()
  {
    if (((this.f == 8) || (this.f == 11)) && (this.h.equals(this.i))) {
      return super.onBackEvent();
    }
    if (this.f == 6) {
      return super.onBackEvent();
    }
    if (this.f == 23)
    {
      finish();
      return false;
    }
    String str = new VFSFile(this.h).getParent();
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
      this.jdField_a_of_type_Apev.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131369326));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131370861));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692072);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if ((this.f == 7) || (this.f == 8) || (this.f == 11))
    {
      c(false);
      return;
    }
    this.jdField_a_of_type_Apev.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new aoou(this));
  }
  
  private void p()
  {
    switch (this.f)
    {
    }
    for (;;)
    {
      this.i = this.h;
      return;
      this.h = aptm.a().b();
      continue;
      this.h = ajsd.aV;
      continue;
      this.h = "/";
      continue;
      File localFile = (File)apug.a(this).get("externalSdCard");
      if (localFile == null) {
        this.h = "/";
      } else {
        this.h = localFile.getPath();
      }
    }
  }
  
  private void q()
  {
    Object localObject = aptm.a().b();
    String str = aptm.a().c();
    VFSFile localVFSFile = new VFSFile((String)localObject);
    if (!bbdx.a((String)localObject)) {
      localVFSFile.mkdirs();
    }
    localObject = new VFSFile(str);
    if (!bbdx.a(str)) {
      ((VFSFile)localObject).mkdirs();
    }
  }
  
  private void r()
  {
    this.jdField_b_of_type_JavaLangString = getString(apep.a(this.f));
    setTitle(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    }
    this.c = this.leftView;
    if (this.c != null) {
      this.c.setOnClickListener(new aopd(this));
    }
    this.c = this.leftView;
  }
  
  public void b()
  {
    n();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560458);
    this.f = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    p();
    q();
    r();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364864));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369241));
    this.jdField_a_of_type_Apev = new apev(this, this.jdField_b_of_type_JavaUtilArrayList, this);
    o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Apev);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new aoor(this));
    a(this.h, true);
    if (this.f == 6) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    paramBundle = getIntent();
    if (paramBundle.getIntExtra("localSdCardfile", -1) != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      d();
    }
    this.j = paramBundle.getBooleanExtra("select_file_only_docs_file", false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(this.j);
    if (this.j) {
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
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(getResources().getStringArray(2130968633)[1], 3);
    localbfpc.a(new aoow(this, localbfpc));
    localbfpc.setOnDismissListener(new aoox(this));
    localbfpc.setOnCancelListener(new aooy(this));
    localbfpc.c(2131690596);
    localbfpc.show();
  }
  
  public void onBackPressed()
  {
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */