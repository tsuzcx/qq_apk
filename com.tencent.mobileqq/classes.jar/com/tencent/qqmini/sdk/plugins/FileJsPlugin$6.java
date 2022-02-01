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
    Object localObject = ((MiniAppFileManager)FileJsPlugin.access$1900(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "tempFilePath file not exist");
    }
    long l2 = FileUtils.getFileSizes((String)localObject);
    if (TextUtils.isEmpty(this.val$filePath))
    {
      l3 = FileUtils.getFileSizes(((MiniAppFileManager)FileJsPlugin.access$2000(this.this$0).getManager(MiniAppFileManager.class)).getSaveStorePath(this.val$tempFilePath));
      if (!((MiniAppFileManager)FileJsPlugin.access$2400(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(1, l2 - l3, FileJsPlugin.access$2100(this.this$0), FileJsPlugin.access$2200(this.this$0), FileJsPlugin.access$2300(this.this$0).getAttachedActivity()))
      {
        FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject);
        return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      }
      str = ((MiniAppFileManager)FileJsPlugin.access$2500(this.this$0).getManager(MiniAppFileManager.class)).savePath(this.val$tempFilePath);
      if (!TextUtils.isEmpty(str))
      {
        FileJsPlugin.access$2600(this.this$0).updateFolderSize(1, l2 - l3);
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("savedFilePath", str);
          FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l1, str);
          return FileJsPlugin.access$1300(this.this$0, this.val$req, (JSONObject)localObject);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, null);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$2700(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    String str = FileJsPlugin.access$2600(this.this$0).getUsrPath(this.val$filePath);
    long l3 = FileUtils.getFileSizes(str);
    if (!((MiniAppFileManager)FileJsPlugin.access$3100(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(2, l2 - l3, FileJsPlugin.access$2800(this.this$0), FileJsPlugin.access$2900(this.this$0), FileJsPlugin.access$3000(this.this$0).getAttachedActivity()))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    FileUtils.copyFile((String)localObject, str);
    FileJsPlugin.access$2600(this.this$0).updateFolderSize(2, l2 - l3);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("savedFilePath", this.val$filePath);
      QMLog.d("FileJsPlugin", "saveFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveAboPath:" + str);
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l1, str);
      return FileJsPlugin.access$1300(this.this$0, this.val$req, (JSONObject)localObject);
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
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */