import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackJumpInfo;

public class lsb
  implements View.OnClickListener
{
  public lsb(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, oidb_cmd0x68b.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_TencentImOidbCmd0x68bOidb_cmd0x68b$PackJumpInfo.str_url.get();
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), paramView);
    ReadInJoyFooterPresenter.a(2, this.jdField_a_of_type_TencentImOidbCmd0x68bOidb_cmd0x68b$PackJumpInfo.str_wording.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsb
 * JD-Core Version:    0.7.0.1
 */