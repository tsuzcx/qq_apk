package com.tencent.mobileqq.guild.notice;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.INoticeRedUpdateListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildNoticeViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  private AppInterface a;
  private MutableLiveData<List<GuildNotice>> b = new MutableLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private SingleLiveEvent<BaseGuildViewModel.ToastEvent> e = new SingleLiveEvent();
  private int f = 0;
  private boolean g = false;
  private IGuildInboxRedService.INoticeRedUpdateListener h = new GuildNoticeViewModel.1(this);
  
  public GuildNoticeViewModel()
  {
    super(new QQGuildInfoRepository());
  }
  
  private List<GuildNotice> a(List<GuildNotice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GuildNotice localGuildNotice = (GuildNotice)paramList.next();
      if (localGuildNotice.d > NetConnInfoCenter.getServerTime())
      {
        localArrayList.add(localGuildNotice);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getValidNotices the item is expired:");
        localStringBuilder.append(localGuildNotice.toString());
        QLog.d("GuildNoticeViewModel", 1, localStringBuilder.toString());
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    List localList = (List)this.b.getValue();
    if (localList == null) {
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      if (((GuildNotice)localList.get(i)).a.equals(paramString))
      {
        localList.remove(i);
        break;
      }
      i += 1;
    }
    this.b.setValue(localList);
  }
  
  public MutableLiveData<Boolean> a()
  {
    return this.c;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).removeNoticeRedUpdateListener(this.h);
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    if (this.g) {
      return;
    }
    boolean bool = true;
    this.g = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData type=");
      localStringBuilder.append(paramInt);
      QLog.d("GuildNoticeViewModel", 1, localStringBuilder.toString());
    }
    this.a = paramAppInterface;
    ((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).addNoticeRedUpdateListener(this.h);
    if (((IGuildInboxRedService)paramAppInterface.getRuntimeService(IGuildInboxRedService.class, "")).getNoticeRedPoint(paramInt).b <= 0) {
      bool = false;
    }
    a(bool);
  }
  
  public void a(GuildNotice paramGuildNotice, GuildMainViewContext paramGuildMainViewContext)
  {
    if ((paramGuildNotice.k.isEmpty()) && (paramGuildNotice.l != null))
    {
      if (TextUtils.isEmpty(paramGuildNotice.l)) {
        return;
      }
      JoinGuildParam localJoinGuildParam = new JoinGuildParam();
      localJoinGuildParam.guildId = paramGuildNotice.f;
      localJoinGuildParam.joinSignature = paramGuildNotice.l;
      localJoinGuildParam.from = 246619;
      ((GuildLeftItemViewExtHelper)paramGuildMainViewContext.a(GuildMainFrameConstants.d)).a(localJoinGuildParam);
      paramGuildMainViewContext.e().d(true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).dealNotice(paramString1, paramString2, new GuildNoticeViewModel.5(this, paramString1));
  }
  
  public void a(boolean paramBoolean)
  {
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).initGetNoticeList(paramBoolean, new GuildNoticeViewModel.2(this));
  }
  
  public LiveData<Boolean> b()
  {
    return Transformations.map(this.b, new GuildNoticeViewModel.3(this));
  }
  
  public void c()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getMoreNoticeList(this.f, new GuildNoticeViewModel.4(this));
  }
  
  public MutableLiveData<List<GuildNotice>> d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel
 * JD-Core Version:    0.7.0.1
 */