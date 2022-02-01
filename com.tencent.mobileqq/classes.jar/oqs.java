import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class oqs
  implements ViewBase.OnClickListener
{
  oqs(otd paramotd, otp paramotp) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_Otd;
    if (paramViewBase == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter");
    }
    ((orv)paramViewBase).a(this.jdField_a_of_type_Otp, oqy.a(this.jdField_a_of_type_Otp, 1), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqs
 * JD-Core Version:    0.7.0.1
 */