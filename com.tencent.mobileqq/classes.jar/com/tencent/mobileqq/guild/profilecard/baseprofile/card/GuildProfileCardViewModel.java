package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.qphone.base.util.BaseApplication;

public class GuildProfileCardViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildProfileCardViewModel.1();
  private SingleLiveEvent<Boolean> b = new SingleLiveEvent();
  private BroadcastReceiver c;
  
  public GuildProfileCardViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public SingleLiveEvent<Boolean> a()
  {
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    if (this.c == null)
    {
      this.c = new GuildProfileCardViewModel.2(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(BaseApplication.getContext().getPackageName());
      localIntentFilter.addAction(localStringBuilder.toString());
      localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
      paramContext.registerReceiver(this.c, localIntentFilter);
    }
  }
  
  public void b(Context paramContext)
  {
    BroadcastReceiver localBroadcastReceiver = this.c;
    if (localBroadcastReceiver != null)
    {
      paramContext.unregisterReceiver(localBroadcastReceiver);
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCardViewModel
 * JD-Core Version:    0.7.0.1
 */