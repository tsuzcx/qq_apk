import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "OnClick"}, k=3, mv={1, 1, 16})
final class peu
  implements bkhw
{
  peu(peq parampeq, Ref.ObjectRef paramObjectRef, bkho parambkho) {}
  
  public final void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bkho.dismiss();
      return;
    }
    pbe localpbe = (pbe)this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element;
    paramView = peq.a(this.jdField_a_of_type_Peq).a;
    if (paramView != null) {}
    for (paramView = paramView.commentId;; paramView = null)
    {
      localpbe.c(paramView);
      peq.a(this.jdField_a_of_type_Peq, 8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     peu
 * JD-Core Version:    0.7.0.1
 */