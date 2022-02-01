import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rgf
  implements View.OnClickListener
{
  public rgf(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgf
 * JD-Core Version:    0.7.0.1
 */