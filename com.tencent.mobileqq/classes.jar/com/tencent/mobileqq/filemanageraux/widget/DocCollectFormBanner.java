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
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null) {
      if (paramBoolean)
      {
        if (!this.c)
        {
          ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
          if (localObjectAnimator != null) {
            localObjectAnimator.cancel();
          }
          this.c = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
        }
      }
      else
      {
        this.c = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c)
      {
        Object localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
        if (localObject != null) {
          ((ObjectAnimator)localObject).cancel();
        }
        this.c = false;
        localObject = this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((View)localObject).getHeight() });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new DocCollectFormBanner.1(this));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
    else
    {
      this.c = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, BaseApplication.getContext().getString(2131691819), 0).a();
    }
    else
    {
      Object localObject;
      if (this.b)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null))
        {
          if (this.jdField_a_of_type_Boolean) {
            if (this.jdField_a_of_type_JavaLangString.indexOf("?") > 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append("&converFrom=qqFile");
              this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append("?converFrom=qqFile");
              this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            }
          }
          if (this.jdField_a_of_type_Boolean) {
            TenDocLogReportHelper.a(null, "0X800ABAB");
          } else {
            TenDocLogReportHelper.a(null, "0X800ABAC");
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", this.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
          ((Bundle)localObject).putParcelable("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
          ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, false);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null)
      {
        localObject = (ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!((ITeamWorkFileImportHandler)localObject).isFileImporting(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo))
        {
          TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
          localTeamWorkFileImportInfo.g = 0;
          ((ITeamWorkFileImportHandler)localObject).addFileImportJob(localTeamWorkFileImportInfo);
        }
        TenDocLogReportHelper.a(null, "0X800ABA6");
        TeamWorkConvertUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner
 * JD-Core Version:    0.7.0.1
 */