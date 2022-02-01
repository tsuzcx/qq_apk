package com.tencent.mobileqq.onlinestatus;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout.AccountPanelRootLayoutListener;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView.OnDismissCallback;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountControll.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class AccountPanel
  extends BaseStatusCardView
  implements View.OnClickListener, OnLineStatusBlurBg.OnLineStatusBlurBgListener, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, AccountPanelRootLayout.AccountPanelRootLayoutListener, BaseStatusCardView.OnDismissCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AccountPanel.6(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AccountPanel.10(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AccountPanel.12(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new AccountPanel.11(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AccountPanel.9(this);
  private AccountPanel.OnAccountExitListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnAccountExitListener;
  private AccountPanel.OnlineStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener;
  private OnBatteryChangeObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver = new AccountPanel.13(this);
  private OnLineStatusBlurBg jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg;
  private OnLineStatusCustomSmartViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl = new OnLineStatusCustomSmartViewCtrl(true, true);
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AccountPanel.17(this);
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = new OnlineStatusPanelParams();
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AccountPanel.18(this);
  private OnlineStatusResDownLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader;
  private OnlineStatusViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private StatusCardViewHolder jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder = new StatusCardViewHolder();
  private WeatherObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = new AccountPanel.19(this);
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanel.15(this);
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new AccountPanel.14(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AccountPanel.16(this);
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  private View e;
  private View f;
  
  public AccountPanel(@android.support.annotation.NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity, null);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558428, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365291);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361929);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365329));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372088);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372089));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361898));
    this.f = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377931);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361900));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(AIOUtils.a(48.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372525));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361926));
    this.e = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369557);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369649));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg = new OnLineStatusBlurBg();
    a(new float[] { 0.5F, 0.0F });
  }
  
  private int a()
  {
    int j = ((SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER)).b().size();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
    int i = j;
    if (localList != null)
    {
      i = j;
      if (localList.size() > 0) {
        i = j + 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "getRequestNum: " + i);
    }
    return i;
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558429, null);
    localView.setTag(new AccountPanel.AccountItemViewHolder(this, localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new OnlineStatusUtil.MyTouchViewOnTouchListener(localView.findViewById(2131363231)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  private AccountPanel.AccountItemViewHolder a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i;
    View localView;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      if (i < j)
      {
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (!paramString.equals((String)localView.getTag(2131361927))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (AccountPanel.AccountItemViewHolder)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(View paramView, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, paramLong);
  }
  
  private void a(AccountPanel.AccountItemViewHolder paramAccountItemViewHolder, SubAccountInfo paramSubAccountInfo, View paramView)
  {
    paramAccountItemViewHolder.a(2);
    paramAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    paramAccountItemViewHolder.a(ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    SubAccountControll.SubAccountUnReadItem localSubAccountUnReadItem = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localSubAccountUnReadItem.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      paramAccountItemViewHolder.a(localSubAccountUnReadItem.jdField_a_of_type_Int, localSubAccountUnReadItem.jdField_a_of_type_Boolean);
      paramAccountItemViewHolder.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label127;
      }
      paramAccountItemViewHolder.b(true);
    }
    for (;;)
    {
      paramView.setTag(2131361927, paramSubAccountInfo.subuin);
      paramView.setTag(2131361897, paramSubAccountInfo);
      return;
      paramAccountItemViewHolder.a(0, false);
      break;
      label127:
      paramAccountItemViewHolder.b(false);
    }
  }
  
  private void a(AccountPanel.AccountItemViewHolder paramAccountItemViewHolder, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramAccountItemViewHolder.a(1);
    paramAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    paramAccountItemViewHolder.a(SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    paramAccountItemViewHolder.a(SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()), false);
    paramAccountItemViewHolder.a(false);
    paramAccountItemViewHolder.b(false);
    paramView.setTag(2131361927, paramSimpleAccount.getUin());
    paramView.setTag(2131361897, paramSimpleAccount);
    paramView.setTag(paramAccountItemViewHolder);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, new Object[] { "[foreground] closeAccountPanelRecursive: invoked. ", " reason: ", paramString });
    }
    if ((BaseActivity.sTopActivity != null) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      paramString = FrameHelperActivity.a(BaseActivity.sTopActivity);
      if (paramString != null)
      {
        paramString = paramString.a;
        if ((paramString != null) && (paramString.isShowing())) {
          paramString.d();
        }
      }
    }
  }
  
  private void a(List<Object> paramList)
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
    int i;
    if (k < j)
    {
      m = 1;
      if (m == 0) {
        break label90;
      }
      i = k;
      label57:
      if (m == 0) {
        break label95;
      }
    }
    for (;;)
    {
      if (m == 0) {
        break label101;
      }
      while (i < j)
      {
        a();
        i += 1;
      }
      m = 0;
      break;
      label90:
      i = j;
      break label57;
      label95:
      j = k;
    }
    label101:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(i, j - i);
    b(paramList);
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_ONLINE_STATUS", paramStatus);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", paramLong);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, AccountOnlineStateActivity.class, 234);
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(paramStatus, paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean1) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_Int -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { " mRequestNum=", Integer.valueOf(this.jdField_a_of_type_Int), " subAccountMsgComing=", Boolean.valueOf(paramBoolean2) });
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_b_of_type_Boolean) {
          p();
        }
      }
    }
    while (!paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramString);
      return;
    }
    u();
  }
  
  private boolean a()
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(localStatus, this.jdField_a_of_type_Long);
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    OnLineStatusHelper localOnLineStatusHelper = OnLineStatusHelper.a();
    if (localOnlineStatusItem.jdField_a_of_type_Long > 0L)
    {
      bool = true;
      if ((localOnLineStatusHelper.a(localOnlineStatusItem, localFriends, bool)) || (localStatus != AppRuntime.Status.online)) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "isDisplayOnline ", " useFallbackOnlineText: ", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  private boolean a(long paramLong)
  {
    boolean bool1 = OnLineStatusHelper.a(AppRuntime.Status.online, this.jdField_b_of_type_Long);
    boolean bool2 = OnLineStatusHelper.a(AppRuntime.Status.online, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(this.jdField_b_of_type_Long), " curExtID=", Long.valueOf(paramLong) });
    }
    if ((paramLong == this.jdField_a_of_type_Long) && (AppRuntime.Status.online == this.jdField_a_of_type_MqqAppAppRuntime$Status) && (bool2))
    {
      QLog.d("AccountPanel", 2, "refreshPanelWhenMoodChange curStatus is equal");
      return true;
    }
    if (!bool2) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_d_of_type_Boolean = false;
    }
    if (!isShowing())
    {
      QLog.d("AccountPanel", 2, "refreshPanelWhenMoodChange dialog not showing");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) && ((bool2) || (bool1)))
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(true, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      n();
      return true;
    }
    return false;
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramOnlineStatusItem.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramSubAccountBackProtocData == null) || (android.text.TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramSubAccountThirdQQBackProtocData == null) || (android.text.TextUtils.isEmpty(paramString)))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return true;
    }
    if (!android.text.TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    int i = 1;
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719505, 1).a();
      return;
    }
    if (a())
    {
      ReportHelperKt.a("0X800B0F2", 1);
      CustomOnlineStatusManager.Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
    }
    do
    {
      for (;;)
      {
        OnlineStatusDataReporter.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
        return;
        if (this.jdField_a_of_type_Long == 1040L)
        {
          ReportHelperKt.a("0X800B0F2", 3);
          ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ConstellationUtilKt.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 4013);
        }
        else if (this.jdField_a_of_type_Long == 1030L)
        {
          ReportHelperKt.a("0X800B0F2", 4);
          paramView = (OnlineAutoStatusBean)QConfigManager.a().a(652);
          Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((paramView != null) && (paramView.a != null) && (!android.text.TextUtils.isEmpty(paramView.a.jdField_a_of_type_JavaLangString)) && (OnlineStatusUtil.a(localFriends)))
          {
            paramView = paramView.a.jdField_a_of_type_JavaLangString + localFriends.adCode;
            ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 4013);
          }
        }
        else
        {
          if (this.jdField_a_of_type_MqqAppAppRuntime$Status != AppRuntime.Status.online) {
            break;
          }
          a(paramView, this.jdField_a_of_type_Long);
          OnlineStatusDataReporter.a(this.jdField_a_of_type_Long);
        }
      }
    } while (!OnlineStatusConstants.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.away) {}
    for (;;)
    {
      ReportHelperKt.a("0X800B6BB", i);
      a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      break;
      if (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.busy) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  private void b(String paramString)
  {
    AccountPanel.AccountItemViewHolder localAccountItemViewHolder = a(paramString);
    if (localAccountItemViewHolder != null)
    {
      paramString = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localAccountItemViewHolder.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
    }
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      AccountPanel.AccountItemViewHolder localAccountItemViewHolder = (AccountPanel.AccountItemViewHolder)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof SubAccountInfo)) {
        a(localAccountItemViewHolder, (SubAccountInfo)localObject, localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof SimpleAccount)) {
          a(localAccountItemViewHolder, (SimpleAccount)localObject, localView);
        }
      }
    }
  }
  
  private void b(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    String str1 = OnLineStatusHelper.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698440, new Object[] { str1 });
    String str2 = ((AutoReplyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(ViewUtils.d(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131698435;; i = 2131698431)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131698438, new AccountPanel.4(this, paramStatus, paramLong));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131698426, new AccountPanel.5(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131698429;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = com.tencent.mobileqq.text.TextUtils.subQQTextString(str2, (Paint)localObject1, 3, 16, (int)(AIOUtils.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new AccountPanel.2(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView().setAccessibilityDelegate(new AccountPanel.3(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131698439;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "removeObservers");
      }
    }
  }
  
  private void n()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a((AppRuntime.Status)localObject3, l);
    Object localObject1 = OnLineStatusHelper.a().a(localOnlineStatusItem);
    Object localObject2;
    boolean bool;
    if (localObject3 == AppRuntime.Status.online)
    {
      localObject2 = OnLineStatusHelper.a();
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localOnlineStatusItem.jdField_a_of_type_Long > 0L)
      {
        bool = true;
        localObject2 = ((OnLineStatusHelper)localObject2).a((QQAppInterface)localObject4, localFriends, localTextView, 3, localOnlineStatusItem, Boolean.valueOf(bool));
        label125:
        if (localObject1 != AppRuntime.Status.online) {
          break label334;
        }
        localObject4 = OnLineStatusHelper.a();
        if (localOnlineStatusItem.jdField_a_of_type_Long <= 0L) {
          break label328;
        }
        bool = true;
        label151:
        if (((OnLineStatusHelper)localObject4).a(localOnlineStatusItem, localFriends, bool)) {
          break label334;
        }
        localObject3 = OnLineStatusHelper.a().a(0L, AppRuntime.Status.online, 1, localFriends);
        label180:
        if ((l != 1030L) && (l != 1040L) && (!a()) && (!OnLineStatusHelper.a((AppRuntime.Status)localObject1, l))) {
          break label369;
        }
        if (!ThemeImageWrapper.isNightMode()) {
          break label351;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841636);
        label233:
        int i = AIOUtils.a(16.0F, BaseApplicationImpl.getContext().getResources());
        ((Drawable)localObject1).setBounds(0, 0, i, i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(0.0F, getContext().getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, (Drawable)localObject1, null);
      return;
      bool = false;
      break;
      localObject2 = OnLineStatusHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localOnlineStatusItem, (AppRuntime.Status)localObject1, localFriends, this.jdField_a_of_type_AndroidWidgetTextView, 3);
      break label125;
      label328:
      bool = false;
      break label151;
      label334:
      localObject3 = OnLineStatusHelper.a().a(l, (AppRuntime.Status)localObject3, 1, localFriends);
      break label180;
      label351:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839413);
      break label233;
      label369:
      localObject1 = null;
    }
  }
  
  private void o()
  {
    if (ThemeImageWrapper.isNightMode())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private void p()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = ((SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER)).b();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      localObject2 = localArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!android.text.TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin)))
        {
          ((List)localObject1).add(localObject3);
          localArrayList2.add(((SubAccountInfo)localObject3).subuin);
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((SubAccountInfo)localObject3).subuin }));
          }
        }
      }
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
    Object localObject2 = new ArrayList();
    if (localObject3 != null) {
      ((List)localObject2).addAll((Collection)localObject3);
    }
    String str1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject3 = ((List)localObject2).iterator();
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    }
    label256:
    label281:
    label294:
    label681:
    label689:
    for (;;)
    {
      int i;
      int j;
      if (((Iterator)localObject3).hasNext())
      {
        if (localArrayList2.size() >= 7) {
          QLog.d("AccountPanel", 1, "add account exceed the limit");
        }
      }
      else
      {
        a((List)localObject1);
        if (QLog.isColorLevel())
        {
          if (localObject2 == null) {
            break label626;
          }
          i = ((List)localObject2).size();
          if (localArrayList1 == null) {
            break label631;
          }
          j = localArrayList1.size();
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0) {
          break label636;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698424);
        label345:
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          break label649;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.e.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.e.getId());
        boolean bool = OnlineStatusUtil.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label674;
        }
        i = 2130841634;
        label446:
        localObject1 = this.f;
        if (!bool) {
          break label681;
        }
        label456:
        ((View)localObject1).setBackgroundResource(i);
        OnLineStatusCustomSmartViewCtrl.a(this.jdField_c_of_type_AndroidViewView, false, null, true);
        OnLineStatusCustomSmartViewCtrl.a(this.jdField_d_of_type_AndroidViewView, false, null, true);
        return;
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject3).next();
      if ((!android.text.TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str1)))
      {
        Iterator localIterator = localArrayList2.iterator();
        String str2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str2 = (String)localIterator.next();
        } while (!localSimpleAccount.getUin().equals(str2));
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label689;
          }
          ((List)localObject1).add(localSimpleAccount);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { localSimpleAccount.getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label256;
          label626:
          i = 0;
          break label281;
          label631:
          j = 0;
          break label294;
          label636:
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698425);
          break label345;
          this.e.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          break label412;
          i = 2130841633;
          break label446;
          i = 0;
          break label456;
        }
      }
    }
  }
  
  private void q()
  {
    p();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.h = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.i = 0;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    for (;;)
    {
      c();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      return;
      AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(true, localStatus, l);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      CustomOnlineStatusManager.a().a(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "addObservers");
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader = new OnlineStatusResDownLoader();
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader = null;
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        String str = (String)((View)localObject).getTag(2131361927);
        if ((!android.text.TextUtils.isEmpty(str)) && ((((View)localObject).getTag() instanceof AccountPanel.AccountItemViewHolder)))
        {
          localObject = (AccountPanel.AccountItemViewHolder)((View)localObject).getTag();
          if (((AccountPanel.AccountItemViewHolder)localObject).jdField_a_of_type_Int == 1) {
            ((AccountPanel.AccountItemViewHolder)localObject).a(SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str), false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.c();
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100) {
      OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, true);
    }
    do
    {
      return;
      if ((paramInt1 == 299) || (paramInt1 == 234))
      {
        c();
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramInt1, paramInt2, paramIntent));
    n();
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 40001L) {
      this.jdField_c_of_type_Boolean = OnlineStatusItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    while (!OnLineStatusHelper.a(AppRuntime.Status.online, paramLong)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_d_of_type_Boolean = true;
  }
  
  public void a(View paramView)
  {
    b(true);
  }
  
  public void a(AccountPanel.OnAccountExitListener paramOnAccountExitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnAccountExitListener = paramOnAccountExitListener;
  }
  
  public void a(AccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener = paramOnlineStatusChangedListener;
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719505, 1).a();
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    AppRuntime.Status localStatus;
    do
    {
      for (;;)
      {
        return;
        localStatus = OnLineStatusHelper.a().a(paramOnlineStatusItem2);
        paramOnlineStatusItem1 = OnLineStatusHelper.a().a(paramOnlineStatusItem1);
        if ((localStatus == null) || (paramOnlineStatusItem2 == null) || (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg, this, paramOnlineStatusItem2.jdField_a_of_type_Long)))
        {
          if ((localStatus == null) || (paramOnlineStatusItem2 == null) || (a(paramOnlineStatusItem2, localStatus))) {
            break;
          }
          OnlineStatusDataReporter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
          paramView = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
          boolean bool = paramView.getBoolean("has_set_battery", false);
          if ((OnLineStatusHelper.a().a(paramOnlineStatusItem2)) && (!bool))
          {
            paramView.edit().putBoolean("has_set_battery", true).apply();
            b(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramOnlineStatusItem1, localStatus, Long.valueOf(paramOnlineStatusItem2.jdField_a_of_type_Long) }));
            return;
            if (OnlineStatusConstants.a(localStatus))
            {
              b(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
            }
            else if ((paramOnlineStatusItem2.jdField_a_of_type_Long == 1028L) && (!OnlineMusicStatusManager.a()))
            {
              OnlineMusicStatusManager.a();
              b(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
            }
            else
            {
              a(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long, true);
            }
          }
        }
      }
    } while ((!a(paramOnlineStatusItem2, localStatus)) || (!OnlineStatusConstants.a(localStatus)));
    int i;
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.away) {
      i = 1;
    }
    for (;;)
    {
      ReportHelperKt.a("0X800B754", i);
      a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.busy) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692257), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    i();
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.switchAccount(paramSimpleAccount, null);
    SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AlbumUtil.b();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    SubAccountControll.SubAccountUnReadItem localSubAccountUnReadItem = SubAccountControll.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localSubAccountUnReadItem.jdField_a_of_type_Int <= 0) || (localSubAccountUnReadItem.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localSubAccountUnReadItem.jdField_a_of_type_Int > 0) {
        ThreadManagerV2.executeOnSubThread(new AccountPanel.7(this, paramQQAppInterface, paramSimpleAccount));
      }
      return;
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setBackgroundColor(paramInt);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView.getWidth() != 0) && (this.jdField_b_of_type_AndroidViewView.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getWidth();
      paramArrayOfInt[1] = this.jdField_b_of_type_AndroidViewView.getHeight();
      return;
    }
    paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfInt[1] = AIOUtils.a(554.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (SubAccountControll.a(paramQQAppInterface, paramSimpleAccount)))
    {
      a(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void az_()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    t();
    d(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return OnLineStatusHelper.a().a(localStatus, l);
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    b(false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a();
    if (!paramBoolean)
    {
      m();
      return;
    }
    dismiss();
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    return null;
  }
  
  public void c()
  {
    if (!isShowing()) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    this.jdField_a_of_type_Long = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    }
    n();
  }
  
  public void c(boolean paramBoolean)
  {
    float f6 = 1.0F;
    float f1;
    float f2;
    label17:
    float f3;
    label24:
    float f4;
    label31:
    float f5;
    if (paramBoolean)
    {
      f1 = 0.5F;
      if (!paramBoolean) {
        break label235;
      }
      f2 = 1.0F;
      if (!paramBoolean) {
        break label242;
      }
      f3 = 0.0F;
      if (!paramBoolean) {
        break label248;
      }
      f4 = 1.0F;
      if (!paramBoolean) {
        break label254;
      }
      f5 = 0.02F;
      label40:
      if (!paramBoolean) {
        break label260;
      }
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { f1, f2 });
      localObjectAnimator1.setDuration(230L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { f1, f2 });
      localObjectAnimator2.setDuration(230L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { f5, f6 });
      if (paramBoolean) {
        localObjectAnimator3.setStartDelay(70L);
      }
      localObjectAnimator3.setDuration(70L);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { f3, f4 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
      return;
      f1 = 1.0F;
      break;
      label235:
      f2 = 0.5F;
      break label17;
      label242:
      f3 = 1.0F;
      break label24;
      label248:
      f4 = 0.0F;
      break label31;
      label254:
      f5 = 1.0F;
      break label40;
      label260:
      f6 = 0.02F;
    }
  }
  
  public void d()
  {
    try
    {
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AccountPanel", 1, "dismissRecursive: failed. ", localException);
    }
  }
  
  public void e()
  {
    super.e();
    d(false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
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
  
  public void k()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.b();
    t();
    b(false);
    SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.b();
    t();
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719592)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719591));
      localQQCustomDialog.setPositiveButton(2131691144, new AccountPanel.8(this));
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.show();
    }
  }
  
  public void onBackPressed()
  {
    b(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(true);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnAccountExitListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnAccountExitListener.a();
      }
      ReportHelperKt.a("0X800AF3C");
      continue;
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719505, 1).a();
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null) {
          this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        }
      }
      else
      {
        a(paramView, 40001L);
        continue;
        CustomOnlineStatusManager.Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
        ReportHelperKt.a("0X800AF42", 1);
        continue;
        if (Utils.c())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693892, 0).a();
        }
        else if (!PwdSetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
          localIntent.addFlags(536870912);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771999, 2130771979);
          SubAccountAssistantForward.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
          ReportHelperKt.a("0X800AF3B");
          continue;
          b(paramView);
        }
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, @androidx.annotation.NonNull KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    s();
    this.jdField_c_of_type_Boolean = true;
    if (ThemeUtil.isNowThemeIsNight(null, false, "")) {
      a(false, null, Color.parseColor("#FF010101"));
    }
    for (;;)
    {
      super.show();
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      r();
      q();
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.1(this));
      Object localObject = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusCustomSmartViewCtrl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((OnlineStatusPermissionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
      b(true);
      return;
      localObject = new OnLineStatusBlurBg.BlurBgItem();
      ((OnLineStatusBlurBg.BlurBgItem)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg.a((OnLineStatusBlurBg.BlurBgItem)localObject, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel
 * JD-Core Version:    0.7.0.1
 */