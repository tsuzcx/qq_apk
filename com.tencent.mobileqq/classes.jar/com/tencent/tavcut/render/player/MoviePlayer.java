package com.tencent.tavcut.render.player;

import android.widget.FrameLayout;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.builder.IMediaBuilder;
import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuildFactory;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.render.util.CMTimeUtil;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderModel.Companion;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavcut.utils.TimeUtils;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.tavkit.component.TAVPlayer.PlayerListener;
import com.tencent.tavkit.composition.TAVComposition;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/player/MoviePlayer;", "Lcom/tencent/tavcut/render/player/IPlayer;", "playerContainer", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "autoPlay", "", "currentPlayUs", "", "durationUs", "interceptSeekTime", "lastCallSeekTime", "lastSeekTime", "player", "Lcom/tencent/tav/player/Player;", "playerComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "playerListeners", "", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerListener;", "playerRenderManager", "Lcom/tencent/tavcut/render/IRenderChainManager;", "playerStatusMap", "", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "positionChangeCallBack", "Lkotlin/Function2;", "", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "runOnCompositionUpdatedEvent", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "seekToLastPosition", "tavPlayer", "Lcom/tencent/tavkit/component/TAVPlayer;", "addPlayerListener", "playerListener", "changeSurfaceSize", "surfaceWidth", "", "surfaceHeight", "destroySurface", "getCurrentPlayUs", "getGlViewPort", "Lcom/tencent/tavcut/composition/model/component/Rect;", "getRenderSize", "getTotalDurationUs", "isInterceptSeek", "timeUs", "isPlaying", "pause", "play", "post", "runnable", "Lkotlin/Function0;", "release", "removePlayerListener", "requestRender", "resetLastSeekTime", "resetSeekWhenSeekFinished", "resetToTotalTimeRange", "safeSeekPositionConvert", "Lcom/tencent/tav/coremedia/CMTime;", "seekToPosition", "seek", "setAutoPlay", "setBgColor", "bgColor", "setLoopPlay", "loopPlay", "setPlayTimeRange", "selectedStartTimeUs", "selectedDurationUs", "setSeekToLastPosition", "setUpSurface", "surface", "Landroid/view/Surface;", "updateComposition", "tavComposition", "updatePlayer", "templateDir", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "updateCallBack", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MoviePlayer
  implements IPlayer
{
  public static final MoviePlayer.Companion a = new MoviePlayer.Companion(null);
  private final TAVPlayer b;
  private Player c;
  private TAVComposition d;
  private IRenderChainManager e;
  private Size f;
  private Function2<? super Long, ? super Long, Unit> g;
  private List<IPlayer.PlayerListener> h;
  private long i;
  private boolean j;
  private boolean k;
  private long l;
  private final LinkedList<Runnable> m;
  private long n;
  private long o;
  private long p;
  private final Map<com.tencent.tav.player.IPlayer.PlayerStatus, IPlayer.PlayerStatus> q;
  
  public MoviePlayer(@Nullable FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout != null) {
      paramFrameLayout = new TAVPlayer(paramFrameLayout);
    } else {
      paramFrameLayout = new TAVPlayer();
    }
    this.b = paramFrameLayout;
    this.f = RenderModel.Companion.getDEFAULT_SIZE();
    this.g = ((Function2)MoviePlayer.positionChangeCallBack.1.INSTANCE);
    this.h = ((List)new ArrayList());
    this.m = new LinkedList();
    this.o = -1L;
    this.p = -1L;
    this.q = MapsKt.mapOf(new Pair[] { new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.IDLE, IPlayer.PlayerStatus.IDLE), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.READY, IPlayer.PlayerStatus.READY), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.PLAYING, IPlayer.PlayerStatus.PLAYING), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.STOPPED, IPlayer.PlayerStatus.STOPPED), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.PAUSED, IPlayer.PlayerStatus.PAUSED), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.FINISHED, IPlayer.PlayerStatus.FINISHED), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.ERROR, IPlayer.PlayerStatus.ERROR), new Pair(com.tencent.tav.player.IPlayer.PlayerStatus.REPLAY, IPlayer.PlayerStatus.REPLAY) });
    this.b.setPlayerListener((TAVPlayer.PlayerListener)new MoviePlayer.1(this));
  }
  
  private final void a(TAVComposition paramTAVComposition, long paramLong)
  {
    this.c = ((Player)null);
    this.b.updateComposition(paramTAVComposition, c(paramLong), this.j, (OnCompositionUpdateListener)new MoviePlayer.updateComposition.1(this));
  }
  
  private final boolean b(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    if ((this.o != -1L) && (l1 - this.n < 50L))
    {
      this.p = paramLong;
      return true;
    }
    this.p = -1L;
    this.o = paramLong;
    this.n = l1;
    return false;
  }
  
  private final CMTime c(long paramLong)
  {
    StringBuilder localStringBuilder;
    long l1;
    if (paramLong < 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("error seek time ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" small  then 0 auto ");
      localStringBuilder.append("adjust to 0");
      TavLogger.b("TavCut_MoviePlayer", localStringBuilder.toString());
      l1 = 0L;
    }
    else
    {
      l1 = paramLong;
      if (paramLong > this.l)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("error seek time ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" big then ");
        localStringBuilder.append(this.l);
        localStringBuilder.append(" auto ");
        localStringBuilder.append("adjust to ");
        localStringBuilder.append(this.l);
        TavLogger.b("TavCut_MoviePlayer", localStringBuilder.toString());
        l1 = this.l - 3333L;
      }
    }
    return CMTimeUtil.a(CMTimeUtil.a, l1, 0, 2, null);
  }
  
  private final void h()
  {
    if (TimeUtils.a.a(this.o) == TimeUtils.a.a(this.i)) {
      i();
    }
    long l1 = this.p;
    if (l1 != -1L)
    {
      this.n = 0L;
      a(l1);
    }
  }
  
  private final void i()
  {
    this.o = -1L;
  }
  
  public void a()
  {
    this.b.play();
  }
  
  public void a(long paramLong)
  {
    if (b(paramLong)) {
      return;
    }
    if (this.c != null)
    {
      this.b.seekToTime(c(paramLong));
      return;
    }
    this.m.add(new MoviePlayer.seek.2(this, paramLong));
  }
  
  public void a(@NotNull IPlayer.PlayerListener paramPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerListener, "playerListener");
    this.h.add(paramPlayerListener);
  }
  
  public void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Function2<? super IRenderChainManager, ? super RenderModel, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateDir");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "updateCallBack");
    if (paramRenderModel.getRoot() == null) {
      return;
    }
    IRenderChainManager localIRenderChainManager = this.e;
    if (localIRenderChainManager != null) {
      localIRenderChainManager.a();
    }
    paramRenderModel = RenderModel.copy$default(paramRenderModel, RenderScene.PLAY, null, null, null, null, false, 0, null, null, null, 0L, 0, null, 8126, null);
    MediaBuildFactory.a.a(RenderConfig.a.b()).a(paramString, paramRenderModel, (IMediaBuilderListener)new MoviePlayer.updatePlayer.1(this, paramFunction2));
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    this.b.post((Runnable)new MoviePlayer.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void b()
  {
    this.b.pause();
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.setLoopPlay(paramBoolean);
  }
  
  public boolean c()
  {
    return this.b.isPlaying();
  }
  
  public long d()
  {
    return this.l;
  }
  
  public long e()
  {
    return this.i;
  }
  
  public void f()
  {
    this.h = ((List)new ArrayList());
    this.b.release();
  }
  
  public void g()
  {
    Player localPlayer = this.c;
    if (localPlayer != null)
    {
      localPlayer.refresh();
      return;
    }
    this.m.add(new MoviePlayer.requestRender.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.MoviePlayer
 * JD-Core Version:    0.7.0.1
 */