import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;

class pti
  implements View.OnClickListener
{
  pti(pth parampth, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(pth.a(this.jdField_a_of_type_Pth), ReadInJoyDeliverUGCActivity.class);
    paramView.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    paramView.putExtra("is_from_kan_dian", true);
    paramView.putExtra("support_topic", true);
    if ((pth.a(this.jdField_a_of_type_Pth) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)pth.a(this.jdField_a_of_type_Pth)).startActivityForResult(paramView, 1000);
      }
      ndn.a(null, "", "0X80096DF", "0X80096DF", 0, 0, pth.a(this.jdField_a_of_type_Pth, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pti
 * JD-Core Version:    0.7.0.1
 */