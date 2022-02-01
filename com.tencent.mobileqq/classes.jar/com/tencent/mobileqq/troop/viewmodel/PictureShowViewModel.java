package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareManager;
import com.tencent.mobileqq.kandian.biz.share.api.ShareCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowViewModel;", "Landroidx/lifecycle/ViewModel;", "data", "Lcom/tencent/mobileqq/troop/viewmodel/SocialBottomBarData;", "pictureShowActionNotifier", "Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;", "(Lcom/tencent/mobileqq/troop/viewmodel/SocialBottomBarData;Lcom/tencent/mobileqq/troop/viewmodel/IPictureShowActionNotifier;)V", "_commentNum", "Landroidx/lifecycle/MutableLiveData;", "", "get_commentNum", "()Landroidx/lifecycle/MutableLiveData;", "_commentNum$delegate", "Lkotlin/Lazy;", "_likeNum", "get_likeNum", "_likeNum$delegate", "_liked", "", "get_liked", "_liked$delegate", "_shareNum", "get_shareNum", "_shareNum$delegate", "commentNum", "Landroidx/lifecycle/LiveData;", "getCommentNum", "()Landroidx/lifecycle/LiveData;", "likeNum", "getLikeNum", "liked", "getLiked", "mReadInjoyObserver", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "mShareCallBack", "Lcom/tencent/mobileqq/kandian/biz/share/api/ShareCallBack;", "shareNum", "getShareNum", "canUpdateSocialBottomBarNum", "numString", "isCallbackRowKeyInvalid", "rowKey", "onActivityClose", "", "onCleared", "onCommentClick", "onLikeClick", "onShareClick", "sendViewActon", "type", "Lcom/tencent/mobileqq/troop/viewmodel/ViewActionType;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PictureShowViewModel
  extends ViewModel
{
  public static final PictureShowViewModel.Companion a = new PictureShowViewModel.Companion(null);
  private final Lazy b;
  private final Lazy c;
  private final Lazy d;
  private final Lazy e;
  @NotNull
  private final LiveData<String> f;
  @NotNull
  private final LiveData<String> g;
  @NotNull
  private final LiveData<String> h;
  @NotNull
  private final LiveData<Boolean> i;
  private final ReadInJoyObserver j;
  private final ShareCallBack k;
  private final SocialBottomBarData l;
  private final IPictureShowActionNotifier m;
  
  public PictureShowViewModel(@NotNull SocialBottomBarData paramSocialBottomBarData, @NotNull IPictureShowActionNotifier paramIPictureShowActionNotifier)
  {
    this.l = paramSocialBottomBarData;
    this.m = paramIPictureShowActionNotifier;
    this.b = LazyKt.lazy((Function0)new PictureShowViewModel._commentNum.2(this));
    this.c = LazyKt.lazy((Function0)new PictureShowViewModel._likeNum.2(this));
    this.d = LazyKt.lazy((Function0)new PictureShowViewModel._shareNum.2(this));
    this.e = LazyKt.lazy((Function0)new PictureShowViewModel._liked.2(this));
    this.f = ((LiveData)i());
    this.g = ((LiveData)j());
    this.h = ((LiveData)k());
    this.i = ((LiveData)l());
    this.j = ((ReadInJoyObserver)new PictureShowViewModel.mReadInjoyObserver.1(this));
    this.k = ((ShareCallBack)new PictureShowViewModel.mShareCallBack.1(this));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.j);
    ((IReadInJoyShareManager)QRoute.api(IReadInJoyShareManager.class)).addShareCallBack(this.k);
  }
  
  private final void a(ViewActionType paramViewActionType)
  {
    IPictureShowActionNotifier localIPictureShowActionNotifier = this.m;
    String str = this.l.b();
    int n = paramViewActionType.getValue();
    paramViewActionType = (Boolean)l().getValue();
    if (paramViewActionType == null) {
      paramViewActionType = Boolean.valueOf(false);
    }
    localIPictureShowActionNotifier.a(str, n, paramViewActionType.booleanValue());
  }
  
  private final boolean a(String paramString)
  {
    int n = ((CharSequence)this.l.a()).length();
    boolean bool = false;
    if (n == 0) {
      n = 1;
    } else {
      n = 0;
    }
    if ((n != 0) || (!StringsKt.equals(this.l.a(), paramString, true))) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {}
    try
    {
      int n = Intrinsics.compare(Integer.valueOf(paramString).intValue(), 0);
      bool1 = bool2;
      if (n >= 0) {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private final MutableLiveData<String> i()
  {
    return (MutableLiveData)this.b.getValue();
  }
  
  private final MutableLiveData<String> j()
  {
    return (MutableLiveData)this.c.getValue();
  }
  
  private final MutableLiveData<String> k()
  {
    return (MutableLiveData)this.d.getValue();
  }
  
  private final MutableLiveData<Boolean> l()
  {
    return (MutableLiveData)this.e.getValue();
  }
  
  @NotNull
  public final LiveData<String> a()
  {
    return this.f;
  }
  
  @NotNull
  public final LiveData<String> b()
  {
    return this.g;
  }
  
  @NotNull
  public final LiveData<String> c()
  {
    return this.h;
  }
  
  @NotNull
  public final LiveData<Boolean> d()
  {
    return this.i;
  }
  
  public final void e()
  {
    a(ViewActionType.SocialBottomBarCommentClickType);
  }
  
  public final void f()
  {
    MutableLiveData localMutableLiveData = l();
    Boolean localBoolean1 = (Boolean)l().getValue();
    Boolean localBoolean2 = Boolean.valueOf(true);
    localMutableLiveData.setValue(Boolean.valueOf(Intrinsics.areEqual(localBoolean1, localBoolean2) ^ true));
    if (b((String)j().getValue()))
    {
      int n;
      if (Intrinsics.areEqual((Boolean)l().getValue(), localBoolean2)) {
        n = Integer.valueOf((String)j().getValue()).intValue() + 1;
      } else {
        n = Integer.valueOf((String)j().getValue()).intValue() - 1;
      }
      j().setValue(String.valueOf(n));
    }
    a(ViewActionType.SocialBottomBarLikeClickType);
  }
  
  public final void g()
  {
    a(ViewActionType.SocialBottomBarShareClickType);
  }
  
  public final void h()
  {
    a(ViewActionType.ActivityClose);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.j);
    ((IReadInJoyShareManager)QRoute.api(IReadInJoyShareManager.class)).removeShareCallBack(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel
 * JD-Core Version:    0.7.0.1
 */