import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qqi
  implements View.OnClickListener
{
  qqi(qqa paramqqa) {}
  
  public final void onClick(View paramView)
  {
    qqa.a(this.a, qqa.a(this.a) ^ true);
    if (qqa.a(this.a)) {
      if (qqa.a(this.a).a()) {
        qqa.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849416, 0, 0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      qqa.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849417, 0, 0, 0);
      continue;
      if (qqa.a(this.a).a()) {
        qqa.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849422, 0, 0, 0);
      } else {
        qqa.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849423, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqi
 * JD-Core Version:    0.7.0.1
 */