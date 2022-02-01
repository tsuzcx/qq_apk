package com.tencent.timi.game.room.impl.operation;

import com.yolo.esports.room.api.IRoomOperation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/operation/OperationBundle;", "", "roomId", "", "roomOperation", "Lcom/yolo/esports/room/api/IRoomOperation;", "roomRotateMsgList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "(JLcom/yolo/esports/room/api/IRoomOperation;Ljava/util/List;)V", "getRoomId", "()J", "getRoomOperation", "()Lcom/yolo/esports/room/api/IRoomOperation;", "setRoomOperation", "(Lcom/yolo/esports/room/api/IRoomOperation;)V", "getRoomRotateMsgList", "()Ljava/util/List;", "setRoomRotateMsgList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class OperationBundle
{
  private final long a;
  @Nullable
  private IRoomOperation b;
  @NotNull
  private List<YoloRoomOuterClass.YoloRoomRotateMessage> c;
  
  public OperationBundle(long paramLong, @Nullable IRoomOperation paramIRoomOperation, @NotNull List<YoloRoomOuterClass.YoloRoomRotateMessage> paramList)
  {
    this.a = paramLong;
    this.b = paramIRoomOperation;
    this.c = paramList;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  @Nullable
  public final IRoomOperation b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<YoloRoomOuterClass.YoloRoomRotateMessage> c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OperationBundle))
      {
        paramObject = (OperationBundle)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    long l = this.a;
    int k = (int)(l ^ l >>> 32);
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperationBundle(roomId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomOperation=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", roomRotateMsgList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.operation.OperationBundle
 * JD-Core Version:    0.7.0.1
 */