import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;

class qpj
  implements View.OnClickListener
{
  qpj(qpi paramqpi, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(qpi.a(this.jdField_a_of_type_Qpi), ReadInJoyDeliverUGCActivity.class);
    paramView.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    paramView.putExtra("is_from_kan_dian", true);
    paramView.putExtra("support_topic", true);
    if ((qpi.a(this.jdField_a_of_type_Qpi) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)qpi.a(this.jdField_a_of_type_Qpi)).startActivityForResult(paramView, 1000);
      }
      nrt.a(null, "", "0X80096DF", "0X80096DF", 0, 0, qpi.a(this.jdField_a_of_type_Qpi, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpj
 * JD-Core Version:    0.7.0.1
 */