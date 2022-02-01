package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class FileJsPlugin$17
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$17(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, RequestEvent paramRequestEvent, long paramLong, String paramString2, String paramString3) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid data ");
    }
    RequestEvent localRequestEvent;
    StringBuilder localStringBuilder;
    if (!FileJsPlugin.access$1200(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid encoding ");
      localStringBuilder.append(this.val$encoding);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    if (((MiniAppFileManager)FileJsPlugin.access$6400(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    Object localObject = this.val$nativeBufferBytes;
    int i;
    if (localObject != null) {
      i = localObject.length;
    } else {
      i = this.val$data.length();
    }
    long l2 = i;
    if (!((MiniAppFileManager)FileJsPlugin.access$6800(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(2, l2, FileJsPlugin.access$6500(this.this$0), FileJsPlugin.access$6600(this.this$0), FileJsPlugin.access$6700(this.this$0).getAttachedActivity()))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    return FileJsPlugin.access$6900(this.this$0, l1, this.val$filePath, this.val$nativeBufferBytes, this.val$data, this.val$encoding, this.val$req, this.val$startMS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */