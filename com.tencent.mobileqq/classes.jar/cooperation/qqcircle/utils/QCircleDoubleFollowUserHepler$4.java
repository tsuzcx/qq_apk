package cooperation.qqcircle.utils;

import com.tencent.mobileqq.persistence.EntityManager;
import cooperation.qqcircle.beans.Friend;

class QCircleDoubleFollowUserHepler$4
  implements Runnable
{
  QCircleDoubleFollowUserHepler$4(QCircleDoubleFollowUserHepler paramQCircleDoubleFollowUserHepler, Friend paramFriend) {}
  
  public void run()
  {
    QCircleDoubleFollowUserHepler.access$300(this.this$0).persistOrReplace(this.val$friend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.4
 * JD-Core Version:    0.7.0.1
 */