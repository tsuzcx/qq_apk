import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class msu
  implements Runnable
{
  public msu(SubscriptFeedsActivity paramSubscriptFeedsActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.rightViewText.getLocationInWindow(arrayOfInt);
      int i = this.jdField_a_of_type_Int;
      int j = arrayOfInt[0];
      int k = this.b;
      int m = AIOUtils.a(2.0F, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.getResources());
      SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity).showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.rightViewText, i - j - k - m, -AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.getResources()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msu
 * JD-Core Version:    0.7.0.1
 */