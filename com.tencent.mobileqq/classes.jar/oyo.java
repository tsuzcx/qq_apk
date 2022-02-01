import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class oyo
  implements ViewFactory.FoundClickableViewListener
{
  oyo(int paramInt, Container paramContainer, ppu paramppu, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, ProteusItemView paramProteusItemView, aoof paramaoof, sel paramsel) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    pye localpye = (pye)oyj.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localpye != null) && (localpye.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Ppu, paramViewBase))) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null));
      i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtil", 2, "configListener viewID : " + paramViewBase.getViewId() + ", cmd : " + i + ",, event : " + paramViewBase.getClickEvnet());
      }
    } while (!oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, i, paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
    paramViewBase.setOnClickListener(new oyp(this, i, paramViewBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */