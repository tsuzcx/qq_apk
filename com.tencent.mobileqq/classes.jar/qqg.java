import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qqg
  implements View.OnClickListener
{
  qqg(qqa paramqqa) {}
  
  public final void onClick(View paramView)
  {
    qqa.a(this.a).a().invoke(Boolean.valueOf(false), Boolean.valueOf(qqa.a(this.a)), Integer.valueOf(3));
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqg
 * JD-Core Version:    0.7.0.1
 */