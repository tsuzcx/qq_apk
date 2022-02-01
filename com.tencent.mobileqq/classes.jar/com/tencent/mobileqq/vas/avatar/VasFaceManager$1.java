package com.tencent.mobileqq.vas.avatar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFace from sd card: ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject).toString());
        this.this$0.a(this.b, this.a);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFace need download: ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject).toString());
      localObject = (IVasQuickUpdateService)this.this$0.b.getRuntimeService(IVasQuickUpdateService.class, "");
      if (localObject != null)
      {
        ((IVasQuickUpdateService)localObject).downloadItem(23L, this.b, "Q.qqhead.VasFaceManager");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFace failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.1
 * JD-Core Version:    0.7.0.1
 */