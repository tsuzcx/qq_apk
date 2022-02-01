package com.tencent.mobileqq.filemanager.bubble;

import atki;
import atlf;
import auea;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(atki paramatki, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    auea.c(this.a);
    if (FileUtil.fileExistsAndNotEmpty(this.a.strLargeThumPath)) {
      this.this$0.a.getFileManagerDataCenter().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */