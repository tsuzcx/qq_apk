import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;

class pnr
  implements View.OnClickListener
{
  pnr(pnh parampnh, pgd parampgd, Container paramContainer, rqj paramrqj) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Pgd.a();
    ((ArticleInfo)localObject).click_area = 8;
    ors.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    QLog.d("PgcShortContentProteusItem", 1, "click single image blank area");
    localObject = this.jdField_a_of_type_Rqj.a();
    if (localObject != null) {
      ((rro)localObject).a(paramView, this.jdField_a_of_type_Pgd.a(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnr
 * JD-Core Version:    0.7.0.1
 */