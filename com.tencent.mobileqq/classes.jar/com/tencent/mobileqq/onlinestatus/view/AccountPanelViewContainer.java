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
  public static final int a = 2131361933;
  public static final int b = 2131361903;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AccountPanelViewContainer.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private AccountPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel;
  private IAccountPanel.OnAccountExitListener jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnAccountExitListener;
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private OnLineStatusCustomSmartViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl = new OnLineStatusCustomSmartViewCtrl(true, true);
  private AccountPanelBinder jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  public QQProgressDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanelViewContainer.1(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  private View d;
  
  public AccountPanelViewContainer(QBaseActivity paramQBaseActivity, AccountPanel paramAccountPanel, AccountPanelBinder paramAccountPanelBinder)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder = paramAccountPanelBinder;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel = paramAccountPanel;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  private AccountPanelViewContainer.AccountItemViewHolder a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = null;
    if (bool) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getChildCount() > 0))
    {
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (paramString.equals((String)((View)localObject).getTag(jdField_a_of_type_Int)))
        {
          paramString = (String)localObject;
          break label93;
        }
        i += 1;
      }
    }
    paramString = null;
    label93:
    if (paramString != null) {
      localAccountItemViewHolder = (AccountPanelViewContainer.AccountItemViewHolder)paramString.getTag();
    }
    return localAccountItemViewHolder;
  }
  
  private void a(AccountPanelViewContainer.AccountItemViewHolder paramAccountItemViewHolder, ISubAccountApi.SubAccountInfoProxy paramSubAccountInfoProxy, View paramView)
  {
    paramAccountItemViewHolder.a(2);
    paramAccountItemViewHolder.a(FaceDrawable.getFaceDrawable((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), 1, paramSubAccountInfoProxy.a()));
    paramAccountItemViewHolder.a(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramSubAccountInfoProxy.a(), false));
    ISubAccountApi.SubAccountUnReadItemProxy localSubAccountUnReadItemProxy = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramSubAccountInfoProxy.a());
    if ((localSubAccountUnReadItemProxy.a() > 0) && (paramSubAccountInfoProxy.a() == 1)) {
      paramAccountItemViewHolder.a(localSubAccountUnReadItemProxy.a(), localSubAccountUnReadItemProxy.a());
    } else {
      paramAccountItemViewHolder.a(0, false);
    }
    paramAccountItemViewHolder.a(true);
    if (paramSubAccountInfoProxy.a() != 1) {
      paramAccountItemViewHolder.b(true);
    } else {
      paramAccountItemViewHolder.b(false);
    }
    paramView.setTag(jdField_a_of_type_Int, paramSubAccountInfoProxy.a());
    paramView.setTag(jdField_b_of_type_Int, paramSubAccountInfoProxy);
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
    paramView.setTag(jdField_a_of_type_Int, paramSimpleAccount.getUin());
    paramView.setTag(jdField_b_of_type_Int, paramSimpleAccount);
    paramView.setTag(paramAccountItemViewHolder);
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = (AccountPanelViewContainer.AccountItemViewHolder)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof ISubAccountApi.SubAccountInfoProxy)) {
        a(localAccountItemViewHolder, (ISubAccountApi.SubAccountInfoProxy)localObject, localView);
      } else if ((localObject instanceof SimpleAccount)) {
        a(localAccountItemViewHolder, (SimpleAccount)localObject, localView);
      }
      i += 1;
    }
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558457, null);
    localView.setTag(new AccountPanelViewContainer.AccountItemViewHolder(localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new OnlineStatusUtil.MyTouchViewOnTouchListener(localView.findViewById(2131363165)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  public View a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558456, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361935);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365203));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371680);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371681));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361904));
    this.d = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377354);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361906));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(Utils.a(48.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372110));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361932));
    this.c = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369271);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369349));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    if (paramInt == 2) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  }
  
  public LinearLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public OnLineStatusBlurBg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(false);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      a(false, null, Color.parseColor("#FF010101"));
      return;
    }
    OnLineStatusBlurBg.BlurBgItem localBlurBgItem = new OnLineStatusBlurBg.BlurBgItem();
    localBlurBgItem.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a(localBlurBgItem, this);
  }
  
  public void a(IAccountPanel.OnAccountExitListener paramOnAccountExitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnAccountExitListener = paramOnAccountExitListener;
  }
  
  public void a(String paramString)
  {
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = a(paramString);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAccountItemViewHolder != null)
    {
      Object localObject = null;
      if (localAccountItemViewHolder.jdField_a_of_type_Int == 2)
      {
        paramString = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(paramString, false);
      }
      else
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)localAccountItemViewHolder.jdField_a_of_type_AndroidViewView.getTag(jdField_b_of_type_Int);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(Utils.a(0.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable1, null, paramDrawable2, null);
  }
  
  public void a(List<Object> paramList)
  {
    int j = paramList.size();
    if (j <= 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (k == j)
    {
      b(paramList);
      return;
    }
    int m;
    if (k < j) {
      m = 1;
    } else {
      m = 0;
    }
    int i;
    if (m != 0) {
      i = k;
    } else {
      i = j;
    }
    if (m == 0) {
      j = k;
    }
    if (m != 0) {
      while (i < j)
      {
        a();
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(i, j - i);
    b(paramList);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramStatus, paramLong);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null))
    {
      AccountPanelRootLayout localAccountPanelRootLayout = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
      if (localAccountPanelRootLayout != null)
      {
        localAccountPanelRootLayout.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        return;
      }
    }
    paramBitmap = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
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
        i = 1;
      } else {
        i = 0;
      }
      int j = paramResources.getDisplayMetrics().widthPixels;
      if (i != 0) {
        i = 2;
      } else {
        i = 1;
      }
      int i = Utils.a(i * 64 + 62, paramResources);
      boolean bool;
      if (Utils.a(64.0F, paramResources) * paramInt > j - i) {
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
  
  public boolean a(long paramLong)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = ((IOnlineStatusService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(localStatus, paramLong);
    localObject = ((IFriendDataService)((AppRuntime)localObject).getRuntimeService(IFriendDataService.class, "")).getFriend(((AppRuntime)localObject).getCurrentUin(), true, true);
    OnLineStatusHelper localOnLineStatusHelper = OnLineStatusHelper.a();
    boolean bool;
    if (localOnlineStatusItem.a > 0L) {
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
  
  public void b() {}
  
  public void b(String paramString)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = a(paramString);
    if (localAccountItemViewHolder != null) {
      localAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(localAppInterface, 1, paramString));
    }
  }
  
  public void c()
  {
    ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).registerChangeWeakListener(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c(String paramString)
  {
    AccountPanelViewContainer.AccountItemViewHolder localAccountItemViewHolder = a(paramString);
    if (localAccountItemViewHolder != null)
    {
      paramString = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramString);
      localAccountItemViewHolder.a(paramString.a(), paramString.a());
    }
  }
  
  public void d()
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Drawable localDrawable = null;
    localObject1 = ((MobileQQ)localObject1).waitAppRuntime(null);
    Object localObject2 = ((IOnlineStatusService)((AppRuntime)localObject1).getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a((AppRuntime)localObject1);
    Friends localFriends = ((IFriendDataService)((AppRuntime)localObject1).getRuntimeService(IFriendDataService.class, "")).getFriend(((AppRuntime)localObject1).getCurrentUin(), true, true);
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a((AppRuntime.Status)localObject2, l);
    Object localObject3 = OnLineStatusHelper.a().a(localOnlineStatusItem);
    OnLineStatusHelper localOnLineStatusHelper;
    boolean bool;
    if (localObject2 == AppRuntime.Status.online)
    {
      localOnLineStatusHelper = OnLineStatusHelper.a();
      TextView localTextView = a();
      if (localOnlineStatusItem.a > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      localObject1 = localOnLineStatusHelper.a((AppRuntime)localObject1, localFriends, localTextView, 3, localOnlineStatusItem, Boolean.valueOf(bool));
    }
    else
    {
      localObject1 = OnLineStatusHelper.a().b((AppRuntime)localObject1, localOnlineStatusItem, (AppRuntime.Status)localObject3, localFriends, a(), 3);
    }
    if (localObject3 == AppRuntime.Status.online)
    {
      localOnLineStatusHelper = OnLineStatusHelper.a();
      if (localOnlineStatusItem.a > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      if (!localOnLineStatusHelper.a(localOnlineStatusItem, localFriends, bool))
      {
        localObject2 = OnLineStatusHelper.a().a(0L, AppRuntime.Status.online, 1, localFriends);
        break label256;
      }
    }
    localObject2 = OnLineStatusHelper.a().a(l, (AppRuntime.Status)localObject2, 1, localFriends);
    label256:
    if ((l == 1030L) || (l == 1040L) || (a(l)) || (OnLineStatusHelper.a((AppRuntime.Status)localObject3, l)))
    {
      if (QQTheme.a()) {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130841521);
      } else {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839269);
      }
      localObject3 = MobileQQ.sMobileQQ;
      int i = Utils.a(16.0F, MobileQQ.getContext().getResources());
      localDrawable.setBounds(0, 0, i, i);
    }
    a((String)localObject1, (Drawable)localObject2, localDrawable);
  }
  
  public void e()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.removeAllViews();
    }
  }
  
  public void f()
  {
    if (QQTheme.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698490);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698491);
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() < 7)
    {
      this.c.setVisibility(0);
      this.c.setOnClickListener(this);
      this.c.setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
      ((RelativeLayout.LayoutParams)localObject).addRule(0, this.c.getId());
    }
    else
    {
      this.c.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
    }
    boolean bool = a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
    int i;
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
      i = 2130841519;
    } else {
      i = 2130841518;
    }
    localObject = this.d;
    if (!bool) {
      i = 0;
    }
    ((View)localObject).setBackgroundResource(i);
    OnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_AndroidViewView, false, null, true);
    OnLineStatusCustomSmartViewCtrl.a(this.jdField_b_of_type_AndroidViewView, false, null, true);
  }
  
  public void h()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      return;
    }
    int j = ((LinearLayout)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localObject1 = (String)((View)localObject2).getTag(jdField_a_of_type_Int);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((View)localObject2).getTag() instanceof AccountPanelViewContainer.AccountItemViewHolder)))
      {
        localObject2 = (AccountPanelViewContainer.AccountItemViewHolder)((View)localObject2).getTag();
        if (((AccountPanelViewContainer.AccountItemViewHolder)localObject2).jdField_a_of_type_Int == 1)
        {
          AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
          ((AccountPanelViewContainer.AccountItemViewHolder)localObject2).a(((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getLocalThirdUnreadMsgNum(localAppInterface, (String)localObject1), false);
        }
      }
      i += 1;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void j()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131376828)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(true);
    }
    else if (i == 2131369349)
    {
      IAccountPanel.OnAccountExitListener localOnAccountExitListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnAccountExitListener;
      if (localOnAccountExitListener != null) {
        localOnAccountExitListener.a();
      }
      ReportHelperKt.a("0X800AF3C");
    }
    else if (i == 2131365355)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(paramView);
    }
    else if (i == 2131365357)
    {
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "panel");
      ReportHelperKt.a("0X800AF42", 1);
    }
    else if (i == 2131369271)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.b();
    }
    else if (i == 2131371680)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer
 * JD-Core Version:    0.7.0.1
 */