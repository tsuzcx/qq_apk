package com.tencent.timi.game.liveroom.impl.view.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.liveroom.impl.ad.TimiTianshuAdManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdditionList", "Ljava/util/ArrayList;", "Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationData;", "Lkotlin/collections/ArrayList;", "mDataList", "mDefaultList", "addAdditionList", "", "data", "", "addDefaultList", "dataList", "cleanAdditionList", "createOperationView", "Lcom/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView;", "pos", "fetchData", "fetchRedPackData", "roomId", "", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "refreshUI", "removeDataInAdditionList", "adId", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOperationContainer
  extends LinearLayout
{
  public static final AnchorOperationContainer.Companion a = new AnchorOperationContainer.Companion(null);
  private final ArrayList<OperationData> b = new ArrayList();
  private final ArrayList<OperationData> c = new ArrayList();
  private final ArrayList<OperationData> d = new ArrayList();
  
  @JvmOverloads
  public AnchorOperationContainer(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorOperationContainer(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorOperationContainer(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setPadding(LayoutExKt.b(16), 0, LayoutExKt.b(16), 0);
    ThreadManagerV2.excute((Runnable)new AnchorOperationContainer.1(this), 128, null, false);
  }
  
  private final AnchorOperationView a(OperationData paramOperationData, int paramInt)
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new AnchorOperationView((Context)localObject, null, 0, paramInt, 6, null);
    ((AnchorOperationView)localObject).setData(paramOperationData);
    return localObject;
  }
  
  private final void a()
  {
    this.b.clear();
    this.b.addAll((Collection)this.c);
    this.b.addAll((Collection)this.d);
    CollectionsKt.sort((List)this.b);
    if (this.b.size() > 4)
    {
      localObject1 = this.b;
      localObject1 = ((ArrayList)localObject1).subList(((ArrayList)localObject1).size() - 4, this.b.size());
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDataList.subList(mDataL…size - 4, mDataList.size)");
      this.b.clear();
      this.b.addAll((Collection)localObject1);
    }
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject2 = ((Iterable)this.b).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((ArrayList)localObject1).add(a((OperationData)((Iterator)localObject2).next(), 3 - i));
      i += 1;
    }
    CollectionsKt.reverse((List)localObject1);
    removeAllViews();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AnchorOperationView)((Iterator)localObject1).next();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = LayoutExKt.b(12);
      addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
    }
  }
  
  private final void a(List<OperationData> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addDefaultList ");
    localStringBuilder.append(paramList);
    Logger.a("AnchorOperationContainer_", 1, localStringBuilder.toString());
    this.c.clear();
    this.c.addAll((Collection)paramList);
    a();
  }
  
  private final void b()
  {
    Logger.a("AnchorOperationContainer_", "fetchData start");
    TimiTianshuAdManager.a.a((TianShuGetAdvCallback)new AnchorOperationContainer.fetchData.1(this), (List)TimiTianshuAdManager.a.a());
  }
  
  public final void a(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      OperationData localOperationData = (OperationData)localIterator.next();
      if ((localOperationData.a() == paramInt) && (this.d.remove(localOperationData))) {
        a();
      }
    }
  }
  
  public final void a(long paramLong, @NotNull LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveRoomExtraInfo, "extraInfo");
    Logger.a("AnchorOperationContainer_", "fetchRedPackData : start");
    ILiveRoomOperation localILiveRoomOperation = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(paramLong);
    if (localILiveRoomOperation == null)
    {
      Logger.c("AnchorOperationContainer_", "fetchRedPackData : liveRoomOperation is null");
      return;
    }
    BaseRoomInfo localBaseRoomInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).h(paramLong);
    TgLiveAnchorUserInfo localTgLiveAnchorUserInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).i(paramLong);
    if ((localBaseRoomInfo != null) && (localTgLiveAnchorUserInfo != null))
    {
      localILiveRoomOperation.getLotteryPendant(paramLong, localTgLiveAnchorUserInfo.getAnchorUid(), localBaseRoomInfo.getProgramId(), (Map)new LinkedHashMap(), (IQQLiveLotteryCallback)new AnchorOperationContainer.fetchRedPackData.1(this, paramLiveRoomExtraInfo));
      return;
    }
    Logger.c("AnchorOperationContainer_", "fetchRedPackData : baseRoomInfo or baseAnchorInfo is null");
  }
  
  public final void a(@NotNull OperationData paramOperationData)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationData, "data");
    this.d.add(paramOperationData);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationContainer
 * JD-Core Version:    0.7.0.1
 */