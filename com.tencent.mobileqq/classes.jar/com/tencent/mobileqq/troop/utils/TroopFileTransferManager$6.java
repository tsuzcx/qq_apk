package com.tencent.mobileqq.troop.utils;

import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class TroopFileTransferManager$6
  extends TroopFileGetOneFileInfoObserver
{
  TroopFileTransferManager$6(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((paramBoolean) && (paramFileInfo != null))
    {
      String str = paramFileInfo.str_file_id.get();
      Object localObject = str;
      if (!str.startsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      localObject = this.a.a().a((String)localObject);
      if (localObject != null)
      {
        ((TroopFileInfo)localObject).a = paramFileInfo.uint32_bus_id.get();
        ((TroopFileInfo)localObject).c = paramFileInfo.uint32_dead_time.get();
      }
      this.a.a().d((TroopFileInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6
 * JD-Core Version:    0.7.0.1
 */