package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class QCircleFeedPicLoader$3
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    int i = RFLog.DEV;
    paramThreadPoolExecutor = new StringBuilder();
    paramThreadPoolExecutor.append("seq = ");
    paramThreadPoolExecutor.append(((PicDownLoadTask)paramRunnable).getOption().getSeq());
    paramThreadPoolExecutor.append(" reject task");
    RFLog.d("QCircleFeedPicLoader", i, paramThreadPoolExecutor.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.3
 * JD-Core Version:    0.7.0.1
 */