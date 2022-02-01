package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class MsgBackupPCConfirmFragment
  extends MsgBackupPcBaseFragment
{
  public static MsgBackupPCConfirmFragment aa;
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mBizType = ");
      localStringBuilder.append(this.K);
      QLog.d("MsgBackupMsgBackupPCConfirmFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
    }
  }
  
  protected void b()
  {
    super.b();
    MsgBackupManager.a().d().a(this);
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.setVisible(this.d, 0);
    ViewUtils.setVisible(this.e, 8);
    ViewUtils.setVisible(this.H, 8);
    ViewUtils.setVisible(this.w, 0);
    ViewUtils.setVisible(this.H, 8);
    this.y.setText(2131887461);
    this.z.setText(2131887509);
    this.x.setImageResource(2130842147);
    this.w.setText(2131887442);
    if (AppSetting.e) {
      this.w.setContentDescription(getString(2131887442));
    }
    if (this.K == 2)
    {
      this.x.setImageResource(2130842146);
      this.y.setText(getActivity().getString(2131887515));
      this.z.setVisibility(8);
      if (AppSetting.e) {
        this.w.setContentDescription(getString(2131887514));
      }
      this.w.setText(getActivity().getString(2131887514));
      MsgBackupReporter.a("0X800A280");
    }
    if (this.ac)
    {
      this.p.setLeftBackVisible(8);
      this.p.setRightButton(2131887454);
    }
    this.p.setOnItemSelectListener(new MsgBackupPCConfirmFragment.1(this));
    if (MsgBackupManager.s) {
      MsgBackupReporter.a("0X800A254");
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      MsgBackupTransportProcessor.a().m();
      paramInt = MsgBackupAuthProcessor.a().c();
      if (paramInt == 2)
      {
        onBackEvent();
        return true;
      }
      if (paramInt == 1)
      {
        if (this.ac)
        {
          onBackEvent();
          return true;
        }
        a(getActivity());
      }
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null)
    {
      MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "activity is null------------->", new Object[0]);
      return false;
    }
    if (paramMessage.what != 10001) {
      return false;
    }
    int i = MsgBackupAuthProcessor.a().c();
    if (i == 2)
    {
      onBackEvent();
      return false;
    }
    if (i == 1)
    {
      if (this.ac)
      {
        onBackEvent();
        return false;
      }
      a(getActivity());
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if ((paramActivity != null) && (this.ac)) {
      paramActivity.overridePendingTransition(2130772187, 2130772186);
    }
  }
  
  public void m_(boolean paramBoolean)
  {
    Message localMessage = this.I.obtainMessage(10001);
    this.I.sendMessage(localMessage);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = aa;
    if ((paramActivity != null) && (paramActivity.getActivity() != null)) {
      aa.getActivity().finish();
    } else {
      MsgBackupUtil.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onAttach getActivity = null,sInstance = null", new Object[0]);
    }
    aa = this;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131438364)
    {
      Intent localIntent;
      if (this.K == 1)
      {
        localIntent = new Intent();
        localIntent.putExtra("backup_select_from", 1);
        localIntent.putExtra("0x11bpush_extra", this.ab);
        QPublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupSelectionFragment.class, 1000);
        MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_BACKUP", new Object[0]);
        if (this.ac) {
          MsgBackupReporter.a("0X800A255");
        }
      }
      else
      {
        localIntent = new Intent();
        localIntent.putExtra("param_start", 2);
        localIntent.putExtra("0x11bpush_extra", this.ab);
        QPublicFragmentActivity.startForResult(getActivity(), localIntent, MsgBackupPCTransportFragment.class, 1000);
        MsgBackupUtil.a("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_RESTORE", new Object[0]);
        MsgBackupReporter.a("0X800A281");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!MsgBackupManager.a) {
      MsgBackupManager.a().d().a(null);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (aa == this) {
      aa = null;
    }
    MsgBackupUtil.b("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onDetach l", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment
 * JD-Core Version:    0.7.0.1
 */