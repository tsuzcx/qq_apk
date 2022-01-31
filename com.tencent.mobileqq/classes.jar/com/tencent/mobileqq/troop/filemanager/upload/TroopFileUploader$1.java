package com.tencent.mobileqq.troop.filemanager.upload;

import bbxy;

public class TroopFileUploader$1
  implements Runnable
{
  public TroopFileUploader$1(bbxy parambbxy) {}
  
  public void run()
  {
    if ((bbxy.a(this.this$0) != null) && (this.this$0.a != null)) {
      this.this$0.a();
    }
    this.this$0.a(true, bbxy.a(this.this$0), 9303, "readfilefail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.1
 * JD-Core Version:    0.7.0.1
 */