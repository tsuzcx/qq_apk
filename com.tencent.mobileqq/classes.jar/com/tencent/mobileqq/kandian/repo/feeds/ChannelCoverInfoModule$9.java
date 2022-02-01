package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChannelCoverInfoModule$9
  implements Runnable
{
  ChannelCoverInfoModule$9(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyUIToRefresh channelId=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" ;size = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      ReadInJoyLogicEngineEventDispatcher.a().f(true, this.jdField_a_of_type_JavaUtilList);
    } else if (i == 56) {
      ReadInJoyLogicEngineEventDispatcher.a().g(true, this.jdField_a_of_type_JavaUtilList);
    } else if (i == 41402) {
      ReadInJoyLogicEngineEventDispatcher.a().h(true, this.jdField_a_of_type_JavaUtilList);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.9
 * JD-Core Version:    0.7.0.1
 */