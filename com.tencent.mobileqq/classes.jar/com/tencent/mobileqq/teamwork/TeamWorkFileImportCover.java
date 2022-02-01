package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

public class TeamWorkFileImportCover
{
  private int jdField_a_of_type_Int = 1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AppInterface a;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AutoVerticalScrollTextView jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public TeamWorkFileImportCover(RelativeLayout paramRelativeLayout, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void c()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      if (localQQCustomDialog.isShowing()) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" dismiss exception: ");
          localStringBuilder.append(localException.toString());
          QLog.e("TeamWorkFileImportCover", 1, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168);
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidAppActivity.findViewById(paramInt);
  }
  
  public View a(Bundle paramBundle)
  {
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131562915, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(3, 2131376636);
    paramBundle.topMargin = (-a());
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, 1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636).setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidViewView = a(2131378345);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378342));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378341));
    this.jdField_b_of_type_AndroidViewView = a(2131378346);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131362696));
    paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    paramBundle.height = ViewUtils.b(60.0F);
    paramBundle.width = ViewUtils.b(60.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(paramBundle);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131378347));
    this.d = ((TextView)a(2131378350));
    this.e = ((TextView)a(2131378348));
    this.f = ((TextView)a(2131378349));
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView = ((AutoVerticalScrollTextView)a(2131378343));
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidAppActivity.getString(2131719517);
    this.jdField_a_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidAppActivity.getString(2131719518);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setTextArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent(), this.jdField_a_of_type_AndroidAppActivity);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("show loading view start time [");
      paramBundle.append(System.currentTimeMillis() / 1000L);
      paramBundle.append("]");
      QLog.i("teamConvert", 2, paramBundle.toString());
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131562911, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(14, -1);
    paramBundle.addRule(12, -1);
    paramBundle.bottomMargin = ViewUtils.b(12.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBundle);
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, null, "0X8009ED4");
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (a()) {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, null, "0X8009ED5");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    AutoVerticalScrollTextView localAutoVerticalScrollTextView = this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView;
    if (localAutoVerticalScrollTextView != null) {
      localAutoVerticalScrollTextView.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    c();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = 4;
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, null, "0X800A2F2");
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      QLog.i("teamConvert", 1, "showFailedView, but activity is null");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localObject != null)
    {
      ((DiniFlyAnimationView)localObject).cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((paramInt != 116) && (paramInt != -116))
    {
      if (paramInt == 106)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719548);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      else if ((Math.abs(paramInt) >= 100) && (Math.abs(paramInt) < 116))
      {
        if (TextUtils.isEmpty(paramString)) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719527);
        } else {
          localObject = paramString;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719527));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramInt == 116) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719520));
      } else if (paramInt == -116) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719547));
      }
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719527);
      } else {
        localObject = paramString;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636).setBackgroundColor(Color.parseColor("#f6f7f9"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tencentdoc log:show failed view finish time [");
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L);
      ((StringBuilder)localObject).append("] error code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("teamConvert", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
      if (paramIntent != null)
      {
        if (paramIntent.d())
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719536));
          this.d.setText(paramContext.getString(2131719539));
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.g == 6)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719535));
          this.d.setText(paramContext.getString(2131719538));
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d == 12)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719574));
          this.d.setText(paramContext.getString(2131719539));
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d == 13)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719559));
          this.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
          this.e.setVisibility(0);
          this.f.setVisibility(0);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b())
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719574));
          this.d.setText(paramContext.getString(2131719539));
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131719534));
          this.d.setText(paramContext.getString(2131719537));
        }
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("teamwork/tim_data_loading.json");
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("tencentdoc log:---FileImport start, fileName： ");
            paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.b);
            paramIntent.append(" ---");
            QLog.i("TeamWorkFileImportCover", 2, paramIntent.toString());
          }
          TenDocLogReportHelper.a("cover_loading_time");
          TenDocLogReportHelper.a("get_url_time");
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
          if ((paramIntent != null) && (paramIntent.d == 9)) {
            TenDocLogReportHelper.a(null, "0X800A4B4");
          }
        }
        else
        {
          QQToast.a(paramContext, 2131694424, 0).b(a());
          a(-1, null);
        }
      }
    }
  }
  
  public boolean a()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376636).setBackgroundColor(Color.parseColor("#f6f7f9"));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hide loading view finish time [");
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L);
      ((StringBuilder)localObject).append("]");
      QLog.i("teamConvert", 2, ((StringBuilder)localObject).toString());
    }
    long l = TenDocLogReportHelper.a("cover_loading_time");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((TeamWorkFileImportInfo)localObject).k;
    }
    TenDocLogReportHelper.a(null, (String)localObject, "0X8009E9C", String.valueOf(l), "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo != null)
    {
      TenDocLogReportHelper.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.k);
      return;
    }
    TenDocLogReportHelper.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportCover
 * JD-Core Version:    0.7.0.1
 */