package cooperation.qzone;

import blue;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;

class QzoneIPCModule$RetryRequestFeed
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  blue jdField_a_of_type_Blue;
  QCircleFakeFeed jdField_a_of_type_ComTencentBizQqcircleBeansQCircleFakeFeed;
  
  public QzoneIPCModule$RetryRequestFeed(QzoneIPCModule paramQzoneIPCModule, QCircleFakeFeed paramQCircleFakeFeed, int paramInt, blue paramblue)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleBeansQCircleFakeFeed = paramQCircleFakeFeed;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Blue = paramblue;
  }
  
  public void run()
  {
    QzoneIPCModule.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqcircleBeansQCircleFakeFeed, this.jdField_a_of_type_Int, this.jdField_a_of_type_Blue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.RetryRequestFeed
 * JD-Core Version:    0.7.0.1
 */