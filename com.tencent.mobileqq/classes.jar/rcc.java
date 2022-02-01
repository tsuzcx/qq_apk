import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rcc
  implements AdapterView.OnItemClickListener
{
  public rcc(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity(), 2131717300, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity().finish();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Intent localIntent = new Intent();
      Object localObject = paramAdapterView.getItemAtPosition(paramInt);
      if ((localObject != null) && ((localObject instanceof TagInfo)))
      {
        localIntent.putExtra("SEARCH_TAG_RESULT", (TagInfo)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoSearchTagFragment.getActivity().setResult(-1, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcc
 * JD-Core Version:    0.7.0.1
 */