package com.tencent.mobileqq.guild.mainframe.container.inbox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.INoticeRedUpdateListener;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildInboxViewModel
  extends BaseGuildViewModel<QQGuildInfoRepository>
{
  private MutableLiveData<List<GuildNoticeRedPoint>> b = new MutableLiveData();
  private IGuildInboxRedService.INoticeRedUpdateListener c = new GuildInboxViewModel.1(this);
  
  public GuildInboxViewModel()
  {
    super(new QQGuildInfoRepository());
  }
  
  public LiveData<List<GuildNoticeRedPoint>> a()
  {
    return this.b;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    ((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).addNoticeRedUpdateListener(this.c);
    this.b.setValue(((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).getNoticeGroupList());
    QLog.d("QQGuildNoticeViewModel", 1, "init ");
  }
  
  public void b(AppInterface paramAppInterface)
  {
    ((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).addNoticeRedUpdateListener(this.c);
  }
  
  public void c(AppInterface paramAppInterface)
  {
    ((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).removeNoticeRedUpdateListener(this.c);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    QLog.d("QQGuildNoticeViewModel", 1, "onCleared ");
    ((IGuildInboxRedService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGuildInboxRedService.class, "")).removeNoticeRedUpdateListener(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxViewModel
 * JD-Core Version:    0.7.0.1
 */