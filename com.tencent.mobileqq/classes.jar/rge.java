import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGallery;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rge
  implements View.OnClickListener
{
  public rge(ComponentContentGallery paramComponentContentGallery, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGallery.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGallery) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pnt localpnt = ComponentContentGallery.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGallery).a().a();
      if (localpnt != null) {
        localpnt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGallery.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 1, ComponentContentGallery.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGallery), this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rge
 * JD-Core Version:    0.7.0.1
 */