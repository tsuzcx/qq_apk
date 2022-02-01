package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wifi.FreeWifiHelper.FreeWifiDialogListener;
import java.util.Iterator;
import java.util.List;

class OfflineFileMultiOperate$5
  implements FreeWifiHelper.FreeWifiDialogListener
{
  OfflineFileMultiOperate$5(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, FileManagerEngine paramFileManagerEngine, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 2)
    {
      FMToastUtil.d(OfflineFileMultiOperate.b(this.d).getString(2131889761));
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            this.b.a(localFileManagerEntity.getFilePath(), "", OfflineFileMultiOperate.a(this.d).getCurrentAccountUin(), 0, false);
          } else {
            this.b.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
      localObject = this.c;
      if (localObject != null) {
        ((QFileMultiOperateCallback)localObject).a(4, 0);
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((QFileMultiOperateCallback)localObject).a(4, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.5
 * JD-Core Version:    0.7.0.1
 */