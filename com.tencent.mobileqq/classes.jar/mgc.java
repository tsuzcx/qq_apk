import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

class mgc
  implements Runnable
{
  mgc(mga parammga) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if ((!this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()) && (!this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c())) {
      ReadInJoyBaseAdapter.a(this.a.a, this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgc
 * JD-Core Version:    0.7.0.1
 */