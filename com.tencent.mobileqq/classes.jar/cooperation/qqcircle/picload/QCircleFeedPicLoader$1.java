package cooperation.qqcircle.picload;

import com.tencent.mobileqq.utils.FileUtils;

class QCircleFeedPicLoader$1
  implements Runnable
{
  QCircleFeedPicLoader$1(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    FileUtils.c(QCircleFeedPicLoader.DOWNLOAD_ROOT_PATH + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.1
 * JD-Core Version:    0.7.0.1
 */