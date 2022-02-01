package cooperation.qzone.music;

import android.text.TextUtils;
import anni;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneMusicHelper
{
  public static final String NO_NETWORK_MSG = anni.a(2131710802);
  
  public static SongInfo convertAudioSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_c_of_type_JavaLangString = getString(paramJSONObject, "name");
    localSongInfo.h = getString(paramJSONObject, "singer");
    localSongInfo.a = getLong(paramJSONObject, "songId");
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "playUrl");
    localSongInfo.jdField_b_of_type_Int = getInt(paramJSONObject, "type");
    localSongInfo.e = getString(paramJSONObject, "cover");
    localSongInfo.jdField_c_of_type_Long = getLong(paramJSONObject, "singerId");
    localSongInfo.g = getString(paramJSONObject, "album");
    localSongInfo.f = getString(paramJSONObject, "detailUrl");
    localSongInfo.d = getString(paramJSONObject, "showId");
    if (localSongInfo.a == 0L) {
      localSongInfo.a = getFMID(localSongInfo.d);
    }
    return localSongInfo;
  }
  
  public static SongInfo convertFMBgMusic(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    String str = getString(paramJSONObject, "showID");
    localSongInfo.jdField_c_of_type_JavaLangString = getString(paramJSONObject, "showName");
    localSongInfo.h = "";
    localSongInfo.a = getFMID(str);
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "showAudioUrl");
    localSongInfo.jdField_b_of_type_Int = 8;
    localSongInfo.e = "";
    localSongInfo.jdField_c_of_type_Long = 0L;
    localSongInfo.g = "";
    localSongInfo.f = "";
    localSongInfo.d = str;
    return localSongInfo;
  }
  
  public static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_c_of_type_JavaLangString = getString(paramJSONObject, "name");
    localSongInfo.h = getString(paramJSONObject, "singer");
    localSongInfo.a = getLong(paramJSONObject, "songId");
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "playUrl");
    localSongInfo.jdField_b_of_type_Int = getInt(paramJSONObject, "type");
    localSongInfo.e = getString(paramJSONObject, "cover");
    localSongInfo.jdField_c_of_type_Long = getLong(paramJSONObject, "singerId");
    localSongInfo.g = getString(paramJSONObject, "album");
    localSongInfo.jdField_b_of_type_Long = getLong(paramJSONObject, "uin");
    if (TextUtils.isEmpty(localSongInfo.g)) {
      localSongInfo.g = getString(paramJSONObject, "songMid");
    }
    if (TextUtils.isEmpty(localSongInfo.g)) {
      localSongInfo.g = getString(paramJSONObject, "musicMId");
    }
    if ((!TextUtils.isEmpty(localSongInfo.g)) && (localSongInfo.a == 0L)) {
      localSongInfo.a = getSongIDWithMid(localSongInfo.g);
    }
    if ((localSongInfo.jdField_b_of_type_Int == 0) && (getInt(paramJSONObject, "voiceType") == 3)) {
      localSongInfo.jdField_b_of_type_Int = 11;
    }
    localSongInfo.f = getString(paramJSONObject, "detailUrl");
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
      QLog.e("QzoneWebMusicJsPlugin", 2, "getInt " + paramJSONObject.getMessage());
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
      QLog.e("QzoneWebMusicJsPlugin", 2, "getLong " + paramJSONObject.getMessage());
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
      QLog.e("QzoneWebMusicJsPlugin", 2, "getString " + paramJSONObject.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneMusicHelper
 * JD-Core Version:    0.7.0.1
 */