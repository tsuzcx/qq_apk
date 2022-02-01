package cooperation.qqcircle.picload;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedPicLoader$6
  implements Runnable
{
  QCircleFeedPicLoader$6(QCircleFeedPicLoader paramQCircleFeedPicLoader, Option paramOption, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.val$option.isValid())
    {
      if (this.val$option.getTargetView() != null)
      {
        this.val$option.getTargetView().setImageDrawable(null);
        this.val$option.getTargetView().setImageDrawable(this.val$drawable);
      }
      QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.val$option.getSeq() + " cacheKey = " + this.val$option.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - this.val$option.mStartTime.longValue()) + "pic is valid");
      return;
    }
    QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.val$option.getSeq() + " cacheKey = " + this.val$option.getCacheKey() + " showDrawable time " + (System.currentTimeMillis() - this.val$option.mStartTime.longValue()) + "pic is unValid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.6
 * JD-Core Version:    0.7.0.1
 */