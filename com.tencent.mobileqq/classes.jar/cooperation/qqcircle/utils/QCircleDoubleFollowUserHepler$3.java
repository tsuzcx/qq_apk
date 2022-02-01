package cooperation.qqcircle.utils;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.Friend;

class QCircleDoubleFollowUserHepler$3
  implements Runnable
{
  QCircleDoubleFollowUserHepler$3(QCircleDoubleFollowUserHepler paramQCircleDoubleFollowUserHepler, String paramString) {}
  
  public void run()
  {
    int i = QCircleDoubleFollowUserHepler.access$300(this.this$0).delete(Friend.class.getSimpleName(), "mUin=? ", new String[] { this.val$uin });
    if (QLog.isColorLevel()) {
      QLog.i("QCircleDoubleFollowUserHepler", 2, "updateFollowUser remove count:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.3
 * JD-Core Version:    0.7.0.1
 */