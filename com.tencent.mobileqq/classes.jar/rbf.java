import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.playAnimation.1.onAnimationEnd.1;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/push/mvp/RIJPushNotifyDialog$playAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rbf
  implements Animation.AnimationListener
{
  rbf(Function0 paramFunction0) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new RIJPushNotifyDialog.playAnimation.1.onAnimationEnd.1(this), 30L);
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbf
 * JD-Core Version:    0.7.0.1
 */