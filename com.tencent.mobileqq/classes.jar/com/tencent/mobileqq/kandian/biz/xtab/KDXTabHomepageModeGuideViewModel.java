package com.tencent.mobileqq.kandian.biz.xtab;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.kandian.repo.xtab.KDXTabHomepageModeGuideRepo;
import com.tencent.mobileqq.kandian.repo.xtab.KDXTabHomepageModeGuideRepo.KDXTabHomepageModeGuideRemoteConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuideViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_shouldHideGuide", "Landroidx/lifecycle/MutableLiveData;", "", "_showGuideData", "Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuideViewModel$HomepageGuideData;", "currentShowingChannelId", "", "remoteConfig", "Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo$KDXTabHomepageModeGuideRemoteConfig;", "repo", "Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo;", "getRepo", "()Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeGuideRepo;", "repo$delegate", "Lkotlin/Lazy;", "shouldHideGuide", "Landroidx/lifecycle/LiveData;", "getShouldHideGuide", "()Landroidx/lifecycle/LiveData;", "showHomePageModeGuideData", "getShowHomePageModeGuideData", "checkNeedShowHomepageModeGuide", "", "channelId", "consume", "hasShownBefore", "onAccountChanged", "onChannelSwitched", "onExitKDTab", "onReceiveRemoteConfig", "Companion", "HomepageGuideData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeGuideViewModel
  extends ViewModel
{
  public static final KDXTabHomepageModeGuideViewModel.Companion a = new KDXTabHomepageModeGuideViewModel.Companion(null);
  private final Lazy b = LazyKt.lazy((Function0)KDXTabHomepageModeGuideViewModel.repo.2.INSTANCE);
  private final MutableLiveData<KDXTabHomepageModeGuideViewModel.HomepageGuideData> c = new MutableLiveData();
  @NotNull
  private final LiveData<KDXTabHomepageModeGuideViewModel.HomepageGuideData> d = (LiveData)this.c;
  private final MutableLiveData<Boolean> e = new MutableLiveData();
  @NotNull
  private final LiveData<Boolean> f = (LiveData)this.e;
  private int g = -1;
  private final KDXTabHomepageModeGuideRepo.KDXTabHomepageModeGuideRemoteConfig h = g().a();
  
  private final void b(int paramInt)
  {
    if (!this.h.a())
    {
      QLog.w("KDXTabHomepageModeGuideViewModel", 1, "checkNeedShowHomepageModeGuide=false, enable=false");
      return;
    }
    StringBuilder localStringBuilder;
    if (!this.h.f())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNeedShowHomepageModeGuide=false, remoteConfig invalid=");
      localStringBuilder.append(this.h);
      QLog.e("KDXTabHomepageModeGuideViewModel", 1, localStringBuilder.toString());
      return;
    }
    if ((paramInt != 41726) && (paramInt != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNeedShowHomepageModeGuide=false, not in channel=");
      localStringBuilder.append(paramInt);
      QLog.w("KDXTabHomepageModeGuideViewModel", 1, localStringBuilder.toString());
      return;
    }
    if (h())
    {
      QLog.w("KDXTabHomepageModeGuideViewModel", 1, "checkNeedShowHomepageModeGuide=false, hasShownBefore=true");
      return;
    }
    this.c.setValue(new KDXTabHomepageModeGuideViewModel.HomepageGuideData(this.h.d(), this.h.e(), this.h.b()));
    g().a(this.h.c());
  }
  
  private final KDXTabHomepageModeGuideRepo g()
  {
    return (KDXTabHomepageModeGuideRepo)this.b.getValue();
  }
  
  private final boolean h()
  {
    long l1 = this.h.c();
    long l2 = g().b();
    boolean bool = false;
    if (l2 == -1L)
    {
      QLog.i("KDXTabHomepageModeGuideViewModel", 1, "lastShownTimestamp = -1, hasShowBefore=false");
      return false;
    }
    if (l1 == -1L)
    {
      QLog.i("KDXTabHomepageModeGuideViewModel", 1, "currentConfigTimestamp = -1, hasShowBefore=true");
      return true;
    }
    if (l2 == l1) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasShowBefore=");
    localStringBuilder.append(bool);
    QLog.i("KDXTabHomepageModeGuideViewModel", 1, localStringBuilder.toString());
    return bool;
  }
  
  @NotNull
  public final LiveData<KDXTabHomepageModeGuideViewModel.HomepageGuideData> a()
  {
    return this.d;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onChannelSwitched=");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("KDXTabHomepageModeGuideViewModel", 1, (String)localObject);
    this.g = paramInt;
    b(paramInt);
    localObject = this.e;
    if ((paramInt == 41726) || (paramInt == 0)) {
      bool = false;
    }
    ((MutableLiveData)localObject).setValue(Boolean.valueOf(bool));
  }
  
  @NotNull
  public final LiveData<Boolean> b()
  {
    return this.f;
  }
  
  public final void c()
  {
    this.c.setValue(null);
    this.e.setValue(Boolean.valueOf(false));
    this.g = -1;
  }
  
  public final void d()
  {
    this.c.setValue(null);
  }
  
  public final void e()
  {
    QLog.i("KDXTabHomepageModeGuideViewModel", 1, "onExitKDTab");
    this.g = -1;
    this.e.setValue(Boolean.valueOf(true));
  }
  
  public final void f()
  {
    b(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.KDXTabHomepageModeGuideViewModel
 * JD-Core Version:    0.7.0.1
 */