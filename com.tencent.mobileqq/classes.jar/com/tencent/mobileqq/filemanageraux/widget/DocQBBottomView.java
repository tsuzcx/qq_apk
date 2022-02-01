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
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  DocQBBottomView.DocQBBottomViewCallback jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public DocQBBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560830, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560830, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, DocQBBottomView.DocQBBottomViewCallback paramDocQBBottomViewCallback)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback = paramDocQBBottomViewCallback;
  }
  
  private Drawable a()
  {
    Drawable localDrawable1 = getResources().getDrawable(2130844401);
    Drawable localDrawable2 = ThemeUtil.maskDrawableByColor(localDrawable1, 2368548);
    localDrawable2.setAlpha(127);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842919 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
    return localStateListDrawable;
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
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b())
    {
      TencentDocLocalCooperationBean.ViewOrEditInfo localViewOrEditInfo = TencentDocLocalCooperationProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
      if ((localViewOrEditInfo != null) && (!TextUtils.isEmpty(localViewOrEditInfo.jdField_a_of_type_JavaLangString))) {
        return localViewOrEditInfo.jdField_a_of_type_JavaLangString;
      }
      return HardCodeUtil.a(2131692461);
    }
    return HardCodeUtil.a(2131698213);
  }
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
      if (!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo))
      {
        paramTeamWorkFileImportInfo.g = 0;
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
      localObject = ((TencentDocLocalCooperationBean)localObject).b;
    } else {
      localObject = ((TencentDocLocalCooperationBean)localObject).d;
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373670));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373669));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373671));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b()) && (TencentDocLocalCooperationProcessor.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b)))
    {
      d();
      return;
    }
    Drawable localDrawable = a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback;
    if (localObject != null) {
      ((DocQBBottomView.DocQBBottomViewCallback)localObject).a();
    }
    if (this.c)
    {
      localObject = getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(getContext().getString(2131719628));
      QQToast.a((Context)localObject, 1, localStringBuilder.toString(), 0).a();
    }
  }
  
  private void f()
  {
    DocQBBottomView.DocQBBottomViewCallback localDocQBBottomViewCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback;
    if (localDocQBBottomViewCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getContext().getString(2131692446));
      localStringBuilder.append(a());
      localDocQBBottomViewCallback.a(localStringBuilder.toString());
    }
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
    int i = this.jdField_a_of_type_Int;
    DocQBBottomView.DocQBBottomViewCallback localDocQBBottomViewCallback;
    if (i == 4)
    {
      if (paramInt == 3)
      {
        this.jdField_a_of_type_Int = 5;
        if (this.d)
        {
          this.d = false;
          onClick(this);
          localDocQBBottomViewCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback;
          if (localDocQBBottomViewCallback != null) {
            localDocQBBottomViewCallback.a();
          }
        }
      }
    }
    else if (i == 2)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          onClick(this);
          localDocQBBottomViewCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView$DocQBBottomViewCallback;
          if (localDocQBBottomViewCallback != null) {
            localDocQBBottomViewCallback.a();
          }
        }
        else
        {
          this.d = true;
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
      this.jdField_a_of_type_Int = paramInt;
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
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
      this.b = ((Boolean)paramObject).booleanValue();
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
      QQToast.a(getContext(), getContext().getString(2131691819), 0).a();
    }
    else
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      if (localObject1 != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 4)
        {
          this.d = true;
        }
        else if ((i != 1) && (i != 2))
        {
          if (i == 3)
          {
            this.c = true;
            f();
            TeamWorkConvertUtils.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
          }
          else if (i == 5)
          {
            if (((TeamWorkFileImportInfo)localObject1).b())
            {
              if (this.jdField_a_of_type_Boolean)
              {
                a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
              }
              else
              {
                if (TencentDocLocalCooperationProcessor.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b))
                {
                  a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null)
                {
                  localObject1 = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
                  if (!((ITeamWorkFileImportHandler)localObject1).isFileImporting(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo))
                  {
                    Object localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.k);
                    ((StringBuilder)localObject2).append("-");
                    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d);
                    TenDocLogReportHelper.a(((StringBuilder)localObject2).toString());
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
                    ((TeamWorkFileImportInfo)localObject2).g = 0;
                    ((ITeamWorkFileImportHandler)localObject1).addFileImportJob((TeamWorkFileImportInfo)localObject2);
                  }
                }
                bool1 = true;
              }
              a(bool1, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.c())
            {
              if (this.jdField_a_of_type_Boolean)
              {
                if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null))
                {
                  if (this.b) {
                    if (this.jdField_a_of_type_JavaLangString.indexOf("?") > 0)
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
                      ((StringBuilder)localObject1).append("&converFrom=qqFile");
                      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
                    }
                    else
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
                      ((StringBuilder)localObject1).append("?converFrom=qqFile");
                      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
                    }
                  }
                  if (this.b) {
                    TenDocLogReportHelper.a(null, "0X800ABAB");
                  } else {
                    TenDocLogReportHelper.a(null, "0X800ABAC");
                  }
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putString("url", this.jdField_a_of_type_JavaLangString);
                  ((Bundle)localObject1).putBoolean("temp_preview_from_qq", true);
                  ((Bundle)localObject1).putParcelable("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
                  ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(getContext(), (Bundle)localObject1, false);
                }
              }
              else {
                a(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
              }
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 2;
          this.c = true;
          f();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setTeamWorkFileImportInfo(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView
 * JD-Core Version:    0.7.0.1
 */