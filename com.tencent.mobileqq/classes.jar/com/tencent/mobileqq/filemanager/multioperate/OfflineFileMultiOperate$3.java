package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$3
  implements FMDialogUtil.FMDialogInterface
{
  OfflineFileMultiOperate$3(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, FileManagerEngine paramFileManagerEngine, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a()
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.b.h(localFileManagerEntity);
      }
    }
    localObject = this.c;
    if (localObject != null) {
      ((QFileMultiOperateCallback)localObject).a(1, 0);
    }
  }
  
  public void b()
  {
    QFileMultiOperateCallback localQFileMultiOperateCallback = this.c;
    if (localQFileMultiOperateCallback != null) {
      localQFileMultiOperateCallback.a(1, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.3
 * JD-Core Version:    0.7.0.1
 */