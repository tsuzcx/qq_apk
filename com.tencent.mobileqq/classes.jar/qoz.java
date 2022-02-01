import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qoz
  implements View.OnClickListener
{
  qoz(qor paramqor) {}
  
  public final void onClick(View paramView)
  {
    qor.a(this.a, qor.a(this.a) ^ true);
    if (qor.a(this.a)) {
      if (qor.a(this.a).a()) {
        qor.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849347, 0, 0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      qor.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849348, 0, 0, 0);
      continue;
      if (qor.a(this.a).a()) {
        qor.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849353, 0, 0, 0);
      } else {
        qor.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849354, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoz
 * JD-Core Version:    0.7.0.1
 */