package com.tencent.mobileqq.filemanageraux.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean.ViewOrEditInfo;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class DocQBBottomView
  extends FrameLayout
  implements View.OnClickListener
{
  DocQBBottomView.DocQBBottomViewCallback a;
  TeamWorkFileImportInfo b;
  private int c = 0;
  private ImageView d;
  private URLImageView e;
  private TextView f;
  private boolean g;
  private String h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public DocQBBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627088, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627088, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, DocQBBottomView.DocQBBottomViewCallback paramDocQBBottomViewCallback)
  {
    this(paramContext);
    this.a = paramDocQBBottomViewCallback;
  }
  
  private Drawable a(int paramInt, String paramString)
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = null;
    Object localObject3 = ((MobileQQ)localObject1).waitAppRuntime(null);
    localObject1 = localObject2;
    if ((localObject3 instanceof AppInterface))
    {
      localObject3 = (AppInterface)localObject3;
      if (paramInt == 0) {
        return FaceDrawable.getFaceDrawable((AppInterface)localObject3, 1, paramString);
      }
      if (paramInt == 1) {
        return FaceDrawable.getFaceDrawable((AppInterface)localObject3, 4, paramString);
      }
      localObject1 = localObject2;
      if (paramInt == 3000) {
        localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject3, 101, paramString);
      }
    }
    return localObject1;
  }
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
      if (!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo))
      {
        paramTeamWorkFileImportInfo.B = 0;
        localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
      }
      TenDocLogReportHelper.a(null, "0X800ABA6");
      TeamWorkConvertUtils.a(getContext(), paramTeamWorkFileImportInfo, null);
    }
  }
  
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
  
  private void b()
  {
    setOnClickListener(this);
    this.d = ((ImageView)findViewById(2131441344));
    this.e = ((URLImageView)findViewById(2131441343));
    this.f = ((TextView)findViewById(2131441345));
    this.d.setImageDrawable(getStateListDrawable());
  }
  
  private void c()
  {
    if ((this.b.b()) && (TencentDocLocalCooperationProcessor.a().c(this.b.c)))
    {
      d();
      return;
    }
    Drawable localDrawable = a(this.b.a, this.b.b);
    if (localDrawable != null)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.e.setImageDrawable(localDrawable);
      return;
    }
    d();
  }
  
  private void d()
  {
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void e()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((DocQBBottomView.DocQBBottomViewCallback)localObject).a();
    }
    if (this.j)
    {
      localObject = getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getStatusText());
      localStringBuilder.append(getContext().getString(2131917225));
      QQToast.makeText((Context)localObject, 1, localStringBuilder.toString(), 0).show();
    }
  }
  
  private void f()
  {
    DocQBBottomView.DocQBBottomViewCallback localDocQBBottomViewCallback = this.a;
    if (localDocQBBottomViewCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getContext().getString(2131889434));
      localStringBuilder.append(getStatusText());
      localDocQBBottomViewCallback.a(localStringBuilder.toString());
    }
  }
  
  private Drawable getStateListDrawable()
  {
    Drawable localDrawable1 = getResources().getDrawable(2130845718);
    Drawable localDrawable2 = ThemeUtil.maskDrawableByColor(localDrawable1, 2368548);
    localDrawable2.setAlpha(127);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842919 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
    return localStateListDrawable;
  }
  
  private String getStatusText()
  {
    if (this.b.b())
    {
      TencentDocLocalCooperationBean.ViewOrEditInfo localViewOrEditInfo = TencentDocLocalCooperationProcessor.a().a(this.b.c);
      if ((localViewOrEditInfo != null) && (!TextUtils.isEmpty(localViewOrEditInfo.b))) {
        return localViewOrEditInfo.b;
      }
      return HardCodeUtil.a(2131889449);
    }
    return HardCodeUtil.a(2131896114);
  }
  
  public void a()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
  }
  
  public void a(int paramInt)
  {
    int m = this.c;
    DocQBBottomView.DocQBBottomViewCallback localDocQBBottomViewCallback;
    if (m == 4)
    {
      if (paramInt == 3)
      {
        this.c = 5;
        if (this.k)
        {
          this.k = false;
          onClick(this);
          localDocQBBottomViewCallback = this.a;
          if (localDocQBBottomViewCallback != null) {
            localDocQBBottomViewCallback.a();
          }
        }
      }
    }
    else if (m == 2)
    {
      this.c = paramInt;
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          onClick(this);
          localDocQBBottomViewCallback = this.a;
          if (localDocQBBottomViewCallback != null) {
            localDocQBBottomViewCallback.a();
          }
        }
        else
        {
          this.k = true;
        }
      }
      else {
        e();
      }
    }
    else
    {
      if (paramInt == 3) {
        e();
      }
      this.c = paramInt;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramTeamWorkFileImportInfo != null))
    {
      if (paramString.indexOf("?") > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("&adtag=s_qq_file_inviteedit");
        paramString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?adtag=s_qq_file_inviteedit");
        paramString = ((StringBuilder)localObject).toString();
      }
      TenDocLogReportHelper.a(null, "0X800A637");
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
      ((Bundle)localObject).putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(getContext(), (Bundle)localObject, false);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.g = true;
    this.h = paramString;
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("open")) {
        onClick(this);
      }
    }
    else if ((paramObject instanceof Boolean)) {
      this.i = ((Boolean)paramObject).booleanValue();
    }
  }
  
  public void onClick(View paramView)
  {
    ((View)paramView.getParent()).performClick();
    ReportController.b(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 2, 0, "", "", "", "");
    boolean bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(getContext(), getContext().getString(2131888782), 0).show();
    }
    else
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        int m = this.c;
        if (m == 4)
        {
          this.k = true;
        }
        else if ((m != 1) && (m != 2))
        {
          if (m == 3)
          {
            this.j = true;
            f();
            TeamWorkConvertUtils.b(this.b);
          }
          else if (m == 5)
          {
            if (((TeamWorkFileImportInfo)localObject1).b())
            {
              if (this.g)
              {
                a(this.h, this.b);
              }
              else
              {
                if (TencentDocLocalCooperationProcessor.a().c(this.b.c))
                {
                  a(this.b);
                }
                else if (this.b != null)
                {
                  localObject1 = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
                  if (!((ITeamWorkFileImportHandler)localObject1).isFileImporting(this.b))
                  {
                    Object localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(this.b.A);
                    ((StringBuilder)localObject2).append("-");
                    ((StringBuilder)localObject2).append(this.b.n);
                    TenDocLogReportHelper.f(((StringBuilder)localObject2).toString());
                    localObject2 = this.b;
                    ((TeamWorkFileImportInfo)localObject2).B = 0;
                    ((ITeamWorkFileImportHandler)localObject1).addFileImportJob((TeamWorkFileImportInfo)localObject2);
                  }
                }
                bool1 = true;
              }
              a(bool1, this.b.a);
            }
            else if (this.b.c())
            {
              if (this.g)
              {
                if ((!TextUtils.isEmpty(this.h)) && (this.b != null))
                {
                  if (this.i) {
                    if (this.h.indexOf("?") > 0)
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(this.h);
                      ((StringBuilder)localObject1).append("&converFrom=qqFile");
                      this.h = ((StringBuilder)localObject1).toString();
                    }
                    else
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(this.h);
                      ((StringBuilder)localObject1).append("?converFrom=qqFile");
                      this.h = ((StringBuilder)localObject1).toString();
                    }
                  }
                  if (this.i) {
                    TenDocLogReportHelper.a(null, "0X800ABAB");
                  } else {
                    TenDocLogReportHelper.a(null, "0X800ABAC");
                  }
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putString("url", this.h);
                  ((Bundle)localObject1).putBoolean("temp_preview_from_qq", true);
                  ((Bundle)localObject1).putParcelable("key_team_work_file_import_info", this.b);
                  ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(getContext(), (Bundle)localObject1, false);
                }
              }
              else {
                a(this.b);
              }
            }
          }
        }
        else
        {
          this.c = 2;
          this.j = true;
          f();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setTeamWorkFileImportInfo(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.b = paramTeamWorkFileImportInfo;
    this.f.setText(getStatusText());
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView
 * JD-Core Version:    0.7.0.1
 */