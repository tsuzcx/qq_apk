package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository;
import mqq.util.WeakReference;

public class AccountPanelViewModelFactory
  implements ViewModelProvider.Factory
{
  private WeakReference<AppInterface> a;
  
  public AccountPanelViewModelFactory(AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramAppInterface);
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    paramClass = new AccountPanelRepository((AppInterface)this.a.get());
    AccountPanelViewModel localAccountPanelViewModel = new AccountPanelViewModel(paramClass);
    paramClass.a(localAccountPanelViewModel);
    return localAccountPanelViewModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModelFactory
 * JD-Core Version:    0.7.0.1
 */