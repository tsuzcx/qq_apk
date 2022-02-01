import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pxv
  implements View.OnClickListener
{
  pxv(pxl parampxl, ppu paramppu, Container paramContainer, sel paramsel) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Ppu.a();
    ((ArticleInfo)localObject).clickArea = 8;
    ozs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), (ArticleInfo)localObject, (int)((ArticleInfo)localObject).mChannelID);
    QLog.d("PgcShortContentProteusItem", 1, "click single image blank area");
    localObject = this.jdField_a_of_type_Sel.a();
    if (localObject != null) {
      ((sgf)localObject).a(paramView, this.jdField_a_of_type_Ppu.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxv
 * JD-Core Version:    0.7.0.1
 */