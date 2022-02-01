package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnAccountExitListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.BlurBgItem;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.OnLineStatusBlurBgListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil.MyTouchViewOnTouchListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.ViewAlphaOnTouchListener;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountInfoProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountUnReadItemProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AccountPanelViewContainer
  implements View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, AccountPanelRootLayout.AccountPanelRootLayoutListener
{
  public static final int a = 2131427487;
  public static final int b = 2131427457;
  protected ImageView c;
  protected ImageView d;
  public QQProgressDialog e;
  private LayoutInflater f;
  private AccountPanelRootLayout g;
  private View h;
  private ViewGroup i;
  private View j;
  private TextView k;
  private LinearLayout l;
  private ReboundHorizontalScrollView m;
  private LinearLayout n;
  private TextView o;
  private View p;
  private OnLineStatusCustomSmartViewCtrl q = new OnLineStatusCustomSmartViewCtrl(true, true);
  private OnLineStatusBlurBg r;
  private IAccountPanel.OnAccountExitListener s;
  private AccountPanel t;
  private AccountPanelBinder u;
  private QBaseActivity v;
  private Runnable w = new AccountPanelViewContainer.1(this);
  private View.OnClickListener x = new AccountPanelViewContainer.2(this);
  
  public AccountPanelViewContainer(QBaseActivity paramQBaseActivity, AccountPanel paramAccountPanel, AccountPanelBinder paramAccountPanelBinder)
  {
    this.u = paramAccountPanelBinder;
    this.t = paramAccountPanel;
    this.v = paramQBaseActivity;
  }
  
  private void a(AccountPanelViewContainer.AccountItemViewHolder paramAccountItemViewHolder, ISubAccountApi.SubAccountInfoProxy paramSubAccountInfoProxy, View paramView)
  {
    paramAccountItemViewHolder.a(2);
    paramAccountItemViewHolder.a(FaceDrawable.getFaceDrawable((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), 1, paramSubAccountInfoProxy.b()));
    paramAccountItemViewHolder.a(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramSubAccountInfoProxy.b(), false));
    ISubAccountApi.SubAccountUnReadItemProxy localSubAccountUnReadItemProxy = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramSubAccountInfoProxy.b());
    if ((localSubAccountUnReadItemProxy.a() > 0) && (paramSubAccountInfoProxy.a() == 1)) {
      paramAccountItemViewHolder.a(localSubAccountUnReadItemProxy.a(), localSubAccountUnReadItemProxy.b());
    } else {
      paramAccountItemViewHolder.a(0, false);
    }
    paramAccountItemViewHolder.a(true);
    if (paramSubAccountInfoProxy.a() != 1) {
      paramAccountItemViewHolder.b(true);
    } else {
      paramAccountItemViewHolder.b(false);
    }
    paramView.setTag(a, paramSubAccountInfoProxy.b());
    paramView.setTag(b, paramSubAccountInfoProxy);
  }
  
  private void a(AccountPanelViewContainer.AccountItemViewHolder paramAccountItemViewHolder, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramAccountItemViewHolder.a(1);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    paramAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(localAppInterface, 1, paramSimpleAccount.getUin()));
    paramAccountItemViewHolder.a(((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getShowName(localAppInterface, paramSimpleAccount));
    paramAccountItemViewHolder.a(((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getLocalThirdUnreadMsgNum(localAppInterface, paramSimpleAccount.getUin()), false);
    paramAccountItemViewHolder.a(false);
    paramAccountItemViewHolder.b(false);
    paramView.setTag(a, paramSimpleAccount.getUin());
    paramView.setTag(b, paramSimpleAccount);
    paramView.setTag(paramAccountItemViewHolder);
  }
  
  private void b(List<Object> paramList)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      View localView = this.l.getChildAt(i1);
      AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = (AccountPanelViewContainer.AccountItemViewHolder)localView.getTag();
      Object localObject = paramList.get(i1);
      if ((localObject instanceof ISubAccountApi.SubAccountInfoProxy)) {
        a(localAccountItemViewHolder, (ISubAccountApi.SubAccountInfoProxy)localObject, localView);
      } else if ((localObject instanceof SimpleAccount)) {
        a(localAccountItemViewHolder, (SimpleAccount)localObject, localView);
      }
      i1 += 1;
    }
  }
  
  private AccountPanelViewContainer.AccountItemViewHolder d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = null;
    if (bool) {
      return null;
    }
    Object localObject = this.l;
    if ((localObject != null) && (((LinearLayout)localObject).getChildCount() > 0))
    {
      int i2 = this.l.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.l.getChildAt(i1);
        if (paramString.equals((String)((View)localObject).getTag(a)))
        {
          paramString = (String)localObject;
          break label93;
        }
        i1 += 1;
      }
    }
    paramString = null;
    label93:
    if (paramString != null) {
      localAccountItemViewHolder = (AccountPanelViewContainer.AccountItemViewHolder)paramString.getTag();
    }
    return localAccountItemViewHolder;
  }
  
  public View a(int paramInt)
  {
    this.f = LayoutInflater.from(this.v);
    this.g = ((AccountPanelRootLayout)this.f.inflate(2131623992, null));
    this.g.setAccountPanelRootLayoutListener(this);
    this.h = this.g.findViewById(2131427489);
    this.i = ((ViewGroup)this.g.findViewById(2131431368));
    this.j = this.g.findViewById(2131439104);
    this.j.setOnClickListener(this);
    this.k = ((TextView)this.g.findViewById(2131439105));
    this.j.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
    this.k.setTypeface(Typeface.defaultFromStyle(1));
    h();
    this.l = ((LinearLayout)this.g.findViewById(2131427458));
    this.p = this.g.findViewById(2131445745);
    this.m = ((ReboundHorizontalScrollView)this.g.findViewById(2131427460));
    this.m.setOverScrollDistance(Utils.a(48.0F, this.v.getResources()));
    this.n = ((LinearLayout)this.g.findViewById(2131439580));
    this.o = ((TextView)this.g.findViewById(2131427486));
    this.c = ((ImageView)this.g.findViewById(2131436250));
    this.d = ((ImageView)this.g.findViewById(2131436364));
    this.q.a(this.v, this.i, 2);
    this.q.b().setOnClickListener(this);
    this.q.a().setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.d.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
    this.t.setContentView(this.g);
    this.r = new OnLineStatusBlurBg();
    if (paramInt != 10) {
      this.h.setVisibility(8);
    }
    return this.g;
  }
  
  public void a()
  {
    this.t.a(false);
  }
  
  public void a(long paramLong)
  {
    StatusCardViewBuilder.a(this.v, paramLong, null);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      a(false, null, Color.parseColor("#FF010101"));
      return;
    }
    OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
    localBlurBgItem.a = paramQBaseActivity;
    this.r.a(localBlurBgItem, this);
  }
  
  public void a(IAccountPanel.OnAccountExitListener paramOnAccountExitListener)
  {
    this.s = paramOnAccountExitListener;
  }
  
  public void a(String paramString)
  {
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = d(paramString);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAccountItemViewHolder != null)
    {
      Object localObject = null;
      if (localAccountItemViewHolder.g == 2)
      {
        paramString = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramString, false);
      }
      else
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)localAccountItemViewHolder.a.getTag(b);
        paramString = localObject;
        if (localSimpleAccount != null) {
          paramString = ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getShowName(localAppInterface, localSimpleAccount);
        }
      }
      localAccountItemViewHolder.a(paramString);
    }
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.k.setText(paramString);
    this.k.setCompoundDrawablePadding(Utils.a(0.0F, this.v.getResources()));
    this.k.setCompoundDrawables(paramDrawable1, null, paramDrawable2, null);
  }
  
  public void a(List<Object> paramList)
  {
    int i2 = paramList.size();
    if (i2 <= 0)
    {
      this.l.removeAllViews();
      return;
    }
    int i3 = this.l.getChildCount();
    if (i3 == i2)
    {
      b(paramList);
      return;
    }
    int i4;
    if (i3 < i2) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i1;
    if (i4 != 0) {
      i1 = i3;
    } else {
      i1 = i2;
    }
    if (i4 == 0) {
      i2 = i3;
    }
    if (i4 != 0) {
      while (i1 < i2)
      {
        k();
        i1 += 1;
      }
    }
    this.l.removeViews(i1, i2 - i1);
    b(paramList);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    this.q.a(this.v, paramStatus, paramLong);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      AccountPanelRootLayout localAccountPanelRootLayout = this.g;
      if (localAccountPanelRootLayout != null)
      {
        localAccountPanelRootLayout.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.g;
    if (paramBitmap != null) {
      paramBitmap.setBackgroundColor(paramInt);
    }
  }
  
  boolean a(int paramInt, Resources paramResources)
  {
    if (paramResources != null)
    {
      if (paramInt == 0) {
        return false;
      }
      if (paramInt < 7) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = paramResources.getDisplayMetrics().widthPixels;
      if (i1 != 0) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      int i1 = Utils.a(i1 * 64 + 62, paramResources);
      boolean bool;
      if (Utils.a(64.0F, paramResources) * paramInt > i2 - i1) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewContainer", 2, new Object[] { "showShadowWhenAllAccountNotDisplay: showShadow:", Boolean.valueOf(bool) });
      }
      return bool;
    }
    return false;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = d(paramString);
    if (localAccountItemViewHolder != null) {
      localAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(localAppInterface, 1, paramString));
    }
  }
  
  public boolean b(long paramLong)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = ((IOnlineStatusService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(localStatus, paramLong);
    localObject = ((IFriendDataService)((AppRuntime)localObject).getRuntimeService(IFriendDataService.class, "")).getFriend(((AppRuntime)localObject).getCurrentUin(), true, true);
    OnLineStatusHelper localOnLineStatusHelper = OnLineStatusHelper.a();
    boolean bool;
    if (localOnlineStatusItem.b > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!localOnLineStatusHelper.a(localOnlineStatusItem, (Friends)localObject, bool)) && (localStatus == AppRuntime.Status.online)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewContainer", 2, new Object[] { "isDisplayOnline ", " useFallbackOnlineText: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void c()
  {
    ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).registerChangeWeakListener(this.w);
  }
  
  public void c(String paramString)
  {
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = d(paramString);
    if (localAccountItemViewHolder != null)
    {
      paramString = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramString);
      localAccountItemViewHolder.a(paramString.a(), paramString.b());
    }
  }
  
  public void d()
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    MobileQQ localMobileQQ = null;
    Object localObject2 = ((MobileQQ)localObject1).waitAppRuntime(null);
    Object localObject3 = ((IOnlineStatusService)((AppRuntime)localObject2).getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l1 = OnLineStatusHelper.a().a((AppRuntime)localObject2);
    Friends localFriends = ((IFriendDataService)((AppRuntime)localObject2).getRuntimeService(IFriendDataService.class, "")).getFriend(((AppRuntime)localObject2).getCurrentUin(), true, true);
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a((AppRuntime.Status)localObject3, l1);
    localObject1 = OnLineStatusHelper.a().b(localOnlineStatusItem);
    OnLineStatusHelper localOnLineStatusHelper;
    boolean bool;
    if (localObject3 == AppRuntime.Status.online)
    {
      localOnLineStatusHelper = OnLineStatusHelper.a();
      TextView localTextView = i();
      if (localOnlineStatusItem.b > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      localObject2 = localOnLineStatusHelper.a((AppRuntime)localObject2, localFriends, localTextView, 3, localOnlineStatusItem, Boolean.valueOf(bool));
    }
    else
    {
      localObject2 = OnLineStatusHelper.a().b((AppRuntime)localObject2, localOnlineStatusItem, (AppRuntime.Status)localObject1, localFriends, i(), 3);
    }
    if (localObject1 == AppRuntime.Status.online)
    {
      localOnLineStatusHelper = OnLineStatusHelper.a();
      if (localOnlineStatusItem.b > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      if (!localOnLineStatusHelper.a(localOnlineStatusItem, localFriends, bool))
      {
        localObject3 = OnLineStatusHelper.a().a(0L, AppRuntime.Status.online, 1, localFriends);
        break label256;
      }
    }
    localObject3 = OnLineStatusHelper.a().a(l1, (AppRuntime.Status)localObject3, 1, localFriends);
    label256:
    if ((l1 != 1030L) && (l1 != 1040L) && (!b(l1)) && (!OnLineStatusHelper.c((AppRuntime.Status)localObject1, l1)))
    {
      localObject1 = localMobileQQ;
      if (l1 == 1080L)
      {
        localObject1 = localMobileQQ;
        if (TextUtils.isEmpty(localOnlineStatusItem.n)) {}
      }
    }
    else
    {
      if (QQTheme.isNowThemeIsNight()) {
        localObject1 = this.v.getResources().getDrawable(2130842364);
      } else {
        localObject1 = this.v.getResources().getDrawable(2130839445);
      }
      localMobileQQ = MobileQQ.sMobileQQ;
      int i1 = Utils.a(16.0F, MobileQQ.getContext().getResources());
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
    }
    a((String)localObject2, (Drawable)localObject3, (Drawable)localObject1);
  }
  
  public LinearLayout e()
  {
    return this.n;
  }
  
  public OnLineStatusBlurBg f()
  {
    return this.r;
  }
  
  public void g()
  {
    LinearLayout localLinearLayout = this.l;
    if (localLinearLayout != null) {
      localLinearLayout.removeAllViews();
    }
  }
  
  public void h()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.k.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.k.setTextColor(-16777216);
  }
  
  public TextView i()
  {
    return this.k;
  }
  
  public void j()
  {
    if (this.l.getChildCount() > 0) {
      this.o.setText(2131896430);
    } else {
      this.o.setText(2131896431);
    }
    Object localObject = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    if (this.l.getChildCount() < 7)
    {
      this.c.setVisibility(0);
      this.c.setOnClickListener(this);
      this.c.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
      ((RelativeLayout.LayoutParams)localObject).addRule(0, this.c.getId());
    }
    else
    {
      this.c.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, this.d.getId());
    }
    boolean bool = a(this.l.getChildCount(), this.l.getResources());
    int i1;
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
      i1 = 2130842362;
    } else {
      i1 = 2130842361;
    }
    localObject = this.p;
    if (!bool) {
      i1 = 0;
    }
    ((View)localObject).setBackgroundResource(i1);
    OnLineStatusCustomSmartViewCtrl.a(this.h, false, null, true);
    OnLineStatusCustomSmartViewCtrl.a(this.j, false, null, true);
  }
  
  public View k()
  {
    View localView = this.f.inflate(2131623993, null);
    localView.setTag(new AccountPanelViewContainer.AccountItemViewHolder(localView));
    localView.setOnClickListener(this.x);
    localView.setOnTouchListener(new OnlineStatusUtil.MyTouchViewOnTouchListener(localView.findViewById(2131429039)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(64.0F), -2);
    this.l.addView(localView, localLayoutParams);
    return localView;
  }
  
  public void l()
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    int i2 = ((LinearLayout)localObject1).getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.l.getChildAt(i1);
      localObject1 = (String)((View)localObject2).getTag(a);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((View)localObject2).getTag() instanceof AccountPanelViewContainer.AccountItemViewHolder)))
      {
        localObject2 = (AccountPanelViewContainer.AccountItemViewHolder)((View)localObject2).getTag();
        if (((AccountPanelViewContainer.AccountItemViewHolder)localObject2).g == 1)
        {
          AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
          ((AccountPanelViewContainer.AccountItemViewHolder)localObject2).a(((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getLocalThirdUnreadMsgNum(localAppInterface, (String)localObject1), false);
        }
      }
      i1 += 1;
    }
  }
  
  public void m()
  {
    if (this.e == null)
    {
      localObject = this.v;
      this.e = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
      this.e.c(true);
    }
    this.e.c(2131892360);
    Object localObject = this.e;
    if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing()) && (!this.v.isFinishing())) {
      this.e.show();
    }
  }
  
  public void n()
  {
    QQProgressDialog localQQProgressDialog = this.e;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.e.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void o()
  {
    this.q.a(this.v);
    this.g.a();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131445159)
    {
      this.t.a(true);
    }
    else if (i1 == 2131436364)
    {
      IAccountPanel.OnAccountExitListener localOnAccountExitListener = this.s;
      if (localOnAccountExitListener != null) {
        localOnAccountExitListener.a();
      }
      ReportHelperKt.a("0X800AF3C");
    }
    else if (i1 == 2131431541)
    {
      this.t.a(paramView);
    }
    else if (i1 == 2131431544)
    {
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.v, "panel");
      ReportHelperKt.a("0X800AF42", 1);
    }
    else if (i1 == 2131436250)
    {
      this.t.b();
    }
    else if (i1 == 2131439104)
    {
      this.t.b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    this.q.c();
  }
  
  public void q()
  {
    Object localObject = BaseApplication.getContext();
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getResources();
    if (localObject == null) {
      return;
    }
    ImageView localImageView;
    if (QQTheme.isNowThemeIsNight())
    {
      localImageView = this.c;
      if (localImageView != null) {
        localImageView.setImageDrawable(((Resources)localObject).getDrawable(2130837632));
      }
      localImageView = this.d;
      if (localImageView != null) {
        localImageView.setImageDrawable(((Resources)localObject).getDrawable(2130837634));
      }
    }
    else
    {
      localImageView = this.c;
      if (localImageView != null) {
        localImageView.setImageDrawable(((Resources)localObject).getDrawable(2130837631));
      }
      localImageView = this.d;
      if (localImageView != null) {
        localImageView.setImageDrawable(((Resources)localObject).getDrawable(2130837633));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer
 * JD-Core Version:    0.7.0.1
 */