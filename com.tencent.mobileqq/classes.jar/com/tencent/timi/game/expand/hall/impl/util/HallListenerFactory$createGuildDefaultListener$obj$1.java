package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/util/HallListenerFactory$createGuildDefaultListener$obj$1", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "onExitEvent", "", "source", "", "param", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "context", "Lcom/tencent/mobileqq/app/QBaseActivity;", "onJoinHallFailed", "", "roomId", "", "errorCode", "errorMsg", "", "onJoinHallSucceed", "onJoinTeamFailed", "teamId", "onJoinTeamSucceed", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HallListenerFactory$createGuildDefaultListener$obj$1
  implements ExpandHallListener
{
  public void a(long paramLong, @Nullable ExpandHallLaunchParam paramExpandHallLaunchParam) {}
  
  public void a(long paramLong, @Nullable ExpandHallLaunchParam paramExpandHallLaunchParam, int paramInt, @Nullable String paramString) {}
  
  public void a(long paramLong, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam, @NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "param");
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createGuildDefaultListener#onJoinHallSucceed param=");
    localStringBuilder.append(paramExpandHallLaunchParam);
    Logger.a("HallListenerFactory_", localStringBuilder.toString());
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).updateSelectedChannel(paramQBaseActivity, paramExpandHallLaunchParam.f);
  }
  
  public boolean a(int paramInt, @Nullable ExpandHallLaunchParam paramExpandHallLaunchParam, @NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "context");
    IGuildMainFrameApi localIGuildMainFrameApi1 = null;
    Object localObject = null;
    boolean bool = true;
    if ((paramInt != 0) && (paramInt != 1))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4))
      {
        bool = false;
      }
      else
      {
        localIGuildMainFrameApi1 = (IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class);
        if (paramExpandHallLaunchParam != null) {
          localObject = paramExpandHallLaunchParam.f;
        }
        localIGuildMainFrameApi1.closeAppChannel(paramQBaseActivity, new ChannelData((String)localObject));
      }
    }
    else
    {
      IGuildMainFrameApi localIGuildMainFrameApi2 = (IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class);
      localObject = localIGuildMainFrameApi1;
      if (paramExpandHallLaunchParam != null) {
        localObject = paramExpandHallLaunchParam.f;
      }
      localIGuildMainFrameApi2.closeAppChannel(paramQBaseActivity, new ChannelData((String)localObject));
    }
    paramExpandHallLaunchParam = new StringBuilder();
    paramExpandHallLaunchParam.append("createGuildDefaultListener#onExitEvent result=");
    paramExpandHallLaunchParam.append(bool);
    Logger.a("HallListenerFactory_", paramExpandHallLaunchParam.toString());
    return bool;
  }
  
  public void b(long paramLong, @Nullable ExpandHallLaunchParam paramExpandHallLaunchParam, int paramInt, @Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.HallListenerFactory.createGuildDefaultListener.obj.1
 * JD-Core Version:    0.7.0.1
 */