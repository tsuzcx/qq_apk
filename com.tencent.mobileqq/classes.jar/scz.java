import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class scz
  implements View.OnClickListener
{
  scz(scu paramscu) {}
  
  public void onClick(View paramView)
  {
    axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005733", "0X8005733", 0, 0, "", "", "", "");
    axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006430", "0X8006430", 0, 0, "", "", "", "");
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.6.1(this));
    if (this.a.jdField_a_of_type_Int == 1) {
      scu.a(this.a);
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_Int != 3);
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
    } while ((paramView == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (!(this.a.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof SubscriptFeedsActivity)));
    paramView.sendEmptyMessage(1006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     scz
 * JD-Core Version:    0.7.0.1
 */