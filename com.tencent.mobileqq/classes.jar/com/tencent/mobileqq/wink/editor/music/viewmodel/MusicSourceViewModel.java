package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.squareup.wire.internal.Internal;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadCallback;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.MusicDownloadRunnable;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.CameraType;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.DataType;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.VideoType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_bgmSourceLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "bgmSourceLiveData", "Landroidx/lifecycle/LiveData;", "getBgmSourceLiveData", "()Landroidx/lifecycle/LiveData;", "currentMusic", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "getCurrentMusic", "()Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "setCurrentMusic", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;)V", "editMode", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "getEditMode", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "setEditMode", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "enableMusic", "", "getEnableMusic", "()Z", "setEnableMusic", "(Z)V", "endTimeInMs", "", "getEndTimeInMs", "()Ljava/lang/Integer;", "setEndTimeInMs", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "errorLiveData", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "firstSetDuration", "getFirstSetDuration", "setFirstSetDuration", "hasTemplateBGM", "getHasTemplateBGM", "hasTemplateInVideoMode", "Ljava/lang/Boolean;", "intentFromWebView", "Landroid/content/Intent;", "lastMusic", "getLastMusic", "setLastMusic", "musicBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "musicDownloadLiveDataMap", "Ljava/util/HashMap;", "", "musicItemInfoFromWeb", "Lcom/tencent/mobileqq/wink/editor/music/VsMusicItemInfo;", "musicList", "", "getMusicList", "musicPos", "getMusicPos", "musicStartTimeMap", "", "needAutoMusic", "getNeedAutoMusic", "setNeedAutoMusic", "selectImageBGM", "getSelectImageBGM", "selectTemplateBGM", "getSelectTemplateBGM", "startTimeInMs", "getStartTimeInMs", "setStartTimeInMs", "value", "", "videoDurationMs", "getVideoDurationMs", "()J", "setVideoDurationMs", "(J)V", "webCallback", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$WebCallback;", "getWebCallback", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$WebCallback;", "setWebCallback", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$WebCallback;)V", "addTemplateHolder", "", "clearImageBgmData", "clearMaterialBgmData", "clearMusic", "clearMusicForTemplate", "clearTavCutBgmData", "downloadMusic", "musicInfo", "callback", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicHelper$MusicDownloadCallback;", "getDownloadingMusicLiveData", "songMid", "getMusicStartTime", "musicMid", "(Ljava/lang/String;)Ljava/lang/Integer;", "getRecommendMusicList", "bitmaps", "", "tongKuanMusic", "mergeMusicList", "queriedMusicList", "currentMusicList", "onMusicSelected", "selectedMusicInfo", "position", "needScroll", "onReceiveWebBroadcast", "context", "Landroid/content/Context;", "intent", "refreshClipArguments", "selectedMusic", "removeTemplateHolder", "removeTemplateHolderAndClearMusic", "requestDetailedMusicInfoForWeb", "vsMusicItemInfo", "needSelect", "resetRange", "restoreCurrentBgm", "saveMusicStartTime", "forceUpdate", "sendLoadingSuccessToWebView", "setAutoMusic", "setEditModeAndRefresh", "newEditMode", "setMusicDuration", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setTemplateHolder", "hasTemplateMusic", "startCacheDownloadMusic", "editorMusicInfo", "updateBgmData", "updateBgmRange", "updateCurrentBgm", "updateImageBgmData", "imageMusicInfo", "updateMaterialBgmData", "data", "originVolume", "", "bgmVolume", "localPath", "updateMusicListOnDownload", "downloadStatus", "progress", "updateMusicListOnDownloadFinished", "succeeded", "updateTavCutBgmData", "WebCallback", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicSourceViewModel
  extends ViewModel
{
  @NotNull
  private final MutableLiveData<List<WinkEditorMusicInfo>> a = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Integer> b = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> c = new MutableLiveData();
  @NotNull
  private final MutableLiveData<Boolean> d = new MutableLiveData();
  private boolean e;
  private boolean f = true;
  @NotNull
  private WinkEditorViewModel.EditMode g = WinkEditorViewModel.EditMode.Video;
  @NotNull
  private final MutableLiveData<WinkEditorMusicInfo> h = new MutableLiveData();
  @Nullable
  private MusicSourceViewModel.WebCallback i;
  private long j = 15000L;
  private final HashMap<String, MutableLiveData<WinkEditorMusicInfo>> k = new HashMap();
  @Nullable
  private WinkEditorMusicInfo l;
  @Nullable
  private WinkEditorMusicInfo m;
  private boolean n;
  @Nullable
  private Integer o;
  @Nullable
  private Integer p;
  private VsMusicItemInfo q;
  private Intent r;
  private final Map<String, Integer> s = (Map)new HashMap();
  @NotNull
  private final MutableLiveData<Integer> t = new MutableLiveData();
  private Boolean u = Boolean.valueOf(false);
  private final MutableLiveData<MusicInfoWrapper> v = new MutableLiveData();
  @NotNull
  private final LiveData<MusicInfoWrapper> w;
  
  public MusicSourceViewModel()
  {
    MutableLiveData localMutableLiveData = this.v;
    if (localMutableLiveData != null)
    {
      this.w = ((LiveData)localMutableLiveData);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper>");
  }
  
  private final List<WinkEditorMusicInfo> a(WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt1, int paramInt2)
  {
    if (paramWinkEditorMusicInfo.a()) {
      return null;
    }
    List localList = (List)this.a.getValue();
    if (localList != null)
    {
      localList = CollectionsKt.toMutableList((Collection)localList);
      if (localList != null) {}
    }
    else
    {
      localList = (List)new LinkedList();
    }
    int i2 = 0;
    Iterator localIterator = localList.iterator();
    WinkEditorMusicInfo localWinkEditorMusicInfo;
    do
    {
      i1 = i2;
      if (!localIterator.hasNext()) {
        break;
      }
      localWinkEditorMusicInfo = (WinkEditorMusicInfo)localIterator.next();
    } while ((localWinkEditorMusicInfo == null) || (localWinkEditorMusicInfo.a()) || (paramWinkEditorMusicInfo.f == 1) || (paramWinkEditorMusicInfo.f == 0) || (!Intrinsics.areEqual(paramWinkEditorMusicInfo.c(), localWinkEditorMusicInfo.c())));
    localWinkEditorMusicInfo.d = paramInt1;
    localWinkEditorMusicInfo.e = paramInt2;
    int i1 = 1;
    if (i1 != 0) {
      return localList;
    }
    return null;
  }
  
  private final List<WinkEditorMusicInfo> a(WinkEditorMusicInfo paramWinkEditorMusicInfo, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    return a(paramWinkEditorMusicInfo, i1, 0);
  }
  
  private final void a(VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean)
  {
    this.q = ((VsMusicItemInfo)null);
    if (paramVsMusicItemInfo == null) {
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    if (WinkEditorMusicHelper.a(paramVsMusicItemInfo))
    {
      if (paramBoolean)
      {
        a(new WinkEditorMusicInfo(paramVsMusicItemInfo, false, 2), 1);
        return;
      }
      a(new WinkEditorMusicInfo(paramVsMusicItemInfo, false, 2));
    }
  }
  
  private final List<WinkEditorMusicInfo> b(List<? extends WinkEditorMusicInfo> paramList1, List<? extends WinkEditorMusicInfo> paramList2)
  {
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap = new HashMap();
    paramList2 = ((Iterable)paramList2).iterator();
    while (paramList2.hasNext())
    {
      WinkEditorMusicInfo localWinkEditorMusicInfo = (WinkEditorMusicInfo)paramList2.next();
      if ((!localWinkEditorMusicInfo.a()) && (localWinkEditorMusicInfo.f != 0))
      {
        localLinkedList.add(localWinkEditorMusicInfo);
        Map localMap = (Map)localHashMap;
        String str = localWinkEditorMusicInfo.c();
        Intrinsics.checkExpressionValueIsNotNull(str, "it.songMid");
        localMap.put(str, localWinkEditorMusicInfo);
      }
    }
    paramList1 = ((Iterable)paramList1).iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (WinkEditorMusicInfo)paramList1.next();
      if ((!paramList2.a()) && (localHashMap.get(paramList2.c()) == null)) {
        localLinkedList.add(paramList2);
      }
    }
    return (List)localLinkedList;
  }
  
  private final void d(WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((Intent)localObject).hasExtra("clipStartTime"))
      {
        localObject = this.r;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        this.o = Integer.valueOf(((Intent)localObject).getIntExtra("clipStartTime", 0));
        paramWinkEditorMusicInfo = paramWinkEditorMusicInfo.c();
        Intrinsics.checkExpressionValueIsNotNull(paramWinkEditorMusicInfo, "selectedMusic.getSongMid()");
        localObject = this.o;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        a(paramWinkEditorMusicInfo, ((Integer)localObject).intValue(), true);
      }
    }
  }
  
  private final void e(WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
      return;
    }
    if ((paramWinkEditorMusicInfo != null) && (this.n))
    {
      if (paramWinkEditorMusicInfo.f == 3) {
        return;
      }
      String str = WinkEditorMusicHelper.a(paramWinkEditorMusicInfo);
      Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorMusicHelper.ge…usicPath(editorMusicInfo)");
      boolean bool = WinkEditorMusicHelper.a(str);
      q();
      if (bool)
      {
        paramWinkEditorMusicInfo.d = 2;
        if (this.r != null) {
          b(paramWinkEditorMusicInfo);
        }
        this.r = ((Intent)null);
        a(paramWinkEditorMusicInfo, 50.0F, 50.0F, str);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramWinkEditorMusicInfo.c());
      WinkEditorMusicHelper.a(localArrayList, (VSDispatchObserver.onVSRspCallBack)new MusicSourceViewModel.updateBgmData.1(this, str));
      return;
    }
    q();
  }
  
  private final void y()
  {
    this.v.postValue(new MusicInfoWrapper(null, null, 0, 0, 14, null));
  }
  
  @NotNull
  public final MutableLiveData<List<WinkEditorMusicInfo>> a()
  {
    return this.a;
  }
  
  @Nullable
  public final Integer a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "musicMid");
    return (Integer)this.s.get(paramString);
  }
  
  public final void a(long paramLong)
  {
    if (this.j != paramLong)
    {
      this.j = paramLong;
      s();
    }
  }
  
  public final void a(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    if ((Intrinsics.areEqual("action_dispatch_music_event", paramIntent.getAction()) ^ true)) {
      return;
    }
    paramContext = paramIntent.getStringExtra("event");
    this.q = WinkEditorMusicHelper.a(paramIntent);
    this.r = paramIntent;
    if (this.q == null) {
      return;
    }
    if ((!Intrinsics.areEqual("kTribeSelectMusic", paramContext)) && (!Intrinsics.areEqual("kTribeClipsMusic", paramContext)))
    {
      if (Intrinsics.areEqual("kTribeDownloadMusic", paramContext)) {
        a(this.q, false);
      }
    }
    else {
      a(this.q, true);
    }
  }
  
  public final void a(@NotNull WinkEditorViewModel.EditMode paramEditMode)
  {
    Intrinsics.checkParameterIsNotNull(paramEditMode, "newEditMode");
    if (paramEditMode == this.g) {
      return;
    }
    if ((paramEditMode == WinkEditorViewModel.EditMode.Image) && (this.g == WinkEditorViewModel.EditMode.Video))
    {
      this.g = paramEditMode;
      this.u = ((Boolean)this.d.getValue());
      n();
      return;
    }
    this.g = paramEditMode;
    if (Intrinsics.areEqual(this.u, Boolean.valueOf(true)))
    {
      o();
      return;
    }
    s();
  }
  
  public final void a(@Nullable MusicSourceViewModel.WebCallback paramWebCallback)
  {
    this.i = paramWebCallback;
  }
  
  public final void a(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    if (paramWinkEditorMusicInfo != null)
    {
      String str = WinkEditorMusicHelper.a(paramWinkEditorMusicInfo);
      Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorMusicHelper.ge…usicPath(editorMusicInfo)");
      if (WinkEditorMusicHelper.a(str)) {
        return;
      }
      if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
        return;
      }
      if (paramWinkEditorMusicInfo.d == 1) {
        return;
      }
      paramWinkEditorMusicInfo.d = 1;
      ThreadManager.excute((Runnable)new WinkEditorMusicHelper.MusicDownloadRunnable(MobileQQ.sMobileQQ.peekAppRuntime(), paramWinkEditorMusicInfo, paramWinkEditorMusicInfo.f(), str, (WinkEditorMusicHelper.MusicDownloadCallback)new MusicSourceViewModel.startCacheDownloadMusic.1.runnable.1()), 128, null, true);
    }
  }
  
  public final void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, float paramFloat1, float paramFloat2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "data");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    if (this.g == WinkEditorViewModel.EditMode.Image)
    {
      c(paramWinkEditorMusicInfo);
      return;
    }
    r();
    b(paramWinkEditorMusicInfo, paramFloat1, paramFloat2, paramString);
  }
  
  public final void a(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt)
  {
    a(paramWinkEditorMusicInfo, paramInt, true);
  }
  
  public final void a(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt, boolean paramBoolean)
  {
    this.m = this.l;
    this.l = paramWinkEditorMusicInfo;
    List localList = (List)this.a.getValue();
    if (localList != null)
    {
      localList = CollectionsKt.toMutableList((Collection)localList);
      if (localList != null) {}
    }
    else
    {
      localList = WinkEditorMusicInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localList, "WinkEditorMusicInfo.DEFAULT_LIST");
    }
    Iterator localIterator = localList.iterator();
    int i1 = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (WinkEditorMusicInfo)localIterator.next();
      if ((localObject != null) && (!((WinkEditorMusicInfo)localObject).a()) && (((WinkEditorMusicInfo)localObject).f != 1) && (((WinkEditorMusicInfo)localObject).f != 0) && (paramWinkEditorMusicInfo != null)) {
        if (Intrinsics.areEqual(paramWinkEditorMusicInfo.c(), ((WinkEditorMusicInfo)localObject).c()))
        {
          ((WinkEditorMusicInfo)localObject).c = true;
          this.l = ((WinkEditorMusicInfo)localObject);
          paramWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject;
          i1 = 1;
        }
        else
        {
          ((WinkEditorMusicInfo)localObject).c = false;
        }
      }
    }
    if (paramWinkEditorMusicInfo != null)
    {
      this.n = true;
      int i2 = paramInt;
      if (i1 == 0)
      {
        paramWinkEditorMusicInfo.c = true;
        i1 = localList.size() - 1;
        if (paramInt > i1)
        {
          i2 = i1 + 1;
          localList.add(paramWinkEditorMusicInfo);
        }
        else
        {
          localList.add(paramInt, paramWinkEditorMusicInfo);
          i2 = paramInt;
        }
      }
      localObject = paramWinkEditorMusicInfo.c();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getSongMid()");
      a((String)localObject, paramWinkEditorMusicInfo.g(), false);
      d(paramWinkEditorMusicInfo);
      if (paramWinkEditorMusicInfo.f == 3)
      {
        this.d.postValue(Boolean.valueOf(true));
        u();
      }
      else
      {
        this.d.postValue(Boolean.valueOf(false));
        e(paramWinkEditorMusicInfo);
      }
      this.a.postValue(localList);
      if (paramBoolean) {
        this.b.postValue(Integer.valueOf(i2));
      }
    }
  }
  
  public final void a(@Nullable Integer paramInteger)
  {
    this.o = paramInteger;
  }
  
  public final void a(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    this.o = paramInteger1;
    this.p = paramInteger2;
  }
  
  public final void a(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "musicMid");
    if (paramBoolean)
    {
      this.s.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    if (!this.s.containsKey(paramString)) {
      this.s.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public final void a(@NotNull List<byte[]> paramList, @Nullable List<? extends WinkEditorMusicInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "bitmaps");
    WinkEditorMusicHelper.a(paramList, null, QQWinkSmartMatchMusicReq.VideoType.LocalFile, null, QQWinkSmartMatchMusicReq.CameraType.Back, "", QQWinkSmartMatchMusicReq.DataType.PicString, (VSDispatchObserver.onVSRspCallBack)new MusicSourceViewModel.getRecommendMusicList.1(this, paramList1));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  @NotNull
  public final MutableLiveData<Integer> b()
  {
    return this.b;
  }
  
  public final void b(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "musicInfo");
    MusicSourceViewModel.WebCallback localWebCallback = this.i;
    if (localWebCallback != null) {
      localWebCallback.a(paramWinkEditorMusicInfo);
    }
  }
  
  public final void b(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, float paramFloat1, float paramFloat2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "data");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    MutableLiveData localMutableLiveData = this.v;
    Object localObject = paramWinkEditorMusicInfo.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "data.songMid");
    localObject = a((String)localObject);
    int i1;
    if (localObject != null) {
      i1 = ((Integer)localObject).intValue();
    } else {
      i1 = paramWinkEditorMusicInfo.g();
    }
    localMutableLiveData.postValue(new MusicInfoWrapper(paramWinkEditorMusicInfo, paramString, i1, (int)this.j));
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject1 = (List)this.a.getValue();
    if (localObject1 != null) {
      localObject1 = CollectionsKt.toMutableList((Collection)localObject1);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if (paramBoolean)
      {
        if (!((List)localObject1).contains(WinkEditorMusicInfo.b))
        {
          localObject2 = WinkEditorMusicInfo.b;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "WinkEditorMusicInfo.TEMPLATE_BGM_HOLDER");
          ((List)localObject1).add(1, localObject2);
        }
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((WinkEditorMusicInfo)((Iterator)localObject2).next()).c = false;
        }
        WinkEditorMusicInfo.b.c = true;
      }
      else
      {
        ((List)localObject1).remove(WinkEditorMusicInfo.b);
      }
      this.a.postValue(localObject1);
      return;
    }
    localObject1 = (MusicSourceViewModel)this;
    localObject1 = Internal.newMutableList();
    Object localObject2 = WinkEditorMusicInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "WinkEditorMusicInfo.DEFAULT_LIST");
    ((List)localObject1).addAll((Collection)localObject2);
    if (paramBoolean)
    {
      localObject2 = WinkEditorMusicInfo.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "WinkEditorMusicInfo.TEMPLATE_BGM_HOLDER");
      ((List)localObject1).add(1, localObject2);
      WinkEditorMusicInfo.b.c = true;
    }
    else
    {
      ((List)localObject1).remove(WinkEditorMusicInfo.b);
    }
    this.a.postValue(localObject1);
  }
  
  @NotNull
  public final MutableLiveData<Boolean> c()
  {
    return this.c;
  }
  
  public final void c(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "imageMusicInfo");
    this.h.postValue(paramWinkEditorMusicInfo);
  }
  
  @NotNull
  public final MutableLiveData<Boolean> d()
  {
    return this.d;
  }
  
  @NotNull
  public final WinkEditorViewModel.EditMode e()
  {
    return this.g;
  }
  
  @NotNull
  public final MutableLiveData<WinkEditorMusicInfo> f()
  {
    return this.h;
  }
  
  public final long g()
  {
    return this.j;
  }
  
  @Nullable
  public final WinkEditorMusicInfo h()
  {
    return this.l;
  }
  
  @Nullable
  public final Integer i()
  {
    return this.o;
  }
  
  @NotNull
  public final MutableLiveData<Integer> j()
  {
    return this.t;
  }
  
  public final void k()
  {
    if (this.e)
    {
      this.e = false;
      Object localObject = (List)this.a.getValue();
      if (localObject != null)
      {
        localObject = (WinkEditorMusicInfo)CollectionsKt.getOrNull((List)localObject, 1);
        if (localObject != null) {
          a((WinkEditorMusicInfo)localObject, 1, false);
        }
      }
    }
  }
  
  public final void l()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      Integer localInteger = this.o;
      if (localInteger != null)
      {
        int i1 = ((Number)localInteger).intValue();
        localObject = ((WinkEditorMusicInfo)localObject).c();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "music.songMid");
        a((String)localObject, i1, true);
      }
    }
  }
  
  public final void m()
  {
    Object localObject = (List)this.a.getValue();
    if (localObject != null) {
      localObject = CollectionsKt.toMutableList((Collection)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ((((List)localObject).size() > 1) && (((WinkEditorMusicInfo)((List)localObject).get(1)).f == 3)) {
        ((List)localObject).remove(1);
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext()) {
        ((WinkEditorMusicInfo)localIterator.next()).c = false;
      }
      this.a.setValue(localObject);
    }
    this.l = ((WinkEditorMusicInfo)null);
    localObject = (Integer)null;
    this.o = ((Integer)localObject);
    this.p = ((Integer)localObject);
    this.n = false;
    this.m = this.l;
    s();
  }
  
  public final void n()
  {
    Object localObject = (List)this.a.getValue();
    if (localObject != null) {
      localObject = CollectionsKt.toMutableList((Collection)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ((((List)localObject).size() > 1) && (((WinkEditorMusicInfo)((List)localObject).get(1)).f == 3)) {
        ((List)localObject).remove(1);
      }
      this.a.setValue(localObject);
    }
    localObject = this.l;
    if ((localObject != null) && (((WinkEditorMusicInfo)localObject).f == 3))
    {
      this.e = true;
      k();
      return;
    }
    s();
  }
  
  public final void o()
  {
    List localList = (List)this.a.getValue();
    if (localList != null) {
      localList = CollectionsKt.toMutableList((Collection)localList);
    } else {
      localList = null;
    }
    if (localList != null)
    {
      if ((localList.size() > 1) && (((WinkEditorMusicInfo)localList.get(1)).f != 3))
      {
        localWinkEditorMusicInfo = WinkEditorMusicInfo.l();
        Intrinsics.checkExpressionValueIsNotNull(localWinkEditorMusicInfo, "WinkEditorMusicInfo.asse…eTemplateBGMPlaceHolder()");
        localList.add(1, localWinkEditorMusicInfo);
      }
      this.a.setValue(localList);
      WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
      a(localWinkEditorMusicInfo, CollectionsKt.indexOf(localList, localWinkEditorMusicInfo));
    }
  }
  
  @NotNull
  public final LiveData<MusicInfoWrapper> p()
  {
    return this.w;
  }
  
  public final void q()
  {
    if (this.g == WinkEditorViewModel.EditMode.Image)
    {
      r();
      return;
    }
    y();
  }
  
  public final void r()
  {
    this.h.postValue(null);
  }
  
  public final void s()
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
    if (localWinkEditorMusicInfo != null)
    {
      String str = WinkEditorMusicHelper.a(localWinkEditorMusicInfo);
      Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorMusicHelper.getLocalMusicPath(it)");
      a(localWinkEditorMusicInfo, 50.0F, 50.0F, str);
    }
  }
  
  public final void t()
  {
    if (this.l != null)
    {
      Object localObject2 = null;
      this.l = ((WinkEditorMusicInfo)null);
      Object localObject1 = (Integer)null;
      this.o = ((Integer)localObject1);
      this.p = ((Integer)localObject1);
      this.n = false;
      this.m = this.l;
      List localList = (List)this.a.getValue();
      if (localList != null)
      {
        Iterator localIterator = ((Iterable)localList).iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = localIterator.next();
        } while (!((WinkEditorMusicInfo)localObject1).c);
        localObject1 = (WinkEditorMusicInfo)localObject1;
        if (localObject1 != null) {
          ((WinkEditorMusicInfo)localObject1).c = false;
        }
        this.a.postValue(localList);
      }
      q();
    }
    this.d.postValue(Boolean.valueOf(false));
  }
  
  public final void u()
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
    if (localWinkEditorMusicInfo != null)
    {
      Integer localInteger = (Integer)null;
      this.o = localInteger;
      this.p = localInteger;
      this.m = localWinkEditorMusicInfo;
      q();
    }
  }
  
  public final void v()
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
    if (localWinkEditorMusicInfo != null)
    {
      MutableLiveData localMutableLiveData = this.v;
      String str = WinkEditorMusicHelper.a(localWinkEditorMusicInfo);
      Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorMusicHelper.getLocalMusicPath(it)");
      Object localObject = localWinkEditorMusicInfo.c();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.songMid");
      localObject = a((String)localObject);
      int i1;
      if (localObject != null) {
        i1 = ((Integer)localObject).intValue();
      } else {
        i1 = localWinkEditorMusicInfo.g();
      }
      localMutableLiveData.postValue(new MusicInfoWrapper(localWinkEditorMusicInfo, str, i1, (int)this.j));
    }
  }
  
  public final void w()
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
    if (localWinkEditorMusicInfo != null)
    {
      Object localObject = this.o;
      if (localObject != null)
      {
        int i1 = ((Number)localObject).intValue();
        localObject = WinkLyricProgressCalculator.a();
        long l1 = i1;
        ((WinkLyricProgressCalculator)localObject).b(l1, RangesKt.coerceAtMost(this.j + l1, localWinkEditorMusicInfo.h()));
        localObject = this.v;
        String str = WinkEditorMusicHelper.a(localWinkEditorMusicInfo);
        Intrinsics.checkExpressionValueIsNotNull(str, "WinkEditorMusicHelper.getLocalMusicPath(music)");
        Integer localInteger = this.o;
        if (localInteger != null) {
          i1 = localInteger.intValue();
        } else {
          i1 = localWinkEditorMusicInfo.g();
        }
        ((MutableLiveData)localObject).postValue(new MusicInfoWrapper(localWinkEditorMusicInfo, str, i1, (int)this.j));
      }
    }
  }
  
  public final void x()
  {
    WinkEditorMusicInfo localWinkEditorMusicInfo = this.l;
    if (localWinkEditorMusicInfo != null)
    {
      a(Integer.valueOf(localWinkEditorMusicInfo.g()), Integer.valueOf((int)(localWinkEditorMusicInfo.g() + this.j)));
      w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel
 * JD-Core Version:    0.7.0.1
 */