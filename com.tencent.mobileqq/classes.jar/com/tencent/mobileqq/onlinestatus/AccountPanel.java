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
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
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
  private int jdField_a_of_type_Int;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private IAccountPanel.OnStatusChangeByUserListener jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnStatusChangeByUserListener;
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = new OnlineStatusPanelParams();
  private OnlineStatusResDownLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader;
  private OnlineStatusViewCtrl jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
  private AccountPanelBinder jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder;
  private AccountPanelViewContainer jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer;
  private StatusCardViewHolder jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder = new StatusCardViewHolder();
  private AccountPanelViewModel jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  public AccountPanel(@android.support.annotation.NonNull QBaseActivity paramQBaseActivity, int paramInt)
  {
    super(paramQBaseActivity, null);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    paramQBaseActivity = a();
    this.jdField_a_of_type_AndroidViewView = paramQBaseActivity;
    this.b = paramQBaseActivity.findViewById(2131365166);
    a(new float[] { 0.5F, 0.0F });
  }
  
  private View a()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel = ((AccountPanelViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, new AccountPanelViewModelFactory(this.jdField_a_of_type_ComTencentCommonAppAppInterface)).get(AccountPanelViewModel.class));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder = new AccountPanelBinder();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer = new AccountPanelViewContainer(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder);
    View localView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.b(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.c(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.d(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.e(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.b(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer, this, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams);
    return localView;
  }
  
  private void a(View paramView, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(), this, paramLong);
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus)
  {
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
    if ((paramStatus == AppRuntime.Status.online) && (localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      return localOnlineStatusData.jdField_a_of_type_Long == paramOnlineStatusItem.jdField_a_of_type_Long;
    }
    return localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus;
  }
  
  private void c(AppRuntime.Status paramStatus, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_ONLINE_STATUS", paramStatus);
    localIntent.putExtra("KEY_ONLINE_EXT_STATUS", paramLong);
    QPublicFragmentActivity.startForResult(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, AccountOnlineStateActivity.class, 234);
  }
  
  private void d(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localObject1 = OnLineStatusHelper.a().a(paramLong, paramStatus);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131698506, new Object[] { localObject1 });
    String str2 = ((AutoReplyManagerImpl)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoReplyManager.class)).a().mRawText;
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(ViewUtils.d(14.0F));
    int i;
    if ((paramLong != 1000L) && (paramLong != 1028L))
    {
      int j;
      if (paramStatus == AppRuntime.Status.dnd)
      {
        i = 4;
        j = 2131698495;
      }
      else
      {
        i = 3;
        j = 2131698505;
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(j);
      str2 = com.tencent.mobileqq.text.TextUtils.subQQTextString(str2, (Paint)localObject2, 3, 16, (int)(ViewUtils.b(i * 242) - ((Paint)localObject2).measureText((String)localObject3)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject2 = new SpannableString(str2);
      localObject3 = new AccountPanel.1(this, paramStatus, paramLong);
      ((SpannableString)localObject2).setSpan(localObject3, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText((CharSequence)localObject2, 3, 16)).setMessageMaxLine(i);
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView().setAccessibilityDelegate(new AccountPanel.2(this, (ClickableSpan)localObject3));
      }
    }
    else
    {
      if (paramLong == 1000L) {
        i = 2131698501;
      } else {
        i = 2131698497;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText(str2, 3, 16)).setMessageMaxLine(4);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131698504, new AccountPanel.3(this, paramStatus, paramLong, (String)localObject1));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131698492, new AccountPanel.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.b();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams;
      ((OnlineStatusPanelParams)localObject).jdField_a_of_type_Int = 1;
      ((OnlineStatusPanelParams)localObject).h = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.i = 0;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(), this, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
    }
    else
    {
      localObject = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(true, (AppRuntime.Status)localObject, l);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.i().setValue(Boolean.valueOf(true));
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g() != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel;
      ((AccountPanelViewModel)localObject).a(((OnlineStatusData)((AccountPanelViewModel)localObject).g().getValue()).jdField_a_of_type_Long);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g() == null) {
      localObject = "null";
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g();
    }
    QLog.e("AccountPanel", 1, new Object[] { "data: ", localObject });
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader = new OnlineStatusResDownLoader();
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  private void n()
  {
    OnlineStatusResDownLoader localOnlineStatusResDownLoader = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader;
    if (localOnlineStatusResDownLoader != null)
    {
      localOnlineStatusResDownLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusResDownLoader = null;
    }
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    return OnLineStatusHelper.a().a(localStatus, l);
  }
  
  public void a()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null)
    {
      OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, MobileQQ.sMobileQQ.peekAppRuntime(), true);
      return;
    }
    if ((paramInt1 != 299) && (paramInt1 != 234))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramInt1, paramInt2, paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.d();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.i().setValue(Boolean.valueOf(true));
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (paramLong == 40001L)
    {
      localObject = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.c(OnlineStatusItem.a(((IOnlineStatusService)localObject).getOnlineStatus(), OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)));
    }
    else if (OnLineStatusHelper.a(AppRuntime.Status.online, paramLong))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.d = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnStatusChangeByUserListener != null)
    {
      localObject = OnLineStatusHelper.a().a(AppRuntime.Status.online, paramLong, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnStatusChangeByUserListener.a(((OnlineStatusItem)localObject).b);
    }
  }
  
  public void a(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 1).a();
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null)
      {
        paramView = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(paramView.jdField_a_of_type_MqqAppAppRuntime$Status, paramView.jdField_a_of_type_Long);
      }
      return;
    }
    a(paramView, 40001L);
  }
  
  public void a(IAccountPanel.OnAccountExitListener paramOnAccountExitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(paramOnAccountExitListener);
  }
  
  public void a(IAccountPanel.OnStatusChangeByUserListener paramOnStatusChangeByUserListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnStatusChangeByUserListener = paramOnStatusChangeByUserListener;
  }
  
  public void a(IAccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(paramOnlineStatusChangedListener);
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    show();
    if (this.jdField_a_of_type_Int == 2)
    {
      OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
      if (localOnlineStatusViewCtrl != null) {
        localOnlineStatusViewCtrl.a(paramOnlineStatusItem);
      }
    }
    ReportHelperKt.a("0X800BBDF");
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2, View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 1).a();
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl != null)
      {
        paramOnlineStatusItem1 = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem1.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem1.jdField_a_of_type_Long);
      }
      return;
    }
    AppRuntime.Status localStatus = OnLineStatusHelper.a().a(paramOnlineStatusItem2);
    paramOnlineStatusItem1 = OnLineStatusHelper.a().a(paramOnlineStatusItem1);
    if ((localStatus != null) && (paramOnlineStatusItem2 != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(), this, paramOnlineStatusItem2.jdField_a_of_type_Long))) {
      return;
    }
    int i = 3;
    if ((localStatus != null) && (paramOnlineStatusItem2 != null) && (!a(paramOnlineStatusItem2, localStatus)))
    {
      OnlineStatusDataReporter.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
      paramView = MobileQQ.sMobileQQ.getSharedPreferences("online_battery", 0);
      boolean bool = paramView.getBoolean("has_set_battery", false);
      if ((OnLineStatusHelper.a().a(paramOnlineStatusItem2)) && (!bool))
      {
        paramView.edit().putBoolean("has_set_battery", true).apply();
        d(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
      }
      else if (OnlineStatusConstants.a(localStatus))
      {
        d(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
      }
      else if ((paramOnlineStatusItem2.jdField_a_of_type_Long == 1028L) && (!OnlineMusicStatusManager.a()))
      {
        OnlineMusicStatusManager.b();
        d(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(localStatus, paramOnlineStatusItem2.jdField_a_of_type_Long, true);
        paramView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnStatusChangeByUserListener;
        if (paramView != null) {
          paramView.a(paramOnlineStatusItem2.b);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramOnlineStatusItem1, localStatus, Long.valueOf(paramOnlineStatusItem2.jdField_a_of_type_Long) }));
      }
    }
    else if ((a(paramOnlineStatusItem2, localStatus)) && (OnlineStatusConstants.a(localStatus)))
    {
      paramOnlineStatusItem1 = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
      if (paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.away) {
        i = 1;
      } else if (paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.busy) {
        i = 2;
      }
      ReportHelperKt.a("0X800B754", i);
      c(paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem1.jdField_a_of_type_Long);
    }
  }
  
  public void a(ISubAccountApi.SubAccountInfoProxy paramSubAccountInfoProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(paramSubAccountInfoProxy, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramSimpleAccount, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.a(paramStatus, paramLong);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.l();
    if (!paramBoolean)
    {
      k();
      return;
    }
    dismiss();
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.b.getWidth() != 0) && (this.b.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.b.getWidth();
      paramArrayOfInt[1] = this.b.getHeight();
      return;
    }
    paramArrayOfInt[0] = this.b.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfInt[1] = ViewUtils.b(554.0F);
  }
  
  public void aK_()
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public ArrayList<OnlineStatusItem> b()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localOnlineStatusViewCtrl != null) {
      return localOnlineStatusViewCtrl.a();
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void b(View paramView)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    int i = 1;
    if (!bool)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719223, 1).a();
      return;
    }
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.g().getValue();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(localOnlineStatusData.jdField_a_of_type_Long))
    {
      ReportHelperKt.a("0X800B0F2", 1);
      ((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "panel");
    }
    else if (localOnlineStatusData.jdField_a_of_type_Long == 1040L)
    {
      ReportHelperKt.a("0X800B0F2", 3);
      ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ConstellationUtilKt.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface), 4013);
    }
    else if (localOnlineStatusData.jdField_a_of_type_Long == 1030L)
    {
      ReportHelperKt.a("0X800B0F2", 4);
      paramView = (OnlineAutoStatusBean)QConfigManager.a().a(652);
      Friends localFriends = ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true, true, true);
      if ((paramView != null) && (paramView.a != null) && (!android.text.TextUtils.isEmpty(paramView.a.a)) && (OnlineStatusUtil.a(localFriends)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramView.a.a);
        localStringBuilder.append(localFriends.adCode);
        paramView = localStringBuilder.toString();
        ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramView, 4013);
      }
    }
    else if (localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)
    {
      a(paramView, localOnlineStatusData.jdField_a_of_type_Long);
      OnlineStatusDataReporter.a(localOnlineStatusData.jdField_a_of_type_Long);
    }
    else if (OnlineStatusConstants.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status))
    {
      if (localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status != AppRuntime.Status.away) {
        if (localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.busy) {
          i = 2;
        } else {
          i = 3;
        }
      }
      ReportHelperKt.a("0X800B6BB", i);
      c(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusData.jdField_a_of_type_Long);
    }
    paramView = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    OnlineStatusDataReporter.a(localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramView.getExtOnlineStatus());
  }
  
  public void b(AppRuntime.Status paramStatus, long paramLong)
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
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
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { f1, f2 });
    localObjectAnimator1.setDuration(230L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { f1, f2 });
    localObjectAnimator2.setDuration(230L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { f5, f6 });
    if (paramBoolean) {
      localObjectAnimator3.setStartDelay(70L);
    }
    localObjectAnimator3.setDuration(70L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { f3, f4 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
  }
  
  public void c()
  {
    OnlineStatusViewCtrl localOnlineStatusViewCtrl = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl;
    if (localOnlineStatusViewCtrl != null) {
      localOnlineStatusViewCtrl.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.f();
  }
  
  public void c(View paramView)
  {
    a(true);
  }
  
  public void d()
  {
    try
    {
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AccountPanel", 1, "dismissRecursive: failed. ", localException);
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.b(false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.b(true);
  }
  
  public void i()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a().setValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.b();
    n();
    a(false);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.e();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewStatusCardViewHolder.b();
    n();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a().setValue(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a())))
    {
      ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719311)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719310));
      localQQCustomDialog.setPositiveButton(2131691064, new AccountPanel.5(this));
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
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null))
    {
      if (isShowing()) {
        return;
      }
      m();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.c(true);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      super.show();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.c();
      l();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (this.jdField_a_of_type_Int != 2)
      {
        Intent localIntent = new Intent("before_account_change");
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.sendBroadcast(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.k();
      b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel
 * JD-Core Version:    0.7.0.1
 */