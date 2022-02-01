import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

final class ory
  implements ViewFactory.FoundClickableViewListener
{
  ory(Container paramContainer, ouc paramouc, ouo paramouo) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    oqo.a.a(i, localSparseArray).a(i, localSparseArray).a(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Ouc, this.jdField_a_of_type_Ouo, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ory
 * JD-Core Version:    0.7.0.1
 */