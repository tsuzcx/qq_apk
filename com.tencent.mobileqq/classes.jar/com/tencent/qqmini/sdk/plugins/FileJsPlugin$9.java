package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$9
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$9(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.val$filePath))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid path");
    }
    if (!FileJsPlugin.access$1400(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    String str = ((MiniAppFileManager)FileJsPlugin.access$4400(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$filePath);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    for (;;)
    {
      try
      {
        Object localObject = FileJsPlugin.access$4500(this.this$0, this.val$encoding, str);
        if (localObject == null)
        {
          QMLog.e("FileJsPlugin", "readFile failed! path:" + str);
          FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, str);
          return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((FileJsPlugin.access$4600(this.this$0)) && ((localObject instanceof byte[])))
        {
          NativeBuffer.packNativeBuffer(this.val$req.jsService, (byte[])localObject, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject);
          FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l, str);
          return FileJsPlugin.access$1300(this.this$0, this.val$req, localJSONObject);
        }
        if ((!FileJsPlugin.access$4700(this.this$0)) && ((localObject instanceof byte[]))) {
          NativeBuffer.packNativeBuffer(this.val$req.jsService, (byte[])localObject, NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject);
        } else {
          localJSONObject.put("data", localThrowable);
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("FileJsPlugin", "readFile failed! ," + localThrowable.getMessage());
        FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, str);
        return FileJsPlugin.access$1200(this.this$0, this.val$req, null, localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */