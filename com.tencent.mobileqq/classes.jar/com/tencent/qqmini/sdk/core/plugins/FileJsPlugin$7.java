package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import bdgo;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class FileJsPlugin$7
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$7(FileJsPlugin paramFileJsPlugin, String paramString1, bdfz parambdfz, String paramString2, long paramLong) {}
  
  public String run()
  {
    long l = 0L;
    Object localObject1 = bdeu.a().a(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "tempFilePath file not exist");
    }
    if (TextUtils.isEmpty(this.val$filePath))
    {
      localObject2 = this.this$0.mMiniAppInfo;
      if (localObject2 != null) {
        l = ((MiniAppInfo)localObject2).usrFileSizeLimit;
      }
      if (!bdeu.a().a(1, bdgo.a((String)localObject1), this.this$0.mIsMiniGame, l)) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      }
      localObject1 = bdeu.a().d(this.val$tempFilePath);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("savedFilePath", localObject1);
          bdnw.a("FileJsPlugin", "saveFile old succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveFilePath:" + (String)localObject1);
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
    if (bdeu.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    Object localObject2 = this.this$0.mMiniAppInfo;
    if (localObject2 != null) {
      l = ((MiniAppInfo)localObject2).usrFileSizeLimit;
    }
    if (!bdeu.a().a(2, bdgo.a((String)localObject1), this.this$0.mIsMiniGame, l)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    localObject2 = bdeu.a().c(this.val$filePath);
    bdgo.b((String)localObject1, (String)localObject2);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("savedFilePath", this.val$filePath);
      bdnw.a("FileJsPlugin", "saveFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveAboPath:" + (String)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */