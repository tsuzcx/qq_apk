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
public final class rnb
  extends also
{
  rnb(roq paramroq, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.jdField_a_of_type_Roq.e.setTextColor(-16578534);
    this.jdField_a_of_type_Roq.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16578534);
    paramAnimator = this.jdField_a_of_type_Roq.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.a;
        if ((paramAnimator != null) && (paramAnimator.a == true)) {
          rpt.a((View)this.jdField_a_of_type_Roq.jdField_f_of_type_AndroidWidgetImageView, 0, (int)200L);
        }
      }
    }
    for (;;)
    {
      rpt.a((View)this.jdField_a_of_type_Roq.c, 8, (int)200L);
      rpt.a((View)this.jdField_a_of_type_Roq.d, 0, (int)200L);
      rpt.a((View)this.jdField_a_of_type_Roq.g, 0, (int)200L);
      rpt.a((View)this.jdField_a_of_type_Roq.h, 0, (int)200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      paramAnimator = this.jdField_a_of_type_Roq.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setVisibility(0);
      paramAnimator = this.jdField_a_of_type_Roq.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleX(0.0F);
      paramAnimator = this.jdField_a_of_type_Roq.i;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleY(0.0F);
      this.jdField_a_of_type_Roq.i.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnb
 * JD-Core Version:    0.7.0.1
 */