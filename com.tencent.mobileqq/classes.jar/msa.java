import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAccountInfo;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendPublicAccountObserver;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class msa
  implements View.OnClickListener
{
  public msa(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.jdField_a_of_type_Long), "", "", "");
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo != null)
    {
      paramView = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.jdField_a_of_type_Int == 0)
    {
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, 2131434794, 0).b(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.a(2);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.jdField_a_of_type_Int = 2;
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((localMqqHandler != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
        localMqqHandler.sendEmptyMessage(1007);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, paramView, new SubscriptRecommendAdapter.RecommendPublicAccountObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem));
      return;
    }
    SubscriptRecommendAdapter.RecommendItem.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msa
 * JD-Core Version:    0.7.0.1
 */