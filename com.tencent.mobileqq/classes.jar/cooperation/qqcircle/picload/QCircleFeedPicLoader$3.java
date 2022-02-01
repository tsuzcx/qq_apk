package cooperation.qqcircle.picload;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class QCircleFeedPicLoader$3
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.d(QCircleFeedPicLoader.TAG, 4, "seq = " + ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable).getOption().getSeq() + " reject task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.3
 * JD-Core Version:    0.7.0.1
 */