package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnlineStatusChangedListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusMood;
import com.tencent.mobileqq.onlinestatus.model.SubAccountMsg;
import com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository;
import com.tencent.mobileqq.onlinestatus.utils.AlbumCleanUtil;
import com.tencent.mobileqq.onlinestatus.utils.UiRouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountInfoProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountUnReadItemProxy;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AccountPanelViewModel
  extends BaseViewModel<AccountPanelRepository>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  public Handler a;
  private MutableLiveData<Boolean> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private IAccountPanel.OnlineStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnlineStatusChangedListener;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private MutableLiveData<Integer> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_b_of_type_Boolean = false;
  private MutableLiveData<String> jdField_c_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_c_of_type_Boolean = true;
  private MutableLiveData<String> jdField_d_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_d_of_type_Boolean = true;
  private MutableLiveData<List<Object>> e = new MutableLiveData();
  private MutableLiveData<SubAccountMsg> f = new MutableLiveData();
  private MutableLiveData<OnlineStatusData> g = new MutableLiveData();
  private MutableLiveData<SimpleAccount> h = new MutableLiveData();
  private MutableLiveData<Boolean> i = new MutableLiveData();
  private MutableLiveData<OnlineStatusMood> j = new MutableLiveData();
  
  public AccountPanelViewModel(AccountPanelRepository paramAccountPanelRepository)
  {
    super(paramAccountPanelRepository);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private int a(AppInterface paramAppInterface)
  {
    int m = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAllSubAccountInfo().size();
    paramAppInterface = paramAppInterface.getApplication().getAllAccounts();
    int k = m;
    if (paramAppInterface != null)
    {
      k = m;
      if (paramAppInterface.size() > 0) {
        k = m + 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getRequestNum: ");
      paramAppInterface.append(k);
      QLog.d("AccountPanelViewModel", 2, paramAppInterface.toString());
    }
    return k;
  }
  
  private boolean a(long paramLong)
  {
    boolean bool1 = OnLineStatusHelper.a(AppRuntime.Status.online, this.jdField_a_of_type_Long);
    boolean bool2 = OnLineStatusHelper.a(AppRuntime.Status.online, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(this.jdField_a_of_type_Long), " curExtID=", Long.valueOf(paramLong) });
    }
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.g.getValue();
    if ((paramLong == localOnlineStatusData.jdField_a_of_type_Long) && (AppRuntime.Status.online == localOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status) && (bool2))
    {
      QLog.d("AccountPanelViewModel", 2, "refreshPanelWhenMoodChange curStatus is equal");
      return true;
    }
    this.j.setValue(new OnlineStatusMood(bool2, bool1));
    if (!bool2) {
      return bool1;
    }
    return true;
  }
  
  public MutableLiveData<Boolean> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    ((AccountPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface)
  {
    if (Utils.c())
    {
      QQToast.a(paramQBaseActivity, 2131693846, 0).a();
      return;
    }
    if (((IPwdSetUtilApi)QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(paramQBaseActivity)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(536870912);
    UiRouteUtils.a(paramQBaseActivity, localIntent, "/base/addAccount");
    paramQBaseActivity.overridePendingTransition(2130772011, 2130771991);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(paramAppInterface, paramQBaseActivity);
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3B");
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      QQToast.a(paramQBaseActivity, paramQBaseActivity.getString(2131692183), 0).b(paramQBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchAccount toAccount=");
      localStringBuilder.append(paramSimpleAccount);
      QLog.d("AccountPanelViewModel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(Boolean.valueOf(true));
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    paramQBaseActivity.sendBroadcast(new Intent("before_account_change"));
    MobileQQ.sMobileQQ.peekAppRuntime().switchAccount(paramSimpleAccount, null);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), paramQBaseActivity);
    AlbumCleanUtil.a();
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppInterface paramAppInterface)
  {
    a(paramQBaseActivity, paramSimpleAccount, paramAppInterface);
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3A");
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppRuntime paramAppRuntime)
  {
    ISubAccountApi.SubAccountUnReadItemProxy localSubAccountUnReadItemProxy = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramSimpleAccount.getUin());
    if ((localSubAccountUnReadItemProxy.a() > 0) && (!localSubAccountUnReadItemProxy.a())) {
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
    } else {
      a(paramQBaseActivity, paramSimpleAccount);
    }
    if (localSubAccountUnReadItemProxy.a() > 0) {
      ThreadManagerV2.executeOnSubThread(new AccountPanelViewModel.1(this, paramAppRuntime, paramSimpleAccount));
    }
  }
  
  public void a(IAccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnlineStatusChangedListener = paramOnlineStatusChangedListener;
  }
  
  public void a(ISubAccountApi.SubAccountInfoProxy paramSubAccountInfoProxy, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramSubAccountInfoProxy != null)
    {
      localObject1 = paramAppInterface.getApplication().getAllAccounts();
      Object localObject2 = new ArrayList();
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SimpleAccount)((Iterator)localObject2).next();
          if (TextUtils.equals(((SimpleAccount)localObject1).getUin(), paramSubAccountInfoProxy.a())) {
            break label101;
          }
        }
      }
    }
    Object localObject1 = null;
    label101:
    if (localObject1 != null)
    {
      a(paramQBaseActivity, (SimpleAccount)localObject1, MobileQQ.sMobileQQ.peekAppRuntime());
    }
    else if (paramSubAccountInfoProxy != null)
    {
      paramQBaseActivity.sendBroadcast(new Intent("before_account_change"));
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("subAccount", paramSubAccountInfoProxy.a());
      paramQBaseActivity.startActivity((Intent)localObject1);
      UiRouteUtils.a(paramQBaseActivity, (Intent)localObject1, "/base/subAccount/ug");
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3A");
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    IAccountPanel.OnlineStatusChangedListener localOnlineStatusChangedListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnlineStatusChangedListener;
    if (localOnlineStatusChangedListener != null) {
      localOnlineStatusChangedListener.a(paramStatus);
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!a(paramLong)) {
      this.i.setValue(Boolean.valueOf(true));
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus != null)
    {
      this.g.setValue(new OnlineStatusData(paramStatus, paramLong));
      if (paramBoolean) {
        ((IOnlineStatusService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(paramStatus, paramLong);
      }
      a(paramStatus);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((AccountPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = this.jdField_d_of_type_Boolean;
    Boolean localBoolean = Boolean.valueOf(true);
    if ((bool) && (paramBundle != null))
    {
      bool = paramBundle.getBoolean("param_need_switch_online_status", false);
      int k;
      if ((paramBoolean) && (paramBundle != null))
      {
        k = paramBundle.getInt("StatusId", 0);
        a(AppRuntime.Status.online, k, false);
        if (!bool)
        {
          QQToast.a(MobileQQ.sMobileQQ, 2, 2131691334, 1).a();
          this.i.setValue(localBoolean);
        }
      }
      else
      {
        if (bool) {
          k = 2131698496;
        } else {
          k = 2131691335;
        }
        QQToast.a(MobileQQ.sMobileQQ, 1, k, 1).a();
        this.i.setValue(localBoolean);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, AppInterface paramAppInterface)
  {
    paramBundle = ((IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(paramAppInterface);
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      a(paramBundle);
      this.i.setValue(Boolean.valueOf(true));
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, AppRuntime.Status paramStatus, AppInterface paramAppInterface)
  {
    ThreadManager.getUIHandler().post(new AccountPanelViewModel.4(this, paramBoolean, paramAppInterface, paramStatus));
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface, AppRuntime.Status paramStatus)
  {
    ThreadManager.getUIHandler().post(new AccountPanelViewModel.3(this, paramBoolean, paramAppInterface, paramStatus));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AccountPanel onSubAccountMsgNumConfirm isSuccess=");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" subUin=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" set need2ConfirmMsgNum=");
        localStringBuilder.append(paramBoolean ^ true);
        localStringBuilder.append(" nextAction=");
        localStringBuilder.append(paramString2);
        QLog.d("AccountPanelViewModel", 2, localStringBuilder.toString());
      }
      if (paramString1.equals(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin())) {
        this.h.setValue(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
      }
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean1) {
        this.jdField_b_of_type_Boolean = true;
      }
      int k = this.jdField_a_of_type_Int;
      if (k > 0) {
        this.jdField_a_of_type_Int = (k - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewModel", 2, new Object[] { " mRequestNum=", Integer.valueOf(this.jdField_a_of_type_Int), " subAccountMsgComing=", Boolean.valueOf(paramBoolean2) });
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_b_of_type_Boolean) {
          b();
        }
      }
    }
    else if (paramBoolean1)
    {
      this.f.setValue(new SubAccountMsg(paramBoolean1, paramString, paramBoolean2));
    }
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppRuntime paramAppRuntime)
  {
    if ((paramSimpleAccount != null) && (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanThirdQQUnreadMsgNum((AppInterface)paramAppRuntime, paramSimpleAccount)))
    {
      a(paramQBaseActivity, paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public MutableLiveData<Integer> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b()
  {
    ArrayList localArrayList1 = new ArrayList();
    List localList = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAllSubAccountInfo();
    ArrayList localArrayList2 = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ISubAccountApi.SubAccountInfoProxy)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ISubAccountApi.SubAccountInfoProxy)localObject2).a())))
        {
          localArrayList1.add(localObject2);
          localArrayList2.add(((ISubAccountApi.SubAccountInfoProxy)localObject2).a());
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((ISubAccountApi.SubAccountInfoProxy)localObject2).a() }));
          }
        }
      }
    }
    Object localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2 = ((AppRuntime)localObject3).getApplication().getAllAccounts();
    Object localObject1 = new ArrayList();
    if (localObject2 != null) {
      ((List)localObject1).addAll((Collection)localObject2);
    }
    int k;
    if (((List)localObject1).size() > 0)
    {
      localObject2 = ((List)localObject1).iterator();
      localObject3 = ((AppRuntime)localObject3).getCurrentUin();
      while (((Iterator)localObject2).hasNext())
      {
        if (localArrayList2.size() >= 7)
        {
          QLog.d("AccountPanelViewModel", 1, "add account exceed the limit");
          break;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
        if ((!TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(localObject3)))
        {
          Iterator localIterator = localArrayList2.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (localSimpleAccount.getUin().equals(str))
            {
              k = 1;
              break label345;
            }
          }
          k = 0;
          label345:
          if (k == 0)
          {
            localArrayList1.add(localSimpleAccount);
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanelViewModel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { localSimpleAccount.getUin() }));
            }
          }
        }
      }
    }
    QLog.d("AccountPanelViewModel", 1, "localAccountList is empty");
    this.e.setValue(localArrayList1);
    if (QLog.isColorLevel())
    {
      int m = ((List)localObject1).size();
      if (localList != null) {
        k = localList.size();
      } else {
        k = 0;
      }
      QLog.d("AccountPanelViewModel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k) }));
    }
  }
  
  public void b(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanelViewModel.2(this, paramQBaseActivity, paramAppInterface));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: no needShowOnlineStatusToast ");
      }
      return;
    }
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = paramBundle.getBoolean("from_modify", false);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, new Object[] { "onSetExtInfo: invoked. ", " isFromRegister: ", Boolean.valueOf(bool1), " isFromModify=", Boolean.valueOf(bool2) });
    }
    int k;
    if (paramBoolean)
    {
      k = paramBundle.getInt("StatusId");
      a(AppRuntime.Status.online, k, false);
      if (bool2)
      {
        QQToast.a(MobileQQ.sMobileQQ, 2, 2131691334, 1).a();
        this.i.setValue(Boolean.valueOf(true));
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewModel", 2, new Object[] { "onSetExtInfo: invoked. ", " statusId: ", Integer.valueOf(k) });
      }
    }
    else
    {
      if (bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanelViewModel", 2, "onSetExtInfo: invoked. isFromRegister ");
        }
        return;
      }
      if (bool2) {
        k = 2131691335;
      } else {
        k = 2131698496;
      }
      QQToast.a(MobileQQ.sMobileQQ, 1, k, 1).a();
      this.i.setValue(Boolean.valueOf(true));
    }
  }
  
  public MutableLiveData<String> c()
  {
    return this.jdField_c_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (OnlineStatusData)this.g.getValue();
      a(paramBundle.jdField_a_of_type_MqqAppAppRuntime$Status, paramBundle.jdField_a_of_type_Long, false);
    }
  }
  
  public MutableLiveData<String> d()
  {
    return this.jdField_d_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public MutableLiveData<List<Object>> e()
  {
    return this.e;
  }
  
  public MutableLiveData<SubAccountMsg> f()
  {
    return this.f;
  }
  
  public MutableLiveData<OnlineStatusData> g()
  {
    return this.g;
  }
  
  public MutableLiveData<SimpleAccount> h()
  {
    return this.h;
  }
  
  public MutableLiveData<Boolean> i()
  {
    return this.i;
  }
  
  public MutableLiveData<OnlineStatusMood> j()
  {
    return this.j;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel
 * JD-Core Version:    0.7.0.1
 */