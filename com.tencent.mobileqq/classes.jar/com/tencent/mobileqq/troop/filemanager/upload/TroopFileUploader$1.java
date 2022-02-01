package com.tencent.mobileqq.troop.filemanager.upload;

import beho;

public class TroopFileUploader$1
  implements Runnable
{
  public TroopFileUploader$1(beho parambeho) {}
  
  public void run()
  {
    if ((beho.a(this.this$0) != null) && (this.this$0.a != null)) {
      this.this$0.a();
    }
    this.this$0.a(true, beho.a(this.this$0), 9303, "readfilefail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.1
 * JD-Core Version:    0.7.0.1
 */