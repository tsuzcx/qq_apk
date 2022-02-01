package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankRequest;

public class AccountPanelBinder
  extends BaseViewBinder
{
  public void a(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanel paramAccountPanel)
  {
    paramAccountPanelViewModel.b().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.2(this, paramAccountPanel));
  }
  
  public void a(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    paramAccountPanelViewModel.a().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.1(this, paramAccountPanelViewContainer));
  }
  
  public void a(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer, QBaseActivity paramQBaseActivity)
  {
    paramAccountPanelViewModel.h().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.8(this, paramAccountPanelViewModel, paramQBaseActivity));
  }
  
  public void a(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel)
  {
    paramAccountPanelViewModel.g().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.7(this, paramAccountPanelViewContainer, paramAccountPanel));
  }
  
  public void a(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel, OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    paramAccountPanelViewModel.j().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.9(this, paramOnlineStatusPanelParams, paramAccountPanel, paramAccountPanelViewModel, paramAccountPanelViewContainer));
  }
  
  public void a(AccountPanel paramAccountPanel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    if ((paramAccountPanel != null) && (paramAccountPanel.isShowing()))
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (!OnlineStatusSPUtil.a(paramAccountPanel.getContext(), localAppRuntime.getCurrentUin()))
      {
        StatusRankMgr.StatusRankRequest localStatusRankRequest = new StatusRankMgr.StatusRankRequest();
        localStatusRankRequest.status_id.set(1080);
        localStatusRankRequest.uin.set(0L);
        localStatusRankRequest.genrank.set(true);
        OlympicProtocolHelper.a(localAppRuntime, localStatusRankRequest, new AccountPanelBinder.13(this, paramAccountPanelViewContainer, paramAccountPanel, localAppRuntime));
      }
    }
  }
  
  public void a(AccountPanel paramAccountPanel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanelViewModel paramAccountPanelViewModel)
  {
    if (!paramAccountPanel.isShowing()) {
      return;
    }
    paramAccountPanel = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = ((IOnlineStatusService)paramAccountPanel.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(paramAccountPanel);
    paramAccountPanelViewModel.g().setValue(new OnlineStatusData(localStatus, l));
    paramAccountPanelViewContainer.d();
    paramAccountPanelViewModel.i().setValue(Boolean.valueOf(false));
  }
  
  public void b(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanel paramAccountPanel)
  {
    paramAccountPanelViewModel.l().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.12(this, paramAccountPanel));
  }
  
  public void b(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    paramAccountPanelViewModel.e().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.3(this, paramAccountPanelViewContainer));
  }
  
  public void b(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel)
  {
    paramAccountPanelViewModel.i().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.10(this, paramAccountPanel, paramAccountPanelViewContainer, paramAccountPanelViewModel));
  }
  
  public void c(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    paramAccountPanelViewModel.f().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.4(this, paramAccountPanelViewContainer));
  }
  
  public void c(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel)
  {
    paramAccountPanelViewModel.k().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.11(this, paramAccountPanel, paramAccountPanelViewContainer));
  }
  
  public void d(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    paramAccountPanelViewModel.c().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.5(this, paramAccountPanelViewContainer));
  }
  
  public void e(LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner, AccountPanelViewModel paramAccountPanelViewModel, AccountPanelViewContainer paramAccountPanelViewContainer)
  {
    paramAccountPanelViewModel.d().observe(paramLifeCycleAndViewModelStoreOwner, new AccountPanelBinder.6(this, paramAccountPanelViewContainer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder
 * JD-Core Version:    0.7.0.1
 */