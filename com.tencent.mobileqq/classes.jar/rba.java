import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rba
  implements View.OnClickListener
{
  rba(raz paramraz, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(raz.a(this.jdField_a_of_type_Raz), ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    if ((raz.a(this.jdField_a_of_type_Raz) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)raz.a(this.jdField_a_of_type_Raz)).startActivityForResult(localIntent, 1000);
      }
      ocd.a(null, "", "0X80096DF", "0X80096DF", 0, 0, raz.a(this.jdField_a_of_type_Raz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */