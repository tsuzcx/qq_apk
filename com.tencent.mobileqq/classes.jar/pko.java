import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pko
  implements View.OnClickListener
{
  public pko(ReadInJoySelfFragment paramReadInJoySelfFragment, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.getActivity().startActivity(localIntent);
      ocd.a(null, "CliOper", "", "", "0X80092FF", "0X80092FF", 0, 0, ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment, this.jdField_a_of_type_Int) + "", this.jdField_a_of_type_Int + "", "", ozs.b(this.b), false);
      ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pko
 * JD-Core Version:    0.7.0.1
 */