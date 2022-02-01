import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class rbe
  implements View.OnClickListener
{
  rbe(raw paramraw) {}
  
  public final void onClick(View paramView)
  {
    raw.a(this.a, raw.a(this.a) ^ true);
    if (raw.a(this.a)) {
      if (raw.a(this.a).a()) {
        raw.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849439, 0, 0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      raw.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849440, 0, 0, 0);
      continue;
      if (raw.a(this.a).a()) {
        raw.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849445, 0, 0, 0);
      } else {
        raw.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849446, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbe
 * JD-Core Version:    0.7.0.1
 */