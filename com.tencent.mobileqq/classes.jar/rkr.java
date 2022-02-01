import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class rkr
  implements View.OnClickListener
{
  rkr(rkk paramrkk) {}
  
  public final void onClick(View paramView)
  {
    rkk.a(this.a, 1);
    Object localObject = rkk.b(this.a);
    if (localObject != null) {
      ((View)localObject).setBackgroundDrawable(null);
    }
    localObject = rkk.a(this.a);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130841774);
    }
    if (rkk.a(this.a))
    {
      localObject = rkk.b(this.a);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable((Drawable)rkk.a(this.a, "https://kd.qpic.cn/bankjiang/apngs/three_cack_apng_7b412611.png"));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkr
 * JD-Core Version:    0.7.0.1
 */