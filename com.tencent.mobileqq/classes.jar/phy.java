import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "OnClick"}, k=3, mv={1, 1, 16})
final class phy
  implements bkzq
{
  phy(phs paramphs, Ref.ObjectRef paramObjectRef, Ref.BooleanRef paramBooleanRef, bkzi parambkzi) {}
  
  public final void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    pdv localpdv = (pdv)this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element;
    paramView = phs.a(this.jdField_a_of_type_Phs).a;
    if (paramView != null) {}
    for (paramView = paramView.commentId;; paramView = null)
    {
      localpdv.b(paramView, this.jdField_a_of_type_KotlinJvmInternalRef$BooleanRef.element);
      phs.a(this.jdField_a_of_type_Phs, 6);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phy
 * JD-Core Version:    0.7.0.1
 */