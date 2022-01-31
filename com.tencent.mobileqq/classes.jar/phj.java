import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class phj
  implements View.OnClickListener
{
  phj(pgz parampgz, pax parampax, Container paramContainer, rap paramrap) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pax.a();
    ((ArticleInfo)localObject).click_area = 8;
    onk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    localObject = this.jdField_a_of_type_Rap.a();
    if (localObject != null) {
      ((rbu)localObject).a(paramView, this.jdField_a_of_type_Pax.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phj
 * JD-Core Version:    0.7.0.1
 */