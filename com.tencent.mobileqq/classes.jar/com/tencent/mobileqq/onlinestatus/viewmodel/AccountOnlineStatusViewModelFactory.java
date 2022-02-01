package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository;
import mqq.util.WeakReference;

public class AccountOnlineStatusViewModelFactory
  implements ViewModelProvider.Factory
{
  private WeakReference<AppInterface> a;
  
  public AccountOnlineStatusViewModelFactory(AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramAppInterface);
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    paramClass = new AccountOnlineStateRepository((AppInterface)this.a.get());
    AccountOnlineStateViewModel localAccountOnlineStateViewModel = new AccountOnlineStateViewModel(paramClass);
    paramClass.a(localAccountOnlineStateViewModel);
    return localAccountOnlineStateViewModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStatusViewModelFactory
 * JD-Core Version:    0.7.0.1
 */