import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.widget.RatingBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mvi
  implements View.OnClickListener
{
  public mvi(RatingBar paramRatingBar) {}
  
  public void onClick(View paramView)
  {
    if (RatingBar.a(this.a))
    {
      RatingBar.a(this.a, this.a.indexOfChild(paramView) + 1);
      this.a.setStar(RatingBar.a(this.a), true);
      if (RatingBar.a(this.a) != null) {
        RatingBar.a(this.a).a(RatingBar.a(this.a), RatingBar.a(this.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvi
 * JD-Core Version:    0.7.0.1
 */