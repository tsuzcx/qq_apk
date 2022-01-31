import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;

class qfd
  implements View.OnClickListener
{
  qfd(qfc paramqfc, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(qfc.a(this.jdField_a_of_type_Qfc), ReadInJoyDeliverUGCActivity.class);
    paramView.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    paramView.putExtra("is_from_kan_dian", true);
    paramView.putExtra("support_topic", true);
    if ((qfc.a(this.jdField_a_of_type_Qfc) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)qfc.a(this.jdField_a_of_type_Qfc)).startActivityForResult(paramView, 1000);
      }
      nol.a(null, "", "0X80096DF", "0X80096DF", 0, 0, qfc.a(this.jdField_a_of_type_Qfc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfd
 * JD-Core Version:    0.7.0.1
 */