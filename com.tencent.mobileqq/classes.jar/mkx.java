import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

class mkx
  implements Runnable
{
  mkx(mks parammks) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a())
    {
      this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e(true);
      this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().g();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c())) {
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d(true);
    this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkx
 * JD-Core Version:    0.7.0.1
 */