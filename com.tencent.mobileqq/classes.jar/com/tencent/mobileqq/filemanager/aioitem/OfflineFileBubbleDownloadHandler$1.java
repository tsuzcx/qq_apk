package com.tencent.mobileqq.filemanager.aioitem;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class OfflineFileBubbleDownloadHandler$1
  implements FMDialogUtil.FMDialogInterface
{
  OfflineFileBubbleDownloadHandler$1(OfflineFileBubbleDownloadHandler paramOfflineFileBubbleDownloadHandler, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if ((this.a.status != 3) && (this.a.status != 0))
    {
      if (this.a.getCloudType() == 0)
      {
        this.b.b.getOnlineFileSessionCenter().b(this.a.nSessionId);
        return;
      }
      this.b.b.getFileManagerEngine().h(this.a);
      return;
    }
    if (this.a.getCloudType() == 0)
    {
      this.b.b.getOnlineFileSessionCenter().d(this.a.nSessionId);
      return;
    }
    this.b.b.getFileManagerEngine().b(this.a.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubbleDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */