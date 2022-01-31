import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionHandler.ReqDiscussInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class shp
  implements Runnable
{
  public shp(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).a(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity));
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localArrayList);
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      DiscussionHandler.ReqDiscussInfo localReqDiscussInfo = new DiscussionHandler.ReqDiscussInfo();
      localReqDiscussInfo.a = String.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity));
      localReqDiscussInfo.b = localArrayList.size();
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).a(localReqDiscussInfo);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shp
 * JD-Core Version:    0.7.0.1
 */