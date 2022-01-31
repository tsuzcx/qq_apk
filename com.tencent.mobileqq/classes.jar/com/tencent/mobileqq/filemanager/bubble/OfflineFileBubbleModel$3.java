package com.tencent.mobileqq.filemanager.bubble;

import aoye;
import aoza;
import apue;
import apvb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(aoye paramaoye, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    apue.d(this.a);
    if (apvb.b(this.a.strLargeThumPath)) {
      this.this$0.a.a().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */