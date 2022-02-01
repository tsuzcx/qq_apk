package com.tencent.mobileqq.secspy;

import android.os.Handler;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

class SecSpyFileManager$3
  implements Runnable
{
  SecSpyFileManager$3(SecSpyFileManager paramSecSpyFileManager, SecSpyFileManager.UploadProgressInfo paramUploadProgressInfo, long paramLong) {}
  
  public void run()
  {
    if (SecSpyFileManager.UploadProgressInfo.a(this.a)) {
      return;
    }
    float f = SecSpyFileManager.UploadProgressInfo.b(this.a) / SecSpyFileManager.UploadProgressInfo.c(this.a);
    this.this$0.a(this.b, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.e.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */