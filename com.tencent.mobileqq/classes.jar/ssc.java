import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.startGuideAnimate.1;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$startGuideAnimate$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ssc
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    if (srv.a(this.a.this$0)) {
      return;
    }
    if (srv.a(this.a.this$0) >= 1)
    {
      srv.a(this.a.this$0);
      return;
    }
    paramAnimator = this.a.this$0;
    srv.a(paramAnimator, srv.a(paramAnimator) + 1);
    srv.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssc
 * JD-Core Version:    0.7.0.1
 */