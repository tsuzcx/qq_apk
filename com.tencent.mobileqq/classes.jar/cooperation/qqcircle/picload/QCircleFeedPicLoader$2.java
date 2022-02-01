package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import java.util.Comparator;

final class QCircleFeedPicLoader$2
  implements Comparator<Runnable>
{
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof RFWPicDownLoadTask)) && ((paramRunnable2 instanceof RFWPicDownLoadTask))) {
      return ((RFWPicDownLoadTask)paramRunnable1).getOption().getPriority() - ((RFWPicDownLoadTask)paramRunnable2).getOption().getPriority();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.2
 * JD-Core Version:    0.7.0.1
 */