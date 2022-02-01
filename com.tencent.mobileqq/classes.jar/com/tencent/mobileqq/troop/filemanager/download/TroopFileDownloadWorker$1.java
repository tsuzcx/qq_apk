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
    if (this.this$0.b)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("] start. had stoped");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      return;
    }
    this.this$0.c();
    Object localObject1 = MD5.toMD5(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    Object localObject2 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.c);
    localStringBuilder.append((String)localObject1);
    ((TroopFileDownloadWorker)localObject2).d = localStringBuilder.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.this$0.c);
    ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath.getBytes()));
    ((StringBuilder)localObject1).append(".tmp");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtil.a((String)localObject1) > 0L)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("] start. use oldVerTmpPath to resume.");
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
      this.this$0.d = ((String)localObject1);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile = this.this$0.d;
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */