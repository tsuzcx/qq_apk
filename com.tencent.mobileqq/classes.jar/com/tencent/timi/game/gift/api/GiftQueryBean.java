package com.tencent.timi.game.gift.api;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.ShopOuterClass.GiftConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/api/GiftQueryBean;", "", "giftName", "", "giftIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "giftConf", "Ltrpc/yes/common/ShopOuterClass$GiftConf;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ltrpc/yes/common/ShopOuterClass$GiftConf;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getGiftConf", "()Ltrpc/yes/common/ShopOuterClass$GiftConf;", "getGiftIcon", "()Ljava/lang/String;", "getGiftName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftQueryBean
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @Nullable
  private final Drawable c;
  @Nullable
  private final ShopOuterClass.GiftConf d;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GiftQueryBean))
      {
        paramObject = (GiftQueryBean)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GiftQueryBean(giftName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", giftIcon=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", giftConf=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.api.GiftQueryBean
 * JD-Core Version:    0.7.0.1
 */