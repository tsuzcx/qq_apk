import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;

public class npw
  implements TVK_IMediaPlayer.OnVideoOutputFrameListener
{
  public npw(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SLog.a("VideoViewTVKImpl", "OnVideoOutputFrame width=%d height=%d rotation=%d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npw
 * JD-Core Version:    0.7.0.1
 */