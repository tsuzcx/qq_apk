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
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
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
  public Handler a = new Handler(ThreadManager.getSubThreadLooper());
  private SimpleAccount b;
  private MutableLiveData<Boolean> c = new MutableLiveData();
  private MutableLiveData<Integer> d = new MutableLiveData();
  private MutableLiveData<String> e = new MutableLiveData();
  private MutableLiveData<String> f = new MutableLiveData();
  private MutableLiveData<List<Object>> g = new MutableLiveData();
  private MutableLiveData<SubAccountMsg> h = new MutableLiveData();
  private MutableLiveData<OnlineStatusData> i = new MutableLiveData();
  private MutableLiveData<SimpleAccount> j = new MutableLiveData();
  private MutableLiveData<Boolean> k = new MutableLiveData();
  private MutableLiveData<OnlineStatusMood> l = new MutableLiveData();
  private MutableLiveData<Boolean> m = new MutableLiveData();
  private MutableLiveData<Boolean> n = new MutableLiveData();
  private long o = -1L;
  private IAccountPanel.OnlineStatusChangedListener p;
  private String q;
  private int r = 0;
  private boolean s = false;
  private boolean t = false;
  private boolean u = true;
  private boolean v = true;
  
  public AccountPanelViewModel(AccountPanelRepository paramAccountPanelRepository)
  {
    super(paramAccountPanelRepository);
  }
  
  private int a(AppInterface paramAppInterface)
  {
    int i2 = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAllSubAccountInfo().size();
    paramAppInterface = paramAppInterface.getApplication().getAllAccounts();
    int i1 = i2;
    if (paramAppInterface != null)
    {
      i1 = i2;
      if (paramAppInterface.size() > 0) {
        i1 = i2 + 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getRequestNum: ");
      paramAppInterface.append(i1);
      QLog.d("AccountPanelViewModel", 2, paramAppInterface.toString());
    }
    return i1;
  }
  
  private void a(Intent paramIntent)
  {
    QLog.d("AccountPanelViewModel", 2, "handleAddAccount AccountPanelViewModel-addAccountFrom2");
    paramIntent.putExtra("fromWhereExactly", 2);
  }
  
  private void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    QLog.d("AccountPanelViewModel", 2, localStringBuilder.toString());
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800BDED", "0X800BDED", 0, 0, paramString2, "0", "", "");
  }
  
  private boolean b(long paramLong)
  {
    boolean bool1 = OnLineStatusHelper.c(AppRuntime.Status.online, this.o);
    boolean bool2 = OnLineStatusHelper.c(AppRuntime.Status.online, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, new Object[] { "refreshPanelWhenMoodChange last=", Long.valueOf(this.o), " curExtID=", Long.valueOf(paramLong) });
    }
    OnlineStatusData localOnlineStatusData = (OnlineStatusData)this.i.getValue();
    if ((paramLong == localOnlineStatusData.b) && (AppRuntime.Status.online == localOnlineStatusData.a) && (bool2))
    {
      QLog.d("AccountPanelViewModel", 2, "refreshPanelWhenMoodChange curStatus is equal");
      return true;
    }
    this.l.setValue(new OnlineStatusMood(bool2, bool1));
    if (!bool2) {
      return bool1;
    }
    return true;
  }
  
  private boolean c(long paramLong)
  {
    return paramLong == 1080L;
  }
  
  public MutableLiveData<Boolean> a()
  {
    return this.c;
  }
  
  public void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface)
  {
    if (Utils.e())
    {
      QQToast.makeText(paramQBaseActivity, 2131891426, 0).show();
      return;
    }
    if (((IPwdSetUtilApi)QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(paramQBaseActivity)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(536870912);
    a(localIntent);
    UiRouteUtils.a(paramQBaseActivity, localIntent, "/base/addAccount");
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(paramAppInterface, paramQBaseActivity);
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3B");
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      QQToast.makeText(paramQBaseActivity, paramQBaseActivity.getString(2131889169), 0).show(paramQBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchAccount toAccount=");
      localStringBuilder.append(paramSimpleAccount);
      QLog.d("AccountPanelViewModel", 2, localStringBuilder.toString());
    }
    this.c.setValue(Boolean.valueOf(true));
    this.q = paramSimpleAccount.getUin();
    paramQBaseActivity.sendBroadcast(new Intent("before_account_change"));
    MobileQQ.sMobileQQ.peekAppRuntime().switchAccount(paramSimpleAccount, null);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), paramQBaseActivity);
    AlbumCleanUtil.a();
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppInterface paramAppInterface)
  {
    b(paramQBaseActivity, paramSimpleAccount, paramAppInterface);
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D3", "0X80072D3", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3A");
    a(paramAppInterface, "handleThirdAccountClick AccountPanelViewModel-thirdAccountClick ", "2");
  }
  
  public void a(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppRuntime paramAppRuntime)
  {
    ISubAccountApi.SubAccountUnReadItemProxy localSubAccountUnReadItemProxy = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getUnreadCount(paramSimpleAccount.getUin());
    if ((localSubAccountUnReadItemProxy.a() > 0) && (!localSubAccountUnReadItemProxy.b())) {
      this.b = paramSimpleAccount;
    } else {
      a(paramQBaseActivity, paramSimpleAccount);
    }
    if (localSubAccountUnReadItemProxy.a() > 0) {
      ThreadManagerV2.executeOnSubThread(new AccountPanelViewModel.1(this, paramAppRuntime, paramSimpleAccount));
    }
  }
  
  public void a(IAccountPanel.OnlineStatusChangedListener paramOnlineStatusChangedListener)
  {
    this.p = paramOnlineStatusChangedListener;
  }
  
  public void a(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    paramOlympicMedalEventInfo = this.k;
    Boolean localBoolean = Boolean.valueOf(true);
    paramOlympicMedalEventInfo.setValue(localBoolean);
    this.n.setValue(localBoolean);
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
          if (TextUtils.equals(((SimpleAccount)localObject1).getUin(), paramSubAccountInfoProxy.b())) {
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
      ((Intent)localObject1).putExtra("subAccount", paramSubAccountInfoProxy.b());
      paramQBaseActivity.startActivity((Intent)localObject1);
      UiRouteUtils.a(paramQBaseActivity, (Intent)localObject1, "/base/subAccount/ug");
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800AC36", "0X800AC36", 0, 0, "", "", "", "");
    ReportController.b(paramAppInterface, "CliOper", "", "", "0X80072D2", "0X80072D2", 0, 0, "", "", "", "");
    ReportHelperKt.a("0X800AF3A");
    a(paramAppInterface, "handleSubAccountClick AccountPanelViewModel-subAccountClick ", "1");
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    IAccountPanel.OnlineStatusChangedListener localOnlineStatusChangedListener = this.p;
    if (localOnlineStatusChangedListener != null) {
      localOnlineStatusChangedListener.a(paramStatus);
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!b(paramLong)) {
      this.k.setValue(Boolean.valueOf(true));
    }
    this.o = paramLong;
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus != null)
    {
      this.i.setValue(new OnlineStatusData(paramStatus, paramLong));
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
    ((AccountPanelRepository)this.z).a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = this.v;
    Boolean localBoolean = Boolean.valueOf(true);
    if ((bool) && (paramBundle != null))
    {
      bool = paramBundle.getBoolean("param_need_switch_online_status", false);
      int i1;
      if ((paramBoolean) && (paramBundle != null))
      {
        i1 = paramBundle.getInt("StatusId", 0);
        a(AppRuntime.Status.online, i1, false);
        if (!bool)
        {
          QQToast.makeText(MobileQQ.sMobileQQ, 2, 2131888289, 1).show();
          this.k.setValue(localBoolean);
        }
      }
      else
      {
        if (bool) {
          i1 = 2131896438;
        } else {
          i1 = 2131888290;
        }
        QQToast.makeText(MobileQQ.sMobileQQ, 1, i1, 1).show();
        this.k.setValue(localBoolean);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelViewModel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(this.v) });
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, AppInterface paramAppInterface)
  {
    paramBundle = ((IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l1 = OnLineStatusHelper.a().a(paramAppInterface);
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l1 == 1030L))
    {
      a(paramBundle);
      this.k.setValue(Boolean.valueOf(true));
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
      if (this.b == null) {
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
      if (paramString1.equals(this.b.getUin())) {
        this.j.setValue(this.b);
      }
      this.b = null;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (this.s)
    {
      if (paramBoolean1) {
        this.t = true;
      }
      int i1 = this.r;
      if (i1 > 0) {
        this.r = (i1 - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewModel", 2, new Object[] { " mRequestNum=", Integer.valueOf(this.r), " subAccountMsgComing=", Boolean.valueOf(paramBoolean2) });
      }
      if (this.r == 0)
      {
        this.s = false;
        if (this.t) {
          o();
        }
      }
    }
    else if (paramBoolean1)
    {
      this.h.setValue(new SubAccountMsg(paramBoolean1, paramString, paramBoolean2));
    }
  }
  
  public MutableLiveData<Integer> b()
  {
    return this.d;
  }
  
  public void b(QBaseActivity paramQBaseActivity, AppInterface paramAppInterface)
  {
    this.a.post(new AccountPanelViewModel.2(this, paramQBaseActivity, paramAppInterface));
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.v)
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
    int i1;
    if (paramBoolean)
    {
      i1 = paramBundle.getInt("StatusId");
      a(AppRuntime.Status.online, i1, false);
      if (bool2)
      {
        QQToast.makeText(MobileQQ.sMobileQQ, 2, 2131888289, 1).show();
        this.k.setValue(Boolean.valueOf(true));
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelViewModel", 2, new Object[] { "onSetExtInfo: invoked. ", " statusId: ", Integer.valueOf(i1) });
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
        i1 = 2131888290;
      } else {
        i1 = 2131896438;
      }
      QQToast.makeText(MobileQQ.sMobileQQ, 1, i1, 1).show();
      this.k.setValue(Boolean.valueOf(true));
    }
  }
  
  public boolean b(QBaseActivity paramQBaseActivity, SimpleAccount paramSimpleAccount, AppRuntime paramAppRuntime)
  {
    if ((paramSimpleAccount != null) && (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanThirdQQUnreadMsgNum((AppInterface)paramAppRuntime, paramSimpleAccount)))
    {
      a(paramQBaseActivity, paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public MutableLiveData<String> c()
  {
    return this.e;
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (OnlineStatusData)this.i.getValue();
      a(paramBundle.a, paramBundle.b, false);
    }
  }
  
  public MutableLiveData<String> d()
  {
    return this.f;
  }
  
  public MutableLiveData<List<Object>> e()
  {
    return this.g;
  }
  
  public MutableLiveData<SubAccountMsg> f()
  {
    return this.h;
  }
  
  public MutableLiveData<OnlineStatusData> g()
  {
    return this.i;
  }
  
  public MutableLiveData<SimpleAccount> h()
  {
    return this.j;
  }
  
  public MutableLiveData<Boolean> i()
  {
    return this.k;
  }
  
  public MutableLiveData<OnlineStatusMood> j()
  {
    return this.l;
  }
  
  public MutableLiveData<Boolean> k()
  {
    return this.m;
  }
  
  public MutableLiveData<Boolean> l()
  {
    return this.n;
  }
  
  public String m()
  {
    return this.q;
  }
  
  public void n()
  {
    ((AccountPanelRepository)this.z).a();
  }
  
  public void o()
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
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ISubAccountApi.SubAccountInfoProxy)localObject2).b())))
        {
          localArrayList1.add(localObject2);
          localArrayList2.add(((ISubAccountApi.SubAccountInfoProxy)localObject2).b());
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanelViewModel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((ISubAccountApi.SubAccountInfoProxy)localObject2).b() }));
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
    int i1;
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
              i1 = 1;
              break label345;
            }
          }
          i1 = 0;
          label345:
          if (i1 == 0)
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
    this.g.setValue(localArrayList1);
    if (QLog.isColorLevel())
    {
      int i2 = ((List)localObject1).size();
      if (localList != null) {
        i1 = localList.size();
      } else {
        i1 = 0;
      }
      QLog.d("AccountPanelViewModel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel
 * JD-Core Version:    0.7.0.1
 */