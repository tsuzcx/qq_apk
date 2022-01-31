package com.tencent.mobileqq.vas.avatar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VasFaceManager$1
  implements Runnable
{
  VasFaceManager$1(VasFaceManager paramVasFaceManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (new File(this.a).exists())
      {
        QLog.d("Q.qqhead.VasFaceManager", 1, "getFace from sd card: " + this.b);
        this.this$0.a(this.b, this.a);
        return;
      }
      QLog.d("Q.qqhead.VasFaceManager", 1, "getFace need download: " + this.b);
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.this$0.a.getManager(184);
      if (localVasQuickUpdateManager != null)
      {
        localVasQuickUpdateManager.downloadItem(23L, this.b, "Q.qqhead.VasFaceManager");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFace failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.1
 * JD-Core Version:    0.7.0.1
 */