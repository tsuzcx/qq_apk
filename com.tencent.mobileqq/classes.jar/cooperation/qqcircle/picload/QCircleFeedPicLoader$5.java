package cooperation.qqcircle.picload;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;

class QCircleFeedPicLoader$5
  implements Runnable
{
  QCircleFeedPicLoader$5(QCircleFeedPicLoader paramQCircleFeedPicLoader, Option paramOption, Drawable paramDrawable, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$option.isValid())
    {
      if (this.val$option.getTargetView() != null)
      {
        this.val$option.getTargetView().setImageDrawable(null);
        this.val$option.getTargetView().setImageDrawable(this.val$drawable);
      }
      if (this.val$report) {
        this.this$0.reportLoadResult(this.val$option, 0);
      }
      i = RFLog.USR;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(this.val$option.getSeq());
      localStringBuilder.append(" cacheKey = ");
      localStringBuilder.append(this.val$option.getCacheKey());
      localStringBuilder.append(" the total time ");
      localStringBuilder.append(System.currentTimeMillis() - this.val$option.mStartTime.longValue());
      localStringBuilder.append("pic is valid");
      RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
      return;
    }
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(this.val$option.getSeq());
    localStringBuilder.append(" cacheKey = ");
    localStringBuilder.append(this.val$option.getCacheKey());
    localStringBuilder.append(" the total time ");
    localStringBuilder.append(System.currentTimeMillis() - this.val$option.mStartTime.longValue());
    localStringBuilder.append("pic is unValid");
    RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.5
 * JD-Core Version:    0.7.0.1
 */