package cooperation.qzone.webviewplugin.sound;

import android.os.Environment;
import android.text.TextUtils;
import bifw;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneSoundPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  public static final String QZONE_TINY_PROGRAM_CACHE = "tencent/Qzone/tinyprogram/";
  private static final String TAG = "QzoneSoundPlugin";
  private String mDownloadMusicFinalCachePath = "";
  private String mFinalCacheRoot = "";
  private QzoneSoundPlayerHelper mLocalBackSoundHelper = new QzoneSoundPlayerHelper();
  private QzoneSoundPlayerHelper mLocalSoundHelper = new QzoneSoundPlayerHelper();
  
  private String checkEnv()
  {
    if (TextUtils.isEmpty(this.mFinalCacheRoot))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "no sdcard");
        }
        return "";
      }
      Object localObject = QZoneFilePath.ROOT_PATH;
      this.mFinalCacheRoot = ((String)localObject + "tencent/Qzone/tinyprogram/");
      localObject = new File(this.mFinalCacheRoot);
      if (!((File)localObject).exists())
      {
        if (!((File)localObject).mkdirs())
        {
          if (QLog.isColorLevel()) {
            QLog.i("QzoneSoundPlugin", 2, "make dir fail");
          }
          return "";
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "make dir suc");
        }
      }
    }
    for (;;)
    {
      return this.mFinalCacheRoot;
      if (QLog.isColorLevel())
      {
        QLog.i("QzoneSoundPlugin", 2, "dir is exists");
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "cache root found use : " + this.mFinalCacheRoot);
        }
      }
    }
  }
  
  private void playLocalBackSound(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = MD5Utils.toMD5(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = checkEnv() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalBackSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.mLocalBackSoundHelper.setDataSource(paramVarArgs);
        this.mLocalBackSoundHelper.start();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void playLocalSound(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = MD5Utils.toMD5(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = checkEnv() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.mLocalSoundHelper.setDataSource(paramVarArgs);
        this.mLocalSoundHelper.start();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void preloadSound(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).optString("callback");
        Object localObject1 = ((JSONObject)localObject2).optString("url");
        localObject2 = MD5Utils.toMD5(((JSONObject)localObject2).optString("url"));
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicUrl : " + (String)localObject1);
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicMD5 : " + (String)localObject2);
        this.mDownloadMusicFinalCachePath = (checkEnv() + (String)localObject2 + ".mp3");
        QLog.d("QzoneSoundPlugin", 2, "mDownloadMusicFinalCachePath : " + this.mDownloadMusicFinalCachePath);
        if (!new File(this.mDownloadMusicFinalCachePath).exists())
        {
          DownloaderFactory.getInstance(this.parentPlugin.mRuntime.a()).getCommonDownloader().download((String)localObject1, this.mDownloadMusicFinalCachePath, new QzoneSoundPlugin.1(this, paramVarArgs));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "The Music File is Exist");
        }
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("code", 0);
          ((JSONObject)localObject1).put("message", "success");
          this.parentPlugin.callJs(paramVarArgs, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        catch (Exception paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadSucceed : " + paramVarArgs.getMessage());
        return;
      }
      catch (JSONException paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "METHOD_DOWNLOAD_SUPER_LIKE_MUSIC: ", paramVarArgs);
        }
      }
    }
  }
  
  private void stopLocalBackSound(String... paramVarArgs)
  {
    if (this.mLocalBackSoundHelper != null) {
      this.mLocalBackSoundHelper.stop();
    }
  }
  
  private void stopLocalSound(String... paramVarArgs)
  {
    if (this.mLocalSoundHelper != null) {
      this.mLocalSoundHelper.stop();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("playLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalSound");
      }
      playLocalSound(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("playLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalBackSound");
      }
      playLocalBackSound(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("preloadSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "preloadSound");
      }
      preloadSound(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalSound");
      }
      stopLocalSound(new String[0]);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalBackSound");
      }
      stopLocalBackSound(new String[0]);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDestroy");
    }
    if (this.mLocalBackSoundHelper != null)
    {
      this.mLocalBackSoundHelper.release();
      this.mLocalBackSoundHelper = null;
    }
    if (this.mLocalSoundHelper != null)
    {
      this.mLocalSoundHelper.release();
      this.mLocalSoundHelper = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin
 * JD-Core Version:    0.7.0.1
 */