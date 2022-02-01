package cooperation.qqcircle.picload;

import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class QCircleFeedPicLoader$PicDownLoadTask
  implements Runnable
{
  protected QCircleFeedPicLoader.QCirclePicStateListener mListener;
  protected Option mOption;
  protected volatile int mStatus;
  
  public QCircleFeedPicLoader$PicDownLoadTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, @NotNull Option paramOption)
  {
    this.mOption = paramOption;
    this.mStatus = QCircleFeedPicLoader.STATE_PREPARE;
  }
  
  public void cancel()
  {
    if (this.mStatus != QCircleFeedPicLoader.STATE_SUCCESS)
    {
      this.mStatus = QCircleFeedPicLoader.STATE_CANCEL;
      if (this.mListener != null) {
        this.mListener.onStateChang(QCircleFeedPicLoader.STATE_CANCEL, this.mOption);
      }
    }
  }
  
  public Option getOption()
  {
    return this.mOption;
  }
  
  public void run()
  {
    if (this.mStatus == QCircleFeedPicLoader.STATE_CANCEL) {
      return;
    }
    long l = System.currentTimeMillis();
    QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download start cost in queue: " + (l - this.mOption.mDownLoadStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
    if (FileUtil.isFileExists(this.this$0.getPicLocalPath(this.mOption)))
    {
      if (this.mOption.isPreDecode()) {
        QCircleFeedPicLoader.access$200(this.this$0, this.mOption, this.mListener);
      }
      QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " return in downLoad file exist " + (l - this.mOption.mDownLoadStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
      return;
    }
    this.mStatus = QCircleFeedPicLoader.STATE_DOWNING;
    if (this.mListener != null) {
      this.mListener.onStateChang(this.mStatus, this.mOption);
    }
    QCirclePicDownLoader.g().downLoad(this.mOption, new QCircleFeedPicLoader.PicDownLoadTask.1(this, this.mOption, l));
  }
  
  public void setStatusListener(QCircleFeedPicLoader.QCirclePicStateListener paramQCirclePicStateListener)
  {
    this.mListener = paramQCirclePicStateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask
 * JD-Core Version:    0.7.0.1
 */