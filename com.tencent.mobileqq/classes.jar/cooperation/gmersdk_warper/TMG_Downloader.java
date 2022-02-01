package cooperation.gmersdk_warper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TMG_Downloader
{
  TMG_Downloader.DownloadContrl a = new TMG_Downloader.DownloadContrl();
  
  public static String a()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, "getFilesDir is null");
      }
      return "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getParent());
    ((StringBuilder)localObject2).append("/txlib/gme_sdk/");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    return localObject1;
  }
  
  static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = b().edit();
    localEditor.putString("gme_sdk_download_md5", paramString);
    localEditor.commit();
  }
  
  static SharedPreferences b()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.gme_sdk", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.TMG_Downloader
 * JD-Core Version:    0.7.0.1
 */