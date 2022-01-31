import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;

public class mxh
  implements Runnable
{
  public mxh(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Boolean = SubscriptRecommendController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.a.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */