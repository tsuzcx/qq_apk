import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lqm
  implements Runnable
{
  public lqm(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "notifyUIToRefresh channelId=" + this.jdField_a_of_type_Int + " ;size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_Int == 0) {
      ReadInJoyLogicEngineEventDispatcher.a().d(true, this.jdField_a_of_type_JavaUtilList);
    }
    while (this.jdField_a_of_type_Int != 56) {
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().e(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqm
 * JD-Core Version:    0.7.0.1
 */