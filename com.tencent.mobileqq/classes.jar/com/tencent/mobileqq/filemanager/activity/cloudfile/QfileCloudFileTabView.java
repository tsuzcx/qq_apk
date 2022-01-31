package com.tencent.mobileqq.filemanager.activity.cloudfile;

import acqa;
import acqb;
import acqd;
import acqe;
import acqf;
import acqg;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = null;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new acqf(this);
  final int b;
  public String b;
  public int c;
  public String c;
  public boolean c;
  private int d;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public QfileCloudFileTabView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 15;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    a(paramString);
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      l();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent == null) {
      k();
    }
    a(false);
  }
  
  private boolean a(WeiYunFileInfo paramWeiYunFileInfo, boolean paramBoolean)
  {
    if (paramWeiYunFileInfo == null) {}
    while ((FileManagerUtil.a(FileUtil.a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString)) != 0) || ((f()) && (((FMDataCache.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramWeiYunFileInfo)) && (!paramBoolean))))) {
      return false;
    }
    if (f())
    {
      if (!paramBoolean) {
        break label65;
      }
      FMDataCache.a(paramWeiYunFileInfo);
    }
    for (;;)
    {
      return true;
      label65:
      FMDataCache.b(paramWeiYunFileInfo);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new acqa(this);
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("document") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().u();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().z();
      continue;
      if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().v();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().A();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("video") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().w();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().B();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("music") == true)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().x();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().C();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().y();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().D();
        }
      }
    }
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new QfileWeiYunImageExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new QfileCloudFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    a(new acqe(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString, 0, 15, this.jdField_c_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWeiYunFileInfo);
    String str = QfileTimeUtils.b(paramWeiYunFileInfo.b);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramWeiYunFileInfo);
    if (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).size() == 0) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
    }
    i();
    return true;
  }
  
  public void h()
  {
    this.h = false;
    if (!NetworkUtil.g(a()))
    {
      FMToastUtil.a(2131428327);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int * 15, 15, this.jdField_c_of_type_JavaLangString);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      x();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    x();
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = new acqb(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acqd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void n()
  {
    super.n();
    l();
    if (this.g) {
      i();
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.runOnUiThread(new acqg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */