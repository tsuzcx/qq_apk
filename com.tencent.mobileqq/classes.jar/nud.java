import android.app.Activity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.3.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class nud
  implements TVK_IMediaPlayer.OnErrorListener
{
  nud(nua paramnua) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("video player error model=" + paramInt1);
      paramTVK_IMediaPlayer.append(",what=" + paramInt2);
      paramTVK_IMediaPlayer.append(",extra=" + paramInt3);
      paramTVK_IMediaPlayer.append(",detailInfo=" + paramString);
      QLog.e("AccountDetailVideoManager", 2, paramTVK_IMediaPlayer.toString());
    }
    this.a.a.runOnUiThread(new AccountDetailVideoManager.3.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nud
 * JD-Core Version:    0.7.0.1
 */