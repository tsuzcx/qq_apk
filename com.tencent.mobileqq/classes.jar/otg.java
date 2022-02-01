import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import java.lang.ref.WeakReference;

public class otg
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  private WeakReference<ReadInJoyArticleBottomVideoView> a;
  
  public otg(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    this.a = new WeakReference(paramReadInJoyArticleBottomVideoView);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (paramTVK_IMediaPlayer == null) {
      return;
    }
    ReadInJoyArticleBottomVideoView.a(paramTVK_IMediaPlayer, 9);
    ood.c = true;
    paramTVK_IMediaPlayer.j();
    paramTVK_IMediaPlayer.r();
    ReadInJoyArticleBottomVideoView.a(paramTVK_IMediaPlayer).a = true;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (paramTVK_IMediaPlayer == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleBottomVideoView", 0, "error msg = " + paramString);
      }
      ReadInJoyArticleBottomVideoView.a(paramTVK_IMediaPlayer, 8);
      paramTVK_IMediaPlayer.j();
    } while (!QLog.isColorLevel());
    QLog.i("ReadInJoyArticleBottomVideoView", 3, "WebFastProteusViewAdBannerVideoCreator start video error");
    return false;
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (paramSurfaceHolder == null) {
      return;
    }
    paramSurfaceHolder.q();
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = (ReadInJoyArticleBottomVideoView)this.a.get();
    if (paramTVK_IMediaPlayer == null) {
      return;
    }
    if ((Looper.myLooper() != Looper.getMainLooper()) && (ReadInJoyArticleBottomVideoView.a(paramTVK_IMediaPlayer) != null))
    {
      ReadInJoyArticleBottomVideoView.a(paramTVK_IMediaPlayer).post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(paramTVK_IMediaPlayer, 2));
      return;
    }
    ReadInJoyArticleBottomVideoView.b(paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otg
 * JD-Core Version:    0.7.0.1
 */