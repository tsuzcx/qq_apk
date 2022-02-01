package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class TroopFileUploadFeedsSender$2
  extends TroopFileGetOneFileInfoObserver
{
  TroopFileUploadFeedsSender$2(TroopFileUploadFeedsSender paramTroopFileUploadFeedsSender) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramBoolean)
    {
      if (paramFileInfo == null) {
        return;
      }
      Object localObject2 = paramFileInfo.str_file_id.get();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      Object localObject1 = localObject2;
      if (!((String)localObject2).startsWith("/"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!((String)localObject1).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath)) {
        return;
      }
      paramInt = TroopFileTransferUtil.Log.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("] onGetOneFileResult. bus_id:");
      ((StringBuilder)localObject2).append(paramFileInfo.uint32_bus_id.get());
      ((StringBuilder)localObject2).append(" dead_time:");
      ((StringBuilder)localObject2).append(paramFileInfo.uint32_dead_time.get());
      TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", paramInt, ((StringBuilder)localObject2).toString());
      localObject2 = TroopFileTransferUtil.a(this.a.jdField_a_of_type_Long);
      if (localObject2 != null)
      {
        localObject1 = ((TroopFileManager)localObject2).a((String)localObject1);
        if (localObject1 != null)
        {
          ((TroopFileInfo)localObject1).a = paramFileInfo.uint32_bus_id.get();
          ((TroopFileInfo)localObject1).c = paramFileInfo.uint32_dead_time.get();
          ((TroopFileManager)localObject2).d((TroopFileInfo)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.2
 * JD-Core Version:    0.7.0.1
 */