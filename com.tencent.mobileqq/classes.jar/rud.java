import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$1$2", "Lcom/tencent/mobileqq/activity/richmedia/AnimatorAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rud
  extends akqf
{
  rud(rvs paramrvs, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.jdField_a_of_type_Rvs.e.setTextColor(-16578534);
    this.jdField_a_of_type_Rvs.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16578534);
    paramAnimator = this.jdField_a_of_type_Rvs.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.a;
        if ((paramAnimator != null) && (paramAnimator.a == true)) {
          rwv.a((View)this.jdField_a_of_type_Rvs.jdField_f_of_type_AndroidWidgetImageView, 0, (int)200L);
        }
      }
    }
    for (;;)
    {
      rwv.a((View)this.jdField_a_of_type_Rvs.b, 8, (int)200L);
      rwv.a((View)this.jdField_a_of_type_Rvs.d, 0, (int)200L);
      rwv.a((View)this.jdField_a_of_type_Rvs.g, 0, (int)200L);
      rwv.a((View)this.jdField_a_of_type_Rvs.h, 0, (int)200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      paramAnimator = this.jdField_a_of_type_Rvs.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setVisibility(0);
      paramAnimator = this.jdField_a_of_type_Rvs.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleX(0.0F);
      paramAnimator = this.jdField_a_of_type_Rvs.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleY(0.0F);
      this.jdField_a_of_type_Rvs.i.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rud
 * JD-Core Version:    0.7.0.1
 */