package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;

public class AEOldShortVideoResStatus
{
  static AEOldShortVideoResStatus.ResStatus a(String paramString)
  {
    String str = paramString;
    if (VideoEnvironment64BitUtils.checkIs64bit())
    {
      str = paramString;
      if (!paramString.endsWith("64bit")) {
        str = paramString + "64bit";
      }
    }
    paramString = new AEOldShortVideoResStatus.ResStatus();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
    paramString.a = localSharedPreferences.getInt(str + "_version_k", 0);
    paramString.b = localSharedPreferences.getInt(str + "_status_k", -1);
    paramString.c = localSharedPreferences.getInt(str + "_last_error_k", -1);
    return paramString;
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (VideoEnvironment64BitUtils.checkIs64bit())
    {
      str = paramString;
      if (!paramString.endsWith("64bit")) {
        str = paramString + "64bit";
      }
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
    paramString.putInt(str + "_version_k", paramInt1);
    paramString.putInt(str + "_status_k", paramInt2);
    paramString.putInt(str + "_last_error_k", paramInt3);
    return paramString.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResStatus
 * JD-Core Version:    0.7.0.1
 */