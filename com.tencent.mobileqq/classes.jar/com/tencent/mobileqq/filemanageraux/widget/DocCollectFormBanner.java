package com.tencent.mobileqq.filemanageraux.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
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

public class DocCollectFormBanner
  implements View.OnClickListener
{
  public View a;
  TeamWorkFileImportInfo b;
  String c;
  boolean d;
  private final Activity e;
  private boolean f;
  private ObjectAnimator g;
  private boolean h;
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      if (paramBoolean)
      {
        if (!this.h)
        {
          ObjectAnimator localObjectAnimator = this.g;
          if (localObjectAnimator != null) {
            localObjectAnimator.cancel();
          }
          this.h = true;
          this.a.setVisibility(0);
          this.g = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { 0.0F });
          this.g.setDuration(180L);
          this.g.setInterpolator(new AccelerateDecelerateInterpolator());
          this.g.start();
        }
      }
      else
      {
        this.h = true;
        this.a.setVisibility(0);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.h)
      {
        Object localObject = this.g;
        if (localObject != null) {
          ((ObjectAnimator)localObject).cancel();
        }
        this.h = false;
        localObject = this.a;
        this.g = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((View)localObject).getHeight() });
        this.g.setInterpolator(new AccelerateDecelerateInterpolator());
        this.g.addListener(new DocCollectFormBanner.1(this));
        this.g.setDuration(180L);
        this.g.start();
      }
    }
    else
    {
      this.h = false;
      this.a.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this.e, BaseApplication.getContext().getString(2131888782), 0).show();
    }
    else
    {
      Object localObject;
      if (this.f)
      {
        if ((!TextUtils.isEmpty(this.c)) && (this.b != null))
        {
          if (this.d) {
            if (this.c.indexOf("?") > 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.c);
              ((StringBuilder)localObject).append("&converFrom=qqFile");
              this.c = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.c);
              ((StringBuilder)localObject).append("?converFrom=qqFile");
              this.c = ((StringBuilder)localObject).toString();
            }
          }
          if (this.d) {
            TenDocLogReportHelper.a(null, "0X800ABAB");
          } else {
            TenDocLogReportHelper.a(null, "0X800ABAC");
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", this.c);
          ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
          ((Bundle)localObject).putParcelable("key_team_work_file_import_info", this.b);
          ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.e, (Bundle)localObject, false);
        }
      }
      else if (this.b != null)
      {
        localObject = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!((ITeamWorkFileImportHandler)localObject).isFileImporting(this.b))
        {
          TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.b;
          localTeamWorkFileImportInfo.B = 0;
          ((ITeamWorkFileImportHandler)localObject).addFileImportJob(localTeamWorkFileImportInfo);
        }
        TenDocLogReportHelper.a(null, "0X800ABA6");
        TeamWorkConvertUtils.a(this.e, this.b, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner
 * JD-Core Version:    0.7.0.1
 */