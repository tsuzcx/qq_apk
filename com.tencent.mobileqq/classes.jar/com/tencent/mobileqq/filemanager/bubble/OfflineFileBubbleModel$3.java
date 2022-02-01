package com.tencent.mobileqq.filemanager.bubble;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class OfflineFileBubbleModel$3
  implements Runnable
{
  OfflineFileBubbleModel$3(OfflineFileBubbleModel paramOfflineFileBubbleModel, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    FileManagerUtil.c(this.a);
    if (FileUtil.b(this.a.strLargeThumPath)) {
      this.this$0.a.getFileManagerDataCenter().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */