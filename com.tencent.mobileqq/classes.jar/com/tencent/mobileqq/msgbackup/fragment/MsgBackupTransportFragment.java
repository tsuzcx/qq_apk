package com.tencent.mobileqq.msgbackup.fragment;

import amtj;
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
import avtf;
import avtq;
import avua;
import avvt;
import avvu;
import avvv;
import avvw;
import avwk;
import avwr;
import avwu;
import bfur;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
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
  
  private void a(avua paramavua)
  {
    if (paramavua == null) {
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
      str1 = paramavua.b();
      str2 = paramavua.b();
      i = paramavua.a();
      str3 = paramavua.a().a();
      paramavua = paramavua.a().a();
    } while (paramavua.size() != 2);
    int j = ((Integer)paramavua.get(0)).intValue();
    int k = ((Integer)paramavua.get(1)).intValue();
    if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: server ip = " + str3 + ", udpport = " + k + ", tcpport = " + j);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "扫码成功了，可以发起直连了！");
    }
    paramavua = avtq.a();
    if (paramavua != null)
    {
      avwk localavwk = paramavua.a();
      localavwk.d(str1);
      paramavua.a().a(i);
      paramavua.a().b(str2);
      localavwk.c(str3);
      localavwk.d(j);
      localavwk.c(k);
      localavwk.g(1);
      localavwk.f(1);
      localavwk.j(1);
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
      avwr.a("0X800A252", i);
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165866));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690450);
    }
    if (this.jdField_f_of_type_Int == 2)
    {
      avwr.a("0X800A241", 1);
      return;
    }
    avwr.a("0X800A250", 1);
  }
  
  private void p()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165867));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690453);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_c_of_type_Int = avtq.jdField_b_of_type_Int;
    avwu.a();
    if (avwk.a().e() == 1) {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
    avwu.b("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    if (this.jdField_a_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_Avtg != null) {
        getActivity().app.removeObserver(this.jdField_a_of_type_Avtg);
      }
      localavtq = avtq.a();
      localavtq.a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_Avtg);
      localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("qr_sig=");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "scan QRCode sig = " + localObject[1]);
        }
        localavtq.a().a(localObject[1]);
        localavtq.a().a(3);
        localavtq.j();
        avtq.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager.sIsTranferingStatus = " + avtq.jdField_b_of_type_Boolean);
        }
        this.jdField_e_of_type_Boolean = false;
        if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
          avwr.a("0X800A245", 2);
        }
      }
    }
    while (this.jdField_a_of_type_Int != 5)
    {
      avtq localavtq;
      Object localObject;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690465));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = avtq.a().a();
    c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_Avtg != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Avtg);
    }
    if (avwk.a().b()) {
      p();
    }
    for (;;)
    {
      avtq.a().a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_Avtg);
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
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + avtq.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (avtq.jdField_e_of_type_Boolean))
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
    this.jdField_f_of_type_Int = avwk.a().e();
    if (paramBoolean)
    {
      paramObject = (avua)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    avwu.b("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", new Object[] { Integer.valueOf(j) });
    if (j == 1006)
    {
      a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690457));
      ViewUtils.setVisible(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.jdField_f_of_type_Boolean = false;
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841322);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      avwr.a("0X800A245", i);
      return;
      if (j == 1021)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690458));
        ViewUtils.setVisible(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      }
      else if (j == 1022)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690459));
        ViewUtils.setVisible(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
        i = 1;
      }
    }
  }
  
  protected void b()
  {
    super.b();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.jdField_f_of_type_Int = avwk.a().e();
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
      setTitle(getActivity().getString(2131690449));
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690438);
      this.vg.setLeftButton(2131690456);
      if ((this.jdField_a_of_type_Int == 4) || (avtq.a().a().e() == 2)) {
        this.vg.hideLeft();
      }
      this.vg.setOnItemSelectListener(new avvt(this));
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841317);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getResources().getString(2131690465));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_f_of_type_Int == 1) {
        avwr.a("0X800A246");
      }
    }
    int i;
    String str1;
    if (this.jdField_a_of_type_Int == 5)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841317);
      }
      avtq.jdField_a_of_type_Boolean = false;
      int j = avtq.a().a();
      this.jdField_d_of_type_Int = j;
      i = j;
      if (j != avtq.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (avwk.a().e() != 1) {
        break label328;
      }
      str1 = getActivity().getResources().getString(2131690474);
    }
    for (String str2 = i + "/" + avtq.jdField_b_of_type_Int;; str2 = i + "/" + avtq.jdField_b_of_type_Int)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        String str3 = avwu.a(this.jdField_a_of_type_Long);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "/S" }));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690453);
      }
      avwr.a("0X800A24A");
      return;
      label315:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841318);
      break;
      label328:
      str1 = getActivity().getResources().getString(2131690477);
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    avwu.b("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      avwr.a("0X800A23D");
      return;
    }
    avwr.a("0X800A248");
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
      avwr.a("0X800A250", 6);
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
          if ((this.jdField_a_of_type_Boolean) && (avtq.a().a().e() != 2)) {
            this.vg.setLeftButton(2131690456);
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!avtq.jdField_e_of_type_Boolean));
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          if (this.jdField_c_of_type_AndroidWidgetImageView != null)
          {
            if (this.jdField_f_of_type_Int != 1) {
              break label326;
            }
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841317);
          }
        }
        str3 = avwu.a(this.jdField_a_of_type_Long);
        avwu.b("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str3 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != avtq.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (avwk.a().e() == 1) {
          str1 = getString(2131690474);
        }
        for (str2 = i + "/" + avtq.jdField_b_of_type_Int;; str2 = i + "/" + avtq.jdField_b_of_type_Int)
        {
          str1 = String.format(str1, new Object[] { str2, str3 + "B/s" });
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
          }
          if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690453);
          break;
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841318);
          break label142;
          str1 = getString(2131690477);
        }
        if ((this.jdField_a_of_type_Boolean) && (avtq.a().a().e() != 2)) {
          this.vg.setLeftButton(2131690456);
        }
      } while ((!this.jdField_a_of_type_Boolean) && (!avtq.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (this.jdField_f_of_type_Int != 1) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841317);
        }
      }
      str3 = avwu.a(this.jdField_a_of_type_Long);
      j = paramMessage.arg1;
      k = paramMessage.arg2;
      c(j, k);
      if (j == k) {}
      break;
    }
    for (int i = j + 1;; i = j)
    {
      if (avwk.a().e() == 1) {
        str1 = getString(2131690474);
      }
      for (str2 = i + "/" + avtq.jdField_b_of_type_Int;; str2 = i + "/" + avtq.jdField_b_of_type_Int)
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690453);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
        }
        if (avwk.a().e() != 2) {
          break label721;
        }
        MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841318);
        break label459;
        str1 = getString(2131690477);
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
      str1 = getActivity().getString(2131690465);
      i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
      avwu.b("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { str1, Integer.valueOf(this.jdField_e_of_type_Int) });
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841315);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690476));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165867));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690475));
      }
      ViewUtils.setVisible(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      ViewUtils.setVisible(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.hideLeftText();
      if ((this.jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean)) {
        avwr.a("0X800A241", 2);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772100, 2130772099);
    }
  }
  
  public void k()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    bfur.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690469), localFragmentActivity.getString(2131690466), localFragmentActivity.getString(2131690467), localFragmentActivity.getString(2131690468), new avvu(this), new avvv(this)).show();
  }
  
  public void l()
  {
    avtq.a().a().c();
    avtq.a().a().a(null);
    h();
  }
  
  public void m()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str = amtj.a(2131706034);
    bfur.a(localFragmentActivity, 0, null, amtj.a(2131706025), null, str, new avvw(this), null).show();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.jdField_a_of_type_Avtg != null)) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Avtg);
    }
    avtq localavtq = avtq.a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroy called! MsgBackupManager.sIsShouQiBtnClick = " + avtq.jdField_a_of_type_Boolean + ", topage = " + this.jdField_a_of_type_Int);
    }
    if (!avtq.jdField_a_of_type_Boolean)
    {
      localavtq.d();
      avtq.jdField_d_of_type_Boolean = false;
      if (avwk.a().e() == 2) {
        localavtq.l();
      }
      localavtq.a().a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    avtq.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    avwu.b("MsgBackup.MsgBackupTransportFragment", "onResume is called!", new Object[0]);
    avtq.a().a(getActivity());
    avtq.jdField_f_of_type_Boolean = true;
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