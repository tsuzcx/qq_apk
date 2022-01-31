import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class pzm
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  pzm(pzj parampzj) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(pzj.a(), 2, "播放器状态回调 onVideoPrepared");
    }
    pzj.a(this.a, System.currentTimeMillis());
    paramTVK_IMediaPlayer = new HashSet();
    Iterator localIterator = pzj.a(this.a).entrySet().iterator();
    while (localIterator.hasNext()) {
      paramTVK_IMediaPlayer.add(((Map.Entry)localIterator.next()).getKey());
    }
    pzj.a(this.a).setExtractFrameModeInfo(true, paramTVK_IMediaPlayer);
    pzj.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzm
 * JD-Core Version:    0.7.0.1
 */