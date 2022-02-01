package com.tencent.timi.game.live.impl.video.minisdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.timi.game.live.api.IVideoPlayer;
import com.tencent.timi.game.live.impl.WifiOr4GStateHolder;
import com.tencent.timi.game.live.impl.video.GameLiveView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/video/minisdk/MiniSdkLiveView;", "Lcom/tencent/timi/game/live/impl/video/GameLiveView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveView", "Landroid/view/View;", "videoPlayer", "Lcom/tencent/timi/game/live/api/IVideoPlayer;", "addView", "", "child", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "mutePlay", "mute", "", "pause", "url", "", "play", "release", "resume", "setLiveVolume", "volume", "setVideoPlayer", "player", "setVideoRotation", "degree", "stop", "takeSnapshot", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MiniSdkLiveView
  extends GameLiveView
{
  private View b;
  private IVideoPlayer c;
  private HashMap d;
  
  @JvmOverloads
  public MiniSdkLiveView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public MiniSdkLiveView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public MiniSdkLiveView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void addView(@Nullable View paramView, int paramInt, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    this.b = paramView;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    IVideoPlayer localIVideoPlayer = this.c;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.a("", paramBoolean);
    }
  }
  
  public void c(@Nullable String paramString)
  {
    super.c(paramString);
    Object localObject = WifiOr4GStateHolder.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if (((WifiOr4GStateHolder)localObject).a(localContext))
    {
      localObject = this.c;
      if (localObject != null) {
        ((IVideoPlayer)localObject).a(paramString, this.b);
      }
    }
  }
  
  public void d(@Nullable String paramString)
  {
    super.d(paramString);
    IVideoPlayer localIVideoPlayer = this.c;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.a(paramString);
    }
  }
  
  public void e(@Nullable String paramString)
  {
    super.e(paramString);
    Object localObject = WifiOr4GStateHolder.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if (((WifiOr4GStateHolder)localObject).a(localContext))
    {
      localObject = this.c;
      if (localObject != null) {
        ((IVideoPlayer)localObject).b(paramString);
      }
    }
  }
  
  public void f(@Nullable String paramString)
  {
    super.f(paramString);
    IVideoPlayer localIVideoPlayer = this.c;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.c(paramString);
    }
  }
  
  public void setLiveVolume(int paramInt)
  {
    super.setLiveVolume(paramInt);
    IVideoPlayer localIVideoPlayer = this.c;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.a("", paramInt);
    }
  }
  
  public void setVideoPlayer(@NotNull IVideoPlayer paramIVideoPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoPlayer, "player");
    this.c = paramIVideoPlayer;
  }
  
  public void setVideoRotation(int paramInt)
  {
    super.setVideoRotation(paramInt);
    IVideoPlayer localIVideoPlayer = this.c;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.minisdk.MiniSdkLiveView
 * JD-Core Version:    0.7.0.1
 */