package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver
  extends TeamWorkFileImportObserver
{
  private SimpleFilePresenter$InnerTeamWorkFileImportObserver(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, boolean paramBoolean)
  {
    int i;
    if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.m())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
      this.a.a(localArrayList, paramString, paramBoolean, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    }
  }
  
  private void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") != 0)
      {
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.2(this));
        if (paramTeamWorkFileImportInfo.b()) {
          TeamWorkHandlerUtils.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.m());
        }
        ReportController.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
        return;
      }
      b(paramJSONObject, paramTeamWorkFileImportInfo, paramString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
      QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", paramJSONObject);
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719628, 0).a();
    }
  }
  
  private void b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.excute(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
  }
  
  private void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    TencentDocData localTencentDocData = new TencentDocData();
    TencentDocData.obtainFromJsonObject(paramJSONObject, null, localTencentDocData);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("key_flag_from_plugin", true);
    paramJSONObject.putExtra("k_forward_show_direct_share_tips", true);
    if (paramTeamWorkFileImportInfo.a())
    {
      paramJSONObject.setClass(this.a.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      ShareMsgHelper.a(this.a.jdField_a_of_type_AndroidAppActivity, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131696401, new Object[] { localTencentDocData.title }), paramString, "web", null, null, null, "web", null, null, null, "https://docs.qq.com/desktop/favicon.ico", this.a.jdField_a_of_type_AndroidAppActivity.getString(2131719569), "", paramJSONObject, 2865, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
      TenDocLogReportHelper.a(null, "0X800A21F");
      return;
    }
    if (paramTeamWorkFileImportInfo.b())
    {
      if (!SimpleFilePresenter.b(this.a))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramTeamWorkFileImportInfo.k);
        paramJSONObject.append("-");
        paramJSONObject.append(paramTeamWorkFileImportInfo.d);
        long l = TenDocLogReportHelper.a(paramJSONObject.toString());
        if (l > 0L) {
          ReportController.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        paramJSONObject = TencentDocLocalCooperationProcessor.a();
        if (paramJSONObject.b(paramTeamWorkFileImportInfo.b))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString, Boolean.valueOf(false));
          return;
        }
        boolean bool = paramJSONObject.a(paramTeamWorkFileImportInfo.b);
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.m, bool);
        paramJSONObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localTencentDocData.docUrl = paramString;
        ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).sendDocCooperationShare(paramJSONObject, this.a.jdField_a_of_type_AndroidAppActivity, localTencentDocData, paramTeamWorkFileImportInfo);
        return;
      }
      TeamWorkHandlerUtils.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.m());
    }
  }
  
  private void c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      int i;
      if (paramTeamWorkFileImportInfo.l == 2) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        TenDocLogReportHelper.a(null, "0X800ABA7");
      } else {
        TenDocLogReportHelper.a(null, "0X800ABA8");
      }
      if (i == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString, Boolean.valueOf(false));
      }
      if ((SimpleFilePresenter.c(this.a)) && (i != 0)) {
        SimpleFilePresenter.b(this.a, true);
      }
      if (i == 0) {
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.q, true);
      }
      paramTeamWorkFileImportInfo.q = null;
      paramTeamWorkFileImportInfo.l = 0;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(paramInt);
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
    }
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramTeamWorkFileImportInfo.b()) {
        ReportController.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.h)) {
        QQToast.a(localQQAppInterface.getApp(), 1, paramTeamWorkFileImportInfo.h, 0).a();
      } else {
        QQToast.a(localQQAppInterface.getApp(), 1, 2131719628, 0).a();
      }
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c())) {
      TenDocLogReportHelper.a(null, "0X800ABAD");
    }
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 1)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(3);
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    c(paramString, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))))
    {
      b(paramString, paramTeamWorkFileImportInfo);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d();
    }
  }
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString1, null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
      SimpleFilePresenter.a(this.a, false, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.c()))
    {
      boolean bool;
      if (paramTeamWorkFileImportInfo.l == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramTeamWorkFileImportInfo.l = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString1, Boolean.valueOf(bool));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(paramBoolean);
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.b(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null))
    {
      String str = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131698525);
      if (paramTeamWorkFileImportInfo.b())
      {
        if (!TencentDocLocalCooperationProcessor.a().b(paramTeamWorkFileImportInfo.b))
        {
          str = HardCodeUtil.a(2131698212);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.h(str);
        }
      }
      else {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.h(str);
      }
      TenDocLogReportHelper.a(null, "0X800A21E");
    }
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 1))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramTeamWorkFileImportInfo);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(1);
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(4);
      SimpleFilePresenter.a(this.a, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      return;
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
      TenDocLogReportHelper.a(null, "0X800ABA4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver
 * JD-Core Version:    0.7.0.1
 */