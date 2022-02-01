import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class njx
  implements awyi
{
  njx(njw paramnjw) {}
  
  public String getToken()
  {
    return QQPlayerService.a(5, "" + this.a.a);
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicService", 2, "onPlaySongChanged:" + paramSongInfo.c);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicService", 2, "onPlayStateChanged:" + paramInt);
    }
    Object localObject = QQPlayerService.b();
    localObject = njw.a(this.a, (SongInfo)localObject);
    if (localObject != null) {}
    try
    {
      ((JSONObject)localObject).put("state", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*.qq.com");
      avob.a("qbrowserMusicStateChange", (JSONObject)localObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMusicService", 2, "onPlayStateChanged:" + localJSONException.getStackTrace());
        }
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njx
 * JD-Core Version:    0.7.0.1
 */