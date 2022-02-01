import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.1.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class obc
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  obc(obb paramobb) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    new Thread(new AccountDetailVideoManager.1.1(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obc
 * JD-Core Version:    0.7.0.1
 */