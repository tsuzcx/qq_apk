package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class MsgBackupDateFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private ActionSheet A;
  private IphonePickerView B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private long R = 0L;
  private long S = 0L;
  private boolean T = false;
  private boolean U = false;
  private boolean V = false;
  private int W = 1;
  private Calendar X;
  private Calendar Y;
  private int Z;
  View.OnClickListener a = new MsgBackupDateFragment.1(this);
  private int aa;
  private int ab;
  private String ac;
  private String ad;
  private int ae;
  private int af = 0;
  View.OnClickListener b = new MsgBackupDateFragment.2(this);
  RadioGroup.OnCheckedChangeListener c = new MsgBackupDateFragment.3(this);
  RadioGroup.OnCheckedChangeListener d = new MsgBackupDateFragment.4(this);
  private RadioGroup e;
  private LinearLayout f;
  private RelativeLayout g;
  private TextView w;
  private RelativeLayout x;
  private TextView y;
  private RadioGroup z;
  
  private void a(int paramInt)
  {
    Calendar localCalendar;
    if (paramInt == 1)
    {
      this.ac = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.O), Integer.valueOf(this.P), Integer.valueOf(this.Q) });
      this.U = true;
      this.w.setText(this.ac);
      a(this.w, this.ac);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.O, this.P - 1, this.Q, 0, 0, 0);
      this.R = (localCalendar.getTimeInMillis() / 1000L);
      return;
    }
    if (paramInt == 2)
    {
      this.ad = String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.O), Integer.valueOf(this.P), Integer.valueOf(this.Q) });
      this.y.setText(this.ad);
      a(this.y, this.ad);
      this.V = true;
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.O, this.P - 1, this.Q, 23, 59, 59);
      this.S = (localCalendar.getTimeInMillis() / 1000L);
      if ((this.U) && (this.V)) {
        n_(true);
      }
    }
  }
  
  private void a(View paramView, String paramString)
  {
    if (AppSetting.e) {
      paramView.setContentDescription(paramString);
    }
  }
  
  private void b(int paramInt)
  {
    Calendar localCalendar1;
    Calendar localCalendar2;
    if (paramInt == 1)
    {
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.Z + this.C);
      localCalendar1.set(2, this.D);
      localCalendar1.set(5, this.E + 1);
      if (localCalendar1.before(this.Y))
      {
        this.C = 0;
        this.D = (this.aa - 1);
        this.E = (this.ab - 1);
        this.B.setSelection(0, this.C);
        this.B.setSelection(1, this.D);
        this.B.setSelection(2, this.E);
      }
      else if (localCalendar1.after(this.X))
      {
        this.C = (this.L - this.Z);
        this.D = (this.M - 1);
        this.E = (this.N - 1);
        this.B.setSelection(0, this.C);
        this.B.setSelection(1, this.D);
        this.B.setSelection(2, this.E);
      }
      if (this.V)
      {
        localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.S * 1000L);
        if (localCalendar1.after(localCalendar2))
        {
          this.C = (localCalendar2.get(1) - this.Z);
          this.D = localCalendar2.get(2);
          this.E = (localCalendar2.get(5) - 1);
          this.B.setSelection(0, this.C);
          this.B.setSelection(1, this.D);
          this.B.setSelection(2, this.E);
        }
      }
    }
    else
    {
      localCalendar1 = Calendar.getInstance();
      localCalendar1.set(1, this.Z + this.F);
      localCalendar1.set(2, this.G);
      localCalendar1.set(5, this.H + 1);
      if (localCalendar1.before(this.Y))
      {
        this.F = 0;
        this.G = (this.aa - 1);
        this.H = (this.ab - 1);
        this.B.setSelection(0, this.F);
        this.B.setSelection(1, this.G);
        this.B.setSelection(2, this.H);
      }
      else if (localCalendar1.after(this.X))
      {
        this.F = (this.L - this.Z);
        this.G = (this.M - 1);
        this.H = (this.N - 1);
        this.B.setSelection(0, this.F);
        this.B.setSelection(1, this.G);
        this.B.setSelection(2, this.H);
      }
      if (paramInt == 2)
      {
        localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.R * 1000L);
        if (localCalendar1.before(localCalendar2))
        {
          this.F = (localCalendar2.get(1) - this.Z);
          this.G = localCalendar2.get(2);
          this.H = (localCalendar2.get(5) - 1);
          this.B.setSelection(0, this.F);
          this.B.setSelection(1, this.G);
          this.B.setSelection(2, this.H);
        }
      }
    }
  }
  
  private void c()
  {
    if ((this.R != 0L) && (this.S != 0L))
    {
      ((RadioButton)this.e.findViewById(2131431607)).setChecked(true);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.R * 1000L);
      this.ac = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.w.setText(this.ac);
      a(this.w, this.ac);
      localCalendar.setTimeInMillis(this.S * 1000L);
      this.ad = String.format("%d.%d.%d", new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
      this.y.setText(this.ad);
      a(this.y, this.ad);
      n_(true);
    }
    else
    {
      ((RadioButton)this.e.findViewById(2131431606)).setChecked(true);
    }
    int i = this.W;
    if (i == 1)
    {
      this.z.check(2131431347);
      return;
    }
    if (i == 2) {
      this.z.check(2131431348);
    }
  }
  
  private void d()
  {
    this.R = 0L;
    this.S = 0L;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject != null)
      {
        this.R = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        this.S = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        this.W = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.ae = ((Intent)localObject).getIntExtra("backup_select_from", 0);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTime = ");
      ((StringBuilder)localObject).append(this.R);
      ((StringBuilder)localObject).append(", endTime = ");
      ((StringBuilder)localObject).append(this.S);
      ((StringBuilder)localObject).append(", mCurContentType = ");
      ((StringBuilder)localObject).append(this.W);
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.X = Calendar.getInstance();
    this.X.setTimeInMillis(System.currentTimeMillis());
    this.L = this.X.get(1);
    this.M = (this.X.get(2) + 1);
    this.N = this.X.get(5);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    this.O = ((Calendar)localObject).get(1);
    this.P = (((Calendar)localObject).get(2) + 1);
    this.Q = ((Calendar)localObject).get(5);
    this.Y = Calendar.getInstance();
    this.Y.setTimeInMillis(System.currentTimeMillis());
    this.Y.add(1, -30);
    this.Y.add(5, 1);
    this.Z = this.Y.get(1);
    this.aa = (this.Y.get(2) + 1);
    this.ab = this.Y.get(5);
    this.C = (this.L - this.Z);
    this.D = (this.M - 1);
    this.E = (this.N - 1);
    this.I = this.C;
    this.J = this.D;
    this.K = this.E;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, String.format("initData date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.Z), Integer.valueOf(this.aa), Integer.valueOf(this.ab), Integer.valueOf(this.L), Integer.valueOf(this.M), Integer.valueOf(this.N) }));
    }
  }
  
  private void e()
  {
    this.e = ((RadioGroup)this.t.findViewById(2131429252));
    this.e.setOnCheckedChangeListener(this.c);
    this.z = ((RadioGroup)this.t.findViewById(2131429249));
    this.z.setOnCheckedChangeListener(this.d);
    this.f = ((LinearLayout)this.t.findViewById(2131431620));
    this.g = ((RelativeLayout)this.t.findViewById(2131429250));
    this.g.setOnClickListener(this);
    this.w = ((TextView)this.t.findViewById(2131431610));
    this.x = ((RelativeLayout)this.t.findViewById(2131429251));
    this.x.setOnClickListener(this);
    this.y = ((TextView)this.t.findViewById(2131431611));
  }
  
  private void f()
  {
    a(getActivity().getString(2131887457));
    c(2131887455, this.a);
    a(2131887454, this.b);
  }
  
  private void g()
  {
    Object localObject = this.A;
    if (localObject != null) {
      ((ActionSheet)localObject).dismiss();
    }
    if (this.A == null)
    {
      this.B = ((IphonePickerView)getActivity().getLayoutInflater().inflate(2131627482, null));
      this.B.a(new MsgBackupDateFragment.DateAdapter(this, null));
      this.A = ActionSheet.createMenuSheet(getActivity());
      this.A.setCloseAutoRead(true);
      this.A.setActionContentView(this.B, null);
      localObject = (DispatchActionMoveScrollView)this.A.findViewById(2131427560);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.A.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.B.setPickListener(new MsgBackupDateFragment.5(this));
    }
    localObject = this.B;
    int i;
    if (localObject != null)
    {
      localObject = (TextView)((IphonePickerView)localObject).findViewById(2131445520);
      Button localButton = (Button)this.B.findViewById(2131447372);
      ((Button)this.B.findViewById(2131447373)).setText(HardCodeUtil.a(2131904798));
      localButton.setVisibility(0);
      localButton.setOnClickListener(new MsgBackupDateFragment.6(this));
      i = this.af;
      if (i == 1)
      {
        ((TextView)localObject).setText(HardCodeUtil.a(2131904786));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
      else if (i == 2)
      {
        ((TextView)localObject).setText(HardCodeUtil.a(2131904787));
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      }
    }
    if (!this.A.isShowing())
    {
      localObject = this.B;
      if (localObject != null)
      {
        i = this.af;
        if (i == 1)
        {
          if (this.U)
          {
            ((IphonePickerView)localObject).setSelection(0, this.C);
            this.B.setSelection(1, this.D);
            this.B.setSelection(2, this.E);
          }
          else
          {
            ((IphonePickerView)localObject).setSelection(0, this.I);
            this.B.setSelection(1, this.J);
            this.B.setSelection(2, this.K);
          }
        }
        else if (i == 2) {
          if (this.V)
          {
            ((IphonePickerView)localObject).setSelection(0, this.F);
            this.B.setSelection(1, this.G);
            this.B.setSelection(2, this.H);
          }
          else
          {
            ((IphonePickerView)localObject).setSelection(0, this.I);
            this.B.setSelection(1, this.J);
            this.B.setSelection(2, this.K);
          }
        }
      }
    }
    try
    {
      this.A.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    int i = this.af;
    if (i == 1)
    {
      this.C = this.B.b(0);
      this.D = this.B.b(1);
      this.E = this.B.b(2);
      return;
    }
    if (i == 2)
    {
      this.F = this.B.b(0);
      this.G = this.B.b(1);
      this.H = this.B.b(2);
    }
  }
  
  private void p()
  {
    if (this.af == 1)
    {
      this.O = (this.Z + this.C);
      localCalendar = Calendar.getInstance();
      localCalendar.set(this.O, this.D, this.E + 1);
      this.O = localCalendar.get(1);
      this.P = (localCalendar.get(2) + 1);
      this.Q = localCalendar.get(5);
      return;
    }
    this.O = (this.Z + this.F);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.O, this.G, this.H + 1);
    this.O = localCalendar.get(1);
    this.P = (localCalendar.get(2) + 1);
    this.Q = localCalendar.get(5);
  }
  
  protected int a()
  {
    return 2131627793;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    f();
    e();
    d();
    c();
  }
  
  public void b()
  {
    if (getActivity() != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("date fragment finish called! before is correct date time-------> startTime = ");
        ((StringBuilder)localObject).append(this.R);
        ((StringBuilder)localObject).append(", endtime = ");
        ((StringBuilder)localObject).append(this.S);
        ((StringBuilder)localObject).append(", contentType = ");
        ((StringBuilder)localObject).append(this.W);
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = this.R;
      long l2 = this.S;
      if (l1 >= l2) {
        this.R = l2;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("date fragment finish called! after is correct date time-------> startTime = ");
        ((StringBuilder)localObject).append(this.R);
        ((StringBuilder)localObject).append(", endtime = ");
        ((StringBuilder)localObject).append(this.S);
        ((StringBuilder)localObject).append(", contentType = ");
        ((StringBuilder)localObject).append(this.W);
        QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("session_start_time", this.R);
      ((Intent)localObject).putExtra("session_end_time", this.S);
      ((Intent)localObject).putExtra("session_start_time_str", this.ac);
      ((Intent)localObject).putExtra("session_end_time_str", this.ad);
      ((Intent)localObject).putExtra("session_content_type", this.W);
      getActivity().setResult(0, (Intent)localObject);
      getActivity().finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131431610) && (i != 2131429250))
    {
      if (((i == 2131429251) || (i == 2131431611)) && ((this.U) || ((this.R != 0L) && (this.ac != null))))
      {
        this.af = 2;
        g();
      }
    }
    else
    {
      this.af = 1;
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment
 * JD-Core Version:    0.7.0.1
 */