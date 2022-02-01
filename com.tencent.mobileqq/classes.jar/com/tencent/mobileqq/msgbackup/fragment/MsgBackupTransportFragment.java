package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
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
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private boolean g = true;
  
  private void a(MsgBackupConfirmQrRsp paramMsgBackupConfirmQrRsp)
  {
    if (paramMsgBackupConfirmQrRsp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp confim qr, data is null!");
      }
      return;
    }
    String str1 = paramMsgBackupConfirmQrRsp.b();
    String str2 = paramMsgBackupConfirmQrRsp.b();
    int i = paramMsgBackupConfirmQrRsp.a();
    String str3 = paramMsgBackupConfirmQrRsp.a().a();
    paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.a().a();
    if (paramMsgBackupConfirmQrRsp.size() == 2)
    {
      int j = ((Integer)paramMsgBackupConfirmQrRsp.get(0)).intValue();
      int k = ((Integer)paramMsgBackupConfirmQrRsp.get(1)).intValue();
      if (QLog.isColorLevel())
      {
        paramMsgBackupConfirmQrRsp = new StringBuilder();
        paramMsgBackupConfirmQrRsp.append("processConfirmRsp: server ip = ");
        paramMsgBackupConfirmQrRsp.append(str3);
        paramMsgBackupConfirmQrRsp.append(", udpport = ");
        paramMsgBackupConfirmQrRsp.append(k);
        paramMsgBackupConfirmQrRsp.append(", tcpport = ");
        paramMsgBackupConfirmQrRsp.append(j);
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, paramMsgBackupConfirmQrRsp.toString());
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
  }
  
  private void o()
  {
    int j = this.jdField_f_of_type_Int;
    int i = 1;
    if (j == 1)
    {
      if (!this.g) {
        i = 6;
      } else if (this.jdField_a_of_type_Boolean) {
        i = 3;
      }
      MsgBackupReporter.a("0X800A252", i);
    }
  }
  
  private void p()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.k != null)
      {
        this.k.setVisibility(0);
        this.k.setTextColor(getResources().getColor(2131165880));
        this.k.setText(2131690555);
      }
      if (this.jdField_f_of_type_Int == 2)
      {
        MsgBackupReporter.a("0X800A241", 1);
        return;
      }
      MsgBackupReporter.a("0X800A250", 1);
    }
  }
  
  private void q()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.k != null)
      {
        this.k.setVisibility(0);
        this.k.setTextColor(getResources().getColor(2131165881));
        this.k.setText(2131690558);
      }
    }
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
        ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      }
      Object localObject1 = MsgBackupManager.a();
      ((MsgBackupManager)localObject1).a().a(this);
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      Object localObject2 = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split("qr_sig=");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("scan QRCode sig = ");
          localStringBuilder.append(localObject2[1]);
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, localStringBuilder.toString());
        }
        ((MsgBackupManager)localObject1).a().a(localObject2[1]);
        ((MsgBackupManager)localObject1).a().a(3);
        ((MsgBackupManager)localObject1).j();
        MsgBackupManager.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("MsgBackupManager.sIsTranferingStatus = ");
          ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Boolean);
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_f_of_type_Boolean = false;
        if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
          MsgBackupReporter.a("0X800A245", 2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
        }
        if (this.j != null)
        {
          this.j.setText(getActivity().getString(2131690570));
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
        }
        this.jdField_f_of_type_Boolean = true;
      }
    }
    else if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = MsgBackupManager.a().a();
      c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null) {
        ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      }
      if (MsgBackupTransportProcessor.a().b()) {
        q();
      } else {
        p();
      }
      MsgBackupManager.a().a().a(this);
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionProgress!!! finishedSessions = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", totalSession");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", start = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      if (paramInt1 == paramInt2) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_c_of_type_Int = paramInt2;
      this.jdField_d_of_type_Int = paramInt1;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10003);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("speedState!!! increment = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" , isStart = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", MsgBackupManager.isTransportStart = ");
      ((StringBuilder)localObject).append(MsgBackupManager.jdField_e_of_type_Boolean);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Long = paramLong;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10002);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    this.g = true;
    this.jdField_f_of_type_Int = MsgBackupTransportProcessor.a().e();
    if (paramBoolean)
    {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onConfirmQrResponse: ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(", isSuccess: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, localStringBuilder.toString());
      }
      a(paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      int j = ((Integer)paramObject).intValue();
      MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", new Object[] { Integer.valueOf(j) });
      int i = 6;
      if (j == 1006)
      {
        a(this.j, getString(2131690562));
        ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
        this.g = false;
        i = 3;
      }
      else if (j == 1021)
      {
        a(this.j, getString(2131690563));
        ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      }
      else if (j == 1022)
      {
        a(this.j, getString(2131690564));
        ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
        i = 1;
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841348);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      if (this.jdField_f_of_type_Int == 1) {
        MsgBackupReporter.a("0X800A245", i);
      }
    }
  }
  
  protected void c()
  {
    super.c();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.jdField_f_of_type_Int = MsgBackupTransportProcessor.a().e();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_f_of_type_Int = 1;
    }
    localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("param_start", -1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("toPage = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("; mBizType = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
    {
      a(getActivity().getString(2131690554));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftBackVisible(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightButton(2131690543);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
      if ((this.jdField_a_of_type_Int == 4) || (MsgBackupManager.a().a().e() == 2)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.hideLeft();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupTransportFragment.1(this));
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {
      return;
    }
    paramInt1 = paramInt1 * 100 / paramInt2;
    if (this.jdField_b_of_type_AndroidWidgetProgressBar != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt1);
    }
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
  
  protected void d()
  {
    super.d();
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_a_of_type_Int == 4)
    {
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        if (this.jdField_f_of_type_Int == 1) {
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841343);
        } else {
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841344);
        }
      }
      if (this.j != null)
      {
        this.j.setText(getActivity().getResources().getString(2131690570));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.k != null) {
        this.k.setVisibility(8);
      }
      if (this.jdField_f_of_type_Int == 1) {
        MsgBackupReporter.a("0X800A246");
      }
    }
    if (this.jdField_a_of_type_Int == 5)
    {
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841343);
      }
      MsgBackupManager.jdField_a_of_type_Boolean = false;
      int j = MsgBackupManager.a().a();
      this.jdField_d_of_type_Int = j;
      int i = j;
      if (j != MsgBackupManager.jdField_b_of_type_Int) {
        i = j + 1;
      }
      String str1;
      Object localObject;
      if (MsgBackupTransportProcessor.a().e() == 1)
      {
        str1 = getActivity().getResources().getString(2131690579);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(MsgBackupManager.jdField_b_of_type_Int);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        str1 = getActivity().getResources().getString(2131690582);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(MsgBackupManager.jdField_b_of_type_Int);
        localObject = ((StringBuilder)localObject).toString();
      }
      if (this.j != null)
      {
        String str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        TextView localTextView = this.j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("/S");
        localTextView.setText(String.format(str1, new Object[] { localObject, localStringBuilder.toString() }));
      }
      if (this.k != null) {
        this.k.setText(2131690558);
      }
      MsgBackupReporter.a("0X800A24A");
    }
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
        l();
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
  
  protected void g()
  {
    super.g();
    if (this.jdField_f_of_type_Int == 1) {
      MsgBackupReporter.a("0X800A250", 6);
    }
  }
  
  public void h_(boolean paramBoolean)
  {
    super.h_(paramBoolean);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10008);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    String str2;
    int j;
    String str1;
    Object localObject2;
    if (i != 10002)
    {
      if (i != 10003)
      {
        if (i != 10007)
        {
          if (i != 10008)
          {
            if ((i == 10014) && (this.j != null) && (this.j.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean))
            {
              localObject1 = getActivity().getString(2131690570);
              i = this.jdField_e_of_type_Int + 1;
              this.jdField_e_of_type_Int = i;
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - (2 - i % 3));
              MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { localObject1, Integer.valueOf(this.jdField_e_of_type_Int) });
              this.j.setText((CharSequence)localObject1);
              this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
            }
          }
          else {
            n();
          }
        }
        else if (paramMessage.arg1 == 1) {
          q();
        } else {
          p();
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Boolean) && (MsgBackupManager.a().a().e() != 2)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
        }
        if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
        {
          if (this.jdField_e_of_type_Boolean)
          {
            this.jdField_e_of_type_Boolean = false;
            if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
              if (this.jdField_f_of_type_Int == 1) {
                this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841343);
              } else {
                this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841344);
              }
            }
          }
          str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
          j = paramMessage.arg1;
          int k = paramMessage.arg2;
          c(j, k);
          if (j != k) {
            i = j + 1;
          } else {
            i = j;
          }
          if (MsgBackupTransportProcessor.a().e() == 1)
          {
            str1 = getString(2131690579);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Int);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            str1 = getString(2131690582);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Int);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          if (this.j != null)
          {
            localObject2 = this.j;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append("B/s");
            ((TextView)localObject2).setText(String.format(str1, new Object[] { localObject1, localStringBuilder.toString() }));
          }
          if (this.k != null)
          {
            this.k.setVisibility(0);
            this.k.setText(2131690558);
          }
          if (j == k)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
            }
            if (MsgBackupTransportProcessor.a().e() == 2) {
              MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
            } else {
              MsgBackupCompleteFragment.d(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
            }
          }
        }
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Boolean) && (MsgBackupManager.a().a().e() != 2)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLeftButton(2131690561);
      }
      if ((this.jdField_a_of_type_Boolean) || (MsgBackupManager.jdField_e_of_type_Boolean))
      {
        if (this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = false;
          if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
            if (this.jdField_f_of_type_Int == 1) {
              this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841343);
            } else {
              this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841344);
            }
          }
        }
        str2 = MsgBackupUtil.a(this.jdField_a_of_type_Long);
        MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str2 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != MsgBackupManager.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (MsgBackupTransportProcessor.a().e() == 1)
        {
          str1 = getString(2131690579);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Int);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          str1 = getString(2131690582);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Int);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append("B/s");
        localObject1 = String.format(str1, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
        if (this.j != null) {
          this.j.setText((CharSequence)localObject1);
        }
        if (this.k != null)
        {
          this.k.setVisibility(0);
          this.k.setText(2131690558);
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772141, 2130772140);
    }
  }
  
  protected void j()
  {
    super.j();
    if (getActivity() != null)
    {
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841341);
      }
      if (this.j != null) {
        this.j.setText(getString(2131690581));
      }
      if (this.k != null)
      {
        this.k.setTextColor(getResources().getColor(2131165881));
        this.k.setText(getString(2131690580));
      }
      ViewUtils.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      ViewUtils.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.hideLeftText();
      if ((this.jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean)) {
        MsgBackupReporter.a("0X800A241", 2);
      }
    }
  }
  
  protected void l()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690574), localFragmentActivity.getString(2131690571), localFragmentActivity.getString(2131690572), localFragmentActivity.getString(2131690573), new MsgBackupTransportFragment.2(this), new MsgBackupTransportFragment.3(this)).show();
    }
  }
  
  protected void m()
  {
    MsgBackupManager.a().a().c();
    MsgBackupManager.a().a().a(null);
    i();
  }
  
  public void n()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      String str = HardCodeUtil.a(2131706949);
      DialogUtil.a(localFragmentActivity, 0, null, HardCodeUtil.a(2131706940), null, str, new MsgBackupTransportFragment.4(this), null).show();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver != null)) {
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy called! MsgBackupManager.sIsShouQiBtnClick = ");
      localStringBuilder.append(MsgBackupManager.jdField_a_of_type_Boolean);
      localStringBuilder.append(", topage = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, localStringBuilder.toString());
    }
    if (!MsgBackupManager.jdField_a_of_type_Boolean)
    {
      localMsgBackupManager.d();
      MsgBackupManager.d = false;
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
    k();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment
 * JD-Core Version:    0.7.0.1
 */