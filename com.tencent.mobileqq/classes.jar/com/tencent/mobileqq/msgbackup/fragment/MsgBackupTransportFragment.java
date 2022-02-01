package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupTransportFragment
  extends MsgBackupBaseFragment
{
  private boolean e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  
  private void a(MsgBackupConfirmQrRsp paramMsgBackupConfirmQrRsp)
  {
    if (paramMsgBackupConfirmQrRsp == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp confim qr, data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    String str3;
    do
    {
      return;
      str1 = paramMsgBackupConfirmQrRsp.b();
      str2 = paramMsgBackupConfirmQrRsp.b();
      i = paramMsgBackupConfirmQrRsp.a();
      str3 = paramMsgBackupConfirmQrRsp.a().a();
      paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.a().a();
    } while (paramMsgBackupConfirmQrRsp.size() != 2);
    int j = ((Integer)paramMsgBackupConfirmQrRsp.get(0)).intValue();
    int k = ((Integer)paramMsgBackupConfirmQrRsp.get(1)).intValue();
    if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: server ip = " + str3 + ", udpport = " + k + ", tcpport = " + j);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "扫码成功了，可以发起直连了！");
    }
    paramMsgBackupConfirmQrRsp = MsgBackupManager.a();
    if (paramMsgBackupConfirmQrRsp != null)
    {
      MsgBackupTransportProcessor localMsgBackupTransportProcessor = paramMsgBackupConfirmQrRsp.a();
      localMsgBackupTransportProcessor.d(str1);
      paramMsgBackupConfirmQrRsp.a().a(i);
      paramMsgBackupConfirmQrRsp.a().b(str2);
      localMsgBackupTransportProcessor.c(str3);
      localMsgBackupTransportProcessor.d(j);
      localMsgBackupTransportProcessor.c(k);
      localMsgBackupTransportProcessor.g(1);
      localMsgBackupTransportProcessor.f(1);
      localMsgBackupTransportProcessor.j(1);
      return;
    }
    QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: MsgBackupManager is null!", new Throwable());
  }
  
  private void n()
  {
    int i = 1;
    if (this.jdField_f_of_type_Int == 1)
    {
      if (this.jdField_f_of_type_Boolean) {
        break label27;
      }
      i = 6;
    }
    for (;;)
    {
      MsgBackupReporter.a("0X800A252", i);
      return;
      label27:
      if (this.jdField_a_of_type_Boolean) {
        i = 3;
      }
    }
  }
  
  private void o()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165877));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690627);
    }
    if (this.jdField_f_of_type_Int == 2)
    {
      MsgBackupReporter.a("0X800A241", 1);
      return;
    }
    MsgBackupReporter.a("0X800A250", 1);
  }
  
  private void p()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165878));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_c_of_type_Int = MsgBackupManager.jdField_b_of_type_Int;
    MsgBackupUtil.a();
    if (MsgBackupTransportProcessor.a().e() == 1) {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    if (this.jdField_a_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
        getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      }
      localMsgBackupManager = MsgBackupManager.a();
      localMsgBackupManager.a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("qr_sig=");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "scan QRCode sig = " + localObject[1]);
        }
        localMsgBackupManager.a().a(localObject[1]);
        localMsgBackupManager.a().a(3);
        localMsgBackupManager.j();
        MsgBackupManager.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager.sIsTranferingStatus = " + MsgBackupManager.jdField_b_of_type_Boolean);
        }
        this.jdField_e_of_type_Boolean = false;
        if (NetworkUtil.a(getActivity()) != 1) {
          MsgBackupReporter.a("0X800A245", 2);
        }
      }
    }
    while (this.jdField_a_of_type_Int != 5)
    {
      MsgBackupManager localMsgBackupManager;
      Object localObject;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690642));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = MsgBackupManager.a().a();
    c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    if (MsgBackupTransportProcessor.a().b()) {
      p();
    }
    for (;;)
    {
      MsgBackupManager.a().a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      return;
      o();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2 + ", start = " + this.jdField_a_of_type_Boolean);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (paramInt1 == paramInt2) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt1;
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10003);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + MsgBackupManager.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Long = paramLong;
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10002);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((!paramBoolean) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.jdField_c_of_type_JavaLangRunnable);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10007);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    int i = 6;
    super.a(paramBoolean, paramObject);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_Int = MsgBackupTransportProcessor.a().e();
    if (paramBoolean)
    {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", new Object[] { Integer.valueOf(j) });
    if (j == 1006)
    {
      a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690634));
      ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.jdField_f_of_type_Boolean = false;
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841467);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      MsgBackupReporter.a("0X800A245", i);
      return;
      if (j == 1021)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690635));
        ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      }
      else if (j == 1022)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690636));
        ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
        i = 1;
      }
    }
  }
  
  protected void b()
  {
    super.b();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.jdField_f_of_type_Int = MsgBackupTransportProcessor.a().e();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_f_of_type_Int = 1;
    }
    localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("param_start", -1);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "toPage = " + this.jdField_a_of_type_Int + "; mBizType = " + this.jdField_b_of_type_Int);
      }
    }
    if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
    {
      setTitle(getActivity().getString(2131690626));
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690615);
      this.vg.setLeftButton(2131690633);
      if ((this.jdField_a_of_type_Int == 4) || (MsgBackupManager.a().a().e() == 2)) {
        this.vg.hideLeft();
      }
      this.vg.setOnItemSelectListener(new MsgBackupTransportFragment.1(this));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10008);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  protected void c()
  {
    super.c();
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_a_of_type_Int == 4)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        if (this.jdField_f_of_type_Int != 1) {
          break label315;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841462);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getResources().getString(2131690642));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_f_of_type_Int == 1) {
        MsgBackupReporter.a("0X800A246");
      }
    }
    int i;
    String str1;
    if (this.jdField_a_of_type_Int == 5)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841462);
      }
      MsgBackupManager.jdField_a_of_type_Boolean = false;
      int j = MsgBackupManager.a().a();
      this.jdField_d_of_type_Int = j;
      i = j;
      if (j != MsgBackupManager.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (MsgBackupTransportProcessor.a().e() != 1) {
        break label328;
      }
      str1 = getActivity().getResources().getString(2131690651);
    }
    for (String str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int;; str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        String str3 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "/S" }));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
      }
      MsgBackupReporter.a("0X800A24A");
      return;
      label315:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841463);
      break;
      label328:
      str1 = getActivity().getResources().getString(2131690654);
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {}
    do
    {
      return;
      paramInt1 = paramInt1 * 100 / paramInt2;
    } while (this.jdField_b_of_type_AndroidWidgetProgressBar == null);
    if (this.jdField_b_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_f_of_type_Int == 2)
    {
      MsgBackupReporter.a("0X800A23D");
      return;
    }
    MsgBackupReporter.a("0X800A248");
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "doOnKeyDown! ------>KEYCODE_BACK");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        k();
        return true;
      }
      if (this.jdField_f_of_type_Int == 1)
      {
        onBackEvent();
        return true;
      }
      a(getActivity());
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_f_of_type_Int == 1) {
      MsgBackupReporter.a("0X800A250", 6);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    label142:
    String str3;
    int j;
    String str1;
    String str2;
    label326:
    label459:
    int k;
    switch (paramMessage.what)
    {
    default: 
    case 10002: 
    case 10003: 
      do
      {
        do
        {
          return super.handleMessage(paramMessage);
          if ((this.jdField_a_of_type_Boolean) && (MsgBackupManager.a().a().e() != 2)) {
            this.vg.setLeftButton(2131690633);
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!MsgBackupManager.jdField_e_of_type_Boolean));
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          if (this.jdField_c_of_type_AndroidWidgetImageView != null)
          {
            if (this.jdField_f_of_type_Int != 1) {
              break label326;
            }
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841462);
          }
        }
        str3 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str3 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != MsgBackupManager.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (MsgBackupTransportProcessor.a().e() == 1) {
          str1 = getString(2131690651);
        }
        for (str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int;; str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int)
        {
          str1 = String.format(str1, new Object[] { str2, str3 + "B/s" });
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
          }
          if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
          break;
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841463);
          break label142;
          str1 = getString(2131690654);
        }
        if ((this.jdField_a_of_type_Boolean) && (MsgBackupManager.a().a().e() != 2)) {
          this.vg.setLeftButton(2131690633);
        }
      } while ((!this.jdField_a_of_type_Boolean) && (!MsgBackupManager.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (this.jdField_f_of_type_Int != 1) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841462);
        }
      }
      str3 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
      j = paramMessage.arg1;
      k = paramMessage.arg2;
      c(j, k);
      if (j == k) {}
      break;
    }
    for (int i = j + 1;; i = j)
    {
      if (MsgBackupTransportProcessor.a().e() == 1) {
        str1 = getString(2131690651);
      }
      for (str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int;; str2 = i + "/" + MsgBackupManager.jdField_b_of_type_Int)
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690630);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
        }
        if (MsgBackupTransportProcessor.a().e() != 2) {
          break label721;
        }
        MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841463);
        break label459;
        str1 = getString(2131690654);
      }
      label721:
      MsgBackupCompleteFragment.d(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      break;
      m();
      break;
      if (paramMessage.arg1 == 1)
      {
        p();
        break;
      }
      o();
      break;
      if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      str1 = getActivity().getString(2131690642);
      i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
      MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { str1, Integer.valueOf(this.jdField_e_of_type_Int) });
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      break;
    }
  }
  
  protected void i()
  {
    super.i();
    if (getActivity() != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841460);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690653));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165878));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690652));
      }
      ViewUtils.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.hideLeftText();
      if ((this.jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean)) {
        MsgBackupReporter.a("0X800A241", 2);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772115, 2130772114);
    }
  }
  
  protected void k()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690646), localFragmentActivity.getString(2131690643), localFragmentActivity.getString(2131690644), localFragmentActivity.getString(2131690645), new MsgBackupTransportFragment.2(this), new MsgBackupTransportFragment.3(this)).show();
  }
  
  protected void l()
  {
    MsgBackupManager.a().a().c();
    MsgBackupManager.a().a().a(null);
    h();
  }
  
  public void m()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str = HardCodeUtil.a(2131706927);
    DialogUtil.a(localFragmentActivity, 0, null, HardCodeUtil.a(2131706918), null, str, new MsgBackupTransportFragment.4(this), null).show();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null)) {
      getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroy called! MsgBackupManager.sIsShouQiBtnClick = " + MsgBackupManager.jdField_a_of_type_Boolean + ", topage = " + this.jdField_a_of_type_Int);
    }
    if (!MsgBackupManager.jdField_a_of_type_Boolean)
    {
      localMsgBackupManager.d();
      MsgBackupManager.jdField_d_of_type_Boolean = false;
      if (MsgBackupTransportProcessor.a().e() == 2) {
        localMsgBackupManager.l();
      }
      localMsgBackupManager.a().a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MsgBackupManager.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "onResume is called!", new Object[0]);
    MsgBackupManager.a().a(getActivity());
    MsgBackupManager.jdField_f_of_type_Boolean = true;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment
 * JD-Core Version:    0.7.0.1
 */