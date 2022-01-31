import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import mqq.os.MqqHandler;

public class npr
  implements TVK_IMediaPlayer.OnInfoListener
{
  public npr(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    SLog.d("VideoViewTVKImpl", "mMediaPlayer onInfo, what:%d, meaning:%s, extra:%s", new Object[] { Integer.valueOf(paramInt), (String)VideoViewTVKImpl.a.get(paramInt, "UNKNOWN"), paramObject });
    ThreadManager.getUIHandler().post(new nps(this, paramInt, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npr
 * JD-Core Version:    0.7.0.1
 */