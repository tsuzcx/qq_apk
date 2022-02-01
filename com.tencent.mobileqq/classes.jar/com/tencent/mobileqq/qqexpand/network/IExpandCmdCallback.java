package com.tencent.mobileqq.qqexpand.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "", "onProtocol", "", "request", "Lcom/tencent/mobileqq/qqexpand/network/ExpandReqInfo;", "response", "Lcom/tencent/mobileqq/qqexpand/network/ExpandResponse;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandCmdCallback
{
  public abstract void onProtocol(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback
 * JD-Core Version:    0.7.0.1
 */