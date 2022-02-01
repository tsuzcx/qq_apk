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
public final class rwf
  extends algw
{
  rwf(rxv paramrxv, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    this.jdField_a_of_type_Rxv.f.setTextColor(-16578534);
    this.jdField_a_of_type_Rxv.g.setTextColor(-16578534);
    paramAnimator = this.jdField_a_of_type_Rxv.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.a;
        if ((paramAnimator != null) && (paramAnimator.a == true)) {
          ryx.a((View)this.jdField_a_of_type_Rxv.jdField_h_of_type_AndroidWidgetImageView, 0, (int)200L);
        }
      }
    }
    for (;;)
    {
      ryx.a((View)this.jdField_a_of_type_Rxv.c, 8, (int)200L);
      ryx.a((View)this.jdField_a_of_type_Rxv.d, 0, (int)200L);
      ryx.a((View)this.jdField_a_of_type_Rxv.jdField_h_of_type_AndroidWidgetTextView, 0, (int)200L);
      ryx.a((View)this.jdField_a_of_type_Rxv.i, 0, (int)200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      paramAnimator = this.jdField_a_of_type_Rxv.j;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setVisibility(0);
      paramAnimator = this.jdField_a_of_type_Rxv.j;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleX(0.0F);
      paramAnimator = this.jdField_a_of_type_Rxv.j;
      Intrinsics.checkExpressionValueIsNotNull(paramAnimator, "videoHolder.columnBannerSubscribeBtn");
      paramAnimator.setScaleY(0.0F);
      this.jdField_a_of_type_Rxv.j.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwf
 * JD-Core Version:    0.7.0.1
 */