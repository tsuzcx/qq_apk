import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class ovx
  implements View.OnClickListener
{
  public ovx(ReadInJoySelfFragment paramReadInJoySelfFragment, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.getActivity(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.getActivity().startActivity(paramView);
      noo.a(null, "CliOper", "", "", "0X80092FF", "0X80092FF", 0, 0, ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment, this.jdField_a_of_type_Int) + "", this.jdField_a_of_type_Int + "", "", onk.a(this.b), false);
      ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovx
 * JD-Core Version:    0.7.0.1
 */