package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
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
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AppInterface a;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private AutoVerticalScrollTextView jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  
  public TeamWorkFileImportCover(RelativeLayout paramRelativeLayout, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TeamWorkFileImportCover", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448);
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidAppActivity.findViewById(paramInt);
  }
  
  public View a(Bundle paramBundle)
  {
    this.c = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2130971588, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(3, 2131363226);
    paramBundle.topMargin = (-a());
    this.c.setLayoutParams(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363226).setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidViewView = a(2131375056);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131375058));
    this.jdField_b_of_type_AndroidViewView = a(2131375053);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131364775));
    paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    paramBundle.height = ViewUtils.b(80.0F);
    paramBundle.width = ViewUtils.b(80.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131375051));
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView = ((AutoVerticalScrollTextView)a(2131375052));
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidAppActivity.getString(2131439115);
    this.jdField_a_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidAppActivity.getString(2131439116);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setTextArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent(), this.jdField_a_of_type_AndroidAppActivity);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "show loading view start time [" + System.currentTimeMillis() / 1000L + "]");
    }
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    if (this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView != null) {
      this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    d();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.c = null;
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131439117));
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("teamwork/tim_data3.json");
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
          break label183;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c <= 20971520L) {
          break label123;
        }
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131439118));
      }
    }
    return;
    label123:
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkFileImportCover", 2, "---FileImport start, fileName： " + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b + " ---");
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    return;
    label183:
    QQToast.a(paramContext, 2131434794, 0).b(a());
    b();
  }
  
  public boolean a()
  {
    return (this.c != null) && (this.c.getVisibility() == 0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363226).setBackgroundColor(Color.parseColor("#f6f7f9"));
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "show failed view finish time [" + System.currentTimeMillis() / 1000L + "]");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363226).setBackgroundColor(Color.parseColor("#f6f7f9"));
    this.c.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "hide loading view finish time [" + System.currentTimeMillis() / 1000L + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportCover
 * JD-Core Version:    0.7.0.1
 */