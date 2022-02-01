package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupPCTransportFragment
  extends MsgBackupPcBaseFragment
{
  private void w()
  {
    this.p.setLeftBackVisible(8);
    this.p.setLeftButton(2131887472);
    this.p.setRightButton(2131887454);
    this.p.setOnItemSelectListener(new MsgBackupPCTransportFragment.1(this));
    if (this.a != 2) {
      return;
    }
    this.p.hideLeft();
  }
  
  private void x()
  {
    this.ad = true;
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
      if (this.K == 1)
      {
        MsgBackupReporter.a("0X800A264", 1);
        return;
      }
      MsgBackupReporter.a("0X800A287", 1);
    }
  }
  
  private void y()
  {
    this.ad = false;
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
      ((StringBuilder)localObject).append("sessionProgress finishedSessions = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", totalSession = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", isStart = ");
      ((StringBuilder)localObject).append(this.T);
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject).toString());
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
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject).toString());
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mBizType = ");
      ((StringBuilder)localObject1).append(this.K);
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      localObject1 = (MsgBackupConfirmQrRsp)paramObject;
      Object localObject2;
      int i;
      Object localObject3;
      int j;
      int k;
      if (this.K == 1)
      {
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup data is null!");
          }
          return;
        }
        localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
        paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
        i = ((MsgBackupConfirmQrRsp)localObject1).d();
        localObject3 = ((MsgBackupConfirmQrRsp)localObject1).c().b();
        if (((List)localObject3).size() == 2)
        {
          localObject1 = ((MsgBackupConfirmQrRsp)localObject1).c().a();
          j = ((Integer)((List)localObject3).get(0)).intValue();
          k = ((Integer)((List)localObject3).get(1)).intValue();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("processConfirmQRRsp: backup client ip = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", udpport = ");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", tcpport = ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = MsgBackupManager.a().d();
          ((MsgBackupTransportProcessor)localObject3).d((String)localObject2);
          localObject2 = MsgBackupAuthProcessor.a();
          ((MsgBackupAuthProcessor)localObject2).b(paramObject);
          ((MsgBackupAuthProcessor)localObject2).a(i);
          ((MsgBackupTransportProcessor)localObject3).b((String)localObject1);
          ((MsgBackupTransportProcessor)localObject3).b(j);
          ((MsgBackupTransportProcessor)localObject3).a(k);
          ((MsgBackupTransportProcessor)localObject3).g(2);
          ((MsgBackupTransportProcessor)localObject3).f(2);
        }
      }
      else if (this.K == 2)
      {
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: restore data is null!");
          }
          return;
        }
        localObject2 = ((MsgBackupConfirmQrRsp)localObject1).b();
        paramObject = ((MsgBackupConfirmQrRsp)localObject1).a();
        i = ((MsgBackupConfirmQrRsp)localObject1).d();
        localObject3 = ((MsgBackupConfirmQrRsp)localObject1).c().b();
        if (((List)localObject3).size() == 2)
        {
          localObject1 = ((MsgBackupConfirmQrRsp)localObject1).c().a();
          j = ((Integer)((List)localObject3).get(0)).intValue();
          k = ((Integer)((List)localObject3).get(1)).intValue();
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("processConfirmRsp: restore server ip = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", udpport = ");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", tcpport = ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = MsgBackupManager.a().d();
          ((MsgBackupTransportProcessor)localObject3).d((String)localObject2);
          localObject2 = MsgBackupAuthProcessor.a();
          ((MsgBackupAuthProcessor)localObject2).b(paramObject);
          ((MsgBackupAuthProcessor)localObject2).a(i);
          ((MsgBackupTransportProcessor)localObject3).c((String)localObject1);
          ((MsgBackupTransportProcessor)localObject3).d(j);
          ((MsgBackupTransportProcessor)localObject3).c(k);
          ((MsgBackupTransportProcessor)localObject3).g(1);
          ((MsgBackupTransportProcessor)localObject3).f(1);
        }
      }
    }
  }
  
  protected void b()
  {
    super.b();
    MsgBackupUtil.b();
    this.R = MsgBackupManager.i;
    int i = MsgBackupTransportProcessor.a().i();
    boolean bool2 = true;
    boolean bool1 = true;
    if (i == 1) {
      this.J.postDelayed(this.P, 15000L);
    }
    i = this.a;
    Object localObject1;
    Object localObject2;
    if (i != 2)
    {
      if (i != 5) {
        return;
      }
      this.T = true;
      this.Q = MsgBackupManager.a().s();
      MsgBackupManager.a = false;
      int j = MsgBackupManager.a().r();
      this.S = j;
      c(this.S, this.R);
      i = j;
      if (j != MsgBackupManager.i) {
        i = j + 1;
      }
      if (MsgBackupTransportProcessor.a().i() == 1) {
        localObject1 = getActivity().getResources().getString(2131887518);
      } else {
        localObject1 = getActivity().getResources().getString(2131887517);
      }
      if (this.F != null)
      {
        localObject2 = MsgBackupUtil.a(this.Q);
        TextView localTextView = this.F;
        j = this.R;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("B/s");
        localTextView.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localStringBuilder.toString() }));
      }
      if (MsgBackupTransportProcessor.a().l()) {
        y();
      } else {
        x();
      }
      MsgBackupManager.a().d().a(this);
      if (MsgBackupTransportProcessor.a().i() == 2)
      {
        if (this.ac) {
          MsgBackupReporter.a("0X800A261");
        }
      }
      else {
        MsgBackupReporter.a("0X800A285");
      }
    }
    else
    {
      if (MsgBackupManager.a().e().c() == 1)
      {
        MsgBackupManager.a().d().a(this);
        if (this.ac) {
          MsgBackupManager.a().a(this.K, this.ab);
        }
        MsgBackupManager.i = MsgBackupManager.a().h.size();
        MsgBackupReporter.a();
        MsgBackupReporter.a.g = MsgBackupManager.i;
        localObject1 = new MsgBackupRequest();
        localObject2 = new HashSet(MsgBackupManager.a().h.size());
        ((HashSet)localObject2).addAll(MsgBackupManager.a().h);
        ((MsgBackupRequest)localObject1).a = ((HashSet)localObject2);
        ((MsgBackupRequest)localObject1).b = 0;
        if (getActivity() != null)
        {
          localObject2 = getActivity().getIntent();
          if (localObject2 != null)
          {
            l1 = ((Intent)localObject2).getLongExtra("session_start_time", 0L);
            l2 = ((Intent)localObject2).getLongExtra("session_end_time", 0L);
            i = ((Intent)localObject2).getIntExtra("session_content_type", 1);
            break label498;
          }
        }
        long l1 = 0L;
        long l2 = l1;
        i = 1;
        label498:
        MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
        if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
        {
          ((MsgBackupRequest)localObject1).c = l1;
          ((MsgBackupRequest)localObject1).d = l2;
          if (i != 2) {
            bool1 = false;
          }
          ((MsgBackupRequest)localObject1).e = bool1;
        }
        else
        {
          ((MsgBackupRequest)localObject1).c = 0L;
          ((MsgBackupRequest)localObject1).d = 9223372036854775807L;
          if (i == 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((MsgBackupRequest)localObject1).e = bool1;
        }
        MsgBackupManager.a().a((MsgBackupRequest)localObject1);
        return;
      }
      MsgBackupManager.a().d().a(this);
      MsgBackupManager.a().d().j(4);
      if (this.ac) {
        MsgBackupManager.a().a(this.K, this.ab);
      }
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    super.c(this.T);
    this.T = paramBoolean;
    if (this.K == 1)
    {
      if (this.ac) {
        MsgBackupReporter.a("0X800A25F");
      }
    }
    else if (this.K == 2) {
      MsgBackupReporter.a("0X800A283");
    }
  }
  
  protected void d()
  {
    super.d();
    ViewUtils.setVisible(this.b, 8);
    ViewUtils.setVisible(this.c, 8);
    ViewUtils.setVisible(this.d, 8);
    ViewUtils.setVisible(this.e, 0);
    if (this.K == 1) {
      this.E.setImageResource(2130842147);
    } else if (this.K == 2) {
      this.E.setImageResource(2130842146);
    }
    int i = this.a;
    if (i != 2)
    {
      if (i != 5) {
        return;
      }
      w();
      this.W = MsgBackupTransportProcessor.a().l();
      if (this.W)
      {
        y();
        return;
      }
      x();
      return;
    }
    this.F.setText(2131887516);
    this.I.removeMessages(10014);
    this.I.sendEmptyMessageDelayed(10014, 800L);
    this.G.setText(2131887469);
    w();
  }
  
  public void de_()
  {
    super.de_();
    if ((this.ac) && (this.K == 1)) {
      if (this.ad) {
        MsgBackupReporter.a("0X800A266", 3);
      } else if (!this.T) {
        MsgBackupReporter.a("0X800A266", 1);
      } else {
        MsgBackupReporter.a("0X800A266", 2);
      }
    }
    if (this.K == 2)
    {
      if (!this.ad)
      {
        MsgBackupReporter.a("0X800A288", 1);
        return;
      }
      MsgBackupReporter.a("0X800A288", 2);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      de_();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    String str1;
    String str2;
    int j;
    TextView localTextView;
    StringBuilder localStringBuilder;
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
              str1 = getActivity().getString(2131887516);
              i = this.Z + 1;
              this.Z = i;
              str1 = str1.substring(0, str1.length() - (2 - i % 3));
              this.F.setText(str1);
              this.I.removeMessages(10014);
              this.I.sendEmptyMessageDelayed(10014, 800L);
            }
          }
          else {
            u();
          }
        }
        else if (paramMessage.arg1 == 1) {
          y();
        } else {
          x();
        }
      }
      else if ((this.T) || (MsgBackupManager.u))
      {
        if (this.X)
        {
          this.X = false;
          if (this.K == 1) {
            this.E.setImageResource(2130842147);
          } else if (this.K == 2) {
            this.E.setImageResource(2130842146);
          }
        }
        this.p.setLeftButton(2131887472);
        str2 = MsgBackupUtil.a(this.Q);
        j = paramMessage.arg1;
        int k = paramMessage.arg2;
        c(j, k);
        if (j != k) {
          i = j + 1;
        } else {
          i = j;
        }
        if (MsgBackupTransportProcessor.a().i() == 1) {
          str1 = getActivity().getResources().getString(2131887518);
        } else {
          str1 = getActivity().getResources().getString(2131887517);
        }
        if (this.F != null)
        {
          localTextView = this.F;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append("B/s");
          localTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), localStringBuilder.toString() }));
        }
        if (this.G != null) {
          this.G.setText(2131887469);
        }
        if (j == k)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
          }
          MsgBackupManager.a().d().a(null);
          if (MsgBackupTransportProcessor.a().i() == 1) {
            MsgBackupCompleteFragment.j(getActivity(), this.R, this.S);
          } else {
            MsgBackupCompleteFragment.a(getActivity(), this.R, this.S, this.ac);
          }
        }
      }
    }
    else if ((this.T) || (MsgBackupManager.u))
    {
      if (this.X)
      {
        this.X = false;
        if (this.K == 1) {
          this.E.setImageResource(2130842147);
        } else if (this.K == 2) {
          this.E.setImageResource(2130842146);
        }
      }
      this.p.setLeftButton(2131887472);
      str2 = MsgBackupUtil.a(this.Q);
      MsgBackupUtil.b("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.Q), str2 });
      j = this.S;
      i = j;
      if (j != MsgBackupManager.i) {
        i = j + 1;
      }
      if (MsgBackupTransportProcessor.a().i() == 1) {
        str1 = getActivity().getResources().getString(2131887518);
      } else {
        str1 = getActivity().getResources().getString(2131887517);
      }
      if (this.F != null)
      {
        localTextView = this.F;
        j = MsgBackupManager.i;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append("B/s");
        localTextView.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localStringBuilder.toString() }));
      }
      if (this.G != null) {
        this.G.setText(2131887469);
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      if ((this.K != 2) && (!this.ac))
      {
        paramActivity.overridePendingTransition(2130772187, 2130772186);
        return;
      }
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void m_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "pc退出了！------------------>exit called! ");
    }
    Message localMessage = this.I.obtainMessage(10008);
    this.I.sendMessage(localMessage);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!MsgBackupManager.a)
    {
      MsgBackupManager.a().g();
      MsgBackupManager.a().d().a(null);
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
        if (this.K == 2) {
          this.G.setText(getString(2131887470));
        } else {
          this.G.setText(getString(2131887443));
        }
      }
      ViewUtils.setVisible(this.L, 8);
      ViewUtils.setVisible(this.M, 8);
      this.p.hideLeftText();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment
 * JD-Core Version:    0.7.0.1
 */