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
  private int aa = 60;
  private boolean ae = false;
  private int af = 0;
  private boolean ag = false;
  private Handler ah = new Handler(new MsgBackupPCAuthFragment.1(this));
  
  private void a(int paramInt)
  {
    this.af = paramInt;
    if (paramInt == 0)
    {
      this.H.setBackgroundResource(2130839460);
      return;
    }
    this.H.setBackgroundResource(2130852171);
  }
  
  private void w()
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
      MsgBackupAuthProcessor.a().a(paramMsgBackupGetQrRsp.d());
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
      w();
    }
  }
  
  protected void c()
  {
    a(getActivity().getString(2131887444));
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.setVisible(this.d, 0);
    ViewUtils.setVisible(this.e, 8);
    ViewUtils.setVisible(this.H, 0);
    ViewUtils.setVisible(this.w, 8);
    ViewUtils.setVisible(this.H, 0);
    this.x.setImageResource(2130842147);
    this.y.setText(2131887508);
    this.z.setText(2131887510);
    this.H.setText(2131887513);
    if (AppSetting.e) {
      this.H.setContentDescription(getString(2131887513));
    }
    this.p.setRightViewTextVisible(0);
    this.p.setOnItemSelectListener(new MsgBackupPCAuthFragment.2(this));
    MsgBackupManager.a().a(new MsgBackupPCAuthFragment.3(this));
    this.J.post(this.N);
    this.H.setOnClickListener(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10012)
    {
      int i = paramMessage.arg1;
      int j = 0;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.H != null) {
        if (this.ag)
        {
          a(1);
        }
        else
        {
          if (i == 0) {
            j = 2;
          }
          a(j);
        }
      }
      if (i == 0)
      {
        if ((this.y != null) && (!isDetached()))
        {
          this.y.setTextColor(getResources().getColor(2131166523));
          this.y.setText(getActivity().getString(2131887462));
        }
        if ((this.z != null) && (!isDetached())) {
          this.z.setText(getActivity().getString(2131887510));
        }
      }
      else
      {
        if ((this.y != null) && (!isDetached()))
        {
          this.y.setTextColor(getResources().getColor(2131167993));
          this.y.setText(getActivity().getString(2131887508));
        }
        if ((this.z != null) && (!isDetached())) {
          this.z.setText(getActivity().getString(2131887510));
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    MsgBackupManager.s = false;
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131438375)
    {
      int i = this.af;
      if (i == 0)
      {
        this.ag = true;
        this.ae = true;
        this.ah.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
        }
        MsgBackupManager.a().a(true);
        MsgBackupReporter.a("0X800A26A");
      }
      else if ((i == 1) && (!this.ac))
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
    this.ah.removeMessages(1);
    MsgBackupManager.a().a(null);
    if (this.N != null) {
      this.J.removeCallbacks(this.N);
    }
  }
  
  protected void t()
  {
    MsgBackupManager.a().d().m();
    MsgBackupTransportProcessor.a().k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment
 * JD-Core Version:    0.7.0.1
 */