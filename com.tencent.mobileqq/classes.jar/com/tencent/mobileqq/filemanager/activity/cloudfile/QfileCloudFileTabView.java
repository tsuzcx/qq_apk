package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileTabView
  extends QfileBaseCloudFileTabView
{
  QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = null;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private IClickListenerVer51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = null;
  QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new QfileCloudFileTabView.6(this);
  final int b;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new QfileCloudFileTabView.8(this);
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new QfileCloudFileTabView.9(this);
  private boolean jdField_f_of_type_Boolean;
  private boolean g = false;
  private boolean h = false;
  
  public QfileCloudFileTabView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 15;
    this.jdField_e_of_type_Int = paramInt;
    a(paramString);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (WeiYunFileInfo)((ImageHolder)paramView.getTag()).a;
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.b(paramView);
      }
      else
      {
        FMDataCache.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i()) && (!FMDataCache.a(FMDataCache.jdField_b_of_type_Int)))
        {
          paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131698224);
          paramView.setPositiveButton(2131719788, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          FMDataCache.b(FMDataCache.jdField_b_of_type_Int);
          FileManagerReporter.a("0X800942F");
        }
      }
      w();
      ai_();
    }
    else
    {
      if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        }
        return;
      }
      if (g()) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      u();
      FileManagerReporter.a("0X8004AE6");
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openWeiYunFileBrowser(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, a(paramView), paramView);
    }
    b(g());
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    if (paramWeiYunFileInfo == null) {
      return false;
    }
    if (QQFileManagerUtil.b(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString)) != 0) {
      return false;
    }
    if ((g()) && (((FMDataCache.a(paramWeiYunFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramWeiYunFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g()) {
      if (paramBoolean) {
        FMDataCache.a(paramWeiYunFileInfo);
      } else {
        FMDataCache.b(paramWeiYunFileInfo);
      }
    }
    return true;
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51 = new QfileCloudFileTabView.1(this);
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("document") == true)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().s();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().x();
      }
    }
    else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().t();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().y();
      }
    }
    else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("video") == true)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().u();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().z();
      }
    }
    else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("music") == true)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().v();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().A();
      }
    }
    else if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("other") == true) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.c()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().w();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().B();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListenerVer51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      return new QfileWeiYunImageExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_e_of_type_AndroidViewView$OnClickListener, this.jdField_f_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    setEditbarButton(false, true, false, true, true);
    return new QfileCloudFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void a()
  {
    a(new QfileCloudFileTabView.4(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, 0, 15, this.jdField_c_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  protected boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWeiYunFileInfo)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramWeiYunFileInfo);
    String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramWeiYunFileInfo.b);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str))
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).remove(paramWeiYunFileInfo);
    if (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).size() == 0) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(str);
    }
    i();
    return true;
  }
  
  protected void h()
  {
    this.h = false;
    if (!NetworkUtil.isNetworkAvailable(a()))
    {
      FMToastUtil.a(2131692554);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int * 15, 15, this.jdField_c_of_type_JavaLangString);
    f();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture") == true)
    {
      setEditbarButton(true, true, false, true, true);
      p();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
      return;
    }
    setEditbarButton(false, true, false, true, true);
    p();
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = new QfileCloudFileTabView.2(this);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QfileCloudFileTabView.3(this);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void m()
  {
    super.m();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileCloudFileTabView.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView
 * JD-Core Version:    0.7.0.1
 */