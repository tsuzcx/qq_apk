import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$1"}, k=3, mv={1, 1, 16})
final class sgp
  implements ValueAnimator.AnimatorUpdateListener
{
  sgp(sgk paramsgk, swr paramswr) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject1 = this.jdField_a_of_type_Swr.b();
    if (localObject1 != null) {}
    for (localObject1 = ((TextView)localObject1).getLayoutParams();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject1 == null) {
        return;
      }
      Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = this.jdField_a_of_type_Swr.b();
    if (paramValueAnimator != null) {
      paramValueAnimator.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgp
 * JD-Core Version:    0.7.0.1
 */