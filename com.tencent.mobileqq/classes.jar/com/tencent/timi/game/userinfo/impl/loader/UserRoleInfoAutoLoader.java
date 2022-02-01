package com.tencent.timi.game.userinfo.impl.loader;

import com.tencent.timi.game.userinfo.impl.net.BatchGetGameDefaultRoleRequest;
import com.tencent.timi.game.utils.IResultListener;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.UserDefaultRole;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/loader/UserRoleInfoAutoLoader;", "Lcom/tencent/timi/game/userinfo/impl/loader/BaseAutoLoader;", "", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "()V", "noRoleInfoUserSet", "", "", "getNoRoleInfoUserSet", "()Ljava/util/Set;", "acquireTAG", "", "requestData", "", "requestList", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "updateUserRole", "uid", "(Ljava/lang/Long;)V", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserRoleInfoAutoLoader
  extends BaseAutoLoader<List<? extends GameDataServerOuterClass.UserDefaultRole>>
{
  public static final UserRoleInfoAutoLoader.Companion a = new UserRoleInfoAutoLoader.Companion(null);
  @NotNull
  private static final Lazy c = LazyKt.lazy((Function0)UserRoleInfoAutoLoader.Companion.stance.2.INSTANCE);
  @NotNull
  private final Set<Long> b = (Set)new LinkedHashSet();
  
  @NotNull
  public String a()
  {
    return "UserRoleInfoAutoLoader";
  }
  
  public final void a(@Nullable Long paramLong)
  {
    if ((paramLong != null) && (paramLong.longValue() != 0L) && (!this.b.contains(paramLong))) {
      a(CollectionsKt.mutableListOf(new Long[] { paramLong }));
    }
  }
  
  public void a(@NotNull List<Long> paramList, @Nullable IResultListener<List<GameDataServerOuterClass.UserDefaultRole>> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestList");
    BatchGetGameDefaultRoleRequest.a.a(paramList, paramIResultListener);
  }
  
  @NotNull
  public final Set<Long> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader
 * JD-Core Version:    0.7.0.1
 */