package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;

class PicDownLoadTask$1
  extends QCirclePicDownLoader.PicDownLoadListener
{
  PicDownLoadTask$1(PicDownLoadTask paramPicDownLoadTask, Option paramOption, long paramLong)
  {
    super(paramOption);
  }
  
  public void onResult(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QCircleFeedPicLoader.g().removeDownLoadTask(this.mOption.getCacheKey());
      if (this.mOption.isPreDecode()) {
        QCircleFeedPicLoader.g().decodeFile(this.mOption, this.this$0.mListener);
      }
      RFLog.d("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download by ImageDownLoader success cost: " + (System.currentTimeMillis() - this.val$time) + " ifFromPreload:" + this.mOption.isFromPreload());
      QCirclePicDownLoader.g().tryGetIp(this.mOption);
      if (this.this$0.mListener != null) {
        this.this$0.mListener.onStateChang(3, this.mOption);
      }
      this.this$0.reportDownloadResult(this.mOption, 0);
      return;
    }
    QCircleFeedPicLoader.g().removeDownLoadTask(this.mOption.getCacheKey());
    QCircleFeedPicLoader.g().showDrawable(this.mOption, this.mOption.getFailDrawable());
    if (this.this$0.mListener != null) {
      this.this$0.mListener.onStateChang(7, this.mOption);
    }
    QCirclePicDownLoader.g().tryGetIp(this.mOption);
    this.this$0.reportDownloadResult(this.mOption, paramInt);
    QCircleFeedPicLoader.g().reportLoadResult(this.mOption, 1);
    RFLog.d("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download failed " + (System.currentTimeMillis() - this.val$time) + " ifFromPreload:" + this.mOption.isFromPreload());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */