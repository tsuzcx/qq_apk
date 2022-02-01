import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qyk
  implements View.OnClickListener
{
  qyk(qye paramqye) {}
  
  public final void onClick(View paramView)
  {
    qye.a(this.a, 0);
    Object localObject = qye.a(this.a);
    if (localObject != null) {
      ((View)localObject).setBackgroundDrawable(null);
    }
    localObject = qye.b(this.a);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130841764);
    }
    if (qye.a(this.a))
    {
      localObject = qye.a(this.a);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable((Drawable)qye.a(this.a, "https://kd.qpic.cn/bankjiang/apngs/one_cake_apng_ee6293e7.png"));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyk
 * JD-Core Version:    0.7.0.1
 */