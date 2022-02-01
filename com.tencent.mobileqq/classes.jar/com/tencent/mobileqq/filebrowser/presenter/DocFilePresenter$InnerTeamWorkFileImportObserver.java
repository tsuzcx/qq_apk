package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class DocFilePresenter$InnerTeamWorkFileImportObserver
  extends TeamWorkFileImportObserver
{
  private DocFilePresenter$InnerTeamWorkFileImportObserver(DocFilePresenter paramDocFilePresenter) {}
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, boolean paramBoolean)
  {
    int i;
    if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (!paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a()))) {
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
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new DocFilePresenter.InnerTeamWorkFileImportObserver.2(this));
        if (paramTeamWorkFileImportInfo.b()) {
          TeamWorkHandlerUtils.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
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
      QLog.e("DocFilePresenter", 1, "direct share fail", paramJSONObject);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, 2131719628, 0).a();
    }
  }
  
  private boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 0);
  }
  
  private void b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.excute(new DocFilePresenter.InnerTeamWorkFileImportObserver.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
  }
  
  private void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo.a())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(paramJSONObject, paramString, this.a.jdField_a_of_type_AndroidAppActivity);
      TenDocLogReportHelper.a(null, "0X800A21F");
      return;
    }
    if (paramTeamWorkFileImportInfo.b())
    {
      if (!DocFilePresenter.b(this.a))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.k);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.d);
        long l = TenDocLogReportHelper.a(((StringBuilder)localObject).toString());
        if (l > 0L) {
          ReportController.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        localObject = TencentDocLocalCooperationProcessor.a();
        if (((TencentDocLocalCooperationBean)localObject).b(paramTeamWorkFileImportInfo.b))
        {
          DocFilePresenter.a(this.a).a(paramString, Boolean.valueOf(false));
          return;
        }
        boolean bool = ((TencentDocLocalCooperationBean)localObject).a(paramTeamWorkFileImportInfo.b);
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.m, bool);
        this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(paramJSONObject, paramString, paramTeamWorkFileImportInfo, this.a.jdField_a_of_type_AndroidAppActivity);
        return;
      }
      TeamWorkHandlerUtils.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    }
  }
  
  private boolean b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 0);
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
        DocFilePresenter.a(this.a).a(paramString, Boolean.valueOf(false));
      }
      if ((DocFilePresenter.c(this.a)) && (i != 0)) {
        DocFilePresenter.b(this.a, true);
      }
      if (i == 0) {
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.q, true);
      }
      paramTeamWorkFileImportInfo.q = null;
      paramTeamWorkFileImportInfo.l = 0;
    }
  }
  
  private boolean c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 1);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (DocFilePresenter.a(this.a) != null) {
      DocFilePresenter.a(this.a).a(paramInt);
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (DocFilePresenter.a(this.a) != null) {
      DocFilePresenter.a(this.a).d();
    }
    if (b(paramTeamWorkFileImportInfo))
    {
      if (paramTeamWorkFileImportInfo.b()) {
        ReportController.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.h)) {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramTeamWorkFileImportInfo.h, 0).a();
      } else {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, 2131719628, 0).a();
      }
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c())) {
      TenDocLogReportHelper.a(null, "0X800ABAD");
    }
    if ((DocFilePresenter.a(this.a) != null) && (c(paramTeamWorkFileImportInfo))) {
      DocFilePresenter.a(this.a).b(3);
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
    if (DocFilePresenter.a(this.a) != null) {
      DocFilePresenter.a(this.a).d();
    }
  }
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      DocFilePresenter.a(this.a).a(paramString1, null);
      DocFilePresenter.a(this.a).b(5);
      DocFilePresenter.a(this.a, false, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
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
      DocFilePresenter.a(this.a).a(paramString1, Boolean.valueOf(bool));
      DocFilePresenter.a(this.a).b(5);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (DocFilePresenter.a(this.a) != null) {
      DocFilePresenter.a(this.a).a(paramBoolean);
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.b(paramTeamWorkFileImportInfo);
    if (a(paramTeamWorkFileImportInfo))
    {
      String str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131698525);
      if (paramTeamWorkFileImportInfo.b())
      {
        if (!TencentDocLocalCooperationProcessor.a().b(paramTeamWorkFileImportInfo.b))
        {
          str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131692447);
          DocFilePresenter.a(this.a).a(str);
        }
      }
      else {
        DocFilePresenter.a(this.a).a(str);
      }
      TenDocLogReportHelper.a(null, "0X800A21E");
    }
    if (c(paramTeamWorkFileImportInfo))
    {
      DocFilePresenter.a(this.a).a(paramTeamWorkFileImportInfo);
      DocFilePresenter.a(this.a).b(1);
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b()))
    {
      DocFilePresenter.a(this.a).b(4);
      DocFilePresenter.a(this.a, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      return;
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      DocFilePresenter.a(this.a).b(5);
      TenDocLogReportHelper.a(null, "0X800ABA4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.InnerTeamWorkFileImportObserver
 * JD-Core Version:    0.7.0.1
 */