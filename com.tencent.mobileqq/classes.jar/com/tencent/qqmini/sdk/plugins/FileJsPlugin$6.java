package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = ((MiniAppFileManager)FileJsPlugin.access$1700(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject2);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "tempFilePath file not exist");
    }
    long l2 = FileUtils.getFileSizes((String)localObject2);
    if (TextUtils.isEmpty(this.val$filePath))
    {
      l3 = FileUtils.getFileSizes(((MiniAppFileManager)FileJsPlugin.access$1800(this.this$0).getManager(MiniAppFileManager.class)).getSaveStorePath(this.val$tempFilePath));
      localObject1 = (MiniAppFileManager)FileJsPlugin.access$2200(this.this$0).getManager(MiniAppFileManager.class);
      l2 -= l3;
      if (!((MiniAppFileManager)localObject1).isFolderCanWrite(1, l2, FileJsPlugin.access$1900(this.this$0), FileJsPlugin.access$2000(this.this$0), FileJsPlugin.access$2100(this.this$0).getAttachedActivity()))
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject2);
        return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      }
      localObject1 = ((MiniAppFileManager)FileJsPlugin.access$2300(this.this$0).getManager(MiniAppFileManager.class)).savePath(this.val$tempFilePath);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        FileJsPlugin.access$2400(this.this$0).updateFolderSize(1, l2);
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("savedFilePath", localObject1);
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l1, (String)localObject1);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, (JSONObject)localObject2);
      }
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject1);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, null);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$2500(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("permission denied, open ");
      ((StringBuilder)localObject3).append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
    }
    Object localObject1 = FileJsPlugin.access$2400(this.this$0).getUsrPath(this.val$filePath);
    long l3 = FileUtils.getFileSizes((String)localObject1);
    Object localObject3 = (MiniAppFileManager)FileJsPlugin.access$2900(this.this$0).getManager(MiniAppFileManager.class);
    l2 -= l3;
    if (!((MiniAppFileManager)localObject3).isFolderCanWrite(2, l2, FileJsPlugin.access$2600(this.this$0), FileJsPlugin.access$2700(this.this$0), FileJsPlugin.access$2800(this.this$0).getAttachedActivity()))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    FileUtils.copyFile((String)localObject2, (String)localObject1);
    FileJsPlugin.access$2400(this.this$0).updateFolderSize(2, l2);
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("savedFilePath", this.val$filePath);
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveFile succeed! [minigame timecost:");
    localStringBuilder.append(System.currentTimeMillis() - this.val$startMS);
    localStringBuilder.append("ms], saveAboPath:");
    localStringBuilder.append((String)localObject1);
    QMLog.d("FileJsPlugin", localStringBuilder.toString());
    FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l1, (String)localObject1);
    return FileJsPlugin.access$1100(this.this$0, this.val$req, (JSONObject)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */