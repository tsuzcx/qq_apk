package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$10
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$10(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.val$filePath))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid path");
    }
    Object localObject2;
    if (!FileJsPlugin.access$1200(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$filePath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("invalid encoding ");
      ((StringBuilder)localObject3).append(this.val$encoding);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
    }
    Object localObject1 = ((MiniAppFileManager)FileJsPlugin.access$4200(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$filePath);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists())) {
      try
      {
        localObject2 = FileJsPlugin.access$4300(this.this$0, this.val$encoding, (String)localObject1);
        if (localObject2 == null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readFile failed! path:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QMLog.e("FileJsPlugin", ((StringBuilder)localObject2).toString());
          FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject1);
          localObject2 = this.this$0;
          localObject3 = this.val$req;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("no such file or directory, open ");
          localStringBuilder.append(this.val$filePath);
          return FileJsPlugin.access$1000((FileJsPlugin)localObject2, (RequestEvent)localObject3, null, localStringBuilder.toString());
        }
        localObject3 = new JSONObject();
        boolean bool = FileJsPlugin.access$4400(this.this$0);
        if ((bool) && ((localObject2 instanceof byte[]))) {
          NativeBuffer.packNativeBuffer(this.val$req.jsService, (byte[])localObject2, NativeBuffer.TYPE_BUFFER_NATIVE, "data", (JSONObject)localObject3);
        } else if ((!FileJsPlugin.access$4500(this.this$0)) && ((localObject2 instanceof byte[]))) {
          NativeBuffer.packNativeBuffer(this.val$req.jsService, (byte[])localObject2, NativeBuffer.TYPE_BUFFER_BASE64, "data", (JSONObject)localObject3);
        } else {
          ((JSONObject)localObject3).put("data", localObject2);
        }
        FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l, (String)localObject1);
        localObject2 = FileJsPlugin.access$1100(this.this$0, this.val$req, (JSONObject)localObject3);
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("readFile failed! ,");
        ((StringBuilder)localObject3).append(localThrowable.getMessage());
        QMLog.e("FileJsPlugin", ((StringBuilder)localObject3).toString());
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject1);
        return FileJsPlugin.access$1000(this.this$0, this.val$req, null, localThrowable.getMessage());
      }
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject1);
    localObject1 = this.this$0;
    RequestEvent localRequestEvent = this.val$req;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("no such file or directory, open ");
    ((StringBuilder)localObject3).append(this.val$filePath);
    return FileJsPlugin.access$1000((FileJsPlugin)localObject1, localRequestEvent, null, ((StringBuilder)localObject3).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */