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
    if (((paramTeamWorkFileImportInfo.a == 1) || (paramTeamWorkFileImportInfo.a == 0) || (paramTeamWorkFileImportInfo.a == 3000)) && (!paramTeamWorkFileImportInfo.b.equals(this.a.c.f()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramTeamWorkFileImportInfo.b);
      this.a.a(localArrayList, paramString, paramBoolean, paramTeamWorkFileImportInfo.a);
    }
  }
  
  private void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") != 0)
      {
        this.a.e.runOnUiThread(new DocFilePresenter.InnerTeamWorkFileImportObserver.2(this));
        if (paramTeamWorkFileImportInfo.b()) {
          TeamWorkHandlerUtils.b(paramTeamWorkFileImportInfo.F, this.a.c.f());
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
      QQToast.makeText(this.a.f, 1, 2131917225, 0).show();
    }
  }
  
  private void b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.excute(new DocFilePresenter.InnerTeamWorkFileImportObserver.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
  }
  
  private void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo.a())
    {
      this.a.c.a(paramJSONObject, paramString, this.a.e);
      TenDocLogReportHelper.a(null, "0X800A21F");
      return;
    }
    if (paramTeamWorkFileImportInfo.b())
    {
      if (!DocFilePresenter.d(this.a))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.A);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.n);
        long l = TenDocLogReportHelper.g(((StringBuilder)localObject).toString());
        if (l > 0L) {
          ReportController.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        localObject = TencentDocLocalCooperationProcessor.a();
        if (((TencentDocLocalCooperationBean)localObject).c(paramTeamWorkFileImportInfo.c))
        {
          DocFilePresenter.a(this.a).a(paramString, Boolean.valueOf(false));
          return;
        }
        boolean bool = ((TencentDocLocalCooperationBean)localObject).b(paramTeamWorkFileImportInfo.c);
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.F, bool);
        this.a.c.a(paramJSONObject, paramString, paramTeamWorkFileImportInfo, this.a.e);
        return;
      }
      TeamWorkHandlerUtils.b(paramTeamWorkFileImportInfo.F, this.a.c.f());
    }
  }
  
  private void c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      int i;
      if (paramTeamWorkFileImportInfo.O == 2) {
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
      if ((DocFilePresenter.e(this.a)) && (i != 0)) {
        DocFilePresenter.c(this.a, true);
      }
      if (i == 0) {
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.P, true);
      }
      paramTeamWorkFileImportInfo.P = null;
      paramTeamWorkFileImportInfo.O = 0;
    }
  }
  
  private boolean d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.B == 0);
  }
  
  private boolean e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.B == 0);
  }
  
  private boolean f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.B == 1);
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
      DocFilePresenter.a(this.a).f();
    }
    if (e(paramTeamWorkFileImportInfo))
    {
      if (paramTeamWorkFileImportInfo.b()) {
        ReportController.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.x)) {
        QQToast.makeText(this.a.f, 1, paramTeamWorkFileImportInfo.x, 0).show();
      } else {
        QQToast.makeText(this.a.f, 1, 2131917225, 0).show();
      }
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c())) {
      TenDocLogReportHelper.a(null, "0X800ABAD");
    }
    if ((DocFilePresenter.a(this.a) != null) && (f(paramTeamWorkFileImportInfo))) {
      DocFilePresenter.a(this.a).b(3);
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    c(paramString, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.B == 0))))
    {
      b(paramString, paramTeamWorkFileImportInfo);
      return;
    }
    if (DocFilePresenter.a(this.a) != null) {
      DocFilePresenter.a(this.a).f();
    }
  }
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      DocFilePresenter.a(this.a).a(paramString1, null);
      DocFilePresenter.a(this.a).b(5);
      DocFilePresenter.a(this.a, false, paramTeamWorkFileImportInfo.a);
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.c()))
    {
      boolean bool;
      if (paramTeamWorkFileImportInfo.O == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramTeamWorkFileImportInfo.O = 0;
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
    if (d(paramTeamWorkFileImportInfo))
    {
      String str = this.a.f.getString(2131896471);
      if (paramTeamWorkFileImportInfo.b())
      {
        if (!TencentDocLocalCooperationProcessor.a().c(paramTeamWorkFileImportInfo.c))
        {
          str = this.a.f.getString(2131889435);
          DocFilePresenter.a(this.a).a(str);
        }
      }
      else {
        DocFilePresenter.a(this.a).a(str);
      }
      TenDocLogReportHelper.a(null, "0X800A21E");
    }
    if (f(paramTeamWorkFileImportInfo))
    {
      DocFilePresenter.a(this.a).b(paramTeamWorkFileImportInfo);
      DocFilePresenter.a(this.a).b(1);
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b()))
    {
      DocFilePresenter.a(this.a).b(4);
      DocFilePresenter.a(this.a, true, paramTeamWorkFileImportInfo.a);
      return;
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      DocFilePresenter.a(this.a).b(5);
      TenDocLogReportHelper.a(null, "0X800ABA4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.InnerTeamWorkFileImportObserver
 * JD-Core Version:    0.7.0.1
 */