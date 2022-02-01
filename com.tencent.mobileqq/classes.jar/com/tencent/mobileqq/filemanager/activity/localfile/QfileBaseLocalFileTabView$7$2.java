package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;

class QfileBaseLocalFileTabView$7$2
  implements Runnable
{
  QfileBaseLocalFileTabView$7$2(QfileBaseLocalFileTabView.7 param7, boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void run()
  {
    this.e.a.e();
    if (!this.a)
    {
      QQFileManagerUtil.a(this.b, this.c, this.d);
      ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(this.e.a.C, this.c);
      return;
    }
    QQFileManagerUtil.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2
 * JD-Core Version:    0.7.0.1
 */