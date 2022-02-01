package cooperation.qzone.webviewplugin.sound;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
    Object localObject;
    if (TextUtils.isEmpty(this.mFinalCacheRoot))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "no sdcard");
        }
        return "";
      }
      localObject = QZoneFilePath.ROOT_PATH;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("tencent/Qzone/tinyprogram/");
      this.mFinalCacheRoot = localStringBuilder.toString();
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
      else if (QLog.isColorLevel())
      {
        QLog.i("QzoneSoundPlugin", 2, "dir is exists");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cache root found use : ");
      ((StringBuilder)localObject).append(this.mFinalCacheRoot);
      QLog.i("QzoneSoundPlugin", 2, ((StringBuilder)localObject).toString());
    }
    return this.mFinalCacheRoot;
  }
  
  private void playLocalBackSound(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = MD5Utils.toMD5(new JSONObject(paramVarArgs[0]).optString("url"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(checkEnv());
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append(".mp3");
      paramVarArgs = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playLocalBackSound : ");
      localStringBuilder.append(paramVarArgs);
      QLog.d("QzoneSoundPlugin", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(checkEnv());
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append(".mp3");
      paramVarArgs = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playLocalSound : ");
      localStringBuilder.append(paramVarArgs);
      QLog.d("QzoneSoundPlugin", 2, localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadMusicUrl : ");
        localStringBuilder.append((String)localObject1);
        QLog.d("QzoneSoundPlugin", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadMusicMD5 : ");
        localStringBuilder.append((String)localObject2);
        QLog.d("QzoneSoundPlugin", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(checkEnv());
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".mp3");
        this.mDownloadMusicFinalCachePath = localStringBuilder.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mDownloadMusicFinalCachePath : ");
        ((StringBuilder)localObject2).append(this.mDownloadMusicFinalCachePath);
        QLog.d("QzoneSoundPlugin", 2, ((StringBuilder)localObject2).toString());
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
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DownloaderFactory onDownloadSucceed : ");
        ((StringBuilder)localObject1).append(paramVarArgs.getMessage());
        QLog.i("QzoneSoundPlugin", 2, ((StringBuilder)localObject1).toString());
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
    paramVarArgs = this.mLocalBackSoundHelper;
    if (paramVarArgs != null) {
      paramVarArgs.stop();
    }
  }
  
  private void stopLocalSound(String... paramVarArgs)
  {
    paramVarArgs = this.mLocalSoundHelper;
    if (paramVarArgs != null) {
      paramVarArgs.stop();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
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
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDestroy");
    }
    QzoneSoundPlayerHelper localQzoneSoundPlayerHelper = this.mLocalBackSoundHelper;
    if (localQzoneSoundPlayerHelper != null)
    {
      localQzoneSoundPlayerHelper.release();
      this.mLocalBackSoundHelper = null;
    }
    localQzoneSoundPlayerHelper = this.mLocalSoundHelper;
    if (localQzoneSoundPlayerHelper != null)
    {
      localQzoneSoundPlayerHelper.release();
      this.mLocalSoundHelper = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin
 * JD-Core Version:    0.7.0.1
 */