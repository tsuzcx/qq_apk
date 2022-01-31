import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class kpq
  implements Runnable
{
  public kpq(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailInSubThread");
    }
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpq
 * JD-Core Version:    0.7.0.1
 */