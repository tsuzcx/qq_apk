package cooperation.qqcircle.picload;

import com.tencent.mobileqq.utils.FileUtils;

class QCircleFeedPicLoader$1
  implements Runnable
{
  QCircleFeedPicLoader$1(QCircleFeedPicLoader paramQCircleFeedPicLoader) {}
  
  public void run()
  {
    FileUtils.createFileIfNotExits(QCircleFeedPicLoader.access$000() + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.1
 * JD-Core Version:    0.7.0.1
 */