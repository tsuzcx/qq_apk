package cooperation.qzone.webviewplugin.sound;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QzoneSoundPlugin$1
  implements Downloader.DownloadListener
{
  QzoneSoundPlugin$1(QzoneSoundPlugin paramQzoneSoundPlugin, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadCanceled:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneSoundPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", -1);
      ((JSONObject)localObject).put("message", paramString);
      QzoneSoundPlugin.access$000(this.this$0).callJs(this.val$callback, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DownloaderFactory onDownloadCanceled : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.i("QzoneSoundPlugin", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFailed:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneSoundPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject();
      if (paramDownloadResult != null)
      {
        localObject = paramDownloadResult.getStatus();
        if (localObject != null) {
          paramString.put("code", ((DownloadResult.Status)localObject).failReason);
        } else {
          paramString.put("code", -1);
        }
        paramString.put("message", paramDownloadResult.getDetailDownloadInfo());
      }
      else
      {
        paramString.put("code", -1);
        paramString.put("message", "DownloadFailed");
      }
      QzoneSoundPlugin.access$100(this.this$0).callJs(this.val$callback, new String[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadResult = new StringBuilder();
        paramDownloadResult.append("DownloaderFactory onDownloadFailed : ");
        paramDownloadResult.append(paramString.getMessage());
        QLog.i("QzoneSoundPlugin", 2, paramDownloadResult.toString());
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" : ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" : ");
      localStringBuilder.append(paramFloat);
      QLog.d("QzoneSoundPlugin", 2, new Object[] { "onDownloadProgress: ", localStringBuilder.toString() });
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadSucceed");
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 0);
      paramString.put("message", "success");
      QzoneSoundPlugin.access$200(this.this$0).callJs(this.val$callback, new String[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadResult = new StringBuilder();
        paramDownloadResult.append("DownloaderFactory onDownloadSucceed : ");
        paramDownloadResult.append(paramString.getMessage());
        QLog.i("QzoneSoundPlugin", 2, paramDownloadResult.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin.1
 * JD-Core Version:    0.7.0.1
 */