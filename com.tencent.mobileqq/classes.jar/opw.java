import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class opw
  implements View.OnClickListener
{
  public opw(MinusViewBotomView paramMinusViewBotomView, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    oph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext(), "jumpPreview", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, "fypbtn");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext() instanceof ChatActivity)) {
      ((ChatActivity)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewMinusViewBotomView.getContext()).finish();
    }
    opk.a(null, "gouwu_fypbtn_click", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    opk.b(null, "gouwu_fypbtn_click", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opw
 * JD-Core Version:    0.7.0.1
 */