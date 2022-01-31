import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class mlj
  implements ViewTreeObserver.OnPreDrawListener
{
  public mlj(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onPreDraw()
  {
    this.a.o = PoiMapActivity.e(this.a).getMeasuredHeight();
    PoiMapActivity.a(this.a, PoiMapActivity.a(this.a).getMeasuredHeight());
    if ((this.a.o > 0) && (PoiMapActivity.a(this.a) > 0))
    {
      this.a.a((this.a.o - PoiMapActivity.b(this.a)) / 2 + this.a.u, false);
      PoiMapActivity.f(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlj
 * JD-Core Version:    0.7.0.1
 */