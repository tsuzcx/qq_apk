import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.1.1;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class muj
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  muj(mui parammui) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    new Thread(new AccountDetailVideoManager.1.1(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muj
 * JD-Core Version:    0.7.0.1
 */