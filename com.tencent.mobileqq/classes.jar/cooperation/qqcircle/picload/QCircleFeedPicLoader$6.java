package cooperation.qqcircle.picload;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class QCircleFeedPicLoader$6
  implements Runnable
{
  QCircleFeedPicLoader$6(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    Iterator localIterator = QCircleFeedPicLoader.access$100(this.this$0).keySet().iterator();
    String str;
    RFWPicDownLoadTask localRFWPicDownLoadTask;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localRFWPicDownLoadTask = (RFWPicDownLoadTask)QCircleFeedPicLoader.access$100(this.this$0).get(str);
      if (localRFWPicDownLoadTask != null) {
        localRFWPicDownLoadTask.cancel();
      }
      QCircleFeedPicLoader.access$100(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.access$200(this.this$0).getQueue().clear();
    localIterator = QCircleFeedPicLoader.access$300(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localRFWPicDownLoadTask = (RFWPicDownLoadTask)QCircleFeedPicLoader.access$300(this.this$0).get(str);
      if (localRFWPicDownLoadTask != null) {
        localRFWPicDownLoadTask.cancel();
      }
      QCircleFeedPicLoader.access$300(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.access$400(this.this$0).getQueue().clear();
    QCircleFeedPicLoader.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.6
 * JD-Core Version:    0.7.0.1
 */