package com.tencent.mobileqq.mini.share;

import android.text.TextUtils;
import bbdj;
import com.tencent.qphone.base.util.QLog;

final class MiniArkShareAsyncManager$2
  implements Runnable
{
  MiniArkShareAsyncManager$2(String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$filePath)) && (bbdj.d(this.val$filePath))) {
      QLog.d("MiniArkShareAsyncManage", 2, "removeArkShareLocalTemporaryFile() called with: filePath = [" + this.val$filePath + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.2
 * JD-Core Version:    0.7.0.1
 */