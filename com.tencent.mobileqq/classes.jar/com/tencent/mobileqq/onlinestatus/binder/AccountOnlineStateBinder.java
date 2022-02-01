package com.tencent.mobileqq.onlinestatus.binder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.onlinestatus.AutoReplyAdapter;
import com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.OnAutoReplyItemListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDataReporter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDisplayInfoBuilder;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.OnStatusItemClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.OnlineStatusPanelListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl.OnStatusItemCheckListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView.OnDismissCallback;
import com.tencent.mobileqq.onlinestatus.view.MyMoodView;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class AccountOnlineStateBinder
  extends BaseViewBinder
  implements View.OnClickListener, AutoReplyAdapter.OnAutoReplyItemListener, BaseOnlineStatusDisplayInfo.UpdateUIListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, OnlineStatusViewCtrl.OnStatusItemCheckListener, BaseStatusCardView.OnDismissCallback
{
  private AccountOnlineStateViewModel A;
  private TopGestureLayout a;
  private AutoReplyText b;
  private AutoReplyText c;
  private OnLineStatusBlurBg d = new OnLineStatusBlurBg();
  private QFormSimpleItem e;
  private QFormSimpleItem f;
  private TextView g;
  private LinearLayout h;
  private ImageView i;
  private ImageView j;
  private View k;
  private View l;
  private View m;
  private TextView n;
  private TextView o;
  private View p;
  private TextView q;
  private ListView r;
  private OnlineStatusViewCtrl s;
  private AutoReplyAdapter t;
  private AccountOnlineStateBinder.BinderCallback u;
  private OnLineStatusCustomSmartViewCtrl v = new OnLineStatusCustomSmartViewCtrl(false, false);
  private OnlineStatusDisplayInfoBuilder w = new OnlineStatusDisplayInfoBuilder();
  private StatusCardViewHolder x = new StatusCardViewHolder();
  private AppInterface y;
  private QBaseActivity z;
  
  public AccountOnlineStateBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, AccountOnlineStateViewModel paramAccountOnlineStateViewModel, AccountOnlineStateBinder.BinderCallback paramBinderCallback)
  {
    this.u = paramBinderCallback;
    this.z = paramQBaseActivity;
    this.y = paramAppInterface;
    this.A = paramAccountOnlineStateViewModel;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.z;
    if (localObject1 != null)
    {
      if (((QBaseActivity)localObject1).isFinishing()) {
        return;
      }
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.w.a(paramLong, this, this.y, this.z);
      if (localBaseOnlineStatusDisplayInfo == null)
      {
        this.r.removeFooterView(this.h);
        return;
      }
      if (localBaseOnlineStatusDisplayInfo.d)
      {
        this.m.setVisibility(0);
        this.A.a(this.y, this.z);
        f();
      }
      else
      {
        this.m.setVisibility(8);
      }
      if (paramBoolean) {
        return;
      }
      if (this.h.getParent() == null) {
        this.r.addFooterView(this.h);
      }
      Object localObject2 = this.g;
      paramBoolean = TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.a);
      String str = "";
      if (paramBoolean) {
        localObject1 = "";
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.a;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.e;
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.b)) {
        localObject1 = "在线";
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.b;
      }
      ((QFormSimpleItem)localObject2).setLeftText((CharSequence)localObject1);
      localObject2 = this.e;
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.c)) {
        localObject1 = str;
      } else {
        localObject1 = localBaseOnlineStatusDisplayInfo.c;
      }
      ((QFormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      if (localBaseOnlineStatusDisplayInfo.c())
      {
        this.e.setClickable(true);
        this.e.a(true);
      }
      else
      {
        this.e.setClickable(false);
        this.e.a(false);
      }
      if (TextUtils.isEmpty(localBaseOnlineStatusDisplayInfo.e))
      {
        this.f.setVisibility(8);
        return;
      }
      this.f.setVisibility(0);
      this.f.setLeftText(localBaseOnlineStatusDisplayInfo.e);
    }
  }
  
  private void a(View paramView, long paramLong)
  {
    this.h = ((LinearLayout)paramView.findViewById(2131437685));
    this.e = ((QFormSimpleItem)paramView.findViewById(2131427471));
    this.g = ((TextView)paramView.findViewById(2131447403));
    this.f = ((QFormSimpleItem)paramView.findViewById(2131427476));
    this.e.setOnClickListener(this);
    this.m = paramView.findViewById(2131439571);
    this.i = ((ImageView)paramView.findViewById(2131445890));
    this.j = ((ImageView)paramView.findViewById(2131445905));
    this.k = paramView.findViewById(2131427474);
    this.l = paramView.findViewById(2131436056);
    this.p = paramView.findViewById(2131445906);
    this.o = ((TextView)paramView.findViewById(2131427473));
    this.n = ((TextView)paramView.findViewById(2131427472));
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.f.setOnClickListener(this);
    a(paramLong, false);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      localObject = ((AutoReplyAdapter)localObject).c();
      AutoReplyText localAutoReplyText = this.b;
      int i2 = 0;
      int i1;
      if (localAutoReplyText != null) {
        i1 = localAutoReplyText.mTextId;
      } else {
        i1 = 0;
      }
      localAutoReplyText = this.c;
      if (localAutoReplyText != null) {
        i2 = localAutoReplyText.mTextId;
      }
      ((ICardHandler)QRoute.api(ICardHandler.class)).setAutoReplyList((ArrayList)localObject, i1, i2, paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.q.setEnabled(paramBoolean);
  }
  
  private void d(View paramView)
  {
    paramView = (MyMoodView)this.x.b(paramView, this.z, this.d, this, 1055L);
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.A.a().getValue();
    paramView.a(localOnlineStatusData.a, localOnlineStatusData.b);
    int i1;
    if (OnLineStatusHelper.c(((IOnlineStatusService)this.y.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), OnLineStatusHelper.a().a(this.y))) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    ReportHelperKt.a("0X800B7AE", i1);
    paramView.show();
  }
  
  private void f()
  {
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.A.f().getValue();
    boolean bool = localOnlineStatusPermissionItem.isAllHasPermission();
    int i2 = 8;
    int i1;
    if (bool)
    {
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      this.p.setVisibility(8);
    }
    else
    {
      this.i.setVisibility(8);
      this.j.setVisibility(0);
      this.p.setVisibility(0);
      if (localOnlineStatusPermissionItem.getPermissionUins() == null) {
        return;
      }
      localObject1 = new SpannableStringBuilder();
      i1 = 0;
      Object localObject2;
      while (i1 < localOnlineStatusPermissionItem.getPermissionUins().size())
      {
        localObject2 = (Long)localOnlineStatusPermissionItem.getPermissionUins().get(i1);
        ((SpannableStringBuilder)localObject1).append(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(localObject2)));
        if (i1 != localOnlineStatusPermissionItem.getPermissionUins().size() - 1) {
          ((SpannableStringBuilder)localObject1).append("、");
        }
        i1 += 1;
      }
      this.n.setText(((SpannableStringBuilder)localObject1).toString());
      localObject1 = this.z.getResources().getDrawable(2130839446);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.o.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      if (localOnlineStatusPermissionItem.getPermissionUins().size() > 0)
      {
        localObject1 = this.o;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("（");
        ((StringBuilder)localObject2).append(localOnlineStatusPermissionItem.getPermissionUins().size());
        ((StringBuilder)localObject2).append("人）");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else
      {
        this.o.setText("");
      }
    }
    Object localObject1 = this.j;
    if (localOnlineStatusPermissionItem.isAllHasPermission()) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    ((ImageView)localObject1).setVisibility(i1);
  }
  
  private void g()
  {
    OnlineStatusData localOnlineStatusData1 = (OnlineStatusData)this.A.a().getValue();
    OnlineStatusData localOnlineStatusData2 = (OnlineStatusData)this.A.b().getValue();
    boolean bool1 = OnLineStatusHelper.c(localOnlineStatusData2.a, localOnlineStatusData2.b);
    boolean bool2 = OnLineStatusHelper.c(localOnlineStatusData1.a, localOnlineStatusData1.b);
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateBinder", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(localOnlineStatusData2.b), " curExtID=", Long.valueOf(localOnlineStatusData1.b) });
    }
    if ((this.s != null) && ((bool2) || (bool1))) {
      this.s.a(true, localOnlineStatusData1.a, localOnlineStatusData1.b);
    }
  }
  
  public void a()
  {
    a(((OnlineStatusData)this.A.a().getValue()).b, false);
  }
  
  public void a(int paramInt)
  {
    if (this.s != null)
    {
      OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.A.b().getValue();
      this.s.a(localOnlineStatusData.a, localOnlineStatusData.b, this);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    OnlineStatusItem localOnlineStatusItem = this.s.c();
    this.w.a(localOnlineStatusItem.b, this, this.y, this.z).a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 40001L)
    {
      AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.x.a(40000L);
      this.A.a(localAutoStatusAccountView.l());
      this.s.a(AppRuntime.Status.online, 40001L, this);
      return;
    }
    if (OnLineStatusHelper.c(AppRuntime.Status.online, paramLong)) {
      a(OnLineStatusHelper.a().a(AppRuntime.Status.online, paramLong), null);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.t.b())
    {
      if (NetworkUtil.isNetworkAvailable(paramActivity))
      {
        a(false);
        return;
      }
      QLog.d("AccountOnlineStateBinder", 2, "onBackEvent network is not available");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateBinder", 2, "onBackEvent auto reply list not changed!");
    }
  }
  
  public void a(View paramView)
  {
    this.a = b(paramView);
  }
  
  public void a(View paramView, TextView paramTextView, OnlineStatusData paramOnlineStatusData)
  {
    this.q = paramTextView;
    paramTextView = new LinearLayout(this.z);
    paramTextView.setOrientation(1);
    paramTextView.setBackgroundDrawable(this.z.getResources().getDrawable(2130839577));
    Drawable localDrawable = this.z.getResources().getDrawable(2130846138);
    OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
    localOnlineStatusPanelParams.a = 2;
    localOnlineStatusPanelParams.j = false;
    localOnlineStatusPanelParams.k = false;
    localOnlineStatusPanelParams.i = this.z.getResources().getDisplayMetrics().widthPixels;
    this.s = new OnlineStatusViewCtrl(this.z, paramTextView, this, localOnlineStatusPanelParams, this);
    this.s.a();
    this.t = new AutoReplyAdapter(this.y, this.z, localDrawable);
    this.t.a(this);
    this.s.a(paramOnlineStatusData.a, paramOnlineStatusData.b, this);
    this.r = ((ListView)paramView.findViewById(2131427479));
    paramView = this.r;
    if ((paramView instanceof SwipListView))
    {
      ((SwipListView)paramView).setDragEnable(true);
      ((SwipListView)this.r).setRightIconMenuListener(new AccountOnlineStateBinder.1(this));
    }
    this.r.addHeaderView(paramTextView);
    this.r.setAdapter(this.t);
    this.r.setDividerHeight(0);
    paramView = View.inflate(this.z, 2131623987, null);
    this.v.a(this.z, paramTextView, 0);
    this.v.b().setOnClickListener(this);
    this.v.a().setOnClickListener(this);
    this.v.a(this.z, paramOnlineStatusData.a, paramOnlineStatusData.b);
    this.v.a(this.z);
    a(paramView, paramOnlineStatusData.b);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().addObserver(new AccountOnlineStateBinder.2(this));
  }
  
  public void a(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.a().observe(paramLifecycleOwner, new AccountOnlineStateBinder.3(this));
  }
  
  public void a(AutoReplyText paramAutoReplyText)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("text is added, text = ");
      localStringBuilder.append(paramAutoReplyText);
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    b(true);
  }
  
  public void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAutoReplyText1);
      localStringBuilder.append(" is checked, lastChecked is ");
      localStringBuilder.append(paramAutoReplyText2);
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    this.b = paramAutoReplyText1;
    this.c = paramAutoReplyText2;
    if (paramAutoReplyText2 != null) {
      b(true);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAutoReplyText);
      localStringBuilder.append(" is delete");
      QLog.d("AccountOnlineStateBinder", 2, localStringBuilder.toString());
    }
    b(true);
    ReportController.b(this.y, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    b(true);
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.A.a().getValue();
    if (paramOnlineStatusItem != null)
    {
      localOnlineStatusData = new OnlineStatusData(OnLineStatusHelper.a().b(paramOnlineStatusItem), paramOnlineStatusItem.b);
      this.A.a().setValue(localOnlineStatusData);
    }
    if ((paramView != null) && (OnLineStatusHelper.c(localOnlineStatusData.a, localOnlineStatusData.b)))
    {
      d(paramView);
      return;
    }
    g();
    paramOnlineStatusItem = new OnlineStatusData(localOnlineStatusData.a, localOnlineStatusData.b);
    this.A.b().setValue(paramOnlineStatusItem);
    this.t.a(OnlineStatusConstants.d(localOnlineStatusData.a));
    this.v.a(this.z, localOnlineStatusData.a, localOnlineStatusData.b);
    paramOnlineStatusItem = this.w.a(localOnlineStatusData.b, this, this.y, this.z);
    if (paramOnlineStatusItem != null) {
      paramOnlineStatusItem.e();
    }
    if (this.h != null) {
      a(localOnlineStatusData.b, false);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    a(paramOnlineStatusItem2, paramView);
  }
  
  TopGestureLayout b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if ((paramView instanceof TopGestureLayout)) {
        return (TopGestureLayout)paramView;
      }
    }
    return null;
  }
  
  public ArrayList<Integer> b()
  {
    AutoStatusAccountView localAutoStatusAccountView = (AutoStatusAccountView)this.x.a(40000L);
    if (localAutoStatusAccountView == null) {
      return null;
    }
    return localAutoStatusAccountView.f();
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.x.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void b(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.c().observe(paramLifecycleOwner, new AccountOnlineStateBinder.4(this));
  }
  
  public void b(AutoReplyText paramAutoReplyText)
  {
    if (paramAutoReplyText != null)
    {
      this.t.a(paramAutoReplyText);
      this.t.a(paramAutoReplyText.getTextId());
    }
  }
  
  public void b(@Nullable AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAutoReplyText);
      ((StringBuilder)localObject).append(" is click");
      QLog.d("AccountOnlineStateBinder", 2, ((StringBuilder)localObject).toString());
    }
    b(true);
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      OnlineStatusDataReporter.b(this.y);
    }
    Object localObject = this.z;
    if (localObject != null) {
      AutoReplyEditActivity.a((Activity)localObject, 325, paramAutoReplyText);
    }
    ReportController.b(this.y, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.A.a().getValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSubmit online status ");
      ((StringBuilder)localObject).append(localOnlineStatusData.b);
      QLog.d("AccountOnlineStateBinder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.z;
    if (localObject == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable((Context)localObject))
    {
      QQToast.makeText(this.z, 1, 2131916775, 1).show();
      return;
    }
    if (this.t.b())
    {
      a(true);
    }
    else
    {
      localObject = this.s.c();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountOnlineStateBinder", 2, "onSubmit online status is empty");
        }
        return;
      }
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = this.w.a(((OnlineStatusItem)localObject).b, this, this.y, this.z);
      this.A.a((OnlineStatusItem)localObject, localBaseOnlineStatusDisplayInfo, this.y);
    }
    this.A.a(localOnlineStatusData, this.y, this.b);
  }
  
  public void c(View paramView) {}
  
  public void c(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.d().observe(paramLifecycleOwner, new AccountOnlineStateBinder.5(this));
  }
  
  public ArrayList<OnlineStatusItem> d()
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.A.a().getValue();
    return OnLineStatusHelper.a().b(localOnlineStatusData.a, localOnlineStatusData.b);
  }
  
  public void d(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.e().observe(paramLifecycleOwner, new AccountOnlineStateBinder.6(this, paramAccountOnlineStateViewModel));
  }
  
  public ArrayList<OnlineStatusItem> e()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.s;
    if (localOnlineStatusViewCtrl != null) {
      return localOnlineStatusViewCtrl.d();
    }
    return null;
  }
  
  public void e(LifecycleOwner paramLifecycleOwner, AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    paramAccountOnlineStateViewModel.f().observe(paramLifecycleOwner, new AccountOnlineStateBinder.7(this));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    b(true);
    int i1 = paramView.getId();
    Object localObject = (OnlineStatusData)this.A.a().getValue();
    if (i1 == 2131427474)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateBinder", 2, "account_online_status_show_all!");
      }
      if (this.i.getVisibility() != 0)
      {
        localObject = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(((OnlineStatusData)localObject).b, true, null);
        this.A.a((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      }
      ReportHelperKt.a("0X800AF99", 1);
    }
    else if (i1 == 2131431541)
    {
      ((AutoStatusAccountView)this.x.b(paramView, this.z, this.d, this, 40000L)).a(OnlineStatusItem.a(((OnlineStatusData)localObject).a, ((OnlineStatusData)localObject).b), this.A.i());
    }
    else if (i1 == 2131431544)
    {
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.z, "panel");
      ReportHelperKt.a("0X800AF42", 2);
    }
    else if (i1 == 2131427471)
    {
      localObject = this.w.a(((OnlineStatusData)localObject).b, this, this.y, this.z);
      if (localObject != null) {
        ((BaseOnlineStatusDisplayInfo)localObject).b();
      }
    }
    else if (i1 == 2131427476)
    {
      localObject = this.w.a(((OnlineStatusData)localObject).b, this, this.y, this.z);
      if (localObject != null) {
        ((BaseOnlineStatusDisplayInfo)localObject).d();
      }
    }
    else if (i1 == 2131436056)
    {
      localObject = this.A;
      if (this.j.getVisibility() == 0) {
        bool = false;
      }
      ((AccountOnlineStateViewModel)localObject).a(bool, this.y, this.z);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder
 * JD-Core Version:    0.7.0.1
 */