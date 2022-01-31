package com.tencent.mobileqq.filemanager.bubble;

import aoyi;
import aoze;
import apug;
import apvd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(aoyi paramaoyi, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    apug.d(this.a);
    if (apvd.b(this.a.strLargeThumPath)) {
      this.this$0.a.a().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */