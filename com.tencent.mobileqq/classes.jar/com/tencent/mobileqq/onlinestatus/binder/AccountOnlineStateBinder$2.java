package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDisplayInfoBuilder;
import com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder;

class AccountOnlineStateBinder$2
  implements LifecycleObserver
{
  AccountOnlineStateBinder$2(AccountOnlineStateBinder paramAccountOnlineStateBinder) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AccountOnlineStateBinder.a(this.a).a();
    AccountOnlineStateBinder.a(this.a).b();
    paramLifecycleOwner.getLifecycle().removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.2
 * JD-Core Version:    0.7.0.1
 */