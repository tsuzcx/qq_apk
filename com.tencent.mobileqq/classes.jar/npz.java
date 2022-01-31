import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class npz
  implements Runnable
{
  npz(npx paramnpx) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c)))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$DebugInfo.f = SystemClock.uptimeMillis();
      SLog.d("VideoViewTVKImpl", "TVK_IMediaPlayer.openMediaPlayerByUrl, 1, vid=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString });
      TVKPreloader.a();
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.c.replace("https://", "http://")), 0L, 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, null);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npz
 * JD-Core Version:    0.7.0.1
 */