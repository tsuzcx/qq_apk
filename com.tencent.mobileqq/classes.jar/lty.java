import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePgcGridSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.OnNoItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnSubRegionClickListener;

public class lty
  implements ComponentContentGridImage.OnNoItemClickListener
{
  public lty(FeedItemCellTypePgcGridSocial paramFeedItemCellTypePgcGridSocial) {}
  
  public void a()
  {
    ReadInJoyBaseAdapter.OnSubRegionClickListener localOnSubRegionClickListener = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lty
 * JD-Core Version:    0.7.0.1
 */