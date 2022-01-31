package com.tencent.mobileqq.mini.widget.media;

import android.text.TextUtils;
import bace;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePusher$4
  implements Downloader.DownloadListener
{
  MiniAppLivePusher$4(MiniAppLivePusher paramMiniAppLivePusher, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4) {}
  
  public void onDownloadCanceled(String paramString)
  {
    MiniAppLivePusher.access$100(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QLog.e("MiniAppLivePusher", 1, "playBGM - download onDownloadCanceled failed:" + paramString);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    MiniAppLivePusher.access$100(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QLog.e("MiniAppLivePusher", 1, "playBGM - download onDownloadFailed failed:" + paramString);
    paramDownloadResult = new JSONObject();
    try
    {
      paramDownloadResult.put("livePusherId", this.this$0.livePusherId);
      paramDownloadResult.put("errMsg", paramString);
      paramDownloadResult.put("errCode", 10003);
      this.this$0.serviceWebview.evaluateSubcribeJS("onLivePusherError", paramDownloadResult.toString(), this.this$0.webviewId);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (MiniAppLivePusher.access$200(this.this$0))
    {
      QLog.d("MiniAppLivePusher", 2, "playBGM - download onDownloadProgress, abort");
      MiniappDownloadUtil.getInstance().abort(this.val$BGMUrl);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    String str2;
    for (;;)
    {
      try
      {
        QLog.e("MiniAppLivePusher", 1, "playBGM - download onDownloadSucceed:" + paramString);
        if (MiniAppLivePusher.access$200(this.this$0))
        {
          QLog.e("MiniAppLivePusher", 1, "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
          return;
        }
        if (TextUtils.isEmpty(this.val$BGMFilePath)) {
          return;
        }
        paramString = new File(this.val$BGMFilePath);
        str2 = paramDownloadResult.getPath();
        localObject = paramString;
        if (!paramString.exists())
        {
          localObject = paramString;
          if (!TextUtils.isEmpty(str2)) {
            QLog.e("MiniAppLivePusher", 1, "file no exists, try to copy again.");
          }
        }
      }
      catch (JSONException paramString)
      {
        File localFile;
        paramString.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localFile = new File(str2);
          localObject = paramString;
          if (localFile.exists())
          {
            localObject = paramString;
            if (localFile.isFile())
            {
              localObject = paramString;
              if (localFile.length() > 0L)
              {
                QLog.w("MiniAppLivePusher", 1, "download Succeed but target file not exists, try copy from download tmp file:" + str2 + ", length:" + localFile.length() + ", to:" + this.val$BGMFilePath);
                localObject = bace.a(this.val$BGMFilePath);
                paramString = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          String str1;
          continue;
        }
        try
        {
          if ((!bace.a(localFile, paramString)) || (!paramString.exists()) || (paramString.length() != localFile.length())) {
            continue;
          }
          QLog.i("MiniAppLivePusher", 1, "copy from download tmp file:" + str2 + " success");
          localObject = paramString;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("MiniAppLivePusher", 1, "try copy from download tmp file exception! tmp file:" + str2, localThrowable1);
          str1 = paramString;
          break;
          QLog.d("MiniAppLivePusher", 1, "download failed, filepath not exists, tmpFile:" + paramDownloadResult.getPath());
          return;
        }
      }
      MiniAppLivePusher.access$100(this.this$0).remove(this.val$downloadId);
      if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
        break label420;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppLivePusher", 1, "download success BGMFilePath:" + this.val$BGMFilePath);
      }
      this.val$jsonObject.put("BGMFilePath", this.val$BGMFilePath);
      MiniAppLivePusher.access$300(this.this$0).operateLivePusher(this.val$operateName, this.val$jsonObject);
      return;
      Object localObject = paramString;
      if (paramString.exists())
      {
        paramString.delete();
        localObject = paramString;
      }
    }
    label420:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher.4
 * JD-Core Version:    0.7.0.1
 */