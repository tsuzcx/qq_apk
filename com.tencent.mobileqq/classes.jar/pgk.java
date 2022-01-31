import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;

class pgk
  implements ViewBase.OnClickListener
{
  pgk(pgh parampgh, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = BaseApplicationImpl.getContext();
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (paramViewBase != null)) {
      if (paramViewBase.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i == 0) && (pcb.a() == 1) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext() instanceof Activity))) {
        pgh.a(this.jdField_a_of_type_Pgh, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext());
      }
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */