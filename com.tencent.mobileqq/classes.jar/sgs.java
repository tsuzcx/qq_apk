import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$1$2", "Lcom/tencent/mobileqq/activity/richmedia/AnimatorAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sgs
  extends alob
{
  sgs(swr paramswr, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_Swr.b();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_Swr.c();
    if (paramAnimator != null) {
      paramAnimator.setTextColor(-16578534);
    }
    paramAnimator = this.jdField_a_of_type_Swr.a;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.a;
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.a;
        if ((paramAnimator != null) && (paramAnimator.a == true)) {
          six.a((View)this.jdField_a_of_type_Swr.c(), 0, (int)200L);
        }
      }
    }
    for (;;)
    {
      six.a((View)this.jdField_a_of_type_Swr.b(), 8, (int)200L);
      six.a((View)this.jdField_a_of_type_Swr.c(), 0, (int)200L);
      six.a((View)this.jdField_a_of_type_Swr.d(), 0, (int)200L);
      six.a((View)this.jdField_a_of_type_Swr.e(), 0, (int)200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      paramAnimator = this.jdField_a_of_type_Swr.f();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = this.jdField_a_of_type_Swr.f();
      if (paramAnimator != null) {
        paramAnimator.setScaleX(0.0F);
      }
      paramAnimator = this.jdField_a_of_type_Swr.f();
      if (paramAnimator != null) {
        paramAnimator.setScaleY(0.0F);
      }
      paramAnimator = this.jdField_a_of_type_Swr.f();
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.animate();
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.scaleX(1.0F);
          if (paramAnimator != null)
          {
            paramAnimator = paramAnimator.scaleY(1.0F);
            if (paramAnimator != null)
            {
              paramAnimator = paramAnimator.setDuration(200L);
              if (paramAnimator != null) {
                paramAnimator.start();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgs
 * JD-Core Version:    0.7.0.1
 */