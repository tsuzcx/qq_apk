import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qny
  implements View.OnClickListener
{
  public qny(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo, long paramLong, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu));
      sgc localsgc = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu).a();
      if (localsgc != null) {
        localsgc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, i, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu), this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qny
 * JD-Core Version:    0.7.0.1
 */