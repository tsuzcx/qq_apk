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
    RFLog.d("QCircleFeedPicLoader", RFLog.DEV, "seq = " + ((PicDownLoadTask)paramRunnable).getOption().getSeq() + " reject task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.3
 * JD-Core Version:    0.7.0.1
 */