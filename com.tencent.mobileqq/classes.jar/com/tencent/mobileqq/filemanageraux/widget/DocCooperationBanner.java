package com.tencent.mobileqq.filemanageraux.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DocCooperationBanner
  implements View.OnClickListener
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TencentDocLocalCooperationBean jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocLocalCooperationBean;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout b;
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = TencentDocLocalCooperationProcessor.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((TencentDocLocalCooperationBean)localObject).b;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((TencentDocLocalCooperationBean)localObject).d;
      break;
      label80:
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 3;
      }
    }
  }
  
  public void a(String paramString1, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramString1)) && (paramTeamWorkFileImportInfo != null))
    {
      new StringBuilder(paramString1);
      if (paramString1.indexOf("?") <= 0) {
        break label204;
      }
      paramString1 = paramString1 + "&adtag=s_qq_file_inviteedit";
      if (paramBoolean)
      {
        paramBoolean = TencentDocLocalCooperationProcessor.a().a(paramTeamWorkFileImportInfo.b);
        localStringBuilder = new StringBuilder(HardCodeUtil.a(2131703414));
        if ((paramTeamWorkFileImportInfo.a != 1) && (paramTeamWorkFileImportInfo.a != 3000)) {
          break label227;
        }
        localStringBuilder.append("群成员");
        label104:
        if (!paramBoolean) {
          break label245;
        }
        localStringBuilder.append("一起编辑");
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, localStringBuilder.toString(), 1).a();
      ThreadManager.excute(new DocCooperationBanner.2(this, paramTeamWorkFileImportInfo, paramString1, paramBoolean, paramString2), 128, null, false);
      TenDocLogReportHelper.a(null, "0X800A637");
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      paramString2.putBoolean("temp_preview_from_qq", true);
      paramString2.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString2, false);
      return;
      label204:
      paramString1 = paramString1 + "?adtag=s_qq_file_inviteedit";
      break;
      label227:
      if (paramTeamWorkFileImportInfo.a != 0) {
        break label104;
      }
      localStringBuilder.append("好友");
      break label104;
      label245:
      localStringBuilder.append("一起查看");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocLocalCooperationBean != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
    {
      if (!paramBoolean) {
        break label105;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
    return;
    label105:
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { this.jdField_a_of_type_AndroidViewView.getHeight() });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new DocCooperationBanner.1(this));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131703412), 0).a();
    }
    label201:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        Object localObject = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (TeamWorkFileImportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (!((TeamWorkFileImportHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
          {
            TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
            this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
            ((TeamWorkFileImportHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {
          break label201;
        }
        a(bool, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a);
        break;
        if (this.b.getVisibility() == 0) {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, false, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner
 * JD-Core Version:    0.7.0.1
 */