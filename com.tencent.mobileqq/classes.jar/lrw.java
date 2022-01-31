import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class lrw
  implements Runnable
{
  public lrw(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString, Context paramContext) {}
  
  public void run()
  {
    TroopBarAssistantManager.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_AndroidContentContext, SubscriptionInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule));
    int i = PublicAccountUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_JavaLangString);
    RecentUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a).a().c(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */