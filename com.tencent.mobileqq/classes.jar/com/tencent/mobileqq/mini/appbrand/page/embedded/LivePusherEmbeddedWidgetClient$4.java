package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.text.TextUtils;
import bhmi;
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

class LivePusherEmbeddedWidgetClient$4
  implements Downloader.DownloadListener
{
  LivePusherEmbeddedWidgetClient$4(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, String paramString1, String paramString2, int paramInt, JsRuntime paramJsRuntime, String paramString3, JSONObject paramJSONObject, String paramString4) {}
  
  public void onDownloadCanceled(String paramString)
  {
    LivePusherEmbeddedWidgetClient.access$400(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QLog.e("miniapp-embedded-live-pusher", 1, "playBGM - download onDownloadCanceled failed:" + paramString);
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    LivePusherEmbeddedWidgetClient.access$400(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    QLog.e("miniapp-embedded-live-pusher", 1, "playBGM - download onDownloadFailed failed:" + paramString);
    paramDownloadResult = new JSONObject();
    try
    {
      paramDownloadResult.put("viewId", this.val$viewId);
      paramDownloadResult.put("errMsg", paramString);
      paramDownloadResult.put("errCode", 10003);
      this.val$serviceWebView.evaluateSubcribeJS("onXWebLivePusherError", paramDownloadResult.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (LivePusherEmbeddedWidgetClient.access$500(this.this$0))
    {
      QLog.d("miniapp-embedded-live-pusher", 2, "playBGM - download onDownloadProgress, abort");
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
        QLog.e("miniapp-embedded-live-pusher", 1, "playBGM - download onDownloadSucceed:" + paramString);
        if (LivePusherEmbeddedWidgetClient.access$500(this.this$0))
        {
          QLog.e("miniapp-embedded-live-pusher", 1, "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
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
            QLog.e("miniapp-embedded-live-pusher", 1, "file no exists, try to copy again.");
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
                QLog.w("miniapp-embedded-live-pusher", 1, "download Succeed but target file not exists, try copy from download tmp file:" + str2 + ", length:" + localFile.length() + ", to:" + this.val$BGMFilePath);
                localObject = bhmi.a(this.val$BGMFilePath);
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
          if ((!bhmi.a(localFile, paramString)) || (!paramString.exists()) || (paramString.length() != localFile.length())) {
            continue;
          }
          QLog.i("miniapp-embedded-live-pusher", 1, "copy from download tmp file:" + str2 + " success");
          localObject = paramString;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("miniapp-embedded-live-pusher", 1, "try copy from download tmp file exception! tmp file:" + str2, localThrowable1);
          str1 = paramString;
          break;
          QLog.d("miniapp-embedded-live-pusher", 1, "download failed, filepath not exists, tmpFile:" + paramDownloadResult.getPath());
          return;
        }
      }
      LivePusherEmbeddedWidgetClient.access$400(this.this$0).remove(this.val$downloadId);
      if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
        break label420;
      }
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-embedded-live-pusher", 1, "download success BGMFilePath:" + this.val$BGMFilePath);
      }
      this.val$jsonObject.put("BGMFilePath", this.val$BGMFilePath);
      LivePusherEmbeddedWidgetClient.access$000(this.this$0).operateLivePusher(this.val$type, this.val$jsonObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePusherEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */