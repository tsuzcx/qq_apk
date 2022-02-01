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
  private int aa;
  private boolean ab;
  private boolean ac = true;
  
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
    int i = paramMsgBackupConfirmQrRsp.d();
    String str3 = paramMsgBackupConfirmQrRsp.c().a();
    paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.c().b();
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
        MsgBackupTransportProcessor localMsgBackupTransportProcessor = paramMsgBackupConfirmQrRsp.d();
        localMsgBackupTransportProcessor.d(str1);
        paramMsgBackupConfirmQrRsp.e().a(i);
        paramMsgBackupConfirmQrRsp.e().b(str2);
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
  
  private void w()
  {
    int j = this.aa;
    int i = 1;
    if (j == 1)
    {
      if (!this.ac) {
        i = 6;
      } else if (this.T) {
        i = 3;
      }
      MsgBackupReporter.a("0X800A252", i);
    }
  }
  
  private void x()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.G != null)
      {
        this.G.setVisibility(0);
        this.G.setTextColor(getResources().getColor(2131166523));
        this.G.setText(2131887466);
      }
      if (this.aa == 2)
      {
        MsgBackupReporter.a("0X800A241", 1);
        return;
      }
      MsgBackupReporter.a("0X800A250", 1);
    }
  }
  
  private void y()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.G != null)
      {
        this.G.setVisibility(0);
        this.G.setTextColor(getResources().getColor(2131166524));
        this.G.setText(2131887469);
      }
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
      ((StringBuilder)localObject).append(this.T);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.T)
    {
      if (this.U) {
        return;
      }
      if (paramInt1 == paramInt2) {
        this.U = true;
      }
      this.R = paramInt2;
      this.S = paramInt1;
      localObject = this.I.obtainMessage(10003);
      ((Message)localObject).arg1 = paramInt1;
      ((Message)localObject).arg2 = paramInt2;
      this.I.sendMessage((Message)localObject);
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
      ((StringBuilder)localObject).append(this.T);
      ((StringBuilder)localObject).append(", MsgBackupManager.isTransportStart = ");
      ((StringBuilder)localObject).append(MsgBackupManager.u);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.T) || (MsgBackupManager.u))
    {
      this.Q = paramLong;
      localObject = this.I.obtainMessage(10002);
      this.I.sendMessage((Message)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    this.ac = true;
    this.aa = MsgBackupTransportProcessor.a().i();
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
        a(this.F, getString(2131887473));
        ViewUtils.setVisible(this.M, 8);
        this.ac = false;
        i = 3;
      }
      else if (j == 1021)
      {
        a(this.F, getString(2131887474));
        ViewUtils.setVisible(this.M, 8);
      }
      else if (j == 1022)
      {
        a(this.F, getString(2131887475));
        ViewUtils.setVisible(this.M, 8);
        i = 1;
      }
      if (this.E != null) {
        this.E.setImageResource(2130842149);
      }
      this.I.removeMessages(10014);
      if (this.aa == 1) {
        MsgBackupReporter.a("0X800A245", i);
      }
    }
  }
  
  protected void b()
  {
    super.b();
    this.R = MsgBackupManager.i;
    MsgBackupUtil.b();
    if (MsgBackupTransportProcessor.a().i() == 1) {
      this.J.postDelayed(this.P, 15000L);
    }
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", new Object[] { Integer.valueOf(this.a) });
    if (this.a == 4)
    {
      if (this.O != null) {
        ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.O);
      }
      Object localObject1 = MsgBackupManager.a();
      ((MsgBackupManager)localObject1).d().a(this);
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).addObserver(this.O);
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
        ((MsgBackupManager)localObject1).e().a(localObject2[1]);
        ((MsgBackupManager)localObject1).e().a(3);
        ((MsgBackupManager)localObject1).n();
        MsgBackupManager.f = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("MsgBackupManager.sIsTranferingStatus = ");
          ((StringBuilder)localObject1).append(MsgBackupManager.f);
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject1).toString());
        }
        this.ab = false;
        if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
          MsgBackupReporter.a("0X800A245", 2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
        }
        if (this.F != null)
        {
          this.F.setText(getActivity().getString(2131887481));
          this.I.removeMessages(10014);
          this.I.sendEmptyMessageDelayed(10014, 800L);
        }
        this.ab = true;
      }
    }
    else if (this.a == 5)
    {
      this.T = true;
      this.Q = MsgBackupManager.a().s();
      c(this.S, this.R);
      if (this.O != null) {
        ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.O);
      }
      if (MsgBackupTransportProcessor.a().l()) {
        y();
      } else {
        x();
      }
      MsgBackupManager.a().d().a(this);
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).addObserver(this.O);
    }
  }
  
  protected void c()
  {
    super.c();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.aa = MsgBackupTransportProcessor.a().i();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.aa = 1;
    }
    localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.a = ((Intent)localObject).getIntExtra("param_start", -1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("toPage = ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("; mBizType = ");
        ((StringBuilder)localObject).append(this.K);
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((this.a == 4) || (this.a == 5))
    {
      a(getActivity().getString(2131887465));
      this.p.setLeftBackVisible(8);
      this.p.setRightButton(2131887454);
      this.p.setLeftButton(2131887472);
      if ((this.a == 4) || (MsgBackupManager.a().d().i() == 2)) {
        this.p.hideLeft();
      }
      this.p.setOnItemSelectListener(new MsgBackupTransportFragment.1(this));
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {
      return;
    }
    paramInt1 = paramInt1 * 100 / paramInt2;
    if (this.L != null)
    {
      if (this.L.getVisibility() != 0) {
        this.L.setVisibility(0);
      }
      this.L.setProgress(paramInt1);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    this.T = paramBoolean;
    if (this.aa == 2)
    {
      MsgBackupReporter.a("0X800A23D");
      return;
    }
    MsgBackupReporter.a("0X800A248");
  }
  
  protected void d()
  {
    super.d();
    this.e.setVisibility(0);
    if (this.a == 4)
    {
      if (this.E != null) {
        if (this.aa == 1) {
          this.E.setImageResource(2130842144);
        } else {
          this.E.setImageResource(2130842145);
        }
      }
      if (this.F != null)
      {
        this.F.setText(getActivity().getResources().getString(2131887481));
        this.I.removeMessages(10014);
        this.I.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.G != null) {
        this.G.setVisibility(8);
      }
      if (this.aa == 1) {
        MsgBackupReporter.a("0X800A246");
      }
    }
    if (this.a == 5)
    {
      if (this.E != null) {
        this.E.setImageResource(2130842144);
      }
      MsgBackupManager.a = false;
      int j = MsgBackupManager.a().r();
      this.S = j;
      int i = j;
      if (j != MsgBackupManager.i) {
        i = j + 1;
      }
      String str1;
      Object localObject;
      if (MsgBackupTransportProcessor.a().i() == 1)
      {
        str1 = getActivity().getResources().getString(2131887490);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(MsgBackupManager.i);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        str1 = getActivity().getResources().getString(2131887493);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(MsgBackupManager.i);
        localObject = ((StringBuilder)localObject).toString();
      }
      if (this.F != null)
      {
        String str2 = MsgBackupUtil.a(this.Q);
        TextView localTextView = this.F;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("/S");
        localTextView.setText(String.format(str1, new Object[] { localObject, localStringBuilder.toString() }));
      }
      if (this.G != null) {
        this.G.setText(2131887469);
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
      if (this.T)
      {
        t();
        return true;
      }
      if (this.aa == 1)
      {
        onBackEvent();
        return true;
      }
      a(getActivity());
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void h()
  {
    super.h();
    if (this.aa == 1) {
      MsgBackupReporter.a("0X800A250", 6);
    }
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
            if ((i == 10014) && (this.F != null) && (this.F.getVisibility() == 0) && (!this.T))
            {
              localObject1 = getActivity().getString(2131887481);
              i = this.Z + 1;
              this.Z = i;
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - (2 - i % 3));
              MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { localObject1, Integer.valueOf(this.Z) });
              this.F.setText((CharSequence)localObject1);
              this.I.removeMessages(10014);
              this.I.sendEmptyMessageDelayed(10014, 800L);
            }
          }
          else {
            v();
          }
        }
        else if (paramMessage.arg1 == 1) {
          y();
        } else {
          x();
        }
      }
      else
      {
        if ((this.T) && (MsgBackupManager.a().d().i() != 2)) {
          this.p.setLeftButton(2131887472);
        }
        if ((this.T) || (MsgBackupManager.u))
        {
          if (this.X)
          {
            this.X = false;
            if (this.E != null) {
              if (this.aa == 1) {
                this.E.setImageResource(2130842144);
              } else {
                this.E.setImageResource(2130842145);
              }
            }
          }
          str2 = MsgBackupUtil.a(this.Q);
          j = paramMessage.arg1;
          int k = paramMessage.arg2;
          c(j, k);
          if (j != k) {
            i = j + 1;
          } else {
            i = j;
          }
          if (MsgBackupTransportProcessor.a().i() == 1)
          {
            str1 = getString(2131887490);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(MsgBackupManager.i);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            str1 = getString(2131887493);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(MsgBackupManager.i);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          if (this.F != null)
          {
            localObject2 = this.F;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append("B/s");
            ((TextView)localObject2).setText(String.format(str1, new Object[] { localObject1, localStringBuilder.toString() }));
          }
          if (this.G != null)
          {
            this.G.setVisibility(0);
            this.G.setText(2131887469);
          }
          if (j == k)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
            }
            if (MsgBackupTransportProcessor.a().i() == 2) {
              MsgBackupCompleteFragment.a(getActivity(), this.R, this.S);
            } else {
              MsgBackupCompleteFragment.d(getActivity(), this.R, this.S);
            }
          }
        }
      }
    }
    else
    {
      if ((this.T) && (MsgBackupManager.a().d().i() != 2)) {
        this.p.setLeftButton(2131887472);
      }
      if ((this.T) || (MsgBackupManager.u))
      {
        if (this.X)
        {
          this.X = false;
          if (this.E != null) {
            if (this.aa == 1) {
              this.E.setImageResource(2130842144);
            } else {
              this.E.setImageResource(2130842145);
            }
          }
        }
        str2 = MsgBackupUtil.a(this.Q);
        MsgBackupUtil.b("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.Q), str2 });
        j = this.S;
        i = j;
        if (j != MsgBackupManager.i) {
          i = j + 1;
        }
        if (MsgBackupTransportProcessor.a().i() == 1)
        {
          str1 = getString(2131887490);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(MsgBackupManager.i);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          str1 = getString(2131887493);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(MsgBackupManager.i);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append("B/s");
        localObject1 = String.format(str1, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
        if (this.F != null) {
          this.F.setText((CharSequence)localObject1);
        }
        if (this.G != null)
        {
          this.G.setVisibility(0);
          this.G.setText(2131887469);
        }
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772187, 2130772186);
    }
  }
  
  public void m_(boolean paramBoolean)
  {
    super.m_(paramBoolean);
    Message localMessage = this.I.obtainMessage(10008);
    this.I.sendMessage(localMessage);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.O != null)) {
      ((BaseQQAppInterface)getQBaseActivity().getAppRuntime()).removeObserver(this.O);
    }
    MsgBackupManager localMsgBackupManager = MsgBackupManager.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy called! MsgBackupManager.sIsShouQiBtnClick = ");
      localStringBuilder.append(MsgBackupManager.a);
      localStringBuilder.append(", topage = ");
      localStringBuilder.append(this.a);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, localStringBuilder.toString());
    }
    if (!MsgBackupManager.a)
    {
      localMsgBackupManager.g();
      MsgBackupManager.t = false;
      if (MsgBackupTransportProcessor.a().i() == 2) {
        localMsgBackupManager.p();
      }
      localMsgBackupManager.d().a(null);
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
    MsgBackupManager.v = true;
  }
  
  public void onStop()
  {
    s();
    super.onStop();
  }
  
  protected void r()
  {
    super.r();
    if (getActivity() != null)
    {
      if (this.E != null) {
        this.E.setImageResource(2130842142);
      }
      if (this.F != null) {
        this.F.setText(getString(2131887492));
      }
      if (this.G != null)
      {
        this.G.setTextColor(getResources().getColor(2131166524));
        this.G.setText(getString(2131887491));
      }
      ViewUtils.setVisible(this.L, 8);
      ViewUtils.setVisible(this.M, 8);
      this.p.hideLeftText();
      if ((this.aa == 1) && (!this.T)) {
        MsgBackupReporter.a("0X800A241", 2);
      }
    }
  }
  
  protected void t()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      DialogUtil.a(localFragmentActivity, 0, localFragmentActivity.getString(2131887485), localFragmentActivity.getString(2131887482), localFragmentActivity.getString(2131887483), localFragmentActivity.getString(2131887484), new MsgBackupTransportFragment.2(this), new MsgBackupTransportFragment.3(this)).show();
    }
  }
  
  protected void u()
  {
    MsgBackupManager.a().d().m();
    MsgBackupManager.a().d().a(null);
    q();
  }
  
  public void v()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      String str = HardCodeUtil.a(2131904792);
      DialogUtil.a(localFragmentActivity, 0, null, HardCodeUtil.a(2131904783), null, str, new MsgBackupTransportFragment.4(this), null).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment
 * JD-Core Version:    0.7.0.1
 */