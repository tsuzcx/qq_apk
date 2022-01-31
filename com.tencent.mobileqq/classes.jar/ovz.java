import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class ovz
  implements View.OnClickListener
{
  ovz(ovx paramovx, opw paramopw, Container paramContainer, qoe paramqoe) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Opw.a();
    ((ArticleInfo)localObject).click_area = 8;
    obz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    localObject = this.jdField_a_of_type_Qoe.a();
    if (localObject != null) {
      ((qpj)localObject).a(paramView, this.jdField_a_of_type_Opw.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovz
 * JD-Core Version:    0.7.0.1
 */