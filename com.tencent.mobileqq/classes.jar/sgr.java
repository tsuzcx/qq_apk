import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$1$1"}, k=3, mv={1, 1, 16})
final class sgr
  implements ValueAnimator.AnimatorUpdateListener
{
  sgr(swr paramswr, ValueAnimator paramValueAnimator) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.jdField_a_of_type_Swr.b();
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if (paramValueAnimator == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator).intValue();
      }
    }
    paramValueAnimator = this.jdField_a_of_type_Swr.b();
    if (paramValueAnimator != null) {
      paramValueAnimator.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgr
 * JD-Core Version:    0.7.0.1
 */