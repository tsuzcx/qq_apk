import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import com.tencent.mobileqq.widget.QQToast;

public class qql
  implements AdapterView.OnItemClickListener
{
  public qql(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity(), 2131719042, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity().finish();
      return;
      paramView = new Intent();
      paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
      if ((paramAdapterView != null) && ((paramAdapterView instanceof TagInfo)))
      {
        paramView.putExtra("SEARCH_TAG_RESULT", (TagInfo)paramAdapterView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity().setResult(-1, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qql
 * JD-Core Version:    0.7.0.1
 */