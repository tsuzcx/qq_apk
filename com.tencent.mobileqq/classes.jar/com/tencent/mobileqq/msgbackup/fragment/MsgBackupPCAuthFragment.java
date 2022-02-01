package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCAuthFragment
  extends MsgBackupPcBaseFragment
{
  private Handler a;
  private int f;
  private int g;
  private boolean h;
  private boolean i = false;
  
  public MsgBackupPCAuthFragment()
  {
    this.jdField_f_of_type_Int = 60;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new MsgBackupPCAuthFragment.1(this));
  }
  
  private void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
  }
  
  private void o()
  {
    ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).gotoWebViewBrowser(BaseApplication.getContext(), "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/pcqq_version_upgrade_919.html", true, true, true, false, null, "biz_src_msg_backup");
  }
  
  protected void a(MsgBackupGetQrRsp paramMsgBackupGetQrRsp)
  {
    super.a(paramMsgBackupGetQrRsp);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processGetQrRsp data = ");
      localStringBuilder.append(paramMsgBackupGetQrRsp);
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, localStringBuilder.toString());
    }
    if (paramMsgBackupGetQrRsp != null)
    {
      MsgBackupAuthProcessor.a().a(paramMsgBackupGetQrRsp.a());
      MsgBackupAuthProcessor.a().a(paramMsgBackupGetQrRsp.a());
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processGetQrError result = ");
      localStringBuilder.append(paramInteger);
      QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, localStringBuilder.toString());
    }
    if (paramInteger.intValue() == 1028) {
      o();
    }
  }
  
  protected void c()
  {
    a(getActivity().getString(2131690533));
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.b(this.jdField_c_of_type_AndroidWidgetLinearLayout, 0);
    ViewUtils.b(this.d, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetButton, 8);
    ViewUtils.b(this.jdField_b_of_type_AndroidWidgetButton, 0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841346);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(2131690597);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(2131690599);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131690602);
    if (AppSetting.d) {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131690602));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightViewTextVisible(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupPCAuthFragment.2(this));
    MsgBackupManager.a().a(new MsgBackupPCAuthFragment.3(this));
    this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10012)
    {
      int j = paramMessage.arg1;
      int k = 0;
      if (j == 1) {
        j = 1;
      } else {
        j = 0;
      }
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        if (this.i)
        {
          a(1);
        }
        else
        {
          if (j == 0) {
            k = 2;
          }
          a(k);
        }
      }
      if (j == 0)
      {
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (!isDetached()))
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165880));
          this.jdField_g_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690551));
        }
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!isDetached())) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690599));
        }
      }
      else
      {
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (!isDetached()))
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
          this.jdField_g_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690597));
        }
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (!isDetached())) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690599));
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    MsgBackupManager.c = false;
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  protected void l()
  {
    MsgBackupManager.a().a().c();
    MsgBackupTransportProcessor.a().b();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131371036)
    {
      int j = this.jdField_g_of_type_Int;
      if (j == 0)
      {
        this.i = true;
        this.jdField_h_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
        }
        MsgBackupManager.a().a(true);
        MsgBackupReporter.a("0X800A26A");
      }
      else if ((j == 1) && (!this.jdField_f_of_type_Boolean))
      {
        MsgBackupReporter.a("0X800A26B");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MsgBackupManager.a().a(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    MsgBackupManager.a().a(null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment
 * JD-Core Version:    0.7.0.1
 */