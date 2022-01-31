import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class kqi
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public kqi(AccountDetailVideoManager paramAccountDetailVideoManager) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    new Thread(new kqj(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqi
 * JD-Core Version:    0.7.0.1
 */