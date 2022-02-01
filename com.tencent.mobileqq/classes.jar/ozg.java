import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ozg
  implements ViewBase.OnClickListener
{
  ozg(pcf parampcf, pdp parampdp) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "viewBase");
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    bfxp.a((Activity)this.jdField_a_of_type_Pcf.a(), 0, localArrayList, true, "", 1888);
    if (this.jdField_a_of_type_Pcf.a() != null) {
      this.jdField_a_of_type_Pcf.a().f(this.jdField_a_of_type_Pdp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozg
 * JD-Core Version:    0.7.0.1
 */