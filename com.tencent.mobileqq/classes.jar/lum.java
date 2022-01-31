import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeTopicRecommendGrid;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.OnNoItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnSubRegionClickListener;

public class lum
  implements ComponentContentGridImage.OnNoItemClickListener
{
  public lum(FeedItemCellTypeTopicRecommendGrid paramFeedItemCellTypeTopicRecommendGrid) {}
  
  public void a()
  {
    ReadInJoyBaseAdapter.OnSubRegionClickListener localOnSubRegionClickListener = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lum
 * JD-Core Version:    0.7.0.1
 */