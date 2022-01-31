package com.tencent.mobileqq.msgbackup.fragment;

import alud;
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
import augd;
import augo;
import augy;
import auir;
import auis;
import auit;
import auiu;
import aujh;
import aujo;
import aujq;
import bdgm;
import bdin;
import bdjz;
import bdoo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
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
  
  private void a(augy paramaugy)
  {
    if (paramaugy == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp confim qr, data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    Object localObject;
    do
    {
      return;
      str1 = paramaugy.b();
      str2 = paramaugy.b();
      i = paramaugy.a();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = aujq.a(paramaugy.a().a());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localObject = paramaugy.a().a();
    } while (((List)localObject).size() != 2);
    localMsgBackupEndPoint1.port = ((Integer)((List)localObject).get(0)).intValue();
    localMsgBackupEndPoint2.port = ((Integer)((List)localObject).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: server ip = " + paramaugy.a().a() + ", udpport = " + ((List)localObject).get(1) + ", tcpport = " + ((List)localObject).get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "扫码成功了，可以发起直连了！");
    }
    paramaugy = augo.a();
    if (paramaugy != null)
    {
      localObject = paramaugy.a();
      ((aujh)localObject).b(str1);
      paramaugy.a().a(i);
      paramaugy.a().b(str2);
      ((aujh)localObject).d(localMsgBackupEndPoint1);
      ((aujh)localObject).c(localMsgBackupEndPoint2);
      ((aujh)localObject).c(1);
      ((aujh)localObject).b(1);
      ((aujh)localObject).f(1);
      return;
    }
    QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager为空了", new Throwable());
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
      aujo.a("0X800A252", i);
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
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165798));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690416);
    }
    if (this.jdField_f_of_type_Int == 2)
    {
      aujo.a("0X800A241", 1);
      return;
    }
    aujo.a("0X800A250", 1);
  }
  
  private void p()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165799));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690419);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_c_of_type_Int = augo.jdField_b_of_type_Int;
    aujq.a();
    if (aujh.a().a() == 1) {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
    aujq.b("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    if (this.jdField_a_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_Auge != null) {
        getActivity().app.removeObserver(this.jdField_a_of_type_Auge);
      }
      localaugo = augo.a();
      localaugo.a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_Auge);
      localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("qr_sig=");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "scan QRCode sig = " + localObject[1]);
        }
        localaugo.a().a(localObject[1]);
        localaugo.a().a(3);
        localaugo.j();
        augo.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager.sIsTranferingStatus = " + augo.jdField_b_of_type_Boolean);
        }
        this.jdField_e_of_type_Boolean = false;
        if (bdin.a(getActivity()) != 1) {
          aujo.a("0X800A245", 2);
        }
      }
    }
    while (this.jdField_a_of_type_Int != 5)
    {
      augo localaugo;
      Object localObject;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getString(2131690433));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = augo.a().a();
    c(this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_Auge != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Auge);
    }
    if (aujh.a().b()) {
      p();
    }
    for (;;)
    {
      augo.a().a().a(this);
      getActivity().app.addObserver(this.jdField_a_of_type_Auge);
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
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.jdField_a_of_type_Boolean + ", MsgBackupManager.isTransportStart = " + augo.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (augo.jdField_e_of_type_Boolean))
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
    this.jdField_f_of_type_Int = aujh.a().a();
    if (paramBoolean)
    {
      paramObject = (augy)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    aujq.b("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", new Object[] { Integer.valueOf(j) });
    if (j == 1006)
    {
      a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690423));
      bdoo.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.jdField_f_of_type_Boolean = false;
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841026);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      aujo.a("0X800A245", i);
      return;
      if (j == 1021)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690424));
        bdoo.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      }
      else if (j == 1022)
      {
        a(this.jdField_d_of_type_AndroidWidgetTextView, getString(2131690426));
        bdoo.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
        i = 1;
      }
    }
  }
  
  protected void b()
  {
    super.b();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.jdField_f_of_type_Int = aujh.a().a();
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
      setTitle(getActivity().getString(2131690414));
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690398);
      this.vg.setLeftButton(2131690422);
      if ((this.jdField_a_of_type_Int == 4) || (augo.a().a().a() == 2)) {
        this.vg.a();
      }
      this.vg.setOnItemSelectListener(new auir(this));
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841021);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getActivity().getResources().getString(2131690433));
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10014);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_f_of_type_Int == 1) {
        aujo.a("0X800A246");
      }
    }
    int i;
    String str1;
    if (this.jdField_a_of_type_Int == 5)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841021);
      }
      augo.jdField_a_of_type_Boolean = false;
      int j = augo.a().a();
      this.jdField_d_of_type_Int = j;
      i = j;
      if (j != augo.jdField_b_of_type_Int) {
        i = j + 1;
      }
      if (aujh.a().a() != 1) {
        break label328;
      }
      str1 = getActivity().getResources().getString(2131690443);
    }
    for (String str2 = i + "/" + augo.jdField_b_of_type_Int;; str2 = i + "/" + augo.jdField_b_of_type_Int)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        String str3 = aujq.a(this.jdField_a_of_type_Long);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "/S" }));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690419);
      }
      aujo.a("0X800A24A");
      return;
      label315:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841022);
      break;
      label328:
      str1 = getActivity().getResources().getString(2131690446);
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    aujq.b("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      aujo.a("0X800A23D");
      return;
    }
    aujo.a("0X800A248");
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
      aujo.a("0X800A250", 6);
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
          if ((this.jdField_a_of_type_Boolean) && (augo.a().a().a() != 2)) {
            this.vg.setLeftButton(2131690422);
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!augo.jdField_e_of_type_Boolean));
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          if (this.jdField_c_of_type_AndroidWidgetImageView != null)
          {
            if (this.jdField_f_of_type_Int != 1) {
              break label326;
            }
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841021);
          }
        }
        str3 = aujq.a(this.jdField_a_of_type_Long);
        aujq.b("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), str3 });
        j = this.jdField_d_of_type_Int;
        i = j;
        if (j != augo.jdField_b_of_type_Int) {
          i = j + 1;
        }
        if (aujh.a().a() == 1) {
          str1 = getString(2131690443);
        }
        for (str2 = i + "/" + augo.jdField_b_of_type_Int;; str2 = i + "/" + augo.jdField_b_of_type_Int)
        {
          str1 = String.format(str1, new Object[] { str2, str3 + "B/s" });
          if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
          }
          if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690419);
          break;
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841022);
          break label142;
          str1 = getString(2131690446);
        }
        if ((this.jdField_a_of_type_Boolean) && (augo.a().a().a() != 2)) {
          this.vg.setLeftButton(2131690422);
        }
      } while ((!this.jdField_a_of_type_Boolean) && (!augo.jdField_e_of_type_Boolean));
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (this.jdField_f_of_type_Int != 1) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841021);
        }
      }
      str3 = aujq.a(this.jdField_a_of_type_Long);
      j = paramMessage.arg1;
      k = paramMessage.arg2;
      c(j, k);
      if (j == k) {}
      break;
    }
    for (int i = j + 1;; i = j)
    {
      if (aujh.a().a() == 1) {
        str1 = getString(2131690443);
      }
      for (str2 = i + "/" + augo.jdField_b_of_type_Int;; str2 = i + "/" + augo.jdField_b_of_type_Int)
      {
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(str1, new Object[] { str2, str3 + "B/s" }));
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690419);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
        }
        if (aujh.a().a() != 2) {
          break label721;
        }
        MsgBackupCompleteFragment.a(getActivity(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        break;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841022);
        break label459;
        str1 = getString(2131690446);
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
      str1 = getActivity().getString(2131690433);
      i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
      aujq.b("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { str1, Integer.valueOf(this.jdField_e_of_type_Int) });
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841019);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690445));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165799));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131690444));
      }
      bdoo.b(this.jdField_b_of_type_AndroidWidgetProgressBar, 8);
      bdoo.b(this.jdField_c_of_type_AndroidWidgetProgressBar, 8);
      this.vg.b();
      if ((this.jdField_f_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean)) {
        aujo.a("0X800A241", 2);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772091, 2130772090);
    }
  }
  
  public void k()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    bdgm.a(localFragmentActivity, 0, localFragmentActivity.getString(2131690438), localFragmentActivity.getString(2131690434), localFragmentActivity.getString(2131690436), localFragmentActivity.getString(2131690437), new auis(this), new auit(this)).show();
  }
  
  public void l()
  {
    augo.a().a().c();
    augo.a().a().a(null);
    h();
  }
  
  public void m()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str = alud.a(2131707306);
    bdgm.a(localFragmentActivity, 0, null, alud.a(2131707297), null, str, new auiu(this), null).show();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.jdField_a_of_type_Auge != null)) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Auge);
    }
    augo localaugo = augo.a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroy called! MsgBackupManager.sIsShouQiBtnClick = " + augo.jdField_a_of_type_Boolean + ", topage = " + this.jdField_a_of_type_Int);
    }
    if (!augo.jdField_a_of_type_Boolean)
    {
      localaugo.d();
      augo.jdField_d_of_type_Boolean = false;
      if (aujh.a().a() == 2) {
        localaugo.l();
      }
      localaugo.a().a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    augo.a().b(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    aujq.b("MsgBackup.MsgBackupTransportFragment", "onResume is called!", new Object[0]);
    augo.a().a(getActivity());
    augo.jdField_f_of_type_Boolean = true;
  }
  
  public void onStop()
  {
    j();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment
 * JD-Core Version:    0.7.0.1
 */