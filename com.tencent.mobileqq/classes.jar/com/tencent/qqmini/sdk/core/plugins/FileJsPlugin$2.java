package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import behp;
import bejl;
import bekr;
import belh;
import belj;
import betc;
import bezb;
import bezd;
import bezi;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$2
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$2(FileJsPlugin paramFileJsPlugin, String paramString1, bekr parambekr, long paramLong, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4) {}
  
  private void reportDownloadFileResult(long paramLong, int paramInt)
  {
    if (this.this$0.mIsMiniGame) {}
    for (String str = "1";; str = "0")
    {
      bezi.a(this.this$0.mMiniAppInfo, 640, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    betc.a("FileJsPlugin", "download failed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms]");
    try
    {
      FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.val$downloadId);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed." + paramString);
      this.val$req.a.a("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - this.val$startMS, paramInt);
      bezb.a(this.this$0.mMiniAppInfo, 0, System.currentTimeMillis() - this.val$startMS, true);
      bezd.a(this.this$0.mMiniAppInfo, this.val$reportUrl, System.currentTimeMillis() - this.val$startMS, paramInt, 0);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        betc.d("FileJsPlugin", "download onDownloadFailed failed." + paramString);
      }
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    new JSONObject();
    try
    {
      paramMap = belj.a(paramMap);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.val$downloadId);
      localJSONObject.put("statusCode", 200);
      localJSONObject.put("header", paramMap);
      localJSONObject.put("state", "headersReceived");
      this.val$req.a.a("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      betc.d("FileJsPlugin", "onDownloadSucceed headerJson error." + paramMap);
    }
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.val$downloadId);
      localJSONObject.put("progress", (int)(100.0F * paramFloat));
      localJSONObject.put("totalBytesWritten", (float)paramLong1 * paramFloat);
      localJSONObject.put("totalBytesExpectedToWrite", paramLong1);
      localJSONObject.put("state", "progressUpdate");
      this.val$req.a.a("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("FileJsPlugin", "download onDownloadProgress failed." + localThrowable);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    betc.a("FileJsPlugin", "download Succeed! [minigame downloadTaskId:" + this.val$downloadId + ", timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms]");
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.val$filePath))
        {
          localObject1 = new File(this.val$filePath);
          if (((File)localObject1).exists()) {
            continue;
          }
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        Object localObject1;
        Object localObject3;
        Object localObject2;
        betc.d("FileJsPlugin", "download onDownloadSucceed exception.", paramString);
        paramMap = new JSONObject();
        try
        {
          FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
          paramMap.put("downloadTaskId", this.val$downloadId);
          paramMap.put("state", "fail");
          paramMap.put("errMsg", "Download Failed.");
          this.val$req.a.a("onDownloadTaskStateChange", paramMap.toString(), 0);
        }
        catch (JSONException paramMap)
        {
          betc.d("FileJsPlugin", "download onDownloadSucceed callback fail exception.", paramString);
        }
        continue;
        betc.a("FileJsPlugin", "download failed, filepath not exists, tmpFile:" + this.val$tmpFilePath);
        FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
        paramString = new JSONObject();
        paramString.put("downloadTaskId", this.val$downloadId);
        paramString.put("state", "fail");
        paramString.put("errMsg", "Download Failed: file not exists or can not read.");
        this.val$req.a.a("onDownloadTaskStateChange", paramString.toString(), 0);
        continue;
        continue;
      }
      try
      {
        localObject3 = new File(paramString);
        localObject2 = localObject1;
        if (((File)localObject3).exists())
        {
          localObject2 = localObject1;
          if (((File)localObject3).isFile())
          {
            localObject2 = localObject1;
            if (((File)localObject3).length() > 0L)
            {
              betc.c("FileJsPlugin", "download Succeed but target file not exists, try copy from download tmp file:" + paramString + ", length:" + ((File)localObject3).length() + ", to:" + this.val$filePath);
              localObject2 = belh.a(this.val$filePath);
              localObject1 = localObject2;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
        paramString = localThrowable2;
        continue;
        paramString = (String)localObject3;
        continue;
      }
      try
      {
        if ((!belh.b((File)localObject3, (File)localObject1)) || (!((File)localObject1).exists()) || (((File)localObject1).length() != ((File)localObject3).length())) {
          continue;
        }
        betc.b("FileJsPlugin", "copy from download tmp file:" + paramString + " success");
        localObject2 = localObject1;
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable1)
      {
        betc.d("FileJsPlugin", "try copy from download tmp file exception! tmp file:" + paramString, localThrowable1);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        if (!"png".equalsIgnoreCase(paramString)) {
          continue;
        }
        paramString = "png";
        continue;
        if (!"gif".equalsIgnoreCase(paramString)) {
          continue;
        }
        paramString = "gif";
        continue;
        if (!"svg+xml".equalsIgnoreCase(paramString)) {
          continue;
        }
        paramString = "svg";
        continue;
        if (!"webp".equalsIgnoreCase(paramString)) {
          continue;
        }
      }
    }
    if ((((File)localObject1).exists()) && (((File)localObject1).canRead()))
    {
      localObject2 = this.val$filePath;
      for (;;)
      {
        try
        {
          localObject3 = MimeTypeMap.getFileExtensionFromUrl((String)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1161;
          }
          if (paramMap == null) {
            continue;
          }
          paramString = (List)paramMap.get("Content-Type");
          if ((paramString == null) || (paramString.size() <= 0)) {
            continue;
          }
          paramString = (String)paramString.get(0);
          if (TextUtils.isEmpty(paramString)) {
            break label1161;
          }
          paramString = paramString.trim().split("/");
          if ((paramString.length <= 1) || (!"image".equalsIgnoreCase(paramString[0]))) {
            break label1161;
          }
          paramString = paramString[1];
          if (!"jpeg".equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = "jpg";
          if (TextUtils.isEmpty(paramString)) {
            break label1161;
          }
          paramString = (String)localObject2 + "." + paramString;
          if (!belh.b(this.val$filePath, paramString)) {
            break label1161;
          }
          belh.a(this.val$filePath);
          localObject2 = paramString;
        }
        catch (Throwable paramString)
        {
          betc.d("FileJsPlugin", "create file extension failed! " + paramString);
          continue;
        }
        paramString = new JSONObject();
        paramString.put("downloadTaskId", this.val$downloadId);
        paramString.put("progress", 100);
        paramString.put("totalBytesWritten", ((File)localObject1).length());
        paramString.put("totalBytesExpectedToWrite", ((File)localObject1).length());
        paramString.put("state", "progressUpdate");
        this.val$req.a.a("onDownloadTaskStateChange", paramString.toString(), 0);
        betc.a("FileJsPlugin", "download success.");
        paramString = new JSONObject();
        try
        {
          paramMap = belj.a(paramMap);
          paramString = paramMap;
        }
        catch (Exception paramMap)
        {
          betc.d("FileJsPlugin", "onDownloadSucceed headerJson error." + paramMap);
          continue;
          paramMap.put("filePath", this.val$reqParamObj.optString("filePath"));
          continue;
        }
        FileJsPlugin.access$000(this.this$0).remove(this.val$downloadId);
        paramMap = new JSONObject();
        paramMap.put("statusCode", 200);
        paramMap.put("downloadTaskId", this.val$downloadId);
        if ((!this.val$reqParamObj.isNull("filePath")) && (!TextUtils.isEmpty(this.val$reqParamObj.optString("filePath")))) {
          break label1032;
        }
        paramMap.put("tempFilePath", bejl.a().e((String)localObject2));
        paramMap.put("header", paramString);
        paramMap.put("state", "success");
        this.val$req.a.a("onDownloadTaskStateChange", paramMap.toString(), 0);
        reportDownloadFileResult(System.currentTimeMillis() - this.val$startMS, paramInt);
        bezb.a(this.this$0.mMiniAppInfo, 0, System.currentTimeMillis() - this.val$startMS, false);
        bezd.a(this.this$0.mMiniAppInfo, this.val$reportUrl, System.currentTimeMillis() - this.val$startMS, paramInt, 0);
        return;
        localObject2 = localObject1;
        if (!((File)localObject1).exists()) {
          break;
        }
        ((File)localObject1).delete();
        localObject2 = localObject1;
        break;
        paramString = "webp";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */