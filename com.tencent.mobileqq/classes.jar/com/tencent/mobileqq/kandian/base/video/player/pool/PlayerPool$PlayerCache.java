package com.tencent.mobileqq.kandian.base.video.player.pool;

import com.tencent.mobileqq.kandian.base.video.player.LitePlayer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/pool/PlayerPool$PlayerCache;", "", "player", "Lcom/tencent/mobileqq/kandian/base/video/player/LitePlayer;", "(Lcom/tencent/mobileqq/kandian/base/video/player/LitePlayer;)V", "recyleTimestamp", "", "equals", "", "other", "get", "hashCode", "", "isRecyclable", "isReusable", "onRecycled", "", "onReused", "release", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class PlayerPool$PlayerCache
{
  private final long a;
  private LitePlayer b;
  
  public PlayerPool$PlayerCache(@Nullable LitePlayer paramLitePlayer)
  {
    this.b = paramLitePlayer;
    this.a = System.currentTimeMillis();
  }
  
  public final boolean a()
  {
    LitePlayer localLitePlayer = this.b;
    return (localLitePlayer != null) && (localLitePlayer.d() == true);
  }
  
  public final boolean b()
  {
    LitePlayer localLitePlayer = this.b;
    return (localLitePlayer != null) && (localLitePlayer.d() == true) && (System.currentTimeMillis() - this.a > PlayerPool.a.a());
  }
  
  @Nullable
  public final LitePlayer c()
  {
    LitePlayer localLitePlayer = this.b;
    if ((localLitePlayer != null) && (localLitePlayer.d() == true)) {
      return this.b;
    }
    return null;
  }
  
  public final void d()
  {
    LitePlayer localLitePlayer = this.b;
    if (localLitePlayer != null) {
      localLitePlayer.F();
    }
    this.b = ((LitePlayer)null);
  }
  
  public final void e()
  {
    LitePlayer localLitePlayer = this.b;
    if (localLitePlayer != null) {
      localLitePlayer.f(false);
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((PlayerCache)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (PlayerCache)paramObject;
      return !(Intrinsics.areEqual(this.b, paramObject.b) ^ true);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.video.player.pool.PlayerPool.PlayerCache");
  }
  
  public final void f()
  {
    LitePlayer localLitePlayer = this.b;
    if (localLitePlayer != null) {
      localLitePlayer.f(true);
    }
  }
  
  public int hashCode()
  {
    LitePlayer localLitePlayer = this.b;
    if (localLitePlayer != null) {
      return localLitePlayer.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PlayerCache(player=");
      localStringBuilder.append(PlayerPool.a(PlayerPool.a, localObject));
      localStringBuilder.append('-');
      localStringBuilder.append(((LitePlayer)localObject).l());
      localStringBuilder.append(')');
      localObject = localStringBuilder.toString();
      if (localObject != null) {
        return localObject;
      }
    }
    return "PlayerCache(player=null)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.pool.PlayerPool.PlayerCache
 * JD-Core Version:    0.7.0.1
 */