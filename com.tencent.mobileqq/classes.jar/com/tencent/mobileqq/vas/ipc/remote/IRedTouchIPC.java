package com.tencent.mobileqq.vas.ipc.remote;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ipc/remote/IRedTouchIPC;", "", "getAppInfo", "", "path", "onRedTouchItemClick", "", "reportLevelOne", "reportType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRedTouchIPC
{
  @Nullable
  public abstract String getAppInfo(@NotNull String paramString);
  
  public abstract void onRedTouchItemClick(@NotNull String paramString);
  
  public abstract void reportLevelOne(@NotNull String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC
 * JD-Core Version:    0.7.0.1
 */