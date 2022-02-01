package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;

class TroopFileDownloadWorker$1
  implements Runnable
{
  TroopFileDownloadWorker$1(TroopFileDownloadWorker paramTroopFileDownloadWorker) {}
  
  public void run()
  {
    int i;
    if (this.this$0.g)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.this$0.f);
      ((StringBuilder)localObject1).append("] start. had stoped");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      return;
    }
    this.this$0.m();
    Object localObject1 = MD5.toMD5(this.this$0.e.FilePath);
    Object localObject2 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.k);
    localStringBuilder.append((String)localObject1);
    ((TroopFileDownloadWorker)localObject2).l = localStringBuilder.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.this$0.k);
    ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(this.this$0.e.FilePath.getBytes()));
    ((StringBuilder)localObject1).append(".tmp");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtil.f((String)localObject1) > 0L)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.this$0.f);
      ((StringBuilder)localObject2).append("] start. use oldVerTmpPath to resume.");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
      this.this$0.l = ((String)localObject1);
    }
    this.this$0.e.TmpFile = this.this$0.l;
    this.this$0.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */