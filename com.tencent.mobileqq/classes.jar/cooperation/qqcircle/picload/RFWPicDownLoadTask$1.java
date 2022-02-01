package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class RFWPicDownLoadTask$1
  extends RFWPicDownLoader.PicDownLoadListener
{
  RFWPicDownLoadTask$1(RFWPicDownLoadTask paramRFWPicDownLoadTask, Option paramOption, long paramLong)
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(this.mOption.getSeq());
      localStringBuilder.append(" cacheKey = ");
      localStringBuilder.append(this.mOption.getCacheKey());
      localStringBuilder.append(" download by ImageDownLoader success cost: ");
      localStringBuilder.append(System.currentTimeMillis() - this.val$time);
      localStringBuilder.append(" ifFromPreload:");
      localStringBuilder.append(this.mOption.isFromPreload());
      QLog.d("QCircleFeedPicLoader", 1, localStringBuilder.toString());
      RFWPicDownLoader.g().tryGetIp(this.mOption);
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
    RFWPicDownLoader.g().tryGetIp(this.mOption);
    this.this$0.reportDownloadResult(this.mOption, paramInt);
    QCircleFeedPicLoader.g().reportLoadResult(this.mOption, 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(this.mOption.getSeq());
    localStringBuilder.append(" cacheKey = ");
    localStringBuilder.append(this.mOption.getCacheKey());
    localStringBuilder.append(" download failed ");
    localStringBuilder.append(System.currentTimeMillis() - this.val$time);
    localStringBuilder.append(" ifFromPreload:");
    localStringBuilder.append(this.mOption.isFromPreload());
    QLog.d("QCircleFeedPicLoader", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWPicDownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */