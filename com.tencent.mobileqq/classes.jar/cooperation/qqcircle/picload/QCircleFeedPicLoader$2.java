package cooperation.qqcircle.picload;

import java.util.Comparator;

final class QCircleFeedPicLoader$2
  implements Comparator<Runnable>
{
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof QCircleFeedPicLoader.PicDownLoadTask)) && ((paramRunnable2 instanceof QCircleFeedPicLoader.PicDownLoadTask))) {
      return ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable1).getOption().getPriority() - ((QCircleFeedPicLoader.PicDownLoadTask)paramRunnable2).getOption().getPriority();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.2
 * JD-Core Version:    0.7.0.1
 */