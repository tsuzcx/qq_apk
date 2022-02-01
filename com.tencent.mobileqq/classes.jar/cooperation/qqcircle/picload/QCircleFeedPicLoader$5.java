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
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.val$option.getSeq() + " cacheKey = " + this.val$option.getCacheKey() + " the total time " + (System.currentTimeMillis() - this.val$option.mStartTime.longValue()) + "pic is valid");
      return;
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.val$option.getSeq() + " cacheKey = " + this.val$option.getCacheKey() + " the total time " + (System.currentTimeMillis() - this.val$option.mStartTime.longValue()) + "pic is unValid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.5
 * JD-Core Version:    0.7.0.1
 */