import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate$onDianZanClick$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class swo
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if ((this.a.jdField_a_of_type_Slr.a() == swn.a(this.a)) && (this.a.jdField_a_of_type_Shl.a != null)) {
      this.a.jdField_a_of_type_Shl.a.a(swn.a(this.a));
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    Object localObject;
    if (swn.a(this.a).a != null)
    {
      localObject = swn.a(this.a).a;
      if (localObject == null) {
        break label142;
      }
      localObject = ((skq)localObject).a;
      if (localObject != null)
      {
        localObject = swn.a(this.a).a;
        if (localObject == null) {
          break label147;
        }
        localObject = ((skq)localObject).a;
        if ((localObject == null) || (((VideoInfo)localObject).r != true)) {
          break label147;
        }
      }
    }
    for (;;)
    {
      if (swn.a(this.a).m != null)
      {
        localObject = swn.a(this.a).m;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(this.a.jdField_a_of_type_Shl.a(this.a.a(bool)));
        }
      }
      paramAnimation.setInterpolator((Interpolator)new AnticipateInterpolator());
      return;
      label142:
      localObject = null;
      break;
      label147:
      bool = false;
    }
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swo
 * JD-Core Version:    0.7.0.1
 */