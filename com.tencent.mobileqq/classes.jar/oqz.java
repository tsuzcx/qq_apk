import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

final class oqz
  implements ViewFactory.FoundClickableViewListener
{
  oqz(Container paramContainer, otd paramotd, otp paramotp) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    opc.a.a(i, localSparseArray).a(i, localSparseArray).a(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Otd, this.jdField_a_of_type_Otp, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqz
 * JD-Core Version:    0.7.0.1
 */