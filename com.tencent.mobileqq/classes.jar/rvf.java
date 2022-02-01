import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "value", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class rvf
  implements ValueAnimator.AnimatorUpdateListener
{
  rvf(ruz paramruz) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    VideoFeedsStressFollowLayout localVideoFeedsStressFollowLayout = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "value");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    localVideoFeedsStressFollowLayout.a(((Float)paramValueAnimator).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvf
 * JD-Core Version:    0.7.0.1
 */