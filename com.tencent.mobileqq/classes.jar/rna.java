import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$1$1"}, k=3, mv={1, 1, 16})
final class rna
  implements ValueAnimator.AnimatorUpdateListener
{
  rna(roq paramroq, ValueAnimator paramValueAnimator) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.jdField_a_of_type_Roq.j;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBanner");
    localObject = ((ViewGroup)localObject).getLayoutParams();
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator).intValue();
    this.jdField_a_of_type_Roq.j.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */