package com.tencent.timi.game.expand.hall.impl.cache;

import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/cache/ExpandHallInfoCacheManager;", "", "()V", "CACHE_KEY", "", "TAG", "cacheHallInfo", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "getCacheHallInfo", "loadFromLocalCache", "", "saveHallInfo", "hallInfo", "saveIntoLocal", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallInfoCacheManager
{
  public static final ExpandHallInfoCacheManager a;
  private static WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf b;
  
  static
  {
    ExpandHallInfoCacheManager localExpandHallInfoCacheManager = new ExpandHallInfoCacheManager();
    a = localExpandHallInfoCacheManager;
    localExpandHallInfoCacheManager.b();
  }
  
  private final void b()
  {
    Object localObject1 = TGSharedPreferenceUtil.b("ExpandHallInfoCacheKey", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadFromLocalCache bytesString length:");
    ((StringBuilder)localObject2).append(((String)localObject1).length());
    Logger.a("ExpandHallInfoCacheManager_", ((StringBuilder)localObject2).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "bytesString");
    int i;
    if (((CharSequence)localObject1).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    localObject1 = Base64.decode((String)localObject1, 2);
    localObject2 = new WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf();
    try
    {
      ((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject2).mergeFrom((byte[])localObject1);
      b = (WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadFromLocalCache cacheHallInfo:");
      ((StringBuilder)localObject1).append(b);
      Logger.a("ExpandHallInfoCacheManager_", ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception localException)
    {
      Logger.a("ExpandHallInfoCacheManager_", "loadFromLocalCache mergeFrom failed", (Throwable)localException);
    }
  }
  
  private final void b(WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf paramWujiYoloCommunityRoomConf)
  {
    paramWujiYoloCommunityRoomConf = Base64.encodeToString(paramWujiYoloCommunityRoomConf.toByteArray(), 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveIntoLocal bytesString length:");
    localStringBuilder.append(paramWujiYoloCommunityRoomConf.length());
    Logger.a("ExpandHallInfoCacheManager_", localStringBuilder.toString());
    TGSharedPreferenceUtil.a("ExpandHallInfoCacheKey", paramWujiYoloCommunityRoomConf);
  }
  
  @Nullable
  public final WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf a()
  {
    return b;
  }
  
  public final void a(@Nullable WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf paramWujiYoloCommunityRoomConf)
  {
    b = paramWujiYoloCommunityRoomConf;
    paramWujiYoloCommunityRoomConf = b;
    if (paramWujiYoloCommunityRoomConf != null) {
      ThreadManagerV2.excute((Runnable)new ExpandHallInfoCacheManager.saveHallInfo.1.1(paramWujiYoloCommunityRoomConf), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.cache.ExpandHallInfoCacheManager
 * JD-Core Version:    0.7.0.1
 */