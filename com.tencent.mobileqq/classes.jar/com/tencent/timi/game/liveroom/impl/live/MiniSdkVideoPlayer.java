package com.tencent.timi.game.liveroom.impl.live;

import android.view.View;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.live.api.IVideoPlayer;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/live/MiniSdkVideoPlayer;", "Lcom/tencent/timi/game/live/api/IVideoPlayer;", "()V", "mutePlay", "", "url", "", "mute", "", "pause", "play", "view", "Landroid/view/View;", "release", "resume", "setLiveVolume", "volume", "", "setVideoRotation", "degree", "stop", "takeSnapshot", "callback", "Lcom/tencent/timi/game/live/api/TakeSnapshotCallback;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MiniSdkVideoPlayer
  implements IVideoPlayer
{
  public static final MiniSdkVideoPlayer.Companion a = new MiniSdkVideoPlayer.Companion(null);
  
  public void a(int paramInt) {}
  
  public void a(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pause: ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("MiniSdkVideoPlayer", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      paramString = StringsKt.toLongOrNull(paramString);
      if (paramString != null)
      {
        l = paramString.longValue();
        break label57;
      }
    }
    long l = 0L;
    label57:
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f(l);
    paramString = (String)localObject;
    if (!(localObject instanceof ILiveTPPlayerRoom)) {
      paramString = null;
    }
    paramString = (ILiveTPPlayerRoom)paramString;
    if (paramString != null) {
      paramString.pause();
    }
  }
  
  public void a(@Nullable String paramString, int paramInt) {}
  
  public void a(@Nullable String paramString, @Nullable View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("play: ");
    paramView.append(paramString);
    Logger.a("MiniSdkVideoPlayer", paramView.toString());
    if (paramString != null)
    {
      paramString = StringsKt.toLongOrNull(paramString);
      if (paramString != null)
      {
        l = paramString.longValue();
        break label53;
      }
    }
    long l = 0L;
    label53:
    paramView = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f(l);
    paramString = paramView;
    if (!(paramView instanceof ILiveTPPlayerRoom)) {
      paramString = null;
    }
    paramString = (ILiveTPPlayerRoom)paramString;
    if (paramString != null) {
      paramString.startPlay("");
    }
  }
  
  public void a(@Nullable String paramString, boolean paramBoolean) {}
  
  public void b(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resume: ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("MiniSdkVideoPlayer", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      paramString = StringsKt.toLongOrNull(paramString);
      if (paramString != null)
      {
        l = paramString.longValue();
        break label57;
      }
    }
    long l = 0L;
    label57:
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f(l);
    paramString = (String)localObject;
    if (!(localObject instanceof ILiveTPPlayerRoom)) {
      paramString = null;
    }
    paramString = (ILiveTPPlayerRoom)paramString;
    if (paramString != null) {
      paramString.play();
    }
  }
  
  public void c(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop: ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("MiniSdkVideoPlayer", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      paramString = StringsKt.toLongOrNull(paramString);
      if (paramString != null)
      {
        l = paramString.longValue();
        break label57;
      }
    }
    long l = 0L;
    label57:
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f(l);
    paramString = (String)localObject;
    if (!(localObject instanceof ILiveTPPlayerRoom)) {
      paramString = null;
    }
    paramString = (ILiveTPPlayerRoom)paramString;
    if (paramString != null) {
      paramString.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.MiniSdkVideoPlayer
 * JD-Core Version:    0.7.0.1
 */