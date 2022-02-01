package cooperation.qqcircle.picload;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class QCircleFeedPicLoader$7
  implements Runnable
{
  QCircleFeedPicLoader$7(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    Iterator localIterator = QCircleFeedPicLoader.access$400(this.this$0).keySet().iterator();
    String str;
    QCircleFeedPicLoader.PicDownLoadTask localPicDownLoadTask;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.access$400(this.this$0).get(str);
      if (localPicDownLoadTask != null) {
        localPicDownLoadTask.cancel();
      }
      QCircleFeedPicLoader.access$400(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.access$700(this.this$0).getQueue().clear();
    localIterator = QCircleFeedPicLoader.access$800(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localPicDownLoadTask = (QCircleFeedPicLoader.PicDownLoadTask)QCircleFeedPicLoader.access$800(this.this$0).get(str);
      if (localPicDownLoadTask != null) {
        localPicDownLoadTask.cancel();
      }
      QCircleFeedPicLoader.access$800(this.this$0).remove(str);
    }
    QCircleFeedPicLoader.access$900(this.this$0).getQueue().clear();
    QCircleFeedPicLoader.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.7
 * JD-Core Version:    0.7.0.1
 */