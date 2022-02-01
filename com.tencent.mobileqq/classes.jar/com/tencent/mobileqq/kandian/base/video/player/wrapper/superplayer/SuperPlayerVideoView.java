package com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer;

import android.view.View;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/superplayer/SuperPlayerVideoView;", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "videoView", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "doCacheSurfaceTexture", "", "doRecoverSurfaceTexture", "getOriginView", "Landroid/view/View;", "setFixedSize", "videoWidth", "", "videoHeight", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerVideoView
  implements IVideoView
{
  private final ISPlayerVideoView a;
  
  public SuperPlayerVideoView(@Nullable ISPlayerVideoView paramISPlayerVideoView)
  {
    this.a = paramISPlayerVideoView;
  }
  
  @Nullable
  public View a()
  {
    ISPlayerVideoView localISPlayerVideoView2 = this.a;
    ISPlayerVideoView localISPlayerVideoView1 = localISPlayerVideoView2;
    if (!(localISPlayerVideoView2 instanceof View)) {
      localISPlayerVideoView1 = null;
    }
    return (View)localISPlayerVideoView1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.setFixedSize(paramInt1, paramInt2);
    }
  }
  
  public void b()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.disableViewCallback();
    }
  }
  
  public void c()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.enableViewCallback();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */