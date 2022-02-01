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
      paramInt = RFLog.USR;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(this.mOption.getSeq());
      localStringBuilder.append(" cacheKey = ");
      localStringBuilder.append(this.mOption.getCacheKey());
      localStringBuilder.append(" download by ImageDownLoader success cost: ");
      localStringBuilder.append(System.currentTimeMillis() - this.val$time);
      localStringBuilder.append(" ifFromPreload:");
      localStringBuilder.append(this.mOption.isFromPreload());
      RFLog.d("QCircleFeedPicLoader", paramInt, localStringBuilder.toString());
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
    paramInt = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(this.mOption.getSeq());
    localStringBuilder.append(" cacheKey = ");
    localStringBuilder.append(this.mOption.getCacheKey());
    localStringBuilder.append(" download failed ");
    localStringBuilder.append(System.currentTimeMillis() - this.val$time);
    localStringBuilder.append(" ifFromPreload:");
    localStringBuilder.append(this.mOption.isFromPreload());
    RFLog.d("QCircleFeedPicLoader", paramInt, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */