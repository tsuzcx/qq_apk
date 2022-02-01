import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

final class oyl
  implements ViewFactory.FoundClickableViewListener
{
  oyl(Container paramContainer, pan parampan, pay parampay) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    owo.a.a(i, localSparseArray).a(i, localSparseArray).a(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_Pan, this.jdField_a_of_type_Pay, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyl
 * JD-Core Version:    0.7.0.1
 */