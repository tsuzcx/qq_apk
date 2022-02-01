package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class QCircleFeedPicLoader$3
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramThreadPoolExecutor = new StringBuilder();
    paramThreadPoolExecutor.append("seq = ");
    paramThreadPoolExecutor.append(((RFWPicDownLoadTask)paramRunnable).getOption().getSeq());
    paramThreadPoolExecutor.append(" reject task");
    QLog.d("QCircleFeedPicLoader", 4, paramThreadPoolExecutor.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.3
 * JD-Core Version:    0.7.0.1
 */