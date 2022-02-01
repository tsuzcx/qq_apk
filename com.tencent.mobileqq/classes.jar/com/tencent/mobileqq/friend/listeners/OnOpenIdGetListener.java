package com.tencent.mobileqq.friend.listeners;

import com.tencent.mobileqq.data.OpenID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/listeners/OnOpenIdGetListener;", "", "onGetOpenId", "", "isSuccess", "", "openId", "Lcom/tencent/mobileqq/data/OpenID;", "IMCore_release"}, k=1, mv={1, 1, 16})
public abstract interface OnOpenIdGetListener
{
  public abstract void a(boolean paramBoolean, @NotNull OpenID paramOpenID);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.listeners.OnOpenIdGetListener
 * JD-Core Version:    0.7.0.1
 */