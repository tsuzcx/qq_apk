package com.tencent.mobileqq.filemanager.bubble;

import aohk;
import aoig;
import apck;
import apdh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(aohk paramaohk, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    apck.d(this.a);
    if (apdh.b(this.a.strLargeThumPath)) {
      this.this$0.a.a().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */