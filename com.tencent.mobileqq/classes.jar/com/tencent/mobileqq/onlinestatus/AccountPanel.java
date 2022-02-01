package com.tencent.mobileqq.onlinestatus;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationUtilKt;
import com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView.OnDismissCallback;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModelFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountInfoProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AccountPanel
  extends BaseStatusCardView
  implements IAccountPanel, OnlineStatusPagerAdapter.OnStatusItemClickListener, OnlineStatusPanel.OnlineStatusPanelListener, BaseStatusCardView.OnDismissCallback
{
  private QBaseActivity a;
  private AppInterface b;
  private OnlineStatusPanelParams c = new OnlineStatusPanelParams();
  private OnlineStatusViewCtrl d;
  private StatusCardViewHolder e = new StatusCardViewHolder();
  private QQCustomDialog f;
  private OnlineStatusResDownLoader g;
  private AccountPanelViewModel h;
  private AccountPanelBinder o;
  private AccountPanelViewContainer p;
  private int q;
  private IAccountPanel.OnStatusChangeByUserListener r;
  
  public AccountPanel(@android.support.annotation.NonNull QBaseActivity paramQBaseActivity, int paramInt)
  {
    super(paramQBaseActivity, null);
    this.q = paramInt;
    this.a = paramQBaseActivity;
    this.b = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    paramQBaseActivity = n();
    this.i = paramQBaseActivity;
    this.j = paramQBaseActivity.findViewById(2131431319);
    a(new float[] { 0.5F, 0.0F });
  }
  
  private void a(View paramView, long paramLong)
  {
    this.e.a(paramView, this.a, this.p.f(), this, paramLong);
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus)
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.h.g().getValue();
    if ((paramStatus == AppRuntime.Status.online) && (localOnlineStatusData.a == AppRuntime.Status.online)) {
      return localOnlineStatusData.b == paramOnlineStatusItem.b;
    }
    return localOnlineStatusData.a == paramStatus;
  }
  
  private void c(AppRuntime.Status paramStatus, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_ONLINE_STATUS", paramStatus);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", paramLong);
    QPublicFragmentActivity.startForResult(this.a, localIntent, AccountOnlineStateActivity.class, 234);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAccountChanged AccountPanel-accountChangeSuccess ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("AccountPanel", 2, ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.a(null, "dc00898", "", "", "0X800BDEE", "0X800BDEE", 0, 0, (String)localObject, "", "", "");
  }
  
  private void d(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing()))
    {
      this.f.dismiss();
      this.f = null;
    }
    localObject1 = OnLineStatusHelper.a().a(paramLong, paramStatus);
    String str1 = this.a.getResources().getString(2131896448, new Object[] { localObject1 });
    String str2 = ((AutoReplyManagerImpl)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoReplyManager.class)).b().mRawText;
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(ViewUtils.spToPx(14.0F));
    int i;
    if ((paramLong != 1000L) && (paramLong != 1028L))
    {
      int j;
      if (paramStatus == AppRuntime.Status.dnd)
      {
        i = 4;
        j = 2131896437;
      }
      else
      {
        i = 3;
        j = 2131896447;
      }
      Object localObject3 = this.a.getResources().getString(j);
      str2 = com.tencent.mobileqq.text.TextUtils.subQQTextString(str2, (Paint)localObject2, 3, 16, (int)(ViewUtils.dpToPx(i * 242) - ((Paint)localObject2).measureText((String)localObject3)), true);
      str2 = AutoReplyText.trimRawString(this.a.getResources().getString(j, new Object[] { str2 }), true);
      localObject2 = new SpannableString(str2);
      localObject3 = new AccountPanel.1(this, paramStatus, paramLong);
      ((SpannableString)localObject2).setSpan(localObject3, str2.length() - 7, str2.length(), 33);
      this.f = DialogUtil.a(this.a, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText((CharSequence)localObject2, 3, 16)).setMessageMaxLine(i);
      if (AppSetting.e) {
        this.f.getMessageTextView().setAccessibilityDelegate(new AccountPanel.2(this, (ClickableSpan)localObject3));
      }
    }
    else
    {
      if (paramLong == 1000L) {
        i = 2131896443;
      } else {
        i = 2131896439;
      }
      str2 = this.a.getResources().getString(i);
      this.f = DialogUtil.a(this.a, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText(str2, 3, 16)).setMessageMaxLine(4);
    }
    if (!this.a.isFinishing()) {
      this.f.show();
    }
    this.f.setPositiveButton(2131896446, new AccountPanel.3(this, paramStatus, paramLong, (String)localObject1));
    this.f.setNegativeButton(2131896434, new AccountPanel.4(this));
    this.f.setCancelable(false);
    this.f.show();
  }
  
  private View n()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.a);
    this.h = ((AccountPanelViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, new AccountPanelViewModelFactory(this.b)).get(AccountPanelViewModel.class));
    this.o = new AccountPanelBinder();
    this.p = new AccountPanelViewContainer(this.a, this, this.o);
    View localView = this.p.a(this.q);
    this.o.a(localLifeCycleAndViewModelStoreOwner, this.h, this.p);
    this.o.a(localLifeCycleAndViewModelStoreOwner, this.h, this);
    this.o.b(localLifeCycleAndViewModelStoreOwner, this.h, this.p);
    this.o.c(localLifeCycleAndViewModelStoreOwner, this.h, this.p);
    this.o.d(localLifeCycleAndViewModelStoreOwner, this.h, this.p);
    this.o.e(localLifeCycleAndViewModelStoreOwner, this.h, this.p);
    this.o.a(localLifeCycleAndViewModelStoreOwner, this.h, this.p, this);
    this.o.a(localLifeCycleAndViewModelStoreOwner, this.h, this.p, this.a);
    this.o.b(localLifeCycleAndViewModelStoreOwner, this.h, this.p, this);
    this.o.a(localLifeCycleAndViewModelStoreOwner, this.h, this.p, this, this.c);
    this.o.c(localLifeCycleAndViewModelStoreOwner, this.h, this.p, this);
    this.o.b(localLifeCycleAndViewModelStoreOwner, this.h, this);
    return localView;
  }
  
  private void o()
  {
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().a(AppRuntime.Status.online, 1080L, false);
    if (!android.text.TextUtils.isEmpty(localOnlineStatusItem.n))
    {
      OnlineStatusOlympicManager localOnlineStatusOlympicManager = (OnlineStatusOlympicManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class);
      QBaseActivity localQBaseActivity = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localOnlineStatusItem.n);
      localStringBuilder.append("&from=");
      localStringBuilder.append(1);
      localOnlineStatusOlympicManager.a(localQBaseActivity, localStringBuilder.toString());
    }
  }
  
  private void p()
  {
    this.h.o();
    Object localObject;
    if (this.d == null)
    {
      localObject = this.c;
      ((OnlineStatusPanelParams)localObject).a = 1;
      ((OnlineStatusPanelParams)localObject).i = this.a.getResources().getDisplayMetrics().widthPixels;
      this.c.l = 0;
      this.d = new OnlineStatusViewCtrl(this.a, this.p.e(), this, this.c, this);
      this.d.a();
    }
    else
    {
      localObject = ((IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l = OnLineStatusHelper.a().a(this.b);
      this.d.a(true, (AppRuntime.Status)localObject, l);
    }
    this.h.i().setValue(Boolean.valueOf(true));
    if ((this.h.g() != null) && (this.h.g().getValue() != null))
    {
      localObject = this.h;
      ((AccountPanelViewModel)localObject).a(((OnlineStatusData)((AccountPanelViewModel)localObject).g().getValue()).b);
      return;
    }
    if (this.h.g() == null) {
      localObject = "null";
    } else {
      localObject = this.h.g();
    }
    QLog.e("AccountPanel", 1, new Object[] { "data: ", localObject });
  }
  
  private void q()
  {
    QLog.d("AccountPanel", 2, "report on Account pannel show");
    ReportController.b(this.b, "dc00898", "", "", "0X800BDEC", "0X800BDEC", 0, 0, "", "", "", "");
  }
  
  private void r()
  {
    if (this.g == null) {
      this.g = new OnlineStatusResDownLoader();
    }
    this.g.a(this.b);
  }
  
  private void s()
  {
    OnlineStatusResDownLoader localOnlineStatusResDownLoader = this.g;
    if (localOnlineStatusResDownLoader != null)
    {
      localOnlineStatusResDownLoader.a();
      this.g = null;
    }
  }
  
  public void a()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.d;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null)
    {
      OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.h.g().getValue();
      this.d.a(localOnlineStatusData.a, localOnlineStatusData.b);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.a, MobileQQ.sMobileQQ.peekAppRuntime(), true);
      return;
    }
    if ((paramInt1 != 299) && (paramInt1 != 234))
    {
      if (this.e.a(paramInt1, paramInt2, paramIntent)) {
        this.p.d();
      }
    }
    else {
      this.h.i().setValue(Boolean.valueOf(true));
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (paramLong == 40001L)
    {
      localObject = (IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "");
      this.h.c(OnlineStatusItem.a(((IOnlineStatusService)localObject).getOnlineStatus(), OnLineStatusHelper.a().a(this.b)));
    }
    else if (OnLineStatusHelper.c(AppRuntime.Status.online, paramLong))
    {
      this.c.m = true;
    }
    if (this.r != null)
    {
      localObject = OnLineStatusHelper.a().a(AppRuntime.Status.online, paramLong, false);
      this.r.a(((OnlineStatusItem)localObject).c);
    }
  }
  
  public void a(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, 2131916775, 1).show();
      if (this.d != null)
      {
        paramView = (OnlineStatusData)this.h.g().getValue();
        this.d.a(paramView.a, paramView.b);
      }
      return;
    }
    a(paramView, 40001L);
  }
  
  public void a(IAccountPanel.OnAccountExitListener paramOnAccountExitListener)
  {
    this.p.a(paramOnAccountExitListener);
  }
  
  public void a(IAccountPanel.OnStatusChangeByUserListener paramOnStatusChangeByUserListener)
  {
    this.r = paramOnStatusChangeByUserListener;
  }
  
  public void a(IAccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener)
  {
    this.h.a(paramOnlineStatusChangedListener);
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, 2131916775, 1).show();
      if (this.d != null)
      {
        paramOnlineStatusItem1 = (OnlineStatusData)this.h.g().getValue();
        this.p.a(paramOnlineStatusItem1.a, paramOnlineStatusItem1.b);
        this.d.a(paramOnlineStatusItem1.a, paramOnlineStatusItem1.b);
      }
      return;
    }
    AppRuntime.Status localStatus = OnLineStatusHelper.a().b(paramOnlineStatusItem2);
    paramOnlineStatusItem1 = OnLineStatusHelper.a().b(paramOnlineStatusItem1);
    if ((localStatus != null) && (paramOnlineStatusItem2 != null) && (this.e.a(paramView, this.a, this.p.f(), this, paramOnlineStatusItem2.b))) {
      return;
    }
    int i = 3;
    if ((localStatus != null) && (paramOnlineStatusItem2 != null) && (!a(paramOnlineStatusItem2, localStatus)))
    {
      OnlineStatusDataReporter.b(this.b, localStatus, paramOnlineStatusItem2.b);
      paramView = MobileQQ.sMobileQQ.getSharedPreferences("online_battery", 0);
      boolean bool = paramView.getBoolean("has_set_battery", false);
      if ((OnLineStatusHelper.a().a(paramOnlineStatusItem2)) && (!bool))
      {
        paramView.edit().putBoolean("has_set_battery", true).apply();
        d(localStatus, paramOnlineStatusItem2.b);
      }
      else if (OnlineStatusConstants.d(localStatus))
      {
        d(localStatus, paramOnlineStatusItem2.b);
      }
      else if ((paramOnlineStatusItem2.b == 1028L) && (!OnlineMusicStatusManager.d()))
      {
        OnlineMusicStatusManager.e();
        d(localStatus, paramOnlineStatusItem2.b);
      }
      else
      {
        this.h.a(localStatus, paramOnlineStatusItem2.b, true);
        paramView = this.r;
        if (paramView != null) {
          paramView.a(paramOnlineStatusItem2.c);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramOnlineStatusItem1, localStatus, Long.valueOf(paramOnlineStatusItem2.b) }));
      }
    }
    else if ((a(paramOnlineStatusItem2, localStatus)) && (OnlineStatusConstants.d(localStatus)))
    {
      paramOnlineStatusItem1 = (OnlineStatusData)this.h.g().getValue();
      if (paramOnlineStatusItem1.a == AppRuntime.Status.away) {
        i = 1;
      } else if (paramOnlineStatusItem1.a == AppRuntime.Status.busy) {
        i = 2;
      }
      ReportHelperKt.a("0X800B754", i);
      c(paramOnlineStatusItem1.a, paramOnlineStatusItem1.b);
    }
  }
  
  public void a(ISubAccountApi.SubAccountInfoProxy paramSubAccountInfoProxy)
  {
    this.h.a(paramSubAccountInfoProxy, this.b, this.a);
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.h.a(this.a, paramSimpleAccount, this.b);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.d;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.a(paramStatus, paramLong);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.p.p();
    if (!paramBoolean)
    {
      m();
      return;
    }
    dismiss();
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.j.getWidth() != 0) && (this.j.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.j.getWidth();
      paramArrayOfInt[1] = this.j.getHeight();
      return;
    }
    paramArrayOfInt[0] = this.j.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfInt[1] = ViewUtils.dpToPx(554.0F);
  }
  
  public void b()
  {
    this.h.a(this.a, this.b);
  }
  
  public void b(View paramView)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(this.a);
    int i = 1;
    if (!bool)
    {
      QQToast.makeText(this.a, 1, 2131916775, 1).show();
      return;
    }
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.h.g().getValue();
    if (this.p.b(localOnlineStatusData.b))
    {
      ReportHelperKt.a("0X800B0F2", 1);
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.a, "panel");
    }
    else if (localOnlineStatusData.b == 1040L)
    {
      ReportHelperKt.a("0X800B0F2", 3);
      ConstellationLauncher.c.a(this.a, ConstellationUtilKt.f(this.b), 4013);
    }
    else if (localOnlineStatusData.b == 1030L)
    {
      ReportHelperKt.a("0X800B0F2", 4);
      paramView = (OnlineAutoStatusBean)QConfigManager.b().b(652);
      Friends localFriends = ((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).getFriend(this.b.getCurrentAccountUin(), true, true, true);
      if ((paramView != null) && (paramView.a != null) && (!android.text.TextUtils.isEmpty(paramView.a.c)) && (OnlineStatusUtil.b(localFriends)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramView.a.c);
        localStringBuilder.append(localFriends.adCode);
        paramView = localStringBuilder.toString();
        ConstellationLauncher.c.a(this.a, paramView, 4013);
      }
    }
    else if (localOnlineStatusData.b == 1080L)
    {
      o();
      ReportHelperKt.a("0X800BD1D", 0);
    }
    else if (localOnlineStatusData.a == AppRuntime.Status.online)
    {
      a(paramView, localOnlineStatusData.b);
      OnlineStatusDataReporter.a(localOnlineStatusData.b);
    }
    else if (OnlineStatusConstants.d(localOnlineStatusData.a))
    {
      if (localOnlineStatusData.a != AppRuntime.Status.away) {
        if (localOnlineStatusData.a == AppRuntime.Status.busy) {
          i = 2;
        } else {
          i = 3;
        }
      }
      ReportHelperKt.a("0X800B6BB", i);
      c(localOnlineStatusData.a, localOnlineStatusData.b);
    }
    paramView = (IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "");
    OnlineStatusDataReporter.a(localOnlineStatusData.a, paramView.getExtOnlineStatus());
  }
  
  public void b(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.d;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.a(true, paramStatus, paramLong);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    float f2 = 0.5F;
    float f6 = 1.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      f2 = 1.0F;
    }
    float f4 = 0.0F;
    float f3;
    if (paramBoolean) {
      f3 = 0.0F;
    } else {
      f3 = 1.0F;
    }
    if (paramBoolean) {
      f4 = 1.0F;
    }
    float f5;
    if (paramBoolean) {
      f5 = 0.02F;
    } else {
      f5 = 1.0F;
    }
    if (!paramBoolean) {
      f6 = 0.02F;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.j, "scaleX", new float[] { f1, f2 });
    localObjectAnimator1.setDuration(230L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.j, "scaleY", new float[] { f1, f2 });
    localObjectAnimator2.setDuration(230L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.j, "alpha", new float[] { f5, f6 });
    if (paramBoolean) {
      localObjectAnimator3.setStartDelay(70L);
    }
    localObjectAnimator3.setDuration(70L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { f3, f4 });
    this.m.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
    this.m.setInterpolator(new AccelerateDecelerateInterpolator());
    this.m.setDuration(300L);
  }
  
  public void c()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.d;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.e();
    }
    this.p.h();
    this.p.q();
  }
  
  public void c(View paramView)
  {
    a(true);
  }
  
  public ArrayList<OnlineStatusItem> d()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.b);
    return OnLineStatusHelper.a().b(localStatus, l);
  }
  
  public void df_()
  {
    String str = this.b.getCurrentAccountUin();
    QLog.d("AccountPanel", 2, "onAccountChanged");
    this.h.a().setValue(Boolean.valueOf(false));
    this.b = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.h.a(null);
    this.e.b();
    s();
    a(false);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(this.b, this.a);
    this.p.g();
    c(((ISubAccountService)this.b.getRuntimeService(ISubAccountService.class, "")).isSubAccountUin(str));
  }
  
  public ArrayList<OnlineStatusItem> e()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.d;
    if (localOnlineStatusViewCtrl != null) {
      return localOnlineStatusViewCtrl.d();
    }
    return null;
  }
  
  public void f()
  {
    try
    {
      a(false);
      this.e.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AccountPanel", 1, "dismissRecursive: failed. ", localException);
    }
  }
  
  protected void g()
  {
    super.g();
    this.h.a(false);
  }
  
  public void h()
  {
    s();
    this.h.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.h.b(false);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.h.b(true);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.e.b();
    s();
    this.h.a().setValue(Boolean.valueOf(false));
    if ((this.a != null) && (this.b != null) && (!android.text.TextUtils.isEmpty(this.h.m())))
    {
      ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131916863)).setMessage(this.a.getString(2131916862));
      localQQCustomDialog.setPositiveButton(2131888010, new AccountPanel.5(this));
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.show();
    }
  }
  
  public void onBackPressed()
  {
    a(true);
  }
  
  public boolean onKeyUp(int paramInt, @androidx.annotation.NonNull KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void show()
  {
    if ((this.b != null) && (this.a != null))
    {
      if (isShowing()) {
        return;
      }
      r();
      this.h.c(true);
      this.p.a(this.a);
      super.show();
      this.h.a(null);
      this.h.n();
      this.p.c();
      p();
      this.h.b(this.a, this.b);
      if (this.q == 10)
      {
        Intent localIntent = new Intent("before_account_change");
        this.a.sendBroadcast(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      ReportController.b(this.b, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      q();
      ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false);
      this.p.o();
      e(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel
 * JD-Core Version:    0.7.0.1
 */