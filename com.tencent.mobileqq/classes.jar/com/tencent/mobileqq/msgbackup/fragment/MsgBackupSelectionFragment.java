package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupSelectionFragment
  extends QIphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private LinearLayoutManager A;
  private long B = 0L;
  private long C = 0L;
  private int D = -1000;
  private String E;
  private String F;
  private String G;
  private MqqHandler H;
  private final int I = 10000;
  private View J;
  private View K;
  private boolean L = false;
  private MsgBackupListAdapter.OnItemCheckedChangeListener M = new MsgBackupSelectionFragment.3(this);
  protected List<RecentBaseData> a = new ArrayList();
  private RecyclerView b;
  private MsgBackupListAdapter c;
  private TextView d;
  private RelativeLayout e;
  private TextView f;
  private TextView g;
  private Button w;
  private MsgBackupManager x;
  private boolean y = false;
  private int z;
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131887468, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.B != 0L) && (this.C != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131887458, new Object[] { this.E, this.F }));
    }
    if (this.D == 2)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(getString(2131887448));
    }
    if (localStringBuilder.length() > 0)
    {
      this.d.setVisibility(0);
      this.d.setText(localStringBuilder.toString());
    }
    else
    {
      this.d.setVisibility(8);
    }
    if (paramInt > 0)
    {
      this.w.setEnabled(true);
      if (paramInt == this.a.size())
      {
        this.y = true;
        b(this.f, 2131887494);
        return;
      }
      this.y = false;
      b(this.f, 2131887476);
      return;
    }
    this.w.setEnabled(false);
    this.y = false;
    b(this.f, 2131887476);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131887468, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.B != 0L) && (this.C != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131887458, new Object[] { this.E, this.F }));
    }
    if (this.D == 2)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(getString(2131887448));
    }
    if (localStringBuilder.length() > 0)
    {
      this.d.setVisibility(0);
      this.d.setText(localStringBuilder.toString());
    }
    else
    {
      this.d.setVisibility(8);
    }
    if (paramBoolean)
    {
      b(this.f, 2131887494);
      this.w.setEnabled(true);
      return;
    }
    b(this.f, 2131887476);
    this.w.setEnabled(false);
  }
  
  private void b()
  {
    Object localObject = getArguments();
    this.z = ((Bundle)localObject).getInt("backup_select_from", 0);
    this.G = ((Bundle)localObject).getString("0x11bpush_extra");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg, mFrom = ");
      ((StringBuilder)localObject).append(this.z);
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(paramInt);
      if (AppSetting.e) {
        paramTextView.setContentDescription(getString(paramInt));
      }
    }
  }
  
  private void c()
  {
    this.x = MsgBackupManager.a();
  }
  
  private void d()
  {
    MsgBackupManager.a().h.clear();
    MsgBackupManager.a().a(new MsgBackupSelectionFragment.1(this));
    MsgBackupManager.a().t();
  }
  
  private void e()
  {
    this.e = ((RelativeLayout)this.t.findViewById(2131429617));
    this.f = ((TextView)this.t.findViewById(2131445510));
    b(this.w, 2131887476);
    this.g = ((TextView)this.t.findViewById(2131431619));
    b(this.g, 2131887477);
    this.w = ((Button)this.t.findViewById(2131445535));
    b(this.w, 2131887467);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.w.setEnabled(false);
    this.d = ((TextView)this.t.findViewById(2131438370));
    this.d.setVisibility(8);
    this.b = ((RecyclerView)this.t.findViewById(2131438366));
    this.A = new LinearLayoutManager(getActivity());
    this.A.setOrientation(1);
    this.b.setLayoutManager(this.A);
    this.c = new MsgBackupListAdapter(getActivity(), (BaseQQAppInterface)getQBaseActivity().getAppRuntime(), this.b);
    this.b.setAdapter(this.c);
    this.c.a(this.M);
    this.K = this.t.findViewById(2131432529);
    this.J = this.t.findViewById(2131437612);
    this.J.setVisibility(0);
    this.p.setOnItemSelectListener(new MsgBackupSelectionFragment.2(this));
  }
  
  private void f()
  {
    ViewUtils.setVisible(this.b, 0);
    ViewUtils.setVisible(this.K, 8);
    ViewUtils.setVisible(this.J, 8);
  }
  
  private void g()
  {
    if (this.y)
    {
      p();
      if (this.z == 0)
      {
        MsgBackupReporter.a("0X800A233", 2);
        return;
      }
      if (MsgBackupManager.s) {
        MsgBackupReporter.a("0X800A258", 2);
      }
    }
    else
    {
      h();
      if (this.z == 0)
      {
        MsgBackupReporter.a("0X800A233", 1);
        return;
      }
      if (MsgBackupManager.s) {
        MsgBackupReporter.a("0X800A258", 1);
      }
    }
  }
  
  private void h()
  {
    this.y ^= true;
    if (this.a.size() > 0) {
      a(this.a.size(), this.y);
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
      MsgBackupManager.a().h.add(localRecentBaseData);
    }
    this.c.b();
  }
  
  private void p()
  {
    this.y ^= true;
    a(0, this.y);
    this.c.c();
    MsgBackupManager.a().f();
  }
  
  private void q()
  {
    Object localObject = MsgBackupManager.a().h.iterator();
    int i = 0;
    int m;
    int k;
    int j;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      m = 3;
      k = 2;
      j = i;
      if (!bool) {
        break;
      }
      if (UinTypeUtil.b(((RecentBaseData)((Iterator)localObject).next()).getRecentUserType()))
      {
        if (i == 2)
        {
          j = 3;
          break;
        }
        i = 1;
      }
      else if (i == 1)
      {
        i = 3;
      }
      else
      {
        i = 2;
      }
    }
    i = m;
    if (this.B != 0L)
    {
      i = m;
      if (this.C != 0L) {
        i = 1;
      }
    }
    if (this.D == 2) {
      if (i == 1) {
        i = k;
      } else {
        i = 4;
      }
    }
    if (this.z == 0) {
      localObject = "0X800A238";
    } else if (MsgBackupManager.s) {
      localObject = "0X800A25D";
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      MsgBackupReporter.a((String)localObject, j, i);
    }
  }
  
  protected int a()
  {
    return 2131627794;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.H = new MqqHandler(Looper.getMainLooper(), this);
    b();
    c();
    e();
    d();
    MsgBackupManager.a().f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return false;
    }
    f();
    paramMessage = this.a;
    if ((paramMessage != null) && (paramMessage.size() > 0))
    {
      this.c.a(this.a);
      this.c.a();
      this.c.notifyDataSetChanged();
      return false;
    }
    this.b.setVisibility(4);
    this.g.setEnabled(false);
    this.f.setEnabled(false);
    this.K.setVisibility(0);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected View n()
  {
    View localView = super.n();
    a(getActivity().getString(2131887478));
    return localView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      if (paramIntent != null)
      {
        this.B = paramIntent.getLongExtra("session_start_time", 0L);
        this.C = paramIntent.getLongExtra("session_end_time", 0L);
        this.E = paramIntent.getStringExtra("session_start_time_str");
        this.F = paramIntent.getStringExtra("session_end_time_str");
        this.D = paramIntent.getIntExtra("session_content_type", 1);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("onActivityResult startTime = ");
          paramIntent.append(this.B);
          paramIntent.append(", endTime = ");
          paramIntent.append(this.C);
          paramIntent.append(", mCurContentType = ");
          paramIntent.append(this.D);
          paramIntent.append(", startTimeShow = ");
          paramIntent.append(this.E);
          paramIntent.append(", endTimeShow = ");
          paramIntent.append(this.F);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, paramIntent.toString());
        }
        a(this.x.h.size());
      }
    }
    else if ((1000 == paramInt1) && (paramInt2 == 1001))
    {
      if (getActivity() != null) {
        getActivity().setResult(1001);
      }
      onBackEvent();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131445510)
    {
      g();
    }
    else
    {
      Object localObject;
      if (i == 2131431619)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("date_select startTime = ");
          ((StringBuilder)localObject).append(this.B);
          ((StringBuilder)localObject).append(", endTime = ");
          ((StringBuilder)localObject).append(this.C);
          ((StringBuilder)localObject).append(", mCurContentType = ");
          ((StringBuilder)localObject).append(this.D);
          ((StringBuilder)localObject).append(", startTimeShow = ");
          ((StringBuilder)localObject).append(this.E);
          ((StringBuilder)localObject).append(", endTimeShow = ");
          ((StringBuilder)localObject).append(this.F);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_start_time", this.B);
        ((Intent)localObject).putExtra("session_end_time", this.C);
        ((Intent)localObject).putExtra("session_start_time_str", this.E);
        ((Intent)localObject).putExtra("session_end_time_str", this.F);
        ((Intent)localObject).putExtra("session_content_type", this.D);
        ((Intent)localObject).putExtra("backup_select_from", this.z);
        QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupDateFragment.class, 1000);
      }
      else if (i == 2131445535)
      {
        MsgBackupManager.i = MsgBackupManager.a().h.size();
        MsgBackupReporter.a();
        MsgBackupReporter.a.g = MsgBackupManager.i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("select session detail, sessionCount = ");
          ((StringBuilder)localObject).append(MsgBackupManager.i);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_start_time", this.B);
        ((Intent)localObject).putExtra("session_end_time", this.C);
        ((Intent)localObject).putExtra("session_content_type", this.D);
        i = this.z;
        if (i == 0)
        {
          boolean bool = NetworkUtil.isWifiEnabled(BaseApplication.getContext());
          ((Intent)localObject).putExtra("session_net_status", bool);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onClick!!! TYPE_TO_OTHER_DEVICE isNetEnable = ");
            localStringBuilder.append(bool);
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, localStringBuilder.toString());
          }
          if (bool)
          {
            MsgBackupManager.a().a(false);
          }
          else if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onClick!!! TYPE_TO_OTHER_DEVICE net enable status = ");
            localStringBuilder.append(bool);
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, localStringBuilder.toString());
          }
          QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupQRFragment.class, 1000);
        }
        else if (i == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_PC");
          }
          ((Intent)localObject).putExtra("0x11bpush_extra", this.G);
          ((Intent)localObject).putExtra("param_start", 2);
          QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupPCTransportFragment.class, 1000);
        }
        q();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MsgBackupManager.a().a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment
 * JD-Core Version:    0.7.0.1
 */