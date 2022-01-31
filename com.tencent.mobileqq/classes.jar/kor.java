import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kor
  implements ActionSheet.OnButtonClickListener
{
  public kor(EqqAccountDetailActivity paramEqqAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramInt + 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    } while ((!((EcShopAssistantManager)EqqAccountDetailActivity.o(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity).getManager(87)).a(EqqAccountDetailActivity.n(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity))) || (this.jdField_a_of_type_Int == paramInt));
    ((EcshopReportHandler)EqqAccountDetailActivity.p(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity).a(88)).a(134243867, EqqAccountDetailActivity.o(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), null, null, null, paramInt + 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kor
 * JD-Core Version:    0.7.0.1
 */