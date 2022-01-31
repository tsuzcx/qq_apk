package com.tencent.mobileqq.filemanager.activity;

import ajed;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import anxt;
import anxu;
import anxv;
import anxw;
import anxx;
import anxy;
import anxz;
import anya;
import anyb;
import anye;
import anyf;
import aonq;
import aonw;
import apbo;
import apck;
import bace;
import begr;
import behe;
import behi;
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
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public aonw a;
  protected behi a;
  public BaseActivity a;
  public NoFileRelativeLayout a;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  public Map<String, Integer> a;
  public View.OnClickListener b;
  TextView b;
  public ArrayList<FileInfo> b;
  TextView c;
  TextView d = null;
  public int e = -1;
  public int f = 0;
  public String h;
  String i;
  boolean j;
  
  public LocalFileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = null;
    this.jdField_a_of_type_Aonw = null;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new anxx(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new anyb(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new anye(this);
    this.jdField_a_of_type_Behi = new anxu(this);
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
      int k = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getFirstVisiblePosition();
      this.jdField_a_of_type_JavaUtilMap.put(this.h, Integer.valueOf(k));
      this.h = paramString;
      this.d.setText(this.h);
      switch (this.f)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
        this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
      }
      this.jdField_a_of_type_AndroidOsAsyncTask = new anxv(this, paramBoolean).execute(new String[] { paramString });
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(this.h)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(this.h);
      break;
      if (this.h.equalsIgnoreCase(this.i)) {
        this.c.setText(2131626880);
      } else {
        this.c.setText(2131627065);
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
    String str = new File(this.h).getParent();
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
      this.jdField_a_of_type_Aonw.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131303656));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = ((NoFileRelativeLayout)findViewById(2131305188));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131626486);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_Behi);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    if ((this.f == 7) || (this.f == 8) || (this.f == 11))
    {
      c(false);
      return;
    }
    this.jdField_a_of_type_Aonw.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new anxw(this));
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
      this.h = apbo.a().b();
      continue;
      this.h = ajed.aT;
      continue;
      this.h = "/";
      continue;
      File localFile = (File)apck.a(this).get("externalSdCard");
      if (localFile == null) {
        this.h = "/";
      } else {
        this.h = localFile.getPath();
      }
    }
  }
  
  private void q()
  {
    Object localObject = apbo.a().b();
    String str = apbo.a().c();
    File localFile = new File((String)localObject);
    if (!bace.a((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!bace.a(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void r()
  {
    this.jdField_b_of_type_JavaLangString = getString(aonq.a(this.f));
    setTitle(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    }
    this.c = this.leftView;
    if (this.c != null) {
      this.c.setOnClickListener(new anyf(this));
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
    setContentView(2131494887);
    this.f = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    p();
    q();
    r();
    this.d = ((TextView)findViewById(2131299302));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303572));
    this.jdField_a_of_type_Aonw = new aonw(this, this.jdField_b_of_type_JavaUtilArrayList, this);
    o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Aonw);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this.jdField_a_of_type_Behi);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(new anxt(this));
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
  
  public void m()
  {
    begr localbegr = (begr)behe.a(this, null);
    localbegr.a(getResources().getStringArray(2130903097)[1], 3);
    localbegr.a(new anxy(this, localbegr));
    localbegr.setOnDismissListener(new anxz(this));
    localbegr.setOnCancelListener(new anya(this));
    localbegr.c(2131625035);
    localbegr.show();
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