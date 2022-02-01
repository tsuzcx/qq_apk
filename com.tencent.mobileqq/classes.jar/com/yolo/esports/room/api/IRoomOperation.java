package com.yolo.esports.room.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/room/api/IRoomOperation;", "", "init", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "setDelayTime", "time", "", "setSwitchTime", "submit", "data", "Lcom/yolo/esports/room/api/OperationData;", "dataList", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRoomOperation
{
  public abstract void a(@NotNull List<OperationData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.room.api.IRoomOperation
 * JD-Core Version:    0.7.0.1
 */