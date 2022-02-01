package com.tencent.mobileqq.guild.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class QQGuildMemberFragment
  extends QQGuildTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private QQGuildMemberListViewModel A;
  private QQProgressDialog B;
  private final AtomicBoolean C = new AtomicBoolean(false);
  private final OverScrollViewListener D = new QQGuildMemberFragment.1(this);
  private final View.OnTouchListener E = new QQGuildMemberFragment.2(this);
  private final AbsListView.OnScrollListener F = new QQGuildMemberFragment.3(this);
  SwipListView o;
  SwipListView p;
  View q;
  private LinearLayout r;
  private final WeakReferenceHandler s = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private RelativeLayout t;
  private EditText u;
  private ImageView v;
  private LinearLayout w;
  private QQCustomDialog x;
  private QQGuildMemberListAdapter y;
  private QQGuildMemberListAdapter z;
  
  private void A()
  {
    RelativeLayout localRelativeLayout = this.t;
    if ((localRelativeLayout != null) && (localRelativeLayout.findViewById(2131435215) != null)) {
      QQGuildUtil.a(this.t.findViewById(2131435215), "em_sgrp_member_list_search", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }
  }
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(QQGuildMemberFragment.OperateMemberResult paramOperateMemberResult)
  {
    Object localObject = QQGuildMemberFragment.OperateMemberResult.access$900(paramOperateMemberResult);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = this.y.a((String)localObject);
    if (localObject == null) {
      return;
    }
    int i = paramOperateMemberResult.getOpcode();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.A.h().setValue(localObject);
        return;
      }
      this.A.g().setValue(localObject);
      return;
    }
    paramOperateMemberResult = new ArrayList();
    paramOperateMemberResult.add(localObject);
    this.A.i().setValue(paramOperateMemberResult);
  }
  
  private void a(String paramString)
  {
    this.a.setText(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      this.a.setBackgroundResource(2130840710);
      paramString = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      paramString.width = Utils.a(24.0F, MobileQQ.sMobileQQ.getResources());
      paramString.height = Utils.a(24.0F, MobileQQ.sMobileQQ.getResources());
      return;
    }
    this.a.setBackgroundResource(0);
    paramString = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    paramString.width = -2;
    paramString.height = -2;
  }
  
  private void a(List<IGProUserInfo> paramList)
  {
    if ((paramList.isEmpty()) && (this.p.getVisibility() == 0))
    {
      this.p.setVisibility(8);
      this.w.setVisibility(0);
    }
    else if ((!paramList.isEmpty()) && (this.w.getVisibility() == 0))
    {
      this.p.setVisibility(0);
      this.w.setVisibility(8);
    }
    this.z.a(paramList);
  }
  
  private void b(String paramString)
  {
    this.p.setVisibility(0);
    this.o.setVisibility(8);
    this.A.a(paramString);
  }
  
  private void b(List<IGProUserInfo> paramList)
  {
    boolean bool = ((CheckBox)this.x.findViewById(2131447782)).isChecked();
    this.A.a(paramList, bool, new QQGuildMemberFragment.16(this));
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.t;
    if (localRelativeLayout != null)
    {
      if (paramBoolean)
      {
        localRelativeLayout.setVisibility(0);
        return;
      }
      localRelativeLayout.setVisibility(8);
    }
  }
  
  private void j()
  {
    this.a.setOnClickListener(this);
    this.a.setTextColor(-16777216);
    this.c.setText(getString(2131890514));
    this.r = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131625088, null));
    this.r.setOnClickListener(this);
    this.q = LayoutInflater.from(getActivity()).inflate(2131625031, null);
    this.o = ((SwipListView)this.l.findViewById(2131438055));
    this.o.addHeaderView(this.r);
    this.o.setOverScrollFooter(this.q);
    this.B = new QQProgressDialog(getActivity());
    this.s.sendEmptyMessageDelayed(15, 500L);
  }
  
  private void k()
  {
    this.A = ((QQGuildMemberListViewModel)ViewModelProviderHelper.a(this, QQGuildMemberListViewModel.u).get(QQGuildMemberListViewModel.class));
    this.A.a(this);
    r();
    this.A.t();
    this.y = new QQGuildMemberListAdapter(this, this.A, 0);
    this.o.setAdapter(this.y);
    this.o.setRightIconMenuListener(this.y);
    this.o.setOverScrollListener(this.D);
    this.o.setOnScrollListener(this.F);
    if (this.A.o()) {
      m();
    }
    n();
  }
  
  private void m()
  {
    this.t = ((RelativeLayout)this.l.findViewById(2131445390));
    this.t.setVisibility(0);
    this.u = ((EditText)this.t.findViewById(2131432634));
    this.u.clearFocus();
    this.u.addTextChangedListener(new QQGuildMemberFragment.SearchTextWatcher(this));
    this.v = ((ImageView)this.t.findViewById(2131435215));
    this.u.setOnTouchListener(this.E);
    this.v.setOnClickListener(this);
    this.l.setFocusableInTouchMode(true);
    this.p = ((SwipListView)this.l.findViewById(2131445451));
    this.w = ((LinearLayout)this.l.findViewById(2131445422));
    this.z = new QQGuildMemberListAdapter(this, this.A, 1);
    this.p.setAdapter(this.z);
    this.z.g();
    this.p.setDragEnable(true);
  }
  
  private void n()
  {
    if (this.A.o()) {
      this.o.setDragEnable(true);
    } else {
      this.o.setDragEnable(false);
    }
    q();
    this.A.a(false);
    a("");
    o();
  }
  
  private void o()
  {
    if (this.o.findHeaderViewPosition(this.r) < 0) {
      this.o.addHeaderView(this.r);
    }
  }
  
  private void p()
  {
    if (this.u.hasFocus()) {
      return;
    }
    this.o.removeHeaderView(this.r);
    this.t.findViewById(2131448724).setVisibility(8);
    this.u.setHint(getString(2131890513));
    this.v.setVisibility(0);
  }
  
  private void q()
  {
    if (this.A.o())
    {
      this.d.setVisibility(0);
      this.d.setOnClickListener(this);
      this.d.setText("");
      this.d.setBackgroundResource(2130841005);
      this.d.setPadding(0, 0, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.addRule(11);
      localLayoutParams.width = ((int)(DeviceInfoUtil.a * 24.0F));
      localLayoutParams.height = ((int)(DeviceInfoUtil.a * 24.0F));
      localLayoutParams.rightMargin = ((int)(DeviceInfoUtil.a * 16.0F));
      return;
    }
    this.d.setVisibility(8);
  }
  
  private void r()
  {
    this.A.d().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.4(this));
    this.A.e().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.5(this));
    this.A.a().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.6(this));
    this.A.q().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.7(this));
    this.A.f().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.8(this));
    this.A.r().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.9(this));
    this.A.b().observe(getViewLifecycleOwner(), new QQGuildMemberFragment.10(this));
  }
  
  private void s()
  {
    Object localObject = (ViewGroup)getActivity().getWindow().getDecorView();
    View localView = ((ViewGroup)localObject).getChildAt(0);
    if ((localView instanceof DragFrameLayout)) {
      localObject = (ViewGroup)localView;
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
    }
  }
  
  private void t()
  {
    if (!this.A.o()) {
      return;
    }
    this.A.b(false);
    if (this.A.c())
    {
      u();
      localHashMap = new HashMap();
      localHashMap.put("sgrp_member_op_result", Integer.valueOf(3));
      VideoReport.reportEvent("clck", this.d, localHashMap);
      return;
    }
    b(false);
    VideoReport.reportEvent("clck", this.c, null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_member_op_result", Integer.valueOf(3));
    VideoReport.reportEvent("imp", this.d, localHashMap);
    this.A.a(true);
    a("移除", -2147483648);
    a("取消");
    this.o.removeHeaderView(this.r);
  }
  
  private void u()
  {
    if (this.y.e().size() <= 0)
    {
      QLog.i("QQGuildMemberFragment", 1, "onRightTitleViewClick no select delete user!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int m;
    for (int k = 0; i < this.y.e().size(); k = m)
    {
      int j = this.y.e().keyAt(i);
      QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = this.y.a(j);
      m = k;
      if (localUserInfoItem != null)
      {
        m = k;
        if (localUserInfoItem.c != null)
        {
          localArrayList.add(localUserInfoItem.c);
          if (localUserInfoItem.c.f() != 1) {
            j = 1;
          } else {
            j = 0;
          }
          m = k | j;
        }
      }
      i += 1;
    }
    a(localArrayList, k);
  }
  
  private void v()
  {
    if (this.A.l() == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_member_list");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.A.l().getGuildID(), null);
  }
  
  private void w()
  {
    VideoReport.setElementId(this.r, "em_sgrp_member_list_invite_member");
    VideoReport.setElementExposePolicy(this.r, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.r, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(this.c, "em_sgrp_member_list_multi_member_manage");
    VideoReport.setElementExposePolicy(this.c, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.c, ClickPolicy.REPORT_NONE);
    VideoReport.setElementId(this.d, "em_sgrp_member_list_multi_member_manage_set");
    VideoReport.setElementExposePolicy(this.d, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.d, ClickPolicy.REPORT_NONE);
    A();
  }
  
  private String x()
  {
    EditText localEditText = this.u;
    if (localEditText != null) {
      return localEditText.getText().toString().trim();
    }
    return "";
  }
  
  private void y()
  {
    this.p.setVisibility(8);
    this.w.setVisibility(8);
    this.o.setVisibility(0);
  }
  
  private void z()
  {
    EditText localEditText = this.u;
    if (localEditText != null)
    {
      if (!localEditText.hasFocus()) {
        return;
      }
      this.p.setVisibility(8);
      this.w.setVisibility(8);
      this.o.setVisibility(0);
      this.v.setVisibility(8);
      this.u.setHint(null);
      this.u.setText("");
      this.t.findViewById(2131448724).setVisibility(0);
      InputMethodUtil.b(this.u);
      this.u.clearFocus();
      o();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    j();
    k();
    v();
    w();
  }
  
  void a(String paramString, int paramInt)
  {
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    this.d.setText(paramString);
    this.d.setBackgroundResource(0);
    this.d.setTextColor(paramInt);
    paramString = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    paramString.addRule(11);
    paramString.width = -2;
    paramString.height = -2;
    paramString.rightMargin = ((int)(DeviceInfoUtil.a * 12.0F));
  }
  
  public void a(List<IGProUserInfo> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.A.l() == null) {
        return;
      }
      if (!this.A.o()) {
        return;
      }
      Object localObject = this.x;
      int i = 8;
      if (localObject == null)
      {
        new DialogUtil();
        this.x = DialogUtil.a(getActivity(), 0, "确定移除该用户？", "", new QQGuildMemberFragment.11(this, paramList), new QQGuildMemberFragment.12(this));
        this.x.setCheckBox(BaseApplication.getContext().getString(2131890568), false, null);
        this.x.findViewById(2131431876).setVisibility(8);
        ((LinearLayout.LayoutParams)this.x.findViewById(2131436895).getLayoutParams()).topMargin = 0;
        ((CheckBox)this.x.findViewById(2131447782)).setBackgroundResource(2130841007);
        localObject = (TextView)this.x.findViewById(2131448922);
        ((TextView)localObject).setTextSize(14.0F);
        ((TextView)localObject).setTextColor(-7894119);
        localObject = this.x.findViewById(2131431871);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(localObject, "pg_sgrp_member_list");
        ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams((View)localObject, this.A.l().getGuildID(), null);
        VideoReport.setElementId(this.x.getBtnLeft(), "em_sgrp_member_list_member_manage_delete_confirm");
        VideoReport.setElementExposePolicy(this.x.getBtnLeft(), ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.x.getBtnLeft(), ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(this.x.getBtnLeft(), "sgrp_member_delete_result", Integer.valueOf(3));
        VideoReport.setElementId(this.x.getBtnight(), "em_sgrp_member_list_member_manage_delete_confirm");
        VideoReport.setElementExposePolicy(this.x.getBtnight(), ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.x.getBtnight(), ClickPolicy.REPORT_NONE);
      }
      this.x.setNegativeButton(2131887648, new QQGuildMemberFragment.13(this));
      localObject = (CheckBox)this.x.findViewById(2131447782);
      ((CheckBox)localObject).setChecked(false);
      this.x.setPositiveButton(2131892267, new QQGuildMemberFragment.14(this, paramList, (CheckBox)localObject));
      this.x.setOnDismissListener(new QQGuildMemberFragment.15(this, (CheckBox)localObject));
      if (paramList.size() == 1)
      {
        this.x.setTitle("确定移除该用户？");
      }
      else
      {
        localObject = this.x;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("确定移除这");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append("位用户？");
        ((QQCustomDialog)localObject).setTitle(localStringBuilder.toString());
      }
      paramList = this.x.findViewById(2131436895);
      if (paramBoolean) {
        i = 0;
      }
      paramList.setVisibility(i);
      this.x.show();
    }
  }
  
  protected int b()
  {
    return 2131625084;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 15)
    {
      if (i == 16)
      {
        paramMessage = this.x;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        n();
      }
    }
    else {
      this.B.show();
    }
    return false;
  }
  
  public void i()
  {
    this.C.set(true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null)) {
      a((QQGuildMemberFragment.OperateMemberResult)paramIntent.getSerializableExtra("operate_member_result"));
    }
  }
  
  public boolean onBackEvent()
  {
    EditText localEditText = this.u;
    if (localEditText != null) {
      InputMethodUtil.b(localEditText);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a)
    {
      if (this.A.c())
      {
        n();
        b(true);
      }
      else
      {
        onBackEvent();
      }
    }
    else if (paramView == this.d) {
      t();
    } else if (paramView == this.r) {
      this.A.a(getQBaseActivity());
    } else if (paramView == this.v) {
      this.A.b(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.x;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    localObject = this.y;
    if (localObject != null) {
      ((QQGuildMemberListAdapter)localObject).f();
    }
    localObject = this.z;
    if (localObject != null) {
      ((QQGuildMemberListAdapter)localObject).f();
    }
    this.A.u();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.s.removeMessages(15);
    this.B.dismiss();
  }
  
  public void onResume()
  {
    super.onResume();
    s();
    if (this.C.compareAndSet(true, false)) {
      this.A.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment
 * JD-Core Version:    0.7.0.1
 */