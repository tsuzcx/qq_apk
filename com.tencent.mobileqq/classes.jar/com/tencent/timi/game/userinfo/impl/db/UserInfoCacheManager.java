package com.tencent.timi.game.userinfo.impl.db;

import androidx.collection.LruCache;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/db/UserInfoCacheManager;", "", "()V", "lock", "lruCahce", "Landroidx/collection/LruCache;", "", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "maxCache", "", "acquireCache", "userId", "clear", "", "put", "userInfo", "updateWhenExist", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoCacheManager
{
  public static final UserInfoCacheManager.Companion a = new UserInfoCacheManager.Companion(null);
  @NotNull
  private static final UserInfoCacheManager e = new UserInfoCacheManager();
  private final int b = 20;
  private LruCache<Long, IUserInfo> c = new LruCache(this.b);
  private final Object d = new Object();
  
  @Nullable
  public final IUserInfo a(long paramLong)
  {
    return (IUserInfo)this.c.get(Long.valueOf(paramLong));
  }
  
  public final void a()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("clear ");
    ((StringBuilder)???).append(this.c.size());
    Logger.a("UserInfoCacheManager ", ((StringBuilder)???).toString());
    synchronized (this.d)
    {
      this.c.evictAll();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public final void a(long paramLong, @NotNull IUserInfo paramIUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfo, "userInfo");
    if (this.c.get(Long.valueOf(paramLong)) != null) {
      b(paramLong, paramIUserInfo);
    }
  }
  
  public final void b(long paramLong, @NotNull IUserInfo paramIUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfo, "userInfo");
    synchronized (this.d)
    {
      paramIUserInfo = (IUserInfo)this.c.put(Long.valueOf(paramLong), paramIUserInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager
 * JD-Core Version:    0.7.0.1
 */