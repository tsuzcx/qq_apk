package com.tencent.timi.game.smoba.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdapter", "Lcom/tencent/timi/game/smoba/impl/widget/SmobaAccountSelectView$Adapter;", "mSombaAccountList", "Ljava/util/ArrayList;", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "Lkotlin/collections/ArrayList;", "adjustHeight", "", "calSelectPosByDefaultAccount", "getCurrentSelectedAccount", "initViews", "setData", "list", "", "Adapter", "Companion", "VH", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaAccountSelectView
  extends FrameLayout
{
  public static final SmobaAccountSelectView.Companion a = new SmobaAccountSelectView.Companion(null);
  private static final int d = LayoutExKt.b(140);
  private static final int e = LayoutExKt.b(68);
  private final ArrayList<GameDataServerOuterClass.SmobaGameRoleAbsInfo> b = new ArrayList();
  private final SmobaAccountSelectView.Adapter c = new SmobaAccountSelectView.Adapter(this);
  private HashMap f;
  
  @JvmOverloads
  public SmobaAccountSelectView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SmobaAccountSelectView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SmobaAccountSelectView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629525, (ViewGroup)this);
    a();
  }
  
  private final void a()
  {
    Object localObject = (RecyclerView)a(2131444517);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "recyclerView");
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.c);
    localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    RecyclerView localRecyclerView = (RecyclerView)a(2131444517);
    Intrinsics.checkExpressionValueIsNotNull(localRecyclerView, "recyclerView");
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = (RecyclerView)a(2131444517);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "recyclerView");
    ((RecyclerView)localObject).setOverScrollMode(2);
    setBackgroundResource(2130853197);
  }
  
  private final int b()
  {
    GameDataServerOuterClass.GetSmobaDefaultRoleRsp localGetSmobaDefaultRoleRsp = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a().getValue();
    if (localGetSmobaDefaultRoleRsp != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localGetSmobaDefaultRoleRsp, "ServiceCenter.getService…eData().value ?: return 0");
      Iterator localIterator = ((Iterable)this.b).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject1 = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)localIterator.next();
        int j = ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1).area.get();
        int k = localGetSmobaDefaultRoleRsp.role_info.area.get();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("areaOfCurrent =");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", areaOfDefault =");
        ((StringBuilder)localObject2).append(k);
        Logger.a("SmobaAccountSelectView_", ((StringBuilder)localObject2).toString());
        int m = ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1).partition.get();
        int n = localGetSmobaDefaultRoleRsp.role_info.partition.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("partitionOfCurrent =");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(", partitionOfDefault =");
        ((StringBuilder)localObject2).append(n);
        Logger.a("SmobaAccountSelectView_", ((StringBuilder)localObject2).toString());
        localObject1 = ((GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject1).role_name.get();
        localObject2 = localGetSmobaDefaultRoleRsp.role_info.role_name.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("roleNameOfCurrent =");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", roleNameOfDefault =");
        localStringBuilder.append((String)localObject2);
        Logger.a("SmobaAccountSelectView_", localStringBuilder.toString());
        boolean bool;
        if ((j == k) && (m == n) && (Intrinsics.areEqual(localObject1, localObject2))) {
          bool = true;
        } else {
          bool = false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("compare result:");
        ((StringBuilder)localObject1).append(bool);
        Logger.a("SmobaAccountSelectView_", ((StringBuilder)localObject1).toString());
        if (bool) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private final void c()
  {
    int i = RangesKt.coerceAtMost(d, this.b.size() * e);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = i;
    post((Runnable)new SmobaAccountSelectView.adjustHeight.1(this, localLayoutParams));
  }
  
  public View a(int paramInt)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    View localView2 = (View)this.f.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.f.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public final GameDataServerOuterClass.SmobaGameRoleAbsInfo getCurrentSelectedAccount()
  {
    Object localObject = this.b.get(this.c.a());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mSombaAccountList[mAdapter.getSelectedPos()]");
    return (GameDataServerOuterClass.SmobaGameRoleAbsInfo)localObject;
  }
  
  public final void setData(@NotNull List<GameDataServerOuterClass.SmobaGameRoleAbsInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    post((Runnable)new SmobaAccountSelectView.setData.1(this));
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (((GameDataServerOuterClass.SmobaGameRoleAbsInfo)paramList).is_default.get()) {
        break label89;
      }
    }
    paramList = null;
    label89:
    paramList = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)paramList;
    int i = CollectionsKt.indexOf((List)this.b, paramList);
    paramList = new StringBuilder();
    paramList.append("selectedPosInList:");
    paramList.append(i);
    Logger.a("SmobaAccountSelectView_", paramList.toString());
    int j = b();
    paramList = new StringBuilder();
    paramList.append("selectedPosFromCompare:");
    paramList.append(i);
    Logger.a("SmobaAccountSelectView_", paramList.toString());
    this.c.a(j);
    this.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SmobaAccountSelectView
 * JD-Core Version:    0.7.0.1
 */