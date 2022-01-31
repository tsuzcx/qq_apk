package com.tencent.mobileqq.filemanager.bubble;

import aqrg;
import aqsc;
import arni;
import arof;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(aqrg paramaqrg, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    arni.d(this.a);
    if (arof.b(this.a.strLargeThumPath)) {
      this.this$0.a.a().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */