import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class kvi
  implements TVK_IMediaPlayer.OnErrorListener
{
  public kvi(VideoCoverView paramVideoCoverView) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.a.jdField_a_of_type_Int = 7;
    AdvertisementStatistics.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString);
    this.a.g();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvi
 * JD-Core Version:    0.7.0.1
 */