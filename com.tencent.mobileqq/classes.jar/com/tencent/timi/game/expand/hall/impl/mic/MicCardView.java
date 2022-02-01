package com.tencent.timi.game.expand.hall.impl.mic;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.mic.api.IMicDataObserver;
import com.tencent.timi.game.mic.api.MicDataListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.ILifeCycleView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/mic/MicCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/mic/api/IMicDataObserver;", "Lcom/tencent/timi/game/ui/ILifeCycleView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mData", "Ljava/util/ArrayList;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "Lkotlin/collections/ArrayList;", "mItemLeftMargin", "mItemViewList", "Lcom/tencent/timi/game/expand/hall/impl/mic/MicItemView;", "mItemViewRelationPool", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mMicDataListener", "Lcom/tencent/timi/game/mic/api/MicDataListener;", "mRoomId", "", "calItemLeftMargin", "", "destroy", "initSubViews", "onAudioMemberMicLevelChanged", "memberMicLevelList", "Ljava/util/concurrent/ConcurrentHashMap;", "onRefreshSpeakingPosInfoList", "dataList", "", "refreshDataInner", "data", "refreshUI", "registerRoomListener", "unRegisterRoomListener", "updateRoomId", "roomId", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicCardView
  extends FrameLayout
  implements IMicDataObserver, ILifeCycleView
{
  public static final MicCardView.Companion a = new MicCardView.Companion(null);
  private static final int h = CommonExKt.a(16);
  private static final int i = CommonExKt.a(16);
  private int b;
  private final ArrayList<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> c = new ArrayList();
  private long d;
  private final MicDataListener e = new MicDataListener((IMicDataObserver)this);
  private final HashMap<String, MicItemView> f = new HashMap();
  private final ArrayList<MicItemView> g = new ArrayList();
  private HashMap j;
  
  @JvmOverloads
  public MicCardView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public MicCardView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public MicCardView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629522, (ViewGroup)this);
    b();
    d();
  }
  
  private final void b()
  {
    int k = ScreenUtils.c();
    int m = k - h - i;
    int n = m - MicItemView.a.a() * 6;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("calItemLeftMargin screenWidth:");
    localStringBuilder.append(k);
    localStringBuilder.append(", contentWidth:");
    localStringBuilder.append(m);
    localStringBuilder.append(", remainWidth:");
    localStringBuilder.append(n);
    Logger.b("MicCardView_", localStringBuilder.toString());
    if (n >= 0)
    {
      this.b = (n / 5);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("calItemLeftMargin mItemLeftMargin:");
      localStringBuilder.append(this.b);
      Logger.b("MicCardView_", localStringBuilder.toString());
    }
  }
  
  private final void b(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    this.c.clear();
    this.c.addAll((Collection)paramList);
    paramList = new StringBuilder();
    paramList.append("refreshDataInner mRoomId:");
    paramList.append(this.d);
    paramList.append(", mData size:");
    paramList.append(this.c.size());
    Logger.a("MicCardView_", 1, paramList.toString());
    c();
  }
  
  private final void c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("data size:");
    ((StringBuilder)localObject1).append(this.c.size());
    ((StringBuilder)localObject1).append(", view size");
    ((StringBuilder)localObject1).append(this.g.size());
    Logger.b("MicCardView_", ((StringBuilder)localObject1).toString());
    int n = RangesKt.coerceAtMost(this.c.size(), this.g.size());
    this.f.clear();
    localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    boolean bool;
    if (localObject1 != null) {
      bool = ((IExpandHall)localObject1).k();
    } else {
      bool = false;
    }
    int m = 0;
    int k = 0;
    while (m < n)
    {
      localObject1 = (MicItemView)this.g.get(m);
      long l = this.d;
      Object localObject2 = this.c.get(m);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mData[i]");
      ((MicItemView)localObject1).a(l, m, (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localObject2, (List)this.c);
      localObject1 = this.g.get(m);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemViewList[i]");
      ((MicItemView)localObject1).setVisibility(0);
      localObject1 = (Map)this.f;
      localObject2 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)this.c.get(m)).uid.get());
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…tring(mData[i].uid.get())");
      Object localObject3 = this.g.get(m);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "mItemViewList[i]");
      ((Map)localObject1).put(localObject2, localObject3);
      if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)this.c.get(m)).uid.get() != 0L) {
        k = 1;
      }
      m += 1;
    }
    if (n < this.c.size())
    {
      int i1 = this.c.size();
      m = n;
      while (m < i1)
      {
        localObject1 = this.g.get(m);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mItemViewList[i]");
        ((MicItemView)localObject1).setVisibility(4);
        m += 1;
      }
    }
    if ((!bool) && (k == 0))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  private final void d()
  {
    this.g.clear();
    int m = 0;
    int k = 0;
    Object localObject;
    while (k < 6)
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = new MicItemView((Context)localObject, null, 0, 6, null);
      this.g.add(localObject);
      k += 1;
    }
    ((LinearLayout)a(2131431334)).removeAllViews();
    k = m;
    while (k < 6)
    {
      m = MicItemView.a.a();
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = new LinearLayout.LayoutParams(m, (int)((Context)localObject).getResources().getDimension(2131299897));
      if (k != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.b;
      }
      ((LinearLayout)a(2131431334)).addView((View)this.g.get(k), (ViewGroup.LayoutParams)localObject);
      k += 1;
    }
  }
  
  private final void e()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).a((YoloRoomInterface.YoloRoomCommonListener)this.e);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).a((YoloRoomInterface.YoloRoomAudioListener)this.e);
  }
  
  private final void f()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).b((YoloRoomInterface.YoloRoomCommonListener)this.e);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.d).b((YoloRoomInterface.YoloRoomAudioListener)this.e);
  }
  
  public View a(int paramInt)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    View localView2 = (View)this.j.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.j.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    f();
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext()) {
      ((MicItemView)localIterator.next()).b();
    }
    this.f.clear();
  }
  
  public final void a(long paramLong)
  {
    long l = this.d;
    if ((l != 0L) && (l != paramLong)) {
      f();
    }
    this.d = paramLong;
    e();
  }
  
  public void a(@NotNull List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    b(paramList);
  }
  
  public void a(@NotNull ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "memberMicLevelList");
    if (paramConcurrentHashMap.size() <= 0) {
      return;
    }
    paramConcurrentHashMap = ((Map)paramConcurrentHashMap).entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramConcurrentHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      int k;
      if (((Number)((Map.Entry)localObject).getValue()).intValue() >= 10) {
        k = 1;
      } else {
        k = 0;
      }
      localObject = (MicItemView)this.f.get(str);
      if ((k != 0) && (localObject != null)) {
        ((MicItemView)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicCardView
 * JD-Core Version:    0.7.0.1
 */