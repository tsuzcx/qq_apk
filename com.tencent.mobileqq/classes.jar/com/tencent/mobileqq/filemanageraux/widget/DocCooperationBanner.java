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
  public static final DownloadParams.DecodeHandler a;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TencentDocLocalCooperationBean jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocLocalCooperationBean;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout b;
  
  static
  {
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new DocCooperationBanner.1();
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
        paramBoolean = TencentDocLocalCooperationProcessor.a().a(paramTeamWorkFileImportInfo.b);
        localStringBuilder = new StringBuilder(this.jdField_a_of_type_AndroidAppActivity.getString(2131691815));
        if ((paramTeamWorkFileImportInfo.a != 1) && (paramTeamWorkFileImportInfo.a != 3000))
        {
          if (paramTeamWorkFileImportInfo.a == 0) {
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692458));
          }
        }
        else {
          localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692462));
        }
        if (paramBoolean) {
          localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692461));
        } else {
          localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131692467));
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, localStringBuilder.toString(), 1).a();
        ThreadManager.excute(new DocCooperationBanner.3(this, paramTeamWorkFileImportInfo, paramString1, paramBoolean, paramString2), 128, null, false);
      }
      TenDocLogReportHelper.a(null, "0X800A637");
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      paramString2.putBoolean("temp_preview_from_qq", true);
      paramString2.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.jdField_a_of_type_AndroidAppActivity, paramString2, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocLocalCooperationBean != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null)) {
      if (paramBoolean)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
          if (localObjectAnimator != null) {
            localObjectAnimator.cancel();
          }
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
        if (localObject != null) {
          ((ObjectAnimator)localObject).cancel();
        }
        this.jdField_a_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((View)localObject).getHeight() });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new DocCooperationBanner.2(this));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool2 = false;
    Object localObject1;
    if (!bool1)
    {
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      QQToast.a((Context)localObject1, ((Activity)localObject1).getString(2131691819), 0).a();
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null)
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
      else
      {
        bool1 = bool2;
        if (this.b.getVisibility() == 0)
        {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, false, "");
          bool1 = bool2;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      if (localObject1 != null) {
        a(bool1, ((TeamWorkFileImportInfo)localObject1).a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner
 * JD-Core Version:    0.7.0.1
 */