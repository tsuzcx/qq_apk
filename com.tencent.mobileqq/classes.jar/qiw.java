import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qiw
  implements View.OnClickListener
{
  qiw(qio paramqio) {}
  
  public final void onClick(View paramView)
  {
    qio.a(this.a, qio.a(this.a) ^ true);
    if (qio.a(this.a)) {
      if (qio.a(this.a).a()) {
        qio.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849435, 0, 0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      qio.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849436, 0, 0, 0);
      continue;
      if (qio.a(this.a).a()) {
        qio.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849441, 0, 0, 0);
      } else {
        qio.a(this.a).setCompoundDrawablesWithIntrinsicBounds(2130849442, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qiw
 * JD-Core Version:    0.7.0.1
 */