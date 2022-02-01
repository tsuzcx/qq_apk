package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import dov.com.qq.im.ae.util.AEQLog;

class AEOldResManager$9
  extends RunnableTask
{
  AEOldResManager$9(AEOldResManager paramAEOldResManager, QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString, paramRunnable, paramLong);
  }
  
  public void realCancel()
  {
    AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResManager.9
 * JD-Core Version:    0.7.0.1
 */