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
  private AppInterface a;
  private volatile QBaseActivity b;
  private AccountOnlineStateBinder c;
  private AccountOnlineStateViewModel d;
  
  private void b()
  {
    a(this.b.getString(2131916784));
    c(2131892267, new AccountOnlineStateActivity.1(this));
    if (getActivity().getIntent().getBooleanExtra("KEY_HAS_LEFT_BUTTON_TEXT", false)) {
      a(2131887648, null);
    }
  }
  
  private void c()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = QLifeCycleFragment.a(this.b);
    this.d = ((AccountOnlineStateViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, new AccountOnlineStatusViewModelFactory(this.a)).get(AccountOnlineStateViewModel.class));
    this.d.h();
    AppRuntime.Status localStatus2 = (AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS");
    long l = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)this.a.getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus1 = localStatus2;
    if (localStatus2 == null)
    {
      localStatus1 = localIOnlineStatusService.getOnlineStatus();
      l = OnLineStatusHelper.a().a(this.a);
    }
    this.d.a().setValue(new OnlineStatusData(localStatus1, l));
    this.d.b().setValue(new OnlineStatusData(localStatus1, l));
    this.c = new AccountOnlineStateBinder(this.a, this.b, this.d, this);
    this.c.a(this.t, this.k, (OnlineStatusData)this.d.a().getValue());
    this.c.a(localLifeCycleAndViewModelStoreOwner);
    this.c.a(localLifeCycleAndViewModelStoreOwner, this.d);
    this.c.b(localLifeCycleAndViewModelStoreOwner, this.d);
    this.c.c(localLifeCycleAndViewModelStoreOwner, this.d);
    this.c.d(localLifeCycleAndViewModelStoreOwner, this.d);
    this.c.e(localLifeCycleAndViewModelStoreOwner, this.d);
  }
  
  protected int a()
  {
    return 2131623988;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.b != null)
    {
      this.a = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
      c();
      b();
      this.d.a(this.a);
      if (this.d.b(this.a))
      {
        n_(false);
        return;
      }
      n_(true);
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
    if (this.b == null) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.makeText(this.b, 2, 2131916776, 1).show();
      this.b.setResult(-1);
      this.b.finish();
    }
    else
    {
      QQToast.makeText(this.b, 1, 2131916774, 1).show();
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
        this.c.b(localAutoReplyText);
        if ((paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) && (this.b != null)) {
          QQToast.makeText(this.b, 2, 2131887163, 1).show();
        }
      }
    }
    else
    {
      if (paramInt1 == 100)
      {
        paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.b, this.a, false);
        this.d.b(paramIntent);
        return;
      }
      if (paramInt1 == 1040)
      {
        this.c.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      this.c.b(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = getQBaseActivity();
  }
  
  public boolean onBackEvent()
  {
    this.c.a(this.b);
    if (!l().isEnabled())
    {
      ReportHelperKt.a("0X800AF9B", 1);
      super.onBackEvent();
      return true;
    }
    Object localObject = this.b.getResources().getString(2131896436);
    String str1 = this.b.getResources().getString(2131892764);
    String str2 = this.b.getResources().getString(2131915860);
    localObject = DialogUtil.a(this.b, 230, null, (CharSequence)localObject, str1, str2, new AccountOnlineStateActivity.2(this), new AccountOnlineStateActivity.3(this));
    ((QQCustomDialog)localObject).setMessageMaxLine(1);
    ((QQCustomDialog)localObject).show();
    ReportHelperKt.a("0X800AF9B", 2);
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.b = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */