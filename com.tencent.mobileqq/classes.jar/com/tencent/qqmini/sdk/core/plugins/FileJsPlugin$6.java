package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgho;
import bgjm;
import bgkd;
import bgkv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, bgkd parambgkd, String paramString2, long paramLong) {}
  
  public String run()
  {
    long l = 0L;
    Object localObject1 = bgjm.a().a(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "tempFilePath file not exist");
    }
    if (TextUtils.isEmpty(this.val$filePath))
    {
      localObject2 = this.this$0.mMiniAppInfo;
      if (localObject2 != null) {
        l = ((MiniAppInfo)localObject2).usrFileSizeLimit;
      }
      if (!bgjm.a().a(1, bgkv.a((String)localObject1), this.this$0.mIsMiniGame, l, this.this$0.mMiniAppInfo, this.this$0.mMiniAppContext.a())) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      }
      localObject1 = bgjm.a().d(this.val$tempFilePath);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("savedFilePath", localObject1);
          QMLog.d("FileJsPlugin", "saveFile old succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveFilePath:" + (String)localObject1);
          return FileJsPlugin.access$200(this.this$0, this.val$req, (JSONObject)localObject2);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, null);
    }
    if (bgjm.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    Object localObject2 = this.this$0.mMiniAppInfo;
    if (localObject2 != null) {
      l = ((MiniAppInfo)localObject2).usrFileSizeLimit;
    }
    if (!bgjm.a().a(2, bgkv.a((String)localObject1), this.this$0.mIsMiniGame, l, this.this$0.mMiniAppInfo, this.this$0.mMiniAppContext.a())) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    localObject2 = bgjm.a().c(this.val$filePath);
    bgkv.b((String)localObject1, (String)localObject2);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("savedFilePath", this.val$filePath);
      QMLog.d("FileJsPlugin", "saveFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveAboPath:" + (String)localObject2);
      return FileJsPlugin.access$200(this.this$0, this.val$req, (JSONObject)localObject1);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */