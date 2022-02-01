import android.view.View;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerVideoView;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "videoView", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "doCacheSurfaceTexture", "", "doRecoverSurfaceTexture", "getOriginView", "Landroid/view/View;", "setFixedSize", "videoWidth", "", "videoHeight", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sue
  implements stv
{
  private final ISPlayerVideoView a;
  
  public sue(@Nullable ISPlayerVideoView paramISPlayerVideoView)
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
  
  public void a()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.disableViewCallback();
    }
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
      localISPlayerVideoView.enableViewCallback();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sue
 * JD-Core Version:    0.7.0.1
 */