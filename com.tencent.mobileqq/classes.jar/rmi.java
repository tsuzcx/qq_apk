import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordJumpDialog$dismiss$1", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rmi
  extends bkxp
{
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    try
    {
      this.a.a().removeView(this.a.a());
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.d("RIJWatchWordJumpDialog", 2, QLog.getStackTraceString((Throwable)paramAnimation));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmi
 * JD-Core Version:    0.7.0.1
 */