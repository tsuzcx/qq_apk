package com.tencent.timi.game.userinfo.impl.loader;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.net.BatchGetUserInfoRequest;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/loader/UserInfoAutoLoader;", "Lcom/tencent/timi/game/userinfo/impl/loader/BaseAutoLoader;", "", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "()V", "acquireTAG", "", "requestData", "", "requestList", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "updateUserInfo", "uid", "(Ljava/lang/Long;)V", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoAutoLoader
  extends BaseAutoLoader<List<? extends IUserInfo>>
{
  public static final UserInfoAutoLoader.Companion a = new UserInfoAutoLoader.Companion(null);
  @NotNull
  private static final Lazy b = LazyKt.lazy((Function0)UserInfoAutoLoader.Companion.stance.2.INSTANCE);
  
  @NotNull
  public String a()
  {
    return "UserInfoAutoLoader";
  }
  
  public final void a(@Nullable Long paramLong)
  {
    if (paramLong != null) {
      a(CollectionsKt.mutableListOf(new Long[] { paramLong }));
    }
  }
  
  public void a(@NotNull List<Long> paramList, @Nullable IResultListener<List<IUserInfo>> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestList");
    BatchGetUserInfoRequest.a.a(paramList, paramIResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.UserInfoAutoLoader
 * JD-Core Version:    0.7.0.1
 */