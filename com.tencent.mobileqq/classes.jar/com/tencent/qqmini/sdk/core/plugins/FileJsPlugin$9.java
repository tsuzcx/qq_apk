package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgjm;
import bgkd;
import bglb;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$9
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$9(FileJsPlugin paramFileJsPlugin, String paramString1, bgkd parambgkd, String paramString2, long paramLong) {}
  
  public String run()
  {
    if (TextUtils.isEmpty(this.val$filePath)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    String str = bgjm.a().a(this.val$filePath);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    for (;;)
    {
      try
      {
        Object localObject = FileJsPlugin.access$500(this.this$0, this.val$encoding, str);
        if (localObject == null)
        {
          QMLog.e("FileJsPlugin", "readFile failed! path:" + str);
          return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((this.this$0.mIsMiniGame) && ((localObject instanceof byte[])))
        {
          bglb.a(this.this$0.mMiniAppContext, (byte[])localObject, bglb.a, "data", localJSONObject);
          QMLog.d("FileJsPlugin", "readFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str);
          return FileJsPlugin.access$200(this.this$0, this.val$req, localJSONObject);
        }
        if ((!this.this$0.mIsMiniGame) && ((localObject instanceof byte[]))) {
          bglb.a(this.this$0.mMiniAppContext, (byte[])localObject, bglb.b, "data", localJSONObject);
        } else {
          localJSONObject.put("data", localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("FileJsPlugin", "readFile failed! ," + localThrowable.getMessage());
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */