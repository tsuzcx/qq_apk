package com.tencent.tavcut.render.player;

import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/player/IPlayer;", "", "addPlayerListener", "", "playerListener", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerListener;", "changeSurfaceSize", "surfaceWidth", "", "surfaceHeight", "destroySurface", "getCurrentPlayUs", "", "getGlViewPort", "Lcom/tencent/tavcut/composition/model/component/Rect;", "getRenderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "getTotalDurationUs", "isPlaying", "", "pause", "play", "post", "runnable", "Lkotlin/Function0;", "release", "removePlayerListener", "requestRender", "resetToTotalTimeRange", "seek", "timeUs", "setAutoPlay", "autoPlay", "setBgColor", "bgColor", "setLoopPlay", "loopPlay", "setPlayTimeRange", "selectedStartTimeUs", "selectedDurationUs", "setSeekToLastPosition", "seekToLastPosition", "setUpSurface", "surface", "Landroid/view/Surface;", "updatePlayer", "templateDir", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "updateCallBack", "Lkotlin/Function2;", "Lcom/tencent/tavcut/render/IRenderChainManager;", "PlayerListener", "PlayerStatus", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayer
{
  public abstract void a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(@NotNull IPlayer.PlayerListener paramPlayerListener);
  
  public abstract void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Function2<? super IRenderChainManager, ? super RenderModel, Unit> paramFunction2);
  
  public abstract void a(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract long d();
  
  public abstract long e();
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.IPlayer
 * JD-Core Version:    0.7.0.1
 */