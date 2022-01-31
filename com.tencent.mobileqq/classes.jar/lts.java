import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnGalleryImageClickListener;

public class lts
  implements View.OnClickListener
{
  public lts(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter == null) {}
    int i;
    ReadInJoyBaseAdapter.OnGalleryImageClickListener localOnGalleryImageClickListener;
    do
    {
      do
      {
        return;
        paramView = ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a();
      } while (paramView == null);
      i = ComponentContentGalleryBiu.a(paramView, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      localOnGalleryImageClickListener = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    } while (localOnGalleryImageClickListener == null);
    localOnGalleryImageClickListener.a(this.a.jdField_a_of_type_AndroidContentContext, paramView, 0, paramView.innerUniqueID, i, this.a.jdField_a_of_type_Int, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lts
 * JD-Core Version:    0.7.0.1
 */