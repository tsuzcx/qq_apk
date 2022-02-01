package cooperation.qqcircle.picload;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class QCircleFeedPicLoader$PicDownLoadTask$1
  extends QCirclePicDownLoader.PicDownLoadListener
{
  QCircleFeedPicLoader$PicDownLoadTask$1(QCircleFeedPicLoader.PicDownLoadTask paramPicDownLoadTask, Option paramOption, long paramLong)
  {
    super(paramOption);
  }
  
  public void onResult(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QCircleFeedPicLoader.access$400(this.this$1.this$0).remove(this.mOption.getCacheKey());
      if (this.mOption.isPreDecode()) {
        QCircleFeedPicLoader.access$200(this.this$1.this$0, this.mOption, this.this$1.mListener);
      }
      QLog.d(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download by ImageDownLoader success cost: " + (System.currentTimeMillis() - this.val$time) + " ifFromPreload:" + this.mOption.isFromPreload());
      QCirclePicDownLoader.g().tryGetIp(this.mOption);
      if (this.this$1.mListener != null) {
        this.this$1.mListener.onStateChang(QCircleFeedPicLoader.STATE_DOWNLOAD_SUCCESS, this.mOption);
      }
      QCircleFeedPicLoader.access$500(this.this$1.this$0, this.mOption, 0);
      return;
    }
    QCircleFeedPicLoader.access$400(this.this$1.this$0).remove(this.mOption.getCacheKey());
    QCircleFeedPicLoader.access$100(this.this$1.this$0, this.mOption, this.mOption.getFailDrawable());
    if (this.this$1.mListener != null) {
      this.this$1.mListener.onStateChang(QCircleFeedPicLoader.STATE_DOWN_FAILED, this.mOption);
    }
    QCirclePicDownLoader.g().tryGetIp(this.mOption);
    QCircleFeedPicLoader.access$500(this.this$1.this$0, this.mOption, paramInt);
    QCircleFeedPicLoader.access$600(this.this$1.this$0, this.mOption, 1);
    QLog.d(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download failed " + (System.currentTimeMillis() - this.val$time) + " ifFromPreload:" + this.mOption.isFromPreload());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */