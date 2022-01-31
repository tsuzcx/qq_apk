import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class mhx
  extends VideoShareListener
{
  public mhx(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3)
    {
      if (paramBoolean4) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
      }
    }
    else
    {
      if (paramBoolean1) {
        break label78;
      }
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, false);
    }
    for (;;)
    {
      if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, 0L);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
      break;
      label78:
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhx
 * JD-Core Version:    0.7.0.1
 */