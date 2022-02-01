package com.tencent.mobileqq.filemanageraux.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class DocCooperationBanner
  implements View.OnClickListener
{
  public static final DownloadParams.DecodeHandler a = new DocCooperationBanner.1();
  public View b;
  TencentDocLocalCooperationBean c;
  TeamWorkFileImportInfo d;
  String e;
  private final Activity f;
  private RelativeLayout g;
  private RelativeLayout h;
  private ObjectAnimator i;
  private boolean j;
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = TencentDocLocalCooperationProcessor.a();
    if (paramBoolean) {
      localObject = ((TencentDocLocalCooperationBean)localObject).d;
    } else {
      localObject = ((TencentDocLocalCooperationBean)localObject).f;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((paramInt != 1) && (paramInt != 3000))
      {
        if (paramInt == 0) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, paramInt, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramTeamWorkFileImportInfo != null))
    {
      new StringBuilder(paramString1);
      StringBuilder localStringBuilder;
      if (paramString1.indexOf("?") > 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("&adtag=s_qq_file_inviteedit");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("?adtag=s_qq_file_inviteedit");
        paramString1 = localStringBuilder.toString();
      }
      if (paramBoolean)
      {
        paramBoolean = TencentDocLocalCooperationProcessor.a().b(paramTeamWorkFileImportInfo.c);
        localStringBuilder = new StringBuilder(this.f.getString(2131888778));
        if ((paramTeamWorkFileImportInfo.a != 1) && (paramTeamWorkFileImportInfo.a != 3000))
        {
          if (paramTeamWorkFileImportInfo.a == 0) {
            localStringBuilder.append(this.f.getString(2131889446));
          }
        }
        else {
          localStringBuilder.append(this.f.getString(2131889450));
        }
        if (paramBoolean) {
          localStringBuilder.append(this.f.getString(2131889449));
        } else {
          localStringBuilder.append(this.f.getString(2131889455));
        }
        QQToast.makeText(this.f, 2, localStringBuilder.toString(), 1).show();
        ThreadManager.excute(new DocCooperationBanner.3(this, paramTeamWorkFileImportInfo, paramString1, paramBoolean, paramString2), 128, null, false);
      }
      TenDocLogReportHelper.a(null, "0X800A637");
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      paramString2.putBoolean("temp_preview_from_qq", true);
      paramString2.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.f, paramString2, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.c != null) && (this.d != null)) {
      if (paramBoolean)
      {
        if (!this.j)
        {
          ObjectAnimator localObjectAnimator = this.i;
          if (localObjectAnimator != null) {
            localObjectAnimator.cancel();
          }
          this.j = true;
          this.b.setVisibility(0);
          this.i = ObjectAnimator.ofFloat(this.b, "translationY", new float[] { 0.0F });
          this.i.setDuration(180L);
          this.i.setInterpolator(new AccelerateDecelerateInterpolator());
          this.i.start();
        }
      }
      else
      {
        this.j = true;
        this.b.setVisibility(0);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.j)
      {
        Object localObject = this.i;
        if (localObject != null) {
          ((ObjectAnimator)localObject).cancel();
        }
        this.j = false;
        localObject = this.b;
        this.i = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((View)localObject).getHeight() });
        this.i.setInterpolator(new AccelerateDecelerateInterpolator());
        this.i.addListener(new DocCooperationBanner.2(this));
        this.i.setDuration(180L);
        this.i.start();
      }
    }
    else
    {
      this.j = false;
      this.b.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool2 = false;
    Object localObject1;
    if (!bool1)
    {
      localObject1 = this.f;
      QQToast.makeText((Context)localObject1, ((Activity)localObject1).getString(2131888782), 0).show();
    }
    else
    {
      if (this.g.getVisibility() == 0)
      {
        if (this.d != null)
        {
          localObject1 = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
          if (!((ITeamWorkFileImportHandler)localObject1).isFileImporting(this.d))
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.d.A);
            ((StringBuilder)localObject2).append("-");
            ((StringBuilder)localObject2).append(this.d.n);
            TenDocLogReportHelper.f(((StringBuilder)localObject2).toString());
            localObject2 = this.d;
            ((TeamWorkFileImportInfo)localObject2).B = 0;
            ((ITeamWorkFileImportHandler)localObject1).addFileImportJob((TeamWorkFileImportInfo)localObject2);
          }
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (this.h.getVisibility() == 0)
        {
          a(this.e, this.d, false, "");
          bool1 = bool2;
        }
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        a(bool1, ((TeamWorkFileImportInfo)localObject1).a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner
 * JD-Core Version:    0.7.0.1
 */