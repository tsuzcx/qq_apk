package com.tencent.mobileqq.guild.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQGuildMemberListViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory u = new QQGuildMemberListViewModel.1();
  protected volatile boolean a;
  protected IGProGuildInfo b;
  protected boolean c;
  protected boolean d;
  protected String e;
  protected final MutableLiveData<Boolean> f = new MutableLiveData();
  protected final MutableLiveData<List<IGProUserInfo>> g = new MutableLiveData();
  protected final MutableLiveData<Boolean> h = new MutableLiveData();
  protected final MutableLiveData<IGuildMemberCountInfos> i = new MutableLiveData();
  protected final MutableLiveData<Boolean> j = new MutableLiveData();
  protected final MutableLiveData<List<IGProUserInfo>> k = new MutableLiveData();
  protected final MutableLiveData<Boolean> l = new MutableLiveData();
  protected final SingleLiveEvent<IGProUserInfo> m = new SingleLiveEvent();
  protected final SingleLiveEvent<IGProUserInfo> n = new SingleLiveEvent();
  protected final SingleLiveEvent<List<IGProUserInfo>> o = new SingleLiveEvent();
  protected final SingleLiveEvent<List<IGProUserInfo>> p = new SingleLiveEvent();
  protected final SingleLiveEvent<Boolean> q = new SingleLiveEvent();
  protected volatile boolean r = false;
  protected AppInterface s;
  protected volatile Object t;
  private final GPServiceObserver v = new QQGuildMemberListViewModel.2(this);
  
  public QQGuildMemberListViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  public LiveData<Boolean> a()
  {
    return this.h;
  }
  
  public void a(AppInterface paramAppInterface, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    this.s = paramAppInterface;
    ((QQGuildInfoRepository)this.z).a(this.s);
    this.b = paramIGProGuildInfo;
    this.c = QQGuildUtil.b(this.b);
    this.d = QQGuildUtil.a(this.b);
    this.e = paramString;
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).addObserver(this.v);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).shareGuild(paramQBaseActivity, this.b, 2);
  }
  
  void a(QBaseActivity paramQBaseActivity, QBaseFragment paramQBaseFragment, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openRobotProfileCard(paramQBaseActivity, this.b.getGuildID(), paramString, "");
      return;
    }
    if ("".equals(this.e))
    {
      List localList = ((IGuildAdapterService)this.s.getRuntimeService(IGuildAdapterService.class, "")).getChannelList(this.b.getGuildID(), true);
      if (localList != null)
      {
        if (localList.size() == 0) {
          return;
        }
        this.e = ((IGProChannelInfo)localList.get(0)).toString();
      }
      else
      {
        return;
      }
    }
    paramString = new GuildProfileData(this.b.getGuildID(), "", paramString, 0, 1);
    paramString.getGuildBaseProfileData().d(this.e);
    GuildProfileCard.a(paramQBaseActivity, paramQBaseFragment, paramString);
  }
  
  public void a(QQGuildTitleBarFragment paramQQGuildTitleBarFragment)
  {
    this.s = paramQQGuildTitleBarFragment.l();
    ((QQGuildInfoRepository)this.z).a(this.s);
    paramQQGuildTitleBarFragment = paramQQGuildTitleBarFragment.getActivity().getIntent();
    this.b = ((IGProGuildInfo)paramQQGuildTitleBarFragment.getExtras().getSerializable("extra_guild_guild_info"));
    this.c = QQGuildUtil.b(this.b);
    this.d = QQGuildUtil.a(this.b);
    this.e = paramQQGuildTitleBarFragment.getExtras().getString("extra_channel_id");
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).addObserver(this.v);
  }
  
  protected void a(IGetGProUserListPaginationCallback.Result paramResult)
  {
    if ((paramResult.a == 0) && (paramResult.c != null) && (paramResult.e != null))
    {
      this.t = paramResult.e;
      if (paramResult.d) {
        this.j.setValue(Boolean.valueOf(true));
      }
      this.g.setValue(paramResult.c);
      this.r = false;
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(2131890505));
    this.g.setValue(null);
    this.r = false;
  }
  
  void a(IGProUserInfo paramIGProUserInfo)
  {
    if ((paramIGProUserInfo != null) && (this.b != null))
    {
      if (!this.c) {
        return;
      }
      boolean bool2 = QLog.isColorLevel();
      boolean bool1 = false;
      if (bool2) {
        QLog.d("QQGuildMemberListViewModel", 2, new Object[] { "onSetOrUnsetAdminClick userInfo:", paramIGProUserInfo });
      }
      if (paramIGProUserInfo.d() != 1) {
        bool1 = true;
      }
      ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).setGuildAdmin(this.b.getGuildID(), paramIGProUserInfo.a(), bool1, new QQGuildMemberListViewModel.4(this, bool1, paramIGProUserInfo));
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.b == null)
    {
      QQGuildUtil.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131890505));
      this.g.setValue(null);
      return;
    }
    if (paramObject == null) {
      this.q.setValue(Boolean.valueOf(true));
    }
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).getUserList(this.b.getGuildID(), paramObject, true, new QQGuildMemberListViewModel.5(this));
    this.r = true;
  }
  
  public void a(String paramString)
  {
    if (l() == null)
    {
      QQGuildUtil.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131890512));
      return;
    }
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).searchGuildUserByGuildNickname(l().getGuildID(), paramString, 0, new QQGuildMemberListViewModel.6(this));
  }
  
  protected void a(List<ISearchResultModel<IGProUserInfo>> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new ArrayList(((ISearchResultModel)paramList.get(0)).b());
      this.k.setValue(paramList);
      return;
    }
    QLog.w("QQGuildMemberListViewModel", 1, "handleRequestSearchResultList but list is null");
  }
  
  public void a(List<IGProUserInfo> paramList, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)localIterator.next();
      localArrayList.add(localIGProUserInfo.a());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleDeleteUserInner userInfo:");
        localStringBuilder.append(localIGProUserInfo.a());
        QLog.d("QQGuildMemberListViewModel", 2, localStringBuilder.toString());
      }
    }
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).kickGuildUsers(this.b.getGuildID(), localArrayList, paramBoolean, new QQGuildMemberListViewModel.3(this, paramList, paramIResultWithSecurityCallback));
  }
  
  @MainThread
  public void a(boolean paramBoolean)
  {
    this.h.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public LiveData<Boolean> b()
  {
    return this.l;
  }
  
  public void b(List<String> paramList)
  {
    if (this.b == null) {
      return;
    }
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).fetchUserInfo(this.b.getGuildID(), paramList, true, new QQGuildMemberListViewModel.7(this));
  }
  
  @MainThread
  public void b(boolean paramBoolean)
  {
    this.l.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public boolean c()
  {
    return (this.h.getValue() != null) && (((Boolean)this.h.getValue()).booleanValue());
  }
  
  public LiveData<Boolean> d()
  {
    return this.f;
  }
  
  public LiveData<List<IGProUserInfo>> e()
  {
    return this.g;
  }
  
  public LiveData<Boolean> f()
  {
    return this.j;
  }
  
  public MutableLiveData<IGProUserInfo> g()
  {
    return this.m;
  }
  
  public MutableLiveData<IGProUserInfo> h()
  {
    return this.n;
  }
  
  public MutableLiveData<List<IGProUserInfo>> i()
  {
    return this.o;
  }
  
  public LiveData<List<IGProUserInfo>> j()
  {
    return this.p;
  }
  
  public LiveData<Boolean> k()
  {
    return this.q;
  }
  
  public IGProGuildInfo l()
  {
    return this.b;
  }
  
  public boolean m()
  {
    return this.c;
  }
  
  public boolean n()
  {
    return this.d;
  }
  
  public boolean o()
  {
    return (this.c) || (this.d);
  }
  
  public boolean p()
  {
    return this.r;
  }
  
  public LiveData<IGuildMemberCountInfos> q()
  {
    return this.i;
  }
  
  public LiveData<List<IGProUserInfo>> r()
  {
    return this.k;
  }
  
  public void s()
  {
    a(this.t);
  }
  
  public void t()
  {
    a(null);
  }
  
  public void u()
  {
    this.a = true;
    ((IGPSService)this.s.getRuntimeService(IGPSService.class, "")).deleteObserver(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel
 * JD-Core Version:    0.7.0.1
 */