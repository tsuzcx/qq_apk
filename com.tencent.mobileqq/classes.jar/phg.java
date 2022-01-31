import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class phg
  implements View.OnClickListener
{
  phg(pgw parampgw, pau parampau, Container paramContainer, ram paramram) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pau.a();
    ((ArticleInfo)localObject).click_area = 8;
    onh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    localObject = this.jdField_a_of_type_Ram.a();
    if (localObject != null) {
      ((rbr)localObject).a(paramView, this.jdField_a_of_type_Pau.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */