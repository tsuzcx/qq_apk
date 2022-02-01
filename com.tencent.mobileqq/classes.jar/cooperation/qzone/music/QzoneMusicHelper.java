package cooperation.qzone.music;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneMusicHelper
{
  public static final String NO_NETWORK_MSG = HardCodeUtil.a(2131909605);
  
  public static SongInfo convertAudioSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.e = getString(paramJSONObject, "name");
    localSongInfo.j = getString(paramJSONObject, "singer");
    localSongInfo.a = getLong(paramJSONObject, "songId");
    localSongInfo.d = getString(paramJSONObject, "playUrl");
    localSongInfo.m = getInt(paramJSONObject, "type");
    localSongInfo.g = getString(paramJSONObject, "cover");
    localSongInfo.k = getLong(paramJSONObject, "singerId");
    localSongInfo.i = getString(paramJSONObject, "album");
    localSongInfo.h = getString(paramJSONObject, "detailUrl");
    localSongInfo.f = getString(paramJSONObject, "showId");
    if (localSongInfo.a == 0L) {
      localSongInfo.a = getFMID(localSongInfo.f);
    }
    return localSongInfo;
  }
  
  public static SongInfo convertFMBgMusic(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    String str = getString(paramJSONObject, "showID");
    localSongInfo.e = getString(paramJSONObject, "showName");
    localSongInfo.j = "";
    localSongInfo.a = getFMID(str);
    localSongInfo.d = getString(paramJSONObject, "showAudioUrl");
    localSongInfo.m = 8;
    localSongInfo.g = "";
    localSongInfo.k = 0L;
    localSongInfo.i = "";
    localSongInfo.h = "";
    localSongInfo.f = str;
    return localSongInfo;
  }
  
  public static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.e = getString(paramJSONObject, "name");
    localSongInfo.j = getString(paramJSONObject, "singer");
    localSongInfo.a = getLong(paramJSONObject, "songId");
    localSongInfo.d = getString(paramJSONObject, "playUrl");
    localSongInfo.m = getInt(paramJSONObject, "type");
    localSongInfo.g = getString(paramJSONObject, "cover");
    localSongInfo.k = getLong(paramJSONObject, "singerId");
    localSongInfo.i = getString(paramJSONObject, "album");
    localSongInfo.c = getLong(paramJSONObject, "uin");
    if (TextUtils.isEmpty(localSongInfo.i)) {
      localSongInfo.i = getString(paramJSONObject, "songMid");
    }
    if (TextUtils.isEmpty(localSongInfo.i)) {
      localSongInfo.i = getString(paramJSONObject, "musicMId");
    }
    if ((!TextUtils.isEmpty(localSongInfo.i)) && (localSongInfo.a == 0L)) {
      localSongInfo.a = getSongIDWithMid(localSongInfo.i);
    }
    if ((localSongInfo.m == 0) && (getInt(paramJSONObject, "voiceType") == 3)) {
      localSongInfo.m = 11;
    }
    localSongInfo.h = getString(paramJSONObject, "detailUrl");
    return localSongInfo;
  }
  
  public static long getFMID(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      long l2 = paramString.hashCode();
      long l1 = l2;
      if (l2 >= 0L) {
        l1 = l2 * -1L - 1L - 2147483648L;
      }
      return l1;
    }
    return 0L;
  }
  
  private static int getInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      paramString = new StringBuilder();
      paramString.append("getInt ");
      paramString.append(paramJSONObject.getMessage());
      QLog.e("QzoneWebMusicJsPlugin", 2, paramString.toString());
    }
    return 0;
  }
  
  private static long getLong(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (Exception paramJSONObject)
    {
      paramString = new StringBuilder();
      paramString.append("getLong ");
      paramString.append(paramJSONObject.getMessage());
      QLog.e("QzoneWebMusicJsPlugin", 2, paramString.toString());
    }
    return 0L;
  }
  
  public static long getSongIDWithMid(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = paramString.hashCode();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = l2 * -1L;
      }
      return l1;
    }
    return 0L;
  }
  
  private static String getString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramString = new StringBuilder();
      paramString.append("getString ");
      paramString.append(paramJSONObject.getMessage());
      QLog.e("QzoneWebMusicJsPlugin", 2, paramString.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneMusicHelper
 * JD-Core Version:    0.7.0.1
 */