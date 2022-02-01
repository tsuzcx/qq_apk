package dov.com.qq.im.ae.download;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import dov.com.qq.im.ae.util.AEQLog;

class AEResManager$5
  extends RunnableTask
{
  AEResManager$5(AEResManager paramAEResManager, QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString, paramRunnable, paramLong);
  }
  
  public void realCancel()
  {
    AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.5
 * JD-Core Version:    0.7.0.1
 */