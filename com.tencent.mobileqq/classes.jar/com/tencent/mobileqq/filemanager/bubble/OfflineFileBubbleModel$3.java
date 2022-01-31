package com.tencent.mobileqq.filemanager.bubble;

import aqvp;
import aqwl;
import arrr;
import arso;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(aqvp paramaqvp, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    arrr.d(this.a);
    if (arso.b(this.a.strLargeThumPath)) {
      this.this$0.a.a().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */