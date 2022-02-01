package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;

class TroopFileThumbnailGenTask$1
  implements Runnable
{
  TroopFileThumbnailGenTask$1(TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.d)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] passiveEnd. but had stop");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
      return;
    }
    if (!this.a)
    {
      this.this$0.a(this.b, true);
      return;
    }
    Object localObject = this.this$0;
    ((TroopFileThumbnailGenTask)localObject).h = ((TroopFileThumbnailGenTask)localObject).b.getThumbnailFile(this.this$0.a, this.this$0.j);
    if (this.this$0.h.equalsIgnoreCase(this.c))
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("] passiveSuc thumbpath is same.");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
      this.this$0.a(true, true);
      return;
    }
    int i = TroopFileTransferUtil.Log.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.this$0.c);
    ((StringBuilder)localObject).append("] passiveSuc copy file.");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.h);
    localStringBuilder.append(".ttmp");
    ((TroopFileThumbnailGenTask)localObject).g = localStringBuilder.toString();
    FileUtils.copyFile(this.c, this.this$0.g);
    this.this$0.a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.1
 * JD-Core Version:    0.7.0.1
 */