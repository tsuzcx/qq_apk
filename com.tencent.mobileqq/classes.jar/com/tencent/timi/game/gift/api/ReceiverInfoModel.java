package com.tencent.timi.game.gift.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "priority", "", "desc", "", "fake", "", "isCertain", "chosen", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;ILjava/lang/String;ZZZ)V", "getChosen", "()Z", "setChosen", "(Z)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getFake", "setFake", "getPriority", "()I", "getUid", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverInfoModel
{
  @NotNull
  private final CommonOuterClass.QQUserId a;
  private final int b;
  @NotNull
  private String c;
  private boolean d;
  private final boolean e;
  private boolean f;
  
  public ReceiverInfoModel(@NotNull CommonOuterClass.QQUserId paramQQUserId, int paramInt, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramQQUserId;
    this.b = paramInt;
    this.c = paramString;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramBoolean3;
  }
  
  @NotNull
  public final ReceiverInfoModel a(@NotNull CommonOuterClass.QQUserId paramQQUserId, int paramInt, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    return new ReceiverInfoModel(paramQQUserId, paramInt, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  @NotNull
  public final CommonOuterClass.QQUserId a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReceiverInfoModel(uid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", desc=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fake=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isCertain=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", chosen=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.api.ReceiverInfoModel
 * JD-Core Version:    0.7.0.1
 */