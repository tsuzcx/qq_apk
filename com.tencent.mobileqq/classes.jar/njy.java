import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class njy
  implements TVK_IMediaPlayer.OnErrorListener
{
  public njy(VideoCoverView paramVideoCoverView) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.a.jdField_a_of_type_Int = 7;
    njc.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString);
    this.a.g();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njy
 * JD-Core Version:    0.7.0.1
 */