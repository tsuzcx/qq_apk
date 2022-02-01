import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/push/mvp/RIJPushNotifyDialog$initCallback$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qou
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(@Nullable View paramView)
  {
    pkp.a().a(qor.a(this.a));
  }
  
  public void onViewDetachedFromWindow(@Nullable View paramView)
  {
    pkp.a().b(qor.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qou
 * JD-Core Version:    0.7.0.1
 */