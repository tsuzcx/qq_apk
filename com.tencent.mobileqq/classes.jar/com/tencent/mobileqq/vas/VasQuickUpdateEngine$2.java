package com.tencent.mobileqq.vas;

import com.tencent.qphone.base.util.QLog;

class VasQuickUpdateEngine$2
  implements Runnable
{
  VasQuickUpdateEngine$2(VasQuickUpdateEngine paramVasQuickUpdateEngine, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {}
  
  public void run()
  {
    if (this.this$0.mUpdateManagerInstance != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasQuickUpdateEngine", 2, "onPreloadDownloadStart + itemId = " + this.val$itemId + " url= " + this.val$url + " savePath = " + this.val$savePath + " fileSize = " + this.val$fileSize + " from = " + this.val$from);
      }
      this.this$0.nativeStartPreloadDownload(this.this$0.mUpdateManagerInstance, this.val$itemId, this.val$url, this.val$savePath, this.val$fileSize, this.val$from);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.2
 * JD-Core Version:    0.7.0.1
 */