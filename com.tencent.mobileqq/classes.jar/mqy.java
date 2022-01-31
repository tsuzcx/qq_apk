import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Iterator;
import java.util.List;

public class mqy
  implements ActionSheet.OnButtonClickListener
{
  public mqy(SubscriptFeedsActivity paramSubscriptFeedsActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    TroopBarAssistantManager.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity, null);
    paramInt = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString);
    RecentUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app.a().c(this.jdField_a_of_type_JavaLangString, 1008);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
    paramView = SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity).iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)paramView.next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)));
    for (paramInt = localSubscriptionFeed.b;; paramInt = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80064CF", "0X80064CF", 0, 0, "" + paramInt, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */