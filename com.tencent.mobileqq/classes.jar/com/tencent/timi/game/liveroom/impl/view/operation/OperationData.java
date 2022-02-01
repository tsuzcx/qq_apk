package com.tencent.timi.game.liveroom.impl.view.operation;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationData;", "", "adId", "", "items", "", "Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationItem;", "(ILjava/util/List;)V", "getAdId", "()I", "getItems", "()Ljava/util/List;", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class OperationData
  implements Comparable<OperationData>
{
  private final int a;
  @NotNull
  private final List<OperationItem> b;
  
  public OperationData()
  {
    this(0, null, 3, null);
  }
  
  public OperationData(int paramInt, @NotNull List<OperationItem> paramList)
  {
    this.a = paramInt;
    this.b = paramList;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public int a(@NotNull OperationData paramOperationData)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationData, "other");
    int i = this.a - paramOperationData.a;
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return 0;
  }
  
  @NotNull
  public final List<OperationItem> b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OperationData))
      {
        paramObject = (OperationData)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = this.a;
    List localList = this.b;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperationData(adId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", items=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.OperationData
 * JD-Core Version:    0.7.0.1
 */