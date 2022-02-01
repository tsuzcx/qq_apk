package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder;
import com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.BinderCallback;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStatusViewModelFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class AccountOnlineStateActivity
  extends QIphoneTitleBarFragment
  implements AccountOnlineStateBinder.BinderCallback
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private volatile QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private AccountOnlineStateBinder jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder;
  private AccountOnlineStateViewModel jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel;
  
  private void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719232));
    c(2131694583, new AccountOnlineStateActivity.1(this));
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      a(2131690728, null);
    }
  }
  
  private void c()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = QLifeCycleFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel = ((AccountOnlineStateViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, new AccountOnlineStatusViewModelFactory(this.jdField_a_of_type_ComTencentCommonAppAppInterface)).get(AccountOnlineStateViewModel.class));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a();
    AppRuntime.Status localStatus2 = (AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS");
    long l = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus1 = localStatus2;
    if (localStatus2 == null)
    {
      localStatus1 = localIOnlineStatusService.getOnlineStatus();
      l = OnLineStatusHelper.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().setValue(new OnlineStatusData(localStatus1, l));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.b().setValue(new OnlineStatusData(localStatus1, l));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder = new AccountOnlineStateBinder(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel, this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(this.b, this.d, (OnlineStatusData)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a().getValue());
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(localLifeCycleAndViewModelStoreOwner);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.b(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.c(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.d(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.e(localLifeCycleAndViewModelStoreOwner, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel);
  }
  
  protected int a()
  {
    return 2131558452;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
      c();
      a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
      {
        i_(false);
        return;
      }
      i_(true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubmitted online status ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", retCode = ");
      localStringBuilder.append(paramInt);
      QLog.d("AccountOnlineStateActivity", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, 2131719224, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131719222, 1).a();
    }
    ReportHelperKt.a("0X800AF9D");
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      if ((paramInt1 == 100) && (paramInt2 == 0)) {
        ReportHelperKt.a("0X800AF4B", 2);
      }
      return;
    }
    if (paramInt1 == 325)
    {
      if (paramInt2 == 325)
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)paramIntent.getParcelableExtra("AutoReplyEditActivity:text");
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.b(localAutoReplyText);
        if ((paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, 2131690252, 1).a();
        }
      }
    }
    else
    {
      if (paramInt1 == 100)
      {
        paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.b(paramIntent);
        return;
      }
      if (paramInt1 == 1040)
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.b(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    if (!b().isEnabled())
    {
      ReportHelperKt.a("0X800AF9B", 1);
      super.onBackEvent();
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131698494);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131695036);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131718368);
    localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230, null, (CharSequence)localObject, str1, str2, new AccountOnlineStateActivity.2(this), new AccountOnlineStateActivity.3(this));
    ((QQCustomDialog)localObject).setMessageMaxLine(1);
    ((QQCustomDialog)localObject).show();
    ReportHelperKt.a("0X800AF9B", 2);
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */