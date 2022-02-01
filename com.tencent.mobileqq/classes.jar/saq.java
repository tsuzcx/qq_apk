import android.view.View;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/tvk/TVKVideoView;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "videoView", "Lcom/tencent/qqlive/mediaplayer/view/IVideoViewBase;", "(Lcom/tencent/qqlive/mediaplayer/view/IVideoViewBase;)V", "doCacheSurfaceTexture", "", "doRecoverSurfaceTexture", "getOriginView", "Landroid/view/View;", "setFixedSize", "videoWidth", "", "videoHeight", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class saq
  implements sab
{
  private final IVideoViewBase a;
  
  public saq(@Nullable IVideoViewBase paramIVideoViewBase)
  {
    this.a = paramIVideoViewBase;
  }
  
  @Nullable
  public View a()
  {
    IVideoViewBase localIVideoViewBase2 = this.a;
    IVideoViewBase localIVideoViewBase1 = localIVideoViewBase2;
    if (!(localIVideoViewBase2 instanceof View)) {
      localIVideoViewBase1 = null;
    }
    return (View)localIVideoViewBase1;
  }
  
  public void a()
  {
    IVideoViewBase localIVideoViewBase = this.a;
    if (localIVideoViewBase != null) {
      localIVideoViewBase.doCacheSurfaceTexture();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    IVideoViewBase localIVideoViewBase = this.a;
    if (localIVideoViewBase != null) {
      localIVideoViewBase.setFixedSize(paramInt1, paramInt2);
    }
  }
  
  public void b()
  {
    IVideoViewBase localIVideoViewBase = this.a;
    if (localIVideoViewBase != null) {
      localIVideoViewBase.doRecoverSurfaceTexture();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saq
 * JD-Core Version:    0.7.0.1
 */