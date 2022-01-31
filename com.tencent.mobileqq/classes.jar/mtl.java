import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptObserver;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class mtl
  extends SubscriptObserver
{
  public mtl(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptObserver", 2, "onGetRecommendList isSuccess: " + paramBoolean + " | data: " + paramList + " | isShowRecommend: " + this.a.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean))
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        break label145;
      }
      this.a.a(paramList);
      paramList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((paramList != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.a.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof SubscriptFeedsActivity))) {
        paramList.sendEmptyMessage(1004);
      }
    }
    label145:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptObserver", 2, "onGetRecommendList data is null or empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtl
 * JD-Core Version:    0.7.0.1
 */