package cooperation.qqcircle.utils;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.persistence.EntityManager;
import cooperation.qqcircle.beans.Friend;

class QCircleDoubleFollowUserHepler$3
  implements Runnable
{
  QCircleDoubleFollowUserHepler$3(QCircleDoubleFollowUserHepler paramQCircleDoubleFollowUserHepler, String paramString) {}
  
  public void run()
  {
    int i = QCircleDoubleFollowUserHepler.access$300(this.this$0).delete(Friend.class.getSimpleName(), "mUin=? ", new String[] { this.val$uin });
    if (RFLog.isColorLevel()) {
      RFLog.i("QCircleDoubleFollowUserHepler", RFLog.CLR, "updateFollowUser remove count:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.3
 * JD-Core Version:    0.7.0.1
 */