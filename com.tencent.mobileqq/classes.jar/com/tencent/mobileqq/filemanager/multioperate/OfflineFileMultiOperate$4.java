package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.List;

class OfflineFileMultiOperate$4
  implements FMDialogUtil.FMDialogInterface
{
  OfflineFileMultiOperate$4(OfflineFileMultiOperate paramOfflineFileMultiOperate, List paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a()
  {
    FileManagerUtil.a(this.a, OfflineFileMultiOperate.b(this.c));
    QFileMultiOperateCallback localQFileMultiOperateCallback = this.b;
    if (localQFileMultiOperateCallback != null) {
      localQFileMultiOperateCallback.a(2, 0);
    }
  }
  
  public void b()
  {
    QFileMultiOperateCallback localQFileMultiOperateCallback = this.b;
    if (localQFileMultiOperateCallback != null) {
      localQFileMultiOperateCallback.a(2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.4
 * JD-Core Version:    0.7.0.1
 */