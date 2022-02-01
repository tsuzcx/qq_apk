package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import java.util.Comparator;

final class QCircleFeedPicLoader$2
  implements Comparator<Runnable>
{
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof PicDownLoadTask)) && ((paramRunnable2 instanceof PicDownLoadTask))) {
      return ((PicDownLoadTask)paramRunnable1).getOption().getPriority() - ((PicDownLoadTask)paramRunnable2).getOption().getPriority();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.2
 * JD-Core Version:    0.7.0.1
 */